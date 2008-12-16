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

	@Override
	public String getContent() {
		return thoroughfarePreDirectionType.getContent();
	}

	@Override
	public String getType() {
		return thoroughfarePreDirectionType.getType();
	}

	@Override
	public void setContent(String content) {
		thoroughfarePreDirectionType.setContent(content);
	}

	@Override
	public void setType(String type) {
		thoroughfarePreDirectionType.setType(type);
	}

	@Override
	public String getCode() {
		return thoroughfarePreDirectionType.getCode();
	}

	@Override
	public void setCode(String code) {
		thoroughfarePreDirectionType.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return thoroughfarePreDirectionType.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return thoroughfarePreDirectionType.isSetType();
	}

	@Override
	public void unsetContent() {
		thoroughfarePreDirectionType.setContent(null);
	}

	@Override
	public void unsetType() {
		thoroughfarePreDirectionType.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return thoroughfarePreDirectionType.isSetCode();
	}

	@Override
	public void unsetCode() {
		thoroughfarePreDirectionType.setCode(null);
	}
}
