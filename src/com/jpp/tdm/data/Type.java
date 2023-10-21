package com.jpp.tdm.data;

public enum Type
{
	Int,
	Bool,
	Float,
	Double,
	String,
	NASCII,
	NUTF8,
	Date,
	UNUSED;
	public static Type fromstring(String str)
	{
		switch(str.toUpperCase())
		{
		case "INTEGER":
		case "INT":
			return Type.Int;
		case "BOOLEAN":
		case "BOOL":
			return  Type.Bool;
		case "FLOAT":
			return Type.Float;
		case "DOUBLE":
			return Type.Double;
		case "STRING":
			return Type.String;
		case "DATE":
			return Type.Date;
			default:
				return Type.UNUSED;
		}
	}
}
