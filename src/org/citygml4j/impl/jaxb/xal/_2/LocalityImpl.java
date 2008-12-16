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

	@Override
	public void addAddressLine(AddressLine addressLine) {
		locality.getAddressLine().add(((AddressLineImpl)addressLine).getJAXBObject());
	}

	@Override
	public void addLocalityName(LocalityName localityName) {
		locality.getLocalityName().add(((LocalityNameImpl)localityName).getJAXBObject());
	}

	@Override
	public List<AddressLine> getAddressLine() {
		List<AddressLine> addressLineList = new ArrayList<AddressLine>();
		List<AddressLineElement> addressLineElemList = locality.getAddressLine();

		for (AddressLineElement addressLineElem : addressLineElemList)
			addressLineList.add(new AddressLineImpl(addressLineElem));

		return addressLineList;
	}

	@Override
	public DependentLocality getDependentLocality() {
		if (locality.isSetDependentLocality())
			return new DependentLocalityImpl(locality.getDependentLocality());

		return null;
	}

	@Override
	public String getIndicator() {
		return locality.getIndicator();
	}

	@Override
	public LargeMailUser getLargeMailUser() {
		if (locality.isSetLargeMailUser())
			return new LargeMailUserImpl(locality.getLargeMailUser());

		return null;
	}

	@Override
	public List<LocalityName> getLocalityName() {
		List<LocalityName> localityNameList = new ArrayList<LocalityName>();
		List<LocalityElement.LocalityName> localityNameElemList = locality.getLocalityName();

		for (LocalityElement.LocalityName localityNameElem : localityNameElemList)
			localityNameList.add(new LocalityNameImpl(localityNameElem));

		return localityNameList;
	}

	@Override
	public PostBox getPostBox() {
		if (locality.isSetPostBox())
			return new PostBoxImpl(locality.getPostBox());

		return null;
	}

	@Override
	public PostOffice getPostOffice() {
		if (locality.isSetPostOffice())
			return new PostOfficeImpl(locality.getPostOffice());

		return null;
	}

	@Override
	public PostalCode getPostalCode() {
		if (locality.isSetPostalCode())
			return new PostalCodeImpl(locality.getPostalCode());

		return null;
	}

	@Override
	public PostalRoute getPostalRoute() {
		if (locality.isSetPostalRoute())
			return new PostalRouteImpl(locality.getPostalRoute());

		return null;
	}

	@Override
	public Premise getPremise() {
		if (locality.isSetPremise())
			return new PremiseImpl(locality.getPremise());

		return null;
	}

	@Override
	public String getType() {
		return locality.getType();
	}

	@Override
	public String getUsageType() {
		return locality.getUsageType();
	}

	@Override
	public void setAddressLine(List<AddressLine> addressLine) {
		List<AddressLineElement> addressLineElemList = new ArrayList<AddressLineElement>();

		for (AddressLine addressLineItem : addressLine)
			addressLineElemList.add(((AddressLineImpl)addressLineItem).getJAXBObject());

		locality.unsetAddressLine();
		locality.getAddressLine().addAll(addressLineElemList);
	}

	@Override
	public void setDependentLocality(DependentLocality dependentLocality) {
		locality.setDependentLocality(((DependentLocalityImpl)dependentLocality).getJAXBObject());
	}

	@Override
	public void setIndicator(String indicator) {
		locality.setIndicator(indicator);
	}

	@Override
	public void setLargeMailUser(LargeMailUser largeMailUser) {
		locality.setLargeMailUser(((LargeMailUserImpl)largeMailUser).getJAXBObject());
	}

	@Override
	public void setLocalityName(List<LocalityName> localityName) {
		List<LocalityElement.LocalityName> localityNameElemList = new ArrayList<LocalityElement.LocalityName>();

		for (LocalityName localityNameItem : localityName)
			localityNameElemList.add(((LocalityNameImpl)localityNameItem).getJAXBObject());

		locality.unsetLocalityName();
		locality.getLocalityName().addAll(localityNameElemList);
	}

	@Override
	public void setPostBox(PostBox postBox) {
		locality.setPostBox(((PostBoxImpl)postBox).getJAXBObject());
	}

	@Override
	public void setPostOffice(PostOffice postOffice) {
		locality.setPostOffice(((PostOfficeImpl)postOffice).getJAXBObject());
	}

	@Override
	public void setPostalCode(PostalCode postalCode) {
		locality.setPostalCode(((PostalCodeImpl)postalCode).getJAXBObject());
	}

	@Override
	public void setPostalRoute(PostalRoute postalRoute) {
		locality.setPostalRoute(((PostalRouteImpl)postalRoute).getJAXBObject());
	}

	@Override
	public void setPremise(Premise premise) {
		locality.setPremise(((PremiseImpl)premise).getJAXBObject());
	}

	@Override
	public void setType(String type) {
		locality.setType(type);
	}

	@Override
	public void setUsageType(String usageType) {
		locality.setUsageType(usageType);
	}

	@Override
	public Thoroughfare getThoroughfare() {
		if (locality.isSetThoroughfare())
			return new ThoroughfareImpl(locality.getThoroughfare());

		return null;
	}

	@Override
	public void setThoroughfare(Thoroughfare thoroughfare) {
		locality.setThoroughfare(((ThoroughfareImpl)thoroughfare).getJAXBObject());
	}

	@Override
	public boolean isSetAddressLine() {
		return locality.isSetAddressLine();
	}

	@Override
	public boolean isSetDependentLocality() {
		return locality.isSetDependentLocality();
	}

	@Override
	public boolean isSetIndicator() {
		return locality.isSetIndicator();
	}

	@Override
	public boolean isSetLargeMailUser() {
		return locality.isSetLargeMailUser();
	}

	@Override
	public boolean isSetLocalityName() {
		return locality.isSetLocalityName();
	}

	@Override
	public boolean isSetPostalCode() {
		return locality.isSetPostalCode();
	}

	@Override
	public boolean isSetPostalRoute() {
		return locality.isSetPostalRoute();
	}

	@Override
	public boolean isSetPostBox() {
		return locality.isSetPostBox();
	}

	@Override
	public boolean isSetPostOffice() {
		return locality.isSetPostOffice();
	}

	@Override
	public boolean isSetPremise() {
		return locality.isSetPremise();
	}

	@Override
	public boolean isSetThoroughfare() {
		return locality.isSetThoroughfare();
	}

	@Override
	public boolean isSetType() {
		return locality.isSetType();
	}

	@Override
	public boolean isSetUsageType() {
		return locality.isSetUsageType();
	}

	@Override
	public void unsetAddressLine() {
		locality.unsetAddressLine();
	}

	@Override
	public void unsetDependentLocality() {
		locality.setDependentLocality(null);
	}

	@Override
	public void unsetIndicator() {
		locality.setIndicator(null);
	}

	@Override
	public void unsetLargeMailUser() {
		locality.setLargeMailUser(null);
	}

	@Override
	public void unsetLocalityName() {
		locality.unsetLocalityName();
	}

	@Override
	public void unsetPostalCode() {
		locality.setPostalCode(null);
	}

	@Override
	public void unsetPostalRoute() {
		locality.setPostalRoute(null);
	}

	@Override
	public void unsetPostBox() {
		locality.setPostBox(null);
	}

	@Override
	public void unsetPostOffice() {
		locality.setPostOffice(null);
	}

	@Override
	public void unsetPremise() {
		locality.setPremise(null);
	}

	@Override
	public void unsetThoroughfare() {
		locality.setThoroughfare(null);
	}

	@Override
	public void unsetType() {
		locality.setType(null);
	}

	@Override
	public void unsetUsageType() {
		locality.setUsageType(null);
	}

	@Override
	public boolean unsetAddressLine(AddressLine addressLine) {
		if (locality.isSetAddressLine())
			return locality.getAddressLine().remove(((AddressLineImpl)addressLine).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetLocalityName(LocalityName localityName) {
		if (locality.isSetLocalityName())
			return locality.getLocalityName().remove(((LocalityNameImpl)localityName).getJAXBObject());
		
		return false;
	}

}
