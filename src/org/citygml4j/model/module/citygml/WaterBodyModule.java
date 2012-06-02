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
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.model.module.Module;

public class WaterBodyModule extends AbstractCityGMLModule {
	private static final List<WaterBodyModule> instances = new ArrayList<WaterBodyModule>();

	public static final WaterBodyModule v2_0_0;
	public static final WaterBodyModule v1_0_0;

	private WaterBodyModule (
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
		v2_0_0 = new WaterBodyModule (
				CityGMLModuleType.WATER_BODY,
				CityGMLModuleVersion.v2_0_0,
				"http://www.opengis.net/citygml/waterbody/2.0",
				"wtr",
				"http://schemas.opengis.net/citygml/waterbody/2.0/waterBody.xsd",			
				CoreModule.v2_0_0);
		
		v1_0_0 = new WaterBodyModule (
				CityGMLModuleType.WATER_BODY,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/waterbody/1.0",
				"wtr",
				"http://schemas.opengis.net/citygml/waterbody/1.0/waterBody.xsd",			
				CoreModule.v1_0_0);

		v2_0_0.elementMap = new HashMap<String, Class<? extends CityGML>>();
		v2_0_0.elementMap.put("WaterBody", WaterBody.class);
		v2_0_0.elementMap.put("WaterSurface", WaterSurface.class);
		v2_0_0.elementMap.put("WaterGroundSurface", WaterGroundSurface.class);
		v2_0_0.elementMap.put("WaterClosureSurface", WaterClosureSurface.class);
		v1_0_0.elementMap = v2_0_0.elementMap;
		
		v2_0_0.propertySet = new HashSet<String>();
		v2_0_0.propertySet.add("boundedBy");
		v1_0_0.propertySet = v2_0_0.propertySet;
	}

	public static List<WaterBodyModule> getInstances() {
		return instances;
	}
	
	public static WaterBodyModule getInstance(CityGMLModuleVersion version) {
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
