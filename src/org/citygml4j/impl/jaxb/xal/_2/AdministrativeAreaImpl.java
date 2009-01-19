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

	@Override
	public void addAddressLine(AddressLine addressLine) {
		area.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public void addAdministrativeAreaName(AdministrativeAreaName administrativeAreaName) {
		area.getAdministrativeAreaName().add(((AdministrativeAreaNameImpl)administrativeAreaName).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineInst : area.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineInst));

		return addressLineList;
	}

	@Override
	public List<AdministrativeAreaName> getAdministrativeAreaName() {
		List<AdministrativeAreaName> nameList = new ArrayList<AdministrativeAreaName>();

		for (AdministrativeAreaElement.AdministrativeAreaName nameInst : area.getAdministrativeAreaName())
			nameList.add(new AdministrativeAreaNameImpl(nameInst));

		return nameList;
	}

	@Override
	public String getIndicator() {
		return area.getIndicator();
	}

	@Override
	public Locality getLocality() {
		if (area.isSetLocality())
			return new LocalityImpl(area.getLocality());

		return null;
	}

	@Override
	public PostOffice getPostOffice() {
		if (area.isSetPostOffice())
			return new PostOfficeImpl(area.getPostOffice());

		return null;
	}

	@Override
	public PostalCode getPostalCode() {
		if (area.isSetPostalCode())
			return new PostalCodeImpl(area.getPostalCode());

		return null;
	}

	@Override
	public SubAdministrativeArea getSubAdministrativeArea() {
		if (area.isSetSubAdministrativeArea())
			return new SubAdministrativeAreaImpl(area.getSubAdministrativeArea());

		return null;
	}

	@Override
	public String getType() {
		return area.getType();
	}

	@Override
	public String getUsageType() {
		return area.getUsageType();
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineInstList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineInstList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		area.unsetAddressLine();
		area.getAddressLine().addAll(addressLineInstList);
	}

	@Override
	public void setAdministrativeAreaName(List<AdministrativeAreaName> administrativeAreaName) {
		List<AdministrativeAreaElement.AdministrativeAreaName> nameElemList = new ArrayList<AdministrativeAreaElement.AdministrativeAreaName>();

		for (AdministrativeAreaName name : administrativeAreaName)
			nameElemList.add(((AdministrativeAreaNameImpl)name).getJAXBObject());

		area.unsetAdministrativeAreaName();
		area.getAdministrativeAreaName().addAll(nameElemList);
	}

	@Override
	public void setIndicator(String indicator) {
		area.setIndicator(indicator);
	}

	@Override
	public void setLocality(Locality locality) {
		area.setLocality(((LocalityImpl)locality).getJAXBObject());
	}

	@Override
	public void setPostOffice(PostOffice postOffice) {
		area.setPostOffice(((PostOfficeImpl)postOffice).getJAXBObject());
	}

	@Override
	public void setPostalCode(PostalCode postalCode) {
		area.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	@Override
	public void setSubAdministrativeArea(SubAdministrativeArea subAdministrativeArea) {
		area.setSubAdministrativeArea(((SubAdministrativeAreaImpl)subAdministrativeArea).getJAXBObject());
	}

	@Override
	public void setType(String type) {
		area.setType(type);
	}

	@Override
	public void setUsageType(String usageType) {
		area.setUsageType(usageType);
	}

	@Override
	public boolean isSetAddressLine() {
		return area.isSetAddressLine();
	}

	@Override
	public boolean isSetAdministrativeAreaName() {
		return area.isSetAdministrativeAreaName();
	}

	@Override
	public boolean isSetIndicator() {
		return area.isSetIndicator();
	}

	@Override
	public boolean isSetLocality() {
		return area.isSetLocality();
	}

	@Override
	public boolean isSetPostalCode() {
		return area.isSetPostalCode();
	}

	@Override
	public boolean isSetPostOffice() {
		return area.isSetPostOffice();
	}

	@Override
	public boolean isSetSubAdministrativeArea() {
		return area.isSetSubAdministrativeArea();
	}

	@Override
	public boolean isSetType() {
		return area.isSetType();
	}

	@Override
	public boolean isSetUsageType() {
		return area.isSetUsageType();
	}

	@Override
	public void unsetAddressLine() {
		area.unsetAddressLine();
	}

	@Override
	public void unsetAdministrativeAreaName() {
		area.unsetAdministrativeAreaName();
	}

	@Override
	public void unsetIndicator() {
		area.setIndicator(null);
	}

	@Override
	public void unsetLocality() {
		area.setLocality(null);
	}

	@Override
	public void unsetPostalCode() {
		area.setPostalCode(null);
	}

	@Override
	public void unsetPostOffice() {
		area.setPostOffice(null);
	}

	@Override
	public void unsetSubAdministrativeArea() {
		area.setSubAdministrativeArea(null);
	}

	@Override
	public void unsetType() {
		area.setType(null);
	}

	@Override
	public void unsetUsageType() {
		area.setUsageType(null);
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (area.isSetAddressLine())
			return area.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
			
		return false;
	}

	@Override
	public boolean unsetAdministrativeAreaName(AdministrativeAreaName administrativeAreaName) {
		if (area.isSetAdministrativeAreaName())
			return area.getAdministrativeAreaName().remove(((AdministrativeAreaNameImpl)administrativeAreaName).getJAXBObject());
		
		return false;
	}

}
