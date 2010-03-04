package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface SolidProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public AbstractSolid getSolid();
	public boolean isSetSolid();
	
	public void setSolid(AbstractSolid abstractSolid);
	public void unsetSolid();
}
