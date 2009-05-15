package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.model.xal.Address;
import org.citygml4j.model.xal.AddressDetails;
import org.citygml4j.model.xal.AddressLines;
import org.citygml4j.model.xal.AdministrativeArea;
import org.citygml4j.model.xal.Country;
import org.citygml4j.model.xal.Locality;
import org.citygml4j.model.xal.PostalServiceElements;
import org.citygml4j.model.xal.Thoroughfare;
import org.citygml4j.model.xal.XALClass;

public class AddressDetailsImpl extends XALBaseImpl implements AddressDetails {
	private org.citygml4j.jaxb.xal.AddressDetails addressDetails;
	
	public AddressDetailsImpl() {
		addressDetails = new org.citygml4j.jaxb.xal.AddressDetails();
	}
	
	public AddressDetailsImpl(org.citygml4j.jaxb.xal.AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}
	
	@Override
	public org.citygml4j.jaxb.xal.AddressDetails getJAXBObject() {
		return addressDetails;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.ADDRESSDETAILS;
	}

	public Country getCountry() {
		if (addressDetails.isSetCountry())
			return new CountryImpl(addressDetails.getCountry());
		
		return null;
	}

	public void setCountry(Country country) {
		addressDetails.setCountry(((CountryImpl)country).getJAXBObject());
	}

	public String getCode() {
		return addressDetails.getCode();
	}

	public void setCode(String code) {
		addressDetails.setCode(code);
	}

	public Address getAddress() {
		if (addressDetails.isSetAddress())
			return new AddressImpl(addressDetails.getAddress());

		return null;
	}

	public String getAddressDetailsKey() {
		return addressDetails.getAddressDetailsKey();
	}

	public AddressLines getAddressLines() {
		if (addressDetails.isSetAddressLines())
			return new AddressLinesImpl(addressDetails.getAddressLines());

		return null;
	}

	public String getAddressType() {
		return addressDetails.getAddressType();
	}

	public AdministrativeArea getAdministrativeArea() {
		if (addressDetails.isSetAdministrativeArea())
			return new AdministrativeAreaImpl(addressDetails.getAdministrativeArea());

		return null;
	}

	public String getCurrentStatus() {
		return addressDetails.getCurrentStatus();
	}

	public Locality getLocality() {
		if (addressDetails.isSetLocality())
			return new LocalityImpl(addressDetails.getLocality());

		return null;
	}

	public PostalServiceElements getPostalServiceElements() {
		if (addressDetails.isSetPostalServiceElements())
			return new PostalServiceElementsImpl(addressDetails.getPostalServiceElements());

		return null;
	}

	public Thoroughfare getThoroughfare() {
		if (addressDetails.isSetThoroughfare())
			return new ThoroughfareImpl(addressDetails.getThoroughfare());

		return null;
	}

	public String getUsage() {
		return addressDetails.getUsage();
	}

	public String getValidFromDate() {
		return addressDetails.getValidFromDate();
	}

	public String getValidToDate() {
		return addressDetails.getValidToDate();
	}

	public void setAddress(Address address) {
		addressDetails.setAddress(((AddressImpl)address).getJAXBObject());
	}

	public void setAddressDetailsKey(String addressDetailsKey) {
		addressDetails.setAddressDetailsKey(addressDetailsKey);		
	}

	public void setAddressLines(AddressLines addressLines) {
		addressDetails.setAddressLines(((AddressLinesImpl)addressLines).getJAXBObject());
	}

	public void setAddressType(String addressType) {
		addressDetails.setAddressType(addressType);
	}

	public void setAdministrativeArea(AdministrativeArea administrativeArea) {
		addressDetails.setAdministrativeArea(((AdministrativeAreaImpl)administrativeArea).getJAXBObject());
	}

	public void setCurrentStatus(String currentStatus) {
		addressDetails.setCurrentStatus(currentStatus);		
	}

	public void setLocality(Locality locality) {
		addressDetails.setLocality(((LocalityImpl)locality).getJAXBObject());
	}

	public void setPostalServiceElements(PostalServiceElements postalServiceElements) {
		addressDetails.setPostalServiceElements(((PostalServiceElementsImpl)postalServiceElements).getJAXBObject());
	}

	public void setThoroughfare(Thoroughfare thoroughfare) {
		addressDetails.setThoroughfare(((ThoroughfareImpl)thoroughfare).getJAXBObject());		
	}

	public void setUsage(String usage) {
		addressDetails.setUsage(usage);		
	}

	public void setValidFromDate(String validFromDate) {
		addressDetails.setValidFromDate(validFromDate);		
	}

	public void setValidToDate(String validToDate) {
		addressDetails.setValidToDate(validToDate);		
	}

	public boolean isSetAddress() {
		return addressDetails.isSetAddress();
	}

	public boolean isSetAddressDetailsKey() {
		return addressDetails.isSetAddressDetailsKey();
	}

	public boolean isSetAddressLines() {
		return addressDetails.isSetAddressLines();
	}

	public boolean isSetAddressType() {
		return addressDetails.isSetAddressType();
	}

	public boolean isSetAdministrativeArea() {
		return addressDetails.isSetAdministrativeArea();
	}

	public boolean isSetCountry() {
		return addressDetails.isSetCountry();
	}

	public boolean isSetCurrentStatus() {
		return addressDetails.isSetCurrentStatus();
	}

	public boolean isSetLocality() {
		return addressDetails.isSetLocality();
	}

	public boolean isSetPostalServiceElements() {
		return addressDetails.isSetPostalServiceElements();
	}

	public boolean isSetThoroughfare() {
		return addressDetails.isSetThoroughfare();
	}

	public boolean isSetUsage() {
		return addressDetails.isSetUsage();
	}

	public boolean isSetValidFromDate() {
		return addressDetails.isSetValidFromDate();
	}

	public boolean isSetValidToDate() {
		return addressDetails.isSetValidToDate();
	}

	public void unsetAddress() {
		addressDetails.setAddress(null);
	}

	public void unsetAddressDetailsKey() {
		addressDetails.setAddressDetailsKey(null);
	}

	public void unsetAddressLines() {
		addressDetails.setAddressLines(null);
	}

	public void unsetAddressType() {
		addressDetails.setAddressType(null);
	}

	public void unsetAdministrativeArea() {
		addressDetails.setAdministrativeArea(null);
	}

	public void unsetCountry() {
		addressDetails.setCountry(null);
	}

	public void unsetCurrentStatus() {
		addressDetails.setCurrentStatus(null);
	}

	public void unsetLocality() {
		addressDetails.setLocality(null);
	}

	public void unsetPostalServiceElements() {
		addressDetails.setPostalServiceElements(null);
	}

	public void unsetThoroughfare() {
		addressDetails.setThoroughfare(null);
	}

	public void unsetUsage() {
		addressDetails.setUsage(null);
	}

	public void unsetValidFromDate() {
		addressDetails.setValidFromDate(null);
	}

	public void unsetValidToDate() {
		addressDetails.setValidToDate(null);
	}

	public boolean isSetCode() {
		return addressDetails.isSetCode();
	}

	public void unsetCode() {
		addressDetails.setCode(null);
	}

}
