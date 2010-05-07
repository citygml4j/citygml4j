package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.PremiseNumberElement;
import org.citygml4j.model.xal.PremiseNumber;
import org.citygml4j.model.xal.XALClass;

public class PremiseNumberImpl extends XALBaseImpl implements PremiseNumber {
	private PremiseNumberElement premiseNumber;
	
	public PremiseNumberImpl() {
		premiseNumber = new PremiseNumberElement();
	}
	
	public PremiseNumberImpl(PremiseNumberElement premiseNumber) {
		this.premiseNumber = premiseNumber;
	}
	
	@Override
	public PremiseNumberElement getJAXBObject() {
		return premiseNumber;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.PREMISENUMBER;
	}
	
	public String getContent() {
		return premiseNumber.getContent();
	}

	public String getIndicator() {
		return premiseNumber.getIndicator();
	}

	public String getIndicatorOccurrence() {
		return premiseNumber.getIndicatorOccurrence();
	}

	public String getNumberType() {
		return premiseNumber.getNumberType();
	}

	public String getNumberTypeOccurrence() {
		return premiseNumber.getNumberTypeOccurrence();
	}

	public String getType() {
		return premiseNumber.getType();
	}

	public void setContent(String content) {
		premiseNumber.setContent(content);
	}

	public void setIndicator(String indicator) {
		premiseNumber.setIndicator(indicator);
	}

	public void setIndicatorOccurrence(String indicatorOccurrence) {
		if (indicatorOccurrence.equals("Before") || indicatorOccurrence.equals("After"))
			premiseNumber.setIndicatorOccurrence(indicatorOccurrence);
	}

	public void setNumberType(String numberType) {
		if (numberType.equals("Single") || numberType.equals("Range"))
			premiseNumber.setNumberType(numberType);
	}

	public void setNumberTypeOccurrence(String numberTypeOccurrence) {
		if (numberTypeOccurrence.equals("Before") || numberTypeOccurrence.equals("After"))
			premiseNumber.setNumberTypeOccurrence(numberTypeOccurrence);
	}

	public String getCode() {
		return premiseNumber.getCode();
	}

	public void setCode(String code) {
		premiseNumber.setCode(code);
	}

	public boolean isSetCode() {
		return premiseNumber.isSetCode();
	}

	public void unsetCode() {
		premiseNumber.setCode(null);
	}

	public boolean isSetContent() {
		return premiseNumber.isSetContent();
	}

	public boolean isSetIndicator() {
		return premiseNumber.isSetIndicator();
	}

	public boolean isSetIndicatorOccurrence() {
		return premiseNumber.isSetIndicatorOccurrence();
	}

	public boolean isSetNumberType() {
		return premiseNumber.isSetNumberType();
	}

	public boolean isSetNumberTypeOccurrence() {
		return premiseNumber.isSetNumberTypeOccurrence();
	}

	public boolean isSetType() {
		return premiseNumber.isSetType();
	}

	public void unsetContent() {
		premiseNumber.setContent(null);
	}

	public void unsetIndicator() {
		premiseNumber.setIndicator(null);
	}

	public void unsetIndicatorOccurrence() {
		premiseNumber.setIndicatorOccurrence(null);
	}

	public void unsetNumberType() {
		premiseNumber.setNumberType(null);
	}

	public void unsetNumberTypeOccurrence() {
		premiseNumber.setNumberTypeOccurrence(null);
	}

	public void unsetType() {
		premiseNumber.setType(null);
	}

}
