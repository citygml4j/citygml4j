package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.ThoroughfareNumberPrefixElement;
import org.citygml4j.model.xal.ThoroughfareNumberPrefix;
import org.citygml4j.model.xal.XALClass;

public class ThoroughfareNumberPrefixImpl extends XALBaseImpl implements ThoroughfareNumberPrefix {
	private ThoroughfareNumberPrefixElement thoroughfareNumberPrefix;
	
	public ThoroughfareNumberPrefixImpl() {
		thoroughfareNumberPrefix = new ThoroughfareNumberPrefixElement();
	}
	
	public ThoroughfareNumberPrefixImpl(ThoroughfareNumberPrefixElement thoroughfareNumberPrefix) {
		this.thoroughfareNumberPrefix = thoroughfareNumberPrefix;
	}
	
	@Override
	public ThoroughfareNumberPrefixElement getJAXBObject() {
		return thoroughfareNumberPrefix;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.THOROUGHFARENUMBERPREFIX;
	}

	public String getCode() {
		return thoroughfareNumberPrefix.getCode();
	}

	public void setCode(String code) {
		thoroughfareNumberPrefix.setCode(code);
	}

	public String getContent() {
		return thoroughfareNumberPrefix.getContent();
	}

	public String getNumberPrefixSeparator() {
		return thoroughfareNumberPrefix.getNumberPrefixSeparator();
	}

	public String getType() {
		return thoroughfareNumberPrefix.getType();
	}

	public void setContent(String content) {
		thoroughfareNumberPrefix.setContent(content);		
	}

	public void setNumberPrefixSeparator(String numberPrefixSeparator) {
		thoroughfareNumberPrefix.setNumberPrefixSeparator(numberPrefixSeparator);
	}

	public void setType(String type) {
		thoroughfareNumberPrefix.setType(type);	
	}

	public boolean isSetCode() {
		return thoroughfareNumberPrefix.isSetCode();
	}

	public void unsetCode() {
		thoroughfareNumberPrefix.setCode(null);
	}

	public boolean isSetContent() {
		return thoroughfareNumberPrefix.isSetContent();
	}

	public boolean isSetNumberPrefixSeparator() {
		return thoroughfareNumberPrefix.isSetNumberPrefixSeparator();
	}

	public boolean isSetType() {
		return thoroughfareNumberPrefix.isSetType();
	}

	public void unsetContent() {
		thoroughfareNumberPrefix.setContent(null);
	}

	public void unsetNumberPrefixSeparator() {
		thoroughfareNumberPrefix.setNumberPrefixSeparator(null);
	}

	public void unsetType() {
		thoroughfareNumberPrefix.setType(null);
	}

}
