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

	public String getContent() {
		return premiseLocation.getContent();
	}

	public void setContent(String content) {
		premiseLocation.setContent(content);
	}

	public String getCode() {
		return premiseLocation.getCode();
	}

	public void setCode(String code) {
		premiseLocation.setCode(code);
	}

	public boolean isSetContent() {
		return premiseLocation.isSetContent();
	}

	public void unsetContent() {
		premiseLocation.setContent(null);
	}

	public boolean isSetCode() {
		return premiseLocation.isSetCode();
	}

	public void unsetCode() {
		premiseLocation.setCode(null);
	}
}
