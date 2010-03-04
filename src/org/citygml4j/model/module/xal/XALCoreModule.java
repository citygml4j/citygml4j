package org.citygml4j.model.module.xal;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.model.module.Module;

public class XALCoreModule extends AbstractXALModule {	
	private static final List<XALCoreModule> instances = new ArrayList<XALCoreModule>();

	public static final XALCoreModule v2_0;

	public XALCoreModule (
			XALModuleType type,
			XALModuleVersion version,
			String namespaceURI, 
			String namespacePrefix, 
			String schemaLocation,
			Module... dependencies) {
		super(type, version, namespaceURI, namespacePrefix, schemaLocation, dependencies);
		instances.add(this);
	}

	static {
		v2_0 = new XALCoreModule (
				XALModuleType.CORE,
				XALModuleVersion.v2_0,
				"urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", 
				"xal", 
				"http://schemas.opengis.net/citygml/xAL/xAL.xsd");
	}

	public static List<XALCoreModule> getInstances() {
		return instances;
	}
	
}
