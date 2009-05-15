package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.MailStopType;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.MailStop;
import org.citygml4j.model.xal.MailStopName;
import org.citygml4j.model.xal.MailStopNumber;
import org.citygml4j.model.xal.XALClass;

public class MailStopImpl extends XALBaseImpl implements MailStop {
	private MailStopType mailStop;

	public MailStopImpl() {
		mailStop = new MailStopType();
	}

	public MailStopImpl(MailStopType mailStop) {
		this.mailStop = mailStop;
	}

	@Override
	public MailStopType getJAXBObject() {
		return mailStop;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.MAILSTOP;
	}

	public void addAddressLine(AddressLine addressLine) {
		mailStop.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : mailStop.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	public MailStopName getMailStopName() {
		if (mailStop.isSetMailStopName())
			return new MailStopNameImpl(mailStop.getMailStopName());

		return null;
	}

	public MailStopNumber getMailStopNumber() {
		if (mailStop.isSetMailStopNumber())
			return new MailStopNumberImpl(mailStop.getMailStopNumber());

		return null;
	}

	public String getType() {
		return mailStop.getType();
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		mailStop.unsetAddressLine();
		mailStop.getAddressLine().addAll(addressLineElemList);
	}

	public void setMailStopName(MailStopName mailStopName) {
		mailStop.setMailStopName(((MailStopNameImpl)mailStopName).getJAXBObject());
	}

	public void setMailStopNumber(MailStopNumber mailStopNumber) {
		mailStop.setMailStopNumber(((MailStopNumberImpl)mailStopNumber).getJAXBObject());
	}

	public void setType(String type) {
		mailStop.setType(type);
	}

	public boolean isSetAddressLine() {
		return mailStop.isSetAddressLine();
	}

	public boolean isSetMailStopName() {
		return mailStop.isSetMailStopName();
	}

	public boolean isSetMailStopNumber() {
		return mailStop.isSetMailStopNumber();
	}

	public boolean isSetType() {
		return mailStop.isSetType();
	}

	public void unsetAddressLine() {
		mailStop.unsetAddressLine();
	}

	public void unsetMailStopName() {
		mailStop.setMailStopName(null);
	}

	public void unsetMailStopNumber() {
		mailStop.setMailStopNumber(null);
	}

	public void unsetType() {
		mailStop.setType(null);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		if (mailStop.isSetAddressLine())
			return mailStop.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

}
