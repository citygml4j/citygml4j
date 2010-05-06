package org.citygml4j.impl.jaxb.citygml.generics._0_4;

import org.citygml4j.impl.jaxb.citygml.core._0_4.CityGMLBaseImpl;
import org.citygml4j.jaxb.citygml._0_4._GenericAttributeType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.generics.GenericAttribute;
import org.citygml4j.model.citygml.generics.GenericsModule;

public abstract class GenericAttributeImpl extends CityGMLBaseImpl implements GenericAttribute {
	private _GenericAttributeType genericAttributeType;

	public GenericAttributeImpl(_GenericAttributeType genericAttributeType) {
		this.genericAttributeType = genericAttributeType;
	}

	@Override
	public _GenericAttributeType getJAXBObject() {
		return genericAttributeType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.GENERICATTRIBUTE;
	}

	public String getName() {
		return genericAttributeType.getName();
	}

	public void setName(String name) {
		genericAttributeType.setName(name);
	}
	
	@Override
	public final CityGMLModule getCityGMLModule() {
		return GenericsModule.v0_4_0;
	}

	public boolean isSetName() {
		return genericAttributeType.isSetName();
	}

	public void unsetName() {
		genericAttributeType.setName(null);
	}

}
