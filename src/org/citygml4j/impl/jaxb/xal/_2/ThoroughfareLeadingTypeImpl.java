package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.ThoroughfareLeadingTypeType;
import org.citygml4j.model.xal.ThoroughfareLeadingType;
import org.citygml4j.model.xal.XALClass;

public class ThoroughfareLeadingTypeImpl extends XALBaseImpl implements ThoroughfareLeadingType {
	private ThoroughfareLeadingTypeType thoroughfareLeadingType;
	
	public ThoroughfareLeadingTypeImpl() {
		thoroughfareLeadingType = new ThoroughfareLeadingTypeType();
	}
	
	public ThoroughfareLeadingTypeImpl(ThoroughfareLeadingTypeType thoroughfareLeadingType) {
		this.thoroughfareLeadingType = thoroughfareLeadingType;
	}
	
	@Override
	public ThoroughfareLeadingTypeType getJAXBObject() {
		return thoroughfareLeadingType;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.THOROUGHFARELEADINGTYPE;
	}

	public String getCode() {
		return thoroughfareLeadingType.getCode();
	}

	public void setCode(String code) {
		thoroughfareLeadingType.setCode(code);
	}

	public String getContent() {
		return thoroughfareLeadingType.getContent();
	}

	public String getType() {
		return thoroughfareLeadingType.getType();
	}

	public void setContent(String content) {
		thoroughfareLeadingType.setContent(content);
	}

	public void setType(String type) {
		thoroughfareLeadingType.setType(type);
	}

	public boolean isSetContent() {
		return thoroughfareLeadingType.isSetContent();
	}

	public boolean isSetType() {
		return thoroughfareLeadingType.isSetType();
	}

	public void unsetContent() {
		thoroughfareLeadingType.setContent(null);
	}

	public void unsetType() {
		thoroughfareLeadingType.setType(null);
	}

	public boolean isSetCode() {
		return thoroughfareLeadingType.isSetCode();
	}

	public void unsetCode() {
		thoroughfareLeadingType.setCode(null);
	}
}
