package org.citygml4j.impl.jaxb.citygml.core._1;

import org.citygml4j.impl.jaxb.xal._2.AddressDetailsImpl;
import org.citygml4j.jaxb.citygml.core._1.XalAddressPropertyType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.citygml.core.XalAddressProperty;
import org.citygml4j.model.xal.AddressDetails;

public class XalAddressPropertyImpl extends CityGMLBaseImpl implements XalAddressProperty {
	private XalAddressPropertyType xalAddressPropertyType;
	
	public XalAddressPropertyImpl() {
		xalAddressPropertyType = new XalAddressPropertyType();
	}
	
	public XalAddressPropertyImpl(XalAddressPropertyType xalAddressPropertyType) {
		this.xalAddressPropertyType = xalAddressPropertyType;
	}
	
	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.XALADDRESSPROPERTYTYPE;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return CoreModule.v1_0_0;
	}
	
	@Override
	public XalAddressPropertyType getJAXBObject() {
		return xalAddressPropertyType;
	}

	public AddressDetails getAddressDetails() {
		if (xalAddressPropertyType.isSetAddressDetails())
			return new AddressDetailsImpl(xalAddressPropertyType.getAddressDetails());
		
		return null;
	}

	public void setAddressDetails(AddressDetails addressDetails) {
		xalAddressPropertyType.setAddressDetails(((AddressDetailsImpl)addressDetails).getJAXBObject());
	}

	public boolean isSetAddressDetails() {
		return xalAddressPropertyType.isSetAddressDetails();
	}

	public void unsetAddressDetails() {
		xalAddressPropertyType.setAddressDetails(null);
	}
}
