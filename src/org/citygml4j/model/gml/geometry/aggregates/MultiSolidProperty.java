package org.citygml4j.model.gml.geometry.aggregates;

import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface MultiSolidProperty extends GeometryProperty<MultiSolid> {
	public MultiSolid getMultiSolid();
	public boolean isSetMultiSolid();
	
	public void setMultiSolid(MultiSolid multiSolid);
	public void unsetMultiSolid();
}
