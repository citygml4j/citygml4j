package org.citygml4j.model.citygml.waterbody;

import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.CityGMLModuleDependencies;
import org.citygml4j.model.citygml.CityGMLModuleType;
import org.citygml4j.model.citygml.CityGMLModuleVersion;
import org.citygml4j.model.citygml.core.CoreModule;

public enum WaterBodyModule implements CityGMLModule {
	v0_4_0(CoreModule.v0_4_0) {
		public String getNamespaceUri() { return "http://www.citygml.org/citygml/1/0/0"; }
		public String getNamespacePrefix() { return "citygml"; }
		public String getSchemaLocation() { return "http://www.citygml.org/citygml/0/4/0/CityGML.xsd"; }
		public CityGMLModuleVersion getModuleVersion() { return CityGMLModuleVersion.v0_4_0; }
	},
	v1_0_0(CoreModule.v1_0_0) {
		public String getNamespaceUri() { return "http://www.opengis.net/citygml/waterbody/1.0"; }
		public String getNamespacePrefix() { return "wtr"; }
		public String getSchemaLocation() { return "http://schemas.opengis.net/citygml/waterbody/1.0/waterBody.xsd"; }
		public CityGMLModuleVersion getModuleVersion() { return CityGMLModuleVersion.v1_0_0; }
	};
	
	private final CityGMLModuleDependencies dependencies;
	
	WaterBodyModule(CityGMLModule... dependencies) {
		this.dependencies = new CityGMLModuleDependencies(dependencies);
	}
	
	@Override
	public abstract String getNamespaceUri();
	@Override
	public abstract String getNamespacePrefix();
	@Override
	public abstract String getSchemaLocation();
	@Override
	public abstract CityGMLModuleVersion getModuleVersion();
	
	@Override
	public CityGMLModuleType getModuleType() {
		return CityGMLModuleType.WATERBODY;
	}
	
	@Override
	public CityGMLModuleDependencies getModuleDependencies() {
		return dependencies;
	}
}
