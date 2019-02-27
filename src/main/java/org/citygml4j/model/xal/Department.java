/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2019 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

import java.util.List;

public class Department implements XAL, Child, Copyable {
	private List<AddressLine> addressLine;
	private List<DepartmentName> departmentName;
	private MailStop mailStop;
	private PostalCode postalCode;
	private String type;
	private ModelObject parent;

	public void addAddressLine(AddressLine addressLine) {
		getAddressLine().add(addressLine);
	}

	public void addDepartmentName(DepartmentName departmentName) {
		getDepartmentName().add(departmentName);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<>(this);

		return addressLine;
	}

	public List<DepartmentName> getDepartmentName() {
		if (departmentName == null)
			departmentName = new ChildList<>(this);

		return departmentName;
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

	public boolean isSetDepartmentName() {
		return departmentName != null && !departmentName.isEmpty();
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
		this.addressLine = new ChildList<>(this, addressLine);
	}

	public void setDepartmentName(List<DepartmentName> departmentName) {
		this.departmentName = new ChildList<>(this, departmentName);
	}

	public void setMailStop(MailStop mailStop) {
		this.mailStop = ModelObjects.setParent(mailStop, this);
	}

	public void setPostalCode(PostalCode postalCode) {
		this.postalCode = ModelObjects.setParent(postalCode, this);
	}

	public void setType(String type) {
		this.type = type;
	}

	public void unsetAddressLine() {
		addressLine = ModelObjects.setNull(addressLine);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		return isSetAddressLine() && this.addressLine.remove(addressLine);
	}

	public void unsetDepartmentName() {
		departmentName = ModelObjects.setNull(departmentName);
	}

	public boolean unsetDepartmentName(DepartmentName departmentName) {
		return isSetDepartmentName() && this.departmentName.remove(departmentName);
	}

	public void unsetMailStop() {
		mailStop = ModelObjects.setNull(mailStop);
	}

	public void unsetPostalCode() {
		postalCode = ModelObjects.setNull(postalCode);
	}

	public void unsetType() {
		type = null;
	}

	public XALClass getXALClass() {
		return XALClass.DEPARTMENT;
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
		return copyTo(new Department(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Department copy = (target == null) ? new Department() : (Department)target;

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

		if (isSetDepartmentName()) {
			for (DepartmentName part : departmentName) {
				DepartmentName copyPart = (DepartmentName)copyBuilder.copy(part);
				copy.addDepartmentName(copyPart);

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
	
	public void accept(XALVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(XALFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
