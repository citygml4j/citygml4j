/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.common.visitor;

import org.citygml4j.model.xal.*;

public interface XALFunctor<T> extends Functor<T> {
	T apply(Address address);
	T apply(AddressDetails addressDetails);
	T apply(AddressIdentifier addressIdentifier);
	T apply(AddressLatitude addressLatitude);
	T apply(AddressLatitudeDirection addressLatitudeDirection);
	T apply(AddressLine addressLine);
	T apply(AddressLines addressLines);
	T apply(AddressLongitude addressLongitude);
	T apply(AddressLongitudeDirection addressLongitudeDirection);
	T apply(AdministrativeArea administrativeArea);
	T apply(AdministrativeAreaName administrativeAreaName);
	T apply(Barcode barcode);
	T apply(BuildingName buildingName);
	T apply(Country country);
	T apply(CountryName countryName);
	T apply(CountryNameCode countryNameCode);
	T apply(Department department);
	T apply(DepartmentName departmentName);
	T apply(DependentLocality dependentLocality);
	T apply(DependentLocalityName dependentLocalityName);
	T apply(DependentLocalityNumber dependentLocalityNumber);
	T apply(DependentThoroughfare dependentThoroughfare);
	T apply(EndorsementLineCode endorsementLineCode);
	T apply(Firm firm);
	T apply(FirmName firmName);
	T apply(KeyLineCode keyLineCode);
	T apply(LargeMailUser largeMailUser);
	T apply(LargeMailUserIdentifier largeMailUserIdentifier);
	T apply(LargeMailUserName largeMailUserName);
	T apply(Locality locality);
	T apply(LocalityName localityName);
	T apply(MailStop mailStop);
	T apply(MailStopName mailStopName);
	T apply(MailStopNumber mailStopNumber);
	T apply(PostalCode postalCode);
	T apply(PostalCodeNumber postalCodeNumber);
	T apply(PostalCodeNumberExtension postalCodeNumberExtension);
	T apply(PostalRoute postalRoute);
	T apply(PostalRouteName postalRouteName);
	T apply(PostalRouteNumber postalRouteNumber);
	T apply(PostalServiceElements postalServiceElements);
	T apply(PostBox postBox);
	T apply(PostBoxNumber postBoxNumber);
	T apply(PostBoxNumberExtension postBoxNumberExtension);
	T apply(PostBoxNumberPrefix postBoxNumberPrefix);
	T apply(PostBoxNumberSuffix postBoxNumberSuffix);
	T apply(PostOffice postOffice);
	T apply(PostOfficeName postOfficeName);
	T apply(PostOfficeNumber postOfficeNumber);
	T apply(PostTown postTown);
	T apply(PostTownName postTownName);
	T apply(PostTownSuffix postTownSuffix);
	T apply(Premise premise);
	T apply(PremiseLocation premiseLocation);
	T apply(PremiseName premiseName);
	T apply(PremiseNumber premiseNumber);
	T apply(PremiseNumberPrefix premiseNumberPrefix);
	T apply(PremiseNumberRange premiseNumberRange);
	T apply(PremiseNumberRangeFrom premiseNumberRangeFrom);
	T apply(PremiseNumberRangeTo premiseNumberRangeTo);
	T apply(PremiseNumberSuffix premiseNumberSuffix);
	T apply(SortingCode sortingCode);
	T apply(SubAdministrativeArea subAdministrativeArea);
	T apply(SubAdministrativeAreaName subAdministrativeAreaName);
	T apply(SubPremise subPremise);
	T apply(SubPremiseLocation subPremiseLocation);
	T apply(SubPremiseName subPremiseName);
	T apply(SubPremiseNumber subPremiseNumber);
	T apply(SubPremiseNumberPrefix subPremiseNumberPrefix);
	T apply(SubPremiseNumberSuffix subPremiseNumberSuffix);
	T apply(SupplementaryPostalServiceData supplementaryPostalServiceData);
	T apply(Thoroughfare thoroughfare);
	T apply(ThoroughfareLeadingType thoroughfareLeadingType);
	T apply(ThoroughfareName thoroughfareName);
	T apply(ThoroughfareNumber thoroughfareNumber);
	T apply(ThoroughfareNumberFrom thoroughfareNumberFrom);
	T apply(ThoroughfareNumberPrefix thoroughfareNumberPrefix);
	T apply(ThoroughfareNumberRange thoroughfareNumberRange);
	T apply(ThoroughfareNumberSuffix thoroughfareNumberSuffix);
	T apply(ThoroughfareNumberTo thoroughfareNumberTo);
	T apply(ThoroughfarePostDirection thoroughfarePostDirection);
	T apply(ThoroughfarePreDirection thoroughfarePreDirection);
	T apply(ThoroughfareTrailingType thoroughfareTrailingType);
}
