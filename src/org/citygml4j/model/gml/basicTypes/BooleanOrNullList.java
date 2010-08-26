package org.citygml4j.model.gml.basicTypes;

import java.util.List;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;


public interface BooleanOrNullList extends GML, Child, Copyable {
	public List<BooleanOrNull> getBooleanOrNull();
	public boolean isSetBooleanOrNull();
	
	public void setBooleanOrNull(List<BooleanOrNull> booleanOrNull);
	public void addBooleanOrNull(BooleanOrNull booleanOrNull);
	public void unsetBooleanOrNull();
	public boolean unsetBooleanOrNull(BooleanOrNull booleanOrNull);
}
