package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.MailStopType;
import org.citygml4j.model.xal.MailStopName;
import org.citygml4j.model.xal.XALClass;

public class MailStopNameImpl extends XALBaseImpl implements MailStopName {
	private MailStopType.MailStopName mailStopName;
	
	public MailStopNameImpl() {
		mailStopName = new MailStopType.MailStopName();
	}
	
	public MailStopNameImpl(MailStopType.MailStopName mailStopName) {
		this.mailStopName = mailStopName;
	}
	
	@Override
	public MailStopType.MailStopName getJAXBObject() {
		return mailStopName;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.MAILSTOPNAME;
	}

	public String getCode() {
		return mailStopName.getCode();
	}

	public void setCode(String code) {
		mailStopName.setCode(code);
	}

	public String getContent() {
		return mailStopName.getContent();
	}

	public String getType() {
		return mailStopName.getType();
	}

	public void setContent(String content) {
		mailStopName.setContent(content);
	}

	public void setType(String type) {
		mailStopName.setType(type);		
	}

	public boolean isSetContent() {
		return mailStopName.isSetContent();
	}

	public boolean isSetType() {
		return mailStopName.isSetType();
	}

	public void unsetContent() {
		mailStopName.setContent(null);
	}

	public void unsetType() {
		mailStopName.setType(null);
	}

	public boolean isSetCode() {
		return mailStopName.isSetCode();
	}

	public void unsetCode() {
		mailStopName.setCode(null);
	}
}
