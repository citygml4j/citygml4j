package org.citygml4j.impl.jaxb.citygml.generics._1;

import org.citygml4j.jaxb.citygml.gen._1.StringAttributeType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.generics.GenericStringAttribute;

public class GenericStringAttributeImpl extends GenericAttributeImpl implements	GenericStringAttribute {
	private StringAttributeType stringAttributeType;

	public GenericStringAttributeImpl() {
		this(new StringAttributeType());
	}

	public GenericStringAttributeImpl(StringAttributeType stringAttributeType) {
		super(stringAttributeType);
		this.stringAttributeType = stringAttributeType;
	}

	@Override
	public StringAttributeType getJAXBObject() {
		return stringAttributeType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.STRINGATTRIBUTE;
	}

	public String getValue() {
		return stringAttributeType.getValue();
	}

	public void setValue(String value) {
		stringAttributeType.setValue(value);
	}

	public boolean isSetValue() {
		return stringAttributeType.isSetValue();
	}

	public void unsetValue() {
		stringAttributeType.setValue(null);
	}
}
