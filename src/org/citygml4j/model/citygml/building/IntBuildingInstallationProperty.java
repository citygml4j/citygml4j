package org.citygml4j.model.citygml.building;

import org.citygml4j.model.gml.feature.FeatureProperty;

public interface IntBuildingInstallationProperty extends BuildingModuleComponent, FeatureProperty<IntBuildingInstallation> {
	public IntBuildingInstallation getIntBuildingInstallation();
	public boolean isSetIntBuildingInstallation();
	
	public void setIntBuildingInstallation(IntBuildingInstallation intBuildingInstallation);
	public void unsetIntBuildingInstallation();
}
