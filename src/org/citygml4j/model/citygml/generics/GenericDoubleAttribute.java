package org.citygml4j.model.citygml.generics;

public interface GenericDoubleAttribute extends GenericAttribute {
	public Double getValue();
	public boolean isSetValue();
	
	public void setValue(Double value);
	public void unsetValue();
}
