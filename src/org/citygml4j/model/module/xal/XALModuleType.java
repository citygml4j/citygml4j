package org.citygml4j.model.module.xal;

import org.citygml4j.model.module.ModuleType;

public enum XALModuleType implements ModuleType {
	CORE("xAL Core");

	private final String value;

	XALModuleType(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}

}
