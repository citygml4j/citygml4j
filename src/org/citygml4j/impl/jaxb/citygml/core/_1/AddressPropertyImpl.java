package org.citygml4j.impl.jaxb.citygml.core._1;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.gml._3_1_1.AssociationImpl;
import org.citygml4j.jaxb.citygml.core._1.AddressPropertyType;
import org.citygml4j.jaxb.citygml.core._1.AddressType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.citygml.core.CoreModule;

public class AddressPropertyImpl extends AssociationImpl<Address> implements AddressProperty {
	private AddressPropertyType addressPropertyType;
	
	public AddressPropertyImpl() {
		this(new AddressPropertyType());
	}
	
	public AddressPropertyImpl(AddressPropertyType addressPropertyType) {
		super(addressPropertyType);
		this.addressPropertyType = addressPropertyType;
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ADDRESSPROPERTY;
	}
	
	public final CityGMLModule getCityGMLModule() {
		return CoreModule.v1_0_0;
	}

	@Override
	public AddressPropertyType getJAXBObject() {
		return addressPropertyType;
	}

	public Address getObject() {
		if (addressPropertyType.get_Object() != null) {
			JAXBElement<?> elem = addressPropertyType.get_Object();
			if (elem.getValue() != null && elem.getValue() instanceof AddressType)
				return new AddressImpl((AddressType)elem.getValue());
		}
			
		return null;
	}

	public void setObject(Address object) {
		addressPropertyType.set_Object(ObjectFactory.CORE_1.createAddress(((AddressImpl)object).getJAXBObject()));
	}

}
