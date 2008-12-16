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

	@Override
	public void addAddressLine(AddressLine addressLine) {
		postalCode.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public void addPostalCodeNumber(PostalCodeNumber postalCodeNumber) {
		postalCode.getPostalCodeNumber().add(((PostalCodeNumberImpl)postalCodeNumber).getJAXBObject());
	}

	@Override
	public void addPostalCodeNumberExtension(PostalCodeNumberExtension postalCodeNumberExtension) {
		postalCode.getPostalCodeNumberExtension().add(((PostalCodeNumberExtensionImpl)postalCodeNumberExtension).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();
		List<AddressLineElement> addressLineElemList = postalCode.getAddressLine();

		for (AddressLineElement addressLineElem : addressLineElemList)
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;	
	}

	@Override
	public PostTown getPostTown() {
		if (postalCode.isSetPostTown())
			return new PostTownImpl(postalCode.getPostTown());

		return null;
	}

	@Override
	public List<PostalCodeNumber> getPostalCodeNumber() {
		List<PostalCodeNumber> postalCodeNumberList = new ArrayList<PostalCodeNumber>();
		List<PostalCodeElement.PostalCodeNumber> postalCodeNumberElemList = postalCode.getPostalCodeNumber();

		for (PostalCodeElement.PostalCodeNumber postalCodeNumberElem : postalCodeNumberElemList)
			postalCodeNumberList.add(new PostalCodeNumberImpl(postalCodeNumberElem));

		return postalCodeNumberList;
	}

	@Override
	public List<PostalCodeNumberExtension> getPostalCodeNumberExtension() {
		List<PostalCodeNumberExtension> postalCodeNumberExList = new ArrayList<PostalCodeNumberExtension>();
		List<PostalCodeElement.PostalCodeNumberExtension> postalCodeNumberExElemList = postalCode.getPostalCodeNumberExtension();

		for (PostalCodeElement.PostalCodeNumberExtension postalCodeNumberExElem : postalCodeNumberExElemList)
			postalCodeNumberExList.add(new PostalCodeNumberExtensionImpl(postalCodeNumberExElem));

		return postalCodeNumberExList;
	}

	@Override
	public String getType() {
		return postalCode.getType();
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		postalCode.unsetAddressLine();
		postalCode.getAddressLine().addAll(addressLineElemList);
	}

	@Override
	public void setPostTown(PostTown postTown) {
		postalCode.setPostTown(((PostTownImpl)postTown).getJAXBObject());
	}

	@Override
	public void setPostalCodeNumber(List<PostalCodeNumber> postalCodeNumber) {
		List<PostalCodeElement.PostalCodeNumber> postalCodeNumberElemList = new ArrayList<PostalCodeElement.PostalCodeNumber>();

		for (PostalCodeNumber postalCodeNumberItem : postalCodeNumber)
			postalCodeNumberElemList.add(((PostalCodeNumberImpl)postalCodeNumberItem).getJAXBObject());

		postalCode.unsetPostalCodeNumber();
		postalCode.getPostalCodeNumber().addAll(postalCodeNumberElemList);
	}

	@Override
	public void setPostalCodeNumberExtension(List<PostalCodeNumberExtension> postalCodeNumberExtension) {
		List<PostalCodeElement.PostalCodeNumberExtension> postalCodeNumberExElemList = new ArrayList<PostalCodeElement.PostalCodeNumberExtension>();

		for (PostalCodeNumberExtension postalCideNumberExItem : postalCodeNumberExtension)
			postalCodeNumberExElemList.add(((PostalCodeNumberExtensionImpl)postalCideNumberExItem).getJAXBObject());

		postalCode.unsetPostalCodeNumberExtension();
		postalCode.getPostalCodeNumberExtension().addAll(postalCodeNumberExElemList);
	}

	@Override
	public void setType(String type) {
		postalCode.setType(type);
	}

	@Override
	public boolean isSetAddressLine() {
		return postalCode.isSetAddressLine();
	}

	@Override
	public boolean isSetPostalCodeNumber() {
		return postalCode.isSetPostalCodeNumber();
	}

	@Override
	public boolean isSetPostalCodeNumberExtension() {
		return postalCode.isSetPostalCodeNumberExtension();
	}

	@Override
	public boolean isSetPostTown() {
		return postalCode.isSetPostTown();
	}

	@Override
	public boolean isSetType() {
		return postalCode.isSetType();
	}

	@Override
	public void unsetAddressLine() {
		postalCode.unsetAddressLine();
	}

	@Override
	public void unsetPostalCodeNumber() {
		postalCode.unsetPostalCodeNumber();
	}

	@Override
	public void unsetPostalCodeNumberExtension() {
		postalCode.unsetPostalCodeNumberExtension();
	}

	@Override
	public void unsetPostTown() {
		postalCode.setPostTown(null);
	}

	@Override
	public void unsetType() {
		postalCode.setType(null);
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (postalCode.isSetAddressLine())
			return postalCode.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetPostalCodeNumber(PostalCodeNumber postalCodeNumber) {
		if (postalCode.isSetPostalCodeNumber())
			return postalCode.getPostalCodeNumber().remove(((PostalCodeNumberImpl)postalCodeNumber).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetPostalCodeNumberExtension(PostalCodeNumberExtension postalCodeNumberExtension) {
		if (postalCode.isSetPostalCodeNumberExtension())
			return postalCode.getPostalCodeNumberExtension().remove(((PostalCodeNumberExtensionImpl)postalCodeNumberExtension).getJAXBObject());
		
		return false;
	}

}
