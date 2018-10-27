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

public class PostalRoute implements XAL, Child, Copyable {
	private List<AddressLine> addressLine;
	private List<PostalRouteName> postalRouteName;
	private PostalRouteNumber postalRouteNumber;
	private PostBox postBox;
	private String type;
	private ModelObject parent;
	
	public void addAddressLine(AddressLine addressLine) {
		if (this.addressLine == null)
			this.addressLine = new ChildList<AddressLine>(this);

		this.addressLine.add(addressLine);
	}

	public void addPostalRouteName(PostalRouteName postalRouteName) {
		if (this.postalRouteName == null)
			this.postalRouteName = new ChildList<PostalRouteName>(this);

		this.postalRouteName.add(postalRouteName);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<AddressLine>(this);

		return addressLine;
	}

	public PostBox getPostBox() {
		return postBox;
	}

	public List<PostalRouteName> getPostalRouteName() {
		if (postalRouteName == null)
			postalRouteName = new ChildList<PostalRouteName>(this);

		return postalRouteName;
	}

	public PostalRouteNumber getPostalRouteNumber() {
		return postalRouteNumber;
	}

	public String getType() {
		return type;
	}

	public boolean isSetAddressLine() {
		return addressLine != null && !addressLine.isEmpty();
	}

	public boolean isSetPostBox() {
		return postBox != null;
	}

	public boolean isSetPostalRouteName() {
		return postalRouteName != null && !postalRouteName.isEmpty();
	}

	public boolean isSetPostalRouteNumber() {
		return postalRouteNumber != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		this.addressLine = new ChildList<AddressLine>(this, addressLine);
	}

	public void setPostBox(PostBox postBox) {
		if (postBox != null)
			postBox.setParent(this);
		
		this.postBox = postBox;
	}

	public void setPostalRouteName(List<PostalRouteName> postalRouteName) {
		this.postalRouteName = new ChildList<PostalRouteName>(this, postalRouteName);
	}

	public void setPostalRouteNumber(PostalRouteNumber postalRouteNumber) {
		if (postalRouteNumber != null)
			postalRouteNumber.setParent(this);
		
		this.postalRouteNumber = postalRouteNumber;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void unsetAddressLine() {
		if (isSetAddressLine())
			addressLine.clear();

		addressLine = null;
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		return isSetAddressLine() ? this.addressLine.remove(addressLine) : false;
	}

	public void unsetPostBox() {
		if (isSetPostBox())
			postBox.unsetParent();
		
		postBox = null;
	}

	public void unsetPostalRouteName() {
		if (isSetPostalRouteName())
			postalRouteName.clear();

		postalRouteName = null;
	}

	public boolean unsetPostalRouteName(PostalRouteName postalRouteName) {
		return isSetPostalRouteName() ? this.postalRouteName.remove(postalRouteName) : false;
	}

	public void unsetPostalRouteNumber() {
		if (isSetPostalRouteNumber())
			postalRouteNumber.unsetParent();
		
		postalRouteNumber = null;
	}

	public void unsetType() {
		type = null;
	}

	public XALClass getXALClass() {
		return XALClass.POSTAL_ROUTE;
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
		return copyTo(new PostalRoute(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PostalRoute copy = (target == null) ? new PostalRoute() : (PostalRoute)target;
		
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
		
		if (isSetPostalRouteName()) {
			for (PostalRouteName part : postalRouteName) {
				PostalRouteName copyPart = (PostalRouteName)copyBuilder.copy(part);
				copy.addPostalRouteName(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetPostalRouteNumber()) {
			copy.setPostalRouteNumber((PostalRouteNumber)copyBuilder.copy(postalRouteNumber));
			if (copy.getPostalRouteNumber() == postalRouteNumber)
				postalRouteNumber.setParent(this);
		}
		
		if (isSetPostBox()) {
			copy.setPostBox((PostBox)copyBuilder.copy(postBox));
			if (copy.getPostBox() == postBox)
				postBox.setParent(this);
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
