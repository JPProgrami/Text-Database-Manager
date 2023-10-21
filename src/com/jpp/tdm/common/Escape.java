package com.jpp.tdm.common;

public class Escape
{

	public static String symbol(String symbol)
	{
		String ret="";
		switch(symbol)
		{
		case " ":
			ret="SPACE$";
			break;
		case "\n":
			ret="NEWLINE$";
			break;
		case "\t":
			ret="TAB$";
			break;
		case ")":
			ret="RIGHTBRACKET$";
			break;
		case "(":
			ret="LEFTBRACKET$";
			break;
		case "\"":
			ret="QUOTE$";
			break;
		}
		return ret;
	}

	public static String unescape(String escape)
	{
		String ret="";
		switch(escape)
		{
		case "SPACE$":
			ret=" ";
			break;
		case "NEWLINE$":
			ret="\n";
			break;
		case "TAB$":
			ret="\t";
			break;
		case "RIGHTBRACKET$":
			ret=")";
			break;
		case "LEFTBRACKET$":
			ret="(";
			break;
		case "QUOTE$":
			ret="\"";
			break;
		}
		return ret;
	}

}
