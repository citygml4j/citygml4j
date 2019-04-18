/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2019 Claus Nagel <claus.nagel@gmail.com>
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

public class PostBox implements XAL, Child, Copyable {
	private List<AddressLine> addressLine;
	private PostBoxNumber postBoxNumber;
	private PostBoxNumberPrefix postBoxNumberPrefix;
	private PostBoxNumberSuffix postBoxNumberSuffix;
	private PostBoxNumberExtension postBoxNumberExtension;
	private Firm firm;
	private PostalCode postalCode;
	private String indicator;
	private String type;
	private ModelObject parent;
	
	public void addAddressLine(AddressLine addressLine) {
		getAddressLine().add(addressLine);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<>(this);

		return addressLine;
	}

	public Firm getFirm() {
		return firm;
	}

	public String getIndicator() {
		return indicator;
	}

	public PostBoxNumber getPostBoxNumber() {
		return postBoxNumber;
	}

	public PostBoxNumberExtension getPostBoxNumberExtension() {
		return postBoxNumberExtension;
	}

	public PostBoxNumberPrefix getPostBoxNumberPrefix() {
		return postBoxNumberPrefix;
	}

	public PostBoxNumberSuffix getPostBoxNumberSuffix() {
		return postBoxNumberSuffix;
	}

	public PostalCode getPostalCode() {
		return postalCode;
	}

	public String getType() {
		return type;
	}

	public boolean isSetAddressLine() {
		return addressLine != null && !addressLine.isEmpty();
	}

	public boolean isSetFirm() {
		return firm != null;
	}

	public boolean isSetIndicator() {
		return indicator != null;
	}

	public boolean isSetPostBoxNumber() {
		return postBoxNumber != null;
	}

	public boolean isSetPostBoxNumberExtension() {
		return postBoxNumberExtension != null;
	}

	public boolean isSetPostBoxNumberPrefix() {
		return postBoxNumberPrefix != null;
	}

	public boolean isSetPostBoxNumberSuffix() {
		return postBoxNumberSuffix != null;
	}

	public boolean isSetPostalCode() {
		return postalCode != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		this.addressLine = new ChildList<>(this, addressLine);
	}

	public void setFirm(Firm firm) {
		this.firm = ModelObjects.setParent(firm, this);
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public void setPostBoxNumber(PostBoxNumber postBoxNumber) {
		this.postBoxNumber = ModelObjects.setParent(postBoxNumber, this);
	}

	public void setPostBoxNumberExtension(PostBoxNumberExtension postBoxNumberExtension) {
		this.postBoxNumberExtension = ModelObjects.setParent(postBoxNumberExtension, this);
	}

	public void setPostBoxNumberPrefix(PostBoxNumberPrefix postBoxNumberPrefix) {
		this.postBoxNumberPrefix = ModelObjects.setParent(postBoxNumberPrefix, this);
	}

	public void setPostBoxNumberSuffix(PostBoxNumberSuffix postBoxNumberSuffix) {
		this.postBoxNumberSuffix = ModelObjects.setParent(postBoxNumberSuffix, this);
	}

	public void setPostalCode(PostalCode postalCode) {
		this.postalCode = ModelObjects.setParent(postalCode, this);
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

	public void unsetFirm() {
		firm = ModelObjects.setNull(firm);
	}

	public void unsetIndicator() {
		indicator = null;
	}

	public void unsetPostBoxNumber() {
		postBoxNumber = ModelObjects.setNull(postBoxNumber);
	}

	public void unsetPostBoxNumberExtension() {
		postBoxNumberExtension = ModelObjects.setNull(postBoxNumberExtension);
	}

	public void unsetPostBoxNumberPrefix() {
		postBoxNumberPrefix = ModelObjects.setNull(postBoxNumberPrefix);
	}

	public void unsetPostBoxNumberSuffix() {
		postBoxNumberSuffix = ModelObjects.setNull(postBoxNumberSuffix);
	}

	public void unsetPostalCode() {
		postalCode = ModelObjects.setNull(postalCode);
	}

	public void unsetType() {
		type = null;
	}

	public XALClass getXALClass() {
		return XALClass.POST_BOX;
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
		return copyTo(new PostBox(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PostBox copy = (target == null) ? new PostBox() : (PostBox)target;
		
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
		
		if (isSetFirm()) {
			copy.setFirm((Firm)copyBuilder.copy(firm));
			if (copy.getFirm() == firm)
				firm.setParent(this);
		}
		
		if (isSetPostBoxNumber()) {
			copy.setPostBoxNumber((PostBoxNumber)copyBuilder.copy(postBoxNumber));
			if (copy.getPostBoxNumber() == postBoxNumber)
				postBoxNumber.setParent(this);
		}
		
		if (isSetPostBoxNumberExtension()) {
			copy.setPostBoxNumberExtension((PostBoxNumberExtension)copyBuilder.copy(postBoxNumberExtension));
			if (copy.getPostBoxNumberExtension() == postBoxNumberExtension)
				postBoxNumberExtension.setParent(this);
		}
		
		if (isSetPostBoxNumberPrefix()) {
			copy.setPostBoxNumberPrefix((PostBoxNumberPrefix)copyBuilder.copy(postBoxNumberPrefix));
			if (copy.getPostBoxNumberPrefix() == postBoxNumberPrefix)
				postBoxNumberPrefix.setParent(this);
		}
		
		if (isSetPostBoxNumberSuffix()) {
			copy.setPostBoxNumberSuffix((PostBoxNumberSuffix)copyBuilder.copy(postBoxNumberSuffix));
			if (copy.getPostBoxNumberSuffix() == postBoxNumberSuffix)
				postBoxNumberSuffix.setParent(this);
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
