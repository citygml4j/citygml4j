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

	@Override
	public String getContent() {
		return addressLatitude.getContent();
	}

	@Override
	public String getType() {
		return addressLatitude.getType();
	}

	@Override
	public void setContent(String content) {
		addressLatitude.setContent(content);
	}

	@Override
	public void setType(String type) {
		addressLatitude.setType(type);
	}

	@Override
	public String getCode() {
		return addressLatitude.getCode();
	}

	@Override
	public void setCode(String code) {
		addressLatitude.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return addressLatitude.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return addressLatitude.isSetType();
	}

	@Override
	public void unsetContent() {
		addressLatitude.setContent(null);
	}

	@Override
	public void unsetType() {
		addressLatitude.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return addressLatitude.isSetCode();
	}

	@Override
	public void unsetCode() {
		addressLatitude.setCode(null);
	}

}
