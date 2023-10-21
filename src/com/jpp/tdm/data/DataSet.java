package com.jpp.tdm.data;


public class DataSet
{

	public Table[] Tables;
	public String Name;
	public String Path;

	public Table[] getTables() {
		return Tables;
	}

	public void setTables(Table[] tables) {
		Tables = tables;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}

	public DataSet(Table[] tables, String name, String path) {
		super();
		Tables = tables;
		Name = name;
		Path = path;
	}

	public Table getTableByName(String name)
	{
		for(Table t: this.Tables)
		{
			if(t.getName().equals(name))
			{
				return t;
			}
		}
		return null;
	}
	public int getTableIndexByName(String name)
	{
		for(int i=0;i<this.Tables.length;i++)
		{
			if(this.Tables[i].getName().equals(name))
			{
				return i;
			}
		}
		return -1;
	}
	public DataSet()
	{

	}




}
