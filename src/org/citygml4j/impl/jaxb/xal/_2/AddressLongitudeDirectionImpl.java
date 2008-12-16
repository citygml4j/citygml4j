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

	@Override
	public String getContent() {
		return addressLongitudeDirection.getContent();
	}

	@Override
	public String getType() {
		return addressLongitudeDirection.getType();
	}

	@Override
	public void setContent(String content) {
		addressLongitudeDirection.setContent(content);
	}

	@Override
	public void setType(String type) {
		addressLongitudeDirection.setType(type);
	}

	@Override
	public String getCode() {
		return addressLongitudeDirection.getCode();
	}

	@Override
	public void setCode(String code) {
		addressLongitudeDirection.setCode(code);
	}

	@Override
	public boolean isSetCode() {
		return addressLongitudeDirection.isSetCode();
	}

	@Override
	public void unsetCode() {
		addressLongitudeDirection.setCode(null);
	}

	@Override
	public boolean isSetContent() {
		return addressLongitudeDirection.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return addressLongitudeDirection.isSetType();
	}

	@Override
	public void unsetContent() {
		addressLongitudeDirection.setContent(null);
	}

	@Override
	public void unsetType() {
		addressLongitudeDirection.setType(null);
	}

}
