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
	public void visit(Address address);
	public void visit(AddressDetails addressDetails);
	public void visit(AddressIdentifier addressIdentifier);
	public void visit(AddressLatitude addressLatitude);
	public void visit(AddressLatitudeDirection addressLatitudeDirection);
	public void visit(AddressLine addressLine);
	public void visit(AddressLines addressLines);
	public void visit(AddressLongitude addressLongitude);
	public void visit(AddressLongitudeDirection addressLongitudeDirection);
	public void visit(AdministrativeArea administrativeArea);
	public void visit(AdministrativeAreaName administrativeAreaName);
	public void visit(Barcode barcode);
	public void visit(BuildingName buildingName);
	public void visit(Country country);
	public void visit(CountryName countryName);
	public void visit(CountryNameCode countryNameCode);
	public void visit(Department department);
	public void visit(DepartmentName departmentName);
	public void visit(DependentLocality dependentLocality);
	public void visit(DependentLocalityName dependentLocalityName);
	public void visit(DependentLocalityNumber dependentLocalityNumber);
	public void visit(DependentThoroughfare dependentThoroughfare);
	public void visit(EndorsementLineCode endorsementLineCode);
	public void visit(Firm firm);
	public void visit(FirmName firmName);
	public void visit(KeyLineCode keyLineCode);
	public void visit(LargeMailUser largeMailUser);
	public void visit(LargeMailUserIdentifier largeMailUserIdentifier);
	public void visit(LargeMailUserName largeMailUserName);
	public void visit(Locality locality);
	public void visit(LocalityName localityName);
	public void visit(MailStop mailStop);
	public void visit(MailStopName mailStopName);
	public void visit(MailStopNumber mailStopNumber);
	public void visit(PostalCode postalCode);
	public void visit(PostalCodeNumber postalCodeNumber);
	public void visit(PostalCodeNumberExtension postalCodeNumberExtension);
	public void visit(PostalRoute postalRoute);
	public void visit(PostalRouteName postalRouteName);
	public void visit(PostalRouteNumber postalRouteNumber);
	public void visit(PostalServiceElements postalServiceElements);
	public void visit(PostBox postBox);
	public void visit(PostBoxNumber postBoxNumber);
	public void visit(PostBoxNumberExtension postBoxNumberExtension);
	public void visit(PostBoxNumberPrefix postBoxNumberPrefix);
	public void visit(PostBoxNumberSuffix postBoxNumberSuffix);
	public void visit(PostOffice postOffice);
	public void visit(PostOfficeName postOfficeName);
	public void visit(PostOfficeNumber postOfficeNumber);
	public void visit(PostTown postTown);
	public void visit(PostTownName postTownName);
	public void visit(PostTownSuffix postTownSuffix);
	public void visit(Premise premise);
	public void visit(PremiseLocation premiseLocation);
	public void visit(PremiseName premiseName);
	public void visit(PremiseNumber premiseNumber);
	public void visit(PremiseNumberPrefix premiseNumberPrefix);
	public void visit(PremiseNumberRange premiseNumberRange);
	public void visit(PremiseNumberRangeFrom premiseNumberRangeFrom);
	public void visit(PremiseNumberRangeTo premiseNumberRangeTo);
	public void visit(PremiseNumberSuffix premiseNumberSuffix);
	public void visit(SortingCode sortingCode);
	public void visit(SubAdministrativeArea subAdministrativeArea);
	public void visit(SubAdministrativeAreaName subAdministrativeAreaName);
	public void visit(SubPremise subPremise);
	public void visit(SubPremiseLocation subPremiseLocation);
	public void visit(SubPremiseName subPremiseName);
	public void visit(SubPremiseNumber subPremiseNumber);
	public void visit(SubPremiseNumberPrefix subPremiseNumberPrefix);
	public void visit(SubPremiseNumberSuffix subPremiseNumberSuffix);
	public void visit(SupplementaryPostalServiceData supplementaryPostalServiceData);
	public void visit(Thoroughfare thoroughfare);
	public void visit(ThoroughfareLeadingType thoroughfareLeadingType);
	public void visit(ThoroughfareName thoroughfareName);
	public void visit(ThoroughfareNumber thoroughfareNumber);
	public void visit(ThoroughfareNumberFrom thoroughfareNumberFrom);
	public void visit(ThoroughfareNumberPrefix thoroughfareNumberPrefix);
	public void visit(ThoroughfareNumberRange thoroughfareNumberRange);
	public void visit(ThoroughfareNumberSuffix thoroughfareNumberSuffix);
	public void visit(ThoroughfareNumberTo thoroughfareNumberTo);
	public void visit(ThoroughfarePostDirection thoroughfarePostDirection);
	public void visit(ThoroughfarePreDirection thoroughfarePreDirection);
	public void visit(ThoroughfareTrailingType thoroughfareTrailingType);
}
