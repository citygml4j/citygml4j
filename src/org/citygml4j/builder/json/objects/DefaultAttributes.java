package org.citygml4j.builder.json.objects;

import com.google.gson.annotations.SerializedName;

public class DefaultAttributes extends AbstractAttributes {
	@SerializedName("class")
	private String clazz;
	private String function;
	private String usage;
	
	public boolean isSetClazz() {
		return clazz != null;
	}
	
	public String getClazz() {
		return clazz;
	}
	
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	
	public boolean isSetFunction() {
		return function != null;
	}
	
	public String getFunction() {
		return function;
	}
	
	public void setFunction(String function) {
		this.function = function;
	}
	
	public boolean isSetUsage() {
		return usage != null;
	}
	
	public String getUsage() {
		return usage;
	}
	
	public void setUsage(String usage) {
		this.usage = usage;
	}
	
	public boolean hasAttributes() {
		return super.hasAttributes()
				|| clazz != null
				|| function!= null
				|| usage != null;
	}
		
}
