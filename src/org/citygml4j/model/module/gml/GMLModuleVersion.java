package org.citygml4j.model.module.gml;

import org.citygml4j.model.module.ModuleVersion;

public enum GMLModuleVersion implements ModuleVersion {
	v3_1_1("3.1.1");
	
	private final String value;
	
	GMLModuleVersion(String value) {
		this.value = value;
	}
		
	public String toString() {
		return value;
	}

	public GMLModuleVersion getVersion() {
		return this;
	}
	
}
