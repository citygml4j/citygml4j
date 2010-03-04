package org.citygml4j.visitor.walker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.citygml4j.model.xal.Address;
import org.citygml4j.model.xal.AddressDetails;
import org.citygml4j.model.xal.AddressIdentifier;
import org.citygml4j.model.xal.AddressLatitude;
import org.citygml4j.model.xal.AddressLatitudeDirection;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.AddressLines;
import org.citygml4j.model.xal.AddressLongitude;
import org.citygml4j.model.xal.AddressLongitudeDirection;
import org.citygml4j.model.xal.AdministrativeArea;
import org.citygml4j.model.xal.AdministrativeAreaName;
import org.citygml4j.model.xal.Barcode;
import org.citygml4j.model.xal.BuildingName;
import org.citygml4j.model.xal.Country;
import org.citygml4j.model.xal.CountryName;
import org.citygml4j.model.xal.CountryNameCode;
import org.citygml4j.model.xal.Department;
import org.citygml4j.model.xal.DepartmentName;
import org.citygml4j.model.xal.DependentLocality;
import org.citygml4j.model.xal.DependentLocalityName;
import org.citygml4j.model.xal.DependentLocalityNumber;
import org.citygml4j.model.xal.DependentThoroughfare;
import org.citygml4j.model.xal.EndorsementLineCode;
import org.citygml4j.model.xal.Firm;
import org.citygml4j.model.xal.FirmName;
import org.citygml4j.model.xal.KeyLineCode;
import org.citygml4j.model.xal.LargeMailUser;
import org.citygml4j.model.xal.LargeMailUserIdentifier;
import org.citygml4j.model.xal.LargeMailUserName;
import org.citygml4j.model.xal.Locality;
import org.citygml4j.model.xal.LocalityName;
import org.citygml4j.model.xal.MailStop;
import org.citygml4j.model.xal.MailStopName;
import org.citygml4j.model.xal.MailStopNumber;
import org.citygml4j.model.xal.PostBox;
import org.citygml4j.model.xal.PostBoxNumber;
import org.citygml4j.model.xal.PostBoxNumberExtension;
import org.citygml4j.model.xal.PostBoxNumberPrefix;
import org.citygml4j.model.xal.PostBoxNumberSuffix;
import org.citygml4j.model.xal.PostOffice;
import org.citygml4j.model.xal.PostOfficeName;
import org.citygml4j.model.xal.PostOfficeNumber;
import org.citygml4j.model.xal.PostTown;
import org.citygml4j.model.xal.PostTownName;
import org.citygml4j.model.xal.PostTownSuffix;
import org.citygml4j.model.xal.PostalCode;
import org.citygml4j.model.xal.PostalCodeNumber;
import org.citygml4j.model.xal.PostalCodeNumberExtension;
import org.citygml4j.model.xal.PostalRoute;
import org.citygml4j.model.xal.PostalRouteName;
import org.citygml4j.model.xal.PostalRouteNumber;
import org.citygml4j.model.xal.PostalServiceElements;
import org.citygml4j.model.xal.Premise;
import org.citygml4j.model.xal.PremiseLocation;
import org.citygml4j.model.xal.PremiseName;
import org.citygml4j.model.xal.PremiseNumber;
import org.citygml4j.model.xal.PremiseNumberPrefix;
import org.citygml4j.model.xal.PremiseNumberRange;
import org.citygml4j.model.xal.PremiseNumberRangeFrom;
import org.citygml4j.model.xal.PremiseNumberRangeTo;
import org.citygml4j.model.xal.PremiseNumberSuffix;
import org.citygml4j.model.xal.SortingCode;
import org.citygml4j.model.xal.SubAdministrativeArea;
import org.citygml4j.model.xal.SubAdministrativeAreaName;
import org.citygml4j.model.xal.SubPremise;
import org.citygml4j.model.xal.SubPremiseLocation;
import org.citygml4j.model.xal.SubPremiseName;
import org.citygml4j.model.xal.SubPremiseNumber;
import org.citygml4j.model.xal.SubPremiseNumberPrefix;
import org.citygml4j.model.xal.SubPremiseNumberSuffix;
import org.citygml4j.model.xal.SupplementaryPostalServiceData;
import org.citygml4j.model.xal.Thoroughfare;
import org.citygml4j.model.xal.ThoroughfareLeadingType;
import org.citygml4j.model.xal.ThoroughfareName;
import org.citygml4j.model.xal.ThoroughfareNumber;
import org.citygml4j.model.xal.ThoroughfareNumberFrom;
import org.citygml4j.model.xal.ThoroughfareNumberFromContent;
import org.citygml4j.model.xal.ThoroughfareNumberOrRange;
import org.citygml4j.model.xal.ThoroughfareNumberPrefix;
import org.citygml4j.model.xal.ThoroughfareNumberRange;
import org.citygml4j.model.xal.ThoroughfareNumberSuffix;
import org.citygml4j.model.xal.ThoroughfareNumberTo;
import org.citygml4j.model.xal.ThoroughfareNumberToContent;
import org.citygml4j.model.xal.ThoroughfarePostDirection;
import org.citygml4j.model.xal.ThoroughfarePreDirection;
import org.citygml4j.model.xal.ThoroughfareTrailingType;
import org.citygml4j.visitor.XALVisitor;

public abstract class XALWalker implements XALVisitor, Walker {
	private Set<Object> visited = new HashSet<Object>();
	private boolean shouldWalk = true;

	public void reset() {
		visited.clear();
		shouldWalk = true;
	}
	
	public boolean shouldWalk() {
		return shouldWalk;
	}
	
	public void setShouldWalk(boolean shouldWalk) {
		this.shouldWalk = shouldWalk;
	}
	
	public boolean addToVisited(Object object) {
		return visited.add(object);
	}
	
	public boolean hasVisited(Object object) {
		return visited.contains(object);
	}
	
	public void accept(Address address) {
	}

	public void accept(AddressDetails addressDetails) {
		if (addressDetails.isSetPostalServiceElements() && shouldWalk && visited.add(addressDetails.getPostalServiceElements()))
			addressDetails.getPostalServiceElements().visit(this);

		if (addressDetails.isSetAddress() && shouldWalk && visited.add(addressDetails.getAddress()))
			addressDetails.getAddress().visit(this);

		if (addressDetails.isSetAddressLines() && shouldWalk && visited.add(addressDetails.getAddressLines()))
			addressDetails.getAddressLines().visit(this);

		if (addressDetails.isSetCountry() && shouldWalk && visited.add(addressDetails.getCountry()))
			addressDetails.getCountry().visit(this);

		if (addressDetails.isSetAdministrativeArea() && shouldWalk && visited.add(addressDetails.getAdministrativeArea()))
			addressDetails.getAdministrativeArea().visit(this);

		if (addressDetails.isSetLocality() && shouldWalk && visited.add(addressDetails.getLocality()))
			addressDetails.getLocality().visit(this);

		if (addressDetails.isSetThoroughfare() && shouldWalk && visited.add(addressDetails.getThoroughfare()))
			addressDetails.getThoroughfare().visit(this);			
	}

	public void accept(AddressIdentifier addressIdentifier) {
	}

	public void accept(AddressLatitude addressLatitude) {
	}

	public void accept(AddressLatitudeDirection addressLatitudeDirection) {
	}

	public void accept(AddressLine addressLine) {
	}

	public void accept(AddressLines addressLines) {
		if (addressLines.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(addressLines.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}
	}

	public void accept(AddressLongitude addressLongitude) {
	}

	public void accept(AddressLongitudeDirection addressLongitudeDirection) {
	}

	public void accept(AdministrativeArea administrativeArea) {
		if (administrativeArea.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(administrativeArea.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}

		if (administrativeArea.isSetAdministrativeAreaName()) {
			for (AdministrativeAreaName administrativeAreaName : new ArrayList<AdministrativeAreaName>(administrativeArea.getAdministrativeAreaName()))
				if (shouldWalk && visited.add(administrativeAreaName))
					administrativeAreaName.visit(this);
		}

		if (administrativeArea.isSetSubAdministrativeArea() && shouldWalk && visited.add(administrativeArea.getSubAdministrativeArea()))
			administrativeArea.getSubAdministrativeArea().visit(this);

		if (administrativeArea.isSetLocality() && shouldWalk && visited.add(administrativeArea.getLocality()))
			administrativeArea.getLocality().visit(this);

		if (administrativeArea.isSetPostOffice() && shouldWalk && visited.add(administrativeArea.getPostOffice()))
			administrativeArea.getPostOffice().visit(this);

		if (administrativeArea.isSetPostalCode() && shouldWalk && visited.add(administrativeArea.getPostalCode()))
			administrativeArea.getPostalCode().visit(this);
	}

	public void accept(AdministrativeAreaName administrativeAreaName) {
	}

	public void accept(Barcode barcode) {
	}

	public void accept(BuildingName buildingName) {
	}

	public void accept(Country country) {
		if (country.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(country.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}

		if (country.isSetCountryNameCode()) {
			for (CountryNameCode countryNameCode : new ArrayList<CountryNameCode>(country.getCountryNameCode()))
				if (shouldWalk && visited.add(countryNameCode))
					countryNameCode.visit(this);
		}

		if (country.isSetCountryName()) {
			for (CountryName countryName : new ArrayList<CountryName>(country.getCountryName()))
				if (shouldWalk && visited.add(countryName))
					countryName.visit(this);
		}

		if (country.isSetAdministrativeArea() && shouldWalk && visited.add(country.getAdministrativeArea()))
			country.getAdministrativeArea().visit(this);

		if (country.isSetLocality() && shouldWalk && visited.add(country.getLocality()))
			country.getLocality().visit(this);

		if (country.isSetThoroughfare() && shouldWalk && visited.add(country.getThoroughfare()))
			country.getThoroughfare().visit(this);	
	}

	public void accept(CountryName countryName) {
	}

	public void accept(CountryNameCode countryNameCode) {
	}

	public void accept(Department department) {
		if (department.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(department.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}

		if (department.isSetDepartmentName()) {
			for (DepartmentName departmentName : new ArrayList<DepartmentName>(department.getDepartmentName()))
				if (shouldWalk && visited.add(departmentName))
					departmentName.visit(this);
		}

		if (department.isSetMailStop() && shouldWalk && visited.add(department.getMailStop()))
			department.getMailStop().visit(this);

		if (department.isSetPostalCode() && shouldWalk && visited.add(department.getPostalCode()))
			department.getPostalCode().visit(this);
	}

	public void accept(DepartmentName departmentName) {
	}

	public void accept(DependentLocality dependentLocality) {
		if (dependentLocality.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(dependentLocality.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}

		if (dependentLocality.isSetDependentLocalityName()) {
			for (DependentLocalityName dependentLocalityName : new ArrayList<DependentLocalityName>(dependentLocality.getDependentLocalityName()))
				if (shouldWalk && visited.add(dependentLocalityName))
					dependentLocalityName.visit(this);
		}

		if (dependentLocality.isSetDependentLocalityNumber() && shouldWalk && visited.add(dependentLocality.getDependentLocalityNumber()))
			dependentLocality.getDependentLocalityNumber().visit(this);

		if (dependentLocality.isSetPostBox() && shouldWalk && visited.add(dependentLocality.getPostBox()))
			dependentLocality.getPostBox().visit(this);

		if (dependentLocality.isSetLargeMailUser() & shouldWalk && visited.add(dependentLocality.getLargeMailUser()))
			dependentLocality.getLargeMailUser().visit(this);

		if (dependentLocality.isSetPostOffice() && shouldWalk && visited.add(dependentLocality.getPostOffice()))
			dependentLocality.getPostOffice().visit(this);

		if (dependentLocality.isSetPostalRoute() && shouldWalk && visited.add(dependentLocality.getPostalRoute()))
			dependentLocality.getPostalRoute().visit(this);

		if (dependentLocality.isSetThoroughfare() && shouldWalk && visited.add(dependentLocality.getThoroughfare()))
			dependentLocality.getThoroughfare().visit(this);	

		if (dependentLocality.isSetPremise() && shouldWalk && visited.add(dependentLocality.getPremise()))
			dependentLocality.getPremise().visit(this);

		if (dependentLocality.isSetDependentLocality() && shouldWalk && visited.add(dependentLocality.getDependentLocality()))
			dependentLocality.getDependentLocality().visit(this);

		if (dependentLocality.isSetPostalCode() && shouldWalk && visited.add(dependentLocality.getPostalCode()))
			dependentLocality.getPostalCode().visit(this);
	}

	public void accept(DependentLocalityName dependentLocalityName) {
	}

	public void accept(DependentLocalityNumber dependentLocalityNumber) {
	}

	public void accept(DependentThoroughfare dependentThoroughfare) {
		if (dependentThoroughfare.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(dependentThoroughfare.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}

		if (dependentThoroughfare.isSetThoroughfareName()) {
			for (ThoroughfareName thoroughfareName : new ArrayList<ThoroughfareName>(dependentThoroughfare.getThoroughfareName()))
				if (shouldWalk && visited.add(thoroughfareName))
					thoroughfareName.visit(this);
		}

		if (dependentThoroughfare.isSetThoroughfarePreDirection() && shouldWalk && visited.add(dependentThoroughfare.getThoroughfarePreDirection()))
			dependentThoroughfare.getThoroughfarePreDirection().visit(this);

		if (dependentThoroughfare.isSetThoroughfareLeadingType() && shouldWalk && visited.add(dependentThoroughfare.getThoroughfareLeadingType()))
			dependentThoroughfare.getThoroughfareLeadingType().visit(this);

		if (dependentThoroughfare.isSetThoroughfareTrailingType() && shouldWalk && visited.add(dependentThoroughfare.getThoroughfareTrailingType()))
			dependentThoroughfare.getThoroughfareTrailingType().visit(this);

		if (dependentThoroughfare.isSetThoroughfarePostDirection() && shouldWalk && visited.add(dependentThoroughfare.getThoroughfarePostDirection()))
			dependentThoroughfare.getThoroughfarePostDirection().visit(this);			
	}

	public void accept(EndorsementLineCode endorsementLineCode) {
	}

	public void accept(Firm firm) {
		if (firm.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(firm.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}

		if (firm.isSetFirmName()) {
			for (FirmName firmName : new ArrayList<FirmName>(firm.getFirmName()))
				if (shouldWalk && visited.add(firmName))
					firmName.visit(this);
		}

		if (firm.isSetDepartment()) {
			for (Department department : new ArrayList<Department>(firm.getDepartment()))
				if (shouldWalk && visited.add(department))
					department.visit(this);
		}

		if (firm.isSetMailStop() && shouldWalk && visited.add(firm.getMailStop()))
			firm.getMailStop().visit(this);

		if (firm.isSetPostalCode() && shouldWalk && visited.add(firm.getPostalCode()))
			firm.getPostalCode().visit(this);
	}

	public void accept(FirmName firmName) {
	}

	public void accept(KeyLineCode keyLineCode) {
	}

	public void accept(LargeMailUser largeMailUser) {
		if (largeMailUser.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(largeMailUser.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}

		if (largeMailUser.isSetLargeMailUserName()) {
			for (LargeMailUserName largeMailUserName : new ArrayList<LargeMailUserName>(largeMailUser.getLargeMailUserName()))
				if (shouldWalk && visited.add(largeMailUserName))
					largeMailUserName.visit(this);
		}

		if (largeMailUser.isSetBuildingName()) {
			for (BuildingName buildingName : new ArrayList<BuildingName>(largeMailUser.getBuildingName()))
				if (shouldWalk && visited.add(buildingName))
					buildingName.visit(this);
		}

		if (largeMailUser.isSetLargeMailUserIdentifier() && shouldWalk && visited.add(largeMailUser.getLargeMailUserIdentifier()))
			largeMailUser.getLargeMailUserIdentifier().visit(this);

		if (largeMailUser.isSetDepartment() && shouldWalk && visited.add(largeMailUser.getDepartment()))
			largeMailUser.getDepartment().visit(this);

		if (largeMailUser.isSetPostBox() && shouldWalk && visited.add(largeMailUser.getPostBox()))
			largeMailUser.getPostBox().visit(this);

		if (largeMailUser.isSetThoroughfare() && shouldWalk && visited.add(largeMailUser.getThoroughfare()))
			largeMailUser.getThoroughfare().visit(this);	

		if (largeMailUser.isSetPostalCode() && shouldWalk && visited.add(largeMailUser.getPostalCode()))
			largeMailUser.getPostalCode().visit(this);
	}

	public void accept(LargeMailUserIdentifier largeMailUserIdentifier) {
	}

	public void accept(LargeMailUserName largeMailUserName) {
	}

	public void accept(Locality locality) {
		if (locality.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(locality.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}

		if (locality.isSetLocalityName()) {
			for (LocalityName localityName : new ArrayList<LocalityName>(locality.getLocalityName()))
				if (shouldWalk && visited.add(localityName))
					localityName.visit(this);
		}

		if (locality.isSetPostBox() && shouldWalk && visited.add(locality.getPostBox()))
			locality.getPostBox().visit(this);

		if (locality.isSetLargeMailUser() && shouldWalk && visited.add(locality.getLargeMailUser()))
			locality.getLargeMailUser().visit(this);

		if (locality.isSetPostOffice() && shouldWalk && visited.add(locality.getPostOffice()))
			locality.getPostOffice().visit(this);

		if (locality.isSetPostalRoute() && shouldWalk && visited.add(locality.getPostalRoute()))
			locality.getPostalRoute().visit(this);

		if (locality.isSetThoroughfare() && shouldWalk && visited.add(locality.getThoroughfare()))
			locality.getThoroughfare().visit(this);	

		if (locality.isSetPremise() && shouldWalk && visited.add(locality.getPremise()))
			locality.getPremise().visit(this);

		if (locality.isSetDependentLocality() && shouldWalk && visited.add(locality.getDependentLocality()))
			locality.getDependentLocality().visit(this);

		if (locality.isSetPostalCode() && shouldWalk && visited.add(locality.getPostalCode()))
			locality.getPostalCode().visit(this);
	}

	public void accept(LocalityName localityName) {
	}

	public void accept(MailStop mailStop) {
		if (mailStop.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(mailStop.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}

		if (mailStop.isSetMailStopName() && shouldWalk && visited.add(mailStop.getMailStopName()))
			mailStop.getMailStopName().visit(this);

		if (mailStop.isSetMailStopNumber() && shouldWalk && visited.add(mailStop.getMailStopNumber()))
			mailStop.getMailStopNumber().visit(this);
	}

	public void accept(MailStopName mailStopName) {
	}

	public void accept(MailStopNumber mailStopNumber) {
	}

	public void accept(PostalCode postalCode) {
		if (postalCode.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(postalCode.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}

		if (postalCode.isSetPostalCodeNumber()) {
			for (PostalCodeNumber postalCodeNumber : new ArrayList<PostalCodeNumber>(postalCode.getPostalCodeNumber()))
				if (shouldWalk && visited.add(postalCodeNumber))
					postalCodeNumber.visit(this);
		}

		if (postalCode.isSetPostalCodeNumberExtension()) {
			for (PostalCodeNumberExtension postalCodeNumberExtension : new ArrayList<PostalCodeNumberExtension>(postalCode.getPostalCodeNumberExtension()))
				if (shouldWalk && visited.add(postalCodeNumberExtension))
					postalCodeNumberExtension.visit(this);
		}

		if (postalCode.isSetPostTown() && shouldWalk && visited.add(postalCode.getPostTown()))
			postalCode.getPostTown().visit(this);
	}

	public void accept(PostalCodeNumber postalCodeNumber) {
	}

	public void accept(PostalCodeNumberExtension postalCodeNumberExtension) {
	}

	public void accept(PostalRoute postalRoute) {
		if (postalRoute.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(postalRoute.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}

		if (postalRoute.isSetPostalRouteName()) {
			for (PostalRouteName postalRouteName : new ArrayList<PostalRouteName>(postalRoute.getPostalRouteName()))
				if (shouldWalk && visited.add(postalRouteName))
					postalRouteName.visit(this);
		}

		if (postalRoute.isSetPostalRouteNumber() && shouldWalk && visited.add(postalRoute.getPostalRouteNumber()))
			postalRoute.getPostalRouteNumber().visit(this);

		if (postalRoute.isSetPostBox() && shouldWalk && visited.add(postalRoute.getPostBox()))
			postalRoute.getPostBox().visit(this);
	}

	public void accept(PostalRouteName postalRouteName) {
	}

	public void accept(PostalRouteNumber postalRouteNumber) {
	}

	public void accept(PostalServiceElements postalServiceElements) {
		if (postalServiceElements.isSetAddressIdentifier()) {
			for (AddressIdentifier addressIdentifier : new ArrayList<AddressIdentifier>(postalServiceElements.getAddressIdentifier()))
				if (shouldWalk && visited.add(addressIdentifier))
					addressIdentifier.visit(this);
		}

		if (postalServiceElements.isSetSupplementaryPostalServiceData()) {
			for (SupplementaryPostalServiceData supplementaryPostalServiceData : new ArrayList<SupplementaryPostalServiceData>(postalServiceElements.getSupplementaryPostalServiceData()))
				if (shouldWalk && visited.add(supplementaryPostalServiceData))
					supplementaryPostalServiceData.visit(this);
		}

		if (postalServiceElements.isSetEndorsementLineCode() && shouldWalk && visited.add(postalServiceElements.getEndorsementLineCode()))
			postalServiceElements.getEndorsementLineCode().visit(this);

		if (postalServiceElements.isSetKeyLineCode() && shouldWalk && visited.add(postalServiceElements.getKeyLineCode()))
			postalServiceElements.getKeyLineCode().visit(this);

		if (postalServiceElements.isSetBarcode() && shouldWalk && visited.add(postalServiceElements.getBarcode()))
			postalServiceElements.getBarcode().visit(this);

		if (postalServiceElements.isSetSortingCode() && shouldWalk && visited.add(postalServiceElements.getSortingCode()))
			postalServiceElements.getSortingCode().visit(this);

		if (postalServiceElements.isSetAddressLatitude() && shouldWalk && visited.add(postalServiceElements.getAddressLatitude()))
			postalServiceElements.getAddressLatitude().visit(this);

		if (postalServiceElements.isSetAddressLatitudeDirection() && shouldWalk && visited.add(postalServiceElements.getAddressLatitudeDirection()))
			postalServiceElements.getAddressLatitudeDirection().visit(this);

		if (postalServiceElements.isSetAddressLongitude() && shouldWalk && visited.add(postalServiceElements.getAddressLongitude()))
			postalServiceElements.getAddressLongitude().visit(this);

		if (postalServiceElements.isSetAddressLongitudeDirection() && shouldWalk && visited.add(postalServiceElements.getAddressLongitudeDirection()))
			postalServiceElements.getAddressLongitudeDirection().visit(this);
	}

	public void accept(PostBox postBox) {
		if (postBox.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(postBox.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}

		if (postBox.isSetPostBoxNumber() && shouldWalk && visited.add(postBox.getPostBoxNumber()))
			postBox.getPostBoxNumber().visit(this);

		if (postBox.isSetPostBoxNumberPrefix() && shouldWalk && visited.add(postBox.getPostBoxNumberPrefix()))
			postBox.getPostBoxNumberPrefix().visit(this);

		if (postBox.isSetPostBoxNumberSuffix() && shouldWalk && visited.add(postBox.getPostBoxNumberSuffix()))
			postBox.getPostBoxNumberSuffix().visit(this);

		if (postBox.isSetPostBoxNumberExtension() && shouldWalk && visited.add(postBox.getPostBoxNumberExtension()))
			postBox.getPostBoxNumberExtension().visit(this);

		if (postBox.isSetFirm() && shouldWalk && visited.add(postBox.getFirm()))
			postBox.getFirm().visit(this);

		if (postBox.isSetPostalCode() && shouldWalk && visited.add(postBox.getPostalCode()))
			postBox.getPostalCode().visit(this);
	}

	public void accept(PostBoxNumber postBoxNumber) {
	}

	public void accept(PostBoxNumberExtension postBoxNumberExtension) {
	}

	public void accept(PostBoxNumberPrefix postBoxNumberPrefix) {
	}

	public void accept(PostBoxNumberSuffix postBoxNumberSuffix) {
	}

	public void accept(PostOffice postOffice) {
		if (postOffice.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(postOffice.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}

		if (postOffice.isSetPostOfficeName()) {
			for (PostOfficeName postOfficeName : new ArrayList<PostOfficeName>(postOffice.getPostOfficeName()))
				if (shouldWalk && visited.add(postOfficeName))
					postOfficeName.visit(this);
		}

		if (postOffice.isSetPostOfficeNumber() && shouldWalk && visited.add(postOffice.getPostOfficeNumber()))
			postOffice.getPostOfficeNumber().visit(this);

		if (postOffice.isSetPostalRoute() && shouldWalk && visited.add(postOffice.getPostalRoute()))
			postOffice.getPostalRoute().visit(this);

		if (postOffice.isSetPostBox() && shouldWalk && visited.add(postOffice.getPostBox()))
			postOffice.getPostBox().visit(this);

		if (postOffice.isSetPostalCode() && shouldWalk && visited.add(postOffice.getPostalCode()))
			postOffice.getPostalCode().visit(this);
	}

	public void accept(PostOfficeName postOfficeName) {
	}

	public void accept(PostOfficeNumber postOfficeNumber) {
	}

	public void accept(PostTown postTown) {
		if (postTown.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(postTown.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}

		if (postTown.isSetPostTownName()) {
			for (PostTownName postTownName : new ArrayList<PostTownName>(postTown.getPostTownName()))
				if (shouldWalk && visited.add(postTownName))
					postTownName.visit(this);
		}

		if (postTown.isSetPostTownSuffix() && shouldWalk && visited.add(postTown.getPostTownSuffix()))
			postTown.getPostTownSuffix().visit(this);
	}

	public void accept(PostTownName postTownName) {
	}

	public void accept(PostTownSuffix postTownSuffix) {
	}

	public void accept(Premise premise) {
		if (premise.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(premise.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}

		if (premise.isSetPremiseName()) {
			for (PremiseName premiseName : new ArrayList<PremiseName>(premise.getPremiseName()))
				if (shouldWalk && visited.add(premiseName))
					premiseName.visit(this);
		}

		if (premise.isSetPremiseNumber()) {
			for (PremiseNumber premiseNumber : new ArrayList<PremiseNumber>(premise.getPremiseNumber()))
				if (shouldWalk && visited.add(premiseNumber))
					premiseNumber.visit(this);
		}

		if (premise.isSetPremiseNumberPrefix()) {
			for (PremiseNumberPrefix premiseNumberPrefix : new ArrayList<PremiseNumberPrefix>(premise.getPremiseNumberPrefix()))
				if (shouldWalk && visited.add(premiseNumberPrefix))
					premiseNumberPrefix.visit(this);
		}

		if (premise.isSetPremiseNumberSuffix()) {
			for (PremiseNumberSuffix premiseNumberSuffix : new ArrayList<PremiseNumberSuffix>(premise.getPremiseNumberSuffix()))
				if (shouldWalk && visited.add(premiseNumberSuffix))
					premiseNumberSuffix.visit(this);
		}

		if (premise.isSetBuildingName()) {
			for (BuildingName buildingName : new ArrayList<BuildingName>(premise.getBuildingName()))
				if (shouldWalk && visited.add(buildingName))
					buildingName.visit(this);
		}

		if (premise.isSetSubPremise()) {
			for (SubPremise subPremise : new ArrayList<SubPremise>(premise.getSubPremise()))
				if (shouldWalk && visited.add(subPremise))
					subPremise.visit(this);
		}

		if (premise.isSetPremiseLocation() && shouldWalk && visited.add(premise.getPremiseLocation()))
			premise.getPremiseLocation().visit(this);

		if (premise.isSetPremiseNumberRange() && shouldWalk && visited.add(premise.getPremiseNumberRange()))
			premise.getPremiseNumberRange().visit(this);

		if (premise.isSetFirm() && shouldWalk && visited.add(premise.getFirm()))
			premise.getFirm().visit(this);

		if (premise.isSetMailStop() && shouldWalk && visited.add(premise.getMailStop()))
			premise.getMailStop().visit(this);

		if (premise.isSetPostalCode() && shouldWalk && visited.add(premise.getPostalCode()))
			premise.getPostalCode().visit(this);

		if (premise.isSetPremise() && shouldWalk && visited.add(premise.getPremise()))
			premise.getPremise().visit(this);
	}

	public void accept(PremiseLocation premiseLocation) {
	}

	public void accept(PremiseName premiseName) {
	}

	public void accept(PremiseNumber premiseNumber) {
	}

	public void accept(PremiseNumberPrefix premiseNumberPrefix) {
	}

	public void accept(PremiseNumberRange premiseNumberRange) {
		if (premiseNumberRange.isSetPremiseNumberRangeFrom() && shouldWalk && visited.add(premiseNumberRange.getPremiseNumberRangeFrom()))
			premiseNumberRange.getPremiseNumberRangeFrom().visit(this);

		if (premiseNumberRange.isSetPremiseNumberRangeTo() && shouldWalk && visited.add(premiseNumberRange.getPremiseNumberRangeTo()))
			premiseNumberRange.getPremiseNumberRangeTo().visit(this);
	}

	public void accept(PremiseNumberRangeFrom premiseNumberRangeFrom) {
		if (premiseNumberRangeFrom.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(premiseNumberRangeFrom.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}

		if (premiseNumberRangeFrom.isSetPremiseNumberPrefix()) {
			for (PremiseNumberPrefix premiseNumberPrefix : new ArrayList<PremiseNumberPrefix>(premiseNumberRangeFrom.getPremiseNumberPrefix()))
				if (shouldWalk && visited.add(premiseNumberPrefix))
					premiseNumberPrefix.visit(this);
		}

		if (premiseNumberRangeFrom.isSetPremiseNumber()) {
			for (PremiseNumber premiseNumber : new ArrayList<PremiseNumber>(premiseNumberRangeFrom.getPremiseNumber()))
				if (shouldWalk && visited.add(premiseNumber))
					premiseNumber.visit(this);
		}

		if (premiseNumberRangeFrom.isSetPremiseNumberSuffix()) {
			for (PremiseNumberSuffix premiseNumberSuffix : new ArrayList<PremiseNumberSuffix>(premiseNumberRangeFrom.getPremiseNumberSuffix()))
				if (shouldWalk && visited.add(premiseNumberSuffix))
					premiseNumberSuffix.visit(this);
		}
	}

	public void accept(PremiseNumberRangeTo premiseNumberRangeTo) {
		if (premiseNumberRangeTo.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(premiseNumberRangeTo.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}

		if (premiseNumberRangeTo.isSetPremiseNumberPrefix()) {
			for (PremiseNumberPrefix premiseNumberPrefix : new ArrayList<PremiseNumberPrefix>(premiseNumberRangeTo.getPremiseNumberPrefix()))
				if (shouldWalk && visited.add(premiseNumberPrefix))
					premiseNumberPrefix.visit(this);
		}

		if (premiseNumberRangeTo.isSetPremiseNumber()) {
			for (PremiseNumber premiseNumber : new ArrayList<PremiseNumber>(premiseNumberRangeTo.getPremiseNumber()))
				if (shouldWalk && visited.add(premiseNumber))
					premiseNumber.visit(this);
		}

		if (premiseNumberRangeTo.isSetPremiseNumberSuffix()) {
			for (PremiseNumberSuffix premiseNumberSuffix : new ArrayList<PremiseNumberSuffix>(premiseNumberRangeTo.getPremiseNumberSuffix()))
				if (shouldWalk && visited.add(premiseNumberSuffix))
					premiseNumberSuffix.visit(this);
		}
	}

	public void accept(PremiseNumberSuffix premiseNumberSuffix) {
	}

	public void accept(SortingCode sortingCode) {
	}

	public void accept(SubAdministrativeArea subAdministrativeArea) {
		if (subAdministrativeArea.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(subAdministrativeArea.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}

		if (subAdministrativeArea.isSetSubAdministrativeAreaName()) {
			for (SubAdministrativeAreaName subAdministrativeAreaName : new ArrayList<SubAdministrativeAreaName>(subAdministrativeArea.getSubAdministrativeAreaName()))
				if (shouldWalk && visited.add(subAdministrativeAreaName))
					subAdministrativeAreaName.visit(this);
		}

		if (subAdministrativeArea.isSetLocality() && shouldWalk && visited.add(subAdministrativeArea.getLocality()))
			subAdministrativeArea.getLocality().visit(this);

		if (subAdministrativeArea.isSetPostOffice() && shouldWalk && visited.add(subAdministrativeArea.getPostOffice()))
			subAdministrativeArea.getPostOffice().visit(this);

		if (subAdministrativeArea.isSetPostalCode() && shouldWalk && visited.add(subAdministrativeArea.getPostalCode()))
			subAdministrativeArea.getPostalCode().visit(this);
	}

	public void accept(SubAdministrativeAreaName subAdministrativeAreaName) {
	}

	public void accept(SubPremise subPremise) {
		if (subPremise.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(subPremise.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}

		if (subPremise.isSetSubPremiseName()) {
			for (SubPremiseName subPremiseName : new ArrayList<SubPremiseName>(subPremise.getSubPremiseName()))
				if (shouldWalk && visited.add(subPremiseName))
					subPremiseName.visit(this);
		}

		if (subPremise.isSetSubPremiseNumber()) {
			for (SubPremiseNumber subPremiseNumber : new ArrayList<SubPremiseNumber>(subPremise.getSubPremiseNumber()))
				if (shouldWalk && visited.add(subPremiseNumber))
					subPremiseNumber.visit(this);
		}

		if (subPremise.isSetSubPremiseNumberPrefix()) {
			for (SubPremiseNumberPrefix subPremiseNumberPrefix : new ArrayList<SubPremiseNumberPrefix>(subPremise.getSubPremiseNumberPrefix()))
				if (shouldWalk && visited.add(subPremiseNumberPrefix))
					subPremiseNumberPrefix.visit(this);
		}

		if (subPremise.isSetSubPremiseNumberSuffix()) {
			for (SubPremiseNumberSuffix subPremiseNumberSuffix : new ArrayList<SubPremiseNumberSuffix>(subPremise.getSubPremiseNumberSuffix()))
				if (shouldWalk && visited.add(subPremiseNumberSuffix))
					subPremiseNumberSuffix.visit(this);
		}

		if (subPremise.isSetBuildingName()) {
			for (BuildingName buildingName : new ArrayList<BuildingName>(subPremise.getBuildingName()))
				if (shouldWalk && visited.add(buildingName))
					buildingName.visit(this);
		}

		if (subPremise.isSetFirm() && shouldWalk && visited.add(subPremise.getFirm()))
			subPremise.getFirm().visit(this);

		if (subPremise.isSetSubPremiseLocation() && shouldWalk && visited.add(subPremise.getSubPremiseLocation()))
			subPremise.getSubPremiseLocation().visit(this);

		if (subPremise.isSetMailStop() && shouldWalk && visited.add(subPremise.getMailStop()))
			subPremise.getMailStop().visit(this);

		if (subPremise.isSetPostalCode() && shouldWalk && visited.add(subPremise.getPostalCode()))
			subPremise.getPostalCode().visit(this);

		if (subPremise.isSetSubPremise() && shouldWalk && visited.add(subPremise.getSubPremise()))
			subPremise.getSubPremise().visit(this);
	}

	public void accept(SubPremiseLocation subPremiseLocation) {
	}

	public void accept(SubPremiseName subPremiseName) {
	}

	public void accept(SubPremiseNumber subPremiseNumber) {
	}

	public void accept(SubPremiseNumberPrefix subPremiseNumberPrefix) {
	}

	public void accept(SubPremiseNumberSuffix subPremiseNumberSuffix) {
	}

	public void accept(SupplementaryPostalServiceData supplementaryPostalServiceData) {
	}

	public void accept(Thoroughfare thoroughfare) {
		if (thoroughfare.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(thoroughfare.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}

		if (thoroughfare.isSetThoroughfareNumberOrThoroughfareNumberRange()) {
			for (ThoroughfareNumberOrRange thoroughfareNumberOrRange : new ArrayList<ThoroughfareNumberOrRange>(thoroughfare.getThoroughfareNumberOrThoroughfareNumberRange())) {
				if (shouldWalk) {
					if (thoroughfareNumberOrRange.isSetThoroughfareNumber() && visited.add(thoroughfareNumberOrRange.getThoroughfareNumber()))
						thoroughfareNumberOrRange.getThoroughfareNumber().visit(this);
					else if (thoroughfareNumberOrRange.isSetThoroughfareNumberRange() && visited.add(thoroughfareNumberOrRange.getThoroughfareNumberRange()))
						thoroughfareNumberOrRange.getThoroughfareNumberRange().visit(this);
				}
			}
		}

		if (thoroughfare.isSetThoroughfareNumberPrefix()) {
			for (ThoroughfareNumberPrefix numberPrefix : new ArrayList<ThoroughfareNumberPrefix>(thoroughfare.getThoroughfareNumberPrefix()))
				if (shouldWalk && visited.add(numberPrefix))
					numberPrefix.visit(this);
		}

		if (thoroughfare.isSetThoroughfareNumberSuffix()) {
			for (ThoroughfareNumberSuffix numberSuffix : new ArrayList<ThoroughfareNumberSuffix>(thoroughfare.getThoroughfareNumberSuffix()))
				if (shouldWalk && visited.add(numberSuffix))
					numberSuffix.visit(this);
		}

		if (thoroughfare.isSetThoroughfareName()) {
			for (ThoroughfareName thoroughfareName : new ArrayList<ThoroughfareName>(thoroughfare.getThoroughfareName()))
				if (shouldWalk && visited.add(thoroughfareName))
					thoroughfareName.visit(this);
		}		

		if (thoroughfare.isSetThoroughfarePreDirection() && shouldWalk && visited.add(thoroughfare.getThoroughfarePreDirection()))
			thoroughfare.getThoroughfarePreDirection().visit(this);

		if (thoroughfare.isSetThoroughfareLeadingType() && shouldWalk && visited.add(thoroughfare.getThoroughfareLeadingType()))
			thoroughfare.getThoroughfareLeadingType().visit(this);

		if (thoroughfare.isSetThoroughfareTrailingType() && shouldWalk && visited.add(thoroughfare.getThoroughfareTrailingType()))
			thoroughfare.getThoroughfareTrailingType().visit(this);

		if (thoroughfare.isSetThoroughfarePostDirection() && shouldWalk && visited.add(thoroughfare.getThoroughfarePostDirection()))
			thoroughfare.getThoroughfarePostDirection().visit(this);

		if (thoroughfare.isSetDependentThoroughfare() && shouldWalk && visited.add(thoroughfare.getDependentThoroughfare()))
			thoroughfare.getDependentThoroughfare().visit(this);

		if (thoroughfare.isSetDependentLocality() && shouldWalk && visited.add(thoroughfare.getDependentLocality()))
			thoroughfare.getDependentLocality().visit(this);

		if (thoroughfare.isSetPremise() && shouldWalk && visited.add(thoroughfare.getPremise()))
			thoroughfare.getPremise().visit(this);

		if (thoroughfare.isSetFirm() && shouldWalk && visited.add(thoroughfare.getFirm()))
			thoroughfare.getFirm().visit(this);

		if (thoroughfare.isSetPostalCode() && shouldWalk && visited.add(thoroughfare.getPostalCode()))
			thoroughfare.getPostalCode().visit(this);
	}

	public void accept(ThoroughfareLeadingType thoroughfareLeadingType) {
	}

	public void accept(ThoroughfareName thoroughfareName) {
	}

	public void accept(ThoroughfareNumber thoroughfareNumber) {
	}

	public void accept(ThoroughfareNumberFrom thoroughfareNumberFrom) {
		if (thoroughfareNumberFrom.isSetContent()) {
			for (ThoroughfareNumberFromContent content : new ArrayList<ThoroughfareNumberFromContent>(thoroughfareNumberFrom.getContent())) {
				if (shouldWalk) {
					if (content.isSetAddressLine() && visited.add(content.getAddressLine()))
						content.getAddressLine().visit(this);
					else if (content.isSetThoroughfareNumber() && visited.add(content.getThoroughfareNumber()))
						content.getThoroughfareNumber().visit(this);
					else if (content.isSetThoroughfareNumberPrefix() && visited.add(content.getThoroughfareNumberPrefix()))
						content.getThoroughfareNumberPrefix().visit(this);
					else if (content.isSetThoroughfareNumberSuffix() && visited.add(content.getThoroughfareNumberSuffix()))
						content.getThoroughfareNumberSuffix().visit(this);
				}
			}
		}
	}

	public void accept(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
	}

	public void accept(ThoroughfareNumberRange thoroughfareNumberRange) {
		if (thoroughfareNumberRange.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(thoroughfareNumberRange.getAddressLine()))
				if (shouldWalk && visited.add(addressLine))
					addressLine.visit(this);
		}
		
		if (thoroughfareNumberRange.isSetThoroughfareNumberFrom() && shouldWalk && visited.add(thoroughfareNumberRange.getThoroughfareNumberFrom()))
			thoroughfareNumberRange.getThoroughfareNumberFrom().visit(this);
		
		if (thoroughfareNumberRange.isSetThoroughfareNumberTo() && shouldWalk && visited.add(thoroughfareNumberRange.getThoroughfareNumberTo()))
			thoroughfareNumberRange.getThoroughfareNumberTo().visit(this);
	}

	public void accept(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
	}

	public void accept(ThoroughfareNumberTo thoroughfareNumberTo) {
		if (thoroughfareNumberTo.isSetContent()) {
			for (ThoroughfareNumberToContent content : new ArrayList<ThoroughfareNumberToContent>(thoroughfareNumberTo.getContent())) {
				if (shouldWalk) {
					if (content.isSetAddressLine() && visited.add(content.getAddressLine()))
						content.getAddressLine().visit(this);
					else if (content.isSetThoroughfareNumber() && visited.add(content.getThoroughfareNumber()))
						content.getThoroughfareNumber().visit(this);
					else if (content.isSetThoroughfareNumberPrefix() && visited.add(content.getThoroughfareNumberPrefix()))
						content.getThoroughfareNumberPrefix().visit(this);
					else if (content.isSetThoroughfareNumberSuffix() && visited.add(content.getThoroughfareNumberSuffix()))
						content.getThoroughfareNumberSuffix().visit(this);
				}
			}
		}
	}

	public void accept(ThoroughfarePostDirection thoroughfarePostDirection) {
	}

	public void accept(ThoroughfarePreDirection thoroughfarePreDirection) {
	}

	public void accept(ThoroughfareTrailingType thoroughfareTrailingType) {
	} 

}
