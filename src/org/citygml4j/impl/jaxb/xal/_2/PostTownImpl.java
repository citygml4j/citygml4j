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

	@Override
	public void addAddressLine(AddressLine addressLine) {
		postTown.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public void addPostTownName(PostTownName postTownName) {
		postTown.getPostTownName().add(((PostTownNameImpl)postTownName).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();
		List<AddressLineElement> addressLineElemList = postTown.getAddressLine();

		for (AddressLineElement addressLineElem : addressLineElemList)
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;	
	}

	@Override
	public List<PostTownName> getPostTownName() {
		List<PostTownName> postTownNameList = new ArrayList<PostTownName>();
		List<PostalCodeElement.PostTown.PostTownName> postTownNameElemList = postTown.getPostTownName();

		for (PostalCodeElement.PostTown.PostTownName postTownNameElem : postTownNameElemList)
			postTownNameList.add(new PostTownNameImpl(postTownNameElem));

		return postTownNameList;
	}

	@Override
	public PostTownSuffix getPostTownSuffix() {
		if (postTown.isSetPostTownSuffix())
			return new PostTownSuffixImpl(postTown.getPostTownSuffix());

		return null;
	}

	@Override
	public String getType() {
		return postTown.getType();
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		postTown.unsetAddressLine();
		postTown.getAddressLine().addAll(addressLineElemList);
	}

	@Override
	public void setPostTownName(List<PostTownName> postTownName) {
		List<PostalCodeElement.PostTown.PostTownName> postTownNameElemList = new ArrayList<PostalCodeElement.PostTown.PostTownName>();

		for (PostTownName postTownNameItem : postTownName)
			postTownNameElemList.add(((PostTownNameImpl)postTownNameItem).getJAXBObject());

		postTown.unsetPostTownName();
		postTown.getPostTownName().addAll(postTownNameElemList);
	}

	@Override
	public void setPostTownSuffix(PostTownSuffix postTownSuffix) {
		postTown.setPostTownSuffix(((PostTownSuffixImpl)postTownSuffix).getJAXBObject());
	}

	@Override
	public void setType(String type) {
		postTown.setType(type);
	}

	@Override
	public boolean isSetAddressLine() {
		return postTown.isSetAddressLine();
	}

	@Override
	public boolean isSetPostTownName() {
		return postTown.isSetPostTownName();
	}

	@Override
	public boolean isSetPostTownSuffix() {
		return postTown.isSetPostTownSuffix();
	}

	@Override
	public boolean isSetType() {
		return postTown.isSetType();
	}

	@Override
	public void unsetAddressLine() {
		postTown.unsetAddressLine();
	}

	@Override
	public void unsetPostTownName() {
		postTown.unsetPostTownName();
	}

	@Override
	public void unsetPostTownSuffix() {
		postTown.setPostTownSuffix(null);
	}

	@Override
	public void unsetType() {
		postTown.setType(null);
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (postTown.isSetAddressLine())
			return postTown.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetPostTownName(PostTownName postTownName) {
		if (postTown.isSetPostTownName())
			return postTown.getPostTownName().remove(((PostTownNameImpl)postTownName).getJAXBObject());
		
		return false;
	}

}
