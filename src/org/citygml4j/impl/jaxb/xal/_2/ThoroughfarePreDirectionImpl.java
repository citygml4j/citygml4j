package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.ThoroughfarePreDirectionType;
import org.citygml4j.model.xal.ThoroughfarePreDirection;
import org.citygml4j.model.xal.XALClass;

public class ThoroughfarePreDirectionImpl extends XALBaseImpl implements ThoroughfarePreDirection {
	private ThoroughfarePreDirectionType thoroughfarePreDirectionType;
	
	public ThoroughfarePreDirectionImpl() {
		thoroughfarePreDirectionType = new ThoroughfarePreDirectionType();
	}
	
	public ThoroughfarePreDirectionImpl(ThoroughfarePreDirectionType thoroughfarePreDirectionType) {
		this.thoroughfarePreDirectionType = thoroughfarePreDirectionType;
	}
	
	@Override
	public ThoroughfarePreDirectionType getJAXBObject() {
		return thoroughfarePreDirectionType;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.THOROUGHFAREPREDIRECTION;
	}

	public String getContent() {
		return thoroughfarePreDirectionType.getContent();
	}

	public String getType() {
		return thoroughfarePreDirectionType.getType();
	}

	public void setContent(String content) {
		thoroughfarePreDirectionType.setContent(content);
	}

	public void setType(String type) {
		thoroughfarePreDirectionType.setType(type);
	}

	public String getCode() {
		return thoroughfarePreDirectionType.getCode();
	}

	public void setCode(String code) {
		thoroughfarePreDirectionType.setCode(code);
	}

	public boolean isSetContent() {
		return thoroughfarePreDirectionType.isSetContent();
	}

	public boolean isSetType() {
		return thoroughfarePreDirectionType.isSetType();
	}

	public void unsetContent() {
		thoroughfarePreDirectionType.setContent(null);
	}

	public void unsetType() {
		thoroughfarePreDirectionType.setType(null);
	}

	public boolean isSetCode() {
		return thoroughfarePreDirectionType.isSetCode();
	}

	public void unsetCode() {
		thoroughfarePreDirectionType.setCode(null);
	}
}
