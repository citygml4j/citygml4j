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

	@Override
	public String getCode() {
		return thoroughfareNumberPrefix.getCode();
	}

	@Override
	public void setCode(String code) {
		thoroughfareNumberPrefix.setCode(code);
	}

	@Override
	public String getContent() {
		return thoroughfareNumberPrefix.getContent();
	}

	@Override
	public String getNumberPrefixSeparator() {
		return thoroughfareNumberPrefix.getNumberPrefixSeparator();
	}

	@Override
	public String getType() {
		return thoroughfareNumberPrefix.getType();
	}

	@Override
	public void setContent(String content) {
		thoroughfareNumberPrefix.setContent(content);		
	}

	@Override
	public void setNumberPrefixSeparator(String numberPrefixSeparator) {
		thoroughfareNumberPrefix.setNumberPrefixSeparator(numberPrefixSeparator);
	}

	@Override
	public void setType(String type) {
		thoroughfareNumberPrefix.setType(type);	
	}

	@Override
	public boolean isSetCode() {
		return thoroughfareNumberPrefix.isSetCode();
	}

	@Override
	public void unsetCode() {
		thoroughfareNumberPrefix.setCode(null);
	}

	@Override
	public boolean isSetContent() {
		return thoroughfareNumberPrefix.isSetContent();
	}

	@Override
	public boolean isSetNumberPrefixSeparator() {
		return thoroughfareNumberPrefix.isSetNumberPrefixSeparator();
	}

	@Override
	public boolean isSetType() {
		return thoroughfareNumberPrefix.isSetType();
	}

	@Override
	public void unsetContent() {
		thoroughfareNumberPrefix.setContent(null);
	}

	@Override
	public void unsetNumberPrefixSeparator() {
		thoroughfareNumberPrefix.setNumberPrefixSeparator(null);
	}

	@Override
	public void unsetType() {
		thoroughfareNumberPrefix.setType(null);
	}

}
