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

	@Override
	public String getContent() {
		return thoroughfareName.getContent();
	}

	@Override
	public String getType() {
		return thoroughfareName.getType();
	}

	@Override
	public void setContent(String content) {
		thoroughfareName.setContent(content);
	}

	@Override
	public void setType(String type) {
		thoroughfareName.setType(type);
	}

	@Override
	public String getCode() {
		return thoroughfareName.getCode();
	}

	@Override
	public void setCode(String code) {
		thoroughfareName.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return thoroughfareName.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return thoroughfareName.isSetType();
	}

	@Override
	public void unsetContent() {
		thoroughfareName.setContent(null);
	}

	@Override
	public void unsetType() {
		thoroughfareName.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return thoroughfareName.isSetCode();
	}

	@Override
	public void unsetCode() {
		thoroughfareName.setCode(null);
	}
}
