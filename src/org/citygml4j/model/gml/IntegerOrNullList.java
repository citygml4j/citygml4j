package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface IntegerOrNullList extends GML, Child, Copyable {
	public List<IntegerOrNull> getIntegerOrNull();
	public boolean isSetIntegerOrNull();
	
	public void setIntegerOrNull(List<IntegerOrNull> integerOrNull);
	public void addIntegerOrNull(IntegerOrNull IntegerOrNull);
	public void unsetIntegerOrNull();
	public boolean unsetIntegerOrNull(IntegerOrNull integerOrNull);
}
