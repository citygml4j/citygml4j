package org.citygml4j.impl.jaxb.citygml.generics._0_4;

import javax.xml.datatype.XMLGregorianCalendar;

import org.citygml4j.jaxb.citygml._0_4.DateAttributeType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.generics.GenericDateAttribute;

public class GenericDateAttributeImpl extends GenericAttributeImpl implements GenericDateAttribute {
	private DateAttributeType dateAttributeType;

	public GenericDateAttributeImpl() {
		this(new DateAttributeType());
	}

	public GenericDateAttributeImpl(DateAttributeType dateAttributeType) {
		super(dateAttributeType);
		this.dateAttributeType = dateAttributeType;
	}

	@Override
	public DateAttributeType getJAXBObject() {
		return dateAttributeType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.DATEATTRIBUTE;
	}

	public XMLGregorianCalendar getValue() {
		return dateAttributeType.getValue();
	}

	public void setValue(XMLGregorianCalendar value) {
		dateAttributeType.setValue(value);
	}

	public boolean isSetValue() {
		return dateAttributeType.isSetValue();
	}

	public void unsetValue() {
		dateAttributeType.setValue(null);
	}

}
