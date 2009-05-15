package org.citygml4j.impl.jaxb.xal._2;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.xal.AddressLineElement;
import org.citygml4j.jaxb.xal.LocalityElement;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.DependentLocality;
import org.citygml4j.model.xal.LargeMailUser;
import org.citygml4j.model.xal.Locality;
import org.citygml4j.model.xal.LocalityName;
import org.citygml4j.model.xal.PostBox;
import org.citygml4j.model.xal.PostOffice;
import org.citygml4j.model.xal.PostalCode;
import org.citygml4j.model.xal.PostalRoute;
import org.citygml4j.model.xal.Premise;
import org.citygml4j.model.xal.Thoroughfare;
import org.citygml4j.model.xal.XALClass;

public class LocalityImpl extends XALBaseImpl implements Locality {
	private LocalityElement locality;

	public LocalityImpl() {
		locality = new LocalityElement();
	}

	public LocalityImpl(LocalityElement locality) {
		this.locality = locality;
	}

	@Override
	public LocalityElement getJAXBObject() {
		return locality;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.LOCALITY;
	}

	public void addAddressLine(AddressLine addressLine) {
		locality.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	public void addLocalityName(LocalityName localityName) {
		locality.getLocalityName().add(((LocalityNameImpl)localityName).getJAXBObject());
	}

	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();

		for (AddressLineElement addressLineElem : locality.getAddressLine())
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	public DependentLocality getDependentLocality() {
		if (locality.isSetDependentLocality())
			return new DependentLocalityImpl(locality.getDependentLocality());

		return null;
	}

	public String getIndicator() {
		return locality.getIndicator();
	}

	public LargeMailUser getLargeMailUser() {
		if (locality.isSetLargeMailUser())
			return new LargeMailUserImpl(locality.getLargeMailUser());

		return null;
	}

	public List<LocalityName> getLocalityName() {
		List<LocalityName> localityNameList = new ArrayList<LocalityName>();

		for (LocalityElement.LocalityName localityNameElem : locality.getLocalityName())
			localityNameList.add(new LocalityNameImpl(localityNameElem));

		return localityNameList;
	}

	public PostBox getPostBox() {
		if (locality.isSetPostBox())
			return new PostBoxImpl(locality.getPostBox());

		return null;
	}

	public PostOffice getPostOffice() {
		if (locality.isSetPostOffice())
			return new PostOfficeImpl(locality.getPostOffice());

		return null;
	}

	public PostalCode getPostalCode() {
		if (locality.isSetPostalCode())
			return new PostalCodeImpl(locality.getPostalCode());

		return null;
	}

	public PostalRoute getPostalRoute() {
		if (locality.isSetPostalRoute())
			return new PostalRouteImpl(locality.getPostalRoute());

		return null;
	}

	public Premise getPremise() {
		if (locality.isSetPremise())
			return new PremiseImpl(locality.getPremise());

		return null;
	}

	public String getType() {
		return locality.getType();
	}

	public String getUsageType() {
		return locality.getUsageType();
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		locality.unsetAddressLine();
		locality.getAddressLine().addAll(addressLineElemList);
	}

	public void setDependentLocality(DependentLocality dependentLocality) {
		locality.setDependentLocality(((DependentLocalityImpl)dependentLocality).getJAXBObject());
	}

	public void setIndicator(String indicator) {
		locality.setIndicator(indicator);
	}

	public void setLargeMailUser(LargeMailUser largeMailUser) {
		locality.setLargeMailUser(((LargeMailUserImpl)largeMailUser).getJAXBObject());
	}

	public void setLocalityName(List<LocalityName> localityName) {
		List<LocalityElement.LocalityName> localityNameElemList = new ArrayList<LocalityElement.LocalityName>();

		for (LocalityName localityNameItem : localityName)
			localityNameElemList.add(((LocalityNameImpl)localityNameItem).getJAXBObject());

		locality.unsetLocalityName();
		locality.getLocalityName().addAll(localityNameElemList);
	}

	public void setPostBox(PostBox postBox) {
		locality.setPostBox(((PostBoxImpl)postBox).getJAXBObject());
	}

	public void setPostOffice(PostOffice postOffice) {
		locality.setPostOffice(((PostOfficeImpl)postOffice).getJAXBObject());
	}

	public void setPostalCode(PostalCode postalCode) {
		locality.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	public void setPostalRoute(PostalRoute postalRoute) {
		locality.setPostalRoute(((PostalRouteImpl)postalRoute).getJAXBObject());
	}

	public void setPremise(Premise premise) {
		locality.setPremise(((PremiseImpl)premise).getJAXBObject());
	}

	public void setType(String type) {
		locality.setType(type);
	}

	public void setUsageType(String usageType) {
		locality.setUsageType(usageType);
	}

	public Thoroughfare getThoroughfare() {
		if (locality.isSetThoroughfare())
			return new ThoroughfareImpl(locality.getThoroughfare());

		return null;
	}

	public void setThoroughfare(Thoroughfare thoroughfare) {
		locality.setThoroughfare(((ThoroughfareImpl)thoroughfare).getJAXBObject());
	}

	public boolean isSetAddressLine() {
		return locality.isSetAddressLine();
	}

	public boolean isSetDependentLocality() {
		return locality.isSetDependentLocality();
	}

	public boolean isSetIndicator() {
		return locality.isSetIndicator();
	}

	public boolean isSetLargeMailUser() {
		return locality.isSetLargeMailUser();
	}

	public boolean isSetLocalityName() {
		return locality.isSetLocalityName();
	}

	public boolean isSetPostalCode() {
		return locality.isSetPostalCode();
	}

	public boolean isSetPostalRoute() {
		return locality.isSetPostalRoute();
	}

	public boolean isSetPostBox() {
		return locality.isSetPostBox();
	}

	public boolean isSetPostOffice() {
		return locality.isSetPostOffice();
	}

	public boolean isSetPremise() {
		return locality.isSetPremise();
	}

	public boolean isSetThoroughfare() {
		return locality.isSetThoroughfare();
	}

	public boolean isSetType() {
		return locality.isSetType();
	}

	public boolean isSetUsageType() {
		return locality.isSetUsageType();
	}

	public void unsetAddressLine() {
		locality.unsetAddressLine();
	}

	public void unsetDependentLocality() {
		locality.setDependentLocality(null);
	}

	public void unsetIndicator() {
		locality.setIndicator(null);
	}

	public void unsetLargeMailUser() {
		locality.setLargeMailUser(null);
	}

	public void unsetLocalityName() {
		locality.unsetLocalityName();
	}

	public void unsetPostalCode() {
		locality.setPostalCode(null);
	}

	public void unsetPostalRoute() {
		locality.setPostalRoute(null);
	}

	public void unsetPostBox() {
		locality.setPostBox(null);
	}

	public void unsetPostOffice() {
		locality.setPostOffice(null);
	}

	public void unsetPremise() {
		locality.setPremise(null);
	}

	public void unsetThoroughfare() {
		locality.setThoroughfare(null);
	}

	public void unsetType() {
		locality.setType(null);
	}

	public void unsetUsageType() {
		locality.setUsageType(null);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		if (locality.isSetAddressLine())
			return locality.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	public boolean unsetLocalityName(LocalityName localityName) {
		if (locality.isSetLocalityName())
			return locality.getLocalityName().remove(((LocalityNameImpl)localityName).getJAXBObject());
		
		return false;
	}

}
