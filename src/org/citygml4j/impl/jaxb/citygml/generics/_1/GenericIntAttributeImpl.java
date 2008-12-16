package org.citygml4j.impl.jaxb.citygml.generics._1;

import java.math.BigInteger;

import org.citygml4j.jaxb.citygml.gen._1.IntAttributeType;
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

	@Override
	public Integer getValue() {
		return new Integer(intAttributeType.getValue().intValue());
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INTATTRIBUTE;
	}

	@Override
	public void setValue(Integer value) {
		intAttributeType.setValue(new BigInteger(value.toString()));
	}

	@Override
	public boolean isSetValue() {
		return intAttributeType.isSetValue();
	}

	@Override
	public void unsetValue() {
		intAttributeType.setValue(null);
	}
}
