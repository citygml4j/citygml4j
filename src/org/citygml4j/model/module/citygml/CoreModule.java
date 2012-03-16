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
import java.util.HashSet;
import java.util.List;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.module.Module;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.model.module.xal.XALCoreModule;

public class CoreModule extends AbstractCityGMLModule {
	private static final List<CoreModule> instances = new ArrayList<CoreModule>();

	public static final CoreModule v2_0_0;
	public static final CoreModule v1_0_0;
	public static final CoreModule v0_4_0;

	private CoreModule (
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
		v2_0_0 = new CoreModule (
				CityGMLModuleType.CORE,
				CityGMLModuleVersion.v2_0_0,
				"http://www.opengis.net/citygml/2.0",
				"core",
				"http://schemas.opengis.net/citygml/2.0/cityGMLBase.xsd", 
				GMLCoreModule.v3_1_1, XALCoreModule.v2_0);	
		
		v1_0_0 = new CoreModule (
				CityGMLModuleType.CORE,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/1.0",
				"core",
				"http://schemas.opengis.net/citygml/1.0/cityGMLBase.xsd", 
				GMLCoreModule.v3_1_1, XALCoreModule.v2_0);			

		v0_4_0 = new CoreModule (
				CityGMLModuleType.CORE,
				CityGMLModuleVersion.v0_4_0,
				"http://www.citygml.org/citygml/1/0/0",
				"citygml",
				"http://www.citygml.org/citygml/0/4/0/CityGML.xsd",
				GMLCoreModule.v3_1_1, XALCoreModule.v2_0);
		
		v2_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v2_0_0.elementMap.put("CityModel", CityModel.class);
		v2_0_0.elementMap.put("Address", Address.class);
		v0_4_0.elementMap = v1_0_0.elementMap = v2_0_0.elementMap;
		
		v2_0_0.propertySet = new HashSet<String>();
		v2_0_0.propertySet.add("cityObjectMember");
		v2_0_0.propertySet.add("generalizesTo");
		v0_4_0.propertySet = v1_0_0.propertySet = v2_0_0.propertySet;
	}

	public static List<CoreModule> getInstances() {
		return instances;
	}

}
