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

	public String getNumberPrefixSeparator() {
		return premiseNumberPrefix.getNumberPrefixSeparator();
	}

	public String getType() {
		return premiseNumberPrefix.getType();
	}

	public String getValue() {
		return premiseNumberPrefix.getValue();
	}

	public void setNumberPrefixSeparator(String numberPrefixSeparator) {
		premiseNumberPrefix.setNumberPrefixSeparator(numberPrefixSeparator);
	}

	public void setType(String type) {
		premiseNumberPrefix.setType(type);
	}

	public void setValue(String value) {
		premiseNumberPrefix.setValue(value);
	}

	public String getCode() {
		return premiseNumberPrefix.getCode();
	}

	public void setCode(String code) {
		premiseNumberPrefix.setCode(code);
	}

	public boolean isSetNumberPrefixSeparator() {
		return premiseNumberPrefix.isSetNumberPrefixSeparator();
	}

	public boolean isSetType() {
		return premiseNumberPrefix.isSetType();
	}

	public boolean isSetValue() {
		return premiseNumberPrefix.isSetValue();
	}

	public void unsetNumberPrefixSeparator() {
		premiseNumberPrefix.setNumberPrefixSeparator(null);
	}

	public void unsetType() {
		premiseNumberPrefix.setType(null);
	}

	public void unsetValue() {
		premiseNumberPrefix.setValue(null);
	}

	public boolean isSetCode() {
		return premiseNumberPrefix.isSetCode();
	}

	public void unsetCode() {
		premiseNumberPrefix.setCode(null);
	}

}
