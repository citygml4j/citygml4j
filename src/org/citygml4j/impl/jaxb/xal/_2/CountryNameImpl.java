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

	@Override
	public String getContent() {
		return countryName.getContent();
	}

	@Override
	public String getType() {
		return countryName.getType();
	}

	@Override
	public void setContent(String content) {
		countryName.setContent(content);
	}

	@Override
	public void setType(String type) {
		countryName.setType(type);
	}

	@Override
	public String getCode() {
		return countryName.getCode();
	}

	@Override
	public void setCode(String code) {
		countryName.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return countryName.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return countryName.isSetType();
	}

	@Override
	public void unsetContent() {
		countryName.setContent(null);
	}

	@Override
	public void unsetType() {
		countryName.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return countryName.isSetCode();
	}

	@Override
	public void unsetCode() {
		countryName.setCode(null);
	}

}
