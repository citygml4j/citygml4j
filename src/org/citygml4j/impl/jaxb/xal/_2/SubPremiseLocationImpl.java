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

	@Override
	public String getContent() {
		return subPremiseLocation.getContent();
	}

	@Override
	public void setContent(String content) {
		subPremiseLocation.setContent(content);
	}

	@Override
	public String getCode() {
		return subPremiseLocation.getCode();
	}

	@Override
	public void setCode(String code) {
		subPremiseLocation.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return subPremiseLocation.isSetContent();
	}

	@Override
	public void unsetContent() {
		subPremiseLocation.setContent(null);
	}

	@Override
	public boolean isSetCode() {
		return subPremiseLocation.isSetCode();
	}

	@Override
	public void unsetCode() {
		subPremiseLocation.setCode(null);
	}
}
