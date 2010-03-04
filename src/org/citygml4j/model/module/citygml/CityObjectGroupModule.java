package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.module.Module;

public class CityObjectGroupModule extends AbstractCityGMLModule {
	private static final List<CityObjectGroupModule> instances = new ArrayList<CityObjectGroupModule>();

	public static final CityObjectGroupModule v1_0_0;
	public static final CityObjectGroupModule v0_4_0;

	private CityObjectGroupModule (
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
		v1_0_0 = new CityObjectGroupModule (
				CityGMLModuleType.CITYOBJECTGROUP,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/cityobjectgroup/1.0",
				"grp",
				"http://schemas.opengis.net/citygml/cityobjectgroup/1.0/cityObjectGroup.xsd",			
				CoreModule.v1_0_0);

		v0_4_0 = new CityObjectGroupModule (
				CityGMLModuleType.CITYOBJECTGROUP,
				CoreModule.v0_4_0.getVersion(),
				CoreModule.v0_4_0.getNamespaceURI(),
				CoreModule.v0_4_0.getNamespacePrefix(),
				CoreModule.v0_4_0.getSchemaLocation(),		
				CoreModule.v0_4_0);
		
		v1_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v1_0_0.elementMap.put("CityObjectGroup", CityObjectGroup.class);
		v0_4_0.elementMap = v1_0_0.elementMap;
		
		v1_0_0.propertySet = new HashSet<String>();
		v1_0_0.propertySet.add("groupMember");
		v1_0_0.propertySet.add("parent");
		v0_4_0.propertySet = v1_0_0.propertySet;
	}

	public static List<CityObjectGroupModule> getInstances() {
		return instances;
	}

}
