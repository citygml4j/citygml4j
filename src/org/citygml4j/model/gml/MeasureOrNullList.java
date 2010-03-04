package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface MeasureOrNullList extends GML, Child, Copyable {
	public String getUom();
	public List<DoubleOrNull> getDoubleOrNull();
	public boolean isSetDoubleOrNull();
	public boolean isSetUom();
	
	public void setUom(String uom);
	public void setDoubleOrNull(List<DoubleOrNull> doubleOrNull);
	public void addDoubleOrNull(DoubleOrNull doubleOrNull);
	public void unsetDoubleOrNull();
	public boolean unsetDoubleOrNull(DoubleOrNull doubleOrNull);
	public void unsetUom();
}
