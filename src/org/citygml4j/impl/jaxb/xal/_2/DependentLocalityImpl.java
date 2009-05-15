package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.DependentLocalityType;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.DependentLocality;
import org.citygml4j.model.xal.DependentLocalityName;
import org.citygml4j.model.xal.DependentLocalityNumber;
import org.citygml4j.model.xal.LargeMailUser;
import org.citygml4j.model.xal.PostBox;
import org.citygml4j.model.xal.PostOffice;
import org.citygml4j.model.xal.PostalCode;
import org.citygml4j.model.xal.PostalRoute;
import org.citygml4j.model.xal.Premise;
import org.citygml4j.model.xal.Thoroughfare;
import org.citygml4j.model.xal.XALClass;

public class DependentLocalityImpl extends XALBaseImpl implements DependentLocality {
	private DependentLocalityType dependentLocality;

	public DependentLocalityImpl() {
		dependentLocality = new DependentLocalityType();
	}

	public DependentLocalityImpl(DependentLocalityType dependentLocality) {
		this.dependentLocality = dependentLocality;
	}

	@Override
	public DependentLocalityType getJAXBObject() {
		return dependentLocality;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.DEPENDENTLOCALITY;
	}

	public void addAddressLine(AddressLine addressLine) {
		dependentLocality.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	public void addDependentLocalityName(DependentLocalityName dependentLocalityName) {
		dependentLocality.getDependentLocalityName().add(((DependentLocalityNameImpl)dependentLocalityName).getJAXBObject());
	}

	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineInst : dependentLocality.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineInst));

		return addressLineList;
	}

	public String getConnector() {
		return dependentLocality.getConnector();
	}

	public DependentLocality getDependentLocality() {
		if (dependentLocality.isSetDependentLocality())
			return new DependentLocalityImpl(dependentLocality.getDependentLocality());

		return null;
	}

	public List<DependentLocalityName> getDependentLocalityName() {
		List<DependentLocalityName> dependentLocalityNameList = new ArrayList<DependentLocalityName>();

		for (DependentLocalityType.DependentLocalityName dependentLocalityNameInst : dependentLocality.getDependentLocalityName())
			dependentLocalityNameList.add(new DependentLocalityNameImpl(dependentLocalityNameInst));

		return dependentLocalityNameList;
	}

	public DependentLocalityNumber getDependentLocalityNumber() {
		if (dependentLocality.isSetDependentLocalityNumber())
			return new DependentLocalityNumberImpl(dependentLocality.getDependentLocalityNumber());

		return null;
	}

	public String getIndicator() {
		return dependentLocality.getIndicator();
	}

	public LargeMailUser getLargeMailUser() {
		if (dependentLocality.isSetLargeMailUser())
			return new LargeMailUserImpl(dependentLocality.getLargeMailUser());

		return null;
	}

	public PostBox getPostBox() {
		if (dependentLocality.isSetPostBox())
			return new PostBoxImpl(dependentLocality.getPostBox());

		return null;
	}

	public PostOffice getPostOffice() {
		if (dependentLocality.isSetPostOffice())
			return new PostOfficeImpl(dependentLocality.getPostOffice());

		return null;
	}

	public PostalCode getPostalCode() {
		if (dependentLocality.isSetPostalCode())
			return new PostalCodeImpl(dependentLocality.getPostalCode());

		return null;
	}

	public PostalRoute getPostalRoute() {
		if (dependentLocality.isSetPostalRoute())
			return new PostalRouteImpl(dependentLocality.getPostalRoute());

		return null;
	}

	public Premise getPremise() {
		if (dependentLocality.isSetPremise())
			return new PremiseImpl(dependentLocality.getPremise());

		return null;
	}

	public String getType() {
		return dependentLocality.getType();
	}

	public String getUsageType() {
		return dependentLocality.getUsageType();
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		dependentLocality.unsetAddressLine();
		dependentLocality.getAddressLine().addAll(addressLineElemList);
	}

	public void setConnector(String connector) {
		dependentLocality.setConnector(connector);
	}

	public void setDependentLocality(DependentLocality dependentLocality) {
		this.dependentLocality.setDependentLocality(((DependentLocalityImpl)dependentLocality).getJAXBObject());
	}

	public void setDependentLocalityName(List<DependentLocalityName> dependentLocalityName) {
		List<DependentLocalityType.DependentLocalityName> dependentLocalityNameElemList = new ArrayList<DependentLocalityType.DependentLocalityName>();

		for (DependentLocalityName dependentLocalityNameItem : dependentLocalityName)
			dependentLocalityNameElemList.add(((DependentLocalityNameImpl)dependentLocalityNameItem).getJAXBObject());

		dependentLocality.unsetDependentLocalityName();
		dependentLocality.getDependentLocalityName().addAll(dependentLocalityNameElemList);
	}

	public void setDependentLocalityNumber(DependentLocalityNumber dependentLocalityNumber) {
		dependentLocality.setDependentLocalityNumber(((DependentLocalityNumberImpl)dependentLocalityNumber).getJAXBObject());
	}

	public void setIndicator(String indicator) {
		dependentLocality.setIndicator(indicator);
	}

	public void setLargeMailUser(LargeMailUser largeMailUser) {
		dependentLocality.setLargeMailUser(((LargeMailUserImpl)largeMailUser).getJAXBObject());
	}

	public void setPostBox(PostBox postBox) {
		dependentLocality.setPostBox(((PostBoxImpl)postBox).getJAXBObject());
	}

	public void setPostOffice(PostOffice postOffice) {
		dependentLocality.setPostOffice(((PostOfficeImpl)postOffice).getJAXBObject());
	}

	public void setPostalCode(PostalCode postalCode) {
		dependentLocality.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	public void setPostalRoute(PostalRoute postalRoute) {
		dependentLocality.setPostalRoute(((PostalRouteImpl)postalRoute).getJAXBObject());
	}

	public void setPremise(Premise premise) {
		dependentLocality.setPremise(((PremiseImpl)premise).getJAXBObject());
	}

	public void setType(String type) {
		dependentLocality.setType(type);
	}

	public void setUsageType(String usageType) {
		dependentLocality.setUsageType(usageType);
	}

	public Thoroughfare getThoroughfare() {
		if (dependentLocality.isSetThoroughfare())
			return new ThoroughfareImpl(dependentLocality.getThoroughfare());

		return null;
	}

	public void setThoroughfare(Thoroughfare thoroughfare) {
		dependentLocality.setThoroughfare(((ThoroughfareImpl)thoroughfare).getJAXBObject());
	}

	public boolean isSetAddressLine() {
		return dependentLocality.isSetAddressLine();
	}

	public boolean isSetConnector() {
		return dependentLocality.isSetConnector();
	}

	public boolean isSetDependentLocality() {
		return dependentLocality.isSetDependentLocality();
	}

	public boolean isSetDependentLocalityName() {
		return dependentLocality.isSetDependentLocalityName();
	}

	public boolean isSetDependentLocalityNumber() {
		return dependentLocality.isSetDependentLocalityNumber();
	}

	public boolean isSetIndicator() {
		return dependentLocality.isSetIndicator();
	}

	public boolean isSetLargeMailUser() {
		return dependentLocality.isSetLargeMailUser();
	}

	public boolean isSetPostalCode() {
		return dependentLocality.isSetPostalCode();
	}

	public boolean isSetPostalRoute() {
		return dependentLocality.isSetPostalRoute();
	}

	public boolean isSetPostBox() {
		return dependentLocality.isSetPostBox();
	}

	public boolean isSetPostOffice() {
		return dependentLocality.isSetPostOffice();
	}

	public boolean isSetPremise() {
		return dependentLocality.isSetPremise();
	}

	public boolean isSetThoroughfare() {
		return dependentLocality.isSetThoroughfare();
	}

	public boolean isSetType() {
		return dependentLocality.isSetType();
	}

	public boolean isSetUsageType() {
		return dependentLocality.isSetUsageType();
	}

	public void unsetAddressLine() {
		dependentLocality.unsetAddressLine();
	}

	public void unsetConnector() {
		dependentLocality.setConnector(null);
	}

	public void unsetDependentLocality() {
		dependentLocality.setDependentLocality(null);
	}

	public void unsetDependentLocalityName() {
		dependentLocality.unsetDependentLocalityName();
	}

	public void unsetDependentLocalityNumber() {
		dependentLocality.setDependentLocalityNumber(null);
	}

	public void unsetIndicator() {
		dependentLocality.setIndicator(null);
	}

	public void unsetLargeMailUser() {
		dependentLocality.setLargeMailUser(null);
	}

	public void unsetPostalCode() {
		dependentLocality.setPostalCode(null);
	}

	public void unsetPostalRoute() {
		dependentLocality.setPostalRoute(null);
	}

	public void unsetPostBox() {
		dependentLocality.setPostBox(null);
	}

	public void unsetPostOffice() {
		dependentLocality.setPostOffice(null);
	}

	public void unsetPremise() {
		dependentLocality.setPremise(null);
	}

	public void unsetThoroughfare() {
		dependentLocality.setThoroughfare(null);
	}

	public void unsetType() {
		dependentLocality.setType(null);
	}

	public void unsetUsageType() {
		dependentLocality.setUsageType(null);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		if (dependentLocality.isSetAddressLine())
			return dependentLocality.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
			
		return false;
	}

	public boolean unsetDependentLocalityName(DependentLocalityName dependentLocalityName) {
		if (dependentLocality.isSetDependentLocalityName())
			return dependentLocality.getDependentLocalityName().remove(((DependentLocalityNameImpl)dependentLocalityName).getJAXBObject());
		
		return false;
	}

}
