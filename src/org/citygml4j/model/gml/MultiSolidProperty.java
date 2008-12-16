package org.citygml4j.model.gml;

public interface MultiSolidProperty extends GMLBase, AssociationAttributeGroup {
	public MultiSolid getMultiSolid();
	public boolean isSetMultiSolid();
	
	public void setMultiSolid(MultiSolid multiSolid);
	public void unsetMultiSolid();
}
