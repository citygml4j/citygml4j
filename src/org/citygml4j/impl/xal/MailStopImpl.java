package org.citygml4j.impl.xal;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.MailStop;
import org.citygml4j.model.xal.MailStopName;
import org.citygml4j.model.xal.MailStopNumber;
import org.citygml4j.model.xal.XALClass;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public class MailStopImpl implements MailStop {
	private List<AddressLine> addressLine;
	private MailStopName mailStopName;
	private MailStopNumber mailStopNumber;
	private String type;
	private Object parent;
	
	public void addAddressLine(AddressLine addressLine) {
		if (this.addressLine == null)
			this.addressLine = new ChildList<AddressLine>(this);

		this.addressLine.add(addressLine);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<AddressLine>(this);

		return addressLine;
	}

	public MailStopName getMailStopName() {
		return mailStopName;
	}

	public MailStopNumber getMailStopNumber() {
		return mailStopNumber;
	}

	public String getType() {
		return type;
	}

	public boolean isSetAddressLine() {
		return addressLine != null && !addressLine.isEmpty();
	}

	public boolean isSetMailStopName() {
		return mailStopName != null;
	}

	public boolean isSetMailStopNumber() {
		return mailStopNumber != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		this.addressLine = new ChildList<AddressLine>(this, addressLine);
	}

	public void setMailStopName(MailStopName mailStopName) {
		if (mailStopName != null)
			mailStopName.setParent(this);
		
		this.mailStopName = mailStopName;
	}

	public void setMailStopNumber(MailStopNumber mailStopNumber) {
		if (mailStopNumber != null)
			mailStopNumber.setParent(this);
		
		this.mailStopNumber = mailStopNumber;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void unsetAddressLine() {
		if (isSetAddressLine())
			addressLine.clear();
		
		addressLine = null;
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		return isSetAddressLine() ? this.addressLine.remove(addressLine) : false;
	}

	public void unsetMailStopName() {
		if (isSetMailStopName())
			mailStopName.unsetParent();
		
		mailStopName = null;
	}

	public void unsetMailStopNumber() {
		if (isSetMailStopNumber())
			mailStopNumber.unsetParent();
		
		mailStopNumber = null;
	}

	public void unsetType() {
		type = null;
	}

	public XALClass getXALClass() {
		return XALClass.MAILSTOP;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MailStopImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MailStop copy = (target == null) ? new MailStopImpl() : (MailStop)target;
		
		if (isSetType())
			copy.setType(copyBuilder.copy(type));
		
		if (isSetAddressLine()) {
			for (AddressLine part : addressLine) {
				AddressLine copyPart = (AddressLine)copyBuilder.copy(part);
				copy.addAddressLine(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetMailStopName()) {
			copy.setMailStopName((MailStopName)copyBuilder.copy(mailStopName));
			if (copy.getMailStopName() == mailStopName)
				mailStopName.setParent(this);
		}
		
		if (isSetMailStopNumber()) {
			copy.setMailStopNumber((MailStopNumber)copyBuilder.copy(mailStopNumber));
			if (copy.getMailStopNumber() == mailStopNumber)
				mailStopNumber.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}
	
	public void visit(XALVisitor visitor) {
		visitor.accept(this);
	}
	
	public <T> T visit(XALFunction<T> visitor) {
		return visitor.accept(this);
	}

}
