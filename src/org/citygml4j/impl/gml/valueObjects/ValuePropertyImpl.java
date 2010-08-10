package org.citygml4j.impl.gml.valueObjects;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.AssociationByRepOrRefImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.valueObjects.Value;
import org.citygml4j.model.gml.valueObjects.ValueProperty;

public class ValuePropertyImpl extends AssociationByRepOrRefImpl<Value> implements ValueProperty {

	public Value getValue() {
		return super.getObject();
	}

	public boolean isSetValue() {
		return super.isSetObject();
	}

	public void setValue(Value value) {
		super.setObject(value);
	}

	public void unsetValue() {
		super.unsetObject();
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.VALUE_PROPERTY;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ValueProperty copy = (target == null) ? new ValuePropertyImpl() : (ValueProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ValuePropertyImpl(), copyBuilder);
	}

}
