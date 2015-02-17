/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
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
	
	public static XLinkModule getInstance(GMLModuleVersion version) {
		switch (version) {
		case v3_1_1:
			return v3_1_1;
		default:
			return null;
		}
	}
	
}
