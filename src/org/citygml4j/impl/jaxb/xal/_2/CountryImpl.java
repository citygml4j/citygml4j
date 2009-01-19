package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressDetails;
import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.CountryNameElement;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.AdministrativeArea;
import org.citygml4j.model.xal.Country;
import org.citygml4j.model.xal.CountryName;
import org.citygml4j.model.xal.CountryNameCode;
import org.citygml4j.model.xal.Locality;
import org.citygml4j.model.xal.Thoroughfare;
import org.citygml4j.model.xal.XALClass;

public class CountryImpl extends XALBaseImpl implements Country {
	private AddressDetails.Country country;

	public CountryImpl() {
		country = new AddressDetails.Country();
	}

	public CountryImpl(AddressDetails.Country country) {
		this.country = country;
	}

	@Override
	public AddressDetails.Country getJAXBObject() {
		return country;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.COUNTRY;
	}

	@Override
	public void addCountryName(CountryName countryName) {
		country.getCountryName().add(((CountryNameImpl)countryName).getJAXBObject());
	}

	@Override
	public List<CountryName> getCountryName() {
		List<CountryName> countryNameList = new ArrayList<CountryName>();

		for (CountryNameElement countryNameInst : country.getCountryName()) 
			countryNameList.add(new CountryNameImpl(countryNameInst));

		return countryNameList;
	}

	@Override
	public void setCountryName(List<CountryName> countryName) {
		List<CountryNameElement> countryNameInstList = new ArrayList<CountryNameElement>();

		for (CountryName countryNameItem : countryName)
			countryNameInstList.add(((CountryNameImpl)countryNameItem).getJAXBObject());

		country.unsetCountryName();
		country.getCountryName().addAll(countryNameInstList);
	}

	@Override
	public void addCountryNameCode(CountryNameCode countryNameCode) {
		country.getCountryNameCode().add(((CountryNameCodeImpl)countryNameCode).getJAXBObject());
	}

	@Override
	public List<CountryNameCode> getCountryNameCode() {
		List<CountryNameCode> codeList = new ArrayList<CountryNameCode>();

		for (AddressDetails.Country.CountryNameCode code : country.getCountryNameCode())
			codeList.add(new CountryNameCodeImpl(code));

		return codeList;
	}

	@Override
	public void setCountryNameCode(List<CountryNameCode> countryNameCode) {
		List<AddressDetails.Country.CountryNameCode> countryNameCodeList = new ArrayList<AddressDetails.Country.CountryNameCode>();

		for (CountryNameCode code : countryNameCode)
			countryNameCodeList.add(((CountryNameCodeImpl)code).getJAXBObject());

		country.unsetCountryNameCode();
		country.getCountryNameCode().addAll(countryNameCodeList);
	}

	@Override
	public void addAddressLine(AddressLine addressLine) {
		country.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineInst : country.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineInst));

		return addressLineList;
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		country.unsetAddressLine();
		country.getAddressLine().addAll(addressLineElemList);
	}

	@Override
	public AdministrativeArea getAdministrativeArea() {
		if (country.isSetAdministrativeArea())
			return new AdministrativeAreaImpl(country.getAdministrativeArea());

		return null;
	}

	@Override
	public Locality getLocality() {
		if (country.isSetLocality())
			return new LocalityImpl(country.getLocality());

		return null;
	}

	@Override
	public Thoroughfare getThoroughfare() {
		if (country.isSetThoroughfare())
			return  new ThoroughfareImpl(country.getThoroughfare());

		return null;
	}

	@Override
	public void setAdministrativeArea(AdministrativeArea administrativeArea) {
		country.setAdministrativeArea(((AdministrativeAreaImpl)administrativeArea).getJAXBObject());		
	}

	@Override
	public void setLocality(Locality locality) {
		country.setLocality(((LocalityImpl)locality).getJAXBObject());
	}

	@Override
	public void setThoroughfare(Thoroughfare thoroughfare) {
		country.setThoroughfare(((ThoroughfareImpl)thoroughfare).getJAXBObject());	
	}

	@Override
	public boolean isSetAddressLine() {
		return country.isSetAddressLine();
	}

	@Override
	public boolean isSetAdministrativeArea() {
		return country.isSetAdministrativeArea();
	}

	@Override
	public boolean isSetCountryName() {
		return country.isSetCountryName();
	}

	@Override
	public boolean isSetCountryNameCode() {
		return country.isSetCountryNameCode();
	}

	@Override
	public boolean isSetLocality() {
		return country.isSetLocality();
	}

	@Override
	public void unsetAddressLine() {
		country.unsetAddressLine();
	}

	@Override
	public void unsetAdministrativeArea() {
		country.setAdministrativeArea(null);
	}

	@Override
	public void unsetCountryName() {
		country.unsetCountryName();
	}

	@Override
	public void unsetCountryNameCode() {
		country.unsetCountryNameCode();
	}

	@Override
	public void unsetLocality() {
		country.setLocality(null);
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (country.isSetAddressLine())
			return country.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetCountryName(CountryName countryName) {
		if (country.isSetCountryName())
			return country.getCountryName().remove(((CountryNameImpl)countryName).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetCountryNameCode(CountryNameCode countryNameCode) {
		if (country.isSetCountryNameCode())
			return country.getCountryNameCode().remove(((CountryNameCodeImpl)countryNameCode).getJAXBObject());
		
		return false;
	}

}
