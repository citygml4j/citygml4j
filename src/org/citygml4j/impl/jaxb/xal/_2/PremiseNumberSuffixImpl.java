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

	@Override
	public String getContent() {
		return premiseNumberSuffix.getContent();
	}

	@Override
	public String getNumberSuffixSeparator() {
		return premiseNumberSuffix.getNumberSuffixSeparator();
	}

	@Override
	public String getType() {
		return premiseNumberSuffix.getType();
	}

	@Override
	public void setContent(String content) {
		premiseNumberSuffix.setContent(content);
	}

	@Override
	public void setNumberSuffixSeparator(String numberSuffixSeparator) {
		premiseNumberSuffix.setNumberSuffixSeparator(numberSuffixSeparator);
	}

	@Override
	public void setType(String type) {
		premiseNumberSuffix.setType(type);
	}

	@Override
	public String getCode() {
		return premiseNumberSuffix.getCode();
	}

	@Override
	public void setCode(String code) {
		premiseNumberSuffix.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return premiseNumberSuffix.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return premiseNumberSuffix.isSetType();
	}

	@Override
	public void unsetContent() {
		premiseNumberSuffix.setContent(null);
	}

	@Override
	public void unsetType() {
		premiseNumberSuffix.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return premiseNumberSuffix.isSetCode();
	}

	@Override
	public void unsetCode() {
		premiseNumberSuffix.setCode(null);
	}

	@Override
	public boolean isSetNumberSuffixSeparator() {
		return premiseNumberSuffix.isSetNumberSuffixSeparator();
	}

	@Override
	public void unsetNumberSuffixSeparator() {
		premiseNumberSuffix.setNumberSuffixSeparator(null);
	}
	
}
