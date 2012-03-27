/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.factory;

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

public class XALFactory {

	public XALFactory() {
		
	}
	
	public AddressDetails createAddressDetails() {
		return new AddressDetails();
	}
	
	public AddressIdentifier createAddressIdentifier() {
		return new AddressIdentifier();
	}
	
	public Address createAddress() {
		return new Address();
	}
	
	public AddressLatitudeDirection createAddressLatitudeDirection() {
		return new AddressLatitudeDirection();
	}
	
	public AddressLatitude createAddressLatitude() {
		return new AddressLatitude();
	}
	
	public AddressLine createAddressLine() {
		return new AddressLine();
	}
	
	public AddressLines createAddressLines() {
		return new AddressLines();
	}
	
	public AddressLongitudeDirection createAddressLongitudeDirection() {
		return new AddressLongitudeDirection();
	}
	
	public AddressLongitude createAddressLongitude() {
		return new AddressLongitude();
	}
	
	public AdministrativeArea createAdministrativeArea() {
		return new AdministrativeArea();
	}
	
	public AdministrativeAreaName createAdministrativeAreaName() {
		return new AdministrativeAreaName();
	}
	
	public Barcode createBarcode() {
		return new Barcode();
	}
	
	public BuildingName createBuildingName() {
		return new BuildingName();
	}
	
	public Country createCountry() {
		return new Country();
	}
	
	public CountryNameCode createCountryNameCode() {
		return new CountryNameCode();
	}
	
	public CountryName createCountryName() {
		return new CountryName();
	}
	
	public Department createDepartment() {
		return new Department();
	}
	
	public DepartmentName createDepartmentName() {
		return new DepartmentName();
	}
	
	public DependentLocality createDependentLocality() {
		return new DependentLocality();
	}
	
	public DependentLocalityName createDependentLocalityName() {
		return new DependentLocalityName();
	}
	
	public DependentLocalityNumber createDependentLocalityNumber() {
		return new DependentLocalityNumber();
	}
	
	public DependentThoroughfare createDependentThoroughfare() {
		return new DependentThoroughfare();
	}
	
	public EndorsementLineCode createEndorsementLineCode() {
		return new EndorsementLineCode();
	}
	
	public Firm createFirm() {
		return new Firm();
	}
	
	public FirmName createFirmName() {
		return new FirmName();
	}
	
	public KeyLineCode createKeyLineCode() {
		return new KeyLineCode();
	}
	
	public LargeMailUserIdentifier createLargeMailUserIdentifier() {
		return new LargeMailUserIdentifier();
	}
	
	public LargeMailUser createLargeMailUser() {
		return new LargeMailUser();
	}
	
	public LargeMailUserName createLargeMailUserName() {
		return new LargeMailUserName();
	}
	
	public Locality createLocality() {
		return new Locality();
	}
	
	public LocalityName createLocalityName() {
		return new LocalityName();
	}
	
	public MailStop createMailStop() {
		return new MailStop();
	}
	
	public MailStopName createMailStopName() {
		return new MailStopName();
	}
	
	public MailStopNumber createMailStopNumber() {
		return new MailStopNumber();
	}
	
	public PostalCode createPostalCode() {
		return new PostalCode();
	}
	
	public PostalCodeNumberExtension createPostalCodeNumberExtension() {
		return new PostalCodeNumberExtension();
	}
	
	public PostalCodeNumber createPostalCodeNumber() {
		return new PostalCodeNumber();
	}
	
	public PostalRoute createPostalRoute() {
		return new PostalRoute();
	}
	
	public PostalRouteName createPostalRouteName() {
		return new PostalRouteName();
	}
	
	public PostalRouteNumber createPostalRouteNumber() {
		return new PostalRouteNumber();
	}
	
	public PostalServiceElements createPostalServiceElements() {
		return new PostalServiceElements();
	}
	
	public PostBox createPostBox() {
		return new PostBox();
	}
	
	public PostBoxNumberExtension createPostBoxNumberExtension() {
		return new PostBoxNumberExtension();
	}
	
	public PostBoxNumber createPostBoxNumber() {
		return new PostBoxNumber();
	}
	
	public PostBoxNumberPrefix createPostBoxNumberPrefix() {
		return new PostBoxNumberPrefix();
	}
	
	public PostBoxNumberSuffix createPostBoxNumberSuffix() {
		return new PostBoxNumberSuffix();
	}
	
	public PostOffice createPostOffice() {
		return new PostOffice();
	}
	
	public PostOfficeName createPostOfficeName() {
		return new PostOfficeName();
	}
	
	public PostOfficeNumber createPostOfficeNumber() {
		return new PostOfficeNumber();
	}
	
	public PostTown createPostTown() {
		return new PostTown();
	}
	
	public PostTownName createPostTownName() {
		return new PostTownName();
	}
	
	public PostTownSuffix createPostTownSuffix() {
		return new PostTownSuffix();
	}
	
	public Premise createPremise() {
		return new Premise();
	}
	
	public PremiseLocation createPremiseLocation() {
		return new PremiseLocation();
	}
	
	public PremiseName createPremiseName() {
		return new PremiseName();
	}
	
	public PremiseNumber createPremiseNumber() {
		return new PremiseNumber();
	}
	
	public PremiseNumberPrefix createPremiseNumberPrefix() {
		return new PremiseNumberPrefix();
	}
	
	public PremiseNumberRangeFrom createPremiseNumberRangeFrom() {
		return new PremiseNumberRangeFrom();
	}
	
	public PremiseNumberRange createPremiseNumberRange() {
		return new PremiseNumberRange();
	}
	
	public PremiseNumberRangeTo createPremiseNumberRangeTo() {
		return new PremiseNumberRangeTo();
	}
	
	public PremiseNumberSuffix createPremiseNumberSuffix() {
		return new PremiseNumberSuffix();
	}
	
	public SortingCode createSortingCode() {
		return new SortingCode();
	}
	
	public SubAdministrativeArea createSubAdministrativeArea() {
		return new SubAdministrativeArea();
	}
	
	public SubAdministrativeAreaName createSubAdministrativeAreaName() {
		return new SubAdministrativeAreaName();
	}
	
	public SubPremise createSubPremise() {
		return new SubPremise();
	}
	
	public SubPremiseLocation createSubPremiseLocation() {
		return new SubPremiseLocation();
	}
	
	public SubPremiseName createSubPremiseName() {
		return new SubPremiseName();
	}
	
	public SubPremiseNumber createSubPremiseNumber() {
		return new SubPremiseNumber();
	}
	
	public SubPremiseNumberPrefix createSubPremiseNumberPrefix() {
		return new SubPremiseNumberPrefix();
	}
	
	public SubPremiseNumberSuffix createSubPremiseNumberSuffix() {
		return new SubPremiseNumberSuffix();
	}
	
	public SupplementaryPostalServiceData createSupplementaryPostalServiceData() {
		return new SupplementaryPostalServiceData();
	}
	
	public Thoroughfare createThoroughfare() {
		return new Thoroughfare();
	}
	
	public ThoroughfareLeadingType createThoroughfareLeadingType() {
		return new ThoroughfareLeadingType();
	}
	
	public ThoroughfareName createThoroughfareName() {
		return new ThoroughfareName();
	}
	
	public ThoroughfareNumberFrom createThoroughfareNumberFrom() {
		return new ThoroughfareNumberFrom();
	}
	
	public ThoroughfareNumberFromContent createThoroughfareNumberFromContent() {
		return new ThoroughfareNumberFromContent();
	}
	
	public ThoroughfareNumberFromContent createThoroughfareNumberFromContent(AddressLine addressLine) {
		return new ThoroughfareNumberFromContent(addressLine);
	}
	
	public ThoroughfareNumberFromContent createThoroughfareNumberFromContent(ThoroughfareNumber thoroughfareNumber) {
		return new ThoroughfareNumberFromContent(thoroughfareNumber);
	}
	
	public ThoroughfareNumberFromContent createThoroughfareNumberFromContent(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		return new ThoroughfareNumberFromContent(thoroughfareNumberPrefix);
	}
	
	public ThoroughfareNumberFromContent createThoroughfareNumberFromContent(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		return new ThoroughfareNumberFromContent(thoroughfareNumberSuffix);
	}
	
	public ThoroughfareNumberFromContent createThoroughfareNumberFromContent(String string) {
		return new ThoroughfareNumberFromContent(string);
	}
	
	public ThoroughfareNumberToContent createThoroughfareNumberToContent() {
		return new ThoroughfareNumberToContent();
	}
	
	public ThoroughfareNumberToContent createThoroughfareNumberToContent(AddressLine addressLine) {
		return new ThoroughfareNumberToContent(addressLine);
	}
	
	public ThoroughfareNumberToContent createThoroughfareNumberToContent(ThoroughfareNumber thoroughfareNumber) {
		return new ThoroughfareNumberToContent(thoroughfareNumber);
	}
	
	public ThoroughfareNumberToContent createThoroughfareNumberToContent(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		return new ThoroughfareNumberToContent(thoroughfareNumberPrefix);
	}
	
	public ThoroughfareNumberToContent createThoroughfareNumberToContent(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		return new ThoroughfareNumberToContent(thoroughfareNumberSuffix);
	}
	
	public ThoroughfareNumberToContent createThoroughfareNumberToContent(String string) {
		return new ThoroughfareNumberToContent(string);
	}
	
	
	public ThoroughfareNumber createThoroughfareNumber() {
		return new ThoroughfareNumber();
	}
	
	public ThoroughfareNumberOrRange createThoroughfareNumberOrRange() {
		return new ThoroughfareNumberOrRange();
	}
	
	public ThoroughfareNumberOrRange createThoroughfareNumberOrRange(ThoroughfareNumber thoroughfareNumber) {
		return new ThoroughfareNumberOrRange(thoroughfareNumber);
	}
	
	public ThoroughfareNumberOrRange createThoroughfareNumberOrRange(ThoroughfareNumberRange thoroughfareNumberRange) {
		return new ThoroughfareNumberOrRange(thoroughfareNumberRange);
	}
	
	public ThoroughfareNumberPrefix createThoroughfareNumberPrefix() {
		return new ThoroughfareNumberPrefix();
	}
	
	public ThoroughfareNumberRange createThoroughfareNumberRange() {
		return new ThoroughfareNumberRange();
	}
	
	public ThoroughfareNumberSuffix createThoroughfareNumberSuffix() {
		return new ThoroughfareNumberSuffix();
	}
	
	public ThoroughfareNumberTo createThoroughfareNumberTo() {
		return new ThoroughfareNumberTo();
	}
	
	public ThoroughfarePostDirection createThoroughfarePostDirection() {
		return new ThoroughfarePostDirection();
	}
	
	public ThoroughfarePreDirection createThoroughfarePreDirection() {
		return new ThoroughfarePreDirection();
	}
	
	public ThoroughfareTrailingType createThoroughfareTrailingType() {
		return new ThoroughfareTrailingType();
	}
	
}

