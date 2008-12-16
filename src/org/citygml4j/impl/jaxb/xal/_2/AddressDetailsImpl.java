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

	@Override
	public Country getCountry() {
		if (addressDetails.isSetCountry())
			return new CountryImpl(addressDetails.getCountry());
		
		return null;
	}

	@Override
	public void setCountry(Country country) {
		addressDetails.setCountry(((CountryImpl)country).getJAXBObject());
	}

	@Override
	public String getCode() {
		return addressDetails.getCode();
	}

	@Override
	public void setCode(String code) {
		addressDetails.setCode(code);
	}

	@Override
	public Address getAddress() {
		if (addressDetails.isSetAddress())
			return new AddressImpl(addressDetails.getAddress());

		return null;
	}

	@Override
	public String getAddressDetailsKey() {
		return addressDetails.getAddressDetailsKey();
	}

	@Override
	public AddressLines getAddressLines() {
		if (addressDetails.isSetAddressLines())
			return new AddressLinesImpl(addressDetails.getAddressLines());

		return null;
	}

	@Override
	public String getAddressType() {
		return addressDetails.getAddressType();
	}

	@Override
	public AdministrativeArea getAdministrativeArea() {
		if (addressDetails.isSetAdministrativeArea())
			return new AdministrativeAreaImpl(addressDetails.getAdministrativeArea());

		return null;
	}

	@Override
	public String getCurrentStatus() {
		return addressDetails.getCurrentStatus();
	}

	@Override
	public Locality getLocality() {
		if (addressDetails.isSetLocality())
			return new LocalityImpl(addressDetails.getLocality());

		return null;
	}

	@Override
	public PostalServiceElements getPostalServiceElements() {
		if (addressDetails.isSetPostalServiceElements())
			return new PostalServiceElementsImpl(addressDetails.getPostalServiceElements());

		return null;
	}

	@Override
	public Thoroughfare getThoroughfare() {
		if (addressDetails.isSetThoroughfare())
			return new ThoroughfareImpl(addressDetails.getThoroughfare());

		return null;
	}

	@Override
	public String getUsage() {
		return addressDetails.getUsage();
	}

	@Override
	public String getValidFromDate() {
		return addressDetails.getValidFromDate();
	}

	@Override
	public String getValidToDate() {
		return addressDetails.getValidToDate();
	}

	@Override
	public void setAddress(Address address) {
		addressDetails.setAddress(((AddressImpl)address).getJAXBObject());
	}

	@Override
	public void setAddressDetailsKey(String addressDetailsKey) {
		addressDetails.setAddressDetailsKey(addressDetailsKey);		
	}

	@Override
	public void setAddressLines(AddressLines addressLines) {
		addressDetails.setAddressLines(((AddressLinesImpl)addressLines).getJAXBObject());
	}

	@Override
	public void setAddressType(String addressType) {
		addressDetails.setAddressType(addressType);
	}

	@Override
	public void setAdministrativeArea(AdministrativeArea administrativeArea) {
		addressDetails.setAdministrativeArea(((AdministrativeAreaImpl)administrativeArea).getJAXBObject());
	}

	@Override
	public void setCurrentStatus(String currentStatus) {
		addressDetails.setCurrentStatus(currentStatus);		
	}

	@Override
	public void setLocality(Locality locality) {
		addressDetails.setLocality(((LocalityImpl)locality).getJAXBObject());
	}

	@Override
	public void setPostalServiceElements(PostalServiceElements postalServiceElements) {
		addressDetails.setPostalServiceElements(((PostalServiceElementsImpl)postalServiceElements).getJAXBObject());
	}

	@Override
	public void setThoroughfare(Thoroughfare thoroughfare) {
		addressDetails.setThoroughfare(((ThoroughfareImpl)thoroughfare).getJAXBObject());		
	}

	@Override
	public void setUsage(String usage) {
		addressDetails.setUsage(usage);		
	}

	@Override
	public void setValidFromDate(String validFromDate) {
		addressDetails.setValidFromDate(validFromDate);		
	}

	@Override
	public void setValidToDate(String validToDate) {
		addressDetails.setValidToDate(validToDate);		
	}

	@Override
	public boolean isSetAddress() {
		return addressDetails.isSetAddress();
	}

	@Override
	public boolean isSetAddressDetailsKey() {
		return addressDetails.isSetAddressDetailsKey();
	}

	@Override
	public boolean isSetAddressLines() {
		return addressDetails.isSetAddressLines();
	}

	@Override
	public boolean isSetAddressType() {
		return addressDetails.isSetAddressType();
	}

	@Override
	public boolean isSetAdministrativeArea() {
		return addressDetails.isSetAdministrativeArea();
	}

	@Override
	public boolean isSetCountry() {
		return addressDetails.isSetCountry();
	}

	@Override
	public boolean isSetCurrentStatus() {
		return addressDetails.isSetCurrentStatus();
	}

	@Override
	public boolean isSetLocality() {
		return addressDetails.isSetLocality();
	}

	@Override
	public boolean isSetPostalServiceElements() {
		return addressDetails.isSetPostalServiceElements();
	}

	@Override
	public boolean isSetThoroughfare() {
		return addressDetails.isSetThoroughfare();
	}

	@Override
	public boolean isSetUsage() {
		return addressDetails.isSetUsage();
	}

	@Override
	public boolean isSetValidFromDate() {
		return addressDetails.isSetValidFromDate();
	}

	@Override
	public boolean isSetValidToDate() {
		return addressDetails.isSetValidToDate();
	}

	@Override
	public void unsetAddress() {
		addressDetails.setAddress(null);
	}

	@Override
	public void unsetAddressDetailsKey() {
		addressDetails.setAddressDetailsKey(null);
	}

	@Override
	public void unsetAddressLines() {
		addressDetails.setAddressLines(null);
	}

	@Override
	public void unsetAddressType() {
		addressDetails.setAddressType(null);
	}

	@Override
	public void unsetAdministrativeArea() {
		addressDetails.setAdministrativeArea(null);
	}

	@Override
	public void unsetCountry() {
		addressDetails.setCountry(null);
	}

	@Override
	public void unsetCurrentStatus() {
		addressDetails.setCurrentStatus(null);
	}

	@Override
	public void unsetLocality() {
		addressDetails.setLocality(null);
	}

	@Override
	public void unsetPostalServiceElements() {
		addressDetails.setPostalServiceElements(null);
	}

	@Override
	public void unsetThoroughfare() {
		addressDetails.setThoroughfare(null);
	}

	@Override
	public void unsetUsage() {
		addressDetails.setUsage(null);
	}

	@Override
	public void unsetValidFromDate() {
		addressDetails.setValidFromDate(null);
	}

	@Override
	public void unsetValidToDate() {
		addressDetails.setValidToDate(null);
	}

	@Override
	public boolean isSetCode() {
		return addressDetails.isSetCode();
	}

	@Override
	public void unsetCode() {
		addressDetails.setCode(null);
	}

}
