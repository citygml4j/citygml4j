package org.citygml4j.model.gml.valueObjects;

import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.base.Associable;
import org.citygml4j.model.gml.basicTypes.Null;
import org.citygml4j.model.gml.geometry.AbstractGeometry;


public interface Value extends GML, Associable {
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
