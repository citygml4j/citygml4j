package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.module.Module;

public class GenericsModule extends AbstractCityGMLModule {
	private static final List<GenericsModule> instances = new ArrayList<GenericsModule>();

	public static final GenericsModule v1_0_0;
	public static final GenericsModule v0_4_0;

	private GenericsModule (
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
		v1_0_0 = new GenericsModule (
				CityGMLModuleType.GENERICS,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/generics/1.0",
				"gen",
				"http://schemas.opengis.net/citygml/generics/1.0/generics.xsd",			
				CoreModule.v1_0_0);

		v0_4_0 = new GenericsModule (
				CityGMLModuleType.GENERICS,
				CoreModule.v0_4_0.getVersion(),
				CoreModule.v0_4_0.getNamespaceURI(),
				CoreModule.v0_4_0.getNamespacePrefix(),
				CoreModule.v0_4_0.getSchemaLocation(),		
				CoreModule.v0_4_0);
		
		v1_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v1_0_0.elementMap.put("GenericCityObject", GenericCityObject.class);
		v0_4_0.elementMap = v1_0_0.elementMap;
	}

	public static List<GenericsModule> getInstances() {
		return instances;
	}

}
