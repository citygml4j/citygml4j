package org.citygml4j.builder.cityjson.unmarshal.citygml.core;

import java.util.GregorianCalendar;

import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.AddressType;
import org.citygml4j.binding.cityjson.feature.Attributes;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.XalAddressProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiPointProperty;
import org.citygml4j.model.xal.AddressDetails;
import org.citygml4j.model.xal.Country;
import org.citygml4j.model.xal.CountryName;
import org.citygml4j.model.xal.Locality;
import org.citygml4j.model.xal.LocalityName;
import org.citygml4j.model.xal.PostalCode;
import org.citygml4j.model.xal.PostalCodeNumber;
import org.citygml4j.model.xal.Thoroughfare;
import org.citygml4j.model.xal.ThoroughfareName;
import org.citygml4j.model.xal.ThoroughfareNumber;

public class CoreUnmarshaller {
	private final CityJSONUnmarshaller json;
	private final CityGMLUnmarshaller citygml;
	
	public CoreUnmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONUnmarshaller();
	}
	
	public void unmarshalAbstractCityObject(AbstractCityObjectType src, AbstractCityObject dest) {
		dest.setId(src.getGmlId());
		
		if (src.isSetAttributes()) {
			Attributes attributes = src.getAttributes();
			
			if (attributes.isSetCreationDate()) {
				GregorianCalendar creationDate = new GregorianCalendar();
				creationDate.setTime(attributes.getCreationDate());
				dest.setCreationDate(creationDate);
			}
			
			if (attributes.isSetTerminationDate()) {
				GregorianCalendar terminationDate = new GregorianCalendar();
				terminationDate.setTime(attributes.getCreationDate());
				dest.setTerminationDate(terminationDate);
			}
			
			if (attributes.isSetGenericAttributes())
				citygml.getGenericsUnmarshaller().unmarshalGenericAttributes(attributes, dest);
		}
	}
	
	public void unmarshalAddress(AddressType src, Address dest) {		
		AddressDetails addressDetails = new AddressDetails();		
		Country country = new Country();
		
		if (src.isSetCountryName())
			country.addCountryName(new CountryName(src.getCountryName()));
		
		Locality locality = new Locality();
		locality.setType("City");
		
		if (src.isSetLocalityName())
			locality.addLocalityName(new LocalityName(src.getLocalityName()));
		
		if (src.isSetThoroughfareName() || src.isSetThoroughfareNumber()) {
			Thoroughfare thoroughfare = new Thoroughfare();
			thoroughfare.setType("Street");
			locality.setThoroughfare(thoroughfare);

			if (src.isSetThoroughfareName())
				thoroughfare.addThoroughfareName(new ThoroughfareName(src.getThoroughfareName()));
			
			if (src.isSetThoroughfareNumber())
				thoroughfare.addThoroughfareNumber(new ThoroughfareNumber(src.getThoroughfareNumber()));			
		}
		
		if (src.isSetPostalCode()) {
			PostalCode postalCode = new PostalCode();
			postalCode.addPostalCodeNumber(new PostalCodeNumber(src.getPostalCode()));
			locality.setPostalCode(postalCode);			
		}
		
		if (locality.isSetLocalityName()
				|| locality.isSetThoroughfare()
				|| locality.isSetPostalCode())
			country.setLocality(locality);
		
		if (country.isSetCountryName()
				|| country.isSetLocality())
			addressDetails.setCountry(country);
		
		if (src.isSetLocation())
			dest.setMultiPoint(new MultiPointProperty(json.getGMLUnmarshaller().unmarshalMultiPoint(src.getLocation())));

		dest.setXalAddress(new XalAddressProperty(addressDetails));
	}
	
	public Address unmarshalAddress(AddressType src) {
		Address dest = new Address();
		unmarshalAddress(src, dest);
		
		return dest;
	}
	
}
