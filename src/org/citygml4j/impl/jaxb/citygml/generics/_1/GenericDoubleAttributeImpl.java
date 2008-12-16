package org.citygml4j.impl.jaxb.citygml.generics._1;

import org.citygml4j.jaxb.citygml.gen._1.DoubleAttributeType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.generics.GenericDoubleAttribute;

public class GenericDoubleAttributeImpl extends GenericAttributeImpl implements	GenericDoubleAttribute {
	private DoubleAttributeType doubleAttributeType;

	public GenericDoubleAttributeImpl() {
		this(new DoubleAttributeType());
	}

	public GenericDoubleAttributeImpl(DoubleAttributeType doubleAttributeType) {
		super(doubleAttributeType);
		this.doubleAttributeType = doubleAttributeType;
	}

	@Override
	public DoubleAttributeType getJAXBObject() {
		return doubleAttributeType;
	}

	@Override
	public Double getValue() {
		return new Double(doubleAttributeType.getValue());
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.DOUBLEATTRIBUTE;
	}

	@Override
	public void setValue(Double value) {
		doubleAttributeType.setValue(value);
	}

	@Override
	public boolean isSetValue() {
		return doubleAttributeType.isSetValue();
	}

	@Override
	public void unsetValue() {
		doubleAttributeType.setValue(null);
	}
}
