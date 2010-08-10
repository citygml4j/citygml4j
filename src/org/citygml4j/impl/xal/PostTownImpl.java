package org.citygml4j.impl.xal;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.PostTown;
import org.citygml4j.model.xal.PostTownName;
import org.citygml4j.model.xal.PostTownSuffix;
import org.citygml4j.model.xal.XALClass;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public class PostTownImpl implements PostTown {
	private List<AddressLine> addressLine;
	private List<PostTownName> postTownName;
	private PostTownSuffix postTownSuffix;
	private String type;
	private Object parent;
	
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

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PostTownImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PostTown copy = (target == null) ? new PostTownImpl() : (PostTown)target;
		
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
		visitor.accept(this);
	}
	
	public <T> T visit(XALFunction<T> visitor) {
		return visitor.accept(this);
	}

}
