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

import org.citygml4j.CityGMLContext;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.module.ade.ADEModule;
import org.citygml4j.model.module.citygml.CityGMLModule;
import org.citygml4j.model.module.citygml.CityGMLModuleType;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.gml.GMLModule;
import org.citygml4j.model.module.gml.GMLModuleType;
import org.citygml4j.model.module.xal.XALModule;
import org.citygml4j.model.module.xal.XALModuleType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ModuleContext {
	private CityGMLVersion version;
	private HashMap<ModuleType, Module> modules = new HashMap<>();
	private HashSet<ADEModule> adeModules;

	public ModuleContext() {
		this(CityGMLVersion.DEFAULT);
	}

	public ModuleContext(CityGMLVersion version) {
		this.version = version;
		for (Module module : version.getModules())
			modules.put(module.getType(), module);

		addADEModules();
	}

	public ModuleContext(ModuleContext moduleContext) {
		version = moduleContext.version;
		modules = new HashMap<>(moduleContext.modules);

		if (moduleContext.adeModules != null)
			adeModules = new HashSet<>(moduleContext.adeModules);
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
		return getModules(CityGMLModule.class);
	}

	public List<GMLModule> getGMLModules() {
		return getModules(GMLModule.class);
	}

	public List<XALModule> getXALModules() {
		return getModules(XALModule.class);
	}

	public List<ADEModule> getADEModules() {
		return adeModules != null ? new ArrayList<>(adeModules) : Collections.emptyList();
	}

	public CityGMLVersion getCityGMLVersion() {
		return version;
	}

	public void setCityGMLVersion(CityGMLVersion version) {
		this.version = version;
		modules = new HashMap<>();
		adeModules = null;

		for (Module module : version.getModules())
			modules.put(module.getType(), module);

		addADEModules();
	}

	private void addADEModules() {
		CityGMLContext context = CityGMLContext.getInstance();
		if (context.hasADEContexts()) {
			for (ADEContext adeContext : context.getADEContexts()) {
				for (ADEModule module : adeContext.getADEModules()) {
					if (module.getCityGMLVersion() != version)
						continue;

					for (Module dependency : module.getDependencies()) {
						if (contains(dependency)) {
							if (adeModules == null)
								adeModules = new HashSet<>();

							adeModules.add(module);
							break;
						}
					}
				}
			}
		}
	}

	private <T extends Module> List<T> getModules(Class<T> moduleClass) {
		List<T> result = new ArrayList<>();
		for (Module module : modules.values()) {
			if (moduleClass.isInstance(module))
				result.add(moduleClass.cast(module));
		}

		return result;
	}

}
