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

	@Override
	public String getContent() {
		return addressLongitude.getContent();
	}

	@Override
	public String getType() {
		return addressLongitude.getType();
	}

	@Override
	public void setContent(String content) {
		addressLongitude.setContent(content);
	}

	@Override
	public void setType(String type) {
		addressLongitude.setType(type);
	}

	@Override
	public String getCode() {
		return addressLongitude.getCode();
	}
	
	@Override
	public void setCode(String code) {
		addressLongitude.setCode(code);
	}

	@Override
	public boolean isSetCode() {
		return addressLongitude.isSetCode();
	}

	@Override
	public void unsetCode() {
		addressLongitude.setCode(null);
	}

	@Override
	public boolean isSetContent() {
		return addressLongitude.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return addressLongitude.isSetType();
	}

	@Override
	public void unsetContent() {
		addressLongitude.setContent(null);
	}

	@Override
	public void unsetType() {
		addressLongitude.setType(null);
	}
}
