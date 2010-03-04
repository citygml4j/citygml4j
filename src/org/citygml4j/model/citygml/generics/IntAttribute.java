package org.citygml4j.model.citygml.generics;

public interface IntAttribute extends GenericAttribute {
	public Integer getValue();
	public boolean isSetValue();
	
	public void setValue(Integer value);
	public void unsetValue();
}
