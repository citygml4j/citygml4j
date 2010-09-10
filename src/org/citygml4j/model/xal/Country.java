package org.citygml4j.model.xal;

import java.util.List;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public interface Country extends XAL, Child, Copyable {
	public List<AddressLine> getAddressLine();
	public List<CountryNameCode> getCountryNameCode();
	public List<CountryName> getCountryName();
	public AdministrativeArea getAdministrativeArea();
	public Locality getLocality();
	public Thoroughfare getThoroughfare();
	public boolean isSetAddressLine();
	public boolean isSetCountryNameCode();
	public boolean isSetCountryName();
	public boolean isSetAdministrativeArea();
	public boolean isSetLocality();
	public boolean isSetThoroughfare();
	
	public void setAddressLine(List<AddressLine> addressLine);
	public void addAddressLine(AddressLine addressLine);
	public void setCountryNameCode(List<CountryNameCode> countryNameCode);
	public void addCountryNameCode(CountryNameCode countryNameCode);
	public void setCountryName(List<CountryName> countryName);
	public void addCountryName(CountryName countryName);
	public void setAdministrativeArea(AdministrativeArea administrativeArea);
	public void setLocality(Locality locality);
	public void setThoroughfare(Thoroughfare thoroughfare);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetCountryNameCode();
	public boolean unsetCountryNameCode(CountryNameCode countryNameCode);
	public void unsetCountryName();
	public boolean unsetCountryName(CountryName countryName);
	public void unsetAdministrativeArea();
	public void unsetLocality();
	public void unsetThoroughfare();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
