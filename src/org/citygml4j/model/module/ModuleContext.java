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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.module.ade.ADEModule;
import org.citygml4j.model.module.citygml.CityGMLModule;
import org.citygml4j.model.module.citygml.CityGMLModuleType;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.gml.GMLModule;
import org.citygml4j.model.module.gml.GMLModuleType;
import org.citygml4j.model.module.xal.XALModule;
import org.citygml4j.model.module.xal.XALModuleType;

public class ModuleContext {
	private CityGMLVersion version;
	private HashMap<ModuleType, Module> modules = new HashMap<ModuleType, Module>();
	private HashSet<ADEModule> adeModules;

	public ModuleContext() {
		this(CityGMLVersion.DEFAULT);
	}
	
	public ModuleContext(CityGMLVersion version) {
		for (Module module : version.getModules())
			modules.put(module.getType(), module);

		this.version = version;
	}
	
	public ModuleContext(ModuleContext moduleContext) {
		for (Module module : moduleContext.getModules())
			modules.put(module.getType(), module);

		if (moduleContext.adeModules != null)
			adeModules = new HashSet<>(moduleContext.adeModules);

		version = moduleContext.version;
	}

	public ModuleContext(CityGMLVersion version, List<ADEContext> adeContexts) {
		this(version);

		for (ADEContext adeContext : adeContexts) {
			for (ADEModule module : adeContext.getADEModules())
				addADEModule(module);
		}
	}

	public ModuleContext(ModuleContext moduleContext, List<ADEContext> adeContexts) {
		this(moduleContext);

		for (ADEContext adeContext : adeContexts) {
			for (ADEModule module : adeContext.getADEModules())
				addADEModule(module);
		}
	}

	public Module getModule(CityGMLModuleType type) {
		return modules.get(type);
	}

	public Module getModule(GMLModuleType type) {
		return modules.get(type);
	}

	public Module getModule(XALModuleType type) {
		return modules.get(type);
	}

	public boolean contains(Module module) {
		if (!(module instanceof ADEModule))
			return modules.values().contains(module);
		else 
			return adeModules != null ? adeModules.contains(module) : false;
	}

	public List<Module> getModules() {
		List<Module> modules = new ArrayList<Module>(this.modules.values());
		if (adeModules != null)
			modules.addAll(adeModules);

		return modules;
	}	
	
	public List<CityGMLModule> getCityGMLModules() {
		List<CityGMLModule> modules = new ArrayList<CityGMLModule>();
		for (Module module : this.modules.values())
			if (module instanceof CityGMLModule)
				modules.add((CityGMLModule)module);
		
		return modules;
	}
	
	public List<GMLModule> getGMLModules() {
		List<GMLModule> modules = new ArrayList<GMLModule>();
		for (Module module : this.modules.values())
			if (module instanceof GMLModule)
				modules.add((GMLModule)module);
		
		return modules;
	}
	
	public List<XALModule> getXALModules() {
		List<XALModule> modules = new ArrayList<XALModule>();
		for (Module module : this.modules.values())
			if (module instanceof XALModule)
				modules.add((XALModule)module);
		
		return modules;
	}

	public List<ADEModule> getADEModules() {
		return adeModules != null ? new ArrayList<>(adeModules) : Collections.emptyList();
	}

	public boolean addADEModule(ADEModule adeModule) {
		for (Module dependency : adeModule.getDependencies())
			if (!contains(dependency))
				return false;

		if (adeModules == null)
			adeModules = new HashSet<>();

		return adeModules.add((ADEModule)adeModule);
	}

	public CityGMLVersion getCityGMLVersion() {
		return version;
	}
	
	public void setCityGMLVersion(CityGMLVersion version) {
		this.version = version;

		modules.clear();
		for (Module module : version.getModules())
			modules.put(module.getType(), module);

		if (adeModules != null) {
			HashSet<ADEModule> tmp = adeModules;
			adeModules = null;
			
			for (ADEModule module : tmp)
				addADEModule(module);
		}
	}

}
