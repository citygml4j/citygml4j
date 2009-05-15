package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.AdministrativeAreaElement;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.AdministrativeArea;
import org.citygml4j.model.xal.AdministrativeAreaName;
import org.citygml4j.model.xal.Locality;
import org.citygml4j.model.xal.PostOffice;
import org.citygml4j.model.xal.PostalCode;
import org.citygml4j.model.xal.SubAdministrativeArea;
import org.citygml4j.model.xal.XALClass;

public class AdministrativeAreaImpl extends XALBaseImpl implements AdministrativeArea {
	private AdministrativeAreaElement area;

	public AdministrativeAreaImpl() {
		area = new AdministrativeAreaElement();
	}

	public AdministrativeAreaImpl(AdministrativeAreaElement area) {
		this.area = area;
	}

	@Override
	public AdministrativeAreaElement getJAXBObject() {
		return area;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.ADMINISTRATIVEAREA;
	}

	public void addAddressLine(AddressLine addressLine) {
		area.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	public void addAdministrativeAreaName(AdministrativeAreaName administrativeAreaName) {
		area.getAdministrativeAreaName().add(((AdministrativeAreaNameImpl)administrativeAreaName).getJAXBObject());
	}

	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineInst : area.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineInst));

		return addressLineList;
	}

	public List<AdministrativeAreaName> getAdministrativeAreaName() {
		List<AdministrativeAreaName> nameList = new ArrayList<AdministrativeAreaName>();

		for (AdministrativeAreaElement.AdministrativeAreaName nameInst : area.getAdministrativeAreaName())
			nameList.add(new AdministrativeAreaNameImpl(nameInst));

		return nameList;
	}

	public String getIndicator() {
		return area.getIndicator();
	}

	public Locality getLocality() {
		if (area.isSetLocality())
			return new LocalityImpl(area.getLocality());

		return null;
	}

	public PostOffice getPostOffice() {
		if (area.isSetPostOffice())
			return new PostOfficeImpl(area.getPostOffice());

		return null;
	}

	public PostalCode getPostalCode() {
		if (area.isSetPostalCode())
			return new PostalCodeImpl(area.getPostalCode());

		return null;
	}

	public SubAdministrativeArea getSubAdministrativeArea() {
		if (area.isSetSubAdministrativeArea())
			return new SubAdministrativeAreaImpl(area.getSubAdministrativeArea());

		return null;
	}

	public String getType() {
		return area.getType();
	}

	public String getUsageType() {
		return area.getUsageType();
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineInstList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineInstList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		area.unsetAddressLine();
		area.getAddressLine().addAll(addressLineInstList);
	}

	public void setAdministrativeAreaName(List<AdministrativeAreaName> administrativeAreaName) {
		List<AdministrativeAreaElement.AdministrativeAreaName> nameElemList = new ArrayList<AdministrativeAreaElement.AdministrativeAreaName>();

		for (AdministrativeAreaName name : administrativeAreaName)
			nameElemList.add(((AdministrativeAreaNameImpl)name).getJAXBObject());

		area.unsetAdministrativeAreaName();
		area.getAdministrativeAreaName().addAll(nameElemList);
	}

	public void setIndicator(String indicator) {
		area.setIndicator(indicator);
	}

	public void setLocality(Locality locality) {
		area.setLocality(((LocalityImpl)locality).getJAXBObject());
	}

	public void setPostOffice(PostOffice postOffice) {
		area.setPostOffice(((PostOfficeImpl)postOffice).getJAXBObject());
	}

	public void setPostalCode(PostalCode postalCode) {
		area.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	public void setSubAdministrativeArea(SubAdministrativeArea subAdministrativeArea) {
		area.setSubAdministrativeArea(((SubAdministrativeAreaImpl)subAdministrativeArea).getJAXBObject());
	}

	public void setType(String type) {
		area.setType(type);
	}

	public void setUsageType(String usageType) {
		area.setUsageType(usageType);
	}

	public boolean isSetAddressLine() {
		return area.isSetAddressLine();
	}

	public boolean isSetAdministrativeAreaName() {
		return area.isSetAdministrativeAreaName();
	}

	public boolean isSetIndicator() {
		return area.isSetIndicator();
	}

	public boolean isSetLocality() {
		return area.isSetLocality();
	}

	public boolean isSetPostalCode() {
		return area.isSetPostalCode();
	}

	public boolean isSetPostOffice() {
		return area.isSetPostOffice();
	}

	public boolean isSetSubAdministrativeArea() {
		return area.isSetSubAdministrativeArea();
	}

	public boolean isSetType() {
		return area.isSetType();
	}

	public boolean isSetUsageType() {
		return area.isSetUsageType();
	}

	public void unsetAddressLine() {
		area.unsetAddressLine();
	}

	public void unsetAdministrativeAreaName() {
		area.unsetAdministrativeAreaName();
	}

	public void unsetIndicator() {
		area.setIndicator(null);
	}

	public void unsetLocality() {
		area.setLocality(null);
	}

	public void unsetPostalCode() {
		area.setPostalCode(null);
	}

	public void unsetPostOffice() {
		area.setPostOffice(null);
	}

	public void unsetSubAdministrativeArea() {
		area.setSubAdministrativeArea(null);
	}

	public void unsetType() {
		area.setType(null);
	}

	public void unsetUsageType() {
		area.setUsageType(null);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		if (area.isSetAddressLine())
			return area.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
			
		return false;
	}

	public boolean unsetAdministrativeAreaName(AdministrativeAreaName administrativeAreaName) {
		if (area.isSetAdministrativeAreaName())
			return area.getAdministrativeAreaName().remove(((AdministrativeAreaNameImpl)administrativeAreaName).getJAXBObject());
		
		return false;
	}

}
