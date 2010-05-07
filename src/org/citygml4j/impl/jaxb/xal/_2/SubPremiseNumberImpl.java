package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.SubPremiseType;
import org.citygml4j.model.xal.SubPremiseNumber;
import org.citygml4j.model.xal.XALClass;

public class SubPremiseNumberImpl extends XALBaseImpl implements SubPremiseNumber {
	private SubPremiseType.SubPremiseNumber subPremiseNumber;
	
	public SubPremiseNumberImpl() {
		subPremiseNumber = new SubPremiseType.SubPremiseNumber();
	}
	
	public SubPremiseNumberImpl(SubPremiseType.SubPremiseNumber subPremiseNumber) {
		this.subPremiseNumber = subPremiseNumber;
	}
	
	@Override
	public SubPremiseType.SubPremiseNumber getJAXBObject() {
		return subPremiseNumber;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.SUBPREMISENUMBER;
	}

	public String getContent() {
		return subPremiseNumber.getContent();
	}

	public String getIndicator() {
		return subPremiseNumber.getIndicator();
	}

	public String getIndicatorOccurrence() {
		return subPremiseNumber.getIndicatorOccurrence();
	}

	public String getNumberTypeOccurrence() {
		return subPremiseNumber.getNumberTypeOccurrence();
	}

	public String getPremiseNumberSeparator() {
		return subPremiseNumber.getPremiseNumberSeparator();
	}

	public String getType() {
		return subPremiseNumber.getType();
	}

	public void setContent(String content) {
		subPremiseNumber.setContent(content);
	}

	public void setIndicator(String indicator) {
		subPremiseNumber.setIndicator(indicator);
	}

	public void setIndicatorOccurrence(String indicatorOccurence) {
		if (indicatorOccurence.equals("Before") || subPremiseNumber.equals("After"))
			subPremiseNumber.setIndicatorOccurrence(indicatorOccurence);
	}

	public void setNumberTypeOccurrence(String numberTypeOccurence) {
		if (numberTypeOccurence.equals("Before") || numberTypeOccurence.equals("After"))
			subPremiseNumber.setNumberTypeOccurrence(numberTypeOccurence);
	}

	public void setPremiseNumberSeparator(String premiseNumberSeparator) {
		subPremiseNumber.setPremiseNumberSeparator(premiseNumberSeparator);
	}

	public void setType(String type) {
		subPremiseNumber.setType(type);
	}

	public String getCode() {
		return subPremiseNumber.getCode();
	}

	public void setCode(String code) {
		subPremiseNumber.setCode(code);
	}

	public boolean isSetCode() {
		return subPremiseNumber.isSetCode();
	}

	public void unsetCode() {
		subPremiseNumber.setCode(null);
	}

	public boolean isSetContent() {
		return subPremiseNumber.isSetContent();
	}

	public boolean isSetIndicator() {
		return subPremiseNumber.isSetIndicator();
	}

	public boolean isSetIndicatorOccurrence() {
		return subPremiseNumber.isSetIndicatorOccurrence();
	}

	public boolean isSetNumberTypeOccurrence() {
		return subPremiseNumber.isSetNumberTypeOccurrence();
	}

	public boolean isSetPremiseNumberSeparator() {
		return subPremiseNumber.isSetPremiseNumberSeparator();
	}

	public boolean isSetType() {
		return subPremiseNumber.isSetType();
	}

	public void unsetContent() {
		subPremiseNumber.setContent(null);
	}

	public void unsetIndicator() {
		subPremiseNumber.setIndicator(null);
	}

	public void unsetIndicatorOccurrence() {
		subPremiseNumber.setIndicatorOccurrence(null);
	}

	public void unsetNumberTypeOccurrence() {
		subPremiseNumber.setNumberTypeOccurrence(null);
	}

	public void unsetPremiseNumberSeparator() {
		subPremiseNumber.setPremiseNumberSeparator(null);
	}

	public void unsetType() {
		subPremiseNumber.setType(null);
	}

}
