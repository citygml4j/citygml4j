package org.citygml4j.model.module.citygml;

import org.citygml4j.model.module.ModuleVersion;

public enum CityGMLModuleVersion implements ModuleVersion {
	v1_0_0("1.0.0"),
	v0_4_0("0.4.0");
	
	private final String value;
	
	CityGMLModuleVersion(String value) {
		this.value = value;
	}
		
	public String toString() {
		return value;
	}

	public CityGMLModuleVersion getVersion() {
		return this;
	}
	
}
