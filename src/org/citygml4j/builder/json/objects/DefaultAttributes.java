package org.citygml4j.builder.json.objects;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class DefaultAttributes extends AbstractAttributes {
	private Date creationDate;
	private Date terminationDate;
	@SerializedName("class")
	private String clazz;
	private String function;
	private String usage;
	
	public boolean isSetCreationDate() {
		return creationDate != null;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public boolean isSetTerminationDate() {
		return terminationDate != null;
	}
	
	public Date getTerminationDate() {
		return terminationDate;
	}
	
	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}
	
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
		
}
