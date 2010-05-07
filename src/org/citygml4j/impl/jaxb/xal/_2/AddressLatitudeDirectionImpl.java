package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.AddressDetails;
import org.citygml4j.model.xal.AddressLatitudeDirection;
import org.citygml4j.model.xal.XALClass;

public class AddressLatitudeDirectionImpl extends XALBaseImpl implements AddressLatitudeDirection {
	private AddressDetails.PostalServiceElements.AddressLatitudeDirection addressLatitudeDirection;
	
	public AddressLatitudeDirectionImpl() {
		addressLatitudeDirection = new AddressDetails.PostalServiceElements.AddressLatitudeDirection();
	}
	
	public AddressLatitudeDirectionImpl(AddressDetails.PostalServiceElements.AddressLatitudeDirection addressLatitudeDirection) {
		this.addressLatitudeDirection = addressLatitudeDirection;
	}
	
	@Override
	public AddressDetails.PostalServiceElements.AddressLatitudeDirection getJAXBObject() {
		return addressLatitudeDirection;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.ADDRESSLATITUDEDIRECTION;
	}

	public String getContent() {
		return addressLatitudeDirection.getContent();
	}

	public String getType() {
		return addressLatitudeDirection.getType();
	}

	public void setContent(String content) {
		addressLatitudeDirection.setContent(content);
	}

	public void setType(String type) {
		addressLatitudeDirection.setType(type);
	}

	public String getCode() {
		return addressLatitudeDirection.getCode();
	}

	public void setCode(String code) {
		addressLatitudeDirection.setCode(code);
	}

	public boolean isSetContent() {
		return addressLatitudeDirection.isSetContent();
	}

	public boolean isSetType() {
		return addressLatitudeDirection.isSetType();
	}

	public void unsetContent() {
		addressLatitudeDirection.setContent(null);
	}

	public void unsetType() {
		addressLatitudeDirection.setType(null);
	}

	public boolean isSetCode() {
		return addressLatitudeDirection.isSetCode();
	}

	public void unsetCode() {
		addressLatitudeDirection.setCode(null);
	}

}
