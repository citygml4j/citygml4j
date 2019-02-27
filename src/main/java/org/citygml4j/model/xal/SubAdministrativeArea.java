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

public class SubAdministrativeArea implements XAL, Child, Copyable {
	private List<AddressLine> addressLine;
	private List<SubAdministrativeAreaName> subAdministrativeAreaName;
	private Locality locality;
	private PostOffice postOffice;
	private PostalCode postalCode;
	private String type;
	private String usageType;
	private String indicator;
	private ModelObject parent;	
	
	public void addAddressLine(AddressLine addressLine) {
		getAddressLine().add(addressLine);
	}

	public void addSubAdministrativeAreaName(SubAdministrativeAreaName subAdministrativeAreaName) {
		getSubAdministrativeAreaName().add(subAdministrativeAreaName);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<>(this);

		return addressLine;
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

	public List<SubAdministrativeAreaName> getSubAdministrativeAreaName() {
		if (subAdministrativeAreaName == null)
			subAdministrativeAreaName = new ChildList<>(this);

		return subAdministrativeAreaName;
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

	public boolean isSetSubAdministrativeAreaName() {
		return subAdministrativeAreaName != null && !subAdministrativeAreaName.isEmpty();
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

	public void setSubAdministrativeAreaName(List<SubAdministrativeAreaName> subAdministrativeAreaName) {
		this.subAdministrativeAreaName = new ChildList<>(this, subAdministrativeAreaName);
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

	public void unsetSubAdministrativeAreaName() {
		subAdministrativeAreaName = ModelObjects.setNull(subAdministrativeAreaName);
	}

	public boolean unsetSubAdministrativeAreaName(SubAdministrativeAreaName subAdministrativeAreaName) {
		return isSetSubAdministrativeAreaName() && this.subAdministrativeAreaName.remove(subAdministrativeAreaName);
	}

	public void unsetType() {
		type = null;
	}

	public void unsetUsageType() {
		usageType = null;
	}

	public XALClass getXALClass() {
		return XALClass.SUB_ADMINISTRATIVE_AREA;
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
		return copyTo(new SubAdministrativeArea(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SubAdministrativeArea copy = (target == null) ? new SubAdministrativeArea() : (SubAdministrativeArea)target;
		
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
		
		if (isSetSubAdministrativeAreaName()) {
			for (SubAdministrativeAreaName part : subAdministrativeAreaName) {
				SubAdministrativeAreaName copyPart = (SubAdministrativeAreaName)copyBuilder.copy(part);
				copy.addSubAdministrativeAreaName(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
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
