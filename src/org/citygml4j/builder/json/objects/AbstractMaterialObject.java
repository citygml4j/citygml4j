package org.citygml4j.builder.json.objects;

public abstract class AbstractMaterialObject {
	private transient String theme;
	
	public abstract void addNull();
	public abstract int size();
	
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
	
}
