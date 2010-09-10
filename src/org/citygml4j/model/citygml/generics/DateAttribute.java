package org.citygml4j.model.citygml.generics;

import java.util.GregorianCalendar;

public interface DateAttribute extends AbstractGenericAttribute {
	public GregorianCalendar getValue();
	public boolean isSetValue();
	
	public void setValue(GregorianCalendar value);
	public void unsetValue();
}
