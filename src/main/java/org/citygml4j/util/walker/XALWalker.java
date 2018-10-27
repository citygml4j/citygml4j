/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.util.walker;

import org.citygml4j.model.common.visitor.XALVisitor;
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

import java.util.ArrayList;

public abstract class XALWalker extends Walker implements XALVisitor {
	
	public void visit(Address address) {
	}

	public void visit(AddressDetails addressDetails) {
		if (addressDetails.isSetPostalServiceElements() && shouldWalk)
			addressDetails.getPostalServiceElements().accept(this);

		if (addressDetails.isSetAddress() && shouldWalk)
			addressDetails.getAddress().accept(this);

		if (addressDetails.isSetAddressLines() && shouldWalk)
			addressDetails.getAddressLines().accept(this);

		if (addressDetails.isSetCountry() && shouldWalk)
			addressDetails.getCountry().accept(this);

		if (addressDetails.isSetAdministrativeArea() && shouldWalk)
			addressDetails.getAdministrativeArea().accept(this);

		if (addressDetails.isSetLocality() && shouldWalk)
			addressDetails.getLocality().accept(this);

		if (addressDetails.isSetThoroughfare() && shouldWalk)
			addressDetails.getThoroughfare().accept(this);			
	}

	public void visit(AddressIdentifier addressIdentifier) {
	}

	public void visit(AddressLatitude addressLatitude) {
	}

	public void visit(AddressLatitudeDirection addressLatitudeDirection) {
	}

	public void visit(AddressLine addressLine) {
	}

	public void visit(AddressLines addressLines) {
		if (addressLines.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(addressLines.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}
	}

	public void visit(AddressLongitude addressLongitude) {
	}

	public void visit(AddressLongitudeDirection addressLongitudeDirection) {
	}

	public void visit(AdministrativeArea administrativeArea) {
		if (administrativeArea.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(administrativeArea.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}

		if (administrativeArea.isSetAdministrativeAreaName()) {
			for (AdministrativeAreaName administrativeAreaName : new ArrayList<AdministrativeAreaName>(administrativeArea.getAdministrativeAreaName()))
				if (shouldWalk)
					administrativeAreaName.accept(this);
		}

		if (administrativeArea.isSetSubAdministrativeArea() && shouldWalk)
			administrativeArea.getSubAdministrativeArea().accept(this);

		if (administrativeArea.isSetLocality() && shouldWalk)
			administrativeArea.getLocality().accept(this);

		if (administrativeArea.isSetPostOffice() && shouldWalk)
			administrativeArea.getPostOffice().accept(this);

		if (administrativeArea.isSetPostalCode() && shouldWalk)
			administrativeArea.getPostalCode().accept(this);
	}

	public void visit(AdministrativeAreaName administrativeAreaName) {
	}

	public void visit(Barcode barcode) {
	}

	public void visit(BuildingName buildingName) {
	}

	public void visit(Country country) {
		if (country.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(country.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}

		if (country.isSetCountryNameCode()) {
			for (CountryNameCode countryNameCode : new ArrayList<CountryNameCode>(country.getCountryNameCode()))
				if (shouldWalk)
					countryNameCode.accept(this);
		}

		if (country.isSetCountryName()) {
			for (CountryName countryName : new ArrayList<CountryName>(country.getCountryName()))
				if (shouldWalk)
					countryName.accept(this);
		}

		if (country.isSetAdministrativeArea() && shouldWalk)
			country.getAdministrativeArea().accept(this);

		if (country.isSetLocality() && shouldWalk)
			country.getLocality().accept(this);

		if (country.isSetThoroughfare() && shouldWalk)
			country.getThoroughfare().accept(this);	
	}

	public void visit(CountryName countryName) {
	}

	public void visit(CountryNameCode countryNameCode) {
	}

	public void visit(Department department) {
		if (department.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(department.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}

		if (department.isSetDepartmentName()) {
			for (DepartmentName departmentName : new ArrayList<DepartmentName>(department.getDepartmentName()))
				if (shouldWalk)
					departmentName.accept(this);
		}

		if (department.isSetMailStop() && shouldWalk)
			department.getMailStop().accept(this);

		if (department.isSetPostalCode() && shouldWalk)
			department.getPostalCode().accept(this);
	}

	public void visit(DepartmentName departmentName) {
	}

	public void visit(DependentLocality dependentLocality) {
		if (dependentLocality.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(dependentLocality.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}

		if (dependentLocality.isSetDependentLocalityName()) {
			for (DependentLocalityName dependentLocalityName : new ArrayList<DependentLocalityName>(dependentLocality.getDependentLocalityName()))
				if (shouldWalk)
					dependentLocalityName.accept(this);
		}

		if (dependentLocality.isSetDependentLocalityNumber() && shouldWalk)
			dependentLocality.getDependentLocalityNumber().accept(this);

		if (dependentLocality.isSetPostBox() && shouldWalk)
			dependentLocality.getPostBox().accept(this);

		if (dependentLocality.isSetLargeMailUser() & shouldWalk)
			dependentLocality.getLargeMailUser().accept(this);

		if (dependentLocality.isSetPostOffice() && shouldWalk)
			dependentLocality.getPostOffice().accept(this);

		if (dependentLocality.isSetPostalRoute() && shouldWalk)
			dependentLocality.getPostalRoute().accept(this);

		if (dependentLocality.isSetThoroughfare() && shouldWalk)
			dependentLocality.getThoroughfare().accept(this);	

		if (dependentLocality.isSetPremise() && shouldWalk)
			dependentLocality.getPremise().accept(this);

		if (dependentLocality.isSetDependentLocality() && shouldWalk)
			dependentLocality.getDependentLocality().accept(this);

		if (dependentLocality.isSetPostalCode() && shouldWalk)
			dependentLocality.getPostalCode().accept(this);
	}

	public void visit(DependentLocalityName dependentLocalityName) {
	}

	public void visit(DependentLocalityNumber dependentLocalityNumber) {
	}

	public void visit(DependentThoroughfare dependentThoroughfare) {
		if (dependentThoroughfare.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(dependentThoroughfare.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}

		if (dependentThoroughfare.isSetThoroughfareName()) {
			for (ThoroughfareName thoroughfareName : new ArrayList<ThoroughfareName>(dependentThoroughfare.getThoroughfareName()))
				if (shouldWalk)
					thoroughfareName.accept(this);
		}

		if (dependentThoroughfare.isSetThoroughfarePreDirection() && shouldWalk)
			dependentThoroughfare.getThoroughfarePreDirection().accept(this);

		if (dependentThoroughfare.isSetThoroughfareLeadingType() && shouldWalk)
			dependentThoroughfare.getThoroughfareLeadingType().accept(this);

		if (dependentThoroughfare.isSetThoroughfareTrailingType() && shouldWalk)
			dependentThoroughfare.getThoroughfareTrailingType().accept(this);

		if (dependentThoroughfare.isSetThoroughfarePostDirection() && shouldWalk)
			dependentThoroughfare.getThoroughfarePostDirection().accept(this);			
	}

	public void visit(EndorsementLineCode endorsementLineCode) {
	}

	public void visit(Firm firm) {
		if (firm.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(firm.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}

		if (firm.isSetFirmName()) {
			for (FirmName firmName : new ArrayList<FirmName>(firm.getFirmName()))
				if (shouldWalk)
					firmName.accept(this);
		}

		if (firm.isSetDepartment()) {
			for (Department department : new ArrayList<Department>(firm.getDepartment()))
				if (shouldWalk)
					department.accept(this);
		}

		if (firm.isSetMailStop() && shouldWalk)
			firm.getMailStop().accept(this);

		if (firm.isSetPostalCode() && shouldWalk)
			firm.getPostalCode().accept(this);
	}

	public void visit(FirmName firmName) {
	}

	public void visit(KeyLineCode keyLineCode) {
	}

	public void visit(LargeMailUser largeMailUser) {
		if (largeMailUser.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(largeMailUser.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}

		if (largeMailUser.isSetLargeMailUserName()) {
			for (LargeMailUserName largeMailUserName : new ArrayList<LargeMailUserName>(largeMailUser.getLargeMailUserName()))
				if (shouldWalk)
					largeMailUserName.accept(this);
		}

		if (largeMailUser.isSetBuildingName()) {
			for (BuildingName buildingName : new ArrayList<BuildingName>(largeMailUser.getBuildingName()))
				if (shouldWalk)
					buildingName.accept(this);
		}

		if (largeMailUser.isSetLargeMailUserIdentifier() && shouldWalk)
			largeMailUser.getLargeMailUserIdentifier().accept(this);

		if (largeMailUser.isSetDepartment() && shouldWalk)
			largeMailUser.getDepartment().accept(this);

		if (largeMailUser.isSetPostBox() && shouldWalk)
			largeMailUser.getPostBox().accept(this);

		if (largeMailUser.isSetThoroughfare() && shouldWalk)
			largeMailUser.getThoroughfare().accept(this);	

		if (largeMailUser.isSetPostalCode() && shouldWalk)
			largeMailUser.getPostalCode().accept(this);
	}

	public void visit(LargeMailUserIdentifier largeMailUserIdentifier) {
	}

	public void visit(LargeMailUserName largeMailUserName) {
	}

	public void visit(Locality locality) {
		if (locality.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(locality.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}

		if (locality.isSetLocalityName()) {
			for (LocalityName localityName : new ArrayList<LocalityName>(locality.getLocalityName()))
				if (shouldWalk)
					localityName.accept(this);
		}

		if (locality.isSetPostBox() && shouldWalk)
			locality.getPostBox().accept(this);

		if (locality.isSetLargeMailUser() && shouldWalk)
			locality.getLargeMailUser().accept(this);

		if (locality.isSetPostOffice() && shouldWalk)
			locality.getPostOffice().accept(this);

		if (locality.isSetPostalRoute() && shouldWalk)
			locality.getPostalRoute().accept(this);

		if (locality.isSetThoroughfare() && shouldWalk)
			locality.getThoroughfare().accept(this);	

		if (locality.isSetPremise() && shouldWalk)
			locality.getPremise().accept(this);

		if (locality.isSetDependentLocality() && shouldWalk)
			locality.getDependentLocality().accept(this);

		if (locality.isSetPostalCode() && shouldWalk)
			locality.getPostalCode().accept(this);
	}

	public void visit(LocalityName localityName) {
	}

	public void visit(MailStop mailStop) {
		if (mailStop.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(mailStop.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}

		if (mailStop.isSetMailStopName() && shouldWalk)
			mailStop.getMailStopName().accept(this);

		if (mailStop.isSetMailStopNumber() && shouldWalk)
			mailStop.getMailStopNumber().accept(this);
	}

	public void visit(MailStopName mailStopName) {
	}

	public void visit(MailStopNumber mailStopNumber) {
	}

	public void visit(PostalCode postalCode) {
		if (postalCode.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(postalCode.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}

		if (postalCode.isSetPostalCodeNumber()) {
			for (PostalCodeNumber postalCodeNumber : new ArrayList<PostalCodeNumber>(postalCode.getPostalCodeNumber()))
				if (shouldWalk)
					postalCodeNumber.accept(this);
		}

		if (postalCode.isSetPostalCodeNumberExtension()) {
			for (PostalCodeNumberExtension postalCodeNumberExtension : new ArrayList<PostalCodeNumberExtension>(postalCode.getPostalCodeNumberExtension()))
				if (shouldWalk)
					postalCodeNumberExtension.accept(this);
		}

		if (postalCode.isSetPostTown() && shouldWalk)
			postalCode.getPostTown().accept(this);
	}

	public void visit(PostalCodeNumber postalCodeNumber) {
	}

	public void visit(PostalCodeNumberExtension postalCodeNumberExtension) {
	}

	public void visit(PostalRoute postalRoute) {
		if (postalRoute.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(postalRoute.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}

		if (postalRoute.isSetPostalRouteName()) {
			for (PostalRouteName postalRouteName : new ArrayList<PostalRouteName>(postalRoute.getPostalRouteName()))
				if (shouldWalk)
					postalRouteName.accept(this);
		}

		if (postalRoute.isSetPostalRouteNumber() && shouldWalk)
			postalRoute.getPostalRouteNumber().accept(this);

		if (postalRoute.isSetPostBox() && shouldWalk)
			postalRoute.getPostBox().accept(this);
	}

	public void visit(PostalRouteName postalRouteName) {
	}

	public void visit(PostalRouteNumber postalRouteNumber) {
	}

	public void visit(PostalServiceElements postalServiceElements) {
		if (postalServiceElements.isSetAddressIdentifier()) {
			for (AddressIdentifier addressIdentifier : new ArrayList<AddressIdentifier>(postalServiceElements.getAddressIdentifier()))
				if (shouldWalk)
					addressIdentifier.accept(this);
		}

		if (postalServiceElements.isSetSupplementaryPostalServiceData()) {
			for (SupplementaryPostalServiceData supplementaryPostalServiceData : new ArrayList<SupplementaryPostalServiceData>(postalServiceElements.getSupplementaryPostalServiceData()))
				if (shouldWalk)
					supplementaryPostalServiceData.accept(this);
		}

		if (postalServiceElements.isSetEndorsementLineCode() && shouldWalk)
			postalServiceElements.getEndorsementLineCode().accept(this);

		if (postalServiceElements.isSetKeyLineCode() && shouldWalk)
			postalServiceElements.getKeyLineCode().accept(this);

		if (postalServiceElements.isSetBarcode() && shouldWalk)
			postalServiceElements.getBarcode().accept(this);

		if (postalServiceElements.isSetSortingCode() && shouldWalk)
			postalServiceElements.getSortingCode().accept(this);

		if (postalServiceElements.isSetAddressLatitude() && shouldWalk)
			postalServiceElements.getAddressLatitude().accept(this);

		if (postalServiceElements.isSetAddressLatitudeDirection() && shouldWalk)
			postalServiceElements.getAddressLatitudeDirection().accept(this);

		if (postalServiceElements.isSetAddressLongitude() && shouldWalk)
			postalServiceElements.getAddressLongitude().accept(this);

		if (postalServiceElements.isSetAddressLongitudeDirection() && shouldWalk)
			postalServiceElements.getAddressLongitudeDirection().accept(this);
	}

	public void visit(PostBox postBox) {
		if (postBox.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(postBox.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}

		if (postBox.isSetPostBoxNumber() && shouldWalk)
			postBox.getPostBoxNumber().accept(this);

		if (postBox.isSetPostBoxNumberPrefix() && shouldWalk)
			postBox.getPostBoxNumberPrefix().accept(this);

		if (postBox.isSetPostBoxNumberSuffix() && shouldWalk)
			postBox.getPostBoxNumberSuffix().accept(this);

		if (postBox.isSetPostBoxNumberExtension() && shouldWalk)
			postBox.getPostBoxNumberExtension().accept(this);

		if (postBox.isSetFirm() && shouldWalk)
			postBox.getFirm().accept(this);

		if (postBox.isSetPostalCode() && shouldWalk)
			postBox.getPostalCode().accept(this);
	}

	public void visit(PostBoxNumber postBoxNumber) {
	}

	public void visit(PostBoxNumberExtension postBoxNumberExtension) {
	}

	public void visit(PostBoxNumberPrefix postBoxNumberPrefix) {
	}

	public void visit(PostBoxNumberSuffix postBoxNumberSuffix) {
	}

	public void visit(PostOffice postOffice) {
		if (postOffice.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(postOffice.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}

		if (postOffice.isSetPostOfficeName()) {
			for (PostOfficeName postOfficeName : new ArrayList<PostOfficeName>(postOffice.getPostOfficeName()))
				if (shouldWalk)
					postOfficeName.accept(this);
		}

		if (postOffice.isSetPostOfficeNumber() && shouldWalk)
			postOffice.getPostOfficeNumber().accept(this);

		if (postOffice.isSetPostalRoute() && shouldWalk)
			postOffice.getPostalRoute().accept(this);

		if (postOffice.isSetPostBox() && shouldWalk)
			postOffice.getPostBox().accept(this);

		if (postOffice.isSetPostalCode() && shouldWalk)
			postOffice.getPostalCode().accept(this);
	}

	public void visit(PostOfficeName postOfficeName) {
	}

	public void visit(PostOfficeNumber postOfficeNumber) {
	}

	public void visit(PostTown postTown) {
		if (postTown.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(postTown.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}

		if (postTown.isSetPostTownName()) {
			for (PostTownName postTownName : new ArrayList<PostTownName>(postTown.getPostTownName()))
				if (shouldWalk)
					postTownName.accept(this);
		}

		if (postTown.isSetPostTownSuffix() && shouldWalk)
			postTown.getPostTownSuffix().accept(this);
	}

	public void visit(PostTownName postTownName) {
	}

	public void visit(PostTownSuffix postTownSuffix) {
	}

	public void visit(Premise premise) {
		if (premise.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(premise.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}

		if (premise.isSetPremiseName()) {
			for (PremiseName premiseName : new ArrayList<PremiseName>(premise.getPremiseName()))
				if (shouldWalk)
					premiseName.accept(this);
		}

		if (premise.isSetPremiseNumber()) {
			for (PremiseNumber premiseNumber : new ArrayList<PremiseNumber>(premise.getPremiseNumber()))
				if (shouldWalk)
					premiseNumber.accept(this);
		}

		if (premise.isSetPremiseNumberPrefix()) {
			for (PremiseNumberPrefix premiseNumberPrefix : new ArrayList<PremiseNumberPrefix>(premise.getPremiseNumberPrefix()))
				if (shouldWalk)
					premiseNumberPrefix.accept(this);
		}

		if (premise.isSetPremiseNumberSuffix()) {
			for (PremiseNumberSuffix premiseNumberSuffix : new ArrayList<PremiseNumberSuffix>(premise.getPremiseNumberSuffix()))
				if (shouldWalk)
					premiseNumberSuffix.accept(this);
		}

		if (premise.isSetBuildingName()) {
			for (BuildingName buildingName : new ArrayList<BuildingName>(premise.getBuildingName()))
				if (shouldWalk)
					buildingName.accept(this);
		}

		if (premise.isSetSubPremise()) {
			for (SubPremise subPremise : new ArrayList<SubPremise>(premise.getSubPremise()))
				if (shouldWalk)
					subPremise.accept(this);
		}

		if (premise.isSetPremiseLocation() && shouldWalk)
			premise.getPremiseLocation().accept(this);

		if (premise.isSetPremiseNumberRange() && shouldWalk)
			premise.getPremiseNumberRange().accept(this);

		if (premise.isSetFirm() && shouldWalk)
			premise.getFirm().accept(this);

		if (premise.isSetMailStop() && shouldWalk)
			premise.getMailStop().accept(this);

		if (premise.isSetPostalCode() && shouldWalk)
			premise.getPostalCode().accept(this);

		if (premise.isSetPremise() && shouldWalk)
			premise.getPremise().accept(this);
	}

	public void visit(PremiseLocation premiseLocation) {
	}

	public void visit(PremiseName premiseName) {
	}

	public void visit(PremiseNumber premiseNumber) {
	}

	public void visit(PremiseNumberPrefix premiseNumberPrefix) {
	}

	public void visit(PremiseNumberRange premiseNumberRange) {
		if (premiseNumberRange.isSetPremiseNumberRangeFrom() && shouldWalk)
			premiseNumberRange.getPremiseNumberRangeFrom().accept(this);

		if (premiseNumberRange.isSetPremiseNumberRangeTo() && shouldWalk)
			premiseNumberRange.getPremiseNumberRangeTo().accept(this);
	}

	public void visit(PremiseNumberRangeFrom premiseNumberRangeFrom) {
		if (premiseNumberRangeFrom.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(premiseNumberRangeFrom.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}

		if (premiseNumberRangeFrom.isSetPremiseNumberPrefix()) {
			for (PremiseNumberPrefix premiseNumberPrefix : new ArrayList<PremiseNumberPrefix>(premiseNumberRangeFrom.getPremiseNumberPrefix()))
				if (shouldWalk)
					premiseNumberPrefix.accept(this);
		}

		if (premiseNumberRangeFrom.isSetPremiseNumber()) {
			for (PremiseNumber premiseNumber : new ArrayList<PremiseNumber>(premiseNumberRangeFrom.getPremiseNumber()))
				if (shouldWalk)
					premiseNumber.accept(this);
		}

		if (premiseNumberRangeFrom.isSetPremiseNumberSuffix()) {
			for (PremiseNumberSuffix premiseNumberSuffix : new ArrayList<PremiseNumberSuffix>(premiseNumberRangeFrom.getPremiseNumberSuffix()))
				if (shouldWalk)
					premiseNumberSuffix.accept(this);
		}
	}

	public void visit(PremiseNumberRangeTo premiseNumberRangeTo) {
		if (premiseNumberRangeTo.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(premiseNumberRangeTo.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}

		if (premiseNumberRangeTo.isSetPremiseNumberPrefix()) {
			for (PremiseNumberPrefix premiseNumberPrefix : new ArrayList<PremiseNumberPrefix>(premiseNumberRangeTo.getPremiseNumberPrefix()))
				if (shouldWalk)
					premiseNumberPrefix.accept(this);
		}

		if (premiseNumberRangeTo.isSetPremiseNumber()) {
			for (PremiseNumber premiseNumber : new ArrayList<PremiseNumber>(premiseNumberRangeTo.getPremiseNumber()))
				if (shouldWalk)
					premiseNumber.accept(this);
		}

		if (premiseNumberRangeTo.isSetPremiseNumberSuffix()) {
			for (PremiseNumberSuffix premiseNumberSuffix : new ArrayList<PremiseNumberSuffix>(premiseNumberRangeTo.getPremiseNumberSuffix()))
				if (shouldWalk)
					premiseNumberSuffix.accept(this);
		}
	}

	public void visit(PremiseNumberSuffix premiseNumberSuffix) {
	}

	public void visit(SortingCode sortingCode) {
	}

	public void visit(SubAdministrativeArea subAdministrativeArea) {
		if (subAdministrativeArea.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(subAdministrativeArea.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}

		if (subAdministrativeArea.isSetSubAdministrativeAreaName()) {
			for (SubAdministrativeAreaName subAdministrativeAreaName : new ArrayList<SubAdministrativeAreaName>(subAdministrativeArea.getSubAdministrativeAreaName()))
				if (shouldWalk)
					subAdministrativeAreaName.accept(this);
		}

		if (subAdministrativeArea.isSetLocality() && shouldWalk)
			subAdministrativeArea.getLocality().accept(this);

		if (subAdministrativeArea.isSetPostOffice() && shouldWalk)
			subAdministrativeArea.getPostOffice().accept(this);

		if (subAdministrativeArea.isSetPostalCode() && shouldWalk)
			subAdministrativeArea.getPostalCode().accept(this);
	}

	public void visit(SubAdministrativeAreaName subAdministrativeAreaName) {
	}

	public void visit(SubPremise subPremise) {
		if (subPremise.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(subPremise.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}

		if (subPremise.isSetSubPremiseName()) {
			for (SubPremiseName subPremiseName : new ArrayList<SubPremiseName>(subPremise.getSubPremiseName()))
				if (shouldWalk)
					subPremiseName.accept(this);
		}

		if (subPremise.isSetSubPremiseNumber()) {
			for (SubPremiseNumber subPremiseNumber : new ArrayList<SubPremiseNumber>(subPremise.getSubPremiseNumber()))
				if (shouldWalk)
					subPremiseNumber.accept(this);
		}

		if (subPremise.isSetSubPremiseNumberPrefix()) {
			for (SubPremiseNumberPrefix subPremiseNumberPrefix : new ArrayList<SubPremiseNumberPrefix>(subPremise.getSubPremiseNumberPrefix()))
				if (shouldWalk)
					subPremiseNumberPrefix.accept(this);
		}

		if (subPremise.isSetSubPremiseNumberSuffix()) {
			for (SubPremiseNumberSuffix subPremiseNumberSuffix : new ArrayList<SubPremiseNumberSuffix>(subPremise.getSubPremiseNumberSuffix()))
				if (shouldWalk)
					subPremiseNumberSuffix.accept(this);
		}

		if (subPremise.isSetBuildingName()) {
			for (BuildingName buildingName : new ArrayList<BuildingName>(subPremise.getBuildingName()))
				if (shouldWalk)
					buildingName.accept(this);
		}

		if (subPremise.isSetFirm() && shouldWalk)
			subPremise.getFirm().accept(this);

		if (subPremise.isSetSubPremiseLocation() && shouldWalk)
			subPremise.getSubPremiseLocation().accept(this);

		if (subPremise.isSetMailStop() && shouldWalk)
			subPremise.getMailStop().accept(this);

		if (subPremise.isSetPostalCode() && shouldWalk)
			subPremise.getPostalCode().accept(this);

		if (subPremise.isSetSubPremise() && shouldWalk)
			subPremise.getSubPremise().accept(this);
	}

	public void visit(SubPremiseLocation subPremiseLocation) {
	}

	public void visit(SubPremiseName subPremiseName) {
	}

	public void visit(SubPremiseNumber subPremiseNumber) {
	}

	public void visit(SubPremiseNumberPrefix subPremiseNumberPrefix) {
	}

	public void visit(SubPremiseNumberSuffix subPremiseNumberSuffix) {
	}

	public void visit(SupplementaryPostalServiceData supplementaryPostalServiceData) {
	}

	public void visit(Thoroughfare thoroughfare) {
		if (thoroughfare.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(thoroughfare.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}

		if (thoroughfare.isSetThoroughfareNumberOrThoroughfareNumberRange()) {
			for (ThoroughfareNumberOrRange thoroughfareNumberOrRange : new ArrayList<ThoroughfareNumberOrRange>(thoroughfare.getThoroughfareNumberOrThoroughfareNumberRange())) {
				if (shouldWalk) {
					if (thoroughfareNumberOrRange.isSetThoroughfareNumber())
						thoroughfareNumberOrRange.getThoroughfareNumber().accept(this);
					else if (thoroughfareNumberOrRange.isSetThoroughfareNumberRange())
						thoroughfareNumberOrRange.getThoroughfareNumberRange().accept(this);
				}
			}
		}

		if (thoroughfare.isSetThoroughfareNumberPrefix()) {
			for (ThoroughfareNumberPrefix numberPrefix : new ArrayList<ThoroughfareNumberPrefix>(thoroughfare.getThoroughfareNumberPrefix()))
				if (shouldWalk)
					numberPrefix.accept(this);
		}

		if (thoroughfare.isSetThoroughfareNumberSuffix()) {
			for (ThoroughfareNumberSuffix numberSuffix : new ArrayList<ThoroughfareNumberSuffix>(thoroughfare.getThoroughfareNumberSuffix()))
				if (shouldWalk)
					numberSuffix.accept(this);
		}

		if (thoroughfare.isSetThoroughfareName()) {
			for (ThoroughfareName thoroughfareName : new ArrayList<ThoroughfareName>(thoroughfare.getThoroughfareName()))
				if (shouldWalk)
					thoroughfareName.accept(this);
		}		

		if (thoroughfare.isSetThoroughfarePreDirection() && shouldWalk)
			thoroughfare.getThoroughfarePreDirection().accept(this);

		if (thoroughfare.isSetThoroughfareLeadingType() && shouldWalk)
			thoroughfare.getThoroughfareLeadingType().accept(this);

		if (thoroughfare.isSetThoroughfareTrailingType() && shouldWalk)
			thoroughfare.getThoroughfareTrailingType().accept(this);

		if (thoroughfare.isSetThoroughfarePostDirection() && shouldWalk)
			thoroughfare.getThoroughfarePostDirection().accept(this);

		if (thoroughfare.isSetDependentThoroughfare() && shouldWalk)
			thoroughfare.getDependentThoroughfare().accept(this);

		if (thoroughfare.isSetDependentLocality() && shouldWalk)
			thoroughfare.getDependentLocality().accept(this);

		if (thoroughfare.isSetPremise() && shouldWalk)
			thoroughfare.getPremise().accept(this);

		if (thoroughfare.isSetFirm() && shouldWalk)
			thoroughfare.getFirm().accept(this);

		if (thoroughfare.isSetPostalCode() && shouldWalk)
			thoroughfare.getPostalCode().accept(this);
	}

	public void visit(ThoroughfareLeadingType thoroughfareLeadingType) {
	}

	public void visit(ThoroughfareName thoroughfareName) {
	}

	public void visit(ThoroughfareNumber thoroughfareNumber) {
	}

	public void visit(ThoroughfareNumberFrom thoroughfareNumberFrom) {
		if (thoroughfareNumberFrom.isSetContent()) {
			for (ThoroughfareNumberFromContent content : new ArrayList<ThoroughfareNumberFromContent>(thoroughfareNumberFrom.getContent())) {
				if (shouldWalk) {
					if (content.isSetAddressLine())
						content.getAddressLine().accept(this);
					else if (content.isSetThoroughfareNumber())
						content.getThoroughfareNumber().accept(this);
					else if (content.isSetThoroughfareNumberPrefix())
						content.getThoroughfareNumberPrefix().accept(this);
					else if (content.isSetThoroughfareNumberSuffix())
						content.getThoroughfareNumberSuffix().accept(this);
				}
			}
		}
	}

	public void visit(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
	}

	public void visit(ThoroughfareNumberRange thoroughfareNumberRange) {
		if (thoroughfareNumberRange.isSetAddressLine()) {
			for (AddressLine addressLine : new ArrayList<AddressLine>(thoroughfareNumberRange.getAddressLine()))
				if (shouldWalk)
					addressLine.accept(this);
		}
		
		if (thoroughfareNumberRange.isSetThoroughfareNumberFrom() && shouldWalk)
			thoroughfareNumberRange.getThoroughfareNumberFrom().accept(this);
		
		if (thoroughfareNumberRange.isSetThoroughfareNumberTo() && shouldWalk)
			thoroughfareNumberRange.getThoroughfareNumberTo().accept(this);
	}

	public void visit(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
	}

	public void visit(ThoroughfareNumberTo thoroughfareNumberTo) {
		if (thoroughfareNumberTo.isSetContent()) {
			for (ThoroughfareNumberToContent content : new ArrayList<ThoroughfareNumberToContent>(thoroughfareNumberTo.getContent())) {
				if (shouldWalk) {
					if (content.isSetAddressLine())
						content.getAddressLine().accept(this);
					else if (content.isSetThoroughfareNumber())
						content.getThoroughfareNumber().accept(this);
					else if (content.isSetThoroughfareNumberPrefix())
						content.getThoroughfareNumberPrefix().accept(this);
					else if (content.isSetThoroughfareNumberSuffix())
						content.getThoroughfareNumberSuffix().accept(this);
				}
			}
		}
	}

	public void visit(ThoroughfarePostDirection thoroughfarePostDirection) {
	}

	public void visit(ThoroughfarePreDirection thoroughfarePreDirection) {
	}

	public void visit(ThoroughfareTrailingType thoroughfareTrailingType) {
	} 

}
