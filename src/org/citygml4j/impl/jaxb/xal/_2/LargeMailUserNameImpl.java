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

	@Override
	public String getCode() {
		return largeMailUserName.getCode();
	}

	@Override
	public String getContent() {
		return largeMailUserName.getContent();
	}

	@Override
	public String getType() {
		return largeMailUserName.getType();
	}

	@Override
	public void setCode(String code) {
		largeMailUserName.setCode(code);
	}

	@Override
	public void setContent(String content) {
		largeMailUserName.setContent(content);
	}

	@Override
	public void setType(String type) {
		largeMailUserName.setType(type);
	}

	@Override
	public boolean isSetContent() {
		return largeMailUserName.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return largeMailUserName.isSetType();
	}

	@Override
	public void unsetContent() {
		largeMailUserName.setContent(null);
	}

	@Override
	public void unsetType() {
		largeMailUserName.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return largeMailUserName.isSetCode();
	}

	@Override
	public void unsetCode() {
		largeMailUserName.setCode(null);
	}
}
