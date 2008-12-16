package org.citygml4j.impl.jaxb.citygml.generics._0_4;

import org.citygml4j.jaxb.citygml._0_4.UriAttributeType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.generics.GenericUriAttribute;

public class GenericUriAttributeImpl extends GenericAttributeImpl implements GenericUriAttribute {
	private UriAttributeType uriAttributeType;

	public GenericUriAttributeImpl() {
		this(new UriAttributeType());
	}

	public GenericUriAttributeImpl(UriAttributeType uriAttributeType) {
		super(uriAttributeType);
		this.uriAttributeType = uriAttributeType;
	}

	@Override
	public UriAttributeType getJAXBObject() {
		return uriAttributeType;
	}

	@Override
	public String getValue() {
		return uriAttributeType.getValue();
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.URIATTRIBUTE;
	}

	@Override
	public void setValue(String value) {
		uriAttributeType.setValue(value);
	}

	@Override
	public boolean isSetValue() {
		return uriAttributeType.isSetValue();
	}

	@Override
	public void unsetValue() {
		uriAttributeType.setValue(null);
	}
}
