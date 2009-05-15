package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.PostalCodeElement;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.PostTown;
import org.citygml4j.model.xal.PostTownName;
import org.citygml4j.model.xal.PostTownSuffix;
import org.citygml4j.model.xal.XALClass;

public class PostTownImpl extends XALBaseImpl implements PostTown {
	private PostalCodeElement.PostTown postTown;

	public PostTownImpl() {
		postTown = new PostalCodeElement.PostTown();
	}

	public PostTownImpl(PostalCodeElement.PostTown postTown) {
		this.postTown = postTown;
	}

	@Override
	public PostalCodeElement.PostTown getJAXBObject() {
		return postTown;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.POSTTOWN;
	}

	public void addAddressLine(AddressLine addressLine) {
		postTown.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	public void addPostTownName(PostTownName postTownName) {
		postTown.getPostTownName().add(((PostTownNameImpl)postTownName).getJAXBObject());
	}

	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : postTown.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;	
	}

	public List<PostTownName> getPostTownName() {
		List<PostTownName> postTownNameList = new ArrayList<PostTownName>();

		for (PostalCodeElement.PostTown.PostTownName postTownNameElem : postTown.getPostTownName())
			postTownNameList.add(new PostTownNameImpl(postTownNameElem));

		return postTownNameList;
	}

	public PostTownSuffix getPostTownSuffix() {
		if (postTown.isSetPostTownSuffix())
			return new PostTownSuffixImpl(postTown.getPostTownSuffix());

		return null;
	}

	public String getType() {
		return postTown.getType();
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		postTown.unsetAddressLine();
		postTown.getAddressLine().addAll(addressLineElemList);
	}

	public void setPostTownName(List<PostTownName> postTownName) {
		List<PostalCodeElement.PostTown.PostTownName> postTownNameElemList = new ArrayList<PostalCodeElement.PostTown.PostTownName>();

		for (PostTownName postTownNameItem : postTownName)
			postTownNameElemList.add(((PostTownNameImpl)postTownNameItem).getJAXBObject());

		postTown.unsetPostTownName();
		postTown.getPostTownName().addAll(postTownNameElemList);
	}

	public void setPostTownSuffix(PostTownSuffix postTownSuffix) {
		postTown.setPostTownSuffix(((PostTownSuffixImpl)postTownSuffix).getJAXBObject());
	}

	public void setType(String type) {
		postTown.setType(type);
	}

	public boolean isSetAddressLine() {
		return postTown.isSetAddressLine();
	}

	public boolean isSetPostTownName() {
		return postTown.isSetPostTownName();
	}

	public boolean isSetPostTownSuffix() {
		return postTown.isSetPostTownSuffix();
	}

	public boolean isSetType() {
		return postTown.isSetType();
	}

	public void unsetAddressLine() {
		postTown.unsetAddressLine();
	}

	public void unsetPostTownName() {
		postTown.unsetPostTownName();
	}

	public void unsetPostTownSuffix() {
		postTown.setPostTownSuffix(null);
	}

	public void unsetType() {
		postTown.setType(null);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		if (postTown.isSetAddressLine())
			return postTown.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	public boolean unsetPostTownName(PostTownName postTownName) {
		if (postTown.isSetPostTownName())
			return postTown.getPostTownName().remove(((PostTownNameImpl)postTownName).getJAXBObject());
		
		return false;
	}

}
