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

	@Override
	public String getContent() {
		return subPremiseNumber.getContent();
	}

	@Override
	public String getIndicator() {
		return subPremiseNumber.getIndicator();
	}

	@Override
	public String getIndicatorOccurrence() {
		return subPremiseNumber.getIndicatorOccurrence();
	}

	@Override
	public String getNumberTypeOccurrence() {
		return subPremiseNumber.getNumberTypeOccurrence();
	}

	@Override
	public String getPremiseNumberSeparator() {
		return subPremiseNumber.getPremiseNumberSeparator();
	}

	@Override
	public String getType() {
		return subPremiseNumber.getType();
	}

	@Override
	public void setContent(String content) {
		subPremiseNumber.setContent(content);
	}

	@Override
	public void setIndicator(String indicator) {
		subPremiseNumber.setIndicator(indicator);
	}

	@Override
	public void setIndicatorOccurrence(String indicatorOccurence) {
		if (indicatorOccurence.equals("Before") || subPremiseNumber.equals("After"))
			subPremiseNumber.setIndicatorOccurrence(indicatorOccurence);
	}

	@Override
	public void setNumberTypeOccurrence(String numberTypeOccurence) {
		if (numberTypeOccurence.equals("Before") || numberTypeOccurence.equals("After"))
			subPremiseNumber.setNumberTypeOccurrence(numberTypeOccurence);
	}

	@Override
	public void setPremiseNumberSeparator(String premiseNumberSeparator) {
		subPremiseNumber.setPremiseNumberSeparator(premiseNumberSeparator);
	}

	@Override
	public void setType(String type) {
		subPremiseNumber.setType(type);
	}

	@Override
	public String getCode() {
		return subPremiseNumber.getCode();
	}

	@Override
	public void setCode(String code) {
		subPremiseNumber.setCode(code);
	}

	@Override
	public boolean isSetCode() {
		return subPremiseNumber.isSetCode();
	}

	@Override
	public void unsetCode() {
		subPremiseNumber.setCode(null);
	}

	@Override
	public boolean isSetContent() {
		return subPremiseNumber.isSetContent();
	}

	@Override
	public boolean isSetIndicator() {
		return subPremiseNumber.isSetIndicator();
	}

	@Override
	public boolean isSetIndicatorOccurrence() {
		return subPremiseNumber.isSetIndicatorOccurrence();
	}

	@Override
	public boolean isSetNumberTypeOccurrence() {
		return subPremiseNumber.isSetNumberTypeOccurrence();
	}

	@Override
	public boolean isSetPremiseNumberSeparator() {
		return subPremiseNumber.isSetPremiseNumberSeparator();
	}

	@Override
	public boolean isSetType() {
		return subPremiseNumber.isSetType();
	}

	@Override
	public void unsetContent() {
		subPremiseNumber.setContent(null);
	}

	@Override
	public void unsetIndicator() {
		subPremiseNumber.setIndicator(null);
	}

	@Override
	public void unsetIndicatorOccurrence() {
		subPremiseNumber.setIndicatorOccurrence(null);
	}

	@Override
	public void unsetNumberTypeOccurrence() {
		subPremiseNumber.setNumberTypeOccurrence(null);
	}

	@Override
	public void unsetPremiseNumberSeparator() {
		subPremiseNumber.setPremiseNumberSeparator(null);
	}

	@Override
	public void unsetType() {
		subPremiseNumber.setType(null);
	}

}
