package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.LargeMailUserType;
import org.citygml4j.model.xal.LargeMailUserName;
import org.citygml4j.model.xal.XALClass;

public class LargeMailUserNameImpl extends XALBaseImpl implements LargeMailUserName {
	private LargeMailUserType.LargeMailUserName largeMailUserName;
	
	public LargeMailUserNameImpl() {
		largeMailUserName = new LargeMailUserType.LargeMailUserName();
	}
	
	public LargeMailUserNameImpl(LargeMailUserType.LargeMailUserName largeMailUserName) {
		this.largeMailUserName = largeMailUserName;
	}
	
	@Override
	public LargeMailUserType.LargeMailUserName getJAXBObject() {
		return largeMailUserName;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.LARGEMAILUSERNAME;
	}

	public String getCode() {
		return largeMailUserName.getCode();
	}

	public String getContent() {
		return largeMailUserName.getContent();
	}

	public String getType() {
		return largeMailUserName.getType();
	}

	public void setCode(String code) {
		largeMailUserName.setCode(code);
	}

	public void setContent(String content) {
		largeMailUserName.setContent(content);
	}

	public void setType(String type) {
		largeMailUserName.setType(type);
	}

	public boolean isSetContent() {
		return largeMailUserName.isSetContent();
	}

	public boolean isSetType() {
		return largeMailUserName.isSetType();
	}

	public void unsetContent() {
		largeMailUserName.setContent(null);
	}

	public void unsetType() {
		largeMailUserName.setType(null);
	}

	public boolean isSetCode() {
		return largeMailUserName.isSetCode();
	}

	public void unsetCode() {
		largeMailUserName.setCode(null);
	}
}
