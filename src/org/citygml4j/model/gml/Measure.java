package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface Measure extends GML, Child, Copyable {
	public double getValue();
	public String getUom();
	public boolean isSetValue();
	public boolean isSetUom();
	
	public void setValue(double value);
	public void setUom(String uom);
}
