/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
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
 */
package org.citygml4j.model.module.citygml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.module.Module;

public class GenericsModule extends AbstractCityGMLModule {
	private static final List<GenericsModule> instances = new ArrayList<GenericsModule>();

	public static final GenericsModule v2_0_0;
	public static final GenericsModule v1_0_0;
	public static final GenericsModule v0_4_0;

	private GenericsModule (
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
		v2_0_0 = new GenericsModule (
				CityGMLModuleType.GENERICS,
				CityGMLModuleVersion.v2_0_0,
				"http://www.opengis.net/citygml/generics/2.0",
				"gen",
				"http://schemas.opengis.net/citygml/generics/2.0/generics.xsd",			
				CoreModule.v2_0_0);
		
		v1_0_0 = new GenericsModule (
				CityGMLModuleType.GENERICS,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/generics/1.0",
				"gen",
				"http://schemas.opengis.net/citygml/generics/1.0/generics.xsd",			
				CoreModule.v1_0_0);

		v0_4_0 = new GenericsModule (
				CityGMLModuleType.GENERICS,
				CoreModule.v0_4_0.getVersion(),
				CoreModule.v0_4_0.getNamespaceURI(),
				CoreModule.v0_4_0.getNamespacePrefix(),
				CoreModule.v0_4_0.getSchemaLocation(),		
				CoreModule.v0_4_0);
		
		v2_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v2_0_0.elementMap.put("GenericCityObject", GenericCityObject.class);
		v0_4_0.elementMap = v1_0_0.elementMap = v2_0_0.elementMap;
	}

	public static List<GenericsModule> getInstances() {
		return instances;
	}
	
	public static GenericsModule getInstance(CityGMLModuleVersion version) {
		switch (version) {
		case v2_0_0:
			return v2_0_0;
		case v1_0_0:
			return v1_0_0;
		case v0_4_0:
			return v0_4_0;
		default:
			return null;
		}
	}

}
