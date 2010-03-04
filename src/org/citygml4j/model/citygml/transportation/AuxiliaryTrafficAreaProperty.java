package org.citygml4j.model.citygml.transportation;

import org.citygml4j.model.gml.Association;

public interface AuxiliaryTrafficAreaProperty extends TransportationModuleComponent, Association<AuxiliaryTrafficArea> {
	public AuxiliaryTrafficArea getAuxiliaryTrafficArea();
	public boolean isSetAuxiliaryTrafficArea();
	
	public void setAuxiliaryTrafficArea(AuxiliaryTrafficArea auxiliaryTrafficArea);
	public void unsetAuxiliaryTrafficArea();
}
