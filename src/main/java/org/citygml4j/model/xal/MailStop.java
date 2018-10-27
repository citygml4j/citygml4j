/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

import java.util.List;

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
	
	public void accept(XALVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(XALFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
