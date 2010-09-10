package org.citygml4j.model.citygml.building;

import org.citygml4j.model.gml.feature.FeatureProperty;

public interface InteriorFurnitureProperty extends BuildingModuleComponent, FeatureProperty<BuildingFurniture> {
	public BuildingFurniture getBuildingFurniture();
	public boolean isSetBuildingFurniture();
	
	public void setBuildingFurniture(BuildingFurniture buildingFurniture);
	public void unsetBuildingFurniture();
}
