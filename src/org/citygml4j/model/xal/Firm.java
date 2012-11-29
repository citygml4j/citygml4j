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

public class Firm implements XAL, Child, Copyable {
	private List<AddressLine> addressLine;
	private List<FirmName> firmName;
	private List<Department> department;
	private MailStop mailStop;
	private PostalCode postalCode;
	private String type;
	private ModelObject parent;
	
	public void addAddressLine(AddressLine addressLine) {
		if (this.addressLine == null)
			this.addressLine = new ChildList<AddressLine>(this);

		this.addressLine.add(addressLine);
	}

	public void addDepartment(Department department) {
		if (this.department == null)
			this.department = new ChildList<Department>(this);

		this.department.add(department);
	}

	public void addFirmName(FirmName firmName) {
		if (this.firmName == null)
			this.firmName = new ChildList<FirmName>(this);

		this.firmName.add(firmName);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<AddressLine>(this);

		return addressLine;
	}

	public List<Department> getDepartment() {
		if (department == null)
			department = new ChildList<Department>(this);

		return department;
	}

	public List<FirmName> getFirmName() {
		if (firmName == null)
			firmName = new ChildList<FirmName>(this);

		return firmName;
	}

	public MailStop getMailStop() {
		return mailStop;
	}

	public PostalCode getPostalCode() {
		return postalCode;
	}

	public String getType() {
		return type;
	}

	public boolean isSetAddressLine() {
		return addressLine != null && !addressLine.isEmpty();
	}

	public boolean isSetDepartment() {
		return department != null && !department.isEmpty();
	}

	public boolean isSetFirmName() {
		return firmName != null && !firmName.isEmpty();
	}

	public boolean isSetMailStop() {
		return mailStop != null;
	}

	public boolean isSetPostalCode() {
		return postalCode != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		this.addressLine = new ChildList<AddressLine>(this, addressLine);
	}

	public void setDepartment(List<Department> department) {
		this.department = new ChildList<Department>(this, department);
	}

	public void setFirmName(List<FirmName> firmName) {
		this.firmName = new ChildList<FirmName>(this, firmName);
	}

	public void setMailStop(MailStop mailStop) {
		if (mailStop != null)
			mailStop.setParent(this);

		this.mailStop = mailStop;
	}

	public void setPostalCode(PostalCode postalCode) {
		if (postalCode != null)
			postalCode.setParent(this);

		this.postalCode = postalCode;
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

	public void unsetDepartment() {
		if (isSetDepartment())
			department.clear();

		department = null;
	}

	public boolean unsetDepartment(Department department) {
		return isSetDepartment() ? this.department.remove(department) : false;
	}

	public void unsetFirmName() {
		if (isSetFirmName())
			firmName.clear();

		firmName = null;
	}

	public boolean unsetFirmName(FirmName firmName) {
		return isSetFirmName() ? this.firmName.remove(firmName) : false;
	}

	public void unsetMailStop() {
		if (isSetMailStop())
			mailStop.unsetParent();

		mailStop = null;
	}

	public void unsetPostalCode() {
		if (isSetPostalCode())
			postalCode.unsetParent();

		postalCode = null;
	}

	public void unsetType() {
		type = null;
	}

	public ModelType getModelType() {
		return ModelType.XAL;
	}

	public XALClass getXALClass() {
		return XALClass.FIRM;
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
		return copyTo(new Firm(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Firm copy = (target == null) ? new Firm() : (Firm)target;
		
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

		if (isSetDepartment()) {
			for (Department part : department) {
				Department copyPart = (Department)copyBuilder.copy(part);
				copy.addDepartment(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetFirmName()) {
			for (FirmName part : firmName) {
				FirmName copyPart = (FirmName)copyBuilder.copy(part);
				copy.addFirmName(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetMailStop()) {
			copy.setMailStop((MailStop)copyBuilder.copy(mailStop));
			if (copy.getMailStop() == mailStop)
				mailStop.setParent(this);
		}

		if (isSetPostalCode()) {
			copy.setPostalCode((PostalCode)copyBuilder.copy(postalCode));
			if (copy.getPostalCode() == postalCode)
				postalCode.setParent(this);
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
