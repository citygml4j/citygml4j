package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.XALClass;

public class AddressLineImpl extends XALBaseImpl implements AddressLine {
	private AddressLineElement addressLine;
	
	public AddressLineImpl() {
		addressLine = new AddressLineElement();
	}
	
	public AddressLineImpl(AddressLineElement addressLine) {
		this.addressLine = addressLine;
	}
	
	@Override
	public AddressLineElement getJAXBObject() {
		return addressLine;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.ADDRESSLINE;
	}

	public String getContent() {
		return addressLine.getContent();
	}

	public String getType() {
		return addressLine.getType();
	}

	public void setContent(String content) {
		addressLine.setContent(content);
	}

	public void setType(String type) {
		addressLine.setType(type);
	}

	public String getCode() {
		return addressLine.getCode();
	}

	public void setCode(String code) {
		addressLine.setCode(code);
	}

	public boolean isSetContent() {
		return addressLine.isSetContent();
	}

	public boolean isSetType() {
		return addressLine.isSetType();
	}

	public void unsetContent() {
		addressLine.setContent(null);
	}

	public void unsetType() {
		addressLine.setType(null);
	}

	public boolean isSetCode() {
		return addressLine.isSetCode();
	}

	public void unsetCode() {
		addressLine.setCode(null);
	}

}
