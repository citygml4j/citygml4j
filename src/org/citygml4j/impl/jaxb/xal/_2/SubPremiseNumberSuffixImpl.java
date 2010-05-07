package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.SubPremiseType;
import org.citygml4j.model.xal.SubPremiseNumberSuffix;
import org.citygml4j.model.xal.XALClass;

public class SubPremiseNumberSuffixImpl extends XALBaseImpl implements SubPremiseNumberSuffix {
	private SubPremiseType.SubPremiseNumberSuffix subPremiseNumberSuffix;
	
	public SubPremiseNumberSuffixImpl() {
		subPremiseNumberSuffix = new SubPremiseType.SubPremiseNumberSuffix();
	}
	
	public SubPremiseNumberSuffixImpl(SubPremiseType.SubPremiseNumberSuffix subPremiseNumberSuffix) {
		this.subPremiseNumberSuffix = subPremiseNumberSuffix;
	}
	
	@Override
	public SubPremiseType.SubPremiseNumberSuffix getJAXBObject() {
		return subPremiseNumberSuffix;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.SUBPREMISENUMBERSUFFIX;
	}

	public String getContent() {
		return subPremiseNumberSuffix.getContent();
	}

	public String getNumberSuffixSeparator() {
		return subPremiseNumberSuffix.getNumberSuffixSeparator();
	}

	public String getType() {
		return subPremiseNumberSuffix.getType();
	}

	public void setContent(String content) {
		subPremiseNumberSuffix.setContent(content);
	}

	public void setNumberSuffixSeparator(String numberSuffixSeparator) {
		subPremiseNumberSuffix.setNumberSuffixSeparator(numberSuffixSeparator);
	}

	public void setType(String type) {
		subPremiseNumberSuffix.setType(type);
	}

	public String getCode() {
		return subPremiseNumberSuffix.getCode();
	}

	public void setCode(String code) {
		subPremiseNumberSuffix.setCode(code);
	}

	public boolean isSetContent() {
		return subPremiseNumberSuffix.isSetContent();
	}

	public boolean isSetType() {
		return subPremiseNumberSuffix.isSetType();
	}

	public void unsetContent() {
		subPremiseNumberSuffix.setContent(null);
	}

	public void unsetType() {
		subPremiseNumberSuffix.setType(null);
	}

	public boolean isSetCode() {
		return subPremiseNumberSuffix.isSetCode();
	}

	public void unsetCode() {
		subPremiseNumberSuffix.setCode(null);
	}

	public boolean isSetNumberSuffixSeparator() {
		return subPremiseNumberSuffix.isSetNumberSuffixSeparator();
	}

	public void unsetNumberSuffixSeparator() {
		subPremiseNumberSuffix.setNumberSuffixSeparator(null);
	}
	
}
