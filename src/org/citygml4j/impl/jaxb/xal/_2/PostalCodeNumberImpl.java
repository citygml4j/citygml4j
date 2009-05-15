package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.PostalCodeElement;
import org.citygml4j.model.xal.PostalCodeNumber;
import org.citygml4j.model.xal.XALClass;

public class PostalCodeNumberImpl extends XALBaseImpl implements PostalCodeNumber {
	private PostalCodeElement.PostalCodeNumber postalCodeNumber;
	
	public PostalCodeNumberImpl() {
		postalCodeNumber = new PostalCodeElement.PostalCodeNumber();
	}
	
	public PostalCodeNumberImpl(PostalCodeElement.PostalCodeNumber postalCodeNumber) {
		this.postalCodeNumber = postalCodeNumber;
	}
	
	@Override
	public PostalCodeElement.PostalCodeNumber getJAXBObject() {
		return postalCodeNumber;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.POSTALCODENUMBER;
	}

	public String getContent() {
		return postalCodeNumber.getContent();
	}

	public String getType() {
		return postalCodeNumber.getType();
	}

	public void setContent(String content) {
		postalCodeNumber.setContent(content);
	}

	public void setType(String type) {
		postalCodeNumber.setType(type);
	}

	public String getCode() {
		return postalCodeNumber.getCode();
	}

	public void setCode(String code) {
		postalCodeNumber.setCode(code);
	}

	public boolean isSetContent() {
		return postalCodeNumber.isSetContent();
	}

	public boolean isSetType() {
		return postalCodeNumber.isSetType();
	}

	public void unsetContent() {
		postalCodeNumber.setContent(null);
	}

	public void unsetType() {
		postalCodeNumber.setType(null);
	}

	public boolean isSetCode() {
		return postalCodeNumber.isSetCode();
	}

	public void unsetCode() {
		postalCodeNumber.setCode(null);
	}
}
