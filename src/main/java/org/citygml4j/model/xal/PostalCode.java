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

public class PostalCode implements XAL, Child, Copyable {
	private List<AddressLine> addressLine;
	private List<PostalCodeNumber> postalCodeNumber;
	private List<PostalCodeNumberExtension> postalCodeNumberExtension;
	private PostTown postTown;
	private String type;
	private ModelObject parent;

	public void addAddressLine(AddressLine addressLine) {
		getAddressLine().add(addressLine);
	}

	public void addPostalCodeNumber(PostalCodeNumber postalCodeNumber) {
		getPostalCodeNumber().add(postalCodeNumber);
	}

	public void addPostalCodeNumberExtension(PostalCodeNumberExtension postalCodeNumberExtension) {
		getPostalCodeNumberExtension().add(postalCodeNumberExtension);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<>(this);

		return addressLine;
	}

	public PostTown getPostTown() {
		return postTown;
	}

	public List<PostalCodeNumber> getPostalCodeNumber() {
		if (postalCodeNumber == null)
			postalCodeNumber = new ChildList<>(this);

		return postalCodeNumber;
	}

	public List<PostalCodeNumberExtension> getPostalCodeNumberExtension() {
		if (postalCodeNumberExtension == null)
			postalCodeNumberExtension = new ChildList<>(this);

		return postalCodeNumberExtension;
	}

	public String getType() {
		return type;
	}

	public boolean isSetAddressLine() {
		return addressLine != null && !addressLine.isEmpty();
	}

	public boolean isSetPostTown() {
		return postTown != null;
	}

	public boolean isSetPostalCodeNumber() {
		return postalCodeNumber != null && !postalCodeNumber.isEmpty();
	}

	public boolean isSetPostalCodeNumberExtension() {
		return postalCodeNumberExtension != null && !postalCodeNumberExtension.isEmpty();
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		this.addressLine = new ChildList<>(this, addressLine);
	}

	public void setPostTown(PostTown postTown) {
		this.postTown = ModelObjects.setParent(postTown, this);
	}

	public void setPostalCodeNumber(List<PostalCodeNumber> postalCodeNumber) {
		this.postalCodeNumber = new ChildList<>(this, postalCodeNumber);
	}

	public void setPostalCodeNumberExtension(List<PostalCodeNumberExtension> postalCodeNumberExtension) {
		this.postalCodeNumberExtension = new ChildList<>(this, postalCodeNumberExtension);
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

	public void unsetPostTown() {
		postTown = ModelObjects.setNull(postTown);
	}

	public void unsetPostalCodeNumber() {
		postalCodeNumber = ModelObjects.setNull(postalCodeNumber);
	}

	public boolean unsetPostalCodeNumber(PostalCodeNumber postalCodeNumber) {
		return isSetPostalCodeNumber() && this.postalCodeNumber.remove(postalCodeNumber);
	}

	public void unsetPostalCodeNumberExtension() {
		postalCodeNumberExtension = ModelObjects.setNull(postalCodeNumberExtension);
	}

	public boolean unsetPostalCodeNumberExtension(PostalCodeNumberExtension postalCodeNumberExtension) {
		return isSetPostalCodeNumberExtension() && this.postalCodeNumberExtension.remove(postalCodeNumberExtension);
	}

	public void unsetType() {
		type = null;
	}

	public XALClass getXALClass() {
		return XALClass.POSTAL_CODE;
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
		return copyTo(new PostalCode(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PostalCode copy = (target == null) ? new PostalCode() : (PostalCode)target;

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

		if (isSetPostalCodeNumber()) {
			for (PostalCodeNumber part : postalCodeNumber) {
				PostalCodeNumber copyPart = (PostalCodeNumber)copyBuilder.copy(part);
				copy.addPostalCodeNumber(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetPostalCodeNumberExtension()) {
			for (PostalCodeNumberExtension part : postalCodeNumberExtension) {
				PostalCodeNumberExtension copyPart = (PostalCodeNumberExtension)copyBuilder.copy(part);
				copy.addPostalCodeNumberExtension(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetPostTown()) {
			copy.setPostTown((PostTown)copyBuilder.copy(postTown));
			if (copy.getPostTown() == postTown)
				postTown.setParent(this);
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
