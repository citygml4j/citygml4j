package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.AddressDetails;
import org.citygml4j.model.xal.Address;
import org.citygml4j.model.xal.XALClass;

public class AddressImpl extends XALBaseImpl implements Address {
	private AddressDetails.Address address;
	
	public AddressImpl() {
		address = new AddressDetails.Address();
	}
	
	public AddressImpl(AddressDetails.Address address) {
		this.address = address;
	}
	
	@Override
	public AddressDetails.Address getJAXBObject() {
		return address;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.ADDRESS;
	}

	public String getContent() {
		return address.getContent();
	}

	public String getType() {
		return address.getType();
	}

	public void setContent(String content) {
		address.setContent(content);
	}

	public void setType(String type) {
		address.setType(type);
	}

	public String getCode() {
		return address.getCode();
	}

	public void setCode(String code) {
		address.setCode(code);
	}

	public boolean isSetContent() {
		return address.isSetContent();
	}

	public boolean isSetType() {
		return address.isSetType();
	}

	public void unsetContent() {
		address.setCode(null);
	}

	public void unsetType() {
		address.setType(null);
	}

	public boolean isSetCode() {
		return address.isSetCode();
	}

	public void unsetCode() {
		address.setCode(null);
	}

}
