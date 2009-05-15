package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.PostalCodeElement;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.PostTown;
import org.citygml4j.model.xal.PostalCode;
import org.citygml4j.model.xal.PostalCodeNumber;
import org.citygml4j.model.xal.PostalCodeNumberExtension;
import org.citygml4j.model.xal.XALClass;

public class PostalCodeImpl extends XALBaseImpl implements PostalCode {
	private PostalCodeElement postalCode;

	public PostalCodeImpl() {
		postalCode = new PostalCodeElement();
	}

	public PostalCodeImpl(PostalCodeElement postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public PostalCodeElement getJAXBObject() {
		return postalCode;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.POSTALCODE;
	}

	public void addAddressLine(AddressLine addressLine) {
		postalCode.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	public void addPostalCodeNumber(PostalCodeNumber postalCodeNumber) {
		postalCode.getPostalCodeNumber().add(((PostalCodeNumberImpl)postalCodeNumber).getJAXBObject());
	}

	public void addPostalCodeNumberExtension(PostalCodeNumberExtension postalCodeNumberExtension) {
		postalCode.getPostalCodeNumberExtension().add(((PostalCodeNumberExtensionImpl)postalCodeNumberExtension).getJAXBObject());
	}

	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : postalCode.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;	
	}

	public PostTown getPostTown() {
		if (postalCode.isSetPostTown())
			return new PostTownImpl(postalCode.getPostTown());

		return null;
	}

	public List<PostalCodeNumber> getPostalCodeNumber() {
		List<PostalCodeNumber> postalCodeNumberList = new ArrayList<PostalCodeNumber>();

		for (PostalCodeElement.PostalCodeNumber postalCodeNumberElem : postalCode.getPostalCodeNumber())
			postalCodeNumberList.add(new PostalCodeNumberImpl(postalCodeNumberElem));

		return postalCodeNumberList;
	}

	public List<PostalCodeNumberExtension> getPostalCodeNumberExtension() {
		List<PostalCodeNumberExtension> postalCodeNumberExList = new ArrayList<PostalCodeNumberExtension>();

		for (PostalCodeElement.PostalCodeNumberExtension postalCodeNumberExElem : postalCode.getPostalCodeNumberExtension())
			postalCodeNumberExList.add(new PostalCodeNumberExtensionImpl(postalCodeNumberExElem));

		return postalCodeNumberExList;
	}

	public String getType() {
		return postalCode.getType();
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		postalCode.unsetAddressLine();
		postalCode.getAddressLine().addAll(addressLineElemList);
	}

	public void setPostTown(PostTown postTown) {
		postalCode.setPostTown(((PostTownImpl)postTown).getJAXBObject());
	}

	public void setPostalCodeNumber(List<PostalCodeNumber> postalCodeNumber) {
		List<PostalCodeElement.PostalCodeNumber> postalCodeNumberElemList = new ArrayList<PostalCodeElement.PostalCodeNumber>();

		for (PostalCodeNumber postalCodeNumberItem : postalCodeNumber)
			postalCodeNumberElemList.add(((PostalCodeNumberImpl)postalCodeNumberItem).getJAXBObject());

		postalCode.unsetPostalCodeNumber();
		postalCode.getPostalCodeNumber().addAll(postalCodeNumberElemList);
	}

	public void setPostalCodeNumberExtension(List<PostalCodeNumberExtension> postalCodeNumberExtension) {
		List<PostalCodeElement.PostalCodeNumberExtension> postalCodeNumberExElemList = new ArrayList<PostalCodeElement.PostalCodeNumberExtension>();

		for (PostalCodeNumberExtension postalCideNumberExItem : postalCodeNumberExtension)
			postalCodeNumberExElemList.add(((PostalCodeNumberExtensionImpl)postalCideNumberExItem).getJAXBObject());

		postalCode.unsetPostalCodeNumberExtension();
		postalCode.getPostalCodeNumberExtension().addAll(postalCodeNumberExElemList);
	}

	public void setType(String type) {
		postalCode.setType(type);
	}

	public boolean isSetAddressLine() {
		return postalCode.isSetAddressLine();
	}

	public boolean isSetPostalCodeNumber() {
		return postalCode.isSetPostalCodeNumber();
	}

	public boolean isSetPostalCodeNumberExtension() {
		return postalCode.isSetPostalCodeNumberExtension();
	}

	public boolean isSetPostTown() {
		return postalCode.isSetPostTown();
	}

	public boolean isSetType() {
		return postalCode.isSetType();
	}

	public void unsetAddressLine() {
		postalCode.unsetAddressLine();
	}

	public void unsetPostalCodeNumber() {
		postalCode.unsetPostalCodeNumber();
	}

	public void unsetPostalCodeNumberExtension() {
		postalCode.unsetPostalCodeNumberExtension();
	}

	public void unsetPostTown() {
		postalCode.setPostTown(null);
	}

	public void unsetType() {
		postalCode.setType(null);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		if (postalCode.isSetAddressLine())
			return postalCode.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	public boolean unsetPostalCodeNumber(PostalCodeNumber postalCodeNumber) {
		if (postalCode.isSetPostalCodeNumber())
			return postalCode.getPostalCodeNumber().remove(((PostalCodeNumberImpl)postalCodeNumber).getJAXBObject());
		
		return false;
	}

	public boolean unsetPostalCodeNumberExtension(PostalCodeNumberExtension postalCodeNumberExtension) {
		if (postalCode.isSetPostalCodeNumberExtension())
			return postalCode.getPostalCodeNumberExtension().remove(((PostalCodeNumberExtensionImpl)postalCodeNumberExtension).getJAXBObject());
		
		return false;
	}

}
