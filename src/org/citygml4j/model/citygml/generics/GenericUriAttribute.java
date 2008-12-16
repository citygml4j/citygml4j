package org.citygml4j.model.citygml.generics;

public interface GenericUriAttribute extends GenericAttribute {
	public String getValue();
	public boolean isSetValue();
	
	public void setValue(String value);
	public void unsetValue();
}
