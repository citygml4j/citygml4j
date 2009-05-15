package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.AddressDetails;
import org.citygml4j.model.xal.AddressIdentifier;
import org.citygml4j.model.xal.XALClass;

public class AddressIdentifierImpl extends XALBaseImpl implements AddressIdentifier {
	private AddressDetails.PostalServiceElements.AddressIdentifier addressIdenifier;
	
	public AddressIdentifierImpl() {
		addressIdenifier = new AddressDetails.PostalServiceElements.AddressIdentifier();
	}
	
	public AddressIdentifierImpl(AddressDetails.PostalServiceElements.AddressIdentifier addressIdenifier) {
		this.addressIdenifier = addressIdenifier;
	}
	
	@Override
	public AddressDetails.PostalServiceElements.AddressIdentifier getJAXBObject() {
		return addressIdenifier;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.ADDRESSIDENTIFIER;
	}

	public String getContent() {
		return addressIdenifier.getContent();
	}

	public String getIdentifierType() {
		return addressIdenifier.getIdentifierType();
	}

	public String getType() {
		return addressIdenifier.getType();
	}

	public void setContent(String content) {
		addressIdenifier.setContent(content);
	}

	public void setIdentifierType(String identifierType) {
		addressIdenifier.setIdentifierType(identifierType);
	}

	public void setType(String type) {
		addressIdenifier.setType(type);
	}

	public String getCode() {
		return addressIdenifier.getCode();
	}

	public void setCode(String code) {
		addressIdenifier.setCode(code);
	}

	public boolean isSetContent() {
		return addressIdenifier.isSetContent();
	}

	public boolean isSetIdentifierType() {
		return addressIdenifier.isSetIdentifierType();
	}

	public boolean isSetType() {
		return addressIdenifier.isSetType();
	}

	public void unsetContent() {
		addressIdenifier.setContent(null);
	}

	public void unsetIdentifierType() {
		addressIdenifier.setIdentifierType(null);
	}

	public void unsetType() {
		addressIdenifier.setType(null);
	}

	public boolean isSetCode() {
		return addressIdenifier.isSetCode();
	}

	public void unsetCode() {
		addressIdenifier.setCode(null);
	}

}
