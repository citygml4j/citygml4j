package org.citygml4j.model.module.ade;

import org.citygml4j.model.module.ModuleType;

public class ADEModuleType implements ModuleType {
	private final String value;
	
	public ADEModuleType(String value) {
		this.value = value != null ? value : "undefined";
	}
	
	protected ADEModuleType() {
		this("undefined");
	}

	public String getValue() {
		return value;
	}
	
}