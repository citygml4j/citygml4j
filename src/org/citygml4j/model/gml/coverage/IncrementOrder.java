package org.citygml4j.model.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

public enum IncrementOrder implements GML, Copyable {
	PLUS_X_PLUS_Y("+x+y"),
    PLUS_Y_PLUS_X("+y+x"),
    PLUS_X_MINUS_Y("+x-y"),
    MINUS_X_MINUS_Y("-x-y");

	private final String value;

	IncrementOrder(String v) {
		value = v;
	}

	public String getValue() {
		return value;
	}

	public static IncrementOrder fromValue(String v) {
		v = v.trim();

		for (IncrementOrder c: IncrementOrder.values())
			if (c.value.equals(v))
				return c;

		return PLUS_X_PLUS_Y;
	}

	public String toString() {
		return value;
	}
	
	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.INCREMENT_ORDER;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		return (target == null) ? PLUS_X_PLUS_Y : this;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return this;
	}

}
