package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.module.Module;

public class LandUseModule extends AbstractCityGMLModule {
	private static final List<LandUseModule> instances = new ArrayList<LandUseModule>();

	public static final LandUseModule v1_0_0;
	public static final LandUseModule v0_4_0;

	private LandUseModule (
			CityGMLModuleType type, 
			CityGMLModuleVersion version,
			String namespaceURI, 
			String namespacePrefix, 
			String schemaLocation,
			Module... dependencies) {
		super(type, version, namespaceURI, namespacePrefix, schemaLocation, dependencies);		
		instances.add(this);
	}

	static {
		v1_0_0 = new LandUseModule (
				CityGMLModuleType.LAND_USE,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/landuse/1.0",
				"luse",
				"http://schemas.opengis.net/citygml/landuse/1.0/landUse.xsd",			
				CoreModule.v1_0_0);

		v0_4_0 = new LandUseModule (
				CityGMLModuleType.LAND_USE,
				CoreModule.v0_4_0.getVersion(),
				CoreModule.v0_4_0.getNamespaceURI(),
				CoreModule.v0_4_0.getNamespacePrefix(),
				CoreModule.v0_4_0.getSchemaLocation(),		
				CoreModule.v0_4_0);
		
		v1_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v1_0_0.elementMap.put("LandUse", LandUse.class);
		v0_4_0.elementMap = v1_0_0.elementMap;
	}

	public static List<LandUseModule> getInstances() {
		return instances;
	}

}
