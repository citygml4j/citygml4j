package org.citygml4j.impl.gml.valueObjects;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.ArrayAssociationImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.valueObjects.Value;
import org.citygml4j.model.gml.valueObjects.ValueArrayProperty;

public class ValueArrayPropertyImpl extends ArrayAssociationImpl<Value> implements ValueArrayProperty {
	
	public GMLClass getGMLClass() {
		return GMLClass.VALUE_ARRAY_PROPERTY;
	}

	public List<Value> getValue() {
		return super.getObject();
	}

	public boolean isSetValue() {
		return super.isSetObject();
	}

	public void setValue(List<Value> value) {
		super.setObject(value);
	}

	public void addValue(Value value) {
		super.addObject(value);
	}

	public void unsetValue() {
		super.unsetObject();
	}

	public boolean unsetValue(Value value) {
		return super.unsetObject(value);
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ValueArrayProperty copy = (target == null) ? new ValueArrayPropertyImpl() : (ValueArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ValueArrayPropertyImpl(), copyBuilder);
	}

}
