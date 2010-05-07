package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.AddressDetails;
import org.citygml4j.model.xal.AddressLongitude;
import org.citygml4j.model.xal.XALClass;

public class AddressLongitudeImpl extends XALBaseImpl implements AddressLongitude {
	private AddressDetails.PostalServiceElements.AddressLongitude addressLongitude;
	
	public AddressLongitudeImpl() {
		addressLongitude = new AddressDetails.PostalServiceElements.AddressLongitude();
	}
	
	public AddressLongitudeImpl(AddressDetails.PostalServiceElements.AddressLongitude addressLongitude) {
		this.addressLongitude = addressLongitude;
	}
	
	@Override
	public AddressDetails.PostalServiceElements.AddressLongitude getJAXBObject() {
		return addressLongitude;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.ADDRESSLONGITUDE;
	}

	public String getContent() {
		return addressLongitude.getContent();
	}

	public String getType() {
		return addressLongitude.getType();
	}

	public void setContent(String content) {
		addressLongitude.setContent(content);
	}

	public void setType(String type) {
		addressLongitude.setType(type);
	}

	public String getCode() {
		return addressLongitude.getCode();
	}
	
	public void setCode(String code) {
		addressLongitude.setCode(code);
	}

	public boolean isSetCode() {
		return addressLongitude.isSetCode();
	}

	public void unsetCode() {
		addressLongitude.setCode(null);
	}

	public boolean isSetContent() {
		return addressLongitude.isSetContent();
	}

	public boolean isSetType() {
		return addressLongitude.isSetType();
	}

	public void unsetContent() {
		addressLongitude.setContent(null);
	}

	public void unsetType() {
		addressLongitude.setType(null);
	}
}
