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
import org.citygml4j.model.xal.ThoroughfareNumberPrefix;
import org.citygml4j.model.xal.ThoroughfareNumberRange;
import org.citygml4j.model.xal.ThoroughfareNumberSuffix;
import org.citygml4j.model.xal.ThoroughfareNumberTo;
import org.citygml4j.model.xal.ThoroughfarePostDirection;
import org.citygml4j.model.xal.ThoroughfarePreDirection;
import org.citygml4j.model.xal.ThoroughfareTrailingType;

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
