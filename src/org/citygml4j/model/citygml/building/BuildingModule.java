package org.citygml4j.model.citygml.building;

import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.CityGMLModuleDependencies;
import org.citygml4j.model.citygml.CityGMLModuleType;
import org.citygml4j.model.citygml.CityGMLModuleVersion;
import org.citygml4j.model.citygml.core.CoreModule;

public enum BuildingModule implements CityGMLModule {
	v0_4_0(CoreModule.v0_4_0) {
		public String getNamespaceUri() { return "http://www.citygml.org/citygml/1/0/0"; }
		public String getNamespacePrefix() { return "citygml"; }
		public String getSchemaLocation() { return "http://www.citygml.org/citygml/0/4/0/CityGML.xsd"; }
		public CityGMLModuleVersion getModuleVersion() { return CityGMLModuleVersion.v0_4_0; }
	},
	v1_0_0(CoreModule.v1_0_0) {
		public String getNamespaceUri() { return "http://www.opengis.net/citygml/building/1.0"; }
		public String getNamespacePrefix() { return "bldg"; }
		public String getSchemaLocation() { return "http://schemas.opengis.net/citygml/building/1.0/building.xsd"; }
		public CityGMLModuleVersion getModuleVersion() { return CityGMLModuleVersion.v1_0_0; }
	};
	
	private final CityGMLModuleDependencies dependencies;
	
	BuildingModule(CityGMLModule... dependencies) {
		this.dependencies = new CityGMLModuleDependencies(dependencies);
	}
	
	public abstract String getNamespaceUri();
	
	public abstract String getNamespacePrefix();
	
	public abstract String getSchemaLocation();
	
	public abstract CityGMLModuleVersion getModuleVersion();
	
	public CityGMLModuleType getModuleType() {
		return CityGMLModuleType.BUILDING;
	}
	
	public CityGMLModuleDependencies getModuleDependencies() {
		return dependencies;
	}
}
