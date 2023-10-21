package com.jpp.tdm.common;

public class StringEdit
{

	public static String CutoffL(String text, int index)
	{
		String ret = "";
		for(int i=index+1;i<text.length();i++)
		{
				ret+=text.charAt(i);
		}
		return ret;
	}

	public static String CutoffR(String text, int index)
	{
		String ret = "";
		for(int i=0;i<index;i++)
		{
				ret+=text.charAt(i);
		}
		return ret;
	}

	public static String BetweenQuotes (String text) throws Exception
	{
		String ret="";
		boolean quotes=false;
		for(int i=0;i<text.length();i++)
		{
			if(text.charAt(i)=='\"')
			{
				quotes=!quotes;
				continue;
			}
			if(quotes)
			{
				ret+=text.charAt(i);
			}
		}
		if(quotes)
		{
			throw new Exception("Illegal string format!");
		}
		return ret;

	}
}
