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

	@Override
	public String getContent() {
		return mailStopNumber.getContent();
	}

	@Override
	public String getNameNumberSeparator() {
		return mailStopNumber.getNameNumberSeparator();
	}

	@Override
	public void setContent(String content) {
		mailStopNumber.setContent(content);
	}

	@Override
	public void setNameNumberSeparator(String nameNumberSeparator) {
		mailStopNumber.setNameNumberSeparator(nameNumberSeparator);
	}

	@Override
	public String getCode() {
		return mailStopNumber.getCode();
	}

	@Override
	public void setCode(String code) {
		mailStopNumber.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return mailStopNumber.isSetContent();
	}

	@Override
	public boolean isSetNameNumberSeparator() {
		return mailStopNumber.isSetNameNumberSeparator();
	}

	@Override
	public void unsetContent() {
		mailStopNumber.setContent(null);
	}

	@Override
	public void unsetNameNumberSeparator() {
		mailStopNumber.setNameNumberSeparator(null);
	}

	@Override
	public boolean isSetCode() {
		return mailStopNumber.isSetCode();
	}

	@Override
	public void unsetCode() {
		mailStopNumber.setCode(null);
	}

}
