/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * $Id$
 */
package org.citygml4j.model.xal;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public class MailStop implements XAL, Child, Copyable {
	private List<AddressLine> addressLine;
	private MailStopName mailStopName;
	private MailStopNumber mailStopNumber;
	private String type;
	private ModelObject parent;
	
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

	public ModelType getModelType() {
		return ModelType.XAL;
	}

	public XALClass getXALClass() {
		return XALClass.MAIL_STOP;
	}

	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MailStop(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MailStop copy = (target == null) ? new MailStop() : (MailStop)target;
		
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
		visitor.visit(this);
	}
	
	public <T> T visit(XALFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
