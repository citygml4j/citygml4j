package org.citygml4j.model.citygml.generics;

public interface UriAttribute extends AbstractGenericAttribute {
	public String getValue();
	public boolean isSetValue();
	
	public void setValue(String value);
	public void unsetValue();
}
