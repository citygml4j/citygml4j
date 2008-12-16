package org.citygml4j.model.citygml;

public interface CityGMLModule {
	public CityGMLModuleType getModuleType();
	public CityGMLModuleVersion getModuleVersion();
	public String getNamespaceUri();
	public String getNamespacePrefix();
	public String getSchemaLocation();
}
