package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.gml.MultiSurfaceProperty;
import org.citygml4j.model.gml.SolidProperty;

public interface Room extends BuildingModuleComponent, CityObject {
	public String getClazz();
	public List<String> getFunction();
	public List<String> getUsage();
	public List<BoundarySurfaceProperty> getBoundedBySurface();
	public List<InteriorFurnitureProperty> getInteriorFurniture();
	public List<IntBuildingInstallationProperty> getRoomInstallation();
	public SolidProperty getLod4Solid();
	public MultiSurfaceProperty getLod4MultiSurface();
	public List<ADEComponent> getGenericApplicationPropertyOfRoom();
	public boolean isSetClazz();
	public boolean isSetFunction();
	public boolean isSetUsage();
	public boolean isSetBoundedBySurface();
	public boolean isSetInteriorFurniture();
	public boolean isSetRoomInstallation();
	public boolean isSetLod4Solid();
	public boolean isSetLod4MultiSurface();
	public boolean isSetGenericApplicationPropertyOfRoom();
	
	public void setClazz(String clazz);
	public void setFunction(List<String> function);
	public void addFunction(String function);
	public void setUsage(List<String> usage);
	public void addUsage(String usage);
	public void setRoomInstallation(List<IntBuildingInstallationProperty> roomInstallation);
	public void addRoomInstallation(IntBuildingInstallationProperty roomInstallation);
	public void setBoundedBySurface(List<BoundarySurfaceProperty> boundedBySurface);
	public void addBoundedBySurface(BoundarySurfaceProperty boundedBySurface);
	public void addInteriorFurniture(InteriorFurnitureProperty interiorFurniture);
	public void setInteriorFurniture(List<InteriorFurnitureProperty> interiorFurniture);
	public void setLod4Solid(SolidProperty lod4Solid);
	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface);	
	public void addGenericApplicationPropertyOfRoom(ADEComponent ade);
	public void setGenericApplicationPropertyOfRoom(List<ADEComponent> ade);
	public void unsetClazz();
	public void unsetFunction();
	public boolean unsetFunction(String function);
	public void unsetUsage();
	public boolean unsetUsage(String usage);
	public void unsetBoundedBySurface();
	public boolean unsetBoundedBySurface(BoundarySurfaceProperty boundedBySurface);
	public void unsetInteriorFurniture();
	public boolean unsetInteriorFurniture(InteriorFurnitureProperty interiorFurniture);
	public void unsetRoomInstallation();
	public boolean unsetRoomInstallation(IntBuildingInstallationProperty roomInstallation);
	public void unsetLod4Solid();
	public void unsetLod4MultiSurface();
	public void unsetGenericApplicationPropertyOfRoom();
	public boolean unsetGenericApplicationPropertyOfRoom(ADEComponent ade);
}
