package com.jpp.tdm.common;

public class Entry
{
	EntryType type;
	String Data;
	public EntryType getType() {
		return type;
	}
	public void setType(EntryType type) {
		this.type = type;
	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	public Entry() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Entry(EntryType type, String data) {
		super();
		this.type = type;
		Data = data;
	}



}
