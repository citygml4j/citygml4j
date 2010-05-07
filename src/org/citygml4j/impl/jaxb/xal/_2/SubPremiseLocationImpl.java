package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.SubPremiseType;
import org.citygml4j.model.xal.SubPremiseLocation;
import org.citygml4j.model.xal.XALClass;

public class SubPremiseLocationImpl extends XALBaseImpl implements SubPremiseLocation {
	private SubPremiseType.SubPremiseLocation subPremiseLocation;
	
	public SubPremiseLocationImpl() {
		subPremiseLocation = new SubPremiseType.SubPremiseLocation();
	}
	
	public SubPremiseLocationImpl(SubPremiseType.SubPremiseLocation subPremiseLocation) {
		this.subPremiseLocation = subPremiseLocation;
	}
	
	@Override
	public SubPremiseType.SubPremiseLocation getJAXBObject() {
		return subPremiseLocation;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.SUBPREMISELOCATION;
	}

	public String getContent() {
		return subPremiseLocation.getContent();
	}

	public void setContent(String content) {
		subPremiseLocation.setContent(content);
	}

	public String getCode() {
		return subPremiseLocation.getCode();
	}

	public void setCode(String code) {
		subPremiseLocation.setCode(code);
	}

	public boolean isSetContent() {
		return subPremiseLocation.isSetContent();
	}

	public void unsetContent() {
		subPremiseLocation.setContent(null);
	}

	public boolean isSetCode() {
		return subPremiseLocation.isSetCode();
	}

	public void unsetCode() {
		subPremiseLocation.setCode(null);
	}
}
