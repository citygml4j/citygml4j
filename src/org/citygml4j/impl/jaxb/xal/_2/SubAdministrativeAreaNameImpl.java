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

	@Override
	public String getContent() {
		return subAreaName.getContent();
	}

	@Override
	public String getType() {
		return subAreaName.getType();
	}

	@Override
	public void setContent(String content) {
		subAreaName.setContent(content);
	}

	@Override
	public void setType(String type) {
		subAreaName.setType(type);
	}

	@Override
	public String getCode() {
		return subAreaName.getCode();
	}

	@Override
	public void setCode(String code) {
		subAreaName.setCode(code);
	}
	
	@Override
	public boolean isSetContent() {
		return subAreaName.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return subAreaName.isSetType();
	}

	@Override
	public void unsetContent() {
		subAreaName.setContent(null);
	}

	@Override
	public void unsetType() {
		subAreaName.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return subAreaName.isSetCode();
	}

	@Override
	public void unsetCode() {
		subAreaName.setCode(null);
	}

}
