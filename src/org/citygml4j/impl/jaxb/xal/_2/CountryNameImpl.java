package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.CountryNameElement;
import org.citygml4j.model.xal.CountryName;
import org.citygml4j.model.xal.XALClass;

public class CountryNameImpl extends XALBaseImpl implements CountryName {
	private CountryNameElement countryName;
	
	public CountryNameImpl() {
		countryName = new CountryNameElement();
	}
	
	public CountryNameImpl(CountryNameElement countryName) {
		this.countryName = countryName;
	}
	
	@Override
	public CountryNameElement getJAXBObject() {
		return countryName;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.COUNTRYNAME;
	}

	public String getContent() {
		return countryName.getContent();
	}

	public String getType() {
		return countryName.getType();
	}

	public void setContent(String content) {
		countryName.setContent(content);
	}

	public void setType(String type) {
		countryName.setType(type);
	}

	public String getCode() {
		return countryName.getCode();
	}

	public void setCode(String code) {
		countryName.setCode(code);
	}

	public boolean isSetContent() {
		return countryName.isSetContent();
	}

	public boolean isSetType() {
		return countryName.isSetType();
	}

	public void unsetContent() {
		countryName.setContent(null);
	}

	public void unsetType() {
		countryName.setType(null);
	}

	public boolean isSetCode() {
		return countryName.isSetCode();
	}

	public void unsetCode() {
		countryName.setCode(null);
	}

}
