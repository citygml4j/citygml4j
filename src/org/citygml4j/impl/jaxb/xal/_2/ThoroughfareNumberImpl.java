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

	@Override
	public String getContent() {
		return thoroughfareNumber.getContent();
	}

	@Override
	public String getIndicator() {
		return thoroughfareNumber.getIndicator();
	}

	@Override
	public String getIndicatorOccurrence() {
		return thoroughfareNumber.getIndicatorOccurrence();
	}

	@Override
	public String getNumberOccurrence() {
		return thoroughfareNumber.getNumberOccurrence();
	}

	@Override
	public String getNumberType() {
		return thoroughfareNumber.getNumberType();
	}

	@Override
	public String getType() {
		return thoroughfareNumber.getType();
	}

	@Override
	public void setContent(String content) {
		thoroughfareNumber.setContent(content);
	}

	@Override
	public void setIndicator(String indicator) {
		thoroughfareNumber.setIndicator(indicator);
	}

	@Override
	public void setIndicatorOccurrence(String indicatorOccurrence) {
		if (indicatorOccurrence.equals("Before") || indicatorOccurrence.equals("After"))
			thoroughfareNumber.setIndicatorOccurrence(indicatorOccurrence);
	}

	@Override
	public void setNumberOccurrence(String numberOccurrence) {
		if (numberOccurrence.equals("BeforeName") ||
				numberOccurrence.equals("AfterName") || 
				numberOccurrence.equals("BeforeType") ||
				numberOccurrence.equals("AfterType"))
			thoroughfareNumber.setNumberOccurrence(numberOccurrence);
	}

	@Override
	public void setNumberType(String numberType) {
		if (numberType.equals("Single") || numberType.equals("Range"))
			thoroughfareNumber.setNumberType(numberType);
	}

	@Override
	public void setType(String type) {
		thoroughfareNumber.setType(type);
	}

	@Override
	public String getCode() {
		return thoroughfareNumber.getCode();
	}

	@Override
	public void setCode(String code) {
		thoroughfareNumber.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return thoroughfareNumber.isSetContent();
	}

	@Override
	public boolean isSetIndicator() {
		return thoroughfareNumber.isSetIndicator();
	}

	@Override
	public boolean isSetIndicatorOccurrence() {
		return thoroughfareNumber.isSetIndicatorOccurrence();
	}

	@Override
	public boolean isSetNumberOccurrence() {
		return thoroughfareNumber.isSetNumberOccurrence();
	}

	@Override
	public boolean isSetNumberType() {
		return thoroughfareNumber.isSetNumberType();
	}

	@Override
	public boolean isSetType() {
		return thoroughfareNumber.isSetType();
	}

	@Override
	public void unsetContent() {
		thoroughfareNumber.setContent(null);
	}

	@Override
	public void unsetIndicator() {
		thoroughfareNumber.setIndicator(null);
	}

	@Override
	public void unsetIndicatorOccurrence() {
		thoroughfareNumber.setIndicatorOccurrence(null);
	}

	@Override
	public void unsetNumberOccurrence() {
		thoroughfareNumber.setNumberOccurrence(null);
	}

	@Override
	public void unsetNumberType() {
		thoroughfareNumber.setNumberType(null);
	}

	@Override
	public void unsetType() {
		thoroughfareNumber.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return thoroughfareNumber.isSetCode();
	}

	@Override
	public void unsetCode() {
		thoroughfareNumber.setCode(null);
	}

}
