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

	public String getContent() {
		return localityName.getContent();
	}

	public String getType() {
		return localityName.getType();
	}

	public void setContent(String content) {
		localityName.setContent(content);
	}

	public void setType(String type) {
		localityName.setType(type);
	}

	public String getCode() {
		return localityName.getCode();
	}

	public void setCode(String code) {
		localityName.setCode(code);
	}

	public boolean isSetContent() {
		return localityName.isSetContent();
	}

	public boolean isSetType() {
		return localityName.isSetType();
	}

	public void unsetContent() {
		localityName.setContent(null);
	}

	public void unsetType() {
		localityName.setType(null);
	}

	public boolean isSetCode() {
		return localityName.isSetCode();
	}

	public void unsetCode() {
		localityName.setCode(null);
	}
}
