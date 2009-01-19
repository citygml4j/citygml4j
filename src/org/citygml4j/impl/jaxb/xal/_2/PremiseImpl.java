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

	@Override
	public void addAddressLine(AddressLine addressLine) {
		premise.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public void addBuildingName(BuildingName buildingName) {
		premise.getBuildingName().add(((BuildingNameImpl)buildingName).getJAXBObject());
	}

	@Override
	public void addPremiseName(PremiseName premiseName) {
		premise.getPremiseName().add(((PremiseNameImpl)premiseName).getJAXBObject());
	}

	@Override
	public void addPremiseNumber(PremiseNumber premiseNumber) {
		premise.getPremiseNumber().add(((PremiseNumberImpl)premiseNumber).getJAXBObject());
	}

	@Override
	public void addPremiseNumberPrefix(PremiseNumberPrefix premiseNumberPrefix) {
		premise.getPremiseNumberPrefix().add(((PremiseNumberPrefixImpl)premiseNumberPrefix).getJAXBObject());
	}

	@Override
	public void addPremiseNumberSuffix(PremiseNumberSuffix premiseNumberSuffix) {
		premise.getPremiseNumberSuffix().add(((PremiseNumberSuffixImpl)premiseNumberSuffix).getJAXBObject());
	}

	@Override
	public void addSubPremise(SubPremise subPremise) {
		premise.getSubPremise().add(((SubPremiseImpl)subPremise).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : premise.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	@Override
	public List<BuildingName> getBuildingName() {
		List<BuildingName> buildingNameList = new ArrayList<BuildingName>();

		for (BuildingNameType buildingNameElem : premise.getBuildingName())
			buildingNameList.add(new BuildingNameImpl(buildingNameElem));

		return buildingNameList;
	}

	@Override
	public Firm getFirm() {
		if (premise.isSetFirm())
			return new FirmImpl(premise.getFirm());

		return null;
	}

	@Override
	public MailStop getMailStop() {
		if (premise.isSetMailStop())
			return new MailStopImpl(premise.getMailStop());

		return null;
	}

	@Override
	public PostalCode getPostalCode() {
		if (premise.isSetPostalCode())
			return new PostalCodeImpl(premise.getPostalCode());

		return null;
	}

	@Override
	public Premise getPremise() {
		if (premise.isSetPremise())
			return new PremiseImpl(premise.getPremise());

		return null;
	}

	@Override
	public String getPremiseDependency() {
		return premise.getPremiseDependency();
	}

	@Override
	public String getPremiseDependencyType() {
		return premise.getPremiseDependencyType();
	}

	@Override
	public PremiseLocation getPremiseLocation() {
		if (premise.isSetPremiseLocation())
			return new PremiseLocationImpl(premise.getPremiseLocation());

		return null;
	}

	@Override
	public List<PremiseName> getPremiseName() {
		List<PremiseName> premiseNameList = new ArrayList<PremiseName>();

		for (PremiseElement.PremiseName premiseNameElem : premise.getPremiseName())
			premiseNameList.add(new PremiseNameImpl(premiseNameElem));

		return premiseNameList;
	}

	@Override
	public List<PremiseNumber> getPremiseNumber() {
		List<PremiseNumber> premiseNumberList = new ArrayList<PremiseNumber>();

		for (PremiseNumberElement premiseNumberElem : premise.getPremiseNumber())
			premiseNumberList.add(new PremiseNumberImpl(premiseNumberElem));

		return premiseNumberList;
	}

	@Override
	public List<PremiseNumberPrefix> getPremiseNumberPrefix() {
		List<PremiseNumberPrefix> premiseNumberPrefixList = new ArrayList<PremiseNumberPrefix>();

		for (PremiseNumberPrefixElement premiseNumberPrefixElem : premise.getPremiseNumberPrefix())
			premiseNumberPrefixList.add(new PremiseNumberPrefixImpl(premiseNumberPrefixElem));

		return premiseNumberPrefixList;
	}

	@Override
	public PremiseNumberRange getPremiseNumberRange() {
		if (premise.isSetPremiseNumberRange())
			return new PremiseNumberRangeImpl(premise.getPremiseNumberRange());

		return null;
	}

	@Override
	public List<PremiseNumberSuffix> getPremiseNumberSuffix() {
		List<PremiseNumberSuffix> premiseNumberSuffixList = new ArrayList<PremiseNumberSuffix>();

		for (PremiseNumberSuffixElement premiseNumberSuffixElem : premise.getPremiseNumberSuffix())
			premiseNumberSuffixList.add(new PremiseNumberSuffixImpl(premiseNumberSuffixElem));

		return premiseNumberSuffixList;
	}

	@Override
	public String getPremiseThoroughfareConnector() {
		return premise.getPremiseThoroughfareConnector();
	}

	@Override
	public List<SubPremise> getSubPremise() {
		List<SubPremise> subPremiseList = new ArrayList<SubPremise>();

		for (SubPremiseType subPremiseElem : premise.getSubPremise())
			subPremiseList.add(new SubPremiseImpl(subPremiseElem));

		return subPremiseList;
	}

	@Override
	public String getType() {
		return premise.getType();
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		premise.unsetAddressLine();
		premise.getAddressLine().addAll(addressLineElemList);
	}

	@Override
	public void setBuildingName(List<BuildingName> buildingName) {
		List<BuildingNameType> buildingNameList = new ArrayList<BuildingNameType>();

		for (BuildingName buildingNameItem : buildingName)
			buildingNameList.add(((BuildingNameImpl)buildingNameItem).getJAXBObject());

		premise.unsetBuildingName();
		premise.getBuildingName().addAll(buildingNameList);
	}

	@Override
	public void setFirm(Firm firm) {
		premise.setFirm(((FirmImpl)firm).getJAXBObject());
	}

	@Override
	public void setMailStop(MailStop mailStop) {
		premise.setMailStop(((MailStopImpl)mailStop).getJAXBObject());
	}

	@Override
	public void setPostalCode(PostalCode postalCode) {
		premise.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	@Override
	public void setPremise(Premise premise) {
		this.premise.setPremise(((PremiseImpl)premise).getJAXBObject());
	}

	@Override
	public void setPremiseDependency(String premiseDependency) {
		premise.setPremiseDependency(premiseDependency);
	}

	@Override
	public void setPremiseDependencyType(String premiseDependencyType) {
		premise.setPremiseDependencyType(premiseDependencyType);
	}

	@Override
	public void setPremiseLocation(PremiseLocation premiseLocation) {
		premise.setPremiseLocation(((PremiseLocationImpl)premiseLocation).getJAXBObject());
	}

	@Override
	public void setPremiseName(List<PremiseName> premiseName) {
		List<PremiseElement.PremiseName> premiseNameList = new ArrayList<PremiseElement.PremiseName>();

		for (PremiseName premiseNameItem : premiseName)
			premiseNameList.add(((PremiseNameImpl)premiseNameItem).getJAXBObject());

		premise.unsetPremiseName();
		premise.getPremiseName().addAll(premiseNameList);
	}

	@Override
	public void setPremiseNumber(List<PremiseNumber> premiseNumber) {
		List<PremiseNumberElement> premiseNumberList = new ArrayList<PremiseNumberElement>();

		for (PremiseNumber premiseNumberItem : premiseNumber)
			premiseNumberList.add(((PremiseNumberImpl)premiseNumberItem).getJAXBObject());

		premise.unsetPremiseNumber();
		premise.getPremiseNumber().addAll(premiseNumberList);
	}

	@Override
	public void setPremiseNumberPrefix(List<PremiseNumberPrefix> premiseNumberPrefix) {
		List<PremiseNumberPrefixElement> premiseNumberPrefixList = new ArrayList<PremiseNumberPrefixElement>();

		for (PremiseNumberPrefix premiseNumberPrefixItem : premiseNumberPrefix)
			premiseNumberPrefixList.add(((PremiseNumberPrefixImpl)premiseNumberPrefixItem).getJAXBObject());

		premise.unsetPremiseNumberPrefix();
		premise.getPremiseNumberPrefix().addAll(premiseNumberPrefixList);
	}

	@Override
	public void setPremiseNumberRange(PremiseNumberRange premiseNumberRange) {
		premise.setPremiseNumberRange(((PremiseNumberRangeImpl)premiseNumberRange).getJAXBObject());
	}

	@Override
	public void setPremiseNumberSuffix(List<PremiseNumberSuffix> premiseNumberSuffix) {
		List<PremiseNumberSuffixElement> premiseNumberSuffixList = new ArrayList<PremiseNumberSuffixElement>();

		for (PremiseNumberSuffix premiseNumberSuffixItem : premiseNumberSuffix)
			premiseNumberSuffixList.add(((PremiseNumberSuffixImpl)premiseNumberSuffixItem).getJAXBObject());

		premise.unsetPremiseNumberSuffix();
		premise.getPremiseNumberSuffix().addAll(premiseNumberSuffixList);
	}

	@Override
	public void setPremiseThoroughfareConnector(String premiseThoroughfareConnector) {
		premise.setPremiseThoroughfareConnector(premiseThoroughfareConnector);
	}

	@Override
	public void setSubPremise(List<SubPremise> subPremise) {
		List<SubPremiseType> subPremiseElemList = new ArrayList<SubPremiseType>();

		for (SubPremise subPremiseItem : subPremise)
			subPremiseElemList.add(((SubPremiseImpl)subPremiseItem).getJAXBObject());

		premise.unsetSubPremise();
		premise.getSubPremise().addAll(subPremiseElemList);
	}

	@Override
	public void setType(String type) {
		premise.setType(type);
	}

	@Override
	public boolean isSetAddressLine() {
		return premise.isSetAddressLine();
	}

	@Override
	public boolean isSetBuildingName() {
		return premise.isSetBuildingName();
	}

	@Override
	public boolean isSetFirm() {
		return premise.isSetFirm();
	}

	@Override
	public boolean isSetMailStop() {
		return premise.isSetMailStop();
	}

	@Override
	public boolean isSetPostalCode() {
		return premise.isSetPostalCode();
	}

	@Override
	public boolean isSetPremise() {
		return premise.isSetPremise();
	}

	@Override
	public boolean isSetPremiseDependency() {
		return premise.isSetPremiseDependency();
	}

	@Override
	public boolean isSetPremiseDependencyType() {
		return premise.isSetPremiseDependencyType();
	}

	@Override
	public boolean isSetPremiseLocation() {
		return premise.isSetPremiseLocation();
	}

	@Override
	public boolean isSetPremiseName() {
		return premise.isSetPremiseName();
	}

	@Override
	public boolean isSetPremiseNumber() {
		return premise.isSetPremiseNumber();
	}

	@Override
	public boolean isSetPremiseNumberPrefix() {
		return premise.isSetPremiseNumberPrefix();
	}

	@Override
	public boolean isSetPremiseNumberRange() {
		return premise.isSetPremiseNumberRange();
	}

	@Override
	public boolean isSetPremiseNumberSuffix() {
		return premise.isSetPremiseNumberSuffix();
	}

	@Override
	public boolean isSetPremiseThoroughfareConnector() {
		return premise.isSetPremiseThoroughfareConnector();
	}

	@Override
	public boolean isSetSubPremise() {
		return premise.isSetSubPremise();
	}

	@Override
	public boolean isSetType() {
		return premise.isSetType();
	}

	@Override
	public void unsetAddressLine() {
		premise.unsetAddressLine();
	}

	@Override
	public void unsetBuildingName() {
		premise.unsetBuildingName();
	}

	@Override
	public void unsetFirm() {
		premise.setFirm(null);
	}

	@Override
	public void unsetMailStop() {
		premise.setMailStop(null);
	}

	@Override
	public void unsetPostalCode() {
		premise.setPostalCode(null);
	}

	@Override
	public void unsetPremise() {
		premise.setPremise(null);
	}

	@Override
	public void unsetPremiseDependency() {
		premise.setPremiseDependency(null);
	}

	@Override
	public void unsetPremiseDependencyType() {
		premise.setPremiseDependencyType(null);
	}

	@Override
	public void unsetPremiseLocation() {
		premise.setPremiseLocation(null);
	}

	@Override
	public void unsetPremiseName() {
		premise.unsetPremiseName();
	}

	@Override
	public void unsetPremiseNumber() {
		premise.unsetPremiseNumber();
	}

	@Override
	public void unsetPremiseNumberPrefix() {
		premise.unsetPremiseNumberPrefix();
	}

	@Override
	public void unsetPremiseNumberRange() {
		premise.setPremiseNumberRange(null);
	}

	@Override
	public void unsetPremiseNumberSuffix() {
		premise.unsetPremiseNumberSuffix();
	}

	@Override
	public void unsetPremiseThoroughfareConnector() {
		premise.setPremiseThoroughfareConnector(null);
	}

	@Override
	public void unsetSubPremise() {
		premise.unsetSubPremise();
	}

	@Override
	public void unsetType() {
		premise.setType(null);
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (premise.isSetAddressLine())
			return premise.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetBuildingName(BuildingName buildingName) {
		if (premise.isSetBuildingName())
			return premise.getBuildingName().remove(((BuildingNameImpl)buildingName).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetPremiseName(PremiseName premiseName) {
		if (premise.isSetPremiseName())
			return premise.getPremiseName().remove(((PremiseNameImpl)premiseName).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetPremiseNumber(PremiseNumber premiseNumber) {
		if (premise.isSetPremiseNumber())
			return premise.getPremiseNumber().remove(((PremiseNumberImpl)premiseNumber).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetPremiseNumberPrefix(PremiseNumberPrefix premiseNumberPrefix) {
		if (premise.isSetPremiseNumberPrefix())
			return premise.getPremiseNumberPrefix().remove(((PremiseNumberPrefixImpl)premiseNumberPrefix).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetPremiseNumberSuffix(PremiseNumberSuffix premiseNumberSuffix) {
		if (premise.isSetPremiseNumberSuffix())
			return premise.getPremiseNumberSuffix().remove(((PremiseNumberSuffixImpl)premiseNumberSuffix).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetSubPremise(SubPremise subPremise) {
		if (premise.isSetSubPremise())
			return premise.getSubPremise().remove(((SubPremiseImpl)subPremise).getJAXBObject());
		
		return false;
	}

}
