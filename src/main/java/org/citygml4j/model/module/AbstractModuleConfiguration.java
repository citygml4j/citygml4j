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

import java.util.Arrays;
import java.util.List;

public class AbstractModuleConfiguration {
	protected Module[] modules;
	
	public <T extends Module> AbstractModuleConfiguration(T[] modules) {
		this.modules = modules;
	}
	
	public AbstractModuleConfiguration(List<? extends Module> modules) {
		this.modules = (Module[])modules.toArray();
	}
	
	public List<? extends Module> getModules() {
		return Arrays.asList(modules);
	}
	
	public Module getModule(ModuleType type) {
		for (Module module : modules)
			if (module.getType().equals(type))
				return module;

		return null;
	}

	public boolean contains(ModuleType type, ModuleVersion version) {
		for (Module module : modules)
			if (module.getType().equals(type))
				return module.getVersion().equals(version);

		return false;
	}

	public boolean contains(Module module) {
		for (Module cand : modules)
			if (cand.equals(module))
				return true;

		return false;
	}
}
