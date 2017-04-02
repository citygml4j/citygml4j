/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.builder.jaxb;

import java.util.Arrays;
import java.util.Collection;
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

	public static String getContextPath(Collection<String> packageNames) {
		StringBuilder builder = new StringBuilder(getContextPath());

		if (packageNames != null) {
			for (String contextPath : packageNames) {
				builder.append(":");
				builder.append(contextPath);
			}
		}
		
		return builder.toString();	
	}
	
	public static String getContextPath(String... packageNames) {
		return getContextPath(Arrays.asList(packageNames));
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
