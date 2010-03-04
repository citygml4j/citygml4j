package org.citygml4j.model.module.gml;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.model.module.Module;

public class GMLCoreModule extends AbstractGMLModule {	
	private static final List<GMLCoreModule> instances = new ArrayList<GMLCoreModule>();
	
	public static final GMLCoreModule v3_1_1;
	
	public GMLCoreModule (
			GMLModuleType type,
			GMLModuleVersion version,
			String namespaceURI, 
			String namespacePrefix, 
			String schemaLocation,
			Module... dependencies) {
		super(type, version, namespaceURI, namespacePrefix, schemaLocation, dependencies);
		instances.add(this);
	}
	
	static {
		v3_1_1 = new GMLCoreModule (
				GMLModuleType.CORE,
				GMLModuleVersion.v3_1_1,
				"http://www.opengis.net/gml", 
				"gml", 
				"http://schemas.opengis.net/gml/3.1.1/base/gml.xsd");
	}

	public static List<GMLCoreModule> getInstances() {
		return instances;
	}
	
}
