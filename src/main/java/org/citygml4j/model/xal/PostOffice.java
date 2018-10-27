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

public class PostOffice implements XAL, Child, Copyable {
	private List<AddressLine> addressLine;
	private List<PostOfficeName> postOfficeName;
	private PostOfficeNumber postOfficeNumber;
	private PostalRoute postalRoute;
	private PostBox postBox;
	private PostalCode postalCode;
	private String type;
	private String indicator;
	private ModelObject parent;
	
	public void addAddressLine(AddressLine addressLine) {
		if (this.addressLine == null)
			this.addressLine = new ChildList<AddressLine>(this);

		this.addressLine.add(addressLine);
	}

	public void addPostOfficeName(PostOfficeName postOfficeName) {
		if (this.postOfficeName == null)
			this.postOfficeName = new ChildList<PostOfficeName>(this);

		this.postOfficeName.add(postOfficeName);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<AddressLine>(this);

		return addressLine;
	}

	public String getIndicator() {
		return indicator;
	}

	public PostBox getPostBox() {
		return postBox;
	}

	public List<PostOfficeName> getPostOfficeName() {
		if (postOfficeName == null)
			postOfficeName = new ChildList<PostOfficeName>(this);

		return postOfficeName;
	}

	public PostOfficeNumber getPostOfficeNumber() {
		return postOfficeNumber;
	}

	public PostalCode getPostalCode() {
		return postalCode;
	}

	public PostalRoute getPostalRoute() {
		return postalRoute;
	}

	public String getType() {
		return type;
	}

	public boolean isSetAddressLine() {
		return addressLine != null && !addressLine.isEmpty();
	}

	public boolean isSetIndicator() {
		return indicator != null;
	}

	public boolean isSetPostBox() {
		return postBox != null;
	}

	public boolean isSetPostOfficeName() {
		return postOfficeName != null && !postOfficeName.isEmpty();
	}

	public boolean isSetPostOfficeNumber() {
		return postOfficeNumber != null;
	}

	public boolean isSetPostalCode() {
		return postalCode != null;
	}

	public boolean isSetPostalRoute() {
		return postalRoute != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		this.addressLine = new ChildList<AddressLine>(this, addressLine);
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public void setPostBox(PostBox postBox) {
		if (postBox != null)
			postBox.setParent(this);
		
		this.postBox = postBox;
	}

	public void setPostOfficeName(List<PostOfficeName> postOfficeName) {
		this.postOfficeName = new ChildList<PostOfficeName>(this, postOfficeName);
	}

	public void setPostOfficeNumber(PostOfficeNumber postOfficeNumber) {
		if (postOfficeNumber != null)
			postOfficeNumber.setParent(this);
		
		this.postOfficeNumber = postOfficeNumber;
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

	public void unsetIndicator() {
		indicator = null;
	}

	public void unsetPostBox() {
		if (isSetPostBox())
			postBox.unsetParent();
		
		postBox = null;
	}

	public void unsetPostOfficeName() {
		if (isSetPostOfficeName())
			postOfficeName.clear();

		postOfficeName = null;
	}

	public boolean unsetPostOfficeName(PostOfficeName postOfficeName) {
		return isSetPostOfficeName() ? this.postOfficeName.remove(postOfficeName) : false;
	}

	public void unsetPostOfficeNumber() {
		if (isSetPostOfficeNumber())
			postOfficeNumber.unsetParent();
		
		postOfficeNumber = null;
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

	public void unsetType() {
		type = null;
	}

	public XALClass getXALClass() {
		return XALClass.POST_OFFICE;
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
		return copyTo(new PostOffice(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PostOffice copy = (target == null) ? new PostOffice() : (PostOffice)target;
		
		if (isSetType())
			copy.setType(copyBuilder.copy(type));

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
		
		if (isSetPostOfficeName()) {
			for (PostOfficeName part : postOfficeName) {
				PostOfficeName copyPart = (PostOfficeName)copyBuilder.copy(part);
				copy.addPostOfficeName(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetPostOfficeNumber()) {
			copy.setPostOfficeNumber((PostOfficeNumber)copyBuilder.copy(postOfficeNumber));
			if (copy.getPostOfficeNumber() == postOfficeNumber)
				postOfficeNumber.setParent(this);
		}
		
		if (isSetPostalCode()) {
			copy.setPostalCode((PostalCode)copyBuilder.copy(postalCode));
			if (copy.getPostalCode() == postalCode)
				postalCode.setParent(this);
		}
		
		if (isSetPostalRoute()) {
			copy.setPostalRoute((PostalRoute)copyBuilder.copy(postalRoute));
			if (copy.getPostalRoute() == postalRoute)
				postalRoute.setParent(this);
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
