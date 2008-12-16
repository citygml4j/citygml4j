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

	@Override
	public String getContent() {
		return addressLatitudeDirection.getContent();
	}

	@Override
	public String getType() {
		return addressLatitudeDirection.getType();
	}

	@Override
	public void setContent(String content) {
		addressLatitudeDirection.setContent(content);
	}

	@Override
	public void setType(String type) {
		addressLatitudeDirection.setType(type);
	}

	@Override
	public String getCode() {
		return addressLatitudeDirection.getCode();
	}

	@Override
	public void setCode(String code) {
		addressLatitudeDirection.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return addressLatitudeDirection.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return addressLatitudeDirection.isSetType();
	}

	@Override
	public void unsetContent() {
		addressLatitudeDirection.setContent(null);
	}

	@Override
	public void unsetType() {
		addressLatitudeDirection.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return addressLatitudeDirection.isSetCode();
	}

	@Override
	public void unsetCode() {
		addressLatitudeDirection.setCode(null);
	}

}
