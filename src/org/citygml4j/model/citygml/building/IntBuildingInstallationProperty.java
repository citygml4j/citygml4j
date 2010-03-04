package org.citygml4j.model.citygml.building;

import org.citygml4j.model.gml.Association;

public interface IntBuildingInstallationProperty extends BuildingModuleComponent, Association<IntBuildingInstallation> {
	public IntBuildingInstallation getIntBuildingInstallation();
	public boolean isSetIntBuildingInstallation();
	
	public void setIntBuildingInstallation(IntBuildingInstallation intBuildingInstallation);
	public void unsetIntBuildingInstallation();
}
