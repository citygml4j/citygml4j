package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.PremiseElement;
import org.citygml4j.model.xal.PremiseName;
import org.citygml4j.model.xal.XALClass;

public class PremiseNameImpl extends XALBaseImpl implements PremiseName {
	private PremiseElement.PremiseName premiseName;
	
	public PremiseNameImpl() {
		premiseName = new PremiseElement.PremiseName();
	}
	
	public PremiseNameImpl(PremiseElement.PremiseName premiseName) {
		this.premiseName = premiseName;
	}
	
	@Override
	public PremiseElement.PremiseName getJAXBObject() {
		return premiseName;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.PREMISENAME;
	}

	public String getContent() {
		return premiseName.getContent();
	}

	public String getType() {
		return premiseName.getType();
	}

	public String getTypeOccurrence() {
		return premiseName.getTypeOccurrence();
	}

	public void setContent(String content) {
		premiseName.setContent(content);
	}

	public void setType(String type) {
		premiseName.setType(type);
	}

	public void setTypeOccurrence(String typeOccurrence) {
		if (typeOccurrence.equals("Before") || typeOccurrence.equals("After"))
			premiseName.setTypeOccurrence(typeOccurrence);
	}

	public String getCode() {
		return premiseName.getCode();
	}

	public void setCode(String code) {
		premiseName.setCode(code);
	}

	public boolean isSetContent() {
		return premiseName.isSetContent();
	}

	public boolean isSetType() {
		return premiseName.isSetType();
	}
	
	public boolean isSetTypeOccurrence() {
		return premiseName.isSetTypeOccurrence();
	}

	public void unsetContent() {
		premiseName.setContent(null);
	}

	public void unsetType() {
		premiseName.setType(null);
	}
	
	public void unsetTypeOccurrence() {
		premiseName.setTypeOccurrence(null);
	}

	public boolean isSetCode() {
		return premiseName.isSetCode();
	}

	public void unsetCode() {
		premiseName.setCode(null);
	}
}
