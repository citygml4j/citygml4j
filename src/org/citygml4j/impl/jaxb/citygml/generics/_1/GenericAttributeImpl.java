package org.citygml4j.impl.jaxb.citygml.generics._1;

import org.citygml4j.impl.jaxb.citygml.core._1.CityGMLBaseImpl;
import org.citygml4j.jaxb.citygml.gen._1.AbstractGenericAttributeType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.generics.GenericAttribute;
import org.citygml4j.model.citygml.generics.GenericsModule;

public abstract class GenericAttributeImpl extends CityGMLBaseImpl implements GenericAttribute {
	private AbstractGenericAttributeType genericAttributeType;

	public GenericAttributeImpl(AbstractGenericAttributeType genericAttributeType) {
		this.genericAttributeType = genericAttributeType;
	}

	@Override
	public AbstractGenericAttributeType getJAXBObject() {
		return genericAttributeType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.GENERICATTRIBUTE;
	}

	@Override
	public String getName() {
		return genericAttributeType.getName();
	}

	@Override
	public void setName(String name) {
		genericAttributeType.setName(name);
	}
	
	@Override
	public final CityGMLModule getCityGMLModule() {
		return GenericsModule.v1_0_0;
	}

	@Override
	public boolean isSetName() {
		return genericAttributeType.isSetName();
	}

	@Override
	public void unsetName() {
		genericAttributeType.setName(null);
	}
}
