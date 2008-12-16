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

	@Override
	public void addAddressLine(AddressLine addressLine) {
		subArea.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public void addSubAdministrativeAreaName(SubAdministrativeAreaName subAdministrativeAreaName) {
		subArea.getSubAdministrativeAreaName().add(((SubAdministrativeAreaNameImpl)subAdministrativeAreaName).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();
		List<AddressLineElement> addressLineElemList = subArea.getAddressLine();

		for (AddressLineElement addressLineElem : addressLineElemList)
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	@Override
	public String getIndicator() {
		return subArea.getIndicator();
	}

	@Override
	public Locality getLocality() {
		if (subArea.isSetLocality())
			return new LocalityImpl(subArea.getLocality());

		return null;
	}

	@Override
	public PostOffice getPostOffice() {
		if (subArea.isSetPostOffice())
			return new PostOfficeImpl(subArea.getPostOffice());

		return null;
	}

	@Override
	public PostalCode getPostalCode() {
		if (subArea.isSetPostalCode())
			return new PostalCodeImpl(subArea.getPostalCode());

		return null;
	}

	@Override
	public List<SubAdministrativeAreaName> getSubAdministrativeAreaName() {
		List<SubAdministrativeAreaName> subNameList = new ArrayList<SubAdministrativeAreaName>();
		List<AdministrativeAreaElement.SubAdministrativeArea.SubAdministrativeAreaName> subNameElemList = subArea.getSubAdministrativeAreaName();

		for (AdministrativeAreaElement.SubAdministrativeArea.SubAdministrativeAreaName subNameElem : subNameElemList)
			subNameList.add(new SubAdministrativeAreaNameImpl(subNameElem));

		return subNameList;
	}

	@Override
	public String getType() {
		return subArea.getType();
	}

	@Override
	public String getUsageType() {
		return subArea.getUsageType();
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		subArea.unsetAddressLine();
		subArea.getAddressLine().addAll(addressLineElemList);
	}

	@Override
	public void setIndicator(String indicator) {
		subArea.setIndicator(indicator);
	}

	@Override
	public void setLocality(Locality locality) {
		subArea.setLocality(((LocalityImpl)locality).getJAXBObject());
	}

	@Override
	public void setPostOffice(PostOffice postOffice) {
		subArea.setPostOffice(((PostOfficeImpl)postOffice).getJAXBObject());
	}

	@Override
	public void setPostalCode(PostalCode postalCode) {
		subArea.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	@Override
	public void setSubAdministrativeAreaName(List<SubAdministrativeAreaName> subAdministrativeAreaName) {
		List<AdministrativeAreaElement.SubAdministrativeArea.SubAdministrativeAreaName> subNameElemList = new ArrayList<AdministrativeAreaElement.SubAdministrativeArea.SubAdministrativeAreaName>();

		for (SubAdministrativeAreaName subName : subAdministrativeAreaName)
			subNameElemList.add(((SubAdministrativeAreaNameImpl)subName).getJAXBObject());

		subArea.unsetSubAdministrativeAreaName();
		subArea.getSubAdministrativeAreaName().addAll(subNameElemList);
	}

	@Override
	public void setType(String type) {
		subArea.setType(type);
	}

	@Override
	public void setUsageType(String usageType) {
		subArea.setUsageType(usageType);
	}

	@Override
	public boolean isSetAddressLine() {
		return subArea.isSetAddressLine();
	}

	@Override
	public boolean isSetIndicator() {
		return subArea.isSetIndicator();
	}

	@Override
	public boolean isSetLocality() {
		return subArea.isSetLocality();
	}

	@Override
	public boolean isSetPostalCode() {
		return subArea.isSetPostalCode();
	}

	@Override
	public boolean isSetPostOffice() {
		return subArea.isSetPostOffice();
	}

	@Override
	public boolean isSetSubAdministrativeAreaName() {
		return subArea.isSetSubAdministrativeAreaName();
	}

	@Override
	public boolean isSetType() {
		return subArea.isSetType();
	}

	@Override
	public boolean isSetUsageType() {
		return subArea.isSetUsageType();
	}

	@Override
	public void unsetAddressLine() {
		subArea.unsetAddressLine();
	}

	@Override
	public void unsetIndicator() {
		subArea.setIndicator(null);
	}

	@Override
	public void unsetLocality() {
		subArea.setLocality(null);
	}

	@Override
	public void unsetPostalCode() {
		subArea.setPostalCode(null);
	}

	@Override
	public void unsetPostOffice() {
		subArea.setPostOffice(null);
	}

	@Override
	public void unsetSubAdministrativeAreaName() {
		subArea.unsetSubAdministrativeAreaName();
	}

	@Override
	public void unsetType() {
		subArea.setType(null);
	}

	@Override
	public void unsetUsageType() {
		subArea.setUsageType(null);
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (subArea.isSetAddressLine())
			return subArea.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetSubAdministrativeAreaName(SubAdministrativeAreaName subAdministrativeAreaName) {
		if (subArea.isSetSubAdministrativeAreaName())
			return subArea.getSubAdministrativeAreaName().remove(((SubAdministrativeAreaNameImpl)subAdministrativeAreaName).getJAXBObject());
		
		return false;
	}

}
