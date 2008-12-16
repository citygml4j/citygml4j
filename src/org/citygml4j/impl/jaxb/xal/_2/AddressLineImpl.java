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

	@Override
	public String getContent() {
		return addressLine.getContent();
	}

	@Override
	public String getType() {
		return addressLine.getType();
	}

	@Override
	public void setContent(String content) {
		addressLine.setContent(content);
	}

	@Override
	public void setType(String type) {
		addressLine.setType(type);
	}

	@Override
	public String getCode() {
		return addressLine.getCode();
	}

	@Override
	public void setCode(String code) {
		addressLine.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return addressLine.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return addressLine.isSetType();
	}

	@Override
	public void unsetContent() {
		addressLine.setContent(null);
	}

	@Override
	public void unsetType() {
		addressLine.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return addressLine.isSetCode();
	}

	@Override
	public void unsetCode() {
		addressLine.setCode(null);
	}

}
