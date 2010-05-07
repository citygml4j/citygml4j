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

	public String getContent() {
		return keyLineCode.getContent();
	}

	public String getType() {
		return keyLineCode.getType();
	}

	public void setContent(String content) {
		keyLineCode.setContent(content);
	}

	public void setType(String type) {
		keyLineCode.setType(type);
	}

	public String getCode() {
		return keyLineCode.getCode();
	}

	public void setCode(String code) {
		keyLineCode.setCode(code);
	}

	public boolean isSetContent() {
		return keyLineCode.isSetContent();
	}

	public boolean isSetType() {
		return keyLineCode.isSetType();
	}

	public void unsetContent() {
		keyLineCode.setContent(null);
	}

	public void unsetType() {
		keyLineCode.setType(null);
	}

	public boolean isSetCode() {
		return keyLineCode.isSetCode();
	}

	public void unsetCode() {
		keyLineCode.setCode(null);
	}
}
