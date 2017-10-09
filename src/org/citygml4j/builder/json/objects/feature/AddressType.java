package org.citygml4j.builder.json.objects.feature;

import java.util.ArrayList;
import java.util.List;

public class AddressType {
	private String CountryName;
	private String LocalityName;
	private String ThoroughfareNumber;
	private String ThoroughfareName;
	private String PostalCode;
	private List<Integer> location;
	
	public boolean isSetCountryName() {
		return CountryName != null;
	}
	
	public String getCountryName() {
		return CountryName;
	}
	
	public void setCountryName(String countryName) {
		CountryName = countryName;
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
	
	public boolean isSetThoroughfareNumber() {
		return ThoroughfareNumber != null;
	}
	
	public String getThoroughfareNumber() {
		return ThoroughfareNumber;
	}
	
	public void setThoroughfareNumber(String thoroughfareNumber) {
		ThoroughfareNumber = thoroughfareNumber;
	}
	
	public String getThoroughfareName() {
		return ThoroughfareName;
	}
	
	public void setThoroughfareName(String thoroughfareName) {
		ThoroughfareName = thoroughfareName;
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
	
	public boolean isSetLocation() {
		return location != null;
	}

	public void addLocation(int point) {
		if (location == null)
			location = new ArrayList<>();
			
		location.add(point);
	}
	
	public List<Integer> getLocation() {
		return location;
	}
	
	public void setLocation(List<Integer> location) {
		this.location = location;
	}
	
}
