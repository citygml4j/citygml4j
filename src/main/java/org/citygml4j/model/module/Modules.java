/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.model.gml.feature.AbstractFeature;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Modules {
	static Map<String, Module> modules = new ConcurrentHashMap<>();

	static {
		for (Module module : CoreModule.getInstances()) modules.put(module.getNamespaceURI(), module);
		for (Module module : AppearanceModule.getInstances()) modules.put(module.getNamespaceURI(), module);
		for (Module module : BridgeModule.getInstances()) modules.put(module.getNamespaceURI(), module);
		for (Module module : BuildingModule.getInstances()) modules.put(module.getNamespaceURI(), module);
		for (Module module : CityFurnitureModule.getInstances()) modules.put(module.getNamespaceURI(), module);
		for (Module module : CityObjectGroupModule.getInstances()) modules.put(module.getNamespaceURI(), module);
		for (Module module : GenericsModule.getInstances()) modules.put(module.getNamespaceURI(), module);
		for (Module module : LandUseModule.getInstances()) modules.put(module.getNamespaceURI(), module);
		for (Module module : ReliefModule.getInstances()) modules.put(module.getNamespaceURI(), module);
		for (Module module : TransportationModule.getInstances()) modules.put(module.getNamespaceURI(), module);
		for (Module module : TunnelModule.getInstances()) modules.put(module.getNamespaceURI(), module);
		for (Module module : VegetationModule.getInstances()) modules.put(module.getNamespaceURI(), module);
		for (Module module : WaterBodyModule.getInstances()) modules.put(module.getNamespaceURI(), module);
		for (Module module : TexturedSurfaceModule.getInstances()) modules.put(module.getNamespaceURI(), module);
		for (Module module : GMLCoreModule.getInstances()) modules.put(module.getNamespaceURI(), module);
		for (Module module : XLinkModule.getInstances()) modules.put(module.getNamespaceURI(), module);
		for (Module module : XALCoreModule.getInstances()) modules.put(module.getNamespaceURI(), module);
	}

	private Modules() {
		// just to thwart instantiation
	}

	public static Module getModule(String namespaceURI) {
		return modules.get(namespaceURI);
	}
	
	public static Module getModule(Class<? extends AbstractFeature> featureClass) {
		for (Module module : modules.values()) {
			Map<String, Class<? extends AbstractFeature>> features = module.getFeatures();
			if (features != null && features.values().contains(featureClass))
				return module;
		}
		
		return null;
	}

	public static List<Module> getModules() {
		return new ArrayList<>(modules.values());
	}

	public static List<CityGMLModule> getCityGMLModules() {
		return getModules(CityGMLModule.class);
	}

	public static CityGMLModule getCityGMLModule(String namespaceURI) {
		return getModule(CityGMLModule.class, namespaceURI);
	}

	public static List<CityGMLModule> getCityGMLModules(CityGMLModuleType type) {
		return getModules(CityGMLModule.class, type);
	}

	public static List<GMLModule> getGMLModules() {
		return getModules(GMLModule.class);
	}

	public static List<GMLModule> getGMLModules(GMLModuleType type) {
		return getModules(GMLModule.class, type);
	}

	public static List<XALModule> getXALModules() {
		return getModules(XALModule.class);
	}

	public static List<XALModule> getXALModules(XALModuleType type) {
		return getModules(XALModule.class, type);
	}

	public static void registerADEModule(ADEModule module) {
		modules.put(module.getNamespaceURI(), module);
	}

	public static void unregisterADEModule(ADEModule module) {
		modules.remove(module.getNamespaceURI());
	}

	public static List<ADEModule> getADEModules() {
		return getModules(ADEModule.class);
	}

	public static List<ADEModule> getADEModules(ADEModuleType type) {
		return getModules(ADEModule.class, type);
	}

	public static ADEModule getADEModule(String namespaceURI) {
		return getModule(ADEModule.class, namespaceURI);
	}

	public static boolean isCityGMLModuleNamespace(String namespaceURI) {
		return namespaceURI != null && namespaceURI.startsWith("http://www.opengis.net/citygml");
	}

	public static boolean isModuleNamespace(String namespaceURI, ModuleType type) {
		Module module = modules.get(namespaceURI);
		return module != null && module.getType().equals(type);
	}
	
	private static <T extends Module> T getModule(Class<T> moduleClass, String namespaceURI) {
		Module module = modules.get(namespaceURI);
		return moduleClass.isInstance(module) ? moduleClass.cast(module) : null;
	}
	
	private static <T extends Module> List<T> getModules(Class<T> moduleClass) {
		List<T> result = new ArrayList<>();
		for (Module module : modules.values()) {
			if (moduleClass.isInstance(module))
				result.add(moduleClass.cast(module));
		}
		
		return result;
	}
	
	private static <T extends Module> List<T> getModules(Class<T> moduleClass, ModuleType type) {
		List<T> result = new ArrayList<>();
		for (Module module : modules.values()) {
			if (module.getType().equals(type) && moduleClass.isInstance(module))
				result.add(moduleClass.cast(module));
		}
		
		return result;
	}

}
