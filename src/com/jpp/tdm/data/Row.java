package com.jpp.tdm.data;

import java.util.ArrayList;
import java.util.List;

public class Row
{

	List<Object> Data;
	boolean HasBeenChanged;
	boolean MarkForDelete;
	boolean IsNew;

	public boolean isNew() {
		return IsNew;
	}
	public void setIsNew(boolean isNew) {
		IsNew = isNew;
	}
	public boolean isHasBeenChanged() {
		return HasBeenChanged;
	}
	public void setHasBeenChanged(boolean hasBeenChanged) {
		HasBeenChanged = hasBeenChanged;
	}

	public boolean isMarkForDelete() {
		return MarkForDelete;
	}
	public void setMarkForDelete(boolean markForDelete) {
		MarkForDelete = markForDelete;
	}

	public Row()
	{
		Data = new ArrayList<>();
	}
	public Row(List<Object> data) {
		super();
		Data = data;
	}
	public List<Object> getData() {
		return Data;
	}
	public void setData(List<Object> lista) {
		Data = lista;
	}



}
