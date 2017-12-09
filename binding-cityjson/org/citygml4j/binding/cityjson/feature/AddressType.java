package org.citygml4j.binding.cityjson.feature;

import org.citygml4j.binding.cityjson.geometry.MultiPointType;

public class AddressType {
	private String CountryName;
	private String LocalityName;
	private String ThoroughfareNumber;
	private String ThoroughfareName;
	private String PostalCode;
	private MultiPointType location;
	
	public boolean isSetCountryName() {
		return CountryName != null;
	}
	
	public String getCountryName() {
		return CountryName;
	}
	
	public void setCountryName(String countryName) {
		CountryName = countryName;
	}
	
	public void unsetCountryName() {
		CountryName = null;
	}
	
	public boolean isSetLocalityName() {
		return LocalityName != null;
	}
	
	public String getLocalityName() {
		return LocalityName;
	}
	
	public void setLocalityName(String localityName) {
		LocalityName = localityName;
	}
	
	public void unsetLocalityName() {
		LocalityName = null;
	}
	
	public boolean isSetThoroughfareNumber() {
		return ThoroughfareNumber != null;
	}
	
	public String getThoroughfareNumber() {
		return ThoroughfareNumber;
	}
	
	public void setThoroughfareNumber(String thoroughfareNumber) {
		ThoroughfareNumber = thoroughfareNumber;
	}
	
	public void unsetThoroughfareNumber() {
		ThoroughfareNumber = null;
	}
	
	public boolean isSetThoroughfareName() {
		return ThoroughfareName != null;
	}
	
	public String getThoroughfareName() {
		return ThoroughfareName;
	}
	
	public void setThoroughfareName(String thoroughfareName) {
		ThoroughfareName = thoroughfareName;
	}
	
	public void unsetThoroughfareName() {
		ThoroughfareName = null;
	}
	
	public boolean isSetPostalCode() {
		return PostalCode != null;
	}
	
	public String getPostalCode() {
		return PostalCode;
	}
	
	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}
	
	public void unsetPostalCode() {
		PostalCode = null;
	}
	
	public boolean isSetLocation() {
		return location != null;
	}
	
	public MultiPointType getLocation() {
		return location;
	}
	
	public void setLocation(MultiPointType location) {
		this.location = location;
	}
	
	public void unsetLocation() {
		location = null;
	}
	
}
