package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.PremiseNumberPrefixElement;
import org.citygml4j.model.xal.PremiseNumberPrefix;
import org.citygml4j.model.xal.XALClass;

public class PremiseNumberPrefixImpl extends XALBaseImpl implements PremiseNumberPrefix {
	private PremiseNumberPrefixElement premiseNumberPrefix;
	
	public PremiseNumberPrefixImpl() {
		premiseNumberPrefix = new PremiseNumberPrefixElement();
	}
	
	public PremiseNumberPrefixImpl(PremiseNumberPrefixElement premiseNumberPrefix) {
		this.premiseNumberPrefix = premiseNumberPrefix;
	}
	
	@Override
	public PremiseNumberPrefixElement getJAXBObject() {
		return premiseNumberPrefix;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.PREMISENUMBERPREFIX;
	}

	@Override
	public String getNumberPrefixSeparator() {
		return premiseNumberPrefix.getNumberPrefixSeparator();
	}

	@Override
	public String getType() {
		return premiseNumberPrefix.getType();
	}

	@Override
	public String getValue() {
		return premiseNumberPrefix.getValue();
	}

	@Override
	public void setNumberPrefixSeparator(String numberPrefixSeparator) {
		premiseNumberPrefix.setNumberPrefixSeparator(numberPrefixSeparator);
	}

	@Override
	public void setType(String type) {
		premiseNumberPrefix.setType(type);
	}

	@Override
	public void setValue(String value) {
		premiseNumberPrefix.setValue(value);
	}

	@Override
	public String getCode() {
		return premiseNumberPrefix.getCode();
	}

	@Override
	public void setCode(String code) {
		premiseNumberPrefix.setCode(code);
	}

	@Override
	public boolean isSetNumberPrefixSeparator() {
		return premiseNumberPrefix.isSetNumberPrefixSeparator();
	}

	@Override
	public boolean isSetType() {
		return premiseNumberPrefix.isSetType();
	}

	@Override
	public boolean isSetValue() {
		return premiseNumberPrefix.isSetValue();
	}

	@Override
	public void unsetNumberPrefixSeparator() {
		premiseNumberPrefix.setNumberPrefixSeparator(null);
	}

	@Override
	public void unsetType() {
		premiseNumberPrefix.setType(null);
	}

	@Override
	public void unsetValue() {
		premiseNumberPrefix.setValue(null);
	}

	@Override
	public boolean isSetCode() {
		return premiseNumberPrefix.isSetCode();
	}

	@Override
	public void unsetCode() {
		premiseNumberPrefix.setCode(null);
	}

}
