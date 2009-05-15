package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.AddressDetails;
import org.citygml4j.model.xal.AddressLongitudeDirection;
import org.citygml4j.model.xal.XALClass;

public class AddressLongitudeDirectionImpl extends XALBaseImpl implements AddressLongitudeDirection {
	private AddressDetails.PostalServiceElements.AddressLongitudeDirection addressLongitudeDirection;
	
	public AddressLongitudeDirectionImpl() {
		addressLongitudeDirection = new AddressDetails.PostalServiceElements.AddressLongitudeDirection();
	}
	
	public AddressLongitudeDirectionImpl(AddressDetails.PostalServiceElements.AddressLongitudeDirection addressLongitudeDirection) {
		this.addressLongitudeDirection = addressLongitudeDirection;
	}
	
	@Override
	public AddressDetails.PostalServiceElements.AddressLongitudeDirection getJAXBObject() {
		return addressLongitudeDirection;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.ADDRESSLATITUDEDIRECTION;
	}

	public String getContent() {
		return addressLongitudeDirection.getContent();
	}

	public String getType() {
		return addressLongitudeDirection.getType();
	}

	public void setContent(String content) {
		addressLongitudeDirection.setContent(content);
	}

	public void setType(String type) {
		addressLongitudeDirection.setType(type);
	}

	public String getCode() {
		return addressLongitudeDirection.getCode();
	}

	public void setCode(String code) {
		addressLongitudeDirection.setCode(code);
	}

	public boolean isSetCode() {
		return addressLongitudeDirection.isSetCode();
	}

	public void unsetCode() {
		addressLongitudeDirection.setCode(null);
	}

	public boolean isSetContent() {
		return addressLongitudeDirection.isSetContent();
	}

	public boolean isSetType() {
		return addressLongitudeDirection.isSetType();
	}

	public void unsetContent() {
		addressLongitudeDirection.setContent(null);
	}

	public void unsetType() {
		addressLongitudeDirection.setType(null);
	}

}
