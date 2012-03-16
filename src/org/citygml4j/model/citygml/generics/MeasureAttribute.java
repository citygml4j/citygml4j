package org.citygml4j.model.citygml.generics;

import org.citygml4j.model.gml.basicTypes.Measure;

public interface MeasureAttribute extends AbstractGenericAttribute {
	public Measure getValue();
	public boolean isSetValue();
	
	public void setValue(Measure value);
	public void unsetValue();
}
