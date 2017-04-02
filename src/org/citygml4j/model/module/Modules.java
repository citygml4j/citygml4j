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
package org.citygml4j.model.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.citygml4j.model.module.ade.ADEModule;
import org.citygml4j.model.module.ade.ADEModuleType;
import org.citygml4j.model.module.citygml.AppearanceModule;
import org.citygml4j.model.module.citygml.BridgeModule;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.citygml4j.model.module.citygml.CityFurnitureModule;
import org.citygml4j.model.module.citygml.CityGMLModule;
import org.citygml4j.model.module.citygml.CityGMLModuleType;
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
import org.citygml4j.model.module.gml.GMLModule;
import org.citygml4j.model.module.gml.GMLModuleType;
import org.citygml4j.model.module.gml.XLinkModule;
import org.citygml4j.model.module.xal.XALCoreModule;
import org.citygml4j.model.module.xal.XALModule;
import org.citygml4j.model.module.xal.XALModuleType;

public class Modules {
	static HashMap<ModuleType, List<? extends Module>> modules;

	static {
		modules = new HashMap<ModuleType, List<? extends Module>>();

		modules.put(CityGMLModuleType.CORE, CoreModule.getInstances());
		modules.put(CityGMLModuleType.APPEARANCE, AppearanceModule.getInstances());
		modules.put(CityGMLModuleType.BRIDGE, BridgeModule.getInstances());
		modules.put(CityGMLModuleType.BUILDING, BuildingModule.getInstances());
		modules.put(CityGMLModuleType.CITY_FURNITURE, CityFurnitureModule.getInstances());
		modules.put(CityGMLModuleType.CITY_OBJECT_GROUP, CityObjectGroupModule.getInstances());
		modules.put(CityGMLModuleType.GENERICS, GenericsModule.getInstances());
		modules.put(CityGMLModuleType.LAND_USE, LandUseModule.getInstances());
		modules.put(CityGMLModuleType.RELIEF, ReliefModule.getInstances());
		modules.put(CityGMLModuleType.TRANSPORTATION, TransportationModule.getInstances());
		modules.put(CityGMLModuleType.TUNNEL, TunnelModule.getInstances());
		modules.put(CityGMLModuleType.VEGETATION, VegetationModule.getInstances());
		modules.put(CityGMLModuleType.WATER_BODY, WaterBodyModule.getInstances());
		modules.put(CityGMLModuleType.TEXTURED_SURFACE, TexturedSurfaceModule.getInstances());

		modules.put(GMLModuleType.CORE, GMLCoreModule.getInstances());
		modules.put(GMLModuleType.XLINK, XLinkModule.getInstances());

		modules.put(XALModuleType.CORE, XALCoreModule.getInstances());
	}

	private Modules() {
		// just to thwart instantiation
	}

	public static Module getModule(String namespaceURI) {
		for (List<? extends Module> moduleSet : modules.values()) {
			for (Module module : moduleSet)
				if (namespaceURI.equals(module.getNamespaceURI()))
					return module;
		}

		return null;
	}

	public static Module getModule(ModuleType type, ModuleVersion version) {
		for (Module module : modules.get(type)) 
			if (module.getVersion().equals(version)) 
				return module;

		return null;
	}

	public static List<Module> getModules() {
		List<Module> all = new ArrayList<Module>();
		for (List<? extends Module> moduleList : modules.values())
			all.addAll(moduleList);

		return all;
	}

	public static List<CityGMLModule> getCityGMLModules() {
		List<CityGMLModule> citygml = new ArrayList<CityGMLModule>();
		for (ModuleType type : modules.keySet())
			if (type instanceof CityGMLModuleType)
				for (Module module : modules.get(type))
					if (module instanceof CityGMLModule)
						citygml.add((CityGMLModule)module);

		return citygml;
	}
	
	public static CityGMLModule getCityGMLModule(String namespaceURI) {
		Module module = getModule(namespaceURI);
		return (module instanceof CityGMLModule) ? (CityGMLModule)module : null;
	}

	public static List<CityGMLModule> getCityGMLModules(CityGMLModuleType type) {
		List<CityGMLModule> citygml = new ArrayList<CityGMLModule>();
		for (Module module : modules.get(type))
			if (module instanceof CityGMLModule)
				citygml.add((CityGMLModule)module);

		return citygml;
	}

	public static List<GMLModule> getGMLModules() {
		List<GMLModule> gml = new ArrayList<GMLModule>();
		for (ModuleType type : modules.keySet())
			if (type instanceof GMLModuleType)
				for (Module module : modules.get(type))
					if (module instanceof GMLModule)
						gml.add((GMLModule)module);

		return gml;
	}

	public static List<GMLModule> getGMLModules(GMLModuleType type) {
		List<GMLModule> gml = new ArrayList<GMLModule>();
		for (Module module : modules.get(type))
			if (module instanceof GMLModule)
				gml.add((GMLModule)module);

		return gml;
	}

	public static List<XALModule> getXALModules() {
		List<XALModule> xal = new ArrayList<XALModule>();
		for (ModuleType type : modules.keySet())
			if (type instanceof XALModuleType)
				for (Module module : modules.get(type))
					if (module instanceof XALModule)
						xal.add((XALModule)module);

		return xal;
	}

	public static List<XALModule> getXALModules(XALModuleType type) {
		List<XALModule> xal = new ArrayList<XALModule>();
		for (Module module : modules.get(type))
			if (module instanceof XALModule)
				xal.add((XALModule)module);

		return xal;
	}
	
	@SuppressWarnings("unchecked")
	public static void registerADEModule(ADEModule module) {
		List<ADEModule> ade = (List<ADEModule>)modules.get(module.getType());
		if (ade == null) {
			ade = new ArrayList<>();
			modules.put(module.getType(), ade);
		}
		
		ade.add(module);
	}
	
	@SuppressWarnings("unchecked")
	public static void unregisterADEModule(ADEModule module) {
		List<ADEModule> ade = (List<ADEModule>)modules.get(module.getType());
		if (ade != null)
			ade.remove(module);
	}
	
	public static List<ADEModule> getADEModules() {
		List<ADEModule> ade = new ArrayList<ADEModule>();
		for (ModuleType type : modules.keySet())
			if (type instanceof ADEModuleType)
				for (Module module : modules.get(type))
					if (module instanceof ADEModule)
						ade.add((ADEModule)module);

		return ade;
	}
	
	public static List<ADEModule> getADEModules(ADEModuleType type) {
		List<ADEModule> ade = new ArrayList<ADEModule>();
		for (Module module : modules.get(type))
			if (module instanceof ADEModule)
				ade.add((ADEModule)module);

		return ade;
	}
	
	public static ADEModule getADEModule(String namespaceURI) {
		Module module = getModule(namespaceURI);
		return (module instanceof ADEModule) ? (ADEModule)module : null;
	}
	
	public static boolean isCityGMLModuleNamespace(String namespaceURI) {
		return namespaceURI != null && namespaceURI.startsWith("http://www.opengis.net/citygml");
	}
	
	public static boolean isModuleNamespace(String namespaceURI, ModuleType type) {
		Module module = Modules.getModule(namespaceURI);
		return module != null && module.getType() == type;
	}

}
