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

	@Override
	public void addAddressLine(AddressLine addressLine) {
		dependentLocality.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public void addDependentLocalityName(DependentLocalityName dependentLocalityName) {
		dependentLocality.getDependentLocalityName().add(((DependentLocalityNameImpl)dependentLocalityName).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineInst : dependentLocality.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineInst));

		return addressLineList;
	}

	@Override
	public String getConnector() {
		return dependentLocality.getConnector();
	}

	@Override
	public DependentLocality getDependentLocality() {
		if (dependentLocality.isSetDependentLocality())
			return new DependentLocalityImpl(dependentLocality.getDependentLocality());

		return null;
	}

	@Override
	public List<DependentLocalityName> getDependentLocalityName() {
		List<DependentLocalityName> dependentLocalityNameList = new ArrayList<DependentLocalityName>();

		for (DependentLocalityType.DependentLocalityName dependentLocalityNameInst : dependentLocality.getDependentLocalityName())
			dependentLocalityNameList.add(new DependentLocalityNameImpl(dependentLocalityNameInst));

		return dependentLocalityNameList;
	}

	@Override
	public DependentLocalityNumber getDependentLocalityNumber() {
		if (dependentLocality.isSetDependentLocalityNumber())
			return new DependentLocalityNumberImpl(dependentLocality.getDependentLocalityNumber());

		return null;
	}

	@Override
	public String getIndicator() {
		return dependentLocality.getIndicator();
	}

	@Override
	public LargeMailUser getLargeMailUser() {
		if (dependentLocality.isSetLargeMailUser())
			return new LargeMailUserImpl(dependentLocality.getLargeMailUser());

		return null;
	}

	@Override
	public PostBox getPostBox() {
		if (dependentLocality.isSetPostBox())
			return new PostBoxImpl(dependentLocality.getPostBox());

		return null;
	}

	@Override
	public PostOffice getPostOffice() {
		if (dependentLocality.isSetPostOffice())
			return new PostOfficeImpl(dependentLocality.getPostOffice());

		return null;
	}

	@Override
	public PostalCode getPostalCode() {
		if (dependentLocality.isSetPostalCode())
			return new PostalCodeImpl(dependentLocality.getPostalCode());

		return null;
	}

	@Override
	public PostalRoute getPostalRoute() {
		if (dependentLocality.isSetPostalRoute())
			return new PostalRouteImpl(dependentLocality.getPostalRoute());

		return null;
	}

	@Override
	public Premise getPremise() {
		if (dependentLocality.isSetPremise())
			return new PremiseImpl(dependentLocality.getPremise());

		return null;
	}

	@Override
	public String getType() {
		return dependentLocality.getType();
	}

	@Override
	public String getUsageType() {
		return dependentLocality.getUsageType();
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		dependentLocality.unsetAddressLine();
		dependentLocality.getAddressLine().addAll(addressLineElemList);
	}

	@Override
	public void setConnector(String connector) {
		dependentLocality.setConnector(connector);
	}

	@Override
	public void setDependentLocality(DependentLocality dependentLocality) {
		this.dependentLocality.setDependentLocality(((DependentLocalityImpl)dependentLocality).getJAXBObject());
	}

	@Override
	public void setDependentLocalityName(List<DependentLocalityName> dependentLocalityName) {
		List<DependentLocalityType.DependentLocalityName> dependentLocalityNameElemList = new ArrayList<DependentLocalityType.DependentLocalityName>();

		for (DependentLocalityName dependentLocalityNameItem : dependentLocalityName)
			dependentLocalityNameElemList.add(((DependentLocalityNameImpl)dependentLocalityNameItem).getJAXBObject());

		dependentLocality.unsetDependentLocalityName();
		dependentLocality.getDependentLocalityName().addAll(dependentLocalityNameElemList);
	}

	@Override
	public void setDependentLocalityNumber(DependentLocalityNumber dependentLocalityNumber) {
		dependentLocality.setDependentLocalityNumber(((DependentLocalityNumberImpl)dependentLocalityNumber).getJAXBObject());
	}

	@Override
	public void setIndicator(String indicator) {
		dependentLocality.setIndicator(indicator);
	}

	@Override
	public void setLargeMailUser(LargeMailUser largeMailUser) {
		dependentLocality.setLargeMailUser(((LargeMailUserImpl)largeMailUser).getJAXBObject());
	}

	@Override
	public void setPostBox(PostBox postBox) {
		dependentLocality.setPostBox(((PostBoxImpl)postBox).getJAXBObject());
	}

	@Override
	public void setPostOffice(PostOffice postOffice) {
		dependentLocality.setPostOffice(((PostOfficeImpl)postOffice).getJAXBObject());
	}

	@Override
	public void setPostalCode(PostalCode postalCode) {
		dependentLocality.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	@Override
	public void setPostalRoute(PostalRoute postalRoute) {
		dependentLocality.setPostalRoute(((PostalRouteImpl)postalRoute).getJAXBObject());
	}

	@Override
	public void setPremise(Premise premise) {
		dependentLocality.setPremise(((PremiseImpl)premise).getJAXBObject());
	}

	@Override
	public void setType(String type) {
		dependentLocality.setType(type);
	}

	@Override
	public void setUsageType(String usageType) {
		dependentLocality.setUsageType(usageType);
	}

	@Override
	public Thoroughfare getThoroughfare() {
		if (dependentLocality.isSetThoroughfare())
			return new ThoroughfareImpl(dependentLocality.getThoroughfare());

		return null;
	}

	@Override
	public void setThoroughfare(Thoroughfare thoroughfare) {
		dependentLocality.setThoroughfare(((ThoroughfareImpl)thoroughfare).getJAXBObject());
	}

	@Override
	public boolean isSetAddressLine() {
		return dependentLocality.isSetAddressLine();
	}

	@Override
	public boolean isSetConnector() {
		return dependentLocality.isSetConnector();
	}

	@Override
	public boolean isSetDependentLocality() {
		return dependentLocality.isSetDependentLocality();
	}

	@Override
	public boolean isSetDependentLocalityName() {
		return dependentLocality.isSetDependentLocalityName();
	}

	@Override
	public boolean isSetDependentLocalityNumber() {
		return dependentLocality.isSetDependentLocalityNumber();
	}

	@Override
	public boolean isSetIndicator() {
		return dependentLocality.isSetIndicator();
	}

	@Override
	public boolean isSetLargeMailUser() {
		return dependentLocality.isSetLargeMailUser();
	}

	@Override
	public boolean isSetPostalCode() {
		return dependentLocality.isSetPostalCode();
	}

	@Override
	public boolean isSetPostalRoute() {
		return dependentLocality.isSetPostalRoute();
	}

	@Override
	public boolean isSetPostBox() {
		return dependentLocality.isSetPostBox();
	}

	@Override
	public boolean isSetPostOffice() {
		return dependentLocality.isSetPostOffice();
	}

	@Override
	public boolean isSetPremise() {
		return dependentLocality.isSetPremise();
	}

	@Override
	public boolean isSetThoroughfare() {
		return dependentLocality.isSetThoroughfare();
	}

	@Override
	public boolean isSetType() {
		return dependentLocality.isSetType();
	}

	@Override
	public boolean isSetUsageType() {
		return dependentLocality.isSetUsageType();
	}

	@Override
	public void unsetAddressLine() {
		dependentLocality.unsetAddressLine();
	}

	@Override
	public void unsetConnector() {
		dependentLocality.setConnector(null);
	}

	@Override
	public void unsetDependentLocality() {
		dependentLocality.setDependentLocality(null);
	}

	@Override
	public void unsetDependentLocalityName() {
		dependentLocality.unsetDependentLocalityName();
	}

	@Override
	public void unsetDependentLocalityNumber() {
		dependentLocality.setDependentLocalityNumber(null);
	}

	@Override
	public void unsetIndicator() {
		dependentLocality.setIndicator(null);
	}

	@Override
	public void unsetLargeMailUser() {
		dependentLocality.setLargeMailUser(null);
	}

	@Override
	public void unsetPostalCode() {
		dependentLocality.setPostalCode(null);
	}

	@Override
	public void unsetPostalRoute() {
		dependentLocality.setPostalRoute(null);
	}

	@Override
	public void unsetPostBox() {
		dependentLocality.setPostBox(null);
	}

	@Override
	public void unsetPostOffice() {
		dependentLocality.setPostOffice(null);
	}

	@Override
	public void unsetPremise() {
		dependentLocality.setPremise(null);
	}

	@Override
	public void unsetThoroughfare() {
		dependentLocality.setThoroughfare(null);
	}

	@Override
	public void unsetType() {
		dependentLocality.setType(null);
	}

	@Override
	public void unsetUsageType() {
		dependentLocality.setUsageType(null);
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (dependentLocality.isSetAddressLine())
			return dependentLocality.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
			
		return false;
	}

	@Override
	public boolean unsetDependentLocalityName(DependentLocalityName dependentLocalityName) {
		if (dependentLocality.isSetDependentLocalityName())
			return dependentLocality.getDependentLocalityName().remove(((DependentLocalityNameImpl)dependentLocalityName).getJAXBObject());
		
		return false;
	}

}
