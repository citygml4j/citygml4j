package org.citygml4j.model.citygml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.citygml4j.util.CityGMLModules;

public class CityGMLModuleDependencies {
	private HashMap<CityGMLModuleType, CityGMLModuleVersion> modules;

	public CityGMLModuleDependencies(CityGMLModule... cityGMLModules) {
		modules = new HashMap<CityGMLModuleType, CityGMLModuleVersion>();
		for (CityGMLModule cityGMLModule : cityGMLModules)
			modules.put(cityGMLModule.getModuleType(), cityGMLModule.getModuleVersion());
	}
	
	public boolean contains(CityGMLModuleType cityGMLModuleType) {
		return modules.containsKey(cityGMLModuleType);
	}
	
	public boolean contains(CityGMLModule module) {
		if (modules.get(module.getModuleType()) == module.getModuleVersion())
			return true;
		
		return false;
	}
	
	public CityGMLModule getModule(CityGMLModuleType cityGMLModuleType) {
		if (modules.containsKey(cityGMLModuleType))
			return CityGMLModules.getModuleByTypeAndVersion(cityGMLModuleType, modules.get(cityGMLModuleType));
		
		return null;
	}
	
	public List<CityGMLModule> getModules() {
		List<CityGMLModule> modulesList = new ArrayList<CityGMLModule>();
		
		if (!modules.isEmpty()) {
			Iterator<Entry<CityGMLModuleType, CityGMLModuleVersion>> iter = modules.entrySet().iterator();			
			
			while (iter.hasNext()) {
				Entry<CityGMLModuleType, CityGMLModuleVersion> entry = iter.next();
				modulesList.add(CityGMLModules.getModuleByTypeAndVersion(entry.getKey(), entry.getValue()));
			}
		}
		
		return modulesList;
	}
}