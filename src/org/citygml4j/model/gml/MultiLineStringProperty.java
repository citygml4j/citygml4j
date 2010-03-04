package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface MultiLineStringProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public MultiLineString getMultiLineString();
	public boolean isSetMultiLineString();
	
	public void setMultiLineString(MultiLineString multiLineString);
	public void unsetMultiLineString();
}
