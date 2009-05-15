package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.ThoroughfareTrailingTypeType;
import org.citygml4j.model.xal.ThoroughfareTrailingType;
import org.citygml4j.model.xal.XALClass;

public class ThoroughfareTrailingTypeImpl extends XALBaseImpl implements ThoroughfareTrailingType {
	private ThoroughfareTrailingTypeType thoroughfareTrailingType;
	
	public ThoroughfareTrailingTypeImpl() {
		thoroughfareTrailingType = new ThoroughfareTrailingTypeType();
	}
	
	public ThoroughfareTrailingTypeImpl(ThoroughfareTrailingTypeType thoroughfareTrailingType) {
		this.thoroughfareTrailingType = thoroughfareTrailingType;
	}
	
	@Override
	public ThoroughfareTrailingTypeType getJAXBObject() {
		return thoroughfareTrailingType;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.THOROUGHFARELEADINGTYPE;
	}

	public String getCode() {
		return thoroughfareTrailingType.getCode();
	}

	public void setCode(String code) {
		thoroughfareTrailingType.setCode(code);
	}

	public String getContent() {
		return thoroughfareTrailingType.getContent();
	}

	public String getType() {
		return thoroughfareTrailingType.getType();
	}

	public void setContent(String content) {
		thoroughfareTrailingType.setContent(content);
	}

	public void setType(String type) {
		thoroughfareTrailingType.setType(type);
	}
	
	public boolean isSetContent() {
		return thoroughfareTrailingType.isSetContent();
	}

	public boolean isSetType() {
		return thoroughfareTrailingType.isSetType();
	}

	public void unsetContent() {
		thoroughfareTrailingType.setContent(null);
	}

	public void unsetType() {
		thoroughfareTrailingType.setType(null);
	}

	public boolean isSetCode() {
		return thoroughfareTrailingType.isSetCode();
	}

	public void unsetCode() {
		thoroughfareTrailingType.setCode(null);
	}
	
}
