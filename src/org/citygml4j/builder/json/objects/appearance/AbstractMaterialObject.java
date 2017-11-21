package org.citygml4j.builder.json.objects.appearance;

public abstract class AbstractMaterialObject {
	private transient String theme;
	private Integer value;
	
	public abstract boolean isSetValues();
	public abstract void addNullValue();
	public abstract int getNumValues();
	public abstract boolean collapseValues();
	public abstract void unsetValues();
	
	public AbstractMaterialObject() {
	}
	
	public AbstractMaterialObject(String theme) {
		this.theme = theme;
	}
	
	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	public boolean isSetValue() {
		return value != null;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void unsetValue() {
		value = null;
	}
	
}
