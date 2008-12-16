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
	
	@Override
	public String getContent() {
		return premiseNumber.getContent();
	}

	@Override
	public String getIndicator() {
		return premiseNumber.getIndicator();
	}

	@Override
	public String getIndicatorOccurrence() {
		return premiseNumber.getIndicatorOccurrence();
	}

	@Override
	public String getNumberType() {
		return premiseNumber.getNumberType();
	}

	@Override
	public String getNumberTypeOccurrence() {
		return premiseNumber.getNumberTypeOccurrence();
	}

	@Override
	public String getType() {
		return premiseNumber.getType();
	}

	@Override
	public void setContent(String content) {
		premiseNumber.setContent(content);
	}

	@Override
	public void setIndicator(String indicator) {
		premiseNumber.setIndicator(indicator);
	}

	@Override
	public void setIndicatorOccurrence(String indicatorOccurrence) {
		if (indicatorOccurrence.equals("Before") || indicatorOccurrence.equals("After"))
			premiseNumber.setIndicatorOccurrence(indicatorOccurrence);
	}

	@Override
	public void setNumberType(String numberType) {
		if (numberType.equals("Single") || numberType.equals("Range"))
			premiseNumber.setNumberType(numberType);
	}

	@Override
	public void setNumberTypeOccurrence(String numberTypeOccurrence) {
		if (numberTypeOccurrence.equals("Before") || numberTypeOccurrence.equals("After"))
			premiseNumber.setNumberTypeOccurrence(numberTypeOccurrence);
	}

	@Override
	public String getCode() {
		return premiseNumber.getCode();
	}

	@Override
	public void setCode(String code) {
		premiseNumber.setCode(code);
	}

	@Override
	public boolean isSetCode() {
		return premiseNumber.isSetCode();
	}

	@Override
	public void unsetCode() {
		premiseNumber.setCode(null);
	}

	@Override
	public boolean isSetContent() {
		return premiseNumber.isSetContent();
	}

	@Override
	public boolean isSetIndicator() {
		return premiseNumber.isSetIndicator();
	}

	@Override
	public boolean isSetIndicatorOccurrence() {
		return premiseNumber.isSetIndicatorOccurrence();
	}

	@Override
	public boolean isSetNumberType() {
		return premiseNumber.isSetNumberType();
	}

	@Override
	public boolean isSetNumberTypeOccurrence() {
		return premiseNumber.isSetNumberTypeOccurrence();
	}

	@Override
	public boolean isSetType() {
		return premiseNumber.isSetType();
	}

	@Override
	public void unsetContent() {
		premiseNumber.setContent(null);
	}

	@Override
	public void unsetIndicator() {
		premiseNumber.setIndicator(null);
	}

	@Override
	public void unsetIndicatorOccurrence() {
		premiseNumber.setIndicatorOccurrence(null);
	}

	@Override
	public void unsetNumberType() {
		premiseNumber.setNumberType(null);
	}

	@Override
	public void unsetNumberTypeOccurrence() {
		premiseNumber.setNumberTypeOccurrence(null);
	}

	@Override
	public void unsetType() {
		premiseNumber.setType(null);
	}

}
