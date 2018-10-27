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

public interface XALFunctor<T> extends Functor<T> {
	public T apply(Address address);
	public T apply(AddressDetails addressDetails);
	public T apply(AddressIdentifier addressIdentifier);
	public T apply(AddressLatitude addressLatitude);
	public T apply(AddressLatitudeDirection addressLatitudeDirection);
	public T apply(AddressLine addressLine);
	public T apply(AddressLines addressLines);
	public T apply(AddressLongitude addressLongitude);
	public T apply(AddressLongitudeDirection addressLongitudeDirection);
	public T apply(AdministrativeArea administrativeArea);
	public T apply(AdministrativeAreaName administrativeAreaName);
	public T apply(Barcode barcode);
	public T apply(BuildingName buildingName);
	public T apply(Country country);
	public T apply(CountryName countryName);
	public T apply(CountryNameCode countryNameCode);
	public T apply(Department department);
	public T apply(DepartmentName departmentName);
	public T apply(DependentLocality dependentLocality);
	public T apply(DependentLocalityName dependentLocalityName);
	public T apply(DependentLocalityNumber dependentLocalityNumber);
	public T apply(DependentThoroughfare dependentThoroughfare);
	public T apply(EndorsementLineCode endorsementLineCode);
	public T apply(Firm firm);
	public T apply(FirmName firmName);
	public T apply(KeyLineCode keyLineCode);
	public T apply(LargeMailUser largeMailUser);
	public T apply(LargeMailUserIdentifier largeMailUserIdentifier);
	public T apply(LargeMailUserName largeMailUserName);
	public T apply(Locality locality);
	public T apply(LocalityName localityName);
	public T apply(MailStop mailStop);
	public T apply(MailStopName mailStopName);
	public T apply(MailStopNumber mailStopNumber);
	public T apply(PostalCode postalCode);
	public T apply(PostalCodeNumber postalCodeNumber);
	public T apply(PostalCodeNumberExtension postalCodeNumberExtension);
	public T apply(PostalRoute postalRoute);
	public T apply(PostalRouteName postalRouteName);
	public T apply(PostalRouteNumber postalRouteNumber);
	public T apply(PostalServiceElements postalServiceElements);
	public T apply(PostBox postBox);
	public T apply(PostBoxNumber postBoxNumber);
	public T apply(PostBoxNumberExtension postBoxNumberExtension);
	public T apply(PostBoxNumberPrefix postBoxNumberPrefix);
	public T apply(PostBoxNumberSuffix postBoxNumberSuffix);
	public T apply(PostOffice postOffice);
	public T apply(PostOfficeName postOfficeName);
	public T apply(PostOfficeNumber postOfficeNumber);
	public T apply(PostTown postTown);
	public T apply(PostTownName postTownName);
	public T apply(PostTownSuffix postTownSuffix);
	public T apply(Premise premise);
	public T apply(PremiseLocation premiseLocation);
	public T apply(PremiseName premiseName);
	public T apply(PremiseNumber premiseNumber);
	public T apply(PremiseNumberPrefix premiseNumberPrefix);
	public T apply(PremiseNumberRange premiseNumberRange);
	public T apply(PremiseNumberRangeFrom premiseNumberRangeFrom);
	public T apply(PremiseNumberRangeTo premiseNumberRangeTo);
	public T apply(PremiseNumberSuffix premiseNumberSuffix);
	public T apply(SortingCode sortingCode);
	public T apply(SubAdministrativeArea subAdministrativeArea);
	public T apply(SubAdministrativeAreaName subAdministrativeAreaName);
	public T apply(SubPremise subPremise);
	public T apply(SubPremiseLocation subPremiseLocation);
	public T apply(SubPremiseName subPremiseName);
	public T apply(SubPremiseNumber subPremiseNumber);
	public T apply(SubPremiseNumberPrefix subPremiseNumberPrefix);
	public T apply(SubPremiseNumberSuffix subPremiseNumberSuffix);
	public T apply(SupplementaryPostalServiceData supplementaryPostalServiceData);
	public T apply(Thoroughfare thoroughfare);
	public T apply(ThoroughfareLeadingType thoroughfareLeadingType);
	public T apply(ThoroughfareName thoroughfareName);
	public T apply(ThoroughfareNumber thoroughfareNumber);
	public T apply(ThoroughfareNumberFrom thoroughfareNumberFrom);
	public T apply(ThoroughfareNumberPrefix thoroughfareNumberPrefix);
	public T apply(ThoroughfareNumberRange thoroughfareNumberRange);
	public T apply(ThoroughfareNumberSuffix thoroughfareNumberSuffix);
	public T apply(ThoroughfareNumberTo thoroughfareNumberTo);
	public T apply(ThoroughfarePostDirection thoroughfarePostDirection);
	public T apply(ThoroughfarePreDirection thoroughfarePreDirection);
	public T apply(ThoroughfareTrailingType thoroughfareTrailingType);
}
