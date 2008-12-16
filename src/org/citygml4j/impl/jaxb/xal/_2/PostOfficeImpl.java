package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.PostOfficeElement;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.PostBox;
import org.citygml4j.model.xal.PostOffice;
import org.citygml4j.model.xal.PostOfficeName;
import org.citygml4j.model.xal.PostOfficeNumber;
import org.citygml4j.model.xal.PostalCode;
import org.citygml4j.model.xal.PostalRoute;
import org.citygml4j.model.xal.XALClass;

public class PostOfficeImpl extends XALBaseImpl implements PostOffice {
	private PostOfficeElement postOffice;

	public PostOfficeImpl() {
		postOffice = new PostOfficeElement();
	}

	public PostOfficeImpl(PostOfficeElement postOffice) {
		this.postOffice = postOffice;
	}

	@Override
	public PostOfficeElement getJAXBObject() {
		return postOffice;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.POSTOFFICE;
	}

	@Override
	public void addAddressLine(AddressLine addressLine) {
		postOffice.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public void addPostOfficeName(PostOfficeName postOfficeName) {
		postOffice.getPostOfficeName().add(((PostOfficeNameImpl)postOfficeName).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();
		List<AddressLineElement> addressLineElemList = postOffice.getAddressLine();

		for (AddressLineElement addressLineElem : addressLineElemList)
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	@Override
	public String getIndicator() {
		return postOffice.getIndicator();
	}

	@Override
	public PostBox getPostBox() {
		if (postOffice.isSetPostBox())
			return new PostBoxImpl(postOffice.getPostBox());

		return null;
	}

	@Override
	public List<PostOfficeName> getPostOfficeName() {
		List<PostOfficeName> postOfficeNameList = new ArrayList<PostOfficeName>();
		List<PostOfficeElement.PostOfficeName> postOfficeNameElemList = postOffice.getPostOfficeName();

		for (PostOfficeElement.PostOfficeName postOfficeNameElem : postOfficeNameElemList)
			postOfficeNameList.add(new PostOfficeNameImpl(postOfficeNameElem));

		return postOfficeNameList;
	}

	@Override
	public PostOfficeNumber getPostOfficeNumber() {
		if (postOffice.isSetPostOfficeNumber())
			return new PostOfficeNumberImpl(postOffice.getPostOfficeNumber());

		return null;
	}

	@Override
	public PostalCode getPostalCode() {
		if (postOffice.isSetPostalCode())
			return new PostalCodeImpl(postOffice.getPostalCode());

		return null;
	}

	@Override
	public PostalRoute getPostalRoute() {
		if (postOffice.isSetPostalRoute())
			return new PostalRouteImpl(postOffice.getPostalRoute());

		return null;
	}

	@Override
	public String getType() {
		return postOffice.getType();
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		postOffice.unsetAddressLine();
		postOffice.getAddressLine().addAll(addressLineElemList);
	}

	@Override
	public void setIndicator(String indicator) {
		postOffice.setIndicator(indicator);
	}

	@Override
	public void setPostBox(PostBox postBox) {
		postOffice.setPostBox(((PostBoxImpl)postBox).getJAXBObject());
	}

	@Override
	public void setPostOfficeName(List<PostOfficeName> postOfficeName) {
		List<PostOfficeElement.PostOfficeName> postOfficeNameElemList = new ArrayList<PostOfficeElement.PostOfficeName>();

		for (PostOfficeName postOfficeNameItem : postOfficeName)
			postOfficeNameElemList.add(((PostOfficeNameImpl)postOfficeNameItem).getJAXBObject());

		postOffice.unsetPostOfficeName();
		postOffice.getPostOfficeName().addAll(postOfficeNameElemList);
	}

	@Override
	public void setPostOfficeNumber(PostOfficeNumber postOfficeNumber) {
		postOffice.setPostOfficeNumber(((PostOfficeNumberImpl)postOfficeNumber).getJAXBObject());
	}

	@Override
	public void setPostalCode(PostalCode postalCode) {
		postOffice.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	@Override
	public void setPostalRoute(PostalRoute postalRoute) {
		postOffice.setPostalRoute(((PostalRouteImpl)postalRoute).getJAXBObject());
	}

	@Override
	public void setType(String type) {
		postOffice.setType(type);
	}

	@Override
	public boolean isSetAddressLine() {
		return postOffice.isSetAddressLine();
	}

	@Override
	public boolean isSetIndicator() {
		return postOffice.isSetIndicator();
	}

	@Override
	public boolean isSetPostalCode() {
		return postOffice.isSetPostalCode();
	}

	@Override
	public boolean isSetPostalRoute() {
		return postOffice.isSetPostalRoute();
	}

	@Override
	public boolean isSetPostBox() {
		return postOffice.isSetPostBox();
	}

	@Override
	public boolean isSetPostOfficeName() {
		return postOffice.isSetPostOfficeName();
	}

	@Override
	public boolean isSetPostOfficeNumber() {
		return postOffice.isSetPostOfficeNumber();
	}

	@Override
	public boolean isSetType() {
		return postOffice.isSetType();
	}

	@Override
	public void unsetAddressLine() {
		postOffice.unsetAddressLine();
	}

	@Override
	public void unsetIndicator() {
		postOffice.setIndicator(null);
	}

	@Override
	public void unsetPostalCode() {
		postOffice.setPostalCode(null);
	}

	@Override
	public void unsetPostalRoute() {
		postOffice.setPostalRoute(null);
	}

	@Override
	public void unsetPostBox() {
		postOffice.setPostBox(null);
	}

	@Override
	public void unsetPostOfficeName() {
		postOffice.unsetPostOfficeName();
	}

	@Override
	public void unsetPostOfficeNumber() {
		postOffice.setPostOfficeNumber(null);
	}

	@Override
	public void unsetType() {
		postOffice.setType(null);
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (postOffice.isSetAddressLine())
			return postOffice.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetPostOfficeName(PostOfficeName postOfficeName) {
		if (postOffice.isSetPostOfficeName())
			return postOffice.getPostOfficeName().remove(((PostOfficeNameImpl)postOfficeName).getJAXBObject());
		
		return false;
	}

}
