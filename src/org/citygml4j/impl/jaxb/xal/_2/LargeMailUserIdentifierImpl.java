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

	@Override
	public String getContent() {
		return largeMailUserIdentifier.getContent();
	}

	@Override
	public String getIndicator() {
		return largeMailUserIdentifier.getIndicator();
	}

	@Override
	public String getType() {
		return largeMailUserIdentifier.getType();
	}

	@Override
	public void setContent(String content) {
		largeMailUserIdentifier.setContent(content);
	}

	@Override
	public void setIndicator(String indicator) {
		largeMailUserIdentifier.setIndicator(indicator);
	}

	@Override
	public void setType(String type) {
		largeMailUserIdentifier.setType(type);
	}

	@Override
	public String getCode() {
		return largeMailUserIdentifier.getCode();
	}

	@Override
	public void setCode(String code) {
		largeMailUserIdentifier.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return largeMailUserIdentifier.isSetContent();
	}

	@Override
	public boolean isSetIndicator() {
		return largeMailUserIdentifier.isSetIndicator();
	}

	@Override
	public boolean isSetType() {
		return largeMailUserIdentifier.isSetType();
	}

	@Override
	public void unsetContent() {
		largeMailUserIdentifier.setContent(null);
	}

	@Override
	public void unsetIndicator() {
		largeMailUserIdentifier.setIndicator(null);
	}

	@Override
	public void unsetType() {
		largeMailUserIdentifier.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return largeMailUserIdentifier.isSetCode();
	}

	@Override
	public void unsetCode() {
		largeMailUserIdentifier.setCode(null);
	}

}
