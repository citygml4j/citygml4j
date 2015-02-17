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
package org.citygml4j.builder.jaxb;

import java.util.HashMap;
import java.util.HashSet;

import org.citygml4j.model.module.Module;
import org.citygml4j.model.module.citygml.AppearanceModule;
import org.citygml4j.model.module.citygml.BridgeModule;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.citygml4j.model.module.citygml.CityFurnitureModule;
import org.citygml4j.model.module.citygml.CityObjectGroupModule;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.model.module.citygml.GenericsModule;
import org.citygml4j.model.module.citygml.LandUseModule;
import org.citygml4j.model.module.citygml.ReliefModule;
import org.citygml4j.model.module.citygml.TexturedSurfaceModule;
import org.citygml4j.model.module.citygml.TransportationModule;
import org.citygml4j.model.module.citygml.TunnelModule;
import org.citygml4j.model.module.citygml.VegetationModule;
import org.citygml4j.model.module.citygml.WaterBodyModule;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.model.module.xal.XALCoreModule;

public class JAXBContextPath {
	static HashMap<Module, String> contextPathMap;

	static {
		contextPathMap = new HashMap<Module, String>();

		// CityGML 2.0
		contextPathMap.put(CoreModule.v2_0_0, "net.opengis.citygml._2");
		contextPathMap.put(AppearanceModule.v2_0_0, "net.opengis.citygml.appearance._2");
		contextPathMap.put(BridgeModule.v2_0_0, "net.opengis.citygml.bridge._2");
		contextPathMap.put(BuildingModule.v2_0_0, "net.opengis.citygml.building._2");
		contextPathMap.put(CityFurnitureModule.v2_0_0, "net.opengis.citygml.cityfurniture._2");
		contextPathMap.put(CityObjectGroupModule.v2_0_0, "net.opengis.citygml.cityobjectgroup._2");
		contextPathMap.put(GenericsModule.v2_0_0, "net.opengis.citygml.generics._2");
		contextPathMap.put(LandUseModule.v2_0_0, "net.opengis.citygml.landuse._2");
		contextPathMap.put(ReliefModule.v2_0_0, "net.opengis.citygml.relief._2");
		contextPathMap.put(TexturedSurfaceModule.v2_0_0, "net.opengis.citygml.texturedsurface._2");
		contextPathMap.put(TransportationModule.v2_0_0, "net.opengis.citygml.transportation._2");
		contextPathMap.put(TunnelModule.v2_0_0, "net.opengis.citygml.tunnel._2");
		contextPathMap.put(VegetationModule.v2_0_0, "net.opengis.citygml.vegetation._2");
		contextPathMap.put(WaterBodyModule.v2_0_0, "net.opengis.citygml.waterbody._2");
		
		// CityGML 1.0
		contextPathMap.put(CoreModule.v1_0_0, "net.opengis.citygml._1");
		contextPathMap.put(AppearanceModule.v1_0_0, "net.opengis.citygml.appearance._1");
		contextPathMap.put(BuildingModule.v1_0_0, "net.opengis.citygml.building._1");
		contextPathMap.put(CityFurnitureModule.v1_0_0, "net.opengis.citygml.cityfurniture._1");
		contextPathMap.put(CityObjectGroupModule.v1_0_0, "net.opengis.citygml.cityobjectgroup._1");
		contextPathMap.put(GenericsModule.v1_0_0, "net.opengis.citygml.generics._1");
		contextPathMap.put(LandUseModule.v1_0_0, "net.opengis.citygml.landuse._1");
		contextPathMap.put(ReliefModule.v1_0_0, "net.opengis.citygml.relief._1");
		contextPathMap.put(TexturedSurfaceModule.v1_0_0, "net.opengis.citygml.texturedsurface._1");
		contextPathMap.put(TransportationModule.v1_0_0, "net.opengis.citygml.transportation._1");
		contextPathMap.put(VegetationModule.v1_0_0, "net.opengis.citygml.vegetation._1");
		contextPathMap.put(WaterBodyModule.v1_0_0, "net.opengis.citygml.waterbody._1");
		
		// GML 3.1.1 and xAL 2.0
		contextPathMap.put(GMLCoreModule.v3_1_1, "net.opengis.gml");
		contextPathMap.put(XALCoreModule.v2_0, "oasis.names.tc.ciq.xsdschema.xal._2");
	}
	
	public static String getContextPath() {
		HashSet<String> contextPaths = new HashSet<String>();

		for (Module module : contextPathMap.keySet()) {
			String contextPath = contextPathMap.get(module);
			if (contextPath != null)
				contextPaths.add(contextPath);
		}

		return createContextPath(contextPaths);
	}
	
	public static String getContextPath(String... packageNames) {
		StringBuilder builder = new StringBuilder(getContextPath());
		
		for (String contextPath : packageNames) {
			builder.append(":");
			builder.append(contextPath);
		}
		
		return builder.toString();	
	}

	private static String createContextPath(HashSet<String> contextPaths) {
		StringBuilder builder = new StringBuilder();
		int counter = 0;
		int size = contextPaths.size();

		for (String contextPath : contextPaths) {
			builder.append(contextPath);
			if (++counter < size)
				builder.append(":");
		}

		return builder.toString();
	}
}
