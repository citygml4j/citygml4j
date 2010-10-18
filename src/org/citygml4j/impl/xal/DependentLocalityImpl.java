/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
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
 */
package org.citygml4j.impl.xal;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.DependentLocality;
import org.citygml4j.model.xal.DependentLocalityName;
import org.citygml4j.model.xal.DependentLocalityNumber;
import org.citygml4j.model.xal.LargeMailUser;
import org.citygml4j.model.xal.PostBox;
import org.citygml4j.model.xal.PostOffice;
import org.citygml4j.model.xal.PostalCode;
import org.citygml4j.model.xal.PostalRoute;
import org.citygml4j.model.xal.Premise;
import org.citygml4j.model.xal.Thoroughfare;
import org.citygml4j.model.xal.XALClass;

public class DependentLocalityImpl implements DependentLocality {
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

	public ModelType getModelType() {
		return ModelType.XAL;
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
		return copyTo(new DependentLocalityImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		DependentLocality copy = (target == null) ? new DependentLocalityImpl() : (DependentLocality)target;

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
	
	public void visit(XALVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T visit(XALFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
