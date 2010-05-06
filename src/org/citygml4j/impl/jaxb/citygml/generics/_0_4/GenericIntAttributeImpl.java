package org.citygml4j.impl.jaxb.citygml.generics._0_4;

import java.math.BigInteger;

import org.citygml4j.jaxb.citygml._0_4.IntAttributeType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.generics.GenericIntAttribute;

public class GenericIntAttributeImpl extends GenericAttributeImpl implements GenericIntAttribute {
	private IntAttributeType intAttributeType;

	public GenericIntAttributeImpl() {
		this(new IntAttributeType());
	}

	public GenericIntAttributeImpl(IntAttributeType intAttributeType) {
		super(intAttributeType);
		this.intAttributeType = intAttributeType;
	}

	@Override
	public IntAttributeType getJAXBObject() {
		return intAttributeType;
	}

	public Integer getValue() {
		return new Integer(intAttributeType.getValue().intValue());
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INTATTRIBUTE;
	}

	public void setValue(Integer value) {
		intAttributeType.setValue(new BigInteger(value.toString()));
	}

	public boolean isSetValue() {
		return intAttributeType.isSetValue();
	}

	public void unsetValue() {
		intAttributeType.setValue(null);
	}
}
