package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.AdministrativeAreaElement;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.Locality;
import org.citygml4j.model.xal.PostOffice;
import org.citygml4j.model.xal.PostalCode;
import org.citygml4j.model.xal.SubAdministrativeArea;
import org.citygml4j.model.xal.SubAdministrativeAreaName;
import org.citygml4j.model.xal.XALClass;

public class SubAdministrativeAreaImpl extends XALBaseImpl implements SubAdministrativeArea {
	private AdministrativeAreaElement.SubAdministrativeArea subArea;

	public SubAdministrativeAreaImpl() {
		subArea = new AdministrativeAreaElement.SubAdministrativeArea();
	}

	public SubAdministrativeAreaImpl(AdministrativeAreaElement.SubAdministrativeArea subArea) {
		this.subArea = subArea;
	}

	@Override
	public AdministrativeAreaElement.SubAdministrativeArea getJAXBObject() {
		return subArea;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.SUBADMINISTRATIVEAREA;
	}

	public void addAddressLine(AddressLine addressLine) {
		subArea.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	public void addSubAdministrativeAreaName(SubAdministrativeAreaName subAdministrativeAreaName) {
		subArea.getSubAdministrativeAreaName().add(((SubAdministrativeAreaNameImpl)subAdministrativeAreaName).getJAXBObject());
	}

	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : subArea.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	public String getIndicator() {
		return subArea.getIndicator();
	}

	public Locality getLocality() {
		if (subArea.isSetLocality())
			return new LocalityImpl(subArea.getLocality());

		return null;
	}

	public PostOffice getPostOffice() {
		if (subArea.isSetPostOffice())
			return new PostOfficeImpl(subArea.getPostOffice());

		return null;
	}

	public PostalCode getPostalCode() {
		if (subArea.isSetPostalCode())
			return new PostalCodeImpl(subArea.getPostalCode());

		return null;
	}

	public List<SubAdministrativeAreaName> getSubAdministrativeAreaName() {
		List<SubAdministrativeAreaName> subNameList = new ArrayList<SubAdministrativeAreaName>();

		for (AdministrativeAreaElement.SubAdministrativeArea.SubAdministrativeAreaName subNameElem : subArea.getSubAdministrativeAreaName())
			subNameList.add(new SubAdministrativeAreaNameImpl(subNameElem));

		return subNameList;
	}

	public String getType() {
		return subArea.getType();
	}

	public String getUsageType() {
		return subArea.getUsageType();
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		subArea.unsetAddressLine();
		subArea.getAddressLine().addAll(addressLineElemList);
	}

	public void setIndicator(String indicator) {
		subArea.setIndicator(indicator);
	}

	public void setLocality(Locality locality) {
		subArea.setLocality(((LocalityImpl)locality).getJAXBObject());
	}

	public void setPostOffice(PostOffice postOffice) {
		subArea.setPostOffice(((PostOfficeImpl)postOffice).getJAXBObject());
	}

	public void setPostalCode(PostalCode postalCode) {
		subArea.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	public void setSubAdministrativeAreaName(List<SubAdministrativeAreaName> subAdministrativeAreaName) {
		List<AdministrativeAreaElement.SubAdministrativeArea.SubAdministrativeAreaName> subNameElemList = new ArrayList<AdministrativeAreaElement.SubAdministrativeArea.SubAdministrativeAreaName>();

		for (SubAdministrativeAreaName subName : subAdministrativeAreaName)
			subNameElemList.add(((SubAdministrativeAreaNameImpl)subName).getJAXBObject());

		subArea.unsetSubAdministrativeAreaName();
		subArea.getSubAdministrativeAreaName().addAll(subNameElemList);
	}

	public void setType(String type) {
		subArea.setType(type);
	}

	public void setUsageType(String usageType) {
		subArea.setUsageType(usageType);
	}

	public boolean isSetAddressLine() {
		return subArea.isSetAddressLine();
	}

	public boolean isSetIndicator() {
		return subArea.isSetIndicator();
	}

	public boolean isSetLocality() {
		return subArea.isSetLocality();
	}

	public boolean isSetPostalCode() {
		return subArea.isSetPostalCode();
	}

	public boolean isSetPostOffice() {
		return subArea.isSetPostOffice();
	}

	public boolean isSetSubAdministrativeAreaName() {
		return subArea.isSetSubAdministrativeAreaName();
	}

	public boolean isSetType() {
		return subArea.isSetType();
	}

	public boolean isSetUsageType() {
		return subArea.isSetUsageType();
	}

	public void unsetAddressLine() {
		subArea.unsetAddressLine();
	}

	public void unsetIndicator() {
		subArea.setIndicator(null);
	}

	public void unsetLocality() {
		subArea.setLocality(null);
	}

	public void unsetPostalCode() {
		subArea.setPostalCode(null);
	}

	public void unsetPostOffice() {
		subArea.setPostOffice(null);
	}

	public void unsetSubAdministrativeAreaName() {
		subArea.unsetSubAdministrativeAreaName();
	}

	public void unsetType() {
		subArea.setType(null);
	}

	public void unsetUsageType() {
		subArea.setUsageType(null);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		if (subArea.isSetAddressLine())
			return subArea.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	public boolean unsetSubAdministrativeAreaName(SubAdministrativeAreaName subAdministrativeAreaName) {
		if (subArea.isSetSubAdministrativeAreaName())
			return subArea.getSubAdministrativeAreaName().remove(((SubAdministrativeAreaNameImpl)subAdministrativeAreaName).getJAXBObject());
		
		return false;
	}

}
