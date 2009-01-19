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

	@Override
	public void addAddressLine(AddressLine addressLine) {
		largeMailUser.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public void addBuildingName(BuildingName buildingName) {
		largeMailUser.getBuildingName().add(((BuildingNameImpl)buildingName).getJAXBObject());
	}

	@Override
	public void addLargeMailUserName(LargeMailUserName largeMailUserName) {
		largeMailUser.getLargeMailUserName().add(((LargeMailUserNameImpl)largeMailUserName).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : largeMailUser.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	@Override
	public List<BuildingName> getBuildingName() {
		List<BuildingName> buildingNameList = new ArrayList<BuildingName>();

		for (BuildingNameType buildingNameElem : largeMailUser.getBuildingName())
			buildingNameList.add(new BuildingNameImpl(buildingNameElem));

		return buildingNameList;
	}

	@Override
	public Department getDepartment() {
		if (largeMailUser.isSetDepartment())
			return new DepartmentImpl(largeMailUser.getDepartment());

		return null;
	}

	@Override
	public LargeMailUserIdentifier getLargeMailUserIdentifier() {
		if (largeMailUser.isSetLargeMailUserIdentifier())
			return new LargeMailUserIdentifierImpl(largeMailUser.getLargeMailUserIdentifier());

		return null;
	}

	@Override
	public List<LargeMailUserName> getLargeMailUserName() {
		List<LargeMailUserName> largeMailUserNameList = new ArrayList<LargeMailUserName>();

		for (LargeMailUserType.LargeMailUserName largeMailUserNameElem : largeMailUser.getLargeMailUserName())
			largeMailUserNameList.add(new LargeMailUserNameImpl(largeMailUserNameElem));

		return largeMailUserNameList;
	}

	@Override
	public PostBox getPostBox() {
		if (largeMailUser.isSetPostBox())
			return new PostBoxImpl(largeMailUser.getPostBox());

		return null;
	}

	@Override
	public PostalCode getPostalCode() {
		if (largeMailUser.isSetPostalCode())
			return new PostalCodeImpl(largeMailUser.getPostalCode());

		return null;
	}

	@Override
	public String getType() {
		return largeMailUser.getType();
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		largeMailUser.unsetAddressLine();
		largeMailUser.getAddressLine().addAll(addressLineElemList);
	}

	@Override
	public void setBuildingName(List<BuildingName> buildingName) {
		List<BuildingNameType> buildingNameList = new ArrayList<BuildingNameType>();

		for (BuildingName buildingNameItem : buildingName)
			buildingNameList.add(((BuildingNameImpl)buildingNameItem).getJAXBObject());

		largeMailUser.unsetBuildingName();
		largeMailUser.getBuildingName().addAll(buildingNameList);
	}

	@Override
	public void setDepartment(Department department) {
		largeMailUser.setDepartment(((DepartmentImpl)department).getJAXBObject());
	}

	@Override
	public void setLargeMailUserIdentifier(LargeMailUserIdentifier largeMailUserIdentifier) {
		largeMailUser.setLargeMailUserIdentifier(((LargeMailUserIdentifierImpl)largeMailUserIdentifier).getJAXBObject());
	}

	@Override
	public void setLargeMailUserName(List<LargeMailUserName> largeMailUserName) {
		List<LargeMailUserType.LargeMailUserName> largeMailUserNameList = new ArrayList<LargeMailUserType.LargeMailUserName>();

		for (LargeMailUserName largeMailUserNameItem : largeMailUserName)
			largeMailUserNameList.add(((LargeMailUserNameImpl)largeMailUserNameItem).getJAXBObject());

		largeMailUser.unsetLargeMailUserName();
		largeMailUser.getLargeMailUserName().addAll(largeMailUserNameList);
	}

	@Override
	public void setPostBox(PostBox postBox) {
		largeMailUser.setPostBox(((PostBoxImpl)postBox).getJAXBObject());
	}

	@Override
	public void setPostalCode(PostalCode postalCode) {
		largeMailUser.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	@Override
	public void setType(String type) {
		largeMailUser.setType(type);
	}

	@Override
	public Thoroughfare getThoroughfare() {
		if (largeMailUser.isSetThoroughfare())
			return new ThoroughfareImpl(largeMailUser.getThoroughfare());

		return null;
	}

	@Override
	public void setThoroughfare(Thoroughfare thoroughfare) {
		largeMailUser.setThoroughfare(((ThoroughfareImpl)thoroughfare).getJAXBObject());
	}

	@Override
	public boolean isSetAddressLine() {
		return largeMailUser.isSetAddressLine();
	}

	@Override
	public boolean isSetBuildingName() {
		return largeMailUser.isSetBuildingName();
	}

	@Override
	public boolean isSetDepartment() {
		return largeMailUser.isSetDepartment();
	}

	@Override
	public boolean isSetLargeMailUserIdentifier() {
		return largeMailUser.isSetLargeMailUserIdentifier();
	}

	@Override
	public boolean isSetLargeMailUserName() {
		return largeMailUser.isSetLargeMailUserName();
	}

	@Override
	public boolean isSetPostalCode() {
		return largeMailUser.isSetPostalCode();
	}

	@Override
	public boolean isSetPostBox() {
		return largeMailUser.isSetPostBox();
	}

	@Override
	public boolean isSetThoroughfare() {
		return largeMailUser.isSetThoroughfare();
	}

	@Override
	public boolean isSetType() {
		return largeMailUser.isSetType();
	}

	@Override
	public void unsetAddressLine() {
		largeMailUser.unsetAddressLine();
	}

	@Override
	public void unsetBuildingName() {
		largeMailUser.unsetBuildingName();
	}

	@Override
	public void unsetDepartment() {
		largeMailUser.setDepartment(null);
	}

	@Override
	public void unsetLargeMailUserIdentifier() {
		largeMailUser.setLargeMailUserIdentifier(null);
	}

	@Override
	public void unsetLargeMailUserName() {
		largeMailUser.unsetLargeMailUserName();
	}

	@Override
	public void unsetPostalCode() {
		largeMailUser.setPostalCode(null);
	}

	@Override
	public void unsetPostBox() {
		largeMailUser.setPostBox(null);
	}

	@Override
	public void unsetThoroughfare() {
		largeMailUser.setThoroughfare(null);
	}

	@Override
	public void unsetType() {
		largeMailUser.setType(null);
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (largeMailUser.isSetAddressLine())
			return largeMailUser.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetBuildingName(BuildingName buildingName) {
		if (largeMailUser.isSetBuildingName())
			return largeMailUser.getBuildingName().remove(((BuildingNameImpl)buildingName).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetLargeMailUserName(LargeMailUserName largeMailUserName) {
		if (largeMailUser.isSetLargeMailUserName())
			return largeMailUser.getLargeMailUserName().remove(((LargeMailUserNameImpl)largeMailUserName).getJAXBObject());
		
		return false;
	}

}
