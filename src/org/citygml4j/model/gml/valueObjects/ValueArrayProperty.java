package org.citygml4j.model.gml.valueObjects;

import java.util.List;

import org.citygml4j.model.gml.base.ArrayAssociation;

public interface ValueArrayProperty extends ArrayAssociation<Value> {
	public List<Value> getValue();
	public boolean isSetValue();

	public void setValue(List<Value> value);
	public void addValue(Value value);
	public void unsetValue();
	public boolean unsetValue(Value value);
}
