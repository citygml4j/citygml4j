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

	@Override
	public void addAddressLine(AddressLine addressLine) {
		postalRoute.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public void addPostalRouteName(PostalRouteName postalRouteName) {
		postalRoute.getPostalRouteName().add(((PostalRouteNameImpl)postalRouteName).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : postalRoute.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	@Override
	public PostBox getPostBox() {
		if (postalRoute.isSetPostBox()) 
			return new PostBoxImpl(postalRoute.getPostBox());

		return null;
	}

	@Override
	public List<PostalRouteName> getPostalRouteName() {
		List<PostalRouteName> postalRouteNameList = new ArrayList<PostalRouteName>();

		for (PostalRouteType.PostalRouteName postalRouteNameElem : postalRoute.getPostalRouteName())
			postalRouteNameList.add(new PostalRouteNameImpl(postalRouteNameElem));

		return postalRouteNameList;
	}

	@Override
	public PostalRouteNumber getPostalRouteNumber() {
		if (postalRoute.isSetPostalRouteNumber())
			return new PostalRouteNumberImpl(postalRoute.getPostalRouteNumber());

		return null;
	}

	@Override
	public String getType() {
		return postalRoute.getType();
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		postalRoute.unsetAddressLine();
		postalRoute.getAddressLine().addAll(addressLineElemList);
	}

	@Override
	public void setPostBox(PostBox postBox) {
		postalRoute.setPostBox(((PostBoxImpl)postBox).getJAXBObject());
	}

	@Override
	public void setPostalRouteName(List<PostalRouteName> postalRouteName) {
		List<PostalRouteType.PostalRouteName> postalRouteNameElemList = new ArrayList<PostalRouteType.PostalRouteName>();

		for (PostalRouteName postalRouteNameItem : postalRouteName)
			postalRouteNameElemList.add(((PostalRouteNameImpl)postalRouteNameItem).getJAXBObject());

		postalRoute.unsetPostalRouteName();
		postalRoute.getPostalRouteName().addAll(postalRouteNameElemList);
	}

	@Override
	public void setPostalRouteNumber(PostalRouteNumber postalRouteNumber) {
		postalRoute.setPostalRouteNumber(((PostalRouteNumberImpl)postalRouteNumber).getJAXBObject());
	}

	@Override
	public void setType(String type) {
		postalRoute.setType(type);
	}

	@Override
	public boolean isSetAddressLine() {
		return postalRoute.isSetAddressLine();
	}

	@Override
	public boolean isSetPostalRouteName() {
		return postalRoute.isSetPostalRouteName();
	}

	@Override
	public boolean isSetPostalRouteNumber() {
		return postalRoute.isSetPostalRouteNumber();
	}

	@Override
	public boolean isSetPostBox() {
		return postalRoute.isSetPostBox();
	}

	@Override
	public boolean isSetType() {
		return postalRoute.isSetType();
	}

	@Override
	public void unsetAddressLine() {
		postalRoute.unsetAddressLine();
	}

	@Override
	public void unsetPostalRouteName() {
		postalRoute.unsetPostalRouteName();
	}

	@Override
	public void unsetPostalRouteNumber() {
		postalRoute.setPostalRouteNumber(null);
	}

	@Override
	public void unsetPostBox() {
		postalRoute.setPostBox(null);
	}

	@Override
	public void unsetType() {
		postalRoute.setType(null);
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (postalRoute.isSetAddressLine())
			return postalRoute.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetPostalRouteName(PostalRouteName postalRouteName) {
		if (postalRoute.isSetPostalRouteName())
			return postalRoute.getPostalRouteName().remove(((PostalRouteNameImpl)postalRouteName).getJAXBObject());
		
		return false;
	}

}
