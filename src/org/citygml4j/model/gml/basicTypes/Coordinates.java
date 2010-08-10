package org.citygml4j.model.gml.basicTypes;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.model.gml.GML;


public interface Coordinates extends GML, Child, Copyable {
	public String getValue();
	public String getDecimal();
	public String getCs();
	public String getTs();
	public boolean isSetValue();
	public boolean isSetDecimal();
	public boolean isSetCs();
	public boolean isSetTs();
	
	public List<Double> toList3d();
	public List<Double> toList3d(boolean reverseOrder);
	
	public void setValue(String value);
	public void setDecimal(String decimal);
	public void setCs(String cs);
	public void setTs(String ts);
	public void unsetValue();
	public void unsetDecimal();
	public void unsetCs();
	public void unsetTs();
}
