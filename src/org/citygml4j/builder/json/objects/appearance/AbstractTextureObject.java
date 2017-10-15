package org.citygml4j.builder.json.objects.appearance;

public abstract class AbstractTextureObject {
	private transient String theme;
	
	public abstract void addNullValue();
	public abstract int getNumValues();
	
	public AbstractTextureObject() {
	}
	
	public AbstractTextureObject(String theme) {
		this.theme = theme;
	}
	
	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
}
