package org.citygml4j.model.citygml.building;

import org.citygml4j.model.gml.feature.FeatureProperty;

public interface BuildingPartProperty extends BuildingModuleComponent, FeatureProperty<BuildingPart> {
	public BuildingPart getBuildingPart();
	public boolean isSetBuildingPart();
	
	public void setBuildingPart(BuildingPart buildingPart);
	public void unsetBuildingPart();
}
