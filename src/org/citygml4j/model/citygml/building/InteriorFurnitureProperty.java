package org.citygml4j.model.citygml.building;

import org.citygml4j.model.gml.Association;

public interface InteriorFurnitureProperty extends BuildingModuleComponent, Association<BuildingFurniture> {
	public BuildingFurniture getBuildingFurniture();
	public boolean isSetBuildingFurniture();
	
	public void setBuildingFurniture(BuildingFurniture buildingFurniture);
	public void unsetBuildingFurniture();
}
