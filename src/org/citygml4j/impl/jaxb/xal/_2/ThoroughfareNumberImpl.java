package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.ThoroughfareNumberElement;
import org.citygml4j.model.xal.ThoroughfareNumber;
import org.citygml4j.model.xal.XALClass;

public class ThoroughfareNumberImpl extends XALBaseImpl implements ThoroughfareNumber {
	private ThoroughfareNumberElement thoroughfareNumber;
	
	public ThoroughfareNumberImpl() {
		thoroughfareNumber = new ThoroughfareNumberElement();
	}
	
	public ThoroughfareNumberImpl(ThoroughfareNumberElement thoroughfareNumber) {
		this.thoroughfareNumber = thoroughfareNumber;
	}
	
	@Override
	public ThoroughfareNumberElement getJAXBObject() {
		return thoroughfareNumber;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.THOROUGHFARENUMBER;
	}

	public String getContent() {
		return thoroughfareNumber.getContent();
	}

	public String getIndicator() {
		return thoroughfareNumber.getIndicator();
	}

	public String getIndicatorOccurrence() {
		return thoroughfareNumber.getIndicatorOccurrence();
	}

	public String getNumberOccurrence() {
		return thoroughfareNumber.getNumberOccurrence();
	}

	public String getNumberType() {
		return thoroughfareNumber.getNumberType();
	}

	public String getType() {
		return thoroughfareNumber.getType();
	}

	public void setContent(String content) {
		thoroughfareNumber.setContent(content);
	}

	public void setIndicator(String indicator) {
		thoroughfareNumber.setIndicator(indicator);
	}

	public void setIndicatorOccurrence(String indicatorOccurrence) {
		if (indicatorOccurrence.equals("Before") || indicatorOccurrence.equals("After"))
			thoroughfareNumber.setIndicatorOccurrence(indicatorOccurrence);
	}

	public void setNumberOccurrence(String numberOccurrence) {
		if (numberOccurrence.equals("BeforeName") ||
				numberOccurrence.equals("AfterName") || 
				numberOccurrence.equals("BeforeType") ||
				numberOccurrence.equals("AfterType"))
			thoroughfareNumber.setNumberOccurrence(numberOccurrence);
	}

	public void setNumberType(String numberType) {
		if (numberType.equals("Single") || numberType.equals("Range"))
			thoroughfareNumber.setNumberType(numberType);
	}

	public void setType(String type) {
		thoroughfareNumber.setType(type);
	}

	public String getCode() {
		return thoroughfareNumber.getCode();
	}

	public void setCode(String code) {
		thoroughfareNumber.setCode(code);
	}

	public boolean isSetContent() {
		return thoroughfareNumber.isSetContent();
	}

	public boolean isSetIndicator() {
		return thoroughfareNumber.isSetIndicator();
	}

	public boolean isSetIndicatorOccurrence() {
		return thoroughfareNumber.isSetIndicatorOccurrence();
	}

	public boolean isSetNumberOccurrence() {
		return thoroughfareNumber.isSetNumberOccurrence();
	}

	public boolean isSetNumberType() {
		return thoroughfareNumber.isSetNumberType();
	}

	public boolean isSetType() {
		return thoroughfareNumber.isSetType();
	}

	public void unsetContent() {
		thoroughfareNumber.setContent(null);
	}

	public void unsetIndicator() {
		thoroughfareNumber.setIndicator(null);
	}

	public void unsetIndicatorOccurrence() {
		thoroughfareNumber.setIndicatorOccurrence(null);
	}

	public void unsetNumberOccurrence() {
		thoroughfareNumber.setNumberOccurrence(null);
	}

	public void unsetNumberType() {
		thoroughfareNumber.setNumberType(null);
	}

	public void unsetType() {
		thoroughfareNumber.setType(null);
	}

	public boolean isSetCode() {
		return thoroughfareNumber.isSetCode();
	}

	public void unsetCode() {
		thoroughfareNumber.setCode(null);
	}

}
