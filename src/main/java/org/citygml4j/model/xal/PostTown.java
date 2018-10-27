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

public class PostTown implements XAL, Child, Copyable {
	private List<AddressLine> addressLine;
	private List<PostTownName> postTownName;
	private PostTownSuffix postTownSuffix;
	private String type;
	private ModelObject parent;
	
	public void addAddressLine(AddressLine addressLine) {
		if (this.addressLine == null)
			this.addressLine = new ChildList<AddressLine>(this);

		this.addressLine.add(addressLine);
	}

	public void addPostTownName(PostTownName postTownName) {
		if (this.postTownName == null)
			this.postTownName = new ChildList<PostTownName>(this);

		this.postTownName.add(postTownName);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<AddressLine>(this);

		return addressLine;
	}

	public List<PostTownName> getPostTownName() {
		if (postTownName == null)
			postTownName = new ChildList<PostTownName>(this);

		return postTownName;
	}

	public PostTownSuffix getPostTownSuffix() {
		return postTownSuffix;
	}

	public String getType() {
		return type;
	}

	public boolean isSetAddressLine() {
		return addressLine != null && !addressLine.isEmpty();
	}

	public boolean isSetPostTownName() {
		return postTownName != null && !postTownName.isEmpty();
	}

	public boolean isSetPostTownSuffix() {
		return postTownSuffix != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		this.addressLine = new ChildList<AddressLine>(this, addressLine);
	}

	public void setPostTownName(List<PostTownName> postTownName) {
		this.postTownName = new ChildList<PostTownName>(this, postTownName);
	}

	public void setPostTownSuffix(PostTownSuffix postTownSuffix) {
		if (postTownSuffix != null)
			postTownSuffix.setParent(this);
		
		this.postTownSuffix = postTownSuffix;
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

	public void unsetPostTownName() {
		if (isSetPostTownName())
			postTownName.clear();
		
		postTownName = null;
	}

	public boolean unsetPostTownName(PostTownName postTownName) {
		return isSetPostTownName() ? this.postTownName.remove(postTownName) : false;
	}

	public void unsetPostTownSuffix() {
		if (isSetPostTownSuffix())
			postTownSuffix.unsetParent();
		
		postTownSuffix = null;
	}

	public void unsetType() {
		type = null;
	}

	public XALClass getXALClass() {
		return XALClass.POST_TOWN;
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
		return copyTo(new PostTown(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PostTown copy = (target == null) ? new PostTown() : (PostTown)target;
		
		if (isSetAddressLine()) {
			for (AddressLine part : addressLine) {
				AddressLine copyPart = (AddressLine)copyBuilder.copy(part);
				copy.addAddressLine(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetPostTownName()) {
			for (PostTownName part : postTownName) {
				PostTownName copyPart = (PostTownName)copyBuilder.copy(part);
				copy.addPostTownName(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetPostTownSuffix()) {
			copy.setPostTownSuffix((PostTownSuffix)copyBuilder.copy(postTownSuffix));
			if (copy.getPostTownSuffix() == postTownSuffix)
				postTownSuffix.setParent(this);
		}
		
		if (isSetType())
			copy.setType(copyBuilder.copy(type));
		
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
