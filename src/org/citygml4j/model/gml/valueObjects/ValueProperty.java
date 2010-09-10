package org.citygml4j.model.gml.valueObjects;

import org.citygml4j.model.gml.base.AssociationByRepOrRef;

public interface ValueProperty extends AssociationByRepOrRef<Value> {
	public Value getValue();
	public boolean isSetValue();
	
	public void setValue(Value value);
	public void unsetValue();
}
