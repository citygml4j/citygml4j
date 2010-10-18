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
package org.citygml4j.model.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.citygml4j.model.module.citygml.AppearanceModule;
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
		modules.put(CityGMLModuleType.BUILDING, BuildingModule.getInstances());
		modules.put(CityGMLModuleType.CITY_FURNITURE, CityFurnitureModule.getInstances());
		modules.put(CityGMLModuleType.CITY_OBJECT_GROUP, CityObjectGroupModule.getInstances());
		modules.put(CityGMLModuleType.GENERICS, GenericsModule.getInstances());
		modules.put(CityGMLModuleType.LAND_USE, LandUseModule.getInstances());
		modules.put(CityGMLModuleType.RELIEF, ReliefModule.getInstances());
		modules.put(CityGMLModuleType.TRANSPORTATION, TransportationModule.getInstances());
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
		if (namespaceURI.equals(CoreModule.v0_4_0.getNamespaceURI()))
			return CoreModule.v0_4_0;

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

}
