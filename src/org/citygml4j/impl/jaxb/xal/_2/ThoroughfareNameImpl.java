package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.ThoroughfareNameType;
import org.citygml4j.model.xal.ThoroughfareName;
import org.citygml4j.model.xal.XALClass;

public class ThoroughfareNameImpl extends XALBaseImpl implements ThoroughfareName {
	private ThoroughfareNameType thoroughfareName;
	
	public ThoroughfareNameImpl() {
		thoroughfareName = new ThoroughfareNameType();
	}
	
	public ThoroughfareNameImpl(ThoroughfareNameType thoroughfareName) {
		this.thoroughfareName = thoroughfareName;
	}
	
	@Override
	public ThoroughfareNameType getJAXBObject() {
		return thoroughfareName;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.THOROUGHFARENAME;
	}

	public String getContent() {
		return thoroughfareName.getContent();
	}

	public String getType() {
		return thoroughfareName.getType();
	}

	public void setContent(String content) {
		thoroughfareName.setContent(content);
	}

	public void setType(String type) {
		thoroughfareName.setType(type);
	}

	public String getCode() {
		return thoroughfareName.getCode();
	}

	public void setCode(String code) {
		thoroughfareName.setCode(code);
	}

	public boolean isSetContent() {
		return thoroughfareName.isSetContent();
	}

	public boolean isSetType() {
		return thoroughfareName.isSetType();
	}

	public void unsetContent() {
		thoroughfareName.setContent(null);
	}

	public void unsetType() {
		thoroughfareName.setType(null);
	}

	public boolean isSetCode() {
		return thoroughfareName.isSetCode();
	}

	public void unsetCode() {
		thoroughfareName.setCode(null);
	}
}
