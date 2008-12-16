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

	@Override
	public String getContent() {
		return addressIdenifier.getContent();
	}

	@Override
	public String getIdentifierType() {
		return addressIdenifier.getIdentifierType();
	}

	@Override
	public String getType() {
		return addressIdenifier.getType();
	}

	@Override
	public void setContent(String content) {
		addressIdenifier.setContent(content);
	}

	@Override
	public void setIdentifierType(String identifierType) {
		addressIdenifier.setIdentifierType(identifierType);
	}

	@Override
	public void setType(String type) {
		addressIdenifier.setType(type);
	}

	@Override
	public String getCode() {
		return addressIdenifier.getCode();
	}

	@Override
	public void setCode(String code) {
		addressIdenifier.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return addressIdenifier.isSetContent();
	}

	@Override
	public boolean isSetIdentifierType() {
		return addressIdenifier.isSetIdentifierType();
	}

	@Override
	public boolean isSetType() {
		return addressIdenifier.isSetType();
	}

	@Override
	public void unsetContent() {
		addressIdenifier.setContent(null);
	}

	@Override
	public void unsetIdentifierType() {
		addressIdenifier.setIdentifierType(null);
	}

	@Override
	public void unsetType() {
		addressIdenifier.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return addressIdenifier.isSetCode();
	}

	@Override
	public void unsetCode() {
		addressIdenifier.setCode(null);
	}

}
