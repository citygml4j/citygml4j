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

import java.util.Arrays;
import java.util.List;

public class AbstractModuleConfiguration {
	protected Module[] modules;
	
	public <T extends Module> AbstractModuleConfiguration(T... modules) {
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
