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

	@Override
	public void addAddressLine(AddressLine addressLine) {
		subPremise.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public void addBuildingName(BuildingName buildingName) {
		subPremise.getBuildingName().add(((BuildingNameImpl)buildingName).getJAXBObject());
	}

	@Override
	public void addSubPremiseName(SubPremiseName subPremiseName) {
		subPremise.getSubPremiseName().add(((SubPremiseNameImpl)subPremiseName).getJAXBObject());
	}

	@Override
	public void addSubPremiseNumber(SubPremiseNumber subPremiseNumber) {
		subPremise.getSubPremiseNumber().add(((SubPremiseNumberImpl)subPremiseNumber).getJAXBObject());
	}

	@Override
	public void addSubPremiseNumberPrefix(SubPremiseNumberPrefix subPremiseNumberPrefix) {
		subPremise.getSubPremiseNumberPrefix().add(((SubPremiseNumberPrefixImpl)subPremiseNumberPrefix).getJAXBObject());
	}

	@Override
	public void addSubPremiseNumberSuffix(SubPremiseNumberSuffix subPremiseNumberSuffix) {
		subPremise.getSubPremiseNumberSuffix().add(((SubPremiseNumberSuffixImpl)subPremiseNumberSuffix).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : subPremise.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	@Override
	public List<BuildingName> getBuildingName() {
		List<BuildingName> buildingNameList = new ArrayList<BuildingName>();

		for (BuildingNameType buildingNameElem : subPremise.getBuildingName())
			buildingNameList.add(new BuildingNameImpl(buildingNameElem));

		return buildingNameList;
	}

	@Override
	public Firm getFirm() {
		if (subPremise.isSetFirm())
			return new FirmImpl(subPremise.getFirm());

		return null;
	}

	@Override
	public MailStop getMailStop() {
		if (subPremise.isSetMailStop())
			return new MailStopImpl(subPremise.getMailStop());

		return null;
	}

	@Override
	public PostalCode getPostalCode() {
		if (subPremise.isSetPostalCode())
			return new PostalCodeImpl(subPremise.getPostalCode());

		return null;
	}

	@Override
	public SubPremise getSubPremise() {
		if (subPremise.isSetSubPremise())
			return new SubPremiseImpl(subPremise.getSubPremise());

		return null;
	}

	@Override
	public SubPremiseLocation getSubPremiseLocation() {
		if (subPremise.isSetSubPremiseLocation())
			return new SubPremiseLocationImpl(subPremise.getSubPremiseLocation());

		return null;
	}

	@Override
	public List<SubPremiseName> getSubPremiseName() {
		List<SubPremiseName> subPremiseNameList = new ArrayList<SubPremiseName>();

		for (SubPremiseType.SubPremiseName subPremiseNameElem : subPremise.getSubPremiseName())
			subPremiseNameList.add(new SubPremiseNameImpl(subPremiseNameElem));

		return subPremiseNameList;
	}

	@Override
	public List<SubPremiseNumber> getSubPremiseNumber() {
		List<SubPremiseNumber> subPremiseNumberList = new ArrayList<SubPremiseNumber>();

		for (SubPremiseType.SubPremiseNumber subPremiseNumberElem : subPremise.getSubPremiseNumber())
			subPremiseNumberList.add(new SubPremiseNumberImpl(subPremiseNumberElem));

		return subPremiseNumberList;
	}

	@Override
	public List<SubPremiseNumberPrefix> getSubPremiseNumberPrefix() {
		List<SubPremiseNumberPrefix> subPremiseNumberPrefixList = new ArrayList<SubPremiseNumberPrefix>();

		for (SubPremiseType.SubPremiseNumberPrefix subPremiseNumberPrefixElem : subPremise.getSubPremiseNumberPrefix())
			subPremiseNumberPrefixList.add(new SubPremiseNumberPrefixImpl(subPremiseNumberPrefixElem));

		return subPremiseNumberPrefixList;
	}

	@Override
	public List<SubPremiseNumberSuffix> getSubPremiseNumberSuffix() {
		List<SubPremiseNumberSuffix> subPremiseNumberSuffixList = new ArrayList<SubPremiseNumberSuffix>();

		for (SubPremiseType.SubPremiseNumberSuffix subPremiseNumberSuffixElem : subPremise.getSubPremiseNumberSuffix())
			subPremiseNumberSuffixList.add(new SubPremiseNumberSuffixImpl(subPremiseNumberSuffixElem));

		return subPremiseNumberSuffixList;
	}

	@Override
	public String getType() {
		return subPremise.getType();
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		subPremise.unsetAddressLine();
		subPremise.getAddressLine().addAll(addressLineElemList);
	}

	@Override
	public void setBuildingName(List<BuildingName> buildingName) {
		List<BuildingNameType> buildingNameList = new ArrayList<BuildingNameType>();

		for (BuildingName buildingNameItem : buildingName)
			buildingNameList.add(((BuildingNameImpl)buildingNameItem).getJAXBObject());

		subPremise.unsetBuildingName();
		subPremise.getBuildingName().addAll(buildingNameList);
	}

	@Override
	public void setFirm(Firm firm) {
		subPremise.setFirm(((FirmImpl)firm).getJAXBObject());
	}

	@Override
	public void setMailStop(MailStop mailStop) {
		subPremise.setMailStop(((MailStopImpl)mailStop).getJAXBObject());
	}

	@Override
	public void setPostalCode(PostalCode postalCode) {
		subPremise.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	@Override
	public void setSubPremise(SubPremise subPremise) {
		this.subPremise.setSubPremise(((SubPremiseImpl)subPremise).getJAXBObject());
	}

	@Override
	public void setSubPremiseLocation(SubPremiseLocation subPremiseLocation) {
		subPremise.setSubPremiseLocation(((SubPremiseLocationImpl)subPremiseLocation).getJAXBObject());
	}

	@Override
	public void setSubPremiseName(List<SubPremiseName> subPremiseName) {
		List<SubPremiseType.SubPremiseName> subPremiseNameList = new ArrayList<SubPremiseType.SubPremiseName>();

		for (SubPremiseName subPremiseNameItem : subPremiseName)
			subPremiseNameList.add(((SubPremiseNameImpl)subPremiseNameItem).getJAXBObject());

		subPremise.unsetSubPremiseName();
		subPremise.getSubPremiseName().addAll(subPremiseNameList);
	}

	@Override
	public void setSubPremiseNumber(List<SubPremiseNumber> subPremiseNumber) {
		List<SubPremiseType.SubPremiseNumber> subPremiseNumberList = new ArrayList<SubPremiseType.SubPremiseNumber>();

		for (SubPremiseNumber subPremiseNumberItem : subPremiseNumber)
			subPremiseNumberList.add(((SubPremiseNumberImpl)subPremiseNumberItem).getJAXBObject());

		subPremise.unsetSubPremiseNumber();
		subPremise.getSubPremiseNumber().addAll(subPremiseNumberList);
	}

	@Override
	public void setSubPremiseNumberPrefix(List<SubPremiseNumberPrefix> subPremiseNumberPrefix) {
		List<SubPremiseType.SubPremiseNumberPrefix> subPremiseNumberPrefixList = new ArrayList<SubPremiseType.SubPremiseNumberPrefix>();

		for (SubPremiseNumberPrefix subPremiseNumberPrefixItem : subPremiseNumberPrefix)
			subPremiseNumberPrefixList.add(((SubPremiseNumberPrefixImpl)subPremiseNumberPrefixItem).getJAXBObject());

		subPremise.unsetSubPremiseNumberPrefix();
		subPremise.getSubPremiseNumberPrefix().addAll(subPremiseNumberPrefixList);
	}

	@Override
	public void setSubPremiseNumberSuffix(List<SubPremiseNumberSuffix> subPremiseNumberSuffix) {
		List<SubPremiseType.SubPremiseNumberSuffix> subPremiseNumberSuffixList = new ArrayList<SubPremiseType.SubPremiseNumberSuffix>();

		for (SubPremiseNumberSuffix subPremiseNumberSuffixItem : subPremiseNumberSuffix)
			subPremiseNumberSuffixList.add(((SubPremiseNumberSuffixImpl)subPremiseNumberSuffixItem).getJAXBObject());

		subPremise.unsetSubPremiseNumberSuffix();
		subPremise.getSubPremiseNumberSuffix().addAll(subPremiseNumberSuffixList);
	}

	@Override
	public void setType(String type) {
		subPremise.setType(type);
	}

	@Override
	public boolean isSetAddressLine() {
		return subPremise.isSetAddressLine();
	}

	@Override
	public boolean isSetBuildingName() {
		return subPremise.isSetBuildingName();
	}

	@Override
	public boolean isSetFirm() {
		return subPremise.isSetFirm();
	}

	@Override
	public boolean isSetMailStop() {
		return subPremise.isSetMailStop();
	}

	@Override
	public boolean isSetPostalCode() {
		return subPremise.isSetPostalCode();
	}

	@Override
	public boolean isSetSubPremise() {
		return subPremise.isSetSubPremise();
	}

	@Override
	public boolean isSetSubPremiseLocation() {
		return subPremise.isSetSubPremiseLocation();
	}

	@Override
	public boolean isSetSubPremiseName() {
		return subPremise.isSetSubPremiseName();
	}

	@Override
	public boolean isSetSubPremiseNumber() {
		return subPremise.isSetSubPremiseNumber();
	}

	@Override
	public boolean isSetSubPremiseNumberPrefix() {
		return subPremise.isSetSubPremiseNumberPrefix();
	}

	@Override
	public boolean isSetSubPremiseNumberSuffix() {
		return subPremise.isSetSubPremiseNumberSuffix();
	}

	@Override
	public boolean isSetType() {
		return subPremise.isSetType();
	}

	@Override
	public void unsetAddressLine() {
		subPremise.unsetAddressLine();
	}

	@Override
	public void unsetBuildingName() {
		subPremise.unsetBuildingName();
	}

	@Override
	public void unsetFirm() {
		subPremise.setFirm(null);
	}

	@Override
	public void unsetMailStop() {
		subPremise.setMailStop(null);
	}

	@Override
	public void unsetPostalCode() {
		subPremise.setPostalCode(null);
	}

	@Override
	public void unsetSubPremise() {
		subPremise.setSubPremise(null);
	}

	@Override
	public void unsetSubPremiseLocation() {
		subPremise.setSubPremiseLocation(null);
	}

	@Override
	public void unsetSubPremiseName() {
		subPremise.unsetSubPremiseName();
	}

	@Override
	public void unsetSubPremiseNumber() {
		subPremise.unsetSubPremiseNumber();
	}

	@Override
	public void unsetSubPremiseNumberPrefix() {
		subPremise.unsetSubPremiseNumberPrefix();
	}

	@Override
	public void unsetSubPremiseNumberSuffix() {
		subPremise.unsetSubPremiseNumberSuffix();
	}

	@Override
	public void unsetType() {
		subPremise.setType(null);
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (subPremise.isSetAddressLine())
			return subPremise.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetBuildingName(BuildingName buildingName) {
		if (subPremise.isSetBuildingName())
			return subPremise.getBuildingName().remove(((BuildingNameImpl)buildingName).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetSubPremiseName(SubPremiseName subPremiseName) {
		if (subPremise.isSetSubPremiseName())
			return subPremise.getSubPremiseName().remove(((SubPremiseNameImpl)subPremiseName).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetSubPremiseNumber(SubPremiseNumber subPremiseNumber) {
		if (subPremise.isSetSubPremiseNumberPrefix())
			return subPremise.getSubPremiseNumberPrefix().remove(((SubPremiseNumberPrefixImpl)subPremiseNumber).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetSubPremiseNumberPrefix(SubPremiseNumberPrefix subPremiseNumberPrefix) {
		if (subPremise.isSetSubPremiseNumberPrefix())
			return subPremise.getSubPremiseNumberPrefix().remove(((SubPremiseNumberPrefixImpl)subPremiseNumberPrefix).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetSubPremiseNumberSuffix(SubPremiseNumberSuffix subPremiseNumberSuffix) {
		if (subPremise.isSetSubPremiseNumberSuffix())
			return subPremise.getSubPremiseNumberSuffix().remove(((SubPremiseNumberSuffixImpl)subPremiseNumberSuffix).getJAXBObject());
		
		return false;
	}

}
