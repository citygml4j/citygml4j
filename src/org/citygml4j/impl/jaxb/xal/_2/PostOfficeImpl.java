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

	public void addAddressLine(AddressLine addressLine) {
		postOffice.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	public void addPostOfficeName(PostOfficeName postOfficeName) {
		postOffice.getPostOfficeName().add(((PostOfficeNameImpl)postOfficeName).getJAXBObject());
	}

	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : postOffice.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	public String getIndicator() {
		return postOffice.getIndicator();
	}

	public PostBox getPostBox() {
		if (postOffice.isSetPostBox())
			return new PostBoxImpl(postOffice.getPostBox());

		return null;
	}

	public List<PostOfficeName> getPostOfficeName() {
		List<PostOfficeName> postOfficeNameList = new ArrayList<PostOfficeName>();

		for (PostOfficeElement.PostOfficeName postOfficeNameElem : postOffice.getPostOfficeName())
			postOfficeNameList.add(new PostOfficeNameImpl(postOfficeNameElem));

		return postOfficeNameList;
	}

	public PostOfficeNumber getPostOfficeNumber() {
		if (postOffice.isSetPostOfficeNumber())
			return new PostOfficeNumberImpl(postOffice.getPostOfficeNumber());

		return null;
	}

	public PostalCode getPostalCode() {
		if (postOffice.isSetPostalCode())
			return new PostalCodeImpl(postOffice.getPostalCode());

		return null;
	}

	public PostalRoute getPostalRoute() {
		if (postOffice.isSetPostalRoute())
			return new PostalRouteImpl(postOffice.getPostalRoute());

		return null;
	}

	public String getType() {
		return postOffice.getType();
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		postOffice.unsetAddressLine();
		postOffice.getAddressLine().addAll(addressLineElemList);
	}

	public void setIndicator(String indicator) {
		postOffice.setIndicator(indicator);
	}

	public void setPostBox(PostBox postBox) {
		postOffice.setPostBox(((PostBoxImpl)postBox).getJAXBObject());
	}

	public void setPostOfficeName(List<PostOfficeName> postOfficeName) {
		List<PostOfficeElement.PostOfficeName> postOfficeNameElemList = new ArrayList<PostOfficeElement.PostOfficeName>();

		for (PostOfficeName postOfficeNameItem : postOfficeName)
			postOfficeNameElemList.add(((PostOfficeNameImpl)postOfficeNameItem).getJAXBObject());

		postOffice.unsetPostOfficeName();
		postOffice.getPostOfficeName().addAll(postOfficeNameElemList);
	}

	public void setPostOfficeNumber(PostOfficeNumber postOfficeNumber) {
		postOffice.setPostOfficeNumber(((PostOfficeNumberImpl)postOfficeNumber).getJAXBObject());
	}

	public void setPostalCode(PostalCode postalCode) {
		postOffice.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	public void setPostalRoute(PostalRoute postalRoute) {
		postOffice.setPostalRoute(((PostalRouteImpl)postalRoute).getJAXBObject());
	}

	public void setType(String type) {
		postOffice.setType(type);
	}

	public boolean isSetAddressLine() {
		return postOffice.isSetAddressLine();
	}

	public boolean isSetIndicator() {
		return postOffice.isSetIndicator();
	}

	public boolean isSetPostalCode() {
		return postOffice.isSetPostalCode();
	}

	public boolean isSetPostalRoute() {
		return postOffice.isSetPostalRoute();
	}

	public boolean isSetPostBox() {
		return postOffice.isSetPostBox();
	}

	public boolean isSetPostOfficeName() {
		return postOffice.isSetPostOfficeName();
	}

	public boolean isSetPostOfficeNumber() {
		return postOffice.isSetPostOfficeNumber();
	}

	public boolean isSetType() {
		return postOffice.isSetType();
	}

	public void unsetAddressLine() {
		postOffice.unsetAddressLine();
	}

	public void unsetIndicator() {
		postOffice.setIndicator(null);
	}

	public void unsetPostalCode() {
		postOffice.setPostalCode(null);
	}

	public void unsetPostalRoute() {
		postOffice.setPostalRoute(null);
	}

	public void unsetPostBox() {
		postOffice.setPostBox(null);
	}

	public void unsetPostOfficeName() {
		postOffice.unsetPostOfficeName();
	}

	public void unsetPostOfficeNumber() {
		postOffice.setPostOfficeNumber(null);
	}

	public void unsetType() {
		postOffice.setType(null);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		if (postOffice.isSetAddressLine())
			return postOffice.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	public boolean unsetPostOfficeName(PostOfficeName postOfficeName) {
		if (postOffice.isSetPostOfficeName())
			return postOffice.getPostOfficeName().remove(((PostOfficeNameImpl)postOfficeName).getJAXBObject());
		
		return false;
	}

}
