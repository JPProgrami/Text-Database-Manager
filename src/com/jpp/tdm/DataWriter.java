package com.jpp.tdm;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jpp.tdm.common.EntryType;
import com.jpp.tdm.common.FileStructure;
import com.jpp.tdm.data.Column;
import com.jpp.tdm.data.DataSet;
import com.jpp.tdm.data.Row;
import com.jpp.tdm.data.Table;
import com.jpp.tdm.data.Type;
/**
 *
 * @author JP Programi
 * &lt;c&gt; 2021-2026.
 *
 *
 */
public class DataWriter
{
	private String path;
	File f;
	FileStructure file_structure;
	boolean softwarecreated=false;
	public DataWriter(String path,FileStructure fs,boolean softwarecreated) throws Exception
	{
		f = new File(path);
		this.setPath(path);
		this.file_structure=fs;
		this.softwarecreated=softwarecreated;

	}
	public DataWriter(String path) throws Exception
	{
		f = new File(path);
		this.softwarecreated=true;
		this.setPath(path);
		this.file_structure=null;

	}

	public void Commit(DataSet set) throws Exception
	{

		FileWriter mywriter = new FileWriter(f);
		List<String> linestowrite = new ArrayList<>();
		if(!softwarecreated)
		{
			for(Integer name: this.file_structure.Text.keySet())
			{
				linestowrite.add(this.file_structure.Text.get(name));
			}
			Collections.reverse(linestowrite);
			for (Table table : set.Tables) {
				if(table.isHasBeenChanged())
				{
					for(int j=0;j<table.getRows().size();j++)
					{
						Row r = table.getRows().get(j);
						if(r.isHasBeenChanged())
						{
							int row_index_in_text = this.file_structure.getEntryKeyByData(j+"|"+table.getName(),EntryType.Row);
							if(r.isMarkForDelete())
							{
								linestowrite.remove(row_index_in_text);
							}
							else
							{
								String temp="VALUES(";
								for(Object obj : r.getData())
								{
									if(table.getColumns().get(r.getData().indexOf(obj)).getType()==Type.String)
									{
										temp+="\""+obj+"\"";
									}
									else
									{
										temp+=obj;
									}
									if(obj!=r.getData().get(r.getData().size()-1))
									{
										temp+=",";
									}
								}
								temp+=")";
								linestowrite.set(row_index_in_text,temp);
							}
						}
						else if(r.isNew())
						{
							String temp="VALUES(";
							for(Object obj : r.getData())
							{
								if(table.getColumns().get(r.getData().indexOf(obj)).getType()==Type.String)
								{
									temp+="\""+obj+"\"";
								}
								else
								{
									temp+=obj;
								}
								if(obj!=r.getData().get(r.getData().size()-1))
								{
									temp+=",";
								}
							}
							temp+=")";
							linestowrite.add(temp);

						}
					}
				}
			}
		}
		else
		{
			linestowrite.add("//FILE CREATED BY DATAWRITER");
			linestowrite.add("//DATE : ");
			linestowrite.add("OBJECT \""+set.Name+"\"");
			for(Table t : set.getTables())
			{
				linestowrite.add("TABLE \""+t.getName()+"\"");
				linestowrite.add("COLUMNS");
				for(Column c : t.getColumns())
				{
					String type="";
					switch(c.getType())
					{
						case Int:
							type="INT";
						break;
						case Bool:
							type="BOOL";
							break;
						case Float:
							type="FLOAT";
							break;
						case Double:
							type="DOUBLE";
							break;
						case String:
							type="STRING";
							break;
						case Date:
							type="DATE";
							break;
						default:
							type="STRING";
							break;
					}
					linestowrite.add(c.getName()+" AS "+type);
				}
				linestowrite.add("ROWS");
				for(Row r : t.getRows())
				{
					String row = "VALUES(";
					for(Object obj : r.getData())
					{

						row+=obj;
						if(obj!=r.getData().get(r.getData().size()-1))
						{
							row+=",";
						}
					}
					row+=")";
					linestowrite.add(row);
				}

			}


		}
		for(String name : linestowrite)
		{
			mywriter.write(name+"\n");
		}
		mywriter.close();
		this.softwarecreated=false;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}





}
