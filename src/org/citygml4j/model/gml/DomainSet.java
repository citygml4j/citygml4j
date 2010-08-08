package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface DomainSet extends GML, AssociationAttributeGroup, Child, Copyable {
	// gml:_TimeObject is not implemented since it is not used in CityGML
	public AbstractGeometry getGeometry();
	public boolean isSetGeometry();
	
	public void setGeometry(AbstractGeometry geometry);
	public void unsetGeometry();
}
