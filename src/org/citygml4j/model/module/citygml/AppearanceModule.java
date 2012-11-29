/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * $Id$
 */
package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.GeoreferencedTexture;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
import org.citygml4j.model.module.Module;

public class AppearanceModule extends AbstractCityGMLModule {
	private static final List<AppearanceModule> instances = new ArrayList<AppearanceModule>();

	public static final AppearanceModule v2_0_0;
	public static final AppearanceModule v1_0_0;

	private AppearanceModule (
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
		v2_0_0 = new AppearanceModule (
				CityGMLModuleType.APPEARANCE,
				CityGMLModuleVersion.v2_0_0,
				"http://www.opengis.net/citygml/appearance/2.0",
				"app",
				"http://schemas.opengis.net/citygml/appearance/2.0/appearance.xsd",		
				CoreModule.v2_0_0);
		
		v1_0_0 = new AppearanceModule (
				CityGMLModuleType.APPEARANCE,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/appearance/1.0",
				"app",
				"http://schemas.opengis.net/citygml/appearance/1.0/appearance.xsd",		
				CoreModule.v1_0_0);

		v2_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v2_0_0.elementMap.put("Appearance", Appearance.class);
		v2_0_0.elementMap.put("ParameterizedTexture", ParameterizedTexture.class);
		v2_0_0.elementMap.put("GeoreferencedTexture", GeoreferencedTexture.class);
		v2_0_0.elementMap.put("X3DMaterial", X3DMaterial.class);
		v1_0_0.elementMap = v2_0_0.elementMap;
		
		v2_0_0.propertySet = new HashSet<String>();
		v2_0_0.propertySet.add("appearance");
		v2_0_0.propertySet.add("appearanceMember");
		v2_0_0.propertySet.add("surfaceDataMember");
		v1_0_0.propertySet = v2_0_0.propertySet;
	}

	public static List<AppearanceModule> getInstances() {
		return instances;
	}
	
	public static AppearanceModule getInstance(CityGMLModuleVersion version) {
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
