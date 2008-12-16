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

	@Override
	public void addAddressIdentifier(AddressIdentifier addressIdentifier) {
		postalServiceElements.getAddressIdentifier().add(((AddressIdentifierImpl)addressIdentifier).getJAXBObject());
	}

	@Override
	public List<AddressIdentifier> getAddressIdentifier() {
		List<AddressIdentifier> addressIdentifierList = new ArrayList<AddressIdentifier>();
		List<AddressDetails.PostalServiceElements.AddressIdentifier> addressIdentifierInstList = postalServiceElements.getAddressIdentifier();

		for (AddressDetails.PostalServiceElements.AddressIdentifier addressIdentifierInst : addressIdentifierInstList)
			addressIdentifierList.add(new AddressIdentifierImpl(addressIdentifierInst));

		return addressIdentifierList;
	}

	@Override
	public AddressLatitude getAddressLatitude() {
		if (postalServiceElements.isSetAddressLatitude())
			return new AddressLatitudeImpl(postalServiceElements.getAddressLatitude());

		return null;
	}

	@Override
	public AddressLatitudeDirection getAddressLatitudeDirection() {
		if (postalServiceElements.isSetAddressLatitudeDirection())
			return new AddressLatitudeDirectionImpl(postalServiceElements.getAddressLatitudeDirection());

		return null;
	}

	@Override
	public AddressLongitude getAddressLongitude() {
		if (postalServiceElements.isSetAddressLongitude())
			return new AddressLongitudeImpl(postalServiceElements.getAddressLongitude());

		return null;
	}

	@Override
	public AddressLongitudeDirection getAddressLongitudeDirection() {
		if (postalServiceElements.isSetAddressLongitudeDirection())
			return new AddressLongitudeDirectionImpl(postalServiceElements.getAddressLongitudeDirection());

		return null;
	}

	@Override
	public Barcode getBarcode() {
		if (postalServiceElements.isSetBarcode())
			return new BarcodeImpl(postalServiceElements.getBarcode());

		return null;
	}

	@Override
	public EndorsementLineCode getEndorsementLineCode() {
		if (postalServiceElements.isSetEndorsementLineCode())
			return new EndorsementLineCodeImpl(postalServiceElements.getEndorsementLineCode());

		return null;
	}

	@Override
	public KeyLineCode getKeyLineCode() {
		if (postalServiceElements.isSetKeyLineCode())
			return new KeyLineCodeImpl(postalServiceElements.getKeyLineCode());

		return null;
	}

	@Override
	public SortingCode getSortingCode() {
		if (postalServiceElements.isSetSortingCode())
			return new SortingCodeImpl(postalServiceElements.getSortingCode());

		return null;
	}

	@Override
	public String getType() {
		return postalServiceElements.getType();
	}

	@Override
	public void setAddressIdentifier(List<AddressIdentifier> addressIdentifier) {
		List<AddressDetails.PostalServiceElements.AddressIdentifier> addressIdentifierInstList = new ArrayList<AddressDetails.PostalServiceElements.AddressIdentifier>();

		for (AddressIdentifier addressIdentifierItem : addressIdentifier)
			addressIdentifierInstList.add(((AddressIdentifierImpl)addressIdentifierItem).getJAXBObject());

		postalServiceElements.unsetAddressIdentifier();
		postalServiceElements.getAddressIdentifier().addAll(addressIdentifierInstList);
	}

	@Override
	public void setAddressLatitude(AddressLatitude addressLatitude) {
		postalServiceElements.setAddressLatitude(((AddressLatitudeImpl)addressLatitude).getJAXBObject());
	}

	@Override
	public void setAddressLatitudeDirection(AddressLatitudeDirection addressLatitudeDirection) {
		postalServiceElements.setAddressLatitudeDirection(((AddressLatitudeDirectionImpl)addressLatitudeDirection).getJAXBObject());
	}

	@Override
	public void setAddressLongitude(AddressLongitude addressLongitude) {
		postalServiceElements.setAddressLongitude(((AddressLongitudeImpl)addressLongitude).getJAXBObject());
	}

	@Override
	public void setAddressLongitudeDirection(AddressLongitudeDirection addressLongitudeDirection) {
		postalServiceElements.setAddressLongitudeDirection(((AddressLongitudeDirectionImpl)addressLongitudeDirection).getJAXBObject());
	}

	@Override
	public void setBarcode(Barcode barcode) {
		postalServiceElements.setBarcode(((BarcodeImpl)barcode).getJAXBObject());
	}

	@Override
	public void setEndorsementLineCode(EndorsementLineCode endorsementLineCode) {
		postalServiceElements.setEndorsementLineCode(((EndorsementLineCodeImpl)endorsementLineCode).getJAXBObject());
	}

	@Override
	public void setKeyLineCode(KeyLineCode keyLineCode) {
		postalServiceElements.setKeyLineCode(((KeyLineCodeImpl)keyLineCode).getJAXBObject());
	}

	@Override
	public void setSortingCode(SortingCode sortingCode) {
		postalServiceElements.setSortingCode(((SortingCodeImpl)sortingCode).getJAXBObject());
	}

	@Override
	public void setType(String type) {
		postalServiceElements.setType(type);
	}

	@Override
	public void addSupplementaryPostalServiceData(SupplementaryPostalServiceData supplementaryPostalServiceData) {
		postalServiceElements.getSupplementaryPostalServiceData().add(((SupplementaryPostalServiceDataImpl)supplementaryPostalServiceData).getJAXBObject());
	}

	@Override
	public List<SupplementaryPostalServiceData> getSupplementaryPostalServiceData() {
		List<SupplementaryPostalServiceData> suppList = new ArrayList<SupplementaryPostalServiceData>();
		List<AddressDetails.PostalServiceElements.SupplementaryPostalServiceData> suppInstList = postalServiceElements.getSupplementaryPostalServiceData();			

		for (AddressDetails.PostalServiceElements.SupplementaryPostalServiceData suppInst : suppInstList)
			suppList.add(new SupplementaryPostalServiceDataImpl(suppInst));

		return suppList;
	}

	@Override
	public void setSupplementaryPostalServiceData(List<SupplementaryPostalServiceData> supplementaryPostalServiceData) {
		List<AddressDetails.PostalServiceElements.SupplementaryPostalServiceData> suppInstList = new ArrayList<AddressDetails.PostalServiceElements.SupplementaryPostalServiceData>();

		for (SupplementaryPostalServiceData suppItem : supplementaryPostalServiceData)
			suppInstList.add(((SupplementaryPostalServiceDataImpl)suppItem).getJAXBObject());

		postalServiceElements.unsetSupplementaryPostalServiceData();
		postalServiceElements.getSupplementaryPostalServiceData().addAll(suppInstList);
	}

	@Override
	public boolean isSetAddressIdentifier() {
		return postalServiceElements.isSetAddressIdentifier();
	}

	@Override
	public boolean isSetAddressLatitude() {
		return postalServiceElements.isSetAddressLatitude();
	}

	@Override
	public boolean isSetAddressLatitudeDirection() {
		return postalServiceElements.isSetAddressLatitudeDirection();
	}

	@Override
	public boolean isSetAddressLongitude() {
		return postalServiceElements.isSetAddressLongitude();
	}

	@Override
	public boolean isSetAddressLongitudeDirection() {
		return postalServiceElements.isSetAddressLongitudeDirection();
	}

	@Override
	public boolean isSetBarcode() {
		return postalServiceElements.isSetBarcode();
	}

	@Override
	public boolean isSetEndorsementLineCode() {
		return postalServiceElements.isSetEndorsementLineCode();
	}

	@Override
	public boolean isSetKeyLineCode() {
		return postalServiceElements.isSetKeyLineCode();
	}

	@Override
	public boolean isSetSortingCode() {
		return postalServiceElements.isSetSortingCode();
	}

	@Override
	public boolean isSetSupplementaryPostalServiceData() {
		return postalServiceElements.isSetSupplementaryPostalServiceData();
	}

	@Override
	public boolean isSetType() {
		return postalServiceElements.isSetType();
	}

	@Override
	public void unsetAddressIdentifier() {
		postalServiceElements.unsetAddressIdentifier();
	}

	@Override
	public void unsetAddressLatitude() {
		postalServiceElements.setAddressLatitude(null);
	}

	@Override
	public void unsetAddressLatitudeDirection() {
		postalServiceElements.setAddressLatitudeDirection(null);
	}

	@Override
	public void unsetAddressLongitude() {
		postalServiceElements.setAddressLongitude(null);
	}

	@Override
	public void unsetAddressLongitudeDirection() {
		postalServiceElements.setAddressLongitudeDirection(null);
	}

	@Override
	public void unsetBarcode() {
		postalServiceElements.setBarcode(null);
	}

	@Override
	public void unsetEndorsementLineCode() {
		postalServiceElements.setEndorsementLineCode(null);
	}

	@Override
	public void unsetKeyLineCode() {
		postalServiceElements.setKeyLineCode(null);
	}

	@Override
	public void unsetSortingCode() {
		postalServiceElements.setSortingCode(null);
	}

	@Override
	public void unsetSupplementaryPostalServiceData() {
		postalServiceElements.unsetSupplementaryPostalServiceData();
	}

	@Override
	public void unsetType() {
		postalServiceElements.setType(null);
	}

	@Override
	public boolean unsetAddressIdentifier(AddressIdentifier addressIdentifier) {
		if (postalServiceElements.isSetAddressIdentifier())
			return postalServiceElements.getAddressIdentifier().remove(((AddressIdentifierImpl)addressIdentifier).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetSupplementaryPostalServiceData(SupplementaryPostalServiceData supplementaryPostalServiceData) {
		if (postalServiceElements.isSetSupplementaryPostalServiceData())
			return postalServiceElements.getSupplementaryPostalServiceData().remove(((SupplementaryPostalServiceDataImpl)supplementaryPostalServiceData).getJAXBObject());
		
		return false;
	}

}
