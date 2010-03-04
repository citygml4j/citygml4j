package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.Square;
import org.citygml4j.model.citygml.transportation.Track;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TransportationComplex;
import org.citygml4j.model.module.Module;

public class TransportationModule extends AbstractCityGMLModule {
	private static final List<TransportationModule> instances = new ArrayList<TransportationModule>();

	public static final TransportationModule v1_0_0;
	public static final TransportationModule v0_4_0;

	private TransportationModule (
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
		v1_0_0 = new TransportationModule (
				CityGMLModuleType.TRANSPORTATION,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/transportation/1.0",
				"tran",
				"http://schemas.opengis.net/citygml/transportation/1.0/transportation.xsd",			
				CoreModule.v1_0_0);

		v0_4_0 = new TransportationModule (
				CityGMLModuleType.TRANSPORTATION,
				CoreModule.v0_4_0.getVersion(),
				CoreModule.v0_4_0.getNamespaceURI(),
				CoreModule.v0_4_0.getNamespacePrefix(),
				CoreModule.v0_4_0.getSchemaLocation(),		
				CoreModule.v0_4_0);
		
		v1_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v1_0_0.elementMap.put("TransportationComplex", TransportationComplex.class);
		v1_0_0.elementMap.put("AuxiliaryTrafficArea", AuxiliaryTrafficArea.class);
		v1_0_0.elementMap.put("TrafficArea", TrafficArea.class);
		v1_0_0.elementMap.put("Square", Square.class);
		v1_0_0.elementMap.put("Track", Track.class);
		v1_0_0.elementMap.put("Railway", Railway.class);
		v1_0_0.elementMap.put("Road", Road.class);
		v0_4_0.elementMap = v1_0_0.elementMap;
		
		v1_0_0.propertySet = new HashSet<String>();
		v1_0_0.propertySet.add("trafficArea");
		v1_0_0.propertySet.add("auxiliaryTrafficArea");
		v0_4_0.propertySet = v1_0_0.propertySet;
	}

	public static List<TransportationModule> getInstances() {
		return instances;
	}

}
