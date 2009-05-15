package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.BuildingNameType;
import org.citygml4j.jaxb.xal.PremiseElement;
import org.citygml4j.jaxb.xal.PremiseNumberElement;
import org.citygml4j.jaxb.xal.PremiseNumberPrefixElement;
import org.citygml4j.jaxb.xal.PremiseNumberSuffixElement;
import org.citygml4j.jaxb.xal.SubPremiseType;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.BuildingName;
import org.citygml4j.model.xal.Firm;
import org.citygml4j.model.xal.MailStop;
import org.citygml4j.model.xal.PostalCode;
import org.citygml4j.model.xal.Premise;
import org.citygml4j.model.xal.PremiseLocation;
import org.citygml4j.model.xal.PremiseName;
import org.citygml4j.model.xal.PremiseNumber;
import org.citygml4j.model.xal.PremiseNumberPrefix;
import org.citygml4j.model.xal.PremiseNumberRange;
import org.citygml4j.model.xal.PremiseNumberSuffix;
import org.citygml4j.model.xal.SubPremise;
import org.citygml4j.model.xal.XALClass;

public class PremiseImpl extends XALBaseImpl implements Premise {
	private PremiseElement premise;

	public PremiseImpl() {
		premise = new PremiseElement();
	}

	public PremiseImpl(PremiseElement premise) {
		this.premise = premise;
	}

	@Override
	public PremiseElement getJAXBObject() {
		return premise;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.PREMISE;
	}

	public void addAddressLine(AddressLine addressLine) {
		premise.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	public void addBuildingName(BuildingName buildingName) {
		premise.getBuildingName().add(((BuildingNameImpl)buildingName).getJAXBObject());
	}

	public void addPremiseName(PremiseName premiseName) {
		premise.getPremiseName().add(((PremiseNameImpl)premiseName).getJAXBObject());
	}

	public void addPremiseNumber(PremiseNumber premiseNumber) {
		premise.getPremiseNumber().add(((PremiseNumberImpl)premiseNumber).getJAXBObject());
	}

	public void addPremiseNumberPrefix(PremiseNumberPrefix premiseNumberPrefix) {
		premise.getPremiseNumberPrefix().add(((PremiseNumberPrefixImpl)premiseNumberPrefix).getJAXBObject());
	}

	public void addPremiseNumberSuffix(PremiseNumberSuffix premiseNumberSuffix) {
		premise.getPremiseNumberSuffix().add(((PremiseNumberSuffixImpl)premiseNumberSuffix).getJAXBObject());
	}

	public void addSubPremise(SubPremise subPremise) {
		premise.getSubPremise().add(((SubPremiseImpl)subPremise).getJAXBObject());
	}

	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : premise.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	public List<BuildingName> getBuildingName() {
		List<BuildingName> buildingNameList = new ArrayList<BuildingName>();

		for (BuildingNameType buildingNameElem : premise.getBuildingName())
			buildingNameList.add(new BuildingNameImpl(buildingNameElem));

		return buildingNameList;
	}

	public Firm getFirm() {
		if (premise.isSetFirm())
			return new FirmImpl(premise.getFirm());

		return null;
	}

	public MailStop getMailStop() {
		if (premise.isSetMailStop())
			return new MailStopImpl(premise.getMailStop());

		return null;
	}

	public PostalCode getPostalCode() {
		if (premise.isSetPostalCode())
			return new PostalCodeImpl(premise.getPostalCode());

		return null;
	}

	public Premise getPremise() {
		if (premise.isSetPremise())
			return new PremiseImpl(premise.getPremise());

		return null;
	}

	public String getPremiseDependency() {
		return premise.getPremiseDependency();
	}

	public String getPremiseDependencyType() {
		return premise.getPremiseDependencyType();
	}

	public PremiseLocation getPremiseLocation() {
		if (premise.isSetPremiseLocation())
			return new PremiseLocationImpl(premise.getPremiseLocation());

		return null;
	}

	public List<PremiseName> getPremiseName() {
		List<PremiseName> premiseNameList = new ArrayList<PremiseName>();

		for (PremiseElement.PremiseName premiseNameElem : premise.getPremiseName())
			premiseNameList.add(new PremiseNameImpl(premiseNameElem));

		return premiseNameList;
	}

	public List<PremiseNumber> getPremiseNumber() {
		List<PremiseNumber> premiseNumberList = new ArrayList<PremiseNumber>();

		for (PremiseNumberElement premiseNumberElem : premise.getPremiseNumber())
			premiseNumberList.add(new PremiseNumberImpl(premiseNumberElem));

		return premiseNumberList;
	}

	public List<PremiseNumberPrefix> getPremiseNumberPrefix() {
		List<PremiseNumberPrefix> premiseNumberPrefixList = new ArrayList<PremiseNumberPrefix>();

		for (PremiseNumberPrefixElement premiseNumberPrefixElem : premise.getPremiseNumberPrefix())
			premiseNumberPrefixList.add(new PremiseNumberPrefixImpl(premiseNumberPrefixElem));

		return premiseNumberPrefixList;
	}

	public PremiseNumberRange getPremiseNumberRange() {
		if (premise.isSetPremiseNumberRange())
			return new PremiseNumberRangeImpl(premise.getPremiseNumberRange());

		return null;
	}

	public List<PremiseNumberSuffix> getPremiseNumberSuffix() {
		List<PremiseNumberSuffix> premiseNumberSuffixList = new ArrayList<PremiseNumberSuffix>();

		for (PremiseNumberSuffixElement premiseNumberSuffixElem : premise.getPremiseNumberSuffix())
			premiseNumberSuffixList.add(new PremiseNumberSuffixImpl(premiseNumberSuffixElem));

		return premiseNumberSuffixList;
	}

	public String getPremiseThoroughfareConnector() {
		return premise.getPremiseThoroughfareConnector();
	}

	public List<SubPremise> getSubPremise() {
		List<SubPremise> subPremiseList = new ArrayList<SubPremise>();

		for (SubPremiseType subPremiseElem : premise.getSubPremise())
			subPremiseList.add(new SubPremiseImpl(subPremiseElem));

		return subPremiseList;
	}

	public String getType() {
		return premise.getType();
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		premise.unsetAddressLine();
		premise.getAddressLine().addAll(addressLineElemList);
	}

	public void setBuildingName(List<BuildingName> buildingName) {
		List<BuildingNameType> buildingNameList = new ArrayList<BuildingNameType>();

		for (BuildingName buildingNameItem : buildingName)
			buildingNameList.add(((BuildingNameImpl)buildingNameItem).getJAXBObject());

		premise.unsetBuildingName();
		premise.getBuildingName().addAll(buildingNameList);
	}

	public void setFirm(Firm firm) {
		premise.setFirm(((FirmImpl)firm).getJAXBObject());
	}

	public void setMailStop(MailStop mailStop) {
		premise.setMailStop(((MailStopImpl)mailStop).getJAXBObject());
	}

	public void setPostalCode(PostalCode postalCode) {
		premise.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	public void setPremise(Premise premise) {
		this.premise.setPremise(((PremiseImpl)premise).getJAXBObject());
	}

	public void setPremiseDependency(String premiseDependency) {
		premise.setPremiseDependency(premiseDependency);
	}

	public void setPremiseDependencyType(String premiseDependencyType) {
		premise.setPremiseDependencyType(premiseDependencyType);
	}

	public void setPremiseLocation(PremiseLocation premiseLocation) {
		premise.setPremiseLocation(((PremiseLocationImpl)premiseLocation).getJAXBObject());
	}

	public void setPremiseName(List<PremiseName> premiseName) {
		List<PremiseElement.PremiseName> premiseNameList = new ArrayList<PremiseElement.PremiseName>();

		for (PremiseName premiseNameItem : premiseName)
			premiseNameList.add(((PremiseNameImpl)premiseNameItem).getJAXBObject());

		premise.unsetPremiseName();
		premise.getPremiseName().addAll(premiseNameList);
	}

	public void setPremiseNumber(List<PremiseNumber> premiseNumber) {
		List<PremiseNumberElement> premiseNumberList = new ArrayList<PremiseNumberElement>();

		for (PremiseNumber premiseNumberItem : premiseNumber)
			premiseNumberList.add(((PremiseNumberImpl)premiseNumberItem).getJAXBObject());

		premise.unsetPremiseNumber();
		premise.getPremiseNumber().addAll(premiseNumberList);
	}

	public void setPremiseNumberPrefix(List<PremiseNumberPrefix> premiseNumberPrefix) {
		List<PremiseNumberPrefixElement> premiseNumberPrefixList = new ArrayList<PremiseNumberPrefixElement>();

		for (PremiseNumberPrefix premiseNumberPrefixItem : premiseNumberPrefix)
			premiseNumberPrefixList.add(((PremiseNumberPrefixImpl)premiseNumberPrefixItem).getJAXBObject());

		premise.unsetPremiseNumberPrefix();
		premise.getPremiseNumberPrefix().addAll(premiseNumberPrefixList);
	}

	public void setPremiseNumberRange(PremiseNumberRange premiseNumberRange) {
		premise.setPremiseNumberRange(((PremiseNumberRangeImpl)premiseNumberRange).getJAXBObject());
	}

	public void setPremiseNumberSuffix(List<PremiseNumberSuffix> premiseNumberSuffix) {
		List<PremiseNumberSuffixElement> premiseNumberSuffixList = new ArrayList<PremiseNumberSuffixElement>();

		for (PremiseNumberSuffix premiseNumberSuffixItem : premiseNumberSuffix)
			premiseNumberSuffixList.add(((PremiseNumberSuffixImpl)premiseNumberSuffixItem).getJAXBObject());

		premise.unsetPremiseNumberSuffix();
		premise.getPremiseNumberSuffix().addAll(premiseNumberSuffixList);
	}

	public void setPremiseThoroughfareConnector(String premiseThoroughfareConnector) {
		premise.setPremiseThoroughfareConnector(premiseThoroughfareConnector);
	}

	public void setSubPremise(List<SubPremise> subPremise) {
		List<SubPremiseType> subPremiseElemList = new ArrayList<SubPremiseType>();

		for (SubPremise subPremiseItem : subPremise)
			subPremiseElemList.add(((SubPremiseImpl)subPremiseItem).getJAXBObject());

		premise.unsetSubPremise();
		premise.getSubPremise().addAll(subPremiseElemList);
	}

	public void setType(String type) {
		premise.setType(type);
	}

	public boolean isSetAddressLine() {
		return premise.isSetAddressLine();
	}

	public boolean isSetBuildingName() {
		return premise.isSetBuildingName();
	}

	public boolean isSetFirm() {
		return premise.isSetFirm();
	}

	public boolean isSetMailStop() {
		return premise.isSetMailStop();
	}

	public boolean isSetPostalCode() {
		return premise.isSetPostalCode();
	}

	public boolean isSetPremise() {
		return premise.isSetPremise();
	}

	public boolean isSetPremiseDependency() {
		return premise.isSetPremiseDependency();
	}

	public boolean isSetPremiseDependencyType() {
		return premise.isSetPremiseDependencyType();
	}

	public boolean isSetPremiseLocation() {
		return premise.isSetPremiseLocation();
	}

	public boolean isSetPremiseName() {
		return premise.isSetPremiseName();
	}

	public boolean isSetPremiseNumber() {
		return premise.isSetPremiseNumber();
	}

	public boolean isSetPremiseNumberPrefix() {
		return premise.isSetPremiseNumberPrefix();
	}

	public boolean isSetPremiseNumberRange() {
		return premise.isSetPremiseNumberRange();
	}

	public boolean isSetPremiseNumberSuffix() {
		return premise.isSetPremiseNumberSuffix();
	}

	public boolean isSetPremiseThoroughfareConnector() {
		return premise.isSetPremiseThoroughfareConnector();
	}

	public boolean isSetSubPremise() {
		return premise.isSetSubPremise();
	}

	public boolean isSetType() {
		return premise.isSetType();
	}

	public void unsetAddressLine() {
		premise.unsetAddressLine();
	}

	public void unsetBuildingName() {
		premise.unsetBuildingName();
	}

	public void unsetFirm() {
		premise.setFirm(null);
	}

	public void unsetMailStop() {
		premise.setMailStop(null);
	}

	public void unsetPostalCode() {
		premise.setPostalCode(null);
	}

	public void unsetPremise() {
		premise.setPremise(null);
	}

	public void unsetPremiseDependency() {
		premise.setPremiseDependency(null);
	}

	public void unsetPremiseDependencyType() {
		premise.setPremiseDependencyType(null);
	}

	public void unsetPremiseLocation() {
		premise.setPremiseLocation(null);
	}

	public void unsetPremiseName() {
		premise.unsetPremiseName();
	}

	public void unsetPremiseNumber() {
		premise.unsetPremiseNumber();
	}

	public void unsetPremiseNumberPrefix() {
		premise.unsetPremiseNumberPrefix();
	}

	public void unsetPremiseNumberRange() {
		premise.setPremiseNumberRange(null);
	}

	public void unsetPremiseNumberSuffix() {
		premise.unsetPremiseNumberSuffix();
	}

	public void unsetPremiseThoroughfareConnector() {
		premise.setPremiseThoroughfareConnector(null);
	}

	public void unsetSubPremise() {
		premise.unsetSubPremise();
	}

	public void unsetType() {
		premise.setType(null);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		if (premise.isSetAddressLine())
			return premise.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	public boolean unsetBuildingName(BuildingName buildingName) {
		if (premise.isSetBuildingName())
			return premise.getBuildingName().remove(((BuildingNameImpl)buildingName).getJAXBObject());
		
		return false;
	}

	public boolean unsetPremiseName(PremiseName premiseName) {
		if (premise.isSetPremiseName())
			return premise.getPremiseName().remove(((PremiseNameImpl)premiseName).getJAXBObject());
		
		return false;
	}

	public boolean unsetPremiseNumber(PremiseNumber premiseNumber) {
		if (premise.isSetPremiseNumber())
			return premise.getPremiseNumber().remove(((PremiseNumberImpl)premiseNumber).getJAXBObject());
		
		return false;
	}

	public boolean unsetPremiseNumberPrefix(PremiseNumberPrefix premiseNumberPrefix) {
		if (premise.isSetPremiseNumberPrefix())
			return premise.getPremiseNumberPrefix().remove(((PremiseNumberPrefixImpl)premiseNumberPrefix).getJAXBObject());
		
		return false;
	}

	public boolean unsetPremiseNumberSuffix(PremiseNumberSuffix premiseNumberSuffix) {
		if (premise.isSetPremiseNumberSuffix())
			return premise.getPremiseNumberSuffix().remove(((PremiseNumberSuffixImpl)premiseNumberSuffix).getJAXBObject());
		
		return false;
	}

	public boolean unsetSubPremise(SubPremise subPremise) {
		if (premise.isSetSubPremise())
			return premise.getSubPremise().remove(((SubPremiseImpl)subPremise).getJAXBObject());
		
		return false;
	}

}
