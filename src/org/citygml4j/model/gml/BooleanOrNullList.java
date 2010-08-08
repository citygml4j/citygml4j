package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface BooleanOrNullList extends GML, Child, Copyable {
	public List<BooleanOrNull> getBooleanOrNull();
	public boolean isSetBooleanOrNull();
	
	public void setBooleanOrNull(List<BooleanOrNull> booleanOrNull);
	public void addBooleanOrNull(BooleanOrNull booleanOrNull);
	public void unsetBooleanOrNull();
	public boolean unsetBooleanOrNull(BooleanOrNull booleanOrNull);
}
