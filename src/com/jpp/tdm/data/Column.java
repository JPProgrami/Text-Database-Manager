package com.jpp.tdm.data;

public class Column
{
	Type type;
	String name;
	Boolean isKey;
	public Column(Type type, String name) {
		super();
		this.type = type;
		this.name = name;
	}
	public Column(Type type, String name, Boolean iskey) {
		super();
		this.type = type;
		this.name = name;
		this.isKey=iskey;
	}
	public Column(String name,Type type) {
		super();
		this.type = type;
		this.name = name;
	}
	public Column(String name,Type type,Boolean iskey) {
		super();
		this.type = type;
		this.name = name;
		this.isKey = iskey;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
