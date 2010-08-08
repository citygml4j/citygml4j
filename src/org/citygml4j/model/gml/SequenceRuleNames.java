package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.builder.copy.Copyable;

public enum SequenceRuleNames implements GML, Copyable {
	LINEAR("Linear"),
    BOUSTROPHEDONIC("Boustrophedonic"),
    CANTOR_DIAGONAL("Cantor-diagonal"),
    SPIRAL("Spiral"),
    MORTON("Morton"),
    HILBERT("Hilbert");

	private final String value;

	SequenceRuleNames(String v) {
		value = v;
	}

	public String getValue() {
		return value;
	}

	public GMLClass getGMLClass() {
		return GMLClass.SEQUENCERULENAMES;
	}

	public static SequenceRuleNames fromValue(String v) {
		v = v.trim();

		for (SequenceRuleNames c: SequenceRuleNames.values())
			if (c.value.equals(v))
				return c;

		return LINEAR;
	}

	public String toString() {
		return value;
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		return (target == null) ? LINEAR : this;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return this;
	}

}
