/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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

public class AdministrativeArea implements XAL, Child, Copyable {
	private List<AddressLine> addressLine;
	private List<AdministrativeAreaName> administrativeAreaName;
	private SubAdministrativeArea subAdministrativeArea;
	private Locality locality;
	private PostOffice postOffice;
	private PostalCode postalCode;
	private String usageType;
	private String indicator;
	private String type;
	private ModelObject parent;

	public void addAddressLine(AddressLine addressLine) {
		getAddressLine().add(addressLine);
	}

	public void addAdministrativeAreaName(AdministrativeAreaName administrativeAreaName) {
		getAdministrativeAreaName().add(administrativeAreaName);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<>(this);

		return addressLine;
	}

	public List<AdministrativeAreaName> getAdministrativeAreaName() {
		if (administrativeAreaName == null)
			administrativeAreaName = new ChildList<>(this);

		return administrativeAreaName;
	}

	public String getIndicator() {
		return indicator;
	}

	public Locality getLocality() {
		return locality;
	}

	public PostOffice getPostOffice() {
		return postOffice;
	}

	public PostalCode getPostalCode() {
		return postalCode;
	}

	public SubAdministrativeArea getSubAdministrativeArea() {
		return subAdministrativeArea;
	}

	public String getType() {
		return type;
	}

	public String getUsageType() {
		return usageType;
	}

	public boolean isSetAddressLine() {
		return addressLine != null && !addressLine.isEmpty();
	}

	public boolean isSetAdministrativeAreaName() {
		return administrativeAreaName != null && !administrativeAreaName.isEmpty();
	}

	public boolean isSetIndicator() {
		return indicator != null;
	}

	public boolean isSetLocality() {
		return locality != null;
	}

	public boolean isSetPostOffice() {
		return postOffice != null;
	}

	public boolean isSetPostalCode() {
		return postalCode != null;
	}

	public boolean isSetSubAdministrativeArea() {
		return subAdministrativeArea != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public boolean isSetUsageType() {
		return usageType != null;
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		this.addressLine = new ChildList<>(this, addressLine);
	}

	public void setAdministrativeAreaName(List<AdministrativeAreaName> administrativeAreaName) {
		this.administrativeAreaName = new ChildList<>(this, administrativeAreaName);
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public void setLocality(Locality locality) {
		this.locality = ModelObjects.setParent(locality, this);
	}

	public void setPostOffice(PostOffice postOffice) {
		this.postOffice = ModelObjects.setParent(postOffice, this);
	}

	public void setPostalCode(PostalCode postalCode) {
		this.postalCode = ModelObjects.setParent(postalCode, this);
	}

	public void setSubAdministrativeArea(SubAdministrativeArea subAdministrativeArea) {
		this.subAdministrativeArea = ModelObjects.setParent(subAdministrativeArea, this);
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUsageType(String usageType) {
		this.usageType = usageType;
	}

	public void unsetAddressLine() {
		addressLine = ModelObjects.setNull(addressLine);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		return isSetAddressLine() && this.addressLine.remove(addressLine);
	}

	public void unsetAdministrativeAreaName() {
		administrativeAreaName = ModelObjects.setNull(administrativeAreaName);
	}

	public boolean unsetAdministrativeAreaName(AdministrativeAreaName administrativeAreaName) {
		return isSetAdministrativeAreaName() && this.administrativeAreaName.remove(administrativeAreaName);
	}

	public void unsetIndicator() {
		indicator = null;
	}

	public void unsetLocality() {
		locality = ModelObjects.setNull(locality);
	}

	public void unsetPostOffice() {
		postOffice = ModelObjects.setNull(postOffice);
	}

	public void unsetPostalCode() {
		postalCode = ModelObjects.setNull(postalCode);
	}

	public void unsetSubAdministrativeArea() {
		subAdministrativeArea = ModelObjects.setNull(subAdministrativeArea);
	}

	public void unsetType() {
		type = null;
	}

	public void unsetUsageType() {
		usageType = null;
	}

	public XALClass getXALClass() {
		return XALClass.ADMINISTRATIVE_AREA;
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
		return copyTo(new AdministrativeArea(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		AdministrativeArea copy = (target == null) ? new AdministrativeArea() : (AdministrativeArea)target;

		if (isSetType())
			copy.setType(copyBuilder.copy(type));

		if (isSetUsageType())
			copy.setUsageType(copyBuilder.copy(usageType));

		if (isSetIndicator())
			copy.setIndicator(copyBuilder.copy(indicator));

		if (isSetAddressLine()) {
			for (AddressLine part : addressLine) {
				AddressLine copyPart = (AddressLine)copyBuilder.copy(part);
				copy.addAddressLine(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetAdministrativeAreaName()) {
			for (AdministrativeAreaName part : administrativeAreaName) {
				AdministrativeAreaName copyPart = (AdministrativeAreaName)copyBuilder.copy(part);
				copy.addAdministrativeAreaName(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetSubAdministrativeArea()) {
			copy.setSubAdministrativeArea((SubAdministrativeArea)copyBuilder.copy(subAdministrativeArea));
			if (copy.getSubAdministrativeArea() == subAdministrativeArea)
				subAdministrativeArea.setParent(this);
		}

		if (isSetLocality()) {
			copy.setLocality((Locality)copyBuilder.copy(locality));
			if (copy.getLocality() == locality)
				locality.setParent(this);
		}

		if (isSetPostOffice()) {
			copy.setPostOffice((PostOffice)copyBuilder.copy(postOffice));
			if (copy.getPostOffice() == postOffice)
				postOffice.setParent(this);
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
