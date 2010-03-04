package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface GeometryProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public AbstractGeometry getGeometry();
	public boolean isSetGeometry();

	public void setGeometry(AbstractGeometry geometry);
	public void unsetGeometry();
}
