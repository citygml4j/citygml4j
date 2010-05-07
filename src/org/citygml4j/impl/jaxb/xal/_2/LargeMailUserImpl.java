package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.BuildingNameType;
import org.citygml4j.jaxb.xal.LargeMailUserType;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.BuildingName;
import org.citygml4j.model.xal.Department;
import org.citygml4j.model.xal.LargeMailUser;
import org.citygml4j.model.xal.LargeMailUserIdentifier;
import org.citygml4j.model.xal.LargeMailUserName;
import org.citygml4j.model.xal.PostBox;
import org.citygml4j.model.xal.PostalCode;
import org.citygml4j.model.xal.Thoroughfare;
import org.citygml4j.model.xal.XALClass;

public class LargeMailUserImpl extends XALBaseImpl implements LargeMailUser {
	private LargeMailUserType largeMailUser;

	public LargeMailUserImpl() {
		largeMailUser = new LargeMailUserType();
	}

	public LargeMailUserImpl(LargeMailUserType largeMailUser) {
		this.largeMailUser = largeMailUser;
	}

	@Override
	public LargeMailUserType getJAXBObject() {
		return largeMailUser;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.LARGEMAILUSER;
	}

	public void addAddressLine(AddressLine addressLine) {
		largeMailUser.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	public void addBuildingName(BuildingName buildingName) {
		largeMailUser.getBuildingName().add(((BuildingNameImpl)buildingName).getJAXBObject());
	}

	public void addLargeMailUserName(LargeMailUserName largeMailUserName) {
		largeMailUser.getLargeMailUserName().add(((LargeMailUserNameImpl)largeMailUserName).getJAXBObject());
	}

	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : largeMailUser.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	public List<BuildingName> getBuildingName() {
		List<BuildingName> buildingNameList = new ArrayList<BuildingName>();

		for (BuildingNameType buildingNameElem : largeMailUser.getBuildingName())
			buildingNameList.add(new BuildingNameImpl(buildingNameElem));

		return buildingNameList;
	}

	public Department getDepartment() {
		if (largeMailUser.isSetDepartment())
			return new DepartmentImpl(largeMailUser.getDepartment());

		return null;
	}

	public LargeMailUserIdentifier getLargeMailUserIdentifier() {
		if (largeMailUser.isSetLargeMailUserIdentifier())
			return new LargeMailUserIdentifierImpl(largeMailUser.getLargeMailUserIdentifier());

		return null;
	}

	public List<LargeMailUserName> getLargeMailUserName() {
		List<LargeMailUserName> largeMailUserNameList = new ArrayList<LargeMailUserName>();

		for (LargeMailUserType.LargeMailUserName largeMailUserNameElem : largeMailUser.getLargeMailUserName())
			largeMailUserNameList.add(new LargeMailUserNameImpl(largeMailUserNameElem));

		return largeMailUserNameList;
	}

	public PostBox getPostBox() {
		if (largeMailUser.isSetPostBox())
			return new PostBoxImpl(largeMailUser.getPostBox());

		return null;
	}

	public PostalCode getPostalCode() {
		if (largeMailUser.isSetPostalCode())
			return new PostalCodeImpl(largeMailUser.getPostalCode());

		return null;
	}

	public String getType() {
		return largeMailUser.getType();
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		largeMailUser.unsetAddressLine();
		largeMailUser.getAddressLine().addAll(addressLineElemList);
	}

	public void setBuildingName(List<BuildingName> buildingName) {
		List<BuildingNameType> buildingNameList = new ArrayList<BuildingNameType>();

		for (BuildingName buildingNameItem : buildingName)
			buildingNameList.add(((BuildingNameImpl)buildingNameItem).getJAXBObject());

		largeMailUser.unsetBuildingName();
		largeMailUser.getBuildingName().addAll(buildingNameList);
	}

	public void setDepartment(Department department) {
		largeMailUser.setDepartment(((DepartmentImpl)department).getJAXBObject());
	}

	public void setLargeMailUserIdentifier(LargeMailUserIdentifier largeMailUserIdentifier) {
		largeMailUser.setLargeMailUserIdentifier(((LargeMailUserIdentifierImpl)largeMailUserIdentifier).getJAXBObject());
	}

	public void setLargeMailUserName(List<LargeMailUserName> largeMailUserName) {
		List<LargeMailUserType.LargeMailUserName> largeMailUserNameList = new ArrayList<LargeMailUserType.LargeMailUserName>();

		for (LargeMailUserName largeMailUserNameItem : largeMailUserName)
			largeMailUserNameList.add(((LargeMailUserNameImpl)largeMailUserNameItem).getJAXBObject());

		largeMailUser.unsetLargeMailUserName();
		largeMailUser.getLargeMailUserName().addAll(largeMailUserNameList);
	}

	public void setPostBox(PostBox postBox) {
		largeMailUser.setPostBox(((PostBoxImpl)postBox).getJAXBObject());
	}

	public void setPostalCode(PostalCode postalCode) {
		largeMailUser.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	public void setType(String type) {
		largeMailUser.setType(type);
	}

	public Thoroughfare getThoroughfare() {
		if (largeMailUser.isSetThoroughfare())
			return new ThoroughfareImpl(largeMailUser.getThoroughfare());

		return null;
	}

	public void setThoroughfare(Thoroughfare thoroughfare) {
		largeMailUser.setThoroughfare(((ThoroughfareImpl)thoroughfare).getJAXBObject());
	}

	public boolean isSetAddressLine() {
		return largeMailUser.isSetAddressLine();
	}

	public boolean isSetBuildingName() {
		return largeMailUser.isSetBuildingName();
	}

	public boolean isSetDepartment() {
		return largeMailUser.isSetDepartment();
	}

	public boolean isSetLargeMailUserIdentifier() {
		return largeMailUser.isSetLargeMailUserIdentifier();
	}

	public boolean isSetLargeMailUserName() {
		return largeMailUser.isSetLargeMailUserName();
	}

	public boolean isSetPostalCode() {
		return largeMailUser.isSetPostalCode();
	}

	public boolean isSetPostBox() {
		return largeMailUser.isSetPostBox();
	}

	public boolean isSetThoroughfare() {
		return largeMailUser.isSetThoroughfare();
	}

	public boolean isSetType() {
		return largeMailUser.isSetType();
	}

	public void unsetAddressLine() {
		largeMailUser.unsetAddressLine();
	}

	public void unsetBuildingName() {
		largeMailUser.unsetBuildingName();
	}

	public void unsetDepartment() {
		largeMailUser.setDepartment(null);
	}

	public void unsetLargeMailUserIdentifier() {
		largeMailUser.setLargeMailUserIdentifier(null);
	}

	public void unsetLargeMailUserName() {
		largeMailUser.unsetLargeMailUserName();
	}

	public void unsetPostalCode() {
		largeMailUser.setPostalCode(null);
	}

	public void unsetPostBox() {
		largeMailUser.setPostBox(null);
	}

	public void unsetThoroughfare() {
		largeMailUser.setThoroughfare(null);
	}

	public void unsetType() {
		largeMailUser.setType(null);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		if (largeMailUser.isSetAddressLine())
			return largeMailUser.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	public boolean unsetBuildingName(BuildingName buildingName) {
		if (largeMailUser.isSetBuildingName())
			return largeMailUser.getBuildingName().remove(((BuildingNameImpl)buildingName).getJAXBObject());
		
		return false;
	}

	public boolean unsetLargeMailUserName(LargeMailUserName largeMailUserName) {
		if (largeMailUser.isSetLargeMailUserName())
			return largeMailUser.getLargeMailUserName().remove(((LargeMailUserNameImpl)largeMailUserName).getJAXBObject());
		
		return false;
	}

}
