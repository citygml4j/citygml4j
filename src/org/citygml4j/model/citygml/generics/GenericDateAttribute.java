package org.citygml4j.model.citygml.generics;

import javax.xml.datatype.XMLGregorianCalendar;

public interface GenericDateAttribute extends GenericAttribute {
	public XMLGregorianCalendar getValue();
	public boolean isSetValue();
	
	public void setValue(XMLGregorianCalendar value);
	public void unsetValue();
}
