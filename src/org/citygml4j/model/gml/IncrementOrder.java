package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.builder.copy.Copyable;

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

	public GMLClass getGMLClass() {
		return GMLClass.INCREMENTORDER;
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
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		return (target == null) ? PLUS_X_PLUS_Y : this;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return this;
	}

}
