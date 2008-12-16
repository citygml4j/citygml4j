package org.citygml4j.model.citygml.generics;

public interface GenericStringAttribute extends GenericAttribute {
	public String getValue();
	public boolean isSetValue();
	
	public void setValue(String value);
	public void unsetValue();
}
