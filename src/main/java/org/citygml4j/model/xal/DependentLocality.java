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

public class DependentLocality implements XAL, Child, Copyable {
	private List<AddressLine> addressLine;
	private List<DependentLocalityName> dependentLocalityName;
	private DependentLocalityNumber dependentLocalityNumber;
	private PostBox postBox;
	private LargeMailUser largeMailUser;
	private PostOffice postOffice;
	private PostalRoute postalRoute;
	private Thoroughfare thoroughfare;
	private Premise premise;
	private DependentLocality dependentLocality;
	private PostalCode postalCode;
	private String type;
	private String usageType;
	private String connector;
	private String indicator;
	private ModelObject parent;	

	public void addAddressLine(AddressLine addressLine) {
		getAddressLine().add(addressLine);
	}

	public void addDependentLocalityName(DependentLocalityName dependentLocalityName) {
		getDependentLocalityName().add(dependentLocalityName);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<>(this);

		return addressLine;
	}

	public String getConnector() {
		return connector;
	}

	public DependentLocality getDependentLocality() {
		return dependentLocality;
	}

	public List<DependentLocalityName> getDependentLocalityName() {
		if (dependentLocalityName == null)
			dependentLocalityName = new ChildList<>(this);

		return dependentLocalityName;
	}

	public DependentLocalityNumber getDependentLocalityNumber() {
		return dependentLocalityNumber;
	}

	public String getIndicator() {
		return indicator;
	}

	public LargeMailUser getLargeMailUser() {
		return largeMailUser;
	}

	public PostBox getPostBox() {
		return postBox;
	}

	public PostOffice getPostOffice() {
		return postOffice;
	}

	public PostalCode getPostalCode() {
		return postalCode;
	}

	public PostalRoute getPostalRoute() {
		return postalRoute;
	}

	public Premise getPremise() {
		return premise;
	}

	public Thoroughfare getThoroughfare() {
		return thoroughfare;
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

	public boolean isSetConnector() {
		return connector != null;
	}

	public boolean isSetDependentLocality() {
		return dependentLocality != null;
	}

	public boolean isSetDependentLocalityName() {
		return dependentLocalityName != null && !dependentLocalityName.isEmpty();
	}

	public boolean isSetDependentLocalityNumber() {
		return dependentLocalityNumber != null;
	}

	public boolean isSetIndicator() {
		return indicator != null;
	}

	public boolean isSetLargeMailUser() {
		return largeMailUser != null;
	}

	public boolean isSetPostBox() {
		return postBox != null;
	}

	public boolean isSetPostOffice() {
		return postOffice != null;
	}

	public boolean isSetPostalCode() {
		return postalCode != null;
	}

	public boolean isSetPostalRoute() {
		return postalRoute != null;
	}

	public boolean isSetPremise() {
		return premise != null;
	}

	public boolean isSetThoroughfare() {
		return thoroughfare != null;
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

	public void setConnector(String connector) {
		this.connector = connector;
	}

	public void setDependentLocality(DependentLocality dependentLocality) {
		this.dependentLocality = ModelObjects.setParent(dependentLocality, this);
	}

	public void setDependentLocalityName(List<DependentLocalityName> dependentLocalityName) {
		this.dependentLocalityName = new ChildList<>(this, dependentLocalityName);
	}

	public void setDependentLocalityNumber(DependentLocalityNumber dependentLocalityNumber) {
		this.dependentLocalityNumber = ModelObjects.setParent(dependentLocalityNumber, this);
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public void setLargeMailUser(LargeMailUser largeMailUser) {
		this.largeMailUser = ModelObjects.setParent(largeMailUser, this);
	}

	public void setPostBox(PostBox postBox) {
		this.postBox = ModelObjects.setParent(postBox, this);
	}

	public void setPostOffice(PostOffice postOffice) {
		this.postOffice = ModelObjects.setParent(postOffice, this);
	}

	public void setPostalCode(PostalCode postalCode) {
		this.postalCode = ModelObjects.setParent(postalCode, this);
	}

	public void setPostalRoute(PostalRoute postalRoute) {
		this.postalRoute = ModelObjects.setParent(postalRoute, this);
	}

	public void setPremise(Premise premise) {
		this.premise = ModelObjects.setParent(premise, this);
	}

	public void setThoroughfare(Thoroughfare thoroughfare) {
		this.thoroughfare = ModelObjects.setParent(thoroughfare, this);
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

	public void unsetConnector() {
		connector = null;
	}

	public void unsetDependentLocality() {
		dependentLocality = ModelObjects.setNull(dependentLocality);
	}

	public void unsetDependentLocalityName() {
		dependentLocalityName = ModelObjects.setNull(dependentLocalityName);
	}

	public boolean unsetDependentLocalityName(DependentLocalityName dependentLocalityName) {
		return isSetDependentLocalityName() && this.dependentLocalityName.remove(dependentLocalityName);
	}

	public void unsetDependentLocalityNumber() {
		dependentLocalityNumber = ModelObjects.setNull(dependentLocalityNumber);
	}

	public void unsetIndicator() {
		indicator = null;
	}

	public void unsetLargeMailUser() {
		largeMailUser = ModelObjects.setNull(largeMailUser);
	}

	public void unsetPostBox() {
		postBox = ModelObjects.setNull(postBox);
	}

	public void unsetPostOffice() {
		postOffice = ModelObjects.setNull(postOffice);
	}

	public void unsetPostalCode() {
		postalCode = ModelObjects.setNull(postalCode);
	}

	public void unsetPostalRoute() {
		postalRoute = ModelObjects.setNull(postalRoute);
	}

	public void unsetPremise() {
		premise = ModelObjects.setNull(premise);
	}

	public void unsetThoroughfare() {
		thoroughfare = ModelObjects.setNull(thoroughfare);
	}

	public void unsetType() {
		type = null;
	}

	public void unsetUsageType() {
		usageType = null;
	}

	public XALClass getXALClass() {
		return XALClass.DEPENDENT_LOCALITY;
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
		return copyTo(new DependentLocality(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		DependentLocality copy = (target == null) ? new DependentLocality() : (DependentLocality)target;

		if (isSetType())
			copy.setType(copyBuilder.copy(type));

		if (isSetUsageType())
			copy.setUsageType(copyBuilder.copy(usageType));

		if (isSetIndicator())
			copy.setIndicator(copyBuilder.copy(indicator));

		if (isSetConnector())
			copy.setConnector(copyBuilder.copy(connector));

		if (isSetAddressLine()) {
			for (AddressLine part : addressLine) {
				AddressLine copyPart = (AddressLine)copyBuilder.copy(part);
				copy.addAddressLine(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetDependentLocalityName()) {
			for (DependentLocalityName part : dependentLocalityName) {
				DependentLocalityName copyPart = (DependentLocalityName)copyBuilder.copy(part);
				copy.addDependentLocalityName(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetDependentLocalityNumber()) {
			copy.setDependentLocalityNumber((DependentLocalityNumber)copyBuilder.copy(dependentLocalityNumber));
			if (copy.getDependentLocalityNumber() == dependentLocalityNumber)
				dependentLocalityNumber.setParent(this);
		}

		if (isSetPostBox()) {
			copy.setPostBox((PostBox)copyBuilder.copy(postBox));
			if (copy.getPostBox() == postBox)
				postBox.setParent(this);
		}

		if (isSetLargeMailUser()) {
			copy.setLargeMailUser((LargeMailUser)copyBuilder.copy(largeMailUser));
			if (copy.getLargeMailUser() == largeMailUser)
				largeMailUser.setParent(this);
		}

		if (isSetPostOffice()) {
			copy.setPostOffice((PostOffice)copyBuilder.copy(postOffice));
			if (copy.getPostOffice() == postOffice)
				postOffice.setParent(this);
		}

		if (isSetPostalRoute()) {
			copy.setPostalRoute((PostalRoute)copyBuilder.copy(postalRoute));
			if (copy.getPostalRoute() == postalRoute)
				postalRoute.setParent(this);
		}

		if (isSetThoroughfare()) {
			copy.setThoroughfare((Thoroughfare)copyBuilder.copy(thoroughfare));
			if (copy.getThoroughfare() == thoroughfare)
				thoroughfare.setParent(this);
		}

		if (isSetPremise()) {
			copy.setPremise((Premise)copyBuilder.copy(premise));
			if (copy.getPremise() == premise)
				premise.setParent(this);
		}

		if (isSetDependentLocality()) {
			copy.setDependentLocality((DependentLocality)copyBuilder.copy(dependentLocality));
			if (copy.getDependentLocality() == dependentLocality)
				dependentLocality.setParent(this);
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
