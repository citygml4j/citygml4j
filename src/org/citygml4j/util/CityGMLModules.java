package org.citygml4j.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.CityGMLModuleType;
import org.citygml4j.model.citygml.CityGMLModuleVersion;
import org.citygml4j.model.citygml.appearance.AppearanceModule;
import org.citygml4j.model.citygml.building.BuildingModule;
import org.citygml4j.model.citygml.cityfurniture.CityFurnitureModule;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupModule;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.citygml.generics.GenericsModule;
import org.citygml4j.model.citygml.landuse.LandUseModule;
import org.citygml4j.model.citygml.relief.ReliefModule;
import org.citygml4j.model.citygml.texturedsurface.TexturedSurfaceModule;
import org.citygml4j.model.citygml.transportation.TransportationModule;
import org.citygml4j.model.citygml.vegetation.VegetationModule;
import org.citygml4j.model.citygml.waterbody.WaterBodyModule;

public class CityGMLModules {
	private final static LinkedHashMap<CityGMLModuleType, CityGMLModule[]> modulesMap;
	
	static {
		modulesMap = new LinkedHashMap<CityGMLModuleType, CityGMLModule[]>();		
		modulesMap.put(CityGMLModuleType.CORE, CoreModule.values());
		modulesMap.put(CityGMLModuleType.APPEARANCE, AppearanceModule.values());
		modulesMap.put(CityGMLModuleType.BUILDING, BuildingModule.values());
		modulesMap.put(CityGMLModuleType.CITYFURNITURE, CityFurnitureModule.values());
		modulesMap.put(CityGMLModuleType.CITYOBJECTGROUP, CityObjectGroupModule.values());
		modulesMap.put(CityGMLModuleType.GENERICS, GenericsModule.values());
		modulesMap.put(CityGMLModuleType.LANDUSE, LandUseModule.values());
		modulesMap.put(CityGMLModuleType.RELIEF, ReliefModule.values());
		modulesMap.put(CityGMLModuleType.TRANSPORTATION, TransportationModule.values());
		modulesMap.put(CityGMLModuleType.VEGETATION, VegetationModule.values());
		modulesMap.put(CityGMLModuleType.WATERBODY, WaterBodyModule.values());
		modulesMap.put(CityGMLModuleType.TEXTUREDSURFACE, TexturedSurfaceModule.values());
	}
	
	public static CityGMLModule getModuleByNamespaceUri(String namespaceUri) {
		// shortcut for CityGML v0.4.0
		if (namespaceUri.equals(CoreModule.v0_4_0.getNamespaceUri()))
			return CoreModule.v0_4_0;

		for (CityGMLModuleType type : modulesMap.keySet()) {
			for (CityGMLModule module : modulesMap.get(type)) {
				if (module.getModuleVersion() == CityGMLModuleVersion.v0_4_0)
					continue;

				if (namespaceUri.equals(module.getNamespaceUri()))
					return module;
			}
		}

		return null;
	}
	
	public static CityGMLModule getModuleByTypeAndVersion(CityGMLModuleType type, CityGMLModuleVersion version) {
		for (CityGMLModule module : modulesMap.get(type)) 
			if (module.getModuleVersion() == version)
				return module;
		
		return null;
	}
	
	public static List<CityGMLModule> getModulesByVersion(CityGMLModuleVersion version) {
		List<CityGMLModule> moduleList = new ArrayList<CityGMLModule>();
		
		for (CityGMLModuleType type : modulesMap.keySet())
			for (CityGMLModule module : modulesMap.get(type)) 
				if (module.getModuleVersion() == version)
					moduleList.add(module);
		
		return moduleList;
	}
	
	public static List<CityGMLModuleVersion> getModuleVersion(CityGMLModuleType type) {
		List<CityGMLModuleVersion> versionList = new ArrayList<CityGMLModuleVersion>();
		
		for (CityGMLModule module : modulesMap.get(type)) 
			versionList.add(module.getModuleVersion());
		
		return versionList;
	}
	
	public static List<CityGMLModule> getModules() {
		List<CityGMLModule> moduleList = new ArrayList<CityGMLModule>();
		
		for (CityGMLModuleType type : modulesMap.keySet())
			for (CityGMLModule module : modulesMap.get(type))
				moduleList.add(module);
			
		return moduleList;
	}

}
