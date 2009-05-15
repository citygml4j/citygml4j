package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.PremiseNumberSuffixElement;
import org.citygml4j.model.xal.PremiseNumberSuffix;
import org.citygml4j.model.xal.XALClass;

public class PremiseNumberSuffixImpl extends XALBaseImpl implements PremiseNumberSuffix {
	private PremiseNumberSuffixElement premiseNumberSuffix;
	
	public PremiseNumberSuffixImpl() {
		premiseNumberSuffix = new PremiseNumberSuffixElement();
	}
	
	public PremiseNumberSuffixImpl(PremiseNumberSuffixElement premiseNumberSuffix) {
		this.premiseNumberSuffix = premiseNumberSuffix;
	}
	
	@Override
	public PremiseNumberSuffixElement getJAXBObject() {
		return premiseNumberSuffix;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.PREMISENUMBERSUFFIX;
	}

	public String getContent() {
		return premiseNumberSuffix.getContent();
	}

	public String getNumberSuffixSeparator() {
		return premiseNumberSuffix.getNumberSuffixSeparator();
	}

	public String getType() {
		return premiseNumberSuffix.getType();
	}

	public void setContent(String content) {
		premiseNumberSuffix.setContent(content);
	}

	public void setNumberSuffixSeparator(String numberSuffixSeparator) {
		premiseNumberSuffix.setNumberSuffixSeparator(numberSuffixSeparator);
	}

	public void setType(String type) {
		premiseNumberSuffix.setType(type);
	}

	public String getCode() {
		return premiseNumberSuffix.getCode();
	}

	public void setCode(String code) {
		premiseNumberSuffix.setCode(code);
	}

	public boolean isSetContent() {
		return premiseNumberSuffix.isSetContent();
	}

	public boolean isSetType() {
		return premiseNumberSuffix.isSetType();
	}

	public void unsetContent() {
		premiseNumberSuffix.setContent(null);
	}

	public void unsetType() {
		premiseNumberSuffix.setType(null);
	}

	public boolean isSetCode() {
		return premiseNumberSuffix.isSetCode();
	}

	public void unsetCode() {
		premiseNumberSuffix.setCode(null);
	}

	public boolean isSetNumberSuffixSeparator() {
		return premiseNumberSuffix.isSetNumberSuffixSeparator();
	}

	public void unsetNumberSuffixSeparator() {
		premiseNumberSuffix.setNumberSuffixSeparator(null);
	}
	
}
