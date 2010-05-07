package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.PostalRouteType;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.PostBox;
import org.citygml4j.model.xal.PostalRoute;
import org.citygml4j.model.xal.PostalRouteName;
import org.citygml4j.model.xal.PostalRouteNumber;
import org.citygml4j.model.xal.XALClass;

public class PostalRouteImpl extends XALBaseImpl implements PostalRoute {
	private PostalRouteType postalRoute;

	public PostalRouteImpl() {
		postalRoute = new PostalRouteType();
	}

	public PostalRouteImpl(PostalRouteType postalRoute) {
		this.postalRoute = postalRoute;
	}

	@Override
	public PostalRouteType getJAXBObject() {
		return postalRoute;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.POSTALROUTE;
	}

	public void addAddressLine(AddressLine addressLine) {
		postalRoute.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	public void addPostalRouteName(PostalRouteName postalRouteName) {
		postalRoute.getPostalRouteName().add(((PostalRouteNameImpl)postalRouteName).getJAXBObject());
	}

	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : postalRoute.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	public PostBox getPostBox() {
		if (postalRoute.isSetPostBox()) 
			return new PostBoxImpl(postalRoute.getPostBox());

		return null;
	}

	public List<PostalRouteName> getPostalRouteName() {
		List<PostalRouteName> postalRouteNameList = new ArrayList<PostalRouteName>();

		for (PostalRouteType.PostalRouteName postalRouteNameElem : postalRoute.getPostalRouteName())
			postalRouteNameList.add(new PostalRouteNameImpl(postalRouteNameElem));

		return postalRouteNameList;
	}

	public PostalRouteNumber getPostalRouteNumber() {
		if (postalRoute.isSetPostalRouteNumber())
			return new PostalRouteNumberImpl(postalRoute.getPostalRouteNumber());

		return null;
	}

	public String getType() {
		return postalRoute.getType();
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		postalRoute.unsetAddressLine();
		postalRoute.getAddressLine().addAll(addressLineElemList);
	}

	public void setPostBox(PostBox postBox) {
		postalRoute.setPostBox(((PostBoxImpl)postBox).getJAXBObject());
	}

	public void setPostalRouteName(List<PostalRouteName> postalRouteName) {
		List<PostalRouteType.PostalRouteName> postalRouteNameElemList = new ArrayList<PostalRouteType.PostalRouteName>();

		for (PostalRouteName postalRouteNameItem : postalRouteName)
			postalRouteNameElemList.add(((PostalRouteNameImpl)postalRouteNameItem).getJAXBObject());

		postalRoute.unsetPostalRouteName();
		postalRoute.getPostalRouteName().addAll(postalRouteNameElemList);
	}

	public void setPostalRouteNumber(PostalRouteNumber postalRouteNumber) {
		postalRoute.setPostalRouteNumber(((PostalRouteNumberImpl)postalRouteNumber).getJAXBObject());
	}

	public void setType(String type) {
		postalRoute.setType(type);
	}

	public boolean isSetAddressLine() {
		return postalRoute.isSetAddressLine();
	}

	public boolean isSetPostalRouteName() {
		return postalRoute.isSetPostalRouteName();
	}

	public boolean isSetPostalRouteNumber() {
		return postalRoute.isSetPostalRouteNumber();
	}

	public boolean isSetPostBox() {
		return postalRoute.isSetPostBox();
	}

	public boolean isSetType() {
		return postalRoute.isSetType();
	}

	public void unsetAddressLine() {
		postalRoute.unsetAddressLine();
	}

	public void unsetPostalRouteName() {
		postalRoute.unsetPostalRouteName();
	}

	public void unsetPostalRouteNumber() {
		postalRoute.setPostalRouteNumber(null);
	}

	public void unsetPostBox() {
		postalRoute.setPostBox(null);
	}

	public void unsetType() {
		postalRoute.setType(null);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		if (postalRoute.isSetAddressLine())
			return postalRoute.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	public boolean unsetPostalRouteName(PostalRouteName postalRouteName) {
		if (postalRoute.isSetPostalRouteName())
			return postalRoute.getPostalRouteName().remove(((PostalRouteNameImpl)postalRouteName).getJAXBObject());
		
		return false;
	}

}
