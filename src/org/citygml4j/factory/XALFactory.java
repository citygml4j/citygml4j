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

import org.citygml4j.impl.xal.AddressDetailsImpl;
import org.citygml4j.impl.xal.AddressIdentifierImpl;
import org.citygml4j.impl.xal.AddressImpl;
import org.citygml4j.impl.xal.AddressLatitudeDirectionImpl;
import org.citygml4j.impl.xal.AddressLatitudeImpl;
import org.citygml4j.impl.xal.AddressLineImpl;
import org.citygml4j.impl.xal.AddressLinesImpl;
import org.citygml4j.impl.xal.AddressLongitudeDirectionImpl;
import org.citygml4j.impl.xal.AddressLongitudeImpl;
import org.citygml4j.impl.xal.AdministrativeAreaImpl;
import org.citygml4j.impl.xal.AdministrativeAreaNameImpl;
import org.citygml4j.impl.xal.BarcodeImpl;
import org.citygml4j.impl.xal.BuildingNameImpl;
import org.citygml4j.impl.xal.CountryImpl;
import org.citygml4j.impl.xal.CountryNameCodeImpl;
import org.citygml4j.impl.xal.CountryNameImpl;
import org.citygml4j.impl.xal.DepartmentImpl;
import org.citygml4j.impl.xal.DepartmentNameImpl;
import org.citygml4j.impl.xal.DependentLocalityImpl;
import org.citygml4j.impl.xal.DependentLocalityNameImpl;
import org.citygml4j.impl.xal.DependentLocalityNumberImpl;
import org.citygml4j.impl.xal.DependentThoroughfareImpl;
import org.citygml4j.impl.xal.EndorsementLineCodeImpl;
import org.citygml4j.impl.xal.FirmImpl;
import org.citygml4j.impl.xal.FirmNameImpl;
import org.citygml4j.impl.xal.KeyLineCodeImpl;
import org.citygml4j.impl.xal.LargeMailUserIdentifierImpl;
import org.citygml4j.impl.xal.LargeMailUserImpl;
import org.citygml4j.impl.xal.LargeMailUserNameImpl;
import org.citygml4j.impl.xal.LocalityImpl;
import org.citygml4j.impl.xal.LocalityNameImpl;
import org.citygml4j.impl.xal.MailStopImpl;
import org.citygml4j.impl.xal.MailStopNameImpl;
import org.citygml4j.impl.xal.MailStopNumberImpl;
import org.citygml4j.impl.xal.PostBoxImpl;
import org.citygml4j.impl.xal.PostBoxNumberExtensionImpl;
import org.citygml4j.impl.xal.PostBoxNumberImpl;
import org.citygml4j.impl.xal.PostBoxNumberPrefixImpl;
import org.citygml4j.impl.xal.PostBoxNumberSuffixImpl;
import org.citygml4j.impl.xal.PostOfficeImpl;
import org.citygml4j.impl.xal.PostOfficeNameImpl;
import org.citygml4j.impl.xal.PostOfficeNumberImpl;
import org.citygml4j.impl.xal.PostTownImpl;
import org.citygml4j.impl.xal.PostTownNameImpl;
import org.citygml4j.impl.xal.PostTownSuffixImpl;
import org.citygml4j.impl.xal.PostalCodeImpl;
import org.citygml4j.impl.xal.PostalCodeNumberExtensionImpl;
import org.citygml4j.impl.xal.PostalCodeNumberImpl;
import org.citygml4j.impl.xal.PostalRouteImpl;
import org.citygml4j.impl.xal.PostalRouteNameImpl;
import org.citygml4j.impl.xal.PostalRouteNumberImpl;
import org.citygml4j.impl.xal.PostalServiceElementsImpl;
import org.citygml4j.impl.xal.PremiseImpl;
import org.citygml4j.impl.xal.PremiseLocationImpl;
import org.citygml4j.impl.xal.PremiseNameImpl;
import org.citygml4j.impl.xal.PremiseNumberImpl;
import org.citygml4j.impl.xal.PremiseNumberPrefixImpl;
import org.citygml4j.impl.xal.PremiseNumberRangeFromImpl;
import org.citygml4j.impl.xal.PremiseNumberRangeImpl;
import org.citygml4j.impl.xal.PremiseNumberRangeToImpl;
import org.citygml4j.impl.xal.PremiseNumberSuffixImpl;
import org.citygml4j.impl.xal.SortingCodeImpl;
import org.citygml4j.impl.xal.SubAdministrativeAreaImpl;
import org.citygml4j.impl.xal.SubAdministrativeAreaNameImpl;
import org.citygml4j.impl.xal.SubPremiseImpl;
import org.citygml4j.impl.xal.SubPremiseLocationImpl;
import org.citygml4j.impl.xal.SubPremiseNameImpl;
import org.citygml4j.impl.xal.SubPremiseNumberImpl;
import org.citygml4j.impl.xal.SubPremiseNumberPrefixImpl;
import org.citygml4j.impl.xal.SubPremiseNumberSuffixImpl;
import org.citygml4j.impl.xal.SupplementaryPostalServiceDataImpl;
import org.citygml4j.impl.xal.ThoroughfareImpl;
import org.citygml4j.impl.xal.ThoroughfareLeadingTypeImpl;
import org.citygml4j.impl.xal.ThoroughfareNameImpl;
import org.citygml4j.impl.xal.ThoroughfareNumberFromContentImpl;
import org.citygml4j.impl.xal.ThoroughfareNumberFromImpl;
import org.citygml4j.impl.xal.ThoroughfareNumberImpl;
import org.citygml4j.impl.xal.ThoroughfareNumberOrRangeImpl;
import org.citygml4j.impl.xal.ThoroughfareNumberPrefixImpl;
import org.citygml4j.impl.xal.ThoroughfareNumberRangeImpl;
import org.citygml4j.impl.xal.ThoroughfareNumberSuffixImpl;
import org.citygml4j.impl.xal.ThoroughfareNumberToContentImpl;
import org.citygml4j.impl.xal.ThoroughfareNumberToImpl;
import org.citygml4j.impl.xal.ThoroughfarePostDirectionImpl;
import org.citygml4j.impl.xal.ThoroughfarePreDirectionImpl;
import org.citygml4j.impl.xal.ThoroughfareTrailingTypeImpl;
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
		return new AddressDetailsImpl();
	}
	
	public AddressIdentifier createAddressIdentifier() {
		return new AddressIdentifierImpl();
	}
	
	public Address createAddress() {
		return new AddressImpl();
	}
	
	public AddressLatitudeDirection createAddressLatitudeDirection() {
		return new AddressLatitudeDirectionImpl();
	}
	
	public AddressLatitude createAddressLatitude() {
		return new AddressLatitudeImpl();
	}
	
	public AddressLine createAddressLine() {
		return new AddressLineImpl();
	}
	
	public AddressLines createAddressLines() {
		return new AddressLinesImpl();
	}
	
	public AddressLongitudeDirection createAddressLongitudeDirection() {
		return new AddressLongitudeDirectionImpl();
	}
	
	public AddressLongitude createAddressLongitude() {
		return new AddressLongitudeImpl();
	}
	
	public AdministrativeArea createAdministrativeArea() {
		return new AdministrativeAreaImpl();
	}
	
	public AdministrativeAreaName createAdministrativeAreaName() {
		return new AdministrativeAreaNameImpl();
	}
	
	public Barcode createBarcode() {
		return new BarcodeImpl();
	}
	
	public BuildingName createBuildingName() {
		return new BuildingNameImpl();
	}
	
	public Country createCountry() {
		return new CountryImpl();
	}
	
	public CountryNameCode createCountryNameCode() {
		return new CountryNameCodeImpl();
	}
	
	public CountryName createCountryName() {
		return new CountryNameImpl();
	}
	
	public Department createDepartment() {
		return new DepartmentImpl();
	}
	
	public DepartmentName createDepartmentName() {
		return new DepartmentNameImpl();
	}
	
	public DependentLocality createDependentLocality() {
		return new DependentLocalityImpl();
	}
	
	public DependentLocalityName createDependentLocalityName() {
		return new DependentLocalityNameImpl();
	}
	
	public DependentLocalityNumber createDependentLocalityNumber() {
		return new DependentLocalityNumberImpl();
	}
	
	public DependentThoroughfare createDependentThoroughfare() {
		return new DependentThoroughfareImpl();
	}
	
	public EndorsementLineCode createEndorsementLineCode() {
		return new EndorsementLineCodeImpl();
	}
	
	public Firm createFirm() {
		return new FirmImpl();
	}
	
	public FirmName createFirmName() {
		return new FirmNameImpl();
	}
	
	public KeyLineCode createKeyLineCode() {
		return new KeyLineCodeImpl();
	}
	
	public LargeMailUserIdentifier createLargeMailUserIdentifier() {
		return new LargeMailUserIdentifierImpl();
	}
	
	public LargeMailUser createLargeMailUser() {
		return new LargeMailUserImpl();
	}
	
	public LargeMailUserName createLargeMailUserName() {
		return new LargeMailUserNameImpl();
	}
	
	public Locality createLocality() {
		return new LocalityImpl();
	}
	
	public LocalityName createLocalityName() {
		return new LocalityNameImpl();
	}
	
	public MailStop createMailStop() {
		return new MailStopImpl();
	}
	
	public MailStopName createMailStopName() {
		return new MailStopNameImpl();
	}
	
	public MailStopNumber createMailStopNumber() {
		return new MailStopNumberImpl();
	}
	
	public PostalCode createPostalCode() {
		return new PostalCodeImpl();
	}
	
	public PostalCodeNumberExtension createPostalCodeNumberExtension() {
		return new PostalCodeNumberExtensionImpl();
	}
	
	public PostalCodeNumber createPostalCodeNumber() {
		return new PostalCodeNumberImpl();
	}
	
	public PostalRoute createPostalRoute() {
		return new PostalRouteImpl();
	}
	
	public PostalRouteName createPostalRouteName() {
		return new PostalRouteNameImpl();
	}
	
	public PostalRouteNumber createPostalRouteNumber() {
		return new PostalRouteNumberImpl();
	}
	
	public PostalServiceElements createPostalServiceElements() {
		return new PostalServiceElementsImpl();
	}
	
	public PostBox createPostBox() {
		return new PostBoxImpl();
	}
	
	public PostBoxNumberExtension createPostBoxNumberExtension() {
		return new PostBoxNumberExtensionImpl();
	}
	
	public PostBoxNumber createPostBoxNumber() {
		return new PostBoxNumberImpl();
	}
	
	public PostBoxNumberPrefix createPostBoxNumberPrefix() {
		return new PostBoxNumberPrefixImpl();
	}
	
	public PostBoxNumberSuffix createPostBoxNumberSuffix() {
		return new PostBoxNumberSuffixImpl();
	}
	
	public PostOffice createPostOffice() {
		return new PostOfficeImpl();
	}
	
	public PostOfficeName createPostOfficeName() {
		return new PostOfficeNameImpl();
	}
	
	public PostOfficeNumber createPostOfficeNumber() {
		return new PostOfficeNumberImpl();
	}
	
	public PostTown createPostTown() {
		return new PostTownImpl();
	}
	
	public PostTownName createPostTownName() {
		return new PostTownNameImpl();
	}
	
	public PostTownSuffix createPostTownSuffix() {
		return new PostTownSuffixImpl();
	}
	
	public Premise createPremise() {
		return new PremiseImpl();
	}
	
	public PremiseLocation createPremiseLocation() {
		return new PremiseLocationImpl();
	}
	
	public PremiseName createPremiseName() {
		return new PremiseNameImpl();
	}
	
	public PremiseNumber createPremiseNumber() {
		return new PremiseNumberImpl();
	}
	
	public PremiseNumberPrefix createPremiseNumberPrefix() {
		return new PremiseNumberPrefixImpl();
	}
	
	public PremiseNumberRangeFrom createPremiseNumberRangeFrom() {
		return new PremiseNumberRangeFromImpl();
	}
	
	public PremiseNumberRange createPremiseNumberRange() {
		return new PremiseNumberRangeImpl();
	}
	
	public PremiseNumberRangeTo createPremiseNumberRangeTo() {
		return new PremiseNumberRangeToImpl();
	}
	
	public PremiseNumberSuffix createPremiseNumberSuffix() {
		return new PremiseNumberSuffixImpl();
	}
	
	public SortingCode createSortingCode() {
		return new SortingCodeImpl();
	}
	
	public SubAdministrativeArea createSubAdministrativeArea() {
		return new SubAdministrativeAreaImpl();
	}
	
	public SubAdministrativeAreaName createSubAdministrativeAreaName() {
		return new SubAdministrativeAreaNameImpl();
	}
	
	public SubPremise createSubPremise() {
		return new SubPremiseImpl();
	}
	
	public SubPremiseLocation createSubPremiseLocation() {
		return new SubPremiseLocationImpl();
	}
	
	public SubPremiseName createSubPremiseName() {
		return new SubPremiseNameImpl();
	}
	
	public SubPremiseNumber createSubPremiseNumber() {
		return new SubPremiseNumberImpl();
	}
	
	public SubPremiseNumberPrefix createSubPremiseNumberPrefix() {
		return new SubPremiseNumberPrefixImpl();
	}
	
	public SubPremiseNumberSuffix createSubPremiseNumberSuffix() {
		return new SubPremiseNumberSuffixImpl();
	}
	
	public SupplementaryPostalServiceData createSupplementaryPostalServiceData() {
		return new SupplementaryPostalServiceDataImpl();
	}
	
	public Thoroughfare createThoroughfare() {
		return new ThoroughfareImpl();
	}
	
	public ThoroughfareLeadingType createThoroughfareLeadingType() {
		return new ThoroughfareLeadingTypeImpl();
	}
	
	public ThoroughfareName createThoroughfareName() {
		return new ThoroughfareNameImpl();
	}
	
	public ThoroughfareNumberFrom createThoroughfareNumberFrom() {
		return new ThoroughfareNumberFromImpl();
	}
	
	public ThoroughfareNumberFromContent createThoroughfareNumberFromContent() {
		return new ThoroughfareNumberFromContentImpl();
	}
	
	public ThoroughfareNumberFromContent createThoroughfareNumberFromContent(AddressLine addressLine) {
		return new ThoroughfareNumberFromContentImpl(addressLine);
	}
	
	public ThoroughfareNumberFromContent createThoroughfareNumberFromContent(ThoroughfareNumber thoroughfareNumber) {
		return new ThoroughfareNumberFromContentImpl(thoroughfareNumber);
	}
	
	public ThoroughfareNumberFromContent createThoroughfareNumberFromContent(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		return new ThoroughfareNumberFromContentImpl(thoroughfareNumberPrefix);
	}
	
	public ThoroughfareNumberFromContent createThoroughfareNumberFromContent(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		return new ThoroughfareNumberFromContentImpl(thoroughfareNumberSuffix);
	}
	
	public ThoroughfareNumberFromContent createThoroughfareNumberFromContent(String string) {
		return new ThoroughfareNumberFromContentImpl(string);
	}
	
	public ThoroughfareNumberToContent createThoroughfareNumberToContent() {
		return new ThoroughfareNumberToContentImpl();
	}
	
	public ThoroughfareNumberToContent createThoroughfareNumberToContent(AddressLine addressLine) {
		return new ThoroughfareNumberToContentImpl(addressLine);
	}
	
	public ThoroughfareNumberToContent createThoroughfareNumberToContent(ThoroughfareNumber thoroughfareNumber) {
		return new ThoroughfareNumberToContentImpl(thoroughfareNumber);
	}
	
	public ThoroughfareNumberToContent createThoroughfareNumberToContent(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		return new ThoroughfareNumberToContentImpl(thoroughfareNumberPrefix);
	}
	
	public ThoroughfareNumberToContent createThoroughfareNumberToContent(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		return new ThoroughfareNumberToContentImpl(thoroughfareNumberSuffix);
	}
	
	public ThoroughfareNumberToContent createThoroughfareNumberToContent(String string) {
		return new ThoroughfareNumberToContentImpl(string);
	}
	
	
	public ThoroughfareNumber createThoroughfareNumber() {
		return new ThoroughfareNumberImpl();
	}
	
	public ThoroughfareNumberOrRange createThoroughfareNumberOrRange() {
		return new ThoroughfareNumberOrRangeImpl();
	}
	
	public ThoroughfareNumberOrRange createThoroughfareNumberOrRange(ThoroughfareNumber thoroughfareNumber) {
		return new ThoroughfareNumberOrRangeImpl(thoroughfareNumber);
	}
	
	public ThoroughfareNumberOrRange createThoroughfareNumberOrRange(ThoroughfareNumberRange thoroughfareNumberRange) {
		return new ThoroughfareNumberOrRangeImpl(thoroughfareNumberRange);
	}
	
	public ThoroughfareNumberPrefix createThoroughfareNumberPrefix() {
		return new ThoroughfareNumberPrefixImpl();
	}
	
	public ThoroughfareNumberRange createThoroughfareNumberRange() {
		return new ThoroughfareNumberRangeImpl();
	}
	
	public ThoroughfareNumberSuffix createThoroughfareNumberSuffix() {
		return new ThoroughfareNumberSuffixImpl();
	}
	
	public ThoroughfareNumberTo createThoroughfareNumberTo() {
		return new ThoroughfareNumberToImpl();
	}
	
	public ThoroughfarePostDirection createThoroughfarePostDirection() {
		return new ThoroughfarePostDirectionImpl();
	}
	
	public ThoroughfarePreDirection createThoroughfarePreDirection() {
		return new ThoroughfarePreDirectionImpl();
	}
	
	public ThoroughfareTrailingType createThoroughfareTrailingType() {
		return new ThoroughfareTrailingTypeImpl();
	}
	
}

