package com.jpp.tdm.data;

import java.util.ArrayList;
import java.util.List;

public class Table
{
	List<Column> Columns;
	List<Row> Rows;
	String Name;

	boolean HasBeenChanged;
	public boolean isHasBeenChanged()
	{
		return HasBeenChanged;
	}
	public void setHasBeenChanged(boolean hasBeenChanged) {
		HasBeenChanged = hasBeenChanged;
	}
	public Table() {
		super();
		// TODO Auto-generated constructor stub
		Columns = new ArrayList<>();
		Rows = new ArrayList<>();
	}
	public Table(List<Column> columns, List<Row> rows,String name) {
		super();
		Columns = columns;
		Rows = rows;
		Name = name;
	}
	public List<Column> getColumns() {
		return Columns;
	}
	public void setColumns(List<Column> columns) {
		Columns = columns;
	}
	public List<Row> getRows() {
		return Rows;
	}
	public void setRows(List<Row> rows) {
		Rows = rows;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public void print_table(boolean printname)
	{
		if(printname)
		{
			System.out.println(this.Name);
		}
		//System.out.print("\t");
		for (Column column : Columns) {
			System.out.print(column.name+"\t");
		}
		System.out.println();
		for (Row row : Rows) {
			for(int j=0;j<row.Data.size();j++)
			{
				System.out.print(row.getData().get(j)+"\t");
			}
			System.out.println();
		}
	}
	public Column getColumnByName(String Colname)
	{
		for(Column c : this.Columns)
		{
			if(c.name.equals(Colname))
			{
				return c;
			}
		}
		return null;
	}

	public int getColumnIndex(String Colname)
	{
		for(int i=0;i<this.Columns.size();i++)
		{
			if(this.Columns.get(i).getName().equals(Colname))
			{
				return i;
			}
		}
		return -1;
	}

}
