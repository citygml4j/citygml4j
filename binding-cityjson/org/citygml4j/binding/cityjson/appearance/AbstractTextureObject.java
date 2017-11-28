package org.citygml4j.binding.cityjson.appearance;

import java.util.List;

public abstract class AbstractTextureObject {
	protected transient String theme;
	
	public abstract boolean isSetValues();
	public abstract void addNullValue();
	public abstract int getNumValues();
	public abstract List<List<List<Integer>>> flatValues();
	
	protected AbstractTextureObject() {
	}
	
	public AbstractTextureObject(String theme) {
		this.theme = theme != null ? theme : "";
	}
	
	public String getTheme() {
		return theme;
	}
	
}
