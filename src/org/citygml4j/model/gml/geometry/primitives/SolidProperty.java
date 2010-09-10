package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface SolidProperty extends GeometryProperty<AbstractSolid> {
	public AbstractSolid getSolid();
	public boolean isSetSolid();
	
	public void setSolid(AbstractSolid abstractSolid);
	public void unsetSolid();
}
