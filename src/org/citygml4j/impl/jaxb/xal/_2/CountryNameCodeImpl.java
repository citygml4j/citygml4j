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

	@Override
	public String getContent() {
		return countryNameCode.getContent();
	}

	@Override
	public String getScheme() {
		return countryNameCode.getScheme();
	}

	@Override
	public void setContent(String content) {
		countryNameCode.setContent(content);
	}

	@Override
	public void setScheme(String scheme) {
		countryNameCode.setScheme(scheme);
	}

	@Override
	public String getCode() {
		return countryNameCode.getCode();
	}

	@Override
	public void setCode(String code) {
		countryNameCode.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return countryNameCode.isSetContent();
	}

	@Override
	public boolean isSetScheme() {
		return countryNameCode.isSetScheme();
	}

	@Override
	public void unsetContent() {
		countryNameCode.setContent(null);
	}

	@Override
	public void unsetScheme() {
		countryNameCode.setScheme(null);
	}

	@Override
	public boolean isSetCode() {
		return countryNameCode.isSetCode();
	}

	@Override
	public void unsetCode() {
		countryNameCode.setCode(null);
	}

}
