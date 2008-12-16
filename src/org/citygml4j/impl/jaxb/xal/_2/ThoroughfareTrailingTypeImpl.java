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

	@Override
	public String getCode() {
		return thoroughfareTrailingType.getCode();
	}

	@Override
	public void setCode(String code) {
		thoroughfareTrailingType.setCode(code);
	}

	@Override
	public String getContent() {
		return thoroughfareTrailingType.getContent();
	}

	@Override
	public String getType() {
		return thoroughfareTrailingType.getType();
	}

	@Override
	public void setContent(String content) {
		thoroughfareTrailingType.setContent(content);
	}

	@Override
	public void setType(String type) {
		thoroughfareTrailingType.setType(type);
	}
	
	@Override
	public boolean isSetContent() {
		return thoroughfareTrailingType.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return thoroughfareTrailingType.isSetType();
	}

	@Override
	public void unsetContent() {
		thoroughfareTrailingType.setContent(null);
	}

	@Override
	public void unsetType() {
		thoroughfareTrailingType.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return thoroughfareTrailingType.isSetCode();
	}

	@Override
	public void unsetCode() {
		thoroughfareTrailingType.setCode(null);
	}
	
}
