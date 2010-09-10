package org.citygml4j.model.citygml.generics;

public interface StringAttribute extends AbstractGenericAttribute {
	public String getValue();
	public boolean isSetValue();
	
	public void setValue(String value);
	public void unsetValue();
}
