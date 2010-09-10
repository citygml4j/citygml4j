package org.citygml4j.model.gml.basicTypes;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;


public interface Measure extends GML, Child, Copyable {
	public double getValue();
	public String getUom();
	public boolean isSetValue();
	public boolean isSetUom();
	
	public void setValue(double value);
	public void setUom(String uom);
}
