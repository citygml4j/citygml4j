package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.AddressDetails;
import org.citygml4j.model.xal.AddressLatitude;
import org.citygml4j.model.xal.XALClass;

public class AddressLatitudeImpl extends XALBaseImpl implements AddressLatitude {
	private AddressDetails.PostalServiceElements.AddressLatitude addressLatitude;
	
	public AddressLatitudeImpl() {
		addressLatitude = new AddressDetails.PostalServiceElements.AddressLatitude();
	}
	
	public AddressLatitudeImpl(AddressDetails.PostalServiceElements.AddressLatitude addressLatitude) {
		this.addressLatitude = addressLatitude;
	}
	
	@Override
	public AddressDetails.PostalServiceElements.AddressLatitude getJAXBObject() {
		return addressLatitude;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.ADDRESSLATITUDE;
	}

	public String getContent() {
		return addressLatitude.getContent();
	}

	public String getType() {
		return addressLatitude.getType();
	}

	public void setContent(String content) {
		addressLatitude.setContent(content);
	}

	public void setType(String type) {
		addressLatitude.setType(type);
	}

	public String getCode() {
		return addressLatitude.getCode();
	}

	public void setCode(String code) {
		addressLatitude.setCode(code);
	}

	public boolean isSetContent() {
		return addressLatitude.isSetContent();
	}

	public boolean isSetType() {
		return addressLatitude.isSetType();
	}

	public void unsetContent() {
		addressLatitude.setContent(null);
	}

	public void unsetType() {
		addressLatitude.setType(null);
	}

	public boolean isSetCode() {
		return addressLatitude.isSetCode();
	}

	public void unsetCode() {
		addressLatitude.setCode(null);
	}

}
