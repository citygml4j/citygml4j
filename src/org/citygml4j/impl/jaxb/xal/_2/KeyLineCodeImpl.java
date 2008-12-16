package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.AddressDetails;
import org.citygml4j.model.xal.KeyLineCode;
import org.citygml4j.model.xal.XALClass;

public class KeyLineCodeImpl extends XALBaseImpl implements KeyLineCode {
	private AddressDetails.PostalServiceElements.KeyLineCode keyLineCode;
	
	public KeyLineCodeImpl() {
		keyLineCode = new AddressDetails.PostalServiceElements.KeyLineCode();
	}
	
	public KeyLineCodeImpl(AddressDetails.PostalServiceElements.KeyLineCode keyLineCode) {
		this.keyLineCode = keyLineCode;
	}
	
	@Override
	public AddressDetails.PostalServiceElements.KeyLineCode getJAXBObject() {
		return keyLineCode;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.KEYLINECODE;
	}

	@Override
	public String getContent() {
		return keyLineCode.getContent();
	}

	@Override
	public String getType() {
		return keyLineCode.getType();
	}

	@Override
	public void setContent(String content) {
		keyLineCode.setContent(content);
	}

	@Override
	public void setType(String type) {
		keyLineCode.setType(type);
	}

	@Override
	public String getCode() {
		return keyLineCode.getCode();
	}

	@Override
	public void setCode(String code) {
		keyLineCode.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return keyLineCode.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return keyLineCode.isSetType();
	}

	@Override
	public void unsetContent() {
		keyLineCode.setContent(null);
	}

	@Override
	public void unsetType() {
		keyLineCode.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return keyLineCode.isSetCode();
	}

	@Override
	public void unsetCode() {
		keyLineCode.setCode(null);
	}
}
