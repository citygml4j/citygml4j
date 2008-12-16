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

	@Override
	public String getContent() {
		return premiseName.getContent();
	}

	@Override
	public String getType() {
		return premiseName.getType();
	}

	@Override
	public String getTypeOccurrence() {
		return premiseName.getTypeOccurrence();
	}

	@Override
	public void setContent(String content) {
		premiseName.setContent(content);
	}

	@Override
	public void setType(String type) {
		premiseName.setType(type);
	}

	@Override
	public void setTypeOccurrence(String typeOccurrence) {
		if (typeOccurrence.equals("Before") || typeOccurrence.equals("After"))
			premiseName.setTypeOccurrence(typeOccurrence);
	}

	@Override
	public String getCode() {
		return premiseName.getCode();
	}

	@Override
	public void setCode(String code) {
		premiseName.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return premiseName.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return premiseName.isSetType();
	}
	
	@Override
	public boolean isSetTypeOccurrence() {
		return premiseName.isSetTypeOccurrence();
	}

	@Override
	public void unsetContent() {
		premiseName.setContent(null);
	}

	@Override
	public void unsetType() {
		premiseName.setType(null);
	}
	
	@Override
	public void unsetTypeOccurrence() {
		premiseName.setTypeOccurrence(null);
	}

	@Override
	public boolean isSetCode() {
		return premiseName.isSetCode();
	}

	@Override
	public void unsetCode() {
		premiseName.setCode(null);
	}
}
