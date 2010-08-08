package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface ValueArrayProperty extends GML, Child, Copyable {
	public List<Value> getValue();
	public boolean isSetValue();

	public void setValue(List<Value> value);
	public void addValue(Value value);
	public void unsetValue();
	public boolean unsetValue(Value value);
}
