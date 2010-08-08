package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface ValueProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public Value getValue();
	public boolean isSetValue();
	
	public void setValue(Value value);
	public void unsetValue();
}
