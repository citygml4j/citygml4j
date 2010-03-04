package org.citygml4j.impl.citygml.generics;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.generics.StringAttribute;
import org.citygml4j.model.module.citygml.GenericsModule;

public class StringAttributeImpl extends GenericAttributeImpl implements StringAttribute {
	private String value;
	
	public StringAttributeImpl() {

	}

	public StringAttributeImpl(GenericsModule module) {
		super(module);
	}
	
	public String getValue() {
		return value;
	}

	public boolean isSetValue() {
		return value != null;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void unsetValue() {
		value = null;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.STRINGATTRIBUTE;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new StringAttributeImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		StringAttribute copy = (target == null) ? new StringAttributeImpl() : (StringAttribute)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetValue())
			copy.setValue(copyBuilder.copy(value));
		
		return copy;
	}

}
