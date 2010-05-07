package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.BuildingNameType;
import org.citygml4j.jaxb.xal.SubPremiseType;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.BuildingName;
import org.citygml4j.model.xal.Firm;
import org.citygml4j.model.xal.MailStop;
import org.citygml4j.model.xal.PostalCode;
import org.citygml4j.model.xal.SubPremise;
import org.citygml4j.model.xal.SubPremiseLocation;
import org.citygml4j.model.xal.SubPremiseName;
import org.citygml4j.model.xal.SubPremiseNumber;
import org.citygml4j.model.xal.SubPremiseNumberPrefix;
import org.citygml4j.model.xal.SubPremiseNumberSuffix;
import org.citygml4j.model.xal.XALClass;

public class SubPremiseImpl extends XALBaseImpl implements SubPremise {
	private SubPremiseType subPremise;

	public SubPremiseImpl() {
		subPremise = new SubPremiseType();
	}

	public SubPremiseImpl(SubPremiseType subPremise) {
		this.subPremise = subPremise;
	}

	@Override
	public SubPremiseType getJAXBObject() {
		return subPremise;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.SUBPREMISE;
	}

	public void addAddressLine(AddressLine addressLine) {
		subPremise.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	public void addBuildingName(BuildingName buildingName) {
		subPremise.getBuildingName().add(((BuildingNameImpl)buildingName).getJAXBObject());
	}

	public void addSubPremiseName(SubPremiseName subPremiseName) {
		subPremise.getSubPremiseName().add(((SubPremiseNameImpl)subPremiseName).getJAXBObject());
	}

	public void addSubPremiseNumber(SubPremiseNumber subPremiseNumber) {
		subPremise.getSubPremiseNumber().add(((SubPremiseNumberImpl)subPremiseNumber).getJAXBObject());
	}

	public void addSubPremiseNumberPrefix(SubPremiseNumberPrefix subPremiseNumberPrefix) {
		subPremise.getSubPremiseNumberPrefix().add(((SubPremiseNumberPrefixImpl)subPremiseNumberPrefix).getJAXBObject());
	}

	public void addSubPremiseNumberSuffix(SubPremiseNumberSuffix subPremiseNumberSuffix) {
		subPremise.getSubPremiseNumberSuffix().add(((SubPremiseNumberSuffixImpl)subPremiseNumberSuffix).getJAXBObject());
	}

	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : subPremise.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	public List<BuildingName> getBuildingName() {
		List<BuildingName> buildingNameList = new ArrayList<BuildingName>();

		for (BuildingNameType buildingNameElem : subPremise.getBuildingName())
			buildingNameList.add(new BuildingNameImpl(buildingNameElem));

		return buildingNameList;
	}

	public Firm getFirm() {
		if (subPremise.isSetFirm())
			return new FirmImpl(subPremise.getFirm());

		return null;
	}

	public MailStop getMailStop() {
		if (subPremise.isSetMailStop())
			return new MailStopImpl(subPremise.getMailStop());

		return null;
	}

	public PostalCode getPostalCode() {
		if (subPremise.isSetPostalCode())
			return new PostalCodeImpl(subPremise.getPostalCode());

		return null;
	}

	public SubPremise getSubPremise() {
		if (subPremise.isSetSubPremise())
			return new SubPremiseImpl(subPremise.getSubPremise());

		return null;
	}

	public SubPremiseLocation getSubPremiseLocation() {
		if (subPremise.isSetSubPremiseLocation())
			return new SubPremiseLocationImpl(subPremise.getSubPremiseLocation());

		return null;
	}

	public List<SubPremiseName> getSubPremiseName() {
		List<SubPremiseName> subPremiseNameList = new ArrayList<SubPremiseName>();

		for (SubPremiseType.SubPremiseName subPremiseNameElem : subPremise.getSubPremiseName())
			subPremiseNameList.add(new SubPremiseNameImpl(subPremiseNameElem));

		return subPremiseNameList;
	}

	public List<SubPremiseNumber> getSubPremiseNumber() {
		List<SubPremiseNumber> subPremiseNumberList = new ArrayList<SubPremiseNumber>();

		for (SubPremiseType.SubPremiseNumber subPremiseNumberElem : subPremise.getSubPremiseNumber())
			subPremiseNumberList.add(new SubPremiseNumberImpl(subPremiseNumberElem));

		return subPremiseNumberList;
	}

	public List<SubPremiseNumberPrefix> getSubPremiseNumberPrefix() {
		List<SubPremiseNumberPrefix> subPremiseNumberPrefixList = new ArrayList<SubPremiseNumberPrefix>();

		for (SubPremiseType.SubPremiseNumberPrefix subPremiseNumberPrefixElem : subPremise.getSubPremiseNumberPrefix())
			subPremiseNumberPrefixList.add(new SubPremiseNumberPrefixImpl(subPremiseNumberPrefixElem));

		return subPremiseNumberPrefixList;
	}

	public List<SubPremiseNumberSuffix> getSubPremiseNumberSuffix() {
		List<SubPremiseNumberSuffix> subPremiseNumberSuffixList = new ArrayList<SubPremiseNumberSuffix>();

		for (SubPremiseType.SubPremiseNumberSuffix subPremiseNumberSuffixElem : subPremise.getSubPremiseNumberSuffix())
			subPremiseNumberSuffixList.add(new SubPremiseNumberSuffixImpl(subPremiseNumberSuffixElem));

		return subPremiseNumberSuffixList;
	}

	public String getType() {
		return subPremise.getType();
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		subPremise.unsetAddressLine();
		subPremise.getAddressLine().addAll(addressLineElemList);
	}

	public void setBuildingName(List<BuildingName> buildingName) {
		List<BuildingNameType> buildingNameList = new ArrayList<BuildingNameType>();

		for (BuildingName buildingNameItem : buildingName)
			buildingNameList.add(((BuildingNameImpl)buildingNameItem).getJAXBObject());

		subPremise.unsetBuildingName();
		subPremise.getBuildingName().addAll(buildingNameList);
	}

	public void setFirm(Firm firm) {
		subPremise.setFirm(((FirmImpl)firm).getJAXBObject());
	}

	public void setMailStop(MailStop mailStop) {
		subPremise.setMailStop(((MailStopImpl)mailStop).getJAXBObject());
	}

	public void setPostalCode(PostalCode postalCode) {
		subPremise.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	public void setSubPremise(SubPremise subPremise) {
		this.subPremise.setSubPremise(((SubPremiseImpl)subPremise).getJAXBObject());
	}

	public void setSubPremiseLocation(SubPremiseLocation subPremiseLocation) {
		subPremise.setSubPremiseLocation(((SubPremiseLocationImpl)subPremiseLocation).getJAXBObject());
	}

	public void setSubPremiseName(List<SubPremiseName> subPremiseName) {
		List<SubPremiseType.SubPremiseName> subPremiseNameList = new ArrayList<SubPremiseType.SubPremiseName>();

		for (SubPremiseName subPremiseNameItem : subPremiseName)
			subPremiseNameList.add(((SubPremiseNameImpl)subPremiseNameItem).getJAXBObject());

		subPremise.unsetSubPremiseName();
		subPremise.getSubPremiseName().addAll(subPremiseNameList);
	}

	public void setSubPremiseNumber(List<SubPremiseNumber> subPremiseNumber) {
		List<SubPremiseType.SubPremiseNumber> subPremiseNumberList = new ArrayList<SubPremiseType.SubPremiseNumber>();

		for (SubPremiseNumber subPremiseNumberItem : subPremiseNumber)
			subPremiseNumberList.add(((SubPremiseNumberImpl)subPremiseNumberItem).getJAXBObject());

		subPremise.unsetSubPremiseNumber();
		subPremise.getSubPremiseNumber().addAll(subPremiseNumberList);
	}

	public void setSubPremiseNumberPrefix(List<SubPremiseNumberPrefix> subPremiseNumberPrefix) {
		List<SubPremiseType.SubPremiseNumberPrefix> subPremiseNumberPrefixList = new ArrayList<SubPremiseType.SubPremiseNumberPrefix>();

		for (SubPremiseNumberPrefix subPremiseNumberPrefixItem : subPremiseNumberPrefix)
			subPremiseNumberPrefixList.add(((SubPremiseNumberPrefixImpl)subPremiseNumberPrefixItem).getJAXBObject());

		subPremise.unsetSubPremiseNumberPrefix();
		subPremise.getSubPremiseNumberPrefix().addAll(subPremiseNumberPrefixList);
	}

	public void setSubPremiseNumberSuffix(List<SubPremiseNumberSuffix> subPremiseNumberSuffix) {
		List<SubPremiseType.SubPremiseNumberSuffix> subPremiseNumberSuffixList = new ArrayList<SubPremiseType.SubPremiseNumberSuffix>();

		for (SubPremiseNumberSuffix subPremiseNumberSuffixItem : subPremiseNumberSuffix)
			subPremiseNumberSuffixList.add(((SubPremiseNumberSuffixImpl)subPremiseNumberSuffixItem).getJAXBObject());

		subPremise.unsetSubPremiseNumberSuffix();
		subPremise.getSubPremiseNumberSuffix().addAll(subPremiseNumberSuffixList);
	}

	public void setType(String type) {
		subPremise.setType(type);
	}

	public boolean isSetAddressLine() {
		return subPremise.isSetAddressLine();
	}

	public boolean isSetBuildingName() {
		return subPremise.isSetBuildingName();
	}

	public boolean isSetFirm() {
		return subPremise.isSetFirm();
	}

	public boolean isSetMailStop() {
		return subPremise.isSetMailStop();
	}

	public boolean isSetPostalCode() {
		return subPremise.isSetPostalCode();
	}

	public boolean isSetSubPremise() {
		return subPremise.isSetSubPremise();
	}

	public boolean isSetSubPremiseLocation() {
		return subPremise.isSetSubPremiseLocation();
	}

	public boolean isSetSubPremiseName() {
		return subPremise.isSetSubPremiseName();
	}

	public boolean isSetSubPremiseNumber() {
		return subPremise.isSetSubPremiseNumber();
	}

	public boolean isSetSubPremiseNumberPrefix() {
		return subPremise.isSetSubPremiseNumberPrefix();
	}

	public boolean isSetSubPremiseNumberSuffix() {
		return subPremise.isSetSubPremiseNumberSuffix();
	}

	public boolean isSetType() {
		return subPremise.isSetType();
	}

	public void unsetAddressLine() {
		subPremise.unsetAddressLine();
	}

	public void unsetBuildingName() {
		subPremise.unsetBuildingName();
	}

	public void unsetFirm() {
		subPremise.setFirm(null);
	}

	public void unsetMailStop() {
		subPremise.setMailStop(null);
	}

	public void unsetPostalCode() {
		subPremise.setPostalCode(null);
	}

	public void unsetSubPremise() {
		subPremise.setSubPremise(null);
	}

	public void unsetSubPremiseLocation() {
		subPremise.setSubPremiseLocation(null);
	}

	public void unsetSubPremiseName() {
		subPremise.unsetSubPremiseName();
	}

	public void unsetSubPremiseNumber() {
		subPremise.unsetSubPremiseNumber();
	}

	public void unsetSubPremiseNumberPrefix() {
		subPremise.unsetSubPremiseNumberPrefix();
	}

	public void unsetSubPremiseNumberSuffix() {
		subPremise.unsetSubPremiseNumberSuffix();
	}

	public void unsetType() {
		subPremise.setType(null);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		if (subPremise.isSetAddressLine())
			return subPremise.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	public boolean unsetBuildingName(BuildingName buildingName) {
		if (subPremise.isSetBuildingName())
			return subPremise.getBuildingName().remove(((BuildingNameImpl)buildingName).getJAXBObject());
		
		return false;
	}

	public boolean unsetSubPremiseName(SubPremiseName subPremiseName) {
		if (subPremise.isSetSubPremiseName())
			return subPremise.getSubPremiseName().remove(((SubPremiseNameImpl)subPremiseName).getJAXBObject());
		
		return false;
	}

	public boolean unsetSubPremiseNumber(SubPremiseNumber subPremiseNumber) {
		if (subPremise.isSetSubPremiseNumberPrefix())
			return subPremise.getSubPremiseNumberPrefix().remove(((SubPremiseNumberPrefixImpl)subPremiseNumber).getJAXBObject());
		
		return false;
	}

	public boolean unsetSubPremiseNumberPrefix(SubPremiseNumberPrefix subPremiseNumberPrefix) {
		if (subPremise.isSetSubPremiseNumberPrefix())
			return subPremise.getSubPremiseNumberPrefix().remove(((SubPremiseNumberPrefixImpl)subPremiseNumberPrefix).getJAXBObject());
		
		return false;
	}

	public boolean unsetSubPremiseNumberSuffix(SubPremiseNumberSuffix subPremiseNumberSuffix) {
		if (subPremise.isSetSubPremiseNumberSuffix())
			return subPremise.getSubPremiseNumberSuffix().remove(((SubPremiseNumberSuffixImpl)subPremiseNumberSuffix).getJAXBObject());
		
		return false;
	}

}
