package com.jpp.tdm;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.jpp.tdm.common.Entry;
import com.jpp.tdm.common.EntryType;
import com.jpp.tdm.common.FileStructure;
import com.jpp.tdm.common.StringEdit;
import com.jpp.tdm.data.Column;
import com.jpp.tdm.data.DataSet;
import com.jpp.tdm.data.Row;
import com.jpp.tdm.data.Table;
import com.jpp.tdm.data.Type;

public class DataReader
{
	private String path;
	public FileStructure FileStructure;

	/**
	 * Creates a new DataReader on the specified path.
	 * @param path Path to file.
	 * @throws Exception Exception.
	 */
	public DataReader(String path) throws Exception{

		if(!new File(path).exists())
		{
			throw new Exception("No file found at path '"+path+"'");
		}
		this.path=path;

	}
	/**
	 * Fills a DataSet with data read from a file.
	 * @param set DataSet to fill.
	 * @return DataSet.
	 * @throws Exception Exception.
	 */
	public DataSet Fill(DataSet set) throws Exception
	{
		int tableindex = -1;
		int linecounter = 0;
		boolean beginreadingcolumns = false;
		boolean beginreadingrows = false;
		boolean objectdefined = false;
		boolean multilinecomment=false;
		List<Table> tables = new ArrayList<>();
		List<String> l = new ArrayList<>();
		File F = new File(path);
		FileStructure=new FileStructure(path);
		InputStream is = new FileInputStream(F);
		BufferedReader myreader = new BufferedReader(new InputStreamReader(is));
		String line;
		while((line = myreader.readLine()) != null)
		{
			l.add(line);
			FileStructure.Text.put(linecounter, line);
			linecounter++;
		}
		myreader.close();
		set.Path=path;
		linecounter=0;
		int rowcounter=0;
		for(String name : l)
		{

			String[] commx = name.split(" ");
			if(name.isBlank() || name.isEmpty())
			{
				linecounter++;
				if(multilinecomment)
				{
					FileStructure.Kywds.put(linecounter, new Entry(EntryType.MultiLineComment,""+linecounter));
				}
				continue;
			}
			if(name.length()>=2)
			{

				if(name.charAt(0)=='/' && name.charAt(1)=='/' && !multilinecomment)
				{
					FileStructure.Kywds.put(linecounter, new Entry(EntryType.Comment,""+linecounter));
					linecounter++;
					continue;
				}
				else if(name.charAt(0)=='/' && name.charAt(1)=='*' && !multilinecomment)
				{
					FileStructure.Kywds.put(linecounter, new Entry(EntryType.MultiLineComment,""+linecounter));
					multilinecomment=true;
					linecounter++;
					continue;
				}
				else if(name.charAt(name.length()-2)=='*' && name.charAt(name.length()-1)=='/' && multilinecomment)
				{
					FileStructure.Kywds.put(linecounter, new Entry(EntryType.MultiLineComment,""+linecounter));
					multilinecomment=false;
					linecounter++;
					continue;
				}
			}
			if(multilinecomment)
			{
				FileStructure.Kywds.put(linecounter, new Entry(EntryType.MultiLineComment,""+linecounter));
				linecounter++;
				continue;
			}

			if(commx[0].equals("OBJECT"))
			{
				if(objectdefined)
				{
					throw new Exception("Error: Only one object allowed per file!");
				}
				String temp="";
				temp = StringEdit.CutoffL(name, name.indexOf('\"')-1);
				temp = StringEdit.BetweenQuotes(temp);
				set.setName(temp.trim());
				FileStructure.Kywds.put(linecounter,new Entry(EntryType.Object,temp.trim()));
			}
			else if(commx[0].equals("TABLE"))
			{
				rowcounter=0;
				tableindex++;
				tables.add(new Table());
				String temp="";
//				boolean quote=false;
				temp = StringEdit.CutoffL(name, name.indexOf('\"')-1);
				temp = StringEdit.BetweenQuotes(temp);
				tables.get(tableindex).setName(temp.trim());
				FileStructure.Kywds.put(linecounter,new Entry(EntryType.Table,temp.trim()));
				beginreadingcolumns=false;
				beginreadingrows=false;
			}
			else if(commx[0].equals("COLUMNS") && !beginreadingcolumns)
			{
				beginreadingrows=false;
				beginreadingcolumns=true;
			}
			else if(name.contains(" AS ") && beginreadingcolumns)
			{
				String fname = commx[0];
				String ftype = commx[2];
				Type t = Type.fromstring(ftype);
				tables.get(tableindex).getColumns().add(new Column(fname,t));
			}
			else if(commx[0].equals("ROWS"))
			{
				beginreadingcolumns=false;
				beginreadingrows=true;
			}
			else if(beginreadingrows)
			{
				if(!name.contains("VALUES"))
				{
					break;
				}
				String vals = name;
				if(vals.indexOf('(') == -1 || vals.indexOf(')') == -1)
				{
					throw new Exception("Error: Illegal command VALUES.");
				}
				vals = StringEdit.CutoffL(vals, vals.indexOf('('));
				vals = StringEdit.CutoffR(vals, vals.indexOf(')'));

				String[] values = vals.split(",");
				if(values.length!=tables.get(tableindex).getColumns().size())
				{
					throw new Exception("Error: Cannot have more or less columns than defined.");
				}
				Row rw = new Row();
				List<Object> lista = new ArrayList<>();
				for(String t : values)
				{
					if(t.contains("\""))
					{
						t=StringEdit.BetweenQuotes(t);
					}
					lista.add(t);
				}
				rw.setData(lista);
				tables.get(tableindex).getRows().add(rw);
				FileStructure.Kywds.put(linecounter,new Entry(EntryType.Row,rowcounter+"|"+tables.get(tableindex).getName()));
				rowcounter++;
			}
			linecounter++;

		}
		Object[] objs = tables.toArray();
		Table[] tbls = new Table[objs.length];
		for(int i=0;i<objs.length;i++)
		{
			tbls[i] = (Table)objs[i];
		}
		set.setTables(tbls);
		return set;
	}

}
