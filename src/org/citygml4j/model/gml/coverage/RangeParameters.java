package org.citygml4j.model.gml.coverage;

import org.citygml4j.model.gml.base.AssociationByRepOrRef;
import org.citygml4j.model.gml.valueObjects.ValueObject;


public interface RangeParameters extends AssociationByRepOrRef<ValueObject> {
	public ValueObject getValueObject();
	public boolean isSetValueObject();
	
	public void setValueObject(ValueObject valueObject);
	public void unsetValueObject();
}
