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

	@Override
	public String getContent() {
		return postalCodeNumber.getContent();
	}

	@Override
	public String getType() {
		return postalCodeNumber.getType();
	}

	@Override
	public void setContent(String content) {
		postalCodeNumber.setContent(content);
	}

	@Override
	public void setType(String type) {
		postalCodeNumber.setType(type);
	}

	@Override
	public String getCode() {
		return postalCodeNumber.getCode();
	}

	@Override
	public void setCode(String code) {
		postalCodeNumber.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return postalCodeNumber.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return postalCodeNumber.isSetType();
	}

	@Override
	public void unsetContent() {
		postalCodeNumber.setContent(null);
	}

	@Override
	public void unsetType() {
		postalCodeNumber.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return postalCodeNumber.isSetCode();
	}

	@Override
	public void unsetCode() {
		postalCodeNumber.setCode(null);
	}
}
