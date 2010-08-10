package org.citygml4j.model.citygml.building;

import org.citygml4j.model.gml.feature.FeatureProperty;

public interface BuildingInstallationProperty extends BuildingModuleComponent, FeatureProperty<BuildingInstallation> {
	public BuildingInstallation getBuildingInstallation();
	public boolean isSetBuildingInstallation();
	
	public void setBuildingInstallation(BuildingInstallation buildingInstallation);
	public void unsetBuildingInstallation();
}
