package org.citygml4j.model.xal;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public interface PostalServiceElements extends XAL, Child, Copyable {
	public List<AddressIdentifier> getAddressIdentifier();
	public EndorsementLineCode getEndorsementLineCode();
	public KeyLineCode getKeyLineCode();
	public Barcode getBarcode();
	public SortingCode getSortingCode();
	public AddressLatitude getAddressLatitude();
	public AddressLatitudeDirection getAddressLatitudeDirection();
	public AddressLongitude getAddressLongitude();
	public AddressLongitudeDirection getAddressLongitudeDirection();
	public List<SupplementaryPostalServiceData> getSupplementaryPostalServiceData();
	public String getType();
	public boolean isSetAddressIdentifier();
	public boolean isSetEndorsementLineCode();
	public boolean isSetKeyLineCode();
	public boolean isSetBarcode();
	public boolean isSetSortingCode();
	public boolean isSetAddressLatitude();
	public boolean isSetAddressLatitudeDirection();
	public boolean isSetAddressLongitude();
	public boolean isSetAddressLongitudeDirection();
	public boolean isSetSupplementaryPostalServiceData();
	public boolean isSetType();
	
	public void addAddressIdentifier(AddressIdentifier addressIdentifier);
	public void setAddressIdentifier(List<AddressIdentifier> addressIdentifier);
	public void setEndorsementLineCode(EndorsementLineCode endorsementLineCode);
	public void setKeyLineCode(KeyLineCode keyLineCode);
	public void setBarcode(Barcode barcode);
	public void setSortingCode(SortingCode sortingCode);
	public void setAddressLatitude(AddressLatitude addressLatitude);
	public void setAddressLatitudeDirection(AddressLatitudeDirection addressLatitudeDirection);
	public void setAddressLongitude(AddressLongitude addressLongitude);
	public void setAddressLongitudeDirection(AddressLongitudeDirection addressLongitudeDirection);
	public void addSupplementaryPostalServiceData(SupplementaryPostalServiceData supplementaryPostalServiceData);
	public void setSupplementaryPostalServiceData(List<SupplementaryPostalServiceData> supplementaryPostalServiceData);
	public void setType(String type);
	public void unsetAddressIdentifier();
	public boolean unsetAddressIdentifier(AddressIdentifier addressIdentifier);
	public void unsetEndorsementLineCode();
	public void unsetKeyLineCode();
	public void unsetBarcode();
	public void unsetSortingCode();
	public void unsetAddressLatitude();
	public void unsetAddressLatitudeDirection();
	public void unsetAddressLongitude();
	public void unsetAddressLongitudeDirection();
	public void unsetSupplementaryPostalServiceData();
	public boolean unsetSupplementaryPostalServiceData(SupplementaryPostalServiceData supplementaryPostalServiceData);
	public void unsetType();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunction<T> visitor);
}
