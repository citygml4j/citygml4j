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
package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.module.Module;

public class LandUseModule extends AbstractCityGMLModule {
	private static final List<LandUseModule> instances = new ArrayList<LandUseModule>();

	public static final LandUseModule v2_0_0;
	public static final LandUseModule v1_0_0;

	private LandUseModule (
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
		v2_0_0 = new LandUseModule (
				CityGMLModuleType.LAND_USE,
				CityGMLModuleVersion.v2_0_0,
				"http://www.opengis.net/citygml/landuse/2.0",
				"luse",
				"http://schemas.opengis.net/citygml/landuse/2.0/landUse.xsd",			
				CoreModule.v2_0_0);
		
		v1_0_0 = new LandUseModule (
				CityGMLModuleType.LAND_USE,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/landuse/1.0",
				"luse",
				"http://schemas.opengis.net/citygml/landuse/1.0/landUse.xsd",			
				CoreModule.v1_0_0);

		v2_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v2_0_0.elementMap.put("LandUse", LandUse.class);
		v1_0_0.elementMap = v2_0_0.elementMap;
	}

	public static List<LandUseModule> getInstances() {
		return instances;
	}
	
	public static LandUseModule getInstance(CityGMLModuleVersion version) {
		switch (version) {
		case v2_0_0:
			return v2_0_0;
		case v1_0_0:
			return v1_0_0;
		default:
			return null;
		}
	}

}
