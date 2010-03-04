package org.citygml4j.model.module.gml;

import org.citygml4j.model.module.ModuleType;

public enum GMLModuleType implements ModuleType {
	CORE("GML Core"),
	XLINK("XLink");

	private final String value;

	GMLModuleType(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}

}
