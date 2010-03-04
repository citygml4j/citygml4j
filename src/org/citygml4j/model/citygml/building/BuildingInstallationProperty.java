package org.citygml4j.model.citygml.building;

import org.citygml4j.model.gml.Association;

public interface BuildingInstallationProperty extends BuildingModuleComponent, Association<BuildingInstallation> {
	public BuildingInstallation getBuildingInstallation();
	public boolean isSetBuildingInstallation();
	
	public void setBuildingInstallation(BuildingInstallation buildingInstallation);
	public void unsetBuildingInstallation();
}
