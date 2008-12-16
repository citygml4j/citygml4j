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

	@Override
	public String getContent() {
		return address.getContent();
	}

	@Override
	public String getType() {
		return address.getType();
	}

	@Override
	public void setContent(String content) {
		address.setContent(content);
	}

	@Override
	public void setType(String type) {
		address.setType(type);
	}

	@Override
	public String getCode() {
		return address.getCode();
	}

	@Override
	public void setCode(String code) {
		address.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return address.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return address.isSetType();
	}

	@Override
	public void unsetContent() {
		address.setCode(null);
	}

	@Override
	public void unsetType() {
		address.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return address.isSetCode();
	}

	@Override
	public void unsetCode() {
		address.setCode(null);
	}

}
