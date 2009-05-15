package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.ThoroughfarePostDirectionType;
import org.citygml4j.model.xal.ThoroughfarePostDirection;
import org.citygml4j.model.xal.XALClass;

public class ThoroughfarePostDirectionImpl extends XALBaseImpl implements ThoroughfarePostDirection {
	private ThoroughfarePostDirectionType thoroughfarePostDirectionType;
	
	public ThoroughfarePostDirectionImpl() {
		thoroughfarePostDirectionType = new ThoroughfarePostDirectionType();
	}
	
	public ThoroughfarePostDirectionImpl(ThoroughfarePostDirectionType thoroughfarePostDirectionType) {
		this.thoroughfarePostDirectionType = thoroughfarePostDirectionType;
	}
	
	@Override
	public ThoroughfarePostDirectionType getJAXBObject() {
		return thoroughfarePostDirectionType;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.THOROUGHFAREPOSTDIRECTION;
	}

	public String getContent() {
		return thoroughfarePostDirectionType.getContent();
	}

	public String getType() {
		return thoroughfarePostDirectionType.getType();
	}

	public void setContent(String content) {
		thoroughfarePostDirectionType.setContent(content);
	}

	public void setType(String type) {
		thoroughfarePostDirectionType.setType(type);
	}

	public String getCode() {
		return thoroughfarePostDirectionType.getCode();
	}

	public void setCode(String code) {
		thoroughfarePostDirectionType.setCode(code);
	}

	public boolean isSetContent() {
		return thoroughfarePostDirectionType.isSetContent();
	}

	public boolean isSetType() {
		return thoroughfarePostDirectionType.isSetType();
	}

	public void unsetContent() {
		thoroughfarePostDirectionType.setContent(null);
	}

	public void unsetType() {
		thoroughfarePostDirectionType.setType(null);
	}

	public boolean isSetCode() {
		return thoroughfarePostDirectionType.isSetCode();
	}

	public void unsetCode() {
		thoroughfarePostDirectionType.setCode(null);
	}
}
