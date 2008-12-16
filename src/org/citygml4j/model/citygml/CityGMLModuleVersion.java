package org.citygml4j.model.citygml;

public enum CityGMLModuleVersion {
	v0_4_0("0.4.0"),
	v1_0_0("1.0.0");
	
	private final String value;
	
	CityGMLModuleVersion(String value) {
		this.value = value;
	}
		
	public String value() {
		return value;
	}
	
	public String toString() {
		return value;
	}
}
