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
package org.citygml4j.model.module.citygml;

import org.citygml4j.model.module.AbstractModuleConfiguration;
import org.citygml4j.model.module.Module;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.model.module.gml.GMLModule;
import org.citygml4j.model.module.gml.XLinkModule;
import org.citygml4j.model.module.xal.AbstractXALModule;
import org.citygml4j.model.module.xal.XALCoreModule;

import java.util.ArrayList;
import java.util.List;

public class CityGMLVersion extends AbstractModuleConfiguration {
	private static final List<CityGMLVersion> instances = new ArrayList<CityGMLVersion>();

	public static final CityGMLVersion DEFAULT;
	public static final CityGMLVersion v2_0_0;
	public static final CityGMLVersion v1_0_0;

	private CityGMLVersion(Module... modules) {
		super(modules);
		instances.add(this);
	}

	static {		
		v2_0_0 = new CityGMLVersion(
				AppearanceModule.v2_0_0,
				BridgeModule.v2_0_0,
				BuildingModule.v2_0_0,
				CityFurnitureModule.v2_0_0,
				CityObjectGroupModule.v2_0_0,
				CoreModule.v2_0_0,
				GenericsModule.v2_0_0,
				LandUseModule.v2_0_0,
				ReliefModule.v2_0_0,
				TexturedSurfaceModule.v2_0_0,
				TransportationModule.v2_0_0,
				TunnelModule.v2_0_0,
				VegetationModule.v2_0_0,
				WaterBodyModule.v2_0_0,
				GMLCoreModule.v3_1_1,
				XLinkModule.v3_1_1,
				XALCoreModule.v2_0				
		);
		
		v1_0_0 = new CityGMLVersion(
				AppearanceModule.v1_0_0,
				BuildingModule.v1_0_0,
				CityFurnitureModule.v1_0_0,
				CityObjectGroupModule.v1_0_0,
				CoreModule.v1_0_0,
				GenericsModule.v1_0_0,
				LandUseModule.v1_0_0,
				ReliefModule.v1_0_0,
				TexturedSurfaceModule.v1_0_0,
				TransportationModule.v1_0_0,
				VegetationModule.v1_0_0,
				WaterBodyModule.v1_0_0,
				GMLCoreModule.v3_1_1,
				XLinkModule.v3_1_1,
				XALCoreModule.v2_0				
		);
		
		DEFAULT = v2_0_0;
	}

	public List<CityGMLModule> getCityGMLModules() {
		List<CityGMLModule> citygml = new ArrayList<CityGMLModule>();
		for (Module module : modules)
			if (module instanceof CityGMLModule)
				citygml.add((CityGMLModule)module);

		return citygml;
	}
	
	public CityGMLModule getCityGMLModule(CityGMLModuleType type) {
		for (CityGMLModule module : getCityGMLModules())
			if (module.getType() == type)
				return module;
		
		return null;
	}

	public List<GMLModule> getGMLModules() {
		List<GMLModule> gml = new ArrayList<GMLModule>();
		for (Module module : modules)
			if (module instanceof GMLModule)
				gml.add((GMLModule)module);

		return gml;
	}

	public List<AbstractXALModule> getXALModules() {
		List<AbstractXALModule> xal = new ArrayList<AbstractXALModule>();
		for (Module module : modules)
			if (module instanceof AbstractXALModule)
				xal.add((AbstractXALModule)module);

		return xal;
	}
	
	public static CityGMLVersion fromCityGMLModule(CityGMLModule module) {
		for (CityGMLVersion version : instances)
			if (version.contains(module))
				return version;
		
		return null;
	}
	
	public static CityGMLVersion fromCityGMLNamespaceURI(String namespaceURI) {
		for (CityGMLVersion version : instances) {
			for (CityGMLModule module : version.getCityGMLModules()) {
				if (module.getNamespaceURI().equals(namespaceURI))
					return version;
			}
		}
		
		return null;
	}

	public static List<CityGMLVersion> getInstances() {
		return instances;
	}
	
	@Override
	public String toString() {
		if (this == v2_0_0)
			return "2.0.0";
		else if (this == v1_0_0)
			return "1.0.0";
		else
			return super.toString();
	}

}
