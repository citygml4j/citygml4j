package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.AddressDetails;
import org.citygml4j.model.xal.EndorsementLineCode;
import org.citygml4j.model.xal.XALClass;

public class EndorsementLineCodeImpl extends XALBaseImpl implements EndorsementLineCode {
	private AddressDetails.PostalServiceElements.EndorsementLineCode endorsementLineCode;
	
	public EndorsementLineCodeImpl() {
		endorsementLineCode = new AddressDetails.PostalServiceElements.EndorsementLineCode();
	}
	
	public EndorsementLineCodeImpl(AddressDetails.PostalServiceElements.EndorsementLineCode endorsementLineCode) {
		this.endorsementLineCode = endorsementLineCode;
	}
	
	@Override
	public AddressDetails.PostalServiceElements.EndorsementLineCode getJAXBObject() {
		return endorsementLineCode;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.ENDORSEMENTLINECODE;
	}

	public String getContent() {
		return endorsementLineCode.getContent();
	}

	public String getType() {
		return endorsementLineCode.getType();
	}

	public void setContent(String content) {
		endorsementLineCode.setContent(content);
	}

	public void setType(String type) {
		endorsementLineCode.setType(type);
	}

	public String getCode() {
		return endorsementLineCode.getCode();
	}

	public void setCode(String code) {
		endorsementLineCode.setCode(code);
	}

	public boolean isSetContent() {
		return endorsementLineCode.isSetContent();
	}

	public boolean isSetType() {
		return endorsementLineCode.isSetType();
	}

	public void unsetContent() {
		endorsementLineCode.setContent(null);
	}

	public void unsetType() {
		endorsementLineCode.setType(null);
	}

	public boolean isSetCode() {
		return endorsementLineCode.isSetCode();
	}

	public void unsetCode() {
		endorsementLineCode.setCode(null);
	}
}
