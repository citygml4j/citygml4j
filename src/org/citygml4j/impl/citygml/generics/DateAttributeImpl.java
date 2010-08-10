package org.citygml4j.impl.citygml.generics;

import java.util.GregorianCalendar;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.generics.DateAttribute;
import org.citygml4j.model.module.citygml.GenericsModule;

public class DateAttributeImpl extends AbstractGenericAttributeImpl implements DateAttribute {
	private GregorianCalendar value;
	
	public DateAttributeImpl() {
		
	}
	
	public DateAttributeImpl(GenericsModule module) {
		super(module);
	}
	
	public GregorianCalendar getValue() {
		return value;
	}

	public boolean isSetValue() {
		return value != null;
	}

	public void setValue(GregorianCalendar value) {
		this.value = value;
	}

	public void unsetValue() {
		value = null;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.DATE_ATTRIBUTE;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new DateAttributeImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		DateAttribute copy = (target == null) ? new DateAttributeImpl() : (DateAttribute)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetValue())
			copy.setValue((GregorianCalendar)copyBuilder.copy(value));
		
		return copy;
	}

}
