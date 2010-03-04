package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.model.module.Module;

public class WaterBodyModule extends AbstractCityGMLModule {
	private static final List<WaterBodyModule> instances = new ArrayList<WaterBodyModule>();

	public static final WaterBodyModule v1_0_0;
	public static final WaterBodyModule v0_4_0;

	private WaterBodyModule (
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
		v1_0_0 = new WaterBodyModule (
				CityGMLModuleType.WATERBODY,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/waterbody/1.0",
				"wtr",
				"http://schemas.opengis.net/citygml/waterbody/1.0/waterBody.xsd",			
				CoreModule.v1_0_0);

		v0_4_0 = new WaterBodyModule (
				CityGMLModuleType.WATERBODY,
				CoreModule.v0_4_0.getVersion(),
				CoreModule.v0_4_0.getNamespaceURI(),
				CoreModule.v0_4_0.getNamespacePrefix(),
				CoreModule.v0_4_0.getSchemaLocation(),		
				CoreModule.v0_4_0);
		
		v1_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v1_0_0.elementMap.put("WaterBody", WaterBody.class);
		v1_0_0.elementMap.put("WaterSurface", WaterSurface.class);
		v1_0_0.elementMap.put("WaterGroundSurface", WaterGroundSurface.class);
		v1_0_0.elementMap.put("WaterClosureSurface", WaterClosureSurface.class);
		v0_4_0.elementMap = v1_0_0.elementMap;
		
		v1_0_0.propertySet = new HashSet<String>();
		v1_0_0.propertySet.add("boundedBy");
		v0_4_0.propertySet = v1_0_0.propertySet;
	}

	public static List<WaterBodyModule> getInstances() {
		return instances;
	}

}
