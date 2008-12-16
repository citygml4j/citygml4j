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

	@Override
	public String getContent() {
		return endorsementLineCode.getContent();
	}

	@Override
	public String getType() {
		return endorsementLineCode.getType();
	}

	@Override
	public void setContent(String content) {
		endorsementLineCode.setContent(content);
	}

	@Override
	public void setType(String type) {
		endorsementLineCode.setType(type);
	}

	@Override
	public String getCode() {
		return endorsementLineCode.getCode();
	}

	@Override
	public void setCode(String code) {
		endorsementLineCode.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return endorsementLineCode.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return endorsementLineCode.isSetType();
	}

	@Override
	public void unsetContent() {
		endorsementLineCode.setContent(null);
	}

	@Override
	public void unsetType() {
		endorsementLineCode.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return endorsementLineCode.isSetCode();
	}

	@Override
	public void unsetCode() {
		endorsementLineCode.setCode(null);
	}
}
