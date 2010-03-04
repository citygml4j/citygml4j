package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface MultiPointProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public MultiPoint getMultiPoint();
	public boolean isSetMultiPoint();
	
	public void setMultiPoint(MultiPoint multiPoint);
	public void unsetMultiPoint();
}
