package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.MailStopType;
import org.citygml4j.model.xal.MailStopNumber;
import org.citygml4j.model.xal.XALClass;

public class MailStopNumberImpl extends XALBaseImpl implements MailStopNumber {
	private MailStopType.MailStopNumber mailStopNumber;
	
	public MailStopNumberImpl() {
		mailStopNumber = new MailStopType.MailStopNumber();
	}
	
	public MailStopNumberImpl(MailStopType.MailStopNumber mailStopNumber) {
		this.mailStopNumber = mailStopNumber;
	}
	
	@Override
	public MailStopType.MailStopNumber getJAXBObject() {
		return mailStopNumber;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.MAILSTOPNUMBER;
	}

	public String getContent() {
		return mailStopNumber.getContent();
	}

	public String getNameNumberSeparator() {
		return mailStopNumber.getNameNumberSeparator();
	}

	public void setContent(String content) {
		mailStopNumber.setContent(content);
	}

	public void setNameNumberSeparator(String nameNumberSeparator) {
		mailStopNumber.setNameNumberSeparator(nameNumberSeparator);
	}

	public String getCode() {
		return mailStopNumber.getCode();
	}

	public void setCode(String code) {
		mailStopNumber.setCode(code);
	}

	public boolean isSetContent() {
		return mailStopNumber.isSetContent();
	}

	public boolean isSetNameNumberSeparator() {
		return mailStopNumber.isSetNameNumberSeparator();
	}

	public void unsetContent() {
		mailStopNumber.setContent(null);
	}

	public void unsetNameNumberSeparator() {
		mailStopNumber.setNameNumberSeparator(null);
	}

	public boolean isSetCode() {
		return mailStopNumber.isSetCode();
	}

	public void unsetCode() {
		mailStopNumber.setCode(null);
	}

}
