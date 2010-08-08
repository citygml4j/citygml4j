package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.builder.copy.Copyable;

public enum FileValueModel implements GML, Copyable {
	RECORD_INTERLEAVED("Record Interleaved");

	private final String value;

	FileValueModel(String v) {
		value = v;
	}

	public String getValue() {
		return value;
	}

	public GMLClass getGMLClass() {
		return GMLClass.FILEVALUEMODEL;
	}

	public static FileValueModel fromValue(String v) {
		v = v.trim();

		for (FileValueModel c: FileValueModel.values())
			if (c.value.equals(v))
				return c;

		return RECORD_INTERLEAVED;
	}

	public String toString() {
		return value;
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		return (target == null) ? RECORD_INTERLEAVED : this;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return this;
	}

}
