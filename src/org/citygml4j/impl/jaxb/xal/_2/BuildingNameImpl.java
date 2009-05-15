package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.BuildingNameType;
import org.citygml4j.model.xal.BuildingName;
import org.citygml4j.model.xal.XALClass;

public class BuildingNameImpl extends XALBaseImpl implements BuildingName {
	private BuildingNameType buildingName;
	
	public BuildingNameImpl() {
		buildingName = new BuildingNameType();
	}
	
	public BuildingNameImpl(BuildingNameType buildingName) {
		this.buildingName = buildingName;
	}
	
	@Override
	public BuildingNameType getJAXBObject() {
		return buildingName;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.BUILDINGNAME;
	}

	public String getContent() {
		return buildingName.getContent();
	}

	public String getType() {
		return buildingName.getType();
	}

	public String getTypeOccurrence() {
		return buildingName.getTypeOccurrence();
	}

	public void setContent(String content) {
		buildingName.setContent(content);
	}

	public void setType(String type) {
		buildingName.setType(type);
	}

	public void setTypeOccurrence(String typeOccurrence) {
		if (typeOccurrence.equals("Before") || typeOccurrence.equals("After"))
			buildingName.setTypeOccurrence(typeOccurrence);
	}

	public String getCode() {
		return buildingName.getCode();
	}

	public void setCode(String code) {
		buildingName.setCode(code);
	}

	public boolean isSetContent() {
		return buildingName.isSetContent();
	}

	public boolean isSetType() {
		return buildingName.isSetType();
	}

	public boolean isSetTypeOccurrence() {
		return buildingName.isSetTypeOccurrence();
	}

	public void unsetContent() {
		buildingName.setContent(null);
	}

	public void unsetType() {
		buildingName.setType(null);
	}

	public void unsetTypeOccurrence() {
		buildingName.setTypeOccurrence(null);
	}

	public boolean isSetCode() {
		return buildingName.isSetCode();
	}

	public void unsetCode() {
		buildingName.setCode(null);
	}

}
