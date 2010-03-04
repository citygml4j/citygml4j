package org.citygml4j.model.module.gml;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.model.module.Module;

public class XLinkModule extends AbstractGMLModule {
	private static final List<XLinkModule> instances = new ArrayList<XLinkModule>();

	public static final XLinkModule v3_1_1;

	public XLinkModule (
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
		v3_1_1 = new XLinkModule (
				GMLModuleType.XLINK,
				GMLModuleVersion.v3_1_1,
				"http://www.w3.org/1999/xlink", 
				"xlink", 
				"http://schemas.opengis.net/gml/3.1.1/xlink/xlinks.xsd",
				GMLCoreModule.v3_1_1);
	}

	public static List<XLinkModule> getInstances() {
		return instances;
	}
}
