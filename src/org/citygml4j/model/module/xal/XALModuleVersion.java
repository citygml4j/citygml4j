package org.citygml4j.model.module.xal;

import org.citygml4j.model.module.ModuleVersion;

public enum XALModuleVersion implements ModuleVersion {
	v2_0("2.0");
	
	private final String value;
	
	XALModuleVersion(String value) {
		this.value = value;
	}
		
	public String toString() {
		return value;
	}
	
}
