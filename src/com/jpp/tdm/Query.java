package com.jpp.tdm;

import java.util.ArrayList;
import java.util.List;

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
public class Query
{
	public DataSet set;

	public DataSet getSet() {
		return set;
	}

	public void setSet(DataSet set) {
		this.set = set;
	}

	public Query(DataSet s)
	{
		this.set=s;
	}

	/**
	 * Compares two objects of given types.
	 * @param obj1 Left object.
	 * @param t1 Type of left object.
	 * @param obj2 Right object.
	 * @param t2 Type of right object.
	 * @return 0 if equal,<br/>-1 if left object is greater than right object,<br/>&nbsp;1 if vice-versa, <br/>-2 if different, but not applicable,<br/>-3 if error.
	 */
	public static int Compare(Object obj1, Type t1, Object obj2, Type t2)
	{
		if(t1==Type.Int)
		{
			if(t2==Type.Int)
			{
				if((Integer)obj1==(Integer)obj2)
				{
					return 0;
				}
				else if((Integer)obj1>(Integer)obj2)
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
			else if(t2==Type.Double)
			{
				if(((Integer)obj1).doubleValue()==(Double)obj2)
				{
					return 0;
				}
				else if(((Integer)obj1).doubleValue()>(Double)obj2)
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
			else if(t2==Type.Float)
			{
				if(((Integer)obj1).floatValue()==(Float)obj2)
				{
					return 0;
				}
				else if(((Integer)obj1).floatValue()>(Float)obj2)
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
			else if(t2==Type.String)
			{
				if(((Integer)obj1).toString()==(String)obj2)
				{
					return 0;
				}
				else
				{
					return -2;
				}
			}
			else if(t2==Type.Bool)
			{
				if((((Integer)obj1)==1 && (Boolean)obj2==true) || (((Integer)obj1)!=1 && !((Boolean)obj2)))
				{
					return 0;
				}
				else
				{
					return -2;
				}
			}
			else if(t2==Type.Date)
			{

			}
		}
		else if(t1==Type.Double)
		{
			if(t2==Type.Int)
			{
				if(((Double)obj1).intValue()==(Integer)obj2)
				{
					return 0;
				}
				else if(((Double)obj1).intValue()>(Integer)obj2)
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
			else if(t2==Type.Double)
			{
				if((Double)obj1==(Double)obj2)
				{
					return 0;
				}
				else if((Double)obj1>(Double)obj2)
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
			else if(t2==Type.Float)
			{
				if(((Double)obj1).floatValue()==(Float)obj2)
				{
					return 0;
				}
				else if(((Double)obj1).floatValue()>(Float)obj2)
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
			else if(t2==Type.String)
			{
				if(((Double)obj1).toString()==(String)obj2)
				{
					return 0;
				}
				else
				{
					return -2;
				}
			}
			else if(t2==Type.Bool)
			{
				if((((Double)obj1)==1 && (Boolean)obj2==true) || (((Double)obj1)!=1 && !((Boolean)obj2)))
				{
					return 0;
				}
				else
				{
					return -2;
				}
			}
		}
		else if(t1==Type.Float)
		{
			if(t2==Type.Int)
			{
				if(((Float)obj1).intValue()==(Integer)obj2)
				{
					return 0;
				}
				else if(((Float)obj1).intValue()>(Integer)obj2)
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
			else if(t2==Type.Double)
			{
				if(((Float)obj1).doubleValue()==(Double)obj2)
				{
					return 0;
				}
				else if(((Float)obj1).doubleValue()>(Double)obj2)
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
			else if(t2==Type.Float)
			{
				if((Float)obj1==(Float)obj2)
				{
					return 0;
				}
				else if((Float)obj1>(Float)obj2)
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
			else if(t2==Type.String)
			{
				if(((Float)obj1).toString()==(String)obj2)
				{
					return 0;
				}
				else
				{
					return -2;
				}
			}
			else if(t2==Type.Bool)
			{
				if((((Float)obj1)==1 && (Boolean)obj2==true) || (((Float)obj1)!=1 && !((Boolean)obj2)))
				{
					return 0;
				}
				else
				{
					return -2;
				}
			}
		}
		else if(t1==Type.String)
		{
			if(t2==Type.Int)
			{
				if((String)obj1==((Integer)obj2).toString())
				{
					return 0;
				}
				else
				{
					return -2;
				}
			}
			else if(t2==Type.Double)
			{
				if((String)obj1==((Double)obj2).toString())
				{
					return 0;
				}
				else
				{
					return -2;
				}
			}
			else if(t2==Type.Float)
			{
				if((String)obj1==((Float)obj2).toString())
				{
					return 0;
				}
				else
				{
					return -2;
				}
			}
			else if(t2==Type.String)
			{
				if((String)obj1==(String)obj2)
				{
					return 0;
				}
				else
				{
					return -2;
				}
			}
			else if(t2==Type.Bool)
			{
				if((((String)obj1).toUpperCase().equals("TRUE") && (Boolean)obj2==true) || (((String)obj1).toUpperCase().equals("FALSE") && !((Boolean)obj2)))
				{
					return 0;
				}
				else
				{
					return -2;
				}
			}
		}
		else if(t1==Type.Bool)
		{
			if(t2==Type.Bool)
			{
				if((Boolean)obj1==(Boolean)obj2)
				{
					return 0;
				}
				else
				{
					return -2;
				}
			}
			else if(t2==Type.Int)
			{
				if((((Integer)obj2)==1 && (Boolean)obj1==true) || (((Integer)obj2)!=1 && !((Boolean)obj1)))
				{
					return 0;
				}
				else
				{
					return -2;
				}
			}
			else if(t2==Type.Float)
			{
				if((((Double)obj2)==1 && (Boolean)obj1==true) || (((Double)obj2)!=1 && !((Boolean)obj1)))
				{
					return 0;
				}
				else
				{
					return -2;
				}
			}
			else if(t2==Type.Double)
			{

				if((((Float)obj2)==1 && (Boolean)obj1==true) || (((Float)obj2)!=1 && !((Boolean)obj1)))
				{
					return 0;
				}
				else
				{
					return -2;
				}
			}
			else if(t2==Type.String)
			{



				if((((String)obj2).toUpperCase().equals("TRUE") && (Boolean)obj1==true) || (((String)obj2).toUpperCase().equals("FALSE") && !((Boolean)obj1)))
				{
					return 0;
				}
				else
				{
					return -2;
				}
			}
		}
		else if(t1==Type.Date)
		{

		}
		return -3;
	}

	/**
	 * Retrieves a row whose values match the given ones as an AND function. A combination of retrieves can be used to simulate an OR function.
	 * @param Table Table to retrieve from.
	 * @param ColumnsToRetrieve Columns to retrieve.
	 * @param ConditionColumns Columns which need to have conditional values.
	 * @param ConditionValues Conditional values.
	 * @return Table
	 */
	public Table Retrieve(String Table,String[] ColumnsToRetrieve,String[] ConditionColumns, Object[] ConditionValues)
	{
		Table ret_table = new Table();
		ret_table.setName("Retname");
		List<Column> rettablecolumns = new ArrayList<>();
		List<Row> ret = new ArrayList<>();
		Table t = this.set.getTableByName(Table);
		boolean y=true;
		for(String name : ColumnsToRetrieve)
		{
			rettablecolumns.add(t.getColumnByName(name));
		}
		ret_table.setColumns(rettablecolumns);

		for(Row r : t.getRows())
		{
			for(int i=0;i<ConditionColumns.length;i++)
			{
				 Column c = t.getColumnByName(ConditionColumns[i]);
				 int col_index = t.getColumns().indexOf(c);
				 Object c_val = r.getData().get(col_index);
				 if(!((String)c_val).equals(ConditionValues[i]))
				 {
					 y=false;
					 break;
				 }
			}
			if(y)
			{
				Row retrow = new Row();
				for (String element : ColumnsToRetrieve) {

					Column c = t.getColumnByName(element);
					int col_index = t.getColumns().indexOf(c);
					retrow.getData().add(r.getData().get(col_index));
				}
				ret.add(retrow);
			}
			y=true;
		}

		ret_table.setRows(ret);
		return ret_table;
	}

	/**
	 * Updates one data field whose row matches the given conditions.
	 * @param Table Table to update.
	 * @param ConditionColumns Columns which need to have conditional values
	 * @param ConditionValues Conditional values.
	 * @param UpdateColumn Column to update.
	 * @param NewValue New value.
	 */
	public void UpdateOne(String Table,String[] ConditionColumns, Object[] ConditionValues,String UpdateColumn,String NewValue)
	{
		Table t = this.set.getTableByName(Table);
		boolean y = true;
		for(int row_index=0;row_index<t.getRows().size();row_index++)
		{
			for(int i=0;i<ConditionColumns.length;i++)
			{
				 Column c = t.getColumnByName(ConditionColumns[i]);
				 int col_index = t.getColumns().indexOf(c);
				 Object c_val = t.getRows().get(row_index).getData().get(col_index);
				 if(!((String)c_val).equals(ConditionValues[i]))
				 {
					 y=false;
					 break;
				 }
			}
			if(y)
			{
				Column c = t.getColumnByName(UpdateColumn);
				int col_index = t.getColumns().indexOf(c);
				t.getRows().get(row_index).getData().set(col_index, NewValue);
				t.getRows().get(row_index).setHasBeenChanged(true);
				t.setHasBeenChanged(true);
			}
			y=true;
		}
	}

	/**
	 * Updates more data fields whose row matches the given conditions.
	 * @param Table Table to update.
	 * @param ConditionColumns Columns which need to have conditional values
	 * @param ConditionValues Conditional values.
	 * @param UpdateColumns Columns to update.
	 * @param NewValues New values.
	 */
	public void UpdateMore(String Table,String[] ConditionColumns, Object[] ConditionValues,String[] UpdateColumns,String[] NewValues)
	{
		Table t = this.set.getTableByName(Table);
		boolean y = true;
		for(int row_index=0;row_index<t.getRows().size();row_index++)
		{
			for(int i=0;i<ConditionColumns.length;i++)
			{
				 Column c = t.getColumnByName(ConditionColumns[i]);
				 int col_index = t.getColumns().indexOf(c);
				 Object c_val = t.getRows().get(row_index).getData().get(col_index);
				 if(!((String)c_val).equals(ConditionValues[i]))
				 {
					 y=false;
					 break;
				 }
			}
			if(y)
			{
				t.setHasBeenChanged(true);
				for(int i=0;i<UpdateColumns.length;i++)
				{
					Column c = t.getColumnByName(UpdateColumns[i]);
					int col_index = t.getColumns().indexOf(c);
					t.getRows().get(row_index).getData().set(col_index, NewValues[i]);
					t.getRows().get(row_index).setHasBeenChanged(true);

				}
			}
			y=true;
		}
	}

	/**
	 * Inserts a new value into a table.
	 * @param Table Table to insert into.
	 * @param NewColumns Columns to insert into.
	 * @param NewValues Values to insert.
	 * @throws Exception Exception.
	 */
	public void Insert(String Table,String[] NewColumns, String[] NewValues) throws Exception
	{
		Table t = this.set.getTableByName(Table);
		int tableindex = this.set.getTableIndexByName(Table);
		List<Integer> col_indices = new ArrayList<>();
		for(String name:NewColumns)
		{
			Column c = t.getColumnByName(name);
			if(c==null)
			{
				throw new Exception("No such column '"+name+"'");
			}
			else
			{
				col_indices.add(t.getColumns().indexOf(c));
			}
		}
		Row newrow = new Row();
		for(int i=0;i<t.getColumns().size();i++)
		{
			newrow.getData().add("");
		}
		for(int i=0;i<NewValues.length;i++)
		{
			newrow.getData().set(col_indices.get(i), NewValues[i]);
		}
		newrow.setIsNew(true);
		t.getRows().add(newrow);
		t.setHasBeenChanged(true);
		this.set.getTables()[tableindex] = t;

	}

	/**
	 * Marks a row for delete whose data matches the condition.
	 * @param Table Table to delete from.
	 * @param ConditionColumns
	 * @param ConditionValues
	 */
	public void Delete(String Table,String[] ConditionColumns, Object[] ConditionValues)
	{
		Table t = this.set.getTableByName(Table);
		boolean y = true;
		for(int row_index=0;row_index<t.getRows().size();row_index++)
		{
			for(int i=0;i<ConditionColumns.length;i++)
			{
				 Column c = t.getColumnByName(ConditionColumns[i]);
				 int col_index = t.getColumns().indexOf(c);
				 Object c_val = t.getRows().get(row_index).getData().get(col_index);
				 if(!((String)c_val).equals(ConditionValues[i]))
				 {
					 y=false;
					 break;
				 }
			}
			if(y)
			{
				//t.getRows().remove(row_index);
				t.getRows().get(row_index).setMarkForDelete(true);
				t.setHasBeenChanged(true);
			}
			y=true;
		}
	}

	public void parsecommand(String comm) throws Exception
	{

	}


}
