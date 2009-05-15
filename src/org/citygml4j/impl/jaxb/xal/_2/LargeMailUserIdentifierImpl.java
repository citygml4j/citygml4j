package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.LargeMailUserType;
import org.citygml4j.model.xal.LargeMailUserIdentifier;
import org.citygml4j.model.xal.XALClass;

public class LargeMailUserIdentifierImpl extends XALBaseImpl implements LargeMailUserIdentifier {
	private LargeMailUserType.LargeMailUserIdentifier largeMailUserIdentifier;
	
	public LargeMailUserIdentifierImpl() {
		largeMailUserIdentifier = new LargeMailUserType.LargeMailUserIdentifier();
	}
	
	public LargeMailUserIdentifierImpl(LargeMailUserType.LargeMailUserIdentifier largeMailUserIdentifier) {
		this.largeMailUserIdentifier = largeMailUserIdentifier;
	}
	
	@Override
	public LargeMailUserType.LargeMailUserIdentifier getJAXBObject() {
		return largeMailUserIdentifier;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.LARGEMAILUSERIDENTIFIER;
	}

	public String getContent() {
		return largeMailUserIdentifier.getContent();
	}

	public String getIndicator() {
		return largeMailUserIdentifier.getIndicator();
	}

	public String getType() {
		return largeMailUserIdentifier.getType();
	}

	public void setContent(String content) {
		largeMailUserIdentifier.setContent(content);
	}

	public void setIndicator(String indicator) {
		largeMailUserIdentifier.setIndicator(indicator);
	}

	public void setType(String type) {
		largeMailUserIdentifier.setType(type);
	}

	public String getCode() {
		return largeMailUserIdentifier.getCode();
	}

	public void setCode(String code) {
		largeMailUserIdentifier.setCode(code);
	}

	public boolean isSetContent() {
		return largeMailUserIdentifier.isSetContent();
	}

	public boolean isSetIndicator() {
		return largeMailUserIdentifier.isSetIndicator();
	}

	public boolean isSetType() {
		return largeMailUserIdentifier.isSetType();
	}

	public void unsetContent() {
		largeMailUserIdentifier.setContent(null);
	}

	public void unsetIndicator() {
		largeMailUserIdentifier.setIndicator(null);
	}

	public void unsetType() {
		largeMailUserIdentifier.setType(null);
	}

	public boolean isSetCode() {
		return largeMailUserIdentifier.isSetCode();
	}

	public void unsetCode() {
		largeMailUserIdentifier.setCode(null);
	}

}
