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

	@Override
	public String getContent() {
		return thoroughfarePostDirectionType.getContent();
	}

	@Override
	public String getType() {
		return thoroughfarePostDirectionType.getType();
	}

	@Override
	public void setContent(String content) {
		thoroughfarePostDirectionType.setContent(content);
	}

	@Override
	public void setType(String type) {
		thoroughfarePostDirectionType.setType(type);
	}

	@Override
	public String getCode() {
		return thoroughfarePostDirectionType.getCode();
	}

	@Override
	public void setCode(String code) {
		thoroughfarePostDirectionType.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return thoroughfarePostDirectionType.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return thoroughfarePostDirectionType.isSetType();
	}

	@Override
	public void unsetContent() {
		thoroughfarePostDirectionType.setContent(null);
	}

	@Override
	public void unsetType() {
		thoroughfarePostDirectionType.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return thoroughfarePostDirectionType.isSetCode();
	}

	@Override
	public void unsetCode() {
		thoroughfarePostDirectionType.setCode(null);
	}
}
