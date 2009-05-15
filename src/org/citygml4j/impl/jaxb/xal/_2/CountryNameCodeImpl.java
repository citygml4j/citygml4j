package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.AddressDetails;
import org.citygml4j.model.xal.CountryNameCode;
import org.citygml4j.model.xal.XALClass;

public class CountryNameCodeImpl extends XALBaseImpl implements CountryNameCode {
	private AddressDetails.Country.CountryNameCode countryNameCode;
	
	public CountryNameCodeImpl() {
		countryNameCode = new AddressDetails.Country.CountryNameCode();
	}
	
	public CountryNameCodeImpl(AddressDetails.Country.CountryNameCode countryNameCode) {
		this.countryNameCode = countryNameCode;
	}
	
	@Override
	public AddressDetails.Country.CountryNameCode getJAXBObject() {
		return countryNameCode;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.COUNTRYNAMECODE;
	}

	public String getContent() {
		return countryNameCode.getContent();
	}

	public String getScheme() {
		return countryNameCode.getScheme();
	}

	public void setContent(String content) {
		countryNameCode.setContent(content);
	}

	public void setScheme(String scheme) {
		countryNameCode.setScheme(scheme);
	}

	public String getCode() {
		return countryNameCode.getCode();
	}

	public void setCode(String code) {
		countryNameCode.setCode(code);
	}

	public boolean isSetContent() {
		return countryNameCode.isSetContent();
	}

	public boolean isSetScheme() {
		return countryNameCode.isSetScheme();
	}

	public void unsetContent() {
		countryNameCode.setContent(null);
	}

	public void unsetScheme() {
		countryNameCode.setScheme(null);
	}

	public boolean isSetCode() {
		return countryNameCode.isSetCode();
	}

	public void unsetCode() {
		countryNameCode.setCode(null);
	}

}
