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

	@Override
	public String getContent() {
		return subPremiseNumberSuffix.getContent();
	}

	@Override
	public String getNumberSuffixSeparator() {
		return subPremiseNumberSuffix.getNumberSuffixSeparator();
	}

	@Override
	public String getType() {
		return subPremiseNumberSuffix.getType();
	}

	@Override
	public void setContent(String content) {
		subPremiseNumberSuffix.setContent(content);
	}

	@Override
	public void setNumberSuffixSeparator(String numberSuffixSeparator) {
		subPremiseNumberSuffix.setNumberSuffixSeparator(numberSuffixSeparator);
	}

	@Override
	public void setType(String type) {
		subPremiseNumberSuffix.setType(type);
	}

	@Override
	public String getCode() {
		return subPremiseNumberSuffix.getCode();
	}

	@Override
	public void setCode(String code) {
		subPremiseNumberSuffix.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return subPremiseNumberSuffix.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return subPremiseNumberSuffix.isSetType();
	}

	@Override
	public void unsetContent() {
		subPremiseNumberSuffix.setContent(null);
	}

	@Override
	public void unsetType() {
		subPremiseNumberSuffix.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return subPremiseNumberSuffix.isSetCode();
	}

	@Override
	public void unsetCode() {
		subPremiseNumberSuffix.setCode(null);
	}

	@Override
	public boolean isSetNumberSuffixSeparator() {
		return subPremiseNumberSuffix.isSetNumberSuffixSeparator();
	}

	@Override
	public void unsetNumberSuffixSeparator() {
		subPremiseNumberSuffix.setNumberSuffixSeparator(null);
	}
	
}
