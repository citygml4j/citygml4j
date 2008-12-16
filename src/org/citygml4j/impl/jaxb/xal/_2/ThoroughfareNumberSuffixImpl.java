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

	@Override
	public String getCode() {
		return thoroughfareNumberSuffix.getCode();
	}

	@Override
	public void setCode(String code) {
		thoroughfareNumberSuffix.setCode(code);
	}

	@Override
	public String getContent() {
		return thoroughfareNumberSuffix.getContent();
	}

	@Override
	public String getNumberSuffixSeparator() {
		return thoroughfareNumberSuffix.getNumberSuffixSeparator();
	}

	@Override
	public String getType() {
		return thoroughfareNumberSuffix.getType();
	}

	@Override
	public void setContent(String content) {
		thoroughfareNumberSuffix.setContent(content);
	}

	@Override
	public void setNumberSuffixSeparator(String numberSuffixSeparator) {
		thoroughfareNumberSuffix.setNumberSuffixSeparator(numberSuffixSeparator);
	}

	@Override
	public void setType(String type) {
		thoroughfareNumberSuffix.setType(type);	
	}

	@Override
	public boolean isSetContent() {
		return thoroughfareNumberSuffix.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return thoroughfareNumberSuffix.isSetType();
	}

	@Override
	public void unsetContent() {
		thoroughfareNumberSuffix.setContent(null);
	}

	@Override
	public void unsetType() {
		thoroughfareNumberSuffix.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return thoroughfareNumberSuffix.isSetCode();
	}

	@Override
	public void unsetCode() {
		thoroughfareNumberSuffix.setCode(null);
	}

	@Override
	public boolean isSetNumberSuffixSeparator() {
		return thoroughfareNumberSuffix.isSetNumberSuffixSeparator();
	}

	@Override
	public void unsetNumberSuffixSeparator() {
		thoroughfareNumberSuffix.setNumberSuffixSeparator(null);
	}
	
}
