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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * $Id: PostTown.java 542 2012-11-29 20:56:44Z nagel $
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

	public ModelType getModelType() {
		return ModelType.XAL;
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
	
	public void visit(XALVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T visit(XALFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
