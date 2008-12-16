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

	@Override
	public String getCode() {
		return thoroughfareLeadingType.getCode();
	}

	@Override
	public void setCode(String code) {
		thoroughfareLeadingType.setCode(code);
	}

	@Override
	public String getContent() {
		return thoroughfareLeadingType.getContent();
	}

	@Override
	public String getType() {
		return thoroughfareLeadingType.getType();
	}

	@Override
	public void setContent(String content) {
		thoroughfareLeadingType.setContent(content);
	}

	@Override
	public void setType(String type) {
		thoroughfareLeadingType.setType(type);
	}

	@Override
	public boolean isSetContent() {
		return thoroughfareLeadingType.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return thoroughfareLeadingType.isSetType();
	}

	@Override
	public void unsetContent() {
		thoroughfareLeadingType.setContent(null);
	}

	@Override
	public void unsetType() {
		thoroughfareLeadingType.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return thoroughfareLeadingType.isSetCode();
	}

	@Override
	public void unsetCode() {
		thoroughfareLeadingType.setCode(null);
	}
}
