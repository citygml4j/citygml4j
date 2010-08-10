package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.module.Module;

public class CityFurnitureModule extends AbstractCityGMLModule {
	private static final List<CityFurnitureModule> instances = new ArrayList<CityFurnitureModule>();

	public static final CityFurnitureModule v1_0_0;
	public static final CityFurnitureModule v0_4_0;

	private CityFurnitureModule (
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
		v1_0_0 = new CityFurnitureModule (
				CityGMLModuleType.CITY_FURNITURE,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/cityfurniture/1.0",
				"frn",
				"http://schemas.opengis.net/citygml/cityfurniture/1.0/cityFurniture.xsd",			
				CoreModule.v1_0_0);

		v0_4_0 = new CityFurnitureModule (
				CityGMLModuleType.CITY_FURNITURE,
				CoreModule.v0_4_0.getVersion(),
				CoreModule.v0_4_0.getNamespaceURI(),
				CoreModule.v0_4_0.getNamespacePrefix(),
				CoreModule.v0_4_0.getSchemaLocation(),		
				CoreModule.v0_4_0);
		
		v1_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v1_0_0.elementMap.put("CityFurniture", CityFurniture.class);
		v0_4_0.elementMap = v1_0_0.elementMap;
	}

	public static List<CityFurnitureModule> getInstances() {
		return instances;
	}

}
