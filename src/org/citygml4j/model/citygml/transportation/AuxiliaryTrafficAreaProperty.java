package org.citygml4j.model.citygml.transportation;

import org.citygml4j.model.gml.feature.FeatureProperty;

public interface AuxiliaryTrafficAreaProperty extends TransportationModuleComponent, FeatureProperty<AuxiliaryTrafficArea> {
	public AuxiliaryTrafficArea getAuxiliaryTrafficArea();
	public boolean isSetAuxiliaryTrafficArea();
	
	public void setAuxiliaryTrafficArea(AuxiliaryTrafficArea auxiliaryTrafficArea);
	public void unsetAuxiliaryTrafficArea();
}
