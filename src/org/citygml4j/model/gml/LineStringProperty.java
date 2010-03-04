package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface LineStringProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public LineString getLineString();
	public boolean isSetLineString();
	
	public void setLineString(LineString lineString);
	public void unsetLineString();
}
