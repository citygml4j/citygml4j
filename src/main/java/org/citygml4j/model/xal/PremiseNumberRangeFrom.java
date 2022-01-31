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

import java.util.List;

public class PremiseNumberRangeFrom implements XAL, Child, Copyable {
	private List<AddressLine> addressLine;
	private List<PremiseNumberPrefix> premiseNumberPrefix;
	private List<PremiseNumber> premiseNumber;
	private List<PremiseNumberSuffix> premiseNumberSuffix;
	private ModelObject parent;
	
	public void addAddressLine(AddressLine addressLine) {
		getAddressLine().add(addressLine);
	}

	public void addPremiseNumber(PremiseNumber premiseNumber) {
		getPremiseNumber().add(premiseNumber);
	}

	public void addPremiseNumberPrefix(PremiseNumberPrefix premiseNumberPrefix) {
		getPremiseNumberPrefix().add(premiseNumberPrefix);
	}

	public void addPremiseNumberSuffix(PremiseNumberSuffix premiseNumberSuffix) {
		getPremiseNumberSuffix().add(premiseNumberSuffix);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<>(this);

		return addressLine;
	}

	public List<PremiseNumber> getPremiseNumber() {
		if (premiseNumber == null)
			premiseNumber = new ChildList<>(this);

		return premiseNumber;
	}

	public List<PremiseNumberPrefix> getPremiseNumberPrefix() {
		if (premiseNumberPrefix == null)
			premiseNumberPrefix = new ChildList<>(this);

		return premiseNumberPrefix;
	}

	public List<PremiseNumberSuffix> getPremiseNumberSuffix() {
		if (premiseNumberSuffix == null)
			premiseNumberSuffix = new ChildList<>(this);

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
		this.addressLine = new ChildList<>(this, addressLine);
	}

	public void setPremiseNumber(List<PremiseNumber> premiseNumber) {
		this.premiseNumber = new ChildList<>(this, premiseNumber);
	}

	public void setPremiseNumberPrefix(List<PremiseNumberPrefix> premiseNumberPrefix) {
		this.premiseNumberPrefix = new ChildList<>(this, premiseNumberPrefix);
	}

	public void setPremiseNumberSuffix(List<PremiseNumberSuffix> premiseNumberSuffix) {
		this.premiseNumberSuffix = new ChildList<>(this, premiseNumberSuffix);
	}

	public void unsetAddressLine() {
		addressLine = ModelObjects.setNull(addressLine);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		return isSetAddressLine() && this.addressLine.remove(addressLine);
	}

	public void unsetPremiseNumber() {
		premiseNumber = ModelObjects.setNull(premiseNumber);
	}

	public boolean unsetPremiseNumber(PremiseNumber premiseNumber) {
		return isSetPremiseNumber() && this.premiseNumber.remove(premiseNumber);
	}

	public void unsetPremiseNumberPrefix() {
		premiseNumberPrefix = ModelObjects.setNull(premiseNumberPrefix);
	}

	public boolean unsetPremiseNumberPrefix(PremiseNumberPrefix premiseNumberPrefix) {
		return isSetPremiseNumberPrefix() && this.premiseNumberPrefix.remove(premiseNumberPrefix);
	}

	public void unsetPremiseNumberSuffix() {
		premiseNumberSuffix = ModelObjects.setNull(premiseNumberSuffix);
	}

	public boolean unsetPremiseNumberSuffix(PremiseNumberSuffix premiseNumberSuffix) {
		return isSetPremiseNumberSuffix() && this.premiseNumberSuffix.remove(premiseNumberSuffix);
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
	
	public void accept(XALVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(XALFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
