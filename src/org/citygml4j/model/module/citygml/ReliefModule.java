package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.module.Module;

public class ReliefModule extends AbstractCityGMLModule {
	private static final List<ReliefModule> instances = new ArrayList<ReliefModule>();

	public static final ReliefModule v1_0_0;
	public static final ReliefModule v0_4_0;

	private ReliefModule (
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
		v1_0_0 = new ReliefModule (
				CityGMLModuleType.RELIEF,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/relief/1.0",
				"dem",
				"http://schemas.opengis.net/citygml/relief/1.0/relief.xsd",			
				CoreModule.v1_0_0);

		v0_4_0 = new ReliefModule (
				CityGMLModuleType.RELIEF,
				CoreModule.v0_4_0.getVersion(),
				CoreModule.v0_4_0.getNamespaceURI(),
				CoreModule.v0_4_0.getNamespacePrefix(),
				CoreModule.v0_4_0.getSchemaLocation(),		
				CoreModule.v0_4_0);
		
		v1_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v1_0_0.elementMap.put("MassPointRelief", MassPointRelief.class);
		v1_0_0.elementMap.put("ReliefFeature", ReliefFeature.class);
		v1_0_0.elementMap.put("BreaklineRelief", BreaklineRelief.class);
		v1_0_0.elementMap.put("TINRelief", TINRelief.class);
		v1_0_0.elementMap.put("RasterRelief", RasterRelief.class);
		v0_4_0.elementMap = v1_0_0.elementMap;
		
		v1_0_0.propertySet = new HashSet<String>();
		v1_0_0.propertySet.add("grid");
		v1_0_0.propertySet.add("reliefComponent");
		v0_4_0.propertySet = v1_0_0.propertySet;
	}

	public static List<ReliefModule> getInstances() {
		return instances;
	}

}
