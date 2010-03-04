package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.module.Module;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.model.module.xal.XALCoreModule;

public class CoreModule extends AbstractCityGMLModule {
	private static final List<CoreModule> instances = new ArrayList<CoreModule>();

	public static final CoreModule v1_0_0;
	public static final CoreModule v0_4_0;

	private CoreModule (
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
		v1_0_0 = new CoreModule (
				CityGMLModuleType.CORE,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/1.0",
				"core",
				"http://schemas.opengis.net/citygml/1.0/cityGMLBase.xsd", 
				GMLCoreModule.v3_1_1, XALCoreModule.v2_0);			

		v0_4_0 = new CoreModule (
				CityGMLModuleType.CORE,
				CityGMLModuleVersion.v0_4_0,
				"http://www.citygml.org/citygml/1/0/0",
				"citygml",
				"http://www.citygml.org/citygml/0/4/0/CityGML.xsd",
				GMLCoreModule.v3_1_1, XALCoreModule.v2_0);
		
		v1_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v1_0_0.elementMap.put("CityModel", CityModel.class);
		v1_0_0.elementMap.put("Address", Address.class);
		v0_4_0.elementMap = v1_0_0.elementMap;
		
		v1_0_0.propertySet = new HashSet<String>();
		v1_0_0.propertySet.add("cityObjectMember");
		v1_0_0.propertySet.add("generalizesTo");
		v0_4_0.propertySet = v1_0_0.propertySet;
	}

	public static List<CoreModule> getInstances() {
		return instances;
	}

}
