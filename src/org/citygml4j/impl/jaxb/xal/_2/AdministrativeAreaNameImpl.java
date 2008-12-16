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

	@Override
	public String getContent() {
		return areaName.getContent();
	}

	@Override
	public String getType() {
		return areaName.getType();
	}

	@Override
	public void setContent(String content) {
		areaName.setContent(content);
	}

	@Override
	public void setType(String type) {
		areaName.setType(type);
	}

	@Override
	public String getCode() {
		return areaName.getCode();
	}

	@Override
	public void setCode(String code) {
		areaName.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return areaName.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return areaName.isSetType();
	}

	@Override
	public void unsetContent() {
		areaName.setContent(null);
	}

	@Override
	public void unsetType() {
		areaName.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return areaName.isSetCode();
	}

	@Override
	public void unsetCode() {
		areaName.setCode(null);
	}

}
