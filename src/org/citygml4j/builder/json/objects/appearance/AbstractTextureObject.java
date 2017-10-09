package org.citygml4j.builder.json.objects.appearance;

public abstract class AbstractTextureObject {
	private transient String theme;
	
	public abstract void addNull();
	public abstract int size();
	
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
