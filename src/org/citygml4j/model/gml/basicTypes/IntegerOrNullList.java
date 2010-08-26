package org.citygml4j.model.gml.basicTypes;

import java.util.List;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;


public interface IntegerOrNullList extends GML, Child, Copyable {
	public List<IntegerOrNull> getIntegerOrNull();
	public boolean isSetIntegerOrNull();
	
	public void setIntegerOrNull(List<IntegerOrNull> integerOrNull);
	public void addIntegerOrNull(IntegerOrNull IntegerOrNull);
	public void unsetIntegerOrNull();
	public boolean unsetIntegerOrNull(IntegerOrNull integerOrNull);
}
