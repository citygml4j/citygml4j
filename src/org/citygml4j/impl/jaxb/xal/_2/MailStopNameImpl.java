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

	@Override
	public String getCode() {
		return mailStopName.getCode();
	}

	@Override
	public void setCode(String code) {
		mailStopName.setCode(code);
	}

	@Override
	public String getContent() {
		return mailStopName.getContent();
	}

	@Override
	public String getType() {
		return mailStopName.getType();
	}

	@Override
	public void setContent(String content) {
		mailStopName.setContent(content);
	}

	@Override
	public void setType(String type) {
		mailStopName.setType(type);		
	}

	@Override
	public boolean isSetContent() {
		return mailStopName.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return mailStopName.isSetType();
	}

	@Override
	public void unsetContent() {
		mailStopName.setContent(null);
	}

	@Override
	public void unsetType() {
		mailStopName.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return mailStopName.isSetCode();
	}

	@Override
	public void unsetCode() {
		mailStopName.setCode(null);
	}
}
