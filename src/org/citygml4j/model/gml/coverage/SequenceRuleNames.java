package org.citygml4j.model.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

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
	
	public GMLClass getGMLClass() {
		return GMLClass.SEQUENCE_RULE_NAMES;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		return (target == null) ? LINEAR : this;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return this;
	}

}
