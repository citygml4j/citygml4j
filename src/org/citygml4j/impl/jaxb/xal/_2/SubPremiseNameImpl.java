package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.SubPremiseType;
import org.citygml4j.model.xal.SubPremiseName;
import org.citygml4j.model.xal.XALClass;

public class SubPremiseNameImpl extends XALBaseImpl implements SubPremiseName {
	private SubPremiseType.SubPremiseName subPremiseName;
	
	public SubPremiseNameImpl() {
		subPremiseName = new SubPremiseType.SubPremiseName();
	}
	
	public SubPremiseNameImpl(SubPremiseType.SubPremiseName subPremiseName) {
		this.subPremiseName = subPremiseName;
	}
	
	@Override
	public SubPremiseType.SubPremiseName getJAXBObject() {
		return subPremiseName;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.SUBPREMISENAME;
	}

	public String getContent() {
		return subPremiseName.getContent();
	}

	public String getType() {
		return subPremiseName.getType();
	}

	public String getTypeOccurrence() {
		return subPremiseName.getTypeOccurrence();
	}

	public void setContent(String content) {
		subPremiseName.setContent(content);
	}

	public void setType(String type) {
		subPremiseName.setType(type);
	}

	public void setTypeOccurrence(String typeOccurrence) {
		if (typeOccurrence.equals("Before") || typeOccurrence.equals("After"))
			subPremiseName.setTypeOccurrence(typeOccurrence);
	}

	public String getCode() {
		return subPremiseName.getCode();
	}

	public void setCode(String code) {
		subPremiseName.setCode(code);
	}

	public boolean isSetContent() {
		return subPremiseName.isSetContent();
	}

	public boolean isSetType() {
		return subPremiseName.isSetType();
	}

	public void unsetContent() {
		subPremiseName.setContent(null);
	}

	public void unsetType() {
		subPremiseName.setType(null);
	}

	public boolean isSetCode() {
		return subPremiseName.isSetCode();
	}

	public void unsetCode() {
		subPremiseName.setCode(null);
	}

	public boolean isSetTypeOccurrence() {
		return subPremiseName.isSetTypeOccurrence();
	}

	public void unsetTypeOccurrence() {
		subPremiseName.setTypeOccurrence(null);
	}
	
}
