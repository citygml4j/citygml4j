/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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

import java.util.Iterator;
import java.util.List;

public class Thoroughfare implements XAL, Child, Copyable {
	private List<AddressLine> addressLine;
	private List<ThoroughfareNumberOrRange> numberOrRange;
	private List<ThoroughfareNumberPrefix> thoroughfareNumberPrefix;
	private List<ThoroughfareNumberSuffix> thoroughfareNumberSuffix;
	private List<ThoroughfareName> thoroughfareName;
	private ThoroughfarePreDirection thoroughfarePreDirection;
	private ThoroughfarePostDirection thoroughfarePostDirection;
	private ThoroughfareLeadingType thoroughfareLeadingType;
	private ThoroughfareTrailingType thoroughfareTrailingType;
	private DependentThoroughfare dependentThoroughfare;
	private DependentLocality dependentLocality;
	private Premise premise;
	private Firm firm;
	private PostalCode postalCode;
	private String type;
	private String dependentThoroughfares;
	private String dependentThoroughfaresIndicator;
	private String dependentThoroughfaresConnector;
	private String dependentThoroughfaresType;
	private ModelObject parent;
	
	public void addAddressLine(AddressLine addressLine) {
		getAddressLine().add(addressLine);
	}

	public void addThoroughfareName(ThoroughfareName thoroughfareName) {
		getThoroughfareName().add(thoroughfareName);
	}

	public void addThoroughfareNumber(ThoroughfareNumber thoroughfareNumber) {
		getThoroughfareNumberOrThoroughfareNumberRange().add(new ThoroughfareNumberOrRange(thoroughfareNumber));
	}

	public void addThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		getThoroughfareNumberPrefix().add(thoroughfareNumberPrefix);
	}

	public void addThoroughfareNumberRange(ThoroughfareNumberRange thoroughfareNumberRange) {
		getThoroughfareNumberOrThoroughfareNumberRange().add(new ThoroughfareNumberOrRange(thoroughfareNumberRange));
	}

	public void addThoroughfareNumberOrThoroughfareNumberRange(ThoroughfareNumberOrRange numberOrRange) {
		getThoroughfareNumberOrThoroughfareNumberRange().add(numberOrRange);
	}

	public void addThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		getThoroughfareNumberSuffix().add(thoroughfareNumberSuffix);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<>(this);

		return addressLine;
	}

	public DependentLocality getDependentLocality() {
		return dependentLocality;
	}

	public DependentThoroughfare getDependentThoroughfare() {
		return dependentThoroughfare;
	}

	public String getDependentThoroughfares() {
		return dependentThoroughfares;
	}

	public String getDependentThoroughfaresConnector() {
		return dependentThoroughfaresConnector;
	}

	public String getDependentThoroughfaresIndicator() {
		return dependentThoroughfaresConnector;
	}

	public String getDependentThoroughfaresType() {
		return dependentThoroughfaresType;
	}

	public Firm getFirm() {
		return firm;
	}

	public PostalCode getPostalCode() {
		return postalCode;
	}

	public Premise getPremise() {
		return premise;
	}

	public ThoroughfareLeadingType getThoroughfareLeadingType() {
		return thoroughfareLeadingType;
	}

	public List<ThoroughfareName> getThoroughfareName() {
		if (thoroughfareName == null)
			thoroughfareName = new ChildList<>(this);

		return thoroughfareName;
	}

	public List<ThoroughfareNumberOrRange> getThoroughfareNumberOrThoroughfareNumberRange() {
		if (numberOrRange == null)
			numberOrRange = new ChildList<>(this);

		return numberOrRange;
	}

	public List<ThoroughfareNumberPrefix> getThoroughfareNumberPrefix() {
		if (thoroughfareNumberPrefix == null)
			thoroughfareNumberPrefix = new ChildList<>(this);

		return thoroughfareNumberPrefix;
	}

	public List<ThoroughfareNumberSuffix> getThoroughfareNumberSuffix() {
		if (thoroughfareNumberSuffix == null)
			thoroughfareNumberSuffix = new ChildList<>(this);

		return thoroughfareNumberSuffix;
	}

	public ThoroughfarePostDirection getThoroughfarePostDirection() {
		return thoroughfarePostDirection;
	}

	public ThoroughfarePreDirection getThoroughfarePreDirection() {
		return thoroughfarePreDirection;
	}

	public ThoroughfareTrailingType getThoroughfareTrailingType() {
		return thoroughfareTrailingType;
	}

	public String getType() {
		return type;
	}

	public boolean isSetAddressLine() {
		return addressLine != null && !addressLine.isEmpty();
	}

	public boolean isSetDependentLocality() {
		return dependentLocality != null;
	}

	public boolean isSetDependentThoroughfare() {
		return dependentThoroughfare != null;
	}

	public boolean isSetDependentThoroughfares() {
		return dependentThoroughfares != null;
	}

	public boolean isSetDependentThoroughfaresConnector() {
		return dependentThoroughfaresConnector != null;
	}

	public boolean isSetDependentThoroughfaresIndicator() {
		return dependentThoroughfaresIndicator != null;
	}

	public boolean isSetDependentThoroughfaresType() {
		return dependentThoroughfaresType != null;
	}

	public boolean isSetFirm() {
		return firm != null;
	}

	public boolean isSetPostalCode() {
		return postalCode != null;
	}

	public boolean isSetPremise() {
		return premise != null;
	}

	public boolean isSetThoroughfareLeadingType() {
		return thoroughfareLeadingType != null;
	}

	public boolean isSetThoroughfareName() {
		return thoroughfareName != null && !thoroughfareName.isEmpty();
	}

	public boolean isSetThoroughfareNumberOrThoroughfareNumberRange() {
		return numberOrRange != null && !numberOrRange.isEmpty();
	}

	public boolean isSetThoroughfareNumberPrefix() {
		return thoroughfareNumberPrefix != null && !thoroughfareNumberPrefix.isEmpty();
	}

	public boolean isSetThoroughfareNumberSuffix() {
		return thoroughfareNumberSuffix != null && !thoroughfareNumberSuffix.isEmpty();
	}

	public boolean isSetThoroughfarePostDirection() {
		return thoroughfarePostDirection != null;
	}

	public boolean isSetThoroughfarePreDirection() {
		return thoroughfarePreDirection != null;
	}

	public boolean isSetThoroughfareTrailingType() {
		return thoroughfareTrailingType != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		this.addressLine = new ChildList<>(this, addressLine);
	}

	public void setDependentLocality(DependentLocality dependentLocality) {
		this.dependentLocality = ModelObjects.setParent(dependentLocality, this);
	}

	public void setDependentThoroughfare(DependentThoroughfare dependentThoroughfare) {
		this.dependentThoroughfare = ModelObjects.setParent(dependentThoroughfare, this);
	}

	public void setDependentThoroughfares(String dependentThoroughfares) {
		if (dependentThoroughfares.equals("Yes") || dependentThoroughfares.equals("No"))
			this.dependentThoroughfares = dependentThoroughfares;
	}

	public void setDependentThoroughfaresConnector(String dependentThoroughfaresConnector) {
		this.dependentThoroughfaresConnector = dependentThoroughfaresConnector;
	}

	public void setDependentThoroughfaresIndicator(String dependentThoroughfaresIndicator) {
		this.dependentThoroughfaresIndicator = dependentThoroughfaresIndicator;
	}

	public void setDependentThoroughfaresType(String dependentThoroughfaresType) {
		this.dependentThoroughfaresType = dependentThoroughfaresType;
	}

	public void setFirm(Firm firm) {
		this.firm = ModelObjects.setParent(firm, this);
	}

	public void setPostalCode(PostalCode postalCode) {
		this.postalCode = ModelObjects.setParent(postalCode, this);
	}

	public void setPremise(Premise premise) {
		this.premise = ModelObjects.setParent(premise, this);
	}

	public void setThoroughfareLeadingType(ThoroughfareLeadingType thoroughfareLeadingType) {
		this.thoroughfareLeadingType = ModelObjects.setParent(thoroughfareLeadingType, this);
	}

	public void setThoroughfareName(List<ThoroughfareName> thoroughfareName) {
		this.thoroughfareName = new ChildList<>(this, thoroughfareName);
	}

	public void setThoroughfareNumberOrThoroughfareNumberRange(List<ThoroughfareNumberOrRange> numberOrRange) {
		this.numberOrRange = new ChildList<>(this, numberOrRange);
	}

	public void setThoroughfareNumberPrefix(List<ThoroughfareNumberPrefix> thoroughfareNumberPrefix) {
		this.thoroughfareNumberPrefix = new ChildList<>(this, thoroughfareNumberPrefix);
	}

	public void setThoroughfareNumberSuffix(List<ThoroughfareNumberSuffix> thoroughfareNumberSuffix) {
		this.thoroughfareNumberSuffix = new ChildList<>(this, thoroughfareNumberSuffix);
	}

	public void setThoroughfarePostDirection(ThoroughfarePostDirection thoroughfarePostDirection) {
		this.thoroughfarePostDirection = ModelObjects.setParent(thoroughfarePostDirection, this);
	}

	public void setThoroughfarePreDirection(ThoroughfarePreDirection thoroughfarePreDirection) {
		this.thoroughfarePreDirection = ModelObjects.setParent(thoroughfarePreDirection, this);
	}

	public void setThoroughfareTrailingType(ThoroughfareTrailingType thoroughfareTrailingType) {
		this.thoroughfareTrailingType = ModelObjects.setParent(thoroughfareTrailingType, this);
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

	public void unsetDependentLocality() {
		dependentLocality = ModelObjects.setNull(dependentLocality);
	}

	public void unsetDependentThoroughfare() {
		dependentThoroughfare = ModelObjects.setNull(dependentThoroughfare);
	}

	public void unsetDependentThoroughfares() {
		dependentThoroughfares = null;
	}

	public void unsetDependentThoroughfaresConnector() {
		dependentThoroughfaresConnector = null;
	}

	public void unsetDependentThoroughfaresIndicator() {
		dependentThoroughfaresIndicator = null;
	}

	public void unsetDependentThoroughfaresType() {
		dependentThoroughfaresType = null;
	}

	public void unsetFirm() {
		firm = ModelObjects.setNull(firm);
	}

	public void unsetPostalCode() {
		postalCode = ModelObjects.setNull(postalCode);
	}

	public void unsetPremise() {
		premise = ModelObjects.setNull(premise);
	}

	public void unsetThoroughfareLeadingType() {
		thoroughfareLeadingType = ModelObjects.setNull(thoroughfareLeadingType);
	}

	public void unsetThoroughfareName() {
		thoroughfareName = ModelObjects.setNull(thoroughfareName);
	}

	public boolean unsetThoroughfareName(ThoroughfareName thoroughfareName) {
		return isSetThoroughfareName() && this.thoroughfareName.remove(thoroughfareName);
	}

	public boolean unsetThoroughfareNumber(ThoroughfareNumber thoroughfareNumber) {
		boolean success = false;

		Iterator<ThoroughfareNumberOrRange> iter = numberOrRange.iterator();
		while (iter.hasNext()) {
			ThoroughfareNumberOrRange numberOrRange = iter.next();
			if (numberOrRange != null && numberOrRange.getThoroughfareNumber().equals(thoroughfareNumber)) {
				iter.remove();
				success = true;
				break;
			}
		}

		return success;
	}

	public void unsetThoroughfareNumberOrThoroughfareNumberRange() {
		numberOrRange = ModelObjects.setNull(numberOrRange);
	}

	public boolean unsetThoroughfareNumberOrThoroughfareNumberRange(ThoroughfareNumberOrRange thoroughfareNumberOrRange) {
		return isSetThoroughfareNumberOrThoroughfareNumberRange() && numberOrRange.remove(thoroughfareNumberOrRange);
	}

	public void unsetThoroughfareNumberPrefix() {
		thoroughfareNumberPrefix = ModelObjects.setNull(thoroughfareNumberPrefix);
	}

	public boolean unsetThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		return isSetThoroughfareNumberPrefix() && this.thoroughfareNumberPrefix.remove(thoroughfareNumberPrefix);
	}

	public boolean unsetThoroughfareNumberRange(ThoroughfareNumberRange thoroughfareNumberRange) {
		boolean success = false;

		Iterator<ThoroughfareNumberOrRange> iter = numberOrRange.iterator();
		while (iter.hasNext()) {
			ThoroughfareNumberOrRange numberOrRange = iter.next();
			if (numberOrRange != null && numberOrRange.getThoroughfareNumberRange().equals(thoroughfareNumberRange)) {
				iter.remove();
				success = true;
				break;
			}
		}

		return success;
	}

	public void unsetThoroughfareNumberSuffix() {
		thoroughfareNumberSuffix = ModelObjects.setNull(thoroughfareNumberSuffix);
	}

	public boolean unsetThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		return isSetThoroughfareNumberSuffix() && this.thoroughfareNumberSuffix.remove(thoroughfareNumberSuffix);
	}

	public void unsetThoroughfarePostDirection() {
		thoroughfarePostDirection = ModelObjects.setNull(thoroughfarePostDirection);
	}

	public void unsetThoroughfarePreDirection() {
		thoroughfarePreDirection = ModelObjects.setNull(thoroughfarePreDirection);
	}

	public void unsetThoroughfareTrailingType() {
		thoroughfareTrailingType = ModelObjects.setNull(thoroughfareTrailingType);
	}

	public void unsetType() {
		type = null;
	}

	public XALClass getXALClass() {
		return XALClass.THOROUGHFARE;
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
		return copyTo(new Thoroughfare(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Thoroughfare copy = (target == null) ? new Thoroughfare() : (Thoroughfare)target;
		
		if (isSetType())
			copy.setType(copyBuilder.copy(type));

		if (isSetDependentThoroughfares())
			copy.setDependentThoroughfares(copyBuilder.copy(dependentThoroughfares));

		if (isSetDependentThoroughfaresIndicator())
			copy.setDependentThoroughfaresIndicator(copyBuilder.copy(dependentThoroughfaresIndicator));

		if (isSetDependentThoroughfaresConnector())
			copy.setDependentThoroughfaresConnector(copyBuilder.copy(dependentThoroughfaresConnector));

		if (isSetDependentThoroughfaresType())
			copy.setDependentThoroughfaresType(copyBuilder.copy(dependentThoroughfaresType));
		
		if (isSetAddressLine()) {
			for (AddressLine part : addressLine) {
				AddressLine copyPart = (AddressLine)copyBuilder.copy(part);
				copy.addAddressLine(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetThoroughfareNumberOrThoroughfareNumberRange()) {
			for (ThoroughfareNumberOrRange part : numberOrRange) {
				ThoroughfareNumberOrRange copyPart = (ThoroughfareNumberOrRange)copyBuilder.copy(part);
				copy.addThoroughfareNumberOrThoroughfareNumberRange(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetThoroughfareName()) {
			for (ThoroughfareName part : thoroughfareName) {
				ThoroughfareName copyPart = (ThoroughfareName)copyBuilder.copy(part);
				copy.addThoroughfareName(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetThoroughfareNumberPrefix()) {
			for (ThoroughfareNumberPrefix part : thoroughfareNumberPrefix) {
				ThoroughfareNumberPrefix copyPart = (ThoroughfareNumberPrefix)copyBuilder.copy(part);
				copy.addThoroughfareNumberPrefix(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
	
		if (isSetThoroughfareNumberSuffix()) {
			for (ThoroughfareNumberSuffix part : thoroughfareNumberSuffix) {
				ThoroughfareNumberSuffix copyPart = (ThoroughfareNumberSuffix)copyBuilder.copy(part);
				copy.addThoroughfareNumberSuffix(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetThoroughfarePreDirection()) {
			copy.setThoroughfarePreDirection((ThoroughfarePreDirection)copyBuilder.copy(thoroughfarePreDirection));
			if (copy.getThoroughfarePreDirection() == thoroughfarePreDirection)
				thoroughfarePreDirection.setParent(this);
		}
		
		if (isSetThoroughfarePostDirection()) {
			copy.setThoroughfarePostDirection((ThoroughfarePostDirection)copyBuilder.copy(thoroughfarePostDirection));
			if (copy.getThoroughfarePostDirection() == thoroughfarePostDirection)
				thoroughfarePostDirection.setParent(this);
		}
		
		if (isSetThoroughfareLeadingType()) {
			copy.setThoroughfareLeadingType((ThoroughfareLeadingType)copyBuilder.copy(thoroughfareLeadingType));
			if (copy.getThoroughfareLeadingType() == thoroughfareLeadingType)
				thoroughfareLeadingType.setParent(this);
		}
		
		if (isSetThoroughfareTrailingType()) {
			copy.setThoroughfareTrailingType((ThoroughfareTrailingType)copyBuilder.copy(thoroughfareTrailingType));
			if (copy.getThoroughfareTrailingType() == thoroughfareTrailingType)
				thoroughfareTrailingType.setParent(this);
		}
		
		if (isSetDependentThoroughfare()) {
			copy.setDependentThoroughfare((DependentThoroughfare)copyBuilder.copy(dependentThoroughfare));
			if (copy.getDependentThoroughfare() == dependentThoroughfare)
				dependentThoroughfare.setParent(this);
		}
		
		if (isSetDependentLocality()) {
			copy.setDependentLocality((DependentLocality)copyBuilder.copy(dependentLocality));
			if (copy.getDependentLocality() == dependentLocality)
				dependentLocality.setParent(this);
		}
		
		if (isSetPremise()) {
			copy.setPremise((Premise)copyBuilder.copy(premise));
			if (copy.getPremise() == premise)
				premise.setParent(this);
		}
		
		if (isSetFirm()) {
			copy.setFirm((Firm)copyBuilder.copy(firm));
			if (copy.getFirm() == firm)
				firm.setParent(this);
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
