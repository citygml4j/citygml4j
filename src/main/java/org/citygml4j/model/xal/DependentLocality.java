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
		if (this.addressLine == null)
			this.addressLine = new ChildList<AddressLine>(this);

		this.addressLine.add(addressLine);
	}

	public void addDependentLocalityName(DependentLocalityName dependentLocalityName) {
		if (this.dependentLocalityName == null)
			this.dependentLocalityName = new ChildList<DependentLocalityName>(this);

		this.dependentLocalityName.add(dependentLocalityName);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<AddressLine>(this);

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
			dependentLocalityName = new ChildList<DependentLocalityName>(this);

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
		this.addressLine = new ChildList<AddressLine>(this, addressLine);
	}

	public void setConnector(String connector) {
		this.connector = connector;
	}

	public void setDependentLocality(DependentLocality dependentLocality) {
		if (dependentLocality != null)
			dependentLocality.setParent(this);

		this.dependentLocality = dependentLocality;
	}

	public void setDependentLocalityName(List<DependentLocalityName> dependentLocalityName) {
		this.dependentLocalityName = new ChildList<DependentLocalityName>(this, dependentLocalityName);
	}

	public void setDependentLocalityNumber(DependentLocalityNumber dependentLocalityNumber) {
		if (dependentLocalityNumber != null)
			dependentLocalityNumber.setParent(this);

		this.dependentLocalityNumber = dependentLocalityNumber;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public void setLargeMailUser(LargeMailUser largeMailUser) {
		if (largeMailUser != null)
			largeMailUser.setParent(this);

		this.largeMailUser = largeMailUser;
	}

	public void setPostBox(PostBox postBox) {
		if (postBox != null)
			postBox.setParent(this);

		this.postBox = postBox;
	}

	public void setPostOffice(PostOffice postOffice) {
		if (postOffice != null)
			postOffice.setParent(this);

		this.postOffice = postOffice;
	}

	public void setPostalCode(PostalCode postalCode) {
		if (postalCode != null)
			postalCode.setParent(this);

		this.postalCode = postalCode;
	}

	public void setPostalRoute(PostalRoute postalRoute) {
		if (postalRoute != null)
			postalRoute.setParent(this);

		this.postalRoute = postalRoute;
	}

	public void setPremise(Premise premise) {
		if (premise != null)
			premise.setParent(this);

		this.premise = premise;
	}

	public void setThoroughfare(Thoroughfare thoroughfare) {
		if (thoroughfare != null)
			thoroughfare.setParent(this);

		this.thoroughfare = thoroughfare;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUsageType(String usageType) {
		this.usageType = usageType;
	}

	public void unsetAddressLine() {
		if (isSetAddressLine())
			addressLine.clear();

		addressLine = null;
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		return isSetAddressLine() ? this.addressLine.remove(addressLine) : false;
	}

	public void unsetConnector() {
		connector = null;
	}

	public void unsetDependentLocality() {
		if (isSetDependentLocality())
			dependentLocality.unsetParent();

		dependentLocality = null;
	}

	public void unsetDependentLocalityName() {
		if (isSetDependentLocalityName())
			dependentLocalityName.clear();

		dependentLocalityName = null;
	}

	public boolean unsetDependentLocalityName(DependentLocalityName dependentLocalityName) {
		return isSetDependentLocalityName() ? this.dependentLocalityName.remove(dependentLocalityName) : false;
	}

	public void unsetDependentLocalityNumber() {
		if (isSetDependentLocalityNumber())
			dependentLocalityNumber.unsetParent();

		dependentLocalityNumber = null;
	}

	public void unsetIndicator() {
		indicator = null;
	}

	public void unsetLargeMailUser() {
		if (isSetLargeMailUser())
			largeMailUser.unsetParent();

		largeMailUser = null;
	}

	public void unsetPostBox() {
		if (isSetPostBox())
			postBox.unsetParent();

		postBox = null;
	}

	public void unsetPostOffice() {
		if (isSetPostOffice())
			postOffice.unsetParent();

		postOffice = null;
	}

	public void unsetPostalCode() {
		if (isSetPostalCode())
			postalCode.unsetParent();

		postalCode = null;
	}

	public void unsetPostalRoute() {
		if (isSetPostalRoute())
			postalRoute.unsetParent();

		postalRoute = null;
	}

	public void unsetPremise() {
		if (isSetPremise())
			premise.unsetParent();

		premise = null;
	}

	public void unsetThoroughfare() {
		if (isSetThoroughfare())
			thoroughfare.unsetParent();

		thoroughfare = null;
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
