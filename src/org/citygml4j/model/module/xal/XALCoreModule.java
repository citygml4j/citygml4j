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
	
	public static XALCoreModule getInstance(XALModuleVersion version) {
		switch (version) {
		case v2_0:
			return v2_0;
		default:
			return null;
		}
	}
	
}
