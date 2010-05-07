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

	public String getContent() {
		return firmName.getContent();
	}

	public String getType() {
		return firmName.getType();
	}

	public void setContent(String content) {
		firmName.setContent(content);
	}

	public void setType(String type) {
		firmName.setType(type);
	}

	public String getCode() {
		return firmName.getCode();
	}

	public void setCode(String code) {
		firmName.setCode(code);
	}

	public boolean isSetContent() {
		return firmName.isSetContent();
	}

	public boolean isSetType() {
		return firmName.isSetType();
	}

	public void unsetContent() {
		firmName.setContent(null);
	}

	public void unsetType() {
		firmName.setType(null);
	}

	public boolean isSetCode() {
		return firmName.isSetCode();
	}

	public void unsetCode() {
		firmName.setCode(null);
	}
}
