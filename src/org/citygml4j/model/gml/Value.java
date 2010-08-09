package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface Value extends GML, Child, Copyable {
	public ValueObject getValueObject();
	public AbstractGeometry getGeometry();
	public GenericValueObject getGenericValueObject();
	public Null getNull();
	public boolean isSetValueObject();
	public boolean isSetGeometry();
	public boolean isSetGenericValueObject();
	public boolean isSetNull();
	
	public void setValueObject(ValueObject valueObject);
	public void setGeometry(AbstractGeometry geometry);
	public void setGenericValueObject(GenericValueObject genericValueObject);
	public void setNull(Null _null);
	public void unsetValueObject();
	public void unsetGeometry();
	public void unsetGenericValueObject();
	public void unsetNull();
}
