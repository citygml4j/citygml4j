package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.ThoroughfareNumberSuffixElement;
import org.citygml4j.model.xal.ThoroughfareNumberSuffix;
import org.citygml4j.model.xal.XALClass;

public class ThoroughfareNumberSuffixImpl extends XALBaseImpl implements ThoroughfareNumberSuffix {
	private ThoroughfareNumberSuffixElement thoroughfareNumberSuffix;
	
	public ThoroughfareNumberSuffixImpl() {
		thoroughfareNumberSuffix = new ThoroughfareNumberSuffixElement();
	}
	
	public ThoroughfareNumberSuffixImpl(ThoroughfareNumberSuffixElement thoroughfareNumberSuffix) {
		this.thoroughfareNumberSuffix = thoroughfareNumberSuffix;
	}
	
	@Override
	public ThoroughfareNumberSuffixElement getJAXBObject() {
		return thoroughfareNumberSuffix;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.THOROUGHFARENUMBERSUFFIX;
	}

	public String getCode() {
		return thoroughfareNumberSuffix.getCode();
	}

	public void setCode(String code) {
		thoroughfareNumberSuffix.setCode(code);
	}

	public String getContent() {
		return thoroughfareNumberSuffix.getContent();
	}

	public String getNumberSuffixSeparator() {
		return thoroughfareNumberSuffix.getNumberSuffixSeparator();
	}

	public String getType() {
		return thoroughfareNumberSuffix.getType();
	}

	public void setContent(String content) {
		thoroughfareNumberSuffix.setContent(content);
	}

	public void setNumberSuffixSeparator(String numberSuffixSeparator) {
		thoroughfareNumberSuffix.setNumberSuffixSeparator(numberSuffixSeparator);
	}

	public void setType(String type) {
		thoroughfareNumberSuffix.setType(type);	
	}

	public boolean isSetContent() {
		return thoroughfareNumberSuffix.isSetContent();
	}

	public boolean isSetType() {
		return thoroughfareNumberSuffix.isSetType();
	}

	public void unsetContent() {
		thoroughfareNumberSuffix.setContent(null);
	}

	public void unsetType() {
		thoroughfareNumberSuffix.setType(null);
	}

	public boolean isSetCode() {
		return thoroughfareNumberSuffix.isSetCode();
	}

	public void unsetCode() {
		thoroughfareNumberSuffix.setCode(null);
	}

	public boolean isSetNumberSuffixSeparator() {
		return thoroughfareNumberSuffix.isSetNumberSuffixSeparator();
	}

	public void unsetNumberSuffixSeparator() {
		thoroughfareNumberSuffix.setNumberSuffixSeparator(null);
	}
	
}
