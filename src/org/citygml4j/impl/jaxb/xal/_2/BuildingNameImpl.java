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

	@Override
	public String getContent() {
		return buildingName.getContent();
	}

	@Override
	public String getType() {
		return buildingName.getType();
	}

	@Override
	public String getTypeOccurrence() {
		return buildingName.getTypeOccurrence();
	}

	@Override
	public void setContent(String content) {
		buildingName.setContent(content);
	}

	@Override
	public void setType(String type) {
		buildingName.setType(type);
	}

	@Override
	public void setTypeOccurrence(String typeOccurrence) {
		if (typeOccurrence.equals("Before") || typeOccurrence.equals("After"))
			buildingName.setTypeOccurrence(typeOccurrence);
	}

	@Override
	public String getCode() {
		return buildingName.getCode();
	}

	@Override
	public void setCode(String code) {
		buildingName.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return buildingName.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return buildingName.isSetType();
	}

	@Override
	public boolean isSetTypeOccurrence() {
		return buildingName.isSetTypeOccurrence();
	}

	@Override
	public void unsetContent() {
		buildingName.setContent(null);
	}

	@Override
	public void unsetType() {
		buildingName.setType(null);
	}

	@Override
	public void unsetTypeOccurrence() {
		buildingName.setTypeOccurrence(null);
	}

	@Override
	public boolean isSetCode() {
		return buildingName.isSetCode();
	}

	@Override
	public void unsetCode() {
		buildingName.setCode(null);
	}

}
