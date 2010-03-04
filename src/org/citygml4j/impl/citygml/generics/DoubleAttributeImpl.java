package org.citygml4j.impl.citygml.generics;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.generics.DoubleAttribute;
import org.citygml4j.model.module.citygml.GenericsModule;

public class DoubleAttributeImpl extends GenericAttributeImpl implements DoubleAttribute {
	private Double value;

	public DoubleAttributeImpl() {

	}

	public DoubleAttributeImpl(GenericsModule module) {
		super(module);
	}

	public Double getValue() {
		return value;
	}

	public boolean isSetValue() {
		return value != null;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public void unsetValue() {
		value = null;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.DOUBLEATTRIBUTE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new DoubleAttributeImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		DoubleAttribute copy = (target == null) ? new DoubleAttributeImpl() : (DoubleAttribute)target;
		super.copyTo(copy, copyBuilder);

		if (isSetValue())
			copy.setValue((Double)copyBuilder.copy(value));

		return copy;
	}

}
