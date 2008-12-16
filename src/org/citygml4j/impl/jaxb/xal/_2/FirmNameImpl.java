package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.FirmType;
import org.citygml4j.model.xal.FirmName;
import org.citygml4j.model.xal.XALClass;

public class FirmNameImpl extends XALBaseImpl implements FirmName {
	private FirmType.FirmName firmName;
	
	public FirmNameImpl() {
		firmName = new FirmType.FirmName();
	}
	
	public FirmNameImpl(FirmType.FirmName firmName) {
		this.firmName = firmName;
	}
	
	@Override
	public FirmType.FirmName getJAXBObject() {
		return firmName;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.FIRMNAME;
	}

	@Override
	public String getContent() {
		return firmName.getContent();
	}

	@Override
	public String getType() {
		return firmName.getType();
	}

	@Override
	public void setContent(String content) {
		firmName.setContent(content);
	}

	@Override
	public void setType(String type) {
		firmName.setType(type);
	}

	@Override
	public String getCode() {
		return firmName.getCode();
	}

	@Override
	public void setCode(String code) {
		firmName.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return firmName.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return firmName.isSetType();
	}

	@Override
	public void unsetContent() {
		firmName.setContent(null);
	}

	@Override
	public void unsetType() {
		firmName.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return firmName.isSetCode();
	}

	@Override
	public void unsetCode() {
		firmName.setCode(null);
	}
}
