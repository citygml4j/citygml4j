package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.PremiseElement;
import org.citygml4j.model.xal.PremiseLocation;
import org.citygml4j.model.xal.XALClass;

public class PremiseLocationImpl extends XALBaseImpl implements PremiseLocation {
	private PremiseElement.PremiseLocation premiseLocation;
	
	public PremiseLocationImpl() {
		premiseLocation = new PremiseElement.PremiseLocation();
	}
	
	public PremiseLocationImpl(PremiseElement.PremiseLocation premiseLocation) {
		this.premiseLocation = premiseLocation;
	}

	@Override
	public PremiseElement.PremiseLocation getJAXBObject() {
		return premiseLocation;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.PREMISELOCATION;
	}

	@Override
	public String getContent() {
		return premiseLocation.getContent();
	}

	@Override
	public void setContent(String content) {
		premiseLocation.setContent(content);
	}

	@Override
	public String getCode() {
		return premiseLocation.getCode();
	}

	@Override
	public void setCode(String code) {
		premiseLocation.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return premiseLocation.isSetContent();
	}

	@Override
	public void unsetContent() {
		premiseLocation.setContent(null);
	}

	@Override
	public boolean isSetCode() {
		return premiseLocation.isSetCode();
	}

	@Override
	public void unsetCode() {
		premiseLocation.setCode(null);
	}
}
