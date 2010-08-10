package org.citygml4j.model.citygml.building;

import org.citygml4j.model.gml.feature.FeatureProperty;

public interface OpeningProperty extends BuildingModuleComponent, FeatureProperty<AbstractOpening> {
	public AbstractOpening getOpening();
	public boolean isSetOpening();
	
	public void setOpening(AbstractOpening opening);
	public void unsetOpening();
}
