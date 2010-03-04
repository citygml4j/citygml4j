package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.module.Module;

public class VegetationModule extends AbstractCityGMLModule {
	private static final List<VegetationModule> instances = new ArrayList<VegetationModule>();

	public static final VegetationModule v1_0_0;
	public static final VegetationModule v0_4_0;

	private VegetationModule (
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
		v1_0_0 = new VegetationModule (
				CityGMLModuleType.VEGETATION,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/vegetation/1.0",
				"veg",
				"http://schemas.opengis.net/citygml/vegetation/1.0/vegetation.xsd",			
				CoreModule.v1_0_0);

		v0_4_0 = new VegetationModule (
				CityGMLModuleType.VEGETATION,
				CoreModule.v0_4_0.getVersion(),
				CoreModule.v0_4_0.getNamespaceURI(),
				CoreModule.v0_4_0.getNamespacePrefix(),
				CoreModule.v0_4_0.getSchemaLocation(),		
				CoreModule.v0_4_0);
		
		v1_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v1_0_0.elementMap.put("SolitaryVegetationObject", SolitaryVegetationObject.class);
		v1_0_0.elementMap.put("PlantCover", PlantCover.class);
		v0_4_0.elementMap = v1_0_0.elementMap;
	}

	public static List<VegetationModule> getInstances() {
		return instances;
	}

}
