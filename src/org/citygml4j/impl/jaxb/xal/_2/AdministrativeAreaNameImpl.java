package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.AdministrativeAreaElement;
import org.citygml4j.model.xal.AdministrativeAreaName;
import org.citygml4j.model.xal.XALClass;

public class AdministrativeAreaNameImpl extends XALBaseImpl implements AdministrativeAreaName {
	private AdministrativeAreaElement.AdministrativeAreaName areaName;
	
	public AdministrativeAreaNameImpl() {
		areaName = new AdministrativeAreaElement.AdministrativeAreaName();
	}
	
	public AdministrativeAreaNameImpl(AdministrativeAreaElement.AdministrativeAreaName areaName) {
		this.areaName = areaName;
	}
	
	@Override
	public AdministrativeAreaElement.AdministrativeAreaName getJAXBObject() {
		return areaName;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.ADMINISTRATIVEAREANAME;
	}

	public String getContent() {
		return areaName.getContent();
	}

	public String getType() {
		return areaName.getType();
	}

	public void setContent(String content) {
		areaName.setContent(content);
	}

	public void setType(String type) {
		areaName.setType(type);
	}

	public String getCode() {
		return areaName.getCode();
	}

	public void setCode(String code) {
		areaName.setCode(code);
	}

	public boolean isSetContent() {
		return areaName.isSetContent();
	}

	public boolean isSetType() {
		return areaName.isSetType();
	}

	public void unsetContent() {
		areaName.setContent(null);
	}

	public void unsetType() {
		areaName.setType(null);
	}

	public boolean isSetCode() {
		return areaName.isSetCode();
	}

	public void unsetCode() {
		areaName.setCode(null);
	}

}
