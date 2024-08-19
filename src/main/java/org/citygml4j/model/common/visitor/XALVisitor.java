/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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

public interface XALVisitor extends Visitor {
	void visit(Address address);
	void visit(AddressDetails addressDetails);
	void visit(AddressIdentifier addressIdentifier);
	void visit(AddressLatitude addressLatitude);
	void visit(AddressLatitudeDirection addressLatitudeDirection);
	void visit(AddressLine addressLine);
	void visit(AddressLines addressLines);
	void visit(AddressLongitude addressLongitude);
	void visit(AddressLongitudeDirection addressLongitudeDirection);
	void visit(AdministrativeArea administrativeArea);
	void visit(AdministrativeAreaName administrativeAreaName);
	void visit(Barcode barcode);
	void visit(BuildingName buildingName);
	void visit(Country country);
	void visit(CountryName countryName);
	void visit(CountryNameCode countryNameCode);
	void visit(Department department);
	void visit(DepartmentName departmentName);
	void visit(DependentLocality dependentLocality);
	void visit(DependentLocalityName dependentLocalityName);
	void visit(DependentLocalityNumber dependentLocalityNumber);
	void visit(DependentThoroughfare dependentThoroughfare);
	void visit(EndorsementLineCode endorsementLineCode);
	void visit(Firm firm);
	void visit(FirmName firmName);
	void visit(KeyLineCode keyLineCode);
	void visit(LargeMailUser largeMailUser);
	void visit(LargeMailUserIdentifier largeMailUserIdentifier);
	void visit(LargeMailUserName largeMailUserName);
	void visit(Locality locality);
	void visit(LocalityName localityName);
	void visit(MailStop mailStop);
	void visit(MailStopName mailStopName);
	void visit(MailStopNumber mailStopNumber);
	void visit(PostalCode postalCode);
	void visit(PostalCodeNumber postalCodeNumber);
	void visit(PostalCodeNumberExtension postalCodeNumberExtension);
	void visit(PostalRoute postalRoute);
	void visit(PostalRouteName postalRouteName);
	void visit(PostalRouteNumber postalRouteNumber);
	void visit(PostalServiceElements postalServiceElements);
	void visit(PostBox postBox);
	void visit(PostBoxNumber postBoxNumber);
	void visit(PostBoxNumberExtension postBoxNumberExtension);
	void visit(PostBoxNumberPrefix postBoxNumberPrefix);
	void visit(PostBoxNumberSuffix postBoxNumberSuffix);
	void visit(PostOffice postOffice);
	void visit(PostOfficeName postOfficeName);
	void visit(PostOfficeNumber postOfficeNumber);
	void visit(PostTown postTown);
	void visit(PostTownName postTownName);
	void visit(PostTownSuffix postTownSuffix);
	void visit(Premise premise);
	void visit(PremiseLocation premiseLocation);
	void visit(PremiseName premiseName);
	void visit(PremiseNumber premiseNumber);
	void visit(PremiseNumberPrefix premiseNumberPrefix);
	void visit(PremiseNumberRange premiseNumberRange);
	void visit(PremiseNumberRangeFrom premiseNumberRangeFrom);
	void visit(PremiseNumberRangeTo premiseNumberRangeTo);
	void visit(PremiseNumberSuffix premiseNumberSuffix);
	void visit(SortingCode sortingCode);
	void visit(SubAdministrativeArea subAdministrativeArea);
	void visit(SubAdministrativeAreaName subAdministrativeAreaName);
	void visit(SubPremise subPremise);
	void visit(SubPremiseLocation subPremiseLocation);
	void visit(SubPremiseName subPremiseName);
	void visit(SubPremiseNumber subPremiseNumber);
	void visit(SubPremiseNumberPrefix subPremiseNumberPrefix);
	void visit(SubPremiseNumberSuffix subPremiseNumberSuffix);
	void visit(SupplementaryPostalServiceData supplementaryPostalServiceData);
	void visit(Thoroughfare thoroughfare);
	void visit(ThoroughfareLeadingType thoroughfareLeadingType);
	void visit(ThoroughfareName thoroughfareName);
	void visit(ThoroughfareNumber thoroughfareNumber);
	void visit(ThoroughfareNumberFrom thoroughfareNumberFrom);
	void visit(ThoroughfareNumberPrefix thoroughfareNumberPrefix);
	void visit(ThoroughfareNumberRange thoroughfareNumberRange);
	void visit(ThoroughfareNumberSuffix thoroughfareNumberSuffix);
	void visit(ThoroughfareNumberTo thoroughfareNumberTo);
	void visit(ThoroughfarePostDirection thoroughfarePostDirection);
	void visit(ThoroughfarePreDirection thoroughfarePreDirection);
	void visit(ThoroughfareTrailingType thoroughfareTrailingType);
}
