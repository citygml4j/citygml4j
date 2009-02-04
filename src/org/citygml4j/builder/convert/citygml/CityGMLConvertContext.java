package org.citygml4j.builder.convert.citygml;

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
import org.citygml4j.util.CityGMLModules;

public class CityGMLConvertContext {
	protected AppearanceModule appModule;
	protected BuildingModule bldgModule;
	protected CityFurnitureModule frnModule;
	protected CityObjectGroupModule grpModule;
	protected CoreModule coreModule;
	protected GenericsModule genModule;
	protected LandUseModule luseModule;
	protected ReliefModule demModule;
	protected TexturedSurfaceModule texModule;
	protected TransportationModule tranModule;
	protected VegetationModule vegModule;
	protected WaterBodyModule wtrModule;	
	
	public CityGMLConvertContext() {
		this(CityGMLModuleVersion.v1_0_0);
	}
	
	public CityGMLConvertContext(CityGMLModuleVersion version) {
		switch (version) {
		case v0_4_0:
			init(version);
			break;
		default:
			init(CityGMLModuleVersion.v1_0_0);
		}
	}
	
	public boolean setModuleVersion(CityGMLModuleVersion version) {
		switch (version) {
		case v0_4_0:
		case v1_0_0:
			init(version);
			return true;
		default:
			return false;
		}
	}
	
	public AppearanceModule getAppearanceModule() {
		return appModule;
	}

	public boolean setAppearanceModule(AppearanceModule appearanceModule) {
		boolean isValid = checkModuleDependencies(appearanceModule);
		if (isValid)
			appModule = appearanceModule;
		
		return isValid;
	}
	
	public BuildingModule getBuildingModule() {
		return bldgModule;
	}
	
	public boolean setBuildingModule(BuildingModule buildingModule) {
		boolean isValid = checkModuleDependencies(buildingModule);
		if (isValid)
			bldgModule = buildingModule;
		
		return isValid;
	}

	public CityFurnitureModule getCityFurnitureModule() {
		return frnModule;
	}

	public boolean setCityFurnitureModule(CityFurnitureModule cityFurnitureModule) {
		boolean isValid = checkModuleDependencies(cityFurnitureModule);
		if (isValid) 
			frnModule = cityFurnitureModule;
		
		return isValid;
	}
	
	public CityObjectGroupModule getCityObjectGroupModule() {
		return grpModule;
	}

	public boolean setCityObjectGroupModule(CityObjectGroupModule cityObjectGroupModule) {
		boolean isValid = checkModuleDependencies(cityObjectGroupModule);
		if (isValid)
			grpModule = cityObjectGroupModule;
		
		return isValid;
	}
	
	public CoreModule getCoreModule() {
		return coreModule;
	}

	public GenericsModule getGenericsModule() {
		return genModule;
	}
	
	public boolean setGenericsModule(GenericsModule genericsModule) {
		boolean isValid = checkModuleDependencies(genericsModule);
		if (isValid)
			genModule = genericsModule;
		
		return isValid;
	}

	public LandUseModule getLandUseModule() {
		return luseModule;
	}
	
	public boolean setLandUseModule(LandUseModule landUseModule) {
		boolean isValid = checkModuleDependencies(landUseModule);
		if (isValid)
			luseModule = landUseModule;
		
		return isValid;
	}
	
	public ReliefModule getReliefModule() {
		return demModule;
	}
	
	public boolean setReliefModule(ReliefModule reliefModule) {
		boolean isValid = checkModuleDependencies(reliefModule);
		if (isValid)
			demModule = reliefModule;
		
		return isValid;
	}

	public TexturedSurfaceModule getTexturedSurfaceModule() {
		return texModule;
	}
	
	public boolean setTexturedSurfaceModule(TexturedSurfaceModule texturedSurfaceModule) {
		boolean isValid = checkModuleDependencies(texturedSurfaceModule);
		if (isValid)
			texModule = texturedSurfaceModule;
		
		return isValid;
	}

	public TransportationModule getTransportationModule() {
		return tranModule;
	}
	
	public boolean setTransportationModule(TransportationModule transportationModule) {
		boolean isValid = checkModuleDependencies(transportationModule);
		if (isValid)
			tranModule = transportationModule;
		
		return isValid;
	}

	public VegetationModule getVegetationModule() {
		return vegModule;
	}
	
	public boolean setVegetationModule(VegetationModule vegetationModule) {
		boolean isValid = checkModuleDependencies(vegetationModule);
		if (isValid)
			vegModule = vegetationModule;
		
		return isValid;
	}

	public WaterBodyModule getWaterBodyModule() {
		return wtrModule;
	}
	
	public boolean setWaterBodyModule(WaterBodyModule waterBodyModule) {
		boolean isValid = checkModuleDependencies(waterBodyModule);
		if (isValid)
			wtrModule = waterBodyModule;
		
		return isValid;
	}
	
	private boolean checkModuleDependencies(CityGMLModule module) {
		boolean success = true;
		
		for (CityGMLModule dependeny : module.getModuleDependencies().getModules()) {
			switch (dependeny.getModuleType()) {
			case APPEARANCE:
				success = dependeny == appModule;
				break;
			case BUILDING:
				success = dependeny == bldgModule;
				break;
			case CITYFURNITURE:
				success = dependeny == frnModule;
				break;
			case CITYOBJECTGROUP:
				success = dependeny == grpModule;
				break;
			case CORE:
				success = dependeny == coreModule;
				break;
			case GENERICS:
				success = dependeny == genModule;
				break;
			case LANDUSE:
				success = dependeny == luseModule;
				break;
			case RELIEF:
				success = dependeny == demModule;
				break;
			case TEXTUREDSURFACE:
				success = dependeny == texModule;
				break;
			case TRANSPORTATION:
				success = dependeny == tranModule;
				break;
			case VEGETATION:
				success = dependeny == vegModule;
				break;
			case WATERBODY:
				success = dependeny == wtrModule;
				break;
			}
			
			if (!success)
				break;
		}
		
		return success;
	}
	
	private void init(CityGMLModuleVersion version) {
		appModule = (AppearanceModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.APPEARANCE, version);
		bldgModule = (BuildingModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.BUILDING, version);
		frnModule = (CityFurnitureModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.CITYFURNITURE, version);
		grpModule = (CityObjectGroupModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.CITYOBJECTGROUP, version);
		coreModule = (CoreModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.CORE, version);
		genModule = (GenericsModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.GENERICS, version);
		luseModule = (LandUseModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.LANDUSE, version);
		demModule = (ReliefModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.RELIEF, version);
		texModule = (TexturedSurfaceModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.TEXTUREDSURFACE, version);
		tranModule = (TransportationModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.TRANSPORTATION, version);
		vegModule = (VegetationModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.VEGETATION, version);
		wtrModule = (WaterBodyModule)CityGMLModules.getModuleByTypeAndVersion(CityGMLModuleType.WATERBODY, version);
	}
}
