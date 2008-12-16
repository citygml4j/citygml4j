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

	@Override
	public String getContent() {
		return subPremiseNumberPrefix.getContent();
	}

	@Override
	public String getNumberPrefixSeparator() {
		return subPremiseNumberPrefix.getNumberPrefixSeparator();
	}

	@Override
	public String getType() {
		return subPremiseNumberPrefix.getType();
	}

	@Override
	public void setContent(String content) {
		subPremiseNumberPrefix.setContent(content);
	}

	@Override
	public void setNumberPrefixSeparator(String numberPrefixSeparator) {
		subPremiseNumberPrefix.setNumberPrefixSeparator(numberPrefixSeparator);
	}

	@Override
	public void setType(String type) {
		subPremiseNumberPrefix.setType(type);
	}

	@Override
	public String getCode() {
		return subPremiseNumberPrefix.getCode();
	}

	@Override
	public void setCode(String code) {
		subPremiseNumberPrefix.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return subPremiseNumberPrefix.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return subPremiseNumberPrefix.isSetType();
	}

	@Override
	public void unsetContent() {
		subPremiseNumberPrefix.setContent(null);
	}

	@Override
	public void unsetType() {
		subPremiseNumberPrefix.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return subPremiseNumberPrefix.isSetCode();
	}

	@Override
	public void unsetCode() {
		subPremiseNumberPrefix.setCode(null);
	}

	@Override
	public boolean isSetNumberPrefixSeparator() {
		return subPremiseNumberPrefix.isSetNumberPrefixSeparator();
	}

	@Override
	public void unsetNumberPrefixSeparator() {
		subPremiseNumberPrefix.setNumberPrefixSeparator(null);
	}
	
}
