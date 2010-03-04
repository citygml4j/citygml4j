package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface MultiSolidProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public MultiSolid getMultiSolid();
	public boolean isSetMultiSolid();
	
	public void setMultiSolid(MultiSolid multiSolid);
	public void unsetMultiSolid();
}
