package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface RangeParameters extends GML, AssociationAttributeGroup, Child, Copyable {
	public ValueObject getValueObject();
	public boolean isSetValueObject();
	
	public void setValueObject(ValueObject valueObject);
	public void unsetValueObject();
}
