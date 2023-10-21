package com.jpp.tdm.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class FileStructure
{
	public Hashtable<Integer,String> Text;
	public Hashtable<Integer,Entry> Kywds;
	String path;

	public FileStructure(String path)
	{
		Text = new Hashtable<>();
		Kywds = new Hashtable<>();
		this.path=path;
	}

	public Entry getEntryByData(String Value, EntryType type)
	{
		for (Integer name: this.Kywds.keySet())
		{
			if(this.Kywds.get(name).getData().equals(Value) && this.Kywds.get(name).type==type)
			{
				return this.Kywds.get(name);
			}
		}
		return null;
	}
	public Integer getEntryKeyByData(String Value, EntryType type)
	{
		for (Integer name: this.Kywds.keySet())
		{
			if(this.Kywds.get(name).Data.equals(Value) && this.Kywds.get(name).type==type)
			{
				return name;
			}
		}
		return -1;
	}
	public void Load() throws Exception
	{
		File F = new File(path);

		InputStream is = new FileInputStream(F);
		BufferedReader myreader = new BufferedReader(new InputStreamReader(is));
		String line;
		int lncount=1;
		while((line = myreader.readLine()) != null)
		{
			Text.put(lncount, line);
			lncount++;


		}
		myreader.close();
	}

}
