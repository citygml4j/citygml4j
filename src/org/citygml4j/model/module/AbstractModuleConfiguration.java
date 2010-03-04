package org.citygml4j.model.module;

import java.util.Arrays;
import java.util.List;

public class AbstractModuleConfiguration {
	protected Module[] modules;
	
	public AbstractModuleConfiguration(Module... modules) {
		this.modules = modules;
	}
	
	public List<Module> getModules() {
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
