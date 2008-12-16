package org.citygml4j.model.citygml;

import java.util.ArrayList;
import java.util.List;

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

public enum CityGMLModuleType {
	CORE("Core", CoreModule.values()),
	APPEARANCE("Appearance", AppearanceModule.values()),
	BUILDING("Building", BuildingModule.values()),
	CITYFURNITURE("CityFurniture", CityFurnitureModule.values()),
	CITYOBJECTGROUP("CityObjectGroup", CityObjectGroupModule.values()),
	GENERICS("Generics", GenericsModule.values()),
	LANDUSE("LandUse", LandUseModule.values()),
	RELIEF("Relief", ReliefModule.values()),
	TRANSPORTATION("Transportation", TransportationModule.values()),
	VEGETATION("Vegetation", VegetationModule.values()),
	WATERBODY("WaterBody", WaterBodyModule.values()),
	TEXTUREDSURFACE("TexturedSurface", TexturedSurfaceModule.values());

	private final String value;
	private final CityGMLModule[] modules;

	CityGMLModuleType(String value, CityGMLModule[] modules) {
		this.value = value;
		this.modules = modules;
	}

	public String value() {
		return value;
	}

	public String toString() {
		return value;
	}

	public static CityGMLModule getModuleByNamespaceUri(String namespaceUri) {
		// shortcut for CityGML v0.4.0
		if (namespaceUri.equals(CoreModule.v0_4_0.getNamespaceUri()))
			return CoreModule.v0_4_0;

		for (CityGMLModuleType type : values()) {
			for (CityGMLModule module : type.modules) {
				if (module.getModuleVersion() == CityGMLModuleVersion.v0_4_0)
					continue;

				if (namespaceUri.equals(module.getNamespaceUri()))
					return module;
			}
		}

		return null;
	}
	
	public static CityGMLModule getModuleByTypeAndVersion(CityGMLModuleType type, CityGMLModuleVersion version) {
		for (CityGMLModule module : type.modules) 
			if (module.getModuleVersion() == version)
				return module;
		
		return null;
	}
	
	public static List<CityGMLModule> getModulesByVersion(CityGMLModuleVersion version) {
		List<CityGMLModule> moduleList = new ArrayList<CityGMLModule>();
		
		for (CityGMLModuleType type : values())
			for (CityGMLModule module : type.modules) 
				if (module.getModuleVersion() == version)
					moduleList.add(module);
		
		return moduleList;
	}
	
	public static List<CityGMLModuleVersion> getModuleVersion(CityGMLModuleType type) {
		List<CityGMLModuleVersion> versionList = new ArrayList<CityGMLModuleVersion>();
		
		for (CityGMLModule module : type.modules) 
			versionList.add(module.getModuleVersion());
		
		return versionList;
	}
	
	public static List<CityGMLModule> getModules() {
		List<CityGMLModule> moduleList = new ArrayList<CityGMLModule>();
		
		for (CityGMLModuleType type : values())
			for (CityGMLModule module : type.modules)
				moduleList.add(module);
			
		return moduleList;
	}
}
