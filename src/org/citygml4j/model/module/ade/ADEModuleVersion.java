package org.citygml4j.model.module.ade;

import org.citygml4j.model.module.ModuleVersion;

public class ADEModuleVersion implements ModuleVersion {
	private final String value;
	
	public ADEModuleVersion(String value) {
		this.value = value != null ? value : "undefined";
	}
	
	protected ADEModuleVersion() {
		this("undefined");
	}

	public String getValue() {
		return value;
	}
	
}