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

	@Override
	public void addAddressLine(AddressLine addressLine) {
		mailStop.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();
		List<AddressLineElement> addressLineElemList = mailStop.getAddressLine();

		for (AddressLineElement addressLineElem : addressLineElemList)
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	@Override
	public MailStopName getMailStopName() {
		if (mailStop.isSetMailStopName())
			return new MailStopNameImpl(mailStop.getMailStopName());

		return null;
	}

	@Override
	public MailStopNumber getMailStopNumber() {
		if (mailStop.isSetMailStopNumber())
			return new MailStopNumberImpl(mailStop.getMailStopNumber());

		return null;
	}

	@Override
	public String getType() {
		return mailStop.getType();
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		mailStop.unsetAddressLine();
		mailStop.getAddressLine().addAll(addressLineElemList);
	}

	@Override
	public void setMailStopName(MailStopName mailStopName) {
		mailStop.setMailStopName(((MailStopNameImpl)mailStopName).getJAXBObject());
	}

	@Override
	public void setMailStopNumber(MailStopNumber mailStopNumber) {
		mailStop.setMailStopNumber(((MailStopNumberImpl)mailStopNumber).getJAXBObject());
	}

	@Override
	public void setType(String type) {
		mailStop.setType(type);
	}

	@Override
	public boolean isSetAddressLine() {
		return mailStop.isSetAddressLine();
	}

	@Override
	public boolean isSetMailStopName() {
		return mailStop.isSetMailStopName();
	}

	@Override
	public boolean isSetMailStopNumber() {
		return mailStop.isSetMailStopNumber();
	}

	@Override
	public boolean isSetType() {
		return mailStop.isSetType();
	}

	@Override
	public void unsetAddressLine() {
		mailStop.unsetAddressLine();
	}

	@Override
	public void unsetMailStopName() {
		mailStop.setMailStopName(null);
	}

	@Override
	public void unsetMailStopNumber() {
		mailStop.setMailStopNumber(null);
	}

	@Override
	public void unsetType() {
		mailStop.setType(null);
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (mailStop.isSetAddressLine())
			return mailStop.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

}
