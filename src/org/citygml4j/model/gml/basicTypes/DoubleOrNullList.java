package org.citygml4j.model.gml.basicTypes;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.model.gml.GML;


public interface DoubleOrNullList extends GML, Child, Copyable {
	public List<DoubleOrNull> getDoubleOrNull();
	public boolean isSetDoubleOrNull();
	
	public void setDoubleOrNull(List<DoubleOrNull> doubleOrNull);
	public void addDoubleOrNull(DoubleOrNull DoubleOrNull);
	public void unsetDoubleOrNull();
	public boolean unsetDoubleOrNull(DoubleOrNull doubleOrNull);
}
