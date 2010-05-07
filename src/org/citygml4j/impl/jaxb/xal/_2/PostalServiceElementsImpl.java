package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressDetails;
import org.citygml4j.model.xal.AddressIdentifier;
import org.citygml4j.model.xal.AddressLatitude;
import org.citygml4j.model.xal.AddressLatitudeDirection;
import org.citygml4j.model.xal.AddressLongitude;
import org.citygml4j.model.xal.AddressLongitudeDirection;
import org.citygml4j.model.xal.Barcode;
import org.citygml4j.model.xal.EndorsementLineCode;
import org.citygml4j.model.xal.KeyLineCode;
import org.citygml4j.model.xal.PostalServiceElements;
import org.citygml4j.model.xal.SortingCode;
import org.citygml4j.model.xal.SupplementaryPostalServiceData;
import org.citygml4j.model.xal.XALClass;

public class PostalServiceElementsImpl extends XALBaseImpl implements PostalServiceElements {
	private AddressDetails.PostalServiceElements postalServiceElements;

	public PostalServiceElementsImpl() {
		postalServiceElements = new AddressDetails.PostalServiceElements();
	}

	public PostalServiceElementsImpl(AddressDetails.PostalServiceElements postalServiceElements) {
		this.postalServiceElements = postalServiceElements;
	}

	@Override
	public AddressDetails.PostalServiceElements getJAXBObject() {
		return postalServiceElements;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.POSTALSERVICEELEMENTS;
	}

	public void addAddressIdentifier(AddressIdentifier addressIdentifier) {
		postalServiceElements.getAddressIdentifier().add(((AddressIdentifierImpl)addressIdentifier).getJAXBObject());
	}

	public List<AddressIdentifier> getAddressIdentifier() {
		List<AddressIdentifier> addressIdentifierList = new ArrayList<AddressIdentifier>();

		for (AddressDetails.PostalServiceElements.AddressIdentifier addressIdentifierInst : postalServiceElements.getAddressIdentifier())
			addressIdentifierList.add(new AddressIdentifierImpl(addressIdentifierInst));

		return addressIdentifierList;
	}

	public AddressLatitude getAddressLatitude() {
		if (postalServiceElements.isSetAddressLatitude())
			return new AddressLatitudeImpl(postalServiceElements.getAddressLatitude());

		return null;
	}

	public AddressLatitudeDirection getAddressLatitudeDirection() {
		if (postalServiceElements.isSetAddressLatitudeDirection())
			return new AddressLatitudeDirectionImpl(postalServiceElements.getAddressLatitudeDirection());

		return null;
	}

	public AddressLongitude getAddressLongitude() {
		if (postalServiceElements.isSetAddressLongitude())
			return new AddressLongitudeImpl(postalServiceElements.getAddressLongitude());

		return null;
	}

	public AddressLongitudeDirection getAddressLongitudeDirection() {
		if (postalServiceElements.isSetAddressLongitudeDirection())
			return new AddressLongitudeDirectionImpl(postalServiceElements.getAddressLongitudeDirection());

		return null;
	}

	public Barcode getBarcode() {
		if (postalServiceElements.isSetBarcode())
			return new BarcodeImpl(postalServiceElements.getBarcode());

		return null;
	}

	public EndorsementLineCode getEndorsementLineCode() {
		if (postalServiceElements.isSetEndorsementLineCode())
			return new EndorsementLineCodeImpl(postalServiceElements.getEndorsementLineCode());

		return null;
	}

	public KeyLineCode getKeyLineCode() {
		if (postalServiceElements.isSetKeyLineCode())
			return new KeyLineCodeImpl(postalServiceElements.getKeyLineCode());

		return null;
	}

	public SortingCode getSortingCode() {
		if (postalServiceElements.isSetSortingCode())
			return new SortingCodeImpl(postalServiceElements.getSortingCode());

		return null;
	}

	public String getType() {
		return postalServiceElements.getType();
	}

	public void setAddressIdentifier(List<AddressIdentifier> addressIdentifier) {
		List<AddressDetails.PostalServiceElements.AddressIdentifier> addressIdentifierInstList = new ArrayList<AddressDetails.PostalServiceElements.AddressIdentifier>();

		for (AddressIdentifier addressIdentifierItem : addressIdentifier)
			addressIdentifierInstList.add(((AddressIdentifierImpl)addressIdentifierItem).getJAXBObject());

		postalServiceElements.unsetAddressIdentifier();
		postalServiceElements.getAddressIdentifier().addAll(addressIdentifierInstList);
	}

	public void setAddressLatitude(AddressLatitude addressLatitude) {
		postalServiceElements.setAddressLatitude(((AddressLatitudeImpl)addressLatitude).getJAXBObject());
	}

	public void setAddressLatitudeDirection(AddressLatitudeDirection addressLatitudeDirection) {
		postalServiceElements.setAddressLatitudeDirection(((AddressLatitudeDirectionImpl)addressLatitudeDirection).getJAXBObject());
	}

	public void setAddressLongitude(AddressLongitude addressLongitude) {
		postalServiceElements.setAddressLongitude(((AddressLongitudeImpl)addressLongitude).getJAXBObject());
	}

	public void setAddressLongitudeDirection(AddressLongitudeDirection addressLongitudeDirection) {
		postalServiceElements.setAddressLongitudeDirection(((AddressLongitudeDirectionImpl)addressLongitudeDirection).getJAXBObject());
	}

	public void setBarcode(Barcode barcode) {
		postalServiceElements.setBarcode(((BarcodeImpl)barcode).getJAXBObject());
	}

	public void setEndorsementLineCode(EndorsementLineCode endorsementLineCode) {
		postalServiceElements.setEndorsementLineCode(((EndorsementLineCodeImpl)endorsementLineCode).getJAXBObject());
	}

	public void setKeyLineCode(KeyLineCode keyLineCode) {
		postalServiceElements.setKeyLineCode(((KeyLineCodeImpl)keyLineCode).getJAXBObject());
	}

	public void setSortingCode(SortingCode sortingCode) {
		postalServiceElements.setSortingCode(((SortingCodeImpl)sortingCode).getJAXBObject());
	}

	public void setType(String type) {
		postalServiceElements.setType(type);
	}

	public void addSupplementaryPostalServiceData(SupplementaryPostalServiceData supplementaryPostalServiceData) {
		postalServiceElements.getSupplementaryPostalServiceData().add(((SupplementaryPostalServiceDataImpl)supplementaryPostalServiceData).getJAXBObject());
	}

	public List<SupplementaryPostalServiceData> getSupplementaryPostalServiceData() {
		List<SupplementaryPostalServiceData> suppList = new ArrayList<SupplementaryPostalServiceData>();

		for (AddressDetails.PostalServiceElements.SupplementaryPostalServiceData suppInst : postalServiceElements.getSupplementaryPostalServiceData())
			suppList.add(new SupplementaryPostalServiceDataImpl(suppInst));

		return suppList;
	}

	public void setSupplementaryPostalServiceData(List<SupplementaryPostalServiceData> supplementaryPostalServiceData) {
		List<AddressDetails.PostalServiceElements.SupplementaryPostalServiceData> suppInstList = new ArrayList<AddressDetails.PostalServiceElements.SupplementaryPostalServiceData>();

		for (SupplementaryPostalServiceData suppItem : supplementaryPostalServiceData)
			suppInstList.add(((SupplementaryPostalServiceDataImpl)suppItem).getJAXBObject());

		postalServiceElements.unsetSupplementaryPostalServiceData();
		postalServiceElements.getSupplementaryPostalServiceData().addAll(suppInstList);
	}

	public boolean isSetAddressIdentifier() {
		return postalServiceElements.isSetAddressIdentifier();
	}

	public boolean isSetAddressLatitude() {
		return postalServiceElements.isSetAddressLatitude();
	}

	public boolean isSetAddressLatitudeDirection() {
		return postalServiceElements.isSetAddressLatitudeDirection();
	}

	public boolean isSetAddressLongitude() {
		return postalServiceElements.isSetAddressLongitude();
	}

	public boolean isSetAddressLongitudeDirection() {
		return postalServiceElements.isSetAddressLongitudeDirection();
	}

	public boolean isSetBarcode() {
		return postalServiceElements.isSetBarcode();
	}

	public boolean isSetEndorsementLineCode() {
		return postalServiceElements.isSetEndorsementLineCode();
	}

	public boolean isSetKeyLineCode() {
		return postalServiceElements.isSetKeyLineCode();
	}

	public boolean isSetSortingCode() {
		return postalServiceElements.isSetSortingCode();
	}

	public boolean isSetSupplementaryPostalServiceData() {
		return postalServiceElements.isSetSupplementaryPostalServiceData();
	}

	public boolean isSetType() {
		return postalServiceElements.isSetType();
	}

	public void unsetAddressIdentifier() {
		postalServiceElements.unsetAddressIdentifier();
	}

	public void unsetAddressLatitude() {
		postalServiceElements.setAddressLatitude(null);
	}

	public void unsetAddressLatitudeDirection() {
		postalServiceElements.setAddressLatitudeDirection(null);
	}

	public void unsetAddressLongitude() {
		postalServiceElements.setAddressLongitude(null);
	}

	public void unsetAddressLongitudeDirection() {
		postalServiceElements.setAddressLongitudeDirection(null);
	}

	public void unsetBarcode() {
		postalServiceElements.setBarcode(null);
	}

	public void unsetEndorsementLineCode() {
		postalServiceElements.setEndorsementLineCode(null);
	}

	public void unsetKeyLineCode() {
		postalServiceElements.setKeyLineCode(null);
	}

	public void unsetSortingCode() {
		postalServiceElements.setSortingCode(null);
	}

	public void unsetSupplementaryPostalServiceData() {
		postalServiceElements.unsetSupplementaryPostalServiceData();
	}

	public void unsetType() {
		postalServiceElements.setType(null);
	}

	public boolean unsetAddressIdentifier(AddressIdentifier addressIdentifier) {
		if (postalServiceElements.isSetAddressIdentifier())
			return postalServiceElements.getAddressIdentifier().remove(((AddressIdentifierImpl)addressIdentifier).getJAXBObject());
		
		return false;
	}

	public boolean unsetSupplementaryPostalServiceData(SupplementaryPostalServiceData supplementaryPostalServiceData) {
		if (postalServiceElements.isSetSupplementaryPostalServiceData())
			return postalServiceElements.getSupplementaryPostalServiceData().remove(((SupplementaryPostalServiceDataImpl)supplementaryPostalServiceData).getJAXBObject());
		
		return false;
	}

}
