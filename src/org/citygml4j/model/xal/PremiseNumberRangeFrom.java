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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
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

public class PremiseNumberRangeFrom implements XAL, Child, Copyable {
	private List<AddressLine> addressLine;
	private List<PremiseNumberPrefix> premiseNumberPrefix;
	private List<PremiseNumber> premiseNumber;
	private List<PremiseNumberSuffix> premiseNumberSuffix;
	private ModelObject parent;
	
	public void addAddressLine(AddressLine addressLine) {
		if (this.addressLine == null)
			this.addressLine = new ChildList<AddressLine>(this);

		this.addressLine.add(addressLine);
	}

	public void addPremiseNumber(PremiseNumber premiseNumber) {
		if (this.premiseNumber == null)
			this.premiseNumber = new ChildList<PremiseNumber>(this);

		this.premiseNumber.add(premiseNumber);
	}

	public void addPremiseNumberPrefix(PremiseNumberPrefix premiseNumberPrefix) {
		if (this.premiseNumberPrefix == null)
			this.premiseNumberPrefix = new ChildList<PremiseNumberPrefix>(this);

		this.premiseNumberPrefix.add(premiseNumberPrefix);
	}

	public void addPremiseNumberSuffix(PremiseNumberSuffix premiseNumberSuffix) {
		if (this.premiseNumberSuffix == null)
			this.premiseNumberSuffix = new ChildList<PremiseNumberSuffix>(this);

		this.premiseNumberSuffix.add(premiseNumberSuffix);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<AddressLine>(this);

		return addressLine;
	}

	public List<PremiseNumber> getPremiseNumber() {
		if (premiseNumber == null)
			premiseNumber = new ChildList<PremiseNumber>(this);

		return premiseNumber;
	}

	public List<PremiseNumberPrefix> getPremiseNumberPrefix() {
		if (premiseNumberPrefix == null)
			premiseNumberPrefix = new ChildList<PremiseNumberPrefix>(this);

		return premiseNumberPrefix;
	}

	public List<PremiseNumberSuffix> getPremiseNumberSuffix() {
		if (premiseNumberSuffix == null)
			premiseNumberSuffix = new ChildList<PremiseNumberSuffix>(this);

		return premiseNumberSuffix;
	}

	public boolean isSetAddressLine() {
		return addressLine != null && !addressLine.isEmpty();
	}

	public boolean isSetPremiseNumber() {
		return premiseNumber != null && !premiseNumber.isEmpty();
	}

	public boolean isSetPremiseNumberPrefix() {
		return premiseNumberPrefix != null && !premiseNumberPrefix.isEmpty();
	}

	public boolean isSetPremiseNumberSuffix() {
		return premiseNumberSuffix != null && !premiseNumberSuffix.isEmpty();
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		this.addressLine = new ChildList<AddressLine>(this, addressLine);
	}

	public void setPremiseNumber(List<PremiseNumber> premiseNumber) {
		this.premiseNumber = new ChildList<PremiseNumber>(this, premiseNumber);
	}

	public void setPremiseNumberPrefix(List<PremiseNumberPrefix> premiseNumberPrefix) {
		this.premiseNumberPrefix = new ChildList<PremiseNumberPrefix>(this, premiseNumberPrefix);
	}

	public void setPremiseNumberSuffix(List<PremiseNumberSuffix> premiseNumberSuffix) {
		this.premiseNumberSuffix = new ChildList<PremiseNumberSuffix>(this, premiseNumberSuffix);
	}

	public void unsetAddressLine() {
		if (isSetAddressLine())
			addressLine.clear();
		
		addressLine = null;
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		return isSetAddressLine() ? this.addressLine.remove(addressLine) : false;
	}

	public void unsetPremiseNumber() {
		if (isSetPremiseNumber())
			premiseNumber.clear();
		
		premiseNumber = null;
	}

	public boolean unsetPremiseNumber(PremiseNumber premiseNumber) {
		return isSetPremiseNumber() ? this.premiseNumber.remove(premiseNumber) : false;
	}

	public void unsetPremiseNumberPrefix() {
		if (isSetPremiseNumberPrefix())
			premiseNumberPrefix.clear();
		
		premiseNumberPrefix = null;
	}

	public boolean unsetPremiseNumberPrefix(PremiseNumberPrefix premiseNumberPrefix) {
		return isSetPremiseNumberPrefix() ? this.premiseNumberPrefix.remove(premiseNumberPrefix) : false;
	}

	public void unsetPremiseNumberSuffix() {
		if (isSetPremiseNumberSuffix())
			premiseNumberSuffix.clear();
		
		premiseNumberSuffix = null;
	}

	public boolean unsetPremiseNumberSuffix(PremiseNumberSuffix premiseNumberSuffix) {
		return isSetPremiseNumberSuffix() ? this.premiseNumberSuffix.remove(premiseNumberSuffix) : false;
	}

	public ModelType getModelType() {
		return ModelType.XAL;
	}

	public XALClass getXALClass() {
		return XALClass.PREMISE_NUMBER_RANGE_FROM;
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
		return copyTo(new PremiseNumberRangeFrom(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PremiseNumberRangeFrom copy = (target == null) ? new PremiseNumberRangeFrom() : (PremiseNumberRangeFrom)target;
		
		if (isSetAddressLine()) {
			for (AddressLine part : addressLine) {
				AddressLine copyPart = (AddressLine)copyBuilder.copy(part);
				copy.addAddressLine(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetPremiseNumber()) {
			for (PremiseNumber part : premiseNumber) {
				PremiseNumber copyPart = (PremiseNumber)copyBuilder.copy(part);
				copy.addPremiseNumber(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetPremiseNumberPrefix()) {
			for (PremiseNumberPrefix part : premiseNumberPrefix) {
				PremiseNumberPrefix copyPart = (PremiseNumberPrefix)copyBuilder.copy(part);
				copy.addPremiseNumberPrefix(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetPremiseNumberSuffix()) {
			for (PremiseNumberSuffix part : premiseNumberSuffix) {
				PremiseNumberSuffix copyPart = (PremiseNumberSuffix)copyBuilder.copy(part);
				copy.addPremiseNumberSuffix(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
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
