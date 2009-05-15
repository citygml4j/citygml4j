package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.AdministrativeAreaElement;
import org.citygml4j.model.xal.SubAdministrativeAreaName;
import org.citygml4j.model.xal.XALClass;

public class SubAdministrativeAreaNameImpl extends XALBaseImpl implements SubAdministrativeAreaName {
	private AdministrativeAreaElement.SubAdministrativeArea.SubAdministrativeAreaName subAreaName;
	
	public SubAdministrativeAreaNameImpl() {
		subAreaName = new AdministrativeAreaElement.SubAdministrativeArea.SubAdministrativeAreaName();
	}
	
	public SubAdministrativeAreaNameImpl(AdministrativeAreaElement.SubAdministrativeArea.SubAdministrativeAreaName subAreaName) {
		this.subAreaName = subAreaName;
	}
	
	@Override
	public AdministrativeAreaElement.SubAdministrativeArea.SubAdministrativeAreaName getJAXBObject() {
		return subAreaName;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.SUBADMINISTRATIVEAREANAME;
	}

	public String getContent() {
		return subAreaName.getContent();
	}

	public String getType() {
		return subAreaName.getType();
	}

	public void setContent(String content) {
		subAreaName.setContent(content);
	}

	public void setType(String type) {
		subAreaName.setType(type);
	}

	public String getCode() {
		return subAreaName.getCode();
	}

	public void setCode(String code) {
		subAreaName.setCode(code);
	}
	
	public boolean isSetContent() {
		return subAreaName.isSetContent();
	}

	public boolean isSetType() {
		return subAreaName.isSetType();
	}

	public void unsetContent() {
		subAreaName.setContent(null);
	}

	public void unsetType() {
		subAreaName.setType(null);
	}

	public boolean isSetCode() {
		return subAreaName.isSetCode();
	}

	public void unsetCode() {
		subAreaName.setCode(null);
	}

}
