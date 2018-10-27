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

public class PremiseNumberRangeTo implements XAL, Child, Copyable {
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
		return copyTo(new PremiseNumberRangeTo(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PremiseNumberRangeTo copy = (target == null) ? new PremiseNumberRangeTo() : (PremiseNumberRangeTo)target;
		
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
	
	public void accept(XALVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(XALFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
