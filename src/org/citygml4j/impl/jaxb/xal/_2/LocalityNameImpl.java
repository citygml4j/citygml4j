package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.LocalityElement;
import org.citygml4j.model.xal.LocalityName;
import org.citygml4j.model.xal.XALClass;

public class LocalityNameImpl extends XALBaseImpl implements LocalityName {
	private LocalityElement.LocalityName localityName;
	
	public LocalityNameImpl() {
		localityName = new LocalityElement.LocalityName();
	}
	
	public LocalityNameImpl(LocalityElement.LocalityName localityName) {
		this.localityName = localityName;
	}
	
	@Override
	public LocalityElement.LocalityName getJAXBObject() {
		return localityName;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.LOCALITYNAME;
	}

	@Override
	public String getContent() {
		return localityName.getContent();
	}

	@Override
	public String getType() {
		return localityName.getType();
	}

	@Override
	public void setContent(String content) {
		localityName.setContent(content);
	}

	@Override
	public void setType(String type) {
		localityName.setType(type);
	}

	@Override
	public String getCode() {
		return localityName.getCode();
	}

	@Override
	public void setCode(String code) {
		localityName.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return localityName.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return localityName.isSetType();
	}

	@Override
	public void unsetContent() {
		localityName.setContent(null);
	}

	@Override
	public void unsetType() {
		localityName.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return localityName.isSetCode();
	}

	@Override
	public void unsetCode() {
		localityName.setCode(null);
	}
}
