package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.SubPremiseType;
import org.citygml4j.model.xal.SubPremiseNumberPrefix;
import org.citygml4j.model.xal.XALClass;

public class SubPremiseNumberPrefixImpl extends XALBaseImpl implements SubPremiseNumberPrefix {
	private SubPremiseType.SubPremiseNumberPrefix subPremiseNumberPrefix;
	
	public SubPremiseNumberPrefixImpl() {
		subPremiseNumberPrefix = new SubPremiseType.SubPremiseNumberPrefix();
	}
	
	public SubPremiseNumberPrefixImpl(SubPremiseType.SubPremiseNumberPrefix subPremiseNumberPrefix) {
		this.subPremiseNumberPrefix = subPremiseNumberPrefix;
	}
	
	@Override
	public SubPremiseType.SubPremiseNumberPrefix getJAXBObject() {
		return subPremiseNumberPrefix;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.SUBPREMISENUMBERPREFIX;
	}

	public String getContent() {
		return subPremiseNumberPrefix.getContent();
	}

	public String getNumberPrefixSeparator() {
		return subPremiseNumberPrefix.getNumberPrefixSeparator();
	}

	public String getType() {
		return subPremiseNumberPrefix.getType();
	}

	public void setContent(String content) {
		subPremiseNumberPrefix.setContent(content);
	}

	public void setNumberPrefixSeparator(String numberPrefixSeparator) {
		subPremiseNumberPrefix.setNumberPrefixSeparator(numberPrefixSeparator);
	}

	public void setType(String type) {
		subPremiseNumberPrefix.setType(type);
	}

	public String getCode() {
		return subPremiseNumberPrefix.getCode();
	}

	public void setCode(String code) {
		subPremiseNumberPrefix.setCode(code);
	}

	public boolean isSetContent() {
		return subPremiseNumberPrefix.isSetContent();
	}

	public boolean isSetType() {
		return subPremiseNumberPrefix.isSetType();
	}

	public void unsetContent() {
		subPremiseNumberPrefix.setContent(null);
	}

	public void unsetType() {
		subPremiseNumberPrefix.setType(null);
	}

	public boolean isSetCode() {
		return subPremiseNumberPrefix.isSetCode();
	}

	public void unsetCode() {
		subPremiseNumberPrefix.setCode(null);
	}

	public boolean isSetNumberPrefixSeparator() {
		return subPremiseNumberPrefix.isSetNumberPrefixSeparator();
	}

	public void unsetNumberPrefixSeparator() {
		subPremiseNumberPrefix.setNumberPrefixSeparator(null);
	}
	
}
