package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface Value extends GML, Child, Copyable {
	public ValueObject getValueObject();
	public AbstractGML getGMLObject();
	public GenericValueObject getGenericValueObject();
	public Null getNull();
	public boolean isSetValueObject();
	public boolean isSetGMLObject();
	public boolean isSetGenericValueObject();
	public boolean isSetNull();
	
	public void setValueObject(ValueObject valueObject);
	public void setGMLObject(AbstractGML gmlObject);
	public void setGenericValueObject(GenericValueObject genericValueObject);
	public void setNull(Null _null);
	public void unsetValueObject();
	public void unsetGMLObject();
	public void unsetGenericValueObject();
	public void unsetNull();
}
