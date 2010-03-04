package org.citygml4j.impl.citygml.generics;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.generics.IntAttribute;
import org.citygml4j.model.module.citygml.GenericsModule;

public class IntAttributeImpl extends GenericAttributeImpl implements IntAttribute {
	private Integer value;
	
	public IntAttributeImpl() {

	}

	public IntAttributeImpl(GenericsModule module) {
		super(module);
	}
	
	public Integer getValue() {
		return value;
	}

	public boolean isSetValue() {
		return value != null;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public void unsetValue() {
		value = null;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INTATTRIBUTE;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new IntAttributeImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		IntAttribute copy = (target == null) ? new IntAttributeImpl() : (IntAttribute)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetValue())
			copy.setValue((Integer)copyBuilder.copy(value));
		
		return copy;
	}

}
