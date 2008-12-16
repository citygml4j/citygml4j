package org.citygml4j.model.gml;

public interface SolidProperty extends GMLBase, AssociationAttributeGroup {
	public AbstractSolid getSolid();
	public boolean isSetSolid();
	
	public void setSolid(AbstractSolid abstractSolid);
	public void unsetSolid();
}
