package org.citygml4j.model.citygml.building;

import org.citygml4j.model.gml.Association;

public interface OpeningProperty extends BuildingModuleComponent, Association<Opening> {
	public Opening getOpening();
	public boolean isSetOpening();
	
	public void setOpening(Opening opening);
	public void unsetOpening();
}
