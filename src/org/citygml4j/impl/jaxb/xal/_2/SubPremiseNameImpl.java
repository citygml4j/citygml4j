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

	@Override
	public String getContent() {
		return subPremiseName.getContent();
	}

	@Override
	public String getType() {
		return subPremiseName.getType();
	}

	@Override
	public String getTypeOccurrence() {
		return subPremiseName.getTypeOccurrence();
	}

	@Override
	public void setContent(String content) {
		subPremiseName.setContent(content);
	}

	@Override
	public void setType(String type) {
		subPremiseName.setType(type);
	}

	@Override
	public void setTypeOccurrence(String typeOccurrence) {
		if (typeOccurrence.equals("Before") || typeOccurrence.equals("After"))
			subPremiseName.setTypeOccurrence(typeOccurrence);
	}

	@Override
	public String getCode() {
		return subPremiseName.getCode();
	}

	@Override
	public void setCode(String code) {
		subPremiseName.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return subPremiseName.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return subPremiseName.isSetType();
	}

	@Override
	public void unsetContent() {
		subPremiseName.setContent(null);
	}

	@Override
	public void unsetType() {
		subPremiseName.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return subPremiseName.isSetCode();
	}

	@Override
	public void unsetCode() {
		subPremiseName.setCode(null);
	}

	@Override
	public boolean isSetTypeOccurrence() {
		return subPremiseName.isSetTypeOccurrence();
	}

	@Override
	public void unsetTypeOccurrence() {
		subPremiseName.setTypeOccurrence(null);
	}
	
}
