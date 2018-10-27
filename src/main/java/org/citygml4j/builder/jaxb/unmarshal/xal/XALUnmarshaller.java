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
package org.citygml4j.builder.jaxb.unmarshal.xal;

import oasis.names.tc.ciq.xsdschema.xal._2.AddressDetails;
import oasis.names.tc.ciq.xsdschema.xal._2.AddressLineElement;
import oasis.names.tc.ciq.xsdschema.xal._2.AddressLinesType;
import oasis.names.tc.ciq.xsdschema.xal._2.AdministrativeAreaElement;
import oasis.names.tc.ciq.xsdschema.xal._2.BuildingNameType;
import oasis.names.tc.ciq.xsdschema.xal._2.CountryNameElement;
import oasis.names.tc.ciq.xsdschema.xal._2.DepartmentElement;
import oasis.names.tc.ciq.xsdschema.xal._2.DependentLocalityType;
import oasis.names.tc.ciq.xsdschema.xal._2.FirmType;
import oasis.names.tc.ciq.xsdschema.xal._2.LargeMailUserType;
import oasis.names.tc.ciq.xsdschema.xal._2.LocalityElement;
import oasis.names.tc.ciq.xsdschema.xal._2.MailStopType;
import oasis.names.tc.ciq.xsdschema.xal._2.PostBoxElement;
import oasis.names.tc.ciq.xsdschema.xal._2.PostOfficeElement;
import oasis.names.tc.ciq.xsdschema.xal._2.PostalCodeElement;
import oasis.names.tc.ciq.xsdschema.xal._2.PostalRouteType;
import oasis.names.tc.ciq.xsdschema.xal._2.PremiseElement;
import oasis.names.tc.ciq.xsdschema.xal._2.PremiseNumberElement;
import oasis.names.tc.ciq.xsdschema.xal._2.PremiseNumberPrefixElement;
import oasis.names.tc.ciq.xsdschema.xal._2.PremiseNumberSuffixElement;
import oasis.names.tc.ciq.xsdschema.xal._2.SubPremiseType;
import oasis.names.tc.ciq.xsdschema.xal._2.ThoroughfareElement;
import oasis.names.tc.ciq.xsdschema.xal._2.ThoroughfareLeadingTypeType;
import oasis.names.tc.ciq.xsdschema.xal._2.ThoroughfareNameType;
import oasis.names.tc.ciq.xsdschema.xal._2.ThoroughfareNumberElement;
import oasis.names.tc.ciq.xsdschema.xal._2.ThoroughfareNumberPrefixElement;
import oasis.names.tc.ciq.xsdschema.xal._2.ThoroughfareNumberSuffixElement;
import oasis.names.tc.ciq.xsdschema.xal._2.ThoroughfarePostDirectionType;
import oasis.names.tc.ciq.xsdschema.xal._2.ThoroughfarePreDirectionType;
import oasis.names.tc.ciq.xsdschema.xal._2.ThoroughfareTrailingTypeType;
import org.citygml4j.model.module.xal.XALCoreModule;
import org.citygml4j.model.xal.Address;
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
import org.citygml4j.model.xal.XAL;
import org.citygml4j.util.mapper.TypeMapper;

import javax.xml.bind.JAXBElement;
import java.util.concurrent.locks.ReentrantLock;

public class XALUnmarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private TypeMapper<XAL> typeMapper;

	private TypeMapper<XAL> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = TypeMapper.<XAL>create()
							.with(AddressDetails.Address.class, this::unmarshalAddress)
							.with(AddressDetails.class, this::unmarshalAddressDetails)
							.with(AddressDetails.PostalServiceElements.AddressIdentifier.class, this::unmarshalAddressIdentifier)
							.with(AddressDetails.PostalServiceElements.AddressLatitude.class, this::unmarshalAddressLatitude)
							.with(AddressDetails.PostalServiceElements.AddressLatitudeDirection.class, this::unmarshalAddressLatitudeDirection)
							.with(AddressLineElement.class, this::unmarshalAddressLine)
							.with(AddressLinesType.class, this::unmarshalAddressLines)
							.with(AddressDetails.PostalServiceElements.AddressLongitude.class, this::unmarshalAddressLongitude)
							.with(AddressDetails.PostalServiceElements.AddressLongitudeDirection.class, this::unmarshalAddressLongitudeDirection)
							.with(AdministrativeAreaElement.class, this::unmarshalAdministrativeArea)
							.with(AdministrativeAreaElement.AdministrativeAreaName.class, this::unmarshalAdministrativeAreaName)
							.with(AddressDetails.PostalServiceElements.Barcode.class, this::unmarshalBarcode)
							.with(BuildingNameType.class, this::unmarshalBuildingName)
							.with(AddressDetails.Country.class, this::unmarshalCountry)
							.with(CountryNameElement.class, this::unmarshalCountryName)
							.with(AddressDetails.Country.CountryNameCode.class, this::unmarshalCountryNameCode)
							.with(DepartmentElement.class, this::unmarshalDepartment)
							.with(DepartmentElement.DepartmentName.class, this::unmarshalDepartmentName)
							.with(DependentLocalityType.class, this::unmarshalDependentLocality)
							.with(DependentLocalityType.DependentLocalityName.class, this::unmarshalDependentLocalityName)
							.with(DependentLocalityType.DependentLocalityNumber.class, this::unmarshalDependentLocalityNumber)
							.with(ThoroughfareElement.DependentThoroughfare.class, this::unmarshalDependentThoroughfare)
							.with(AddressDetails.PostalServiceElements.EndorsementLineCode.class, this::unmarshalEndorsementLineCode)
							.with(FirmType.class, this::unmarshalFirm)
							.with(FirmType.FirmName.class, this::unmarshalFirmName)
							.with(AddressDetails.PostalServiceElements.KeyLineCode.class, this::unmarshalKeyLineCode)
							.with(LargeMailUserType.class, this::unmarshalLargeMailUser)
							.with(LargeMailUserType.LargeMailUserIdentifier.class, this::unmarshalLargeMailUserIdentifier)
							.with(LargeMailUserType.LargeMailUserName.class, this::unmarshalLargeMailUserName)
							.with(LocalityElement.class, this::unmarshalLocality)
							.with(LocalityElement.LocalityName.class, this::unmarshalLocalityName)
							.with(MailStopType.class, this::unmarshalMailStop)
							.with(MailStopType.MailStopName.class, this::unmarshalMailStopName)
							.with(MailStopType.MailStopNumber.class, this::unmarshalMailStopNumber)
							.with(PostalCodeElement.class, this::unmarshalPostalCode)
							.with(PostalCodeElement.PostalCodeNumber.class, this::unmarshalPostalCodeNumber)
							.with(PostalCodeElement.PostalCodeNumberExtension.class, this::unmarshalPostalCodeNumberExtension)
							.with(PostalRouteType.class, this::unmarshalPostalRoute)
							.with(PostalRouteType.PostalRouteName.class, this::unmarshalPostalRouteName)
							.with(PostalRouteType.PostalRouteNumber.class, this::unmarshalPostalRouteNumber)
							.with(AddressDetails.PostalServiceElements.class, this::unmarshalPostalServiceElements)
							.with(PostBoxElement.class, this::unmarshalPostBox)
							.with(PostBoxElement.PostBoxNumber.class, this::unmarshalPostBoxNumber)
							.with(PostBoxElement.PostBoxNumberExtension.class, this::unmarshalPostBoxNumberExtension)
							.with(PostBoxElement.PostBoxNumberPrefix.class, this::unmarshalPostBoxNumberPrefix)
							.with(PostBoxElement.PostBoxNumberSuffix.class, this::unmarshalPostBoxNumberSuffix)
							.with(PostOfficeElement.class, this::unmarshalPostOffice)
							.with(PostOfficeElement.PostOfficeName.class, this::unmarshalPostOfficeName)
							.with(PostOfficeElement.PostOfficeNumber.class, this::unmarshalPostOfficeNumber)
							.with(PostalCodeElement.PostTown.class, this::unmarshalPostTown)
							.with(PostalCodeElement.PostTown.PostTownName.class, this::unmarshalPostTownName)
							.with(PostalCodeElement.PostTown.PostTownSuffix.class, this::unmarshalPostTownSuffix)
							.with(PremiseElement.class, this::unmarshalPremise)
							.with(PremiseElement.PremiseLocation.class, this::unmarshalPremiseLocation)
							.with(PremiseElement.PremiseName.class, this::unmarshalPremiseName)
							.with(PremiseNumberElement.class, this::unmarshalPremiseNumber)
							.with(PremiseNumberPrefixElement.class, this::unmarshalPremiseNumberPrefix)
							.with(PremiseElement.PremiseNumberRange.class, this::unmarshalPremiseNumberRange)
							.with(PremiseElement.PremiseNumberRange.PremiseNumberRangeFrom.class, this::unmarshalPremiseNumberRangeFrom)
							.with(PremiseElement.PremiseNumberRange.PremiseNumberRangeTo.class, this::unmarshalPremiseNumberRangeTo)
							.with(PremiseNumberSuffixElement.class, this::unmarshalPremiseNumberSuffix)
							.with(AddressDetails.PostalServiceElements.SortingCode.class, this::unmarshalSortingCode)
							.with(AdministrativeAreaElement.SubAdministrativeArea.class, this::unmarshalSubAdministrativeArea)
							.with(AdministrativeAreaElement.SubAdministrativeArea.SubAdministrativeAreaName.class, this::unmarshalSubAdministrativeAreaName)
							.with(SubPremiseType.class, this::unmarshalSubPremise)
							.with(SubPremiseType.SubPremiseLocation.class, this::unmarshalSubPremiseLocation)
							.with(SubPremiseType.SubPremiseName.class, this::unmarshalSubPremiseName)
							.with(SubPremiseType.SubPremiseNumber.class, this::unmarshalSubPremiseNumber)
							.with(SubPremiseType.SubPremiseNumberPrefix.class, this::unmarshalSubPremiseNumberPrefix)
							.with(SubPremiseType.SubPremiseNumberSuffix.class, this::unmarshalSubPremiseNumberSuffix)
							.with(AddressDetails.PostalServiceElements.SupplementaryPostalServiceData.class, this::unmarshalSupplementaryPostalServiceData)
							.with(ThoroughfareElement.class, this::unmarshalThoroughfare)
							.with(ThoroughfareLeadingTypeType.class, this::unmarshalThoroughfareLeadingType)
							.with(ThoroughfareNameType.class, this::unmarshalThoroughfareName)
							.with(ThoroughfareNumberElement.class, this::unmarshalThoroughfareNumber)
							.with(ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberFrom.class, this::unmarshalThoroughfareNumberFrom)
							.with(ThoroughfareNumberPrefixElement.class, this::unmarshalThoroughfareNumberPrefix)
							.with(ThoroughfareElement.ThoroughfareNumberRange.class, this::unmarshalThoroughfareNumberRange)
							.with(ThoroughfareNumberSuffixElement.class, this::unmarshalThoroughfareNumberSuffix)
							.with(ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberTo.class, this::unmarshalThoroughfareNumberTo)
							.with(ThoroughfarePostDirectionType.class, this::unmarshalThoroughfarePostDirection)
							.with(ThoroughfarePreDirectionType.class, this::unmarshalThoroughfarePreDirection)
							.with(ThoroughfareTrailingTypeType.class, this::unmarshalThoroughfareTrailingType)
							.with(JAXBElement.class, this::unmarshal);
				}
			} finally {
				lock.unlock();
			}
		}

		return typeMapper;
	}

	public XAL unmarshal(JAXBElement<?> src) {
		if (src.getName().getNamespaceURI().equals(XALCoreModule.v2_0.getNamespaceURI()))
			return unmarshal(src.getValue());

		return null;		
	}

	public XAL unmarshal(Object src) {
		return getTypeMapper().apply(src);
	}

	public Address unmarshalAddress(AddressDetails.Address src) {
		Address dest = new Address();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public org.citygml4j.model.xal.AddressDetails unmarshalAddressDetails(AddressDetails src) {
		org.citygml4j.model.xal.AddressDetails dest = new org.citygml4j.model.xal.AddressDetails();

		if (src.isSetAddress())
			dest.setAddress(unmarshalAddress(src.getAddress()));

		if (src.isSetAddressDetailsKey())
			dest.setAddressDetailsKey(src.getAddressDetailsKey());

		if (src.isSetAddressLines())
			dest.setAddressLines(unmarshalAddressLines(src.getAddressLines()));

		if (src.isSetAddressType())
			dest.setAddressType(src.getAddressType());

		if (src.isSetAdministrativeArea())
			dest.setAdministrativeArea(unmarshalAdministrativeArea(src.getAdministrativeArea()));

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetCountry())
			dest.setCountry(unmarshalCountry(src.getCountry()));

		if (src.isSetCurrentStatus())
			dest.setCurrentStatus(src.getCurrentStatus());

		if (src.isSetLocality())
			dest.setLocality(unmarshalLocality(src.getLocality()));

		if (src.isSetPostalServiceElements())
			dest.setPostalServiceElements(unmarshalPostalServiceElements(src.getPostalServiceElements()));

		if (src.isSetThoroughfare())
			dest.setThoroughfare(unmarshalThoroughfare(src.getThoroughfare()));

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetValidFromDate())
			dest.setValidFromDate(src.getValidFromDate());

		if (src.isSetValidToDate())
			dest.setValidToDate(src.getValidToDate());		

		return dest;
	}

	public AddressIdentifier unmarshalAddressIdentifier(AddressDetails.PostalServiceElements.AddressIdentifier src) {
		AddressIdentifier dest = new AddressIdentifier();

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetIdentifierType())
			dest.setIdentifierType(src.getIdentifierType());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public AddressLatitude unmarshalAddressLatitude(AddressDetails.PostalServiceElements.AddressLatitude src) {
		AddressLatitude dest = new AddressLatitude();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public AddressLatitudeDirection unmarshalAddressLatitudeDirection(AddressDetails.PostalServiceElements.AddressLatitudeDirection src) {
		AddressLatitudeDirection dest = new AddressLatitudeDirection();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public AddressLine unmarshalAddressLine(AddressLineElement src) {
		AddressLine dest = new AddressLine();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public AddressLines unmarshalAddressLines(AddressLinesType src) {
		AddressLines dest = new AddressLines();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		return dest;
	}

	public AddressLongitude unmarshalAddressLongitude(AddressDetails.PostalServiceElements.AddressLongitude src) {
		AddressLongitude dest = new AddressLongitude();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public AddressLongitudeDirection unmarshalAddressLongitudeDirection(AddressDetails.PostalServiceElements.AddressLongitudeDirection src) {
		AddressLongitudeDirection dest = new AddressLongitudeDirection();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public AdministrativeArea unmarshalAdministrativeArea(AdministrativeAreaElement src) {
		AdministrativeArea dest = new AdministrativeArea();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetAdministrativeAreaName()) {
			for (AdministrativeAreaElement.AdministrativeAreaName administrativeAreaName : src.getAdministrativeAreaName())
				dest.addAdministrativeAreaName(unmarshalAdministrativeAreaName(administrativeAreaName));
		}

		if (src.isSetIndicator())
			dest.setIndicator(src.getIndicator());

		if (src.isSetLocality())
			dest.setLocality(unmarshalLocality(src.getLocality()));

		if (src.isSetPostalCode())
			dest.setPostalCode(unmarshalPostalCode(src.getPostalCode()));

		if (src.isSetPostOffice())
			dest.setPostOffice(unmarshalPostOffice(src.getPostOffice()));

		if (src.isSetSubAdministrativeArea())
			dest.setSubAdministrativeArea(unmarshalSubAdministrativeArea(src.getSubAdministrativeArea()));

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetUsageType())
			dest.setUsageType(src.getUsageType());

		return dest;
	}

	public AdministrativeAreaName unmarshalAdministrativeAreaName(AdministrativeAreaElement.AdministrativeAreaName src) {
		AdministrativeAreaName dest = new AdministrativeAreaName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public Barcode unmarshalBarcode(AddressDetails.PostalServiceElements.Barcode src) {
		Barcode dest = new Barcode();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public BuildingName unmarshalBuildingName(BuildingNameType src) {
		BuildingName dest = new BuildingName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetTypeOccurrence())
			dest.setTypeOccurrence(src.getTypeOccurrence());

		return dest;
	}

	public Country unmarshalCountry(AddressDetails.Country src) {
		Country dest = new Country();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetAdministrativeArea())
			dest.setAdministrativeArea(unmarshalAdministrativeArea(src.getAdministrativeArea()));

		if (src.isSetCountryName()) {
			for (CountryNameElement countryName : src.getCountryName())
				dest.addCountryName(unmarshalCountryName(countryName));
		}

		if (src.isSetCountryNameCode()) {
			for (AddressDetails.Country.CountryNameCode countryNameCode : src.getCountryNameCode())
				dest.addCountryNameCode(unmarshalCountryNameCode(countryNameCode));
		}

		if (src.isSetLocality())
			dest.setLocality(unmarshalLocality(src.getLocality()));

		if (src.isSetThoroughfare())
			dest.setThoroughfare(unmarshalThoroughfare(src.getThoroughfare()));		

		return dest;
	}

	public CountryName unmarshalCountryName(CountryNameElement src) {
		CountryName dest = new CountryName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public CountryNameCode unmarshalCountryNameCode(AddressDetails.Country.CountryNameCode src) {
		CountryNameCode dest = new CountryNameCode();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetScheme())
			dest.setScheme(src.getScheme());

		return dest;
	}

	public Department unmarshalDepartment(DepartmentElement src) {
		Department dest = new Department();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetDepartmentName()) {
			for (DepartmentElement.DepartmentName departmentName : src.getDepartmentName())
				dest.addDepartmentName(unmarshalDepartmentName(departmentName));
		}

		if (src.isSetMailStop())
			dest.setMailStop(unmarshalMailStop(src.getMailStop()));

		if (src.isSetPostalCode())
			dest.setPostalCode(unmarshalPostalCode(src.getPostalCode()));

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public DepartmentName unmarshalDepartmentName(DepartmentElement.DepartmentName src) {
		DepartmentName dest = new DepartmentName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public DependentLocality unmarshalDependentLocality(DependentLocalityType src) {
		DependentLocality dest = new DependentLocality();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetConnector())
			dest.setConnector(src.getConnector());

		if (src.isSetDependentLocality())
			dest.setDependentLocality(unmarshalDependentLocality(src.getDependentLocality()));

		if (src.isSetDependentLocalityName()) {
			for (DependentLocalityType.DependentLocalityName dependentLocalityName : src.getDependentLocalityName())
				dest.addDependentLocalityName(unmarshalDependentLocalityName(dependentLocalityName));
		}

		if (src.isSetDependentLocalityNumber())
			dest.setDependentLocalityNumber(unmarshalDependentLocalityNumber(src.getDependentLocalityNumber()));

		if (src.isSetIndicator())
			dest.setIndicator(src.getIndicator());

		if (src.isSetLargeMailUser())
			dest.setLargeMailUser(unmarshalLargeMailUser(src.getLargeMailUser()));

		if (src.isSetPostalCode())
			dest.setPostalCode(unmarshalPostalCode(src.getPostalCode()));

		if (src.isSetPostalRoute())
			dest.setPostalRoute(unmarshalPostalRoute(src.getPostalRoute()));

		if (src.isSetPostBox())
			dest.setPostBox(unmarshalPostBox(src.getPostBox()));

		if (src.isSetPostOffice())
			dest.setPostOffice(unmarshalPostOffice(src.getPostOffice()));

		if (src.isSetPremise())
			dest.setPremise(unmarshalPremise(src.getPremise()));

		if (src.isSetThoroughfare())
			dest.setThoroughfare(unmarshalThoroughfare(src.getThoroughfare()));

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetUsageType())
			dest.setUsageType(src.getUsageType());

		return dest;
	}

	public DependentLocalityName unmarshalDependentLocalityName(DependentLocalityType.DependentLocalityName src) {
		DependentLocalityName dest = new DependentLocalityName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public DependentLocalityNumber unmarshalDependentLocalityNumber(DependentLocalityType.DependentLocalityNumber src) {
		DependentLocalityNumber dest = new DependentLocalityNumber();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetNameNumberOccurrence())
			dest.setNameNumberOccurrence(src.getNameNumberOccurrence());

		return dest;
	}

	public DependentThoroughfare unmarshalDependentThoroughfare(ThoroughfareElement.DependentThoroughfare src) {
		DependentThoroughfare dest = new DependentThoroughfare();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetThoroughfareLeadingType())
			dest.setThoroughfareLeadingType(unmarshalThoroughfareLeadingType(src.getThoroughfareLeadingType()));

		if (src.isSetThoroughfareName()) {
			for (ThoroughfareNameType thoroughfareName : src.getThoroughfareName())
				dest.addThoroughfareName(unmarshalThoroughfareName(thoroughfareName));
		}

		if (src.isSetThoroughfarePostDirection())
			dest.setThoroughfarePostDirection(unmarshalThoroughfarePostDirection(src.getThoroughfarePostDirection()));

		if (src.isSetThoroughfarePreDirection())
			dest.setThoroughfarePreDirection(unmarshalThoroughfarePreDirection(src.getThoroughfarePreDirection()));

		if (src.isSetThoroughfareTrailingType())
			dest.setThoroughfareTrailingType(unmarshalThoroughfareTrailingType(src.getThoroughfareTrailingType()));

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public EndorsementLineCode unmarshalEndorsementLineCode(AddressDetails.PostalServiceElements.EndorsementLineCode src) {
		EndorsementLineCode dest = new EndorsementLineCode();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public Firm unmarshalFirm(FirmType src) {
		Firm dest = new Firm();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetDepartment()) {
			for (DepartmentElement department : src.getDepartment())
				dest.addDepartment(unmarshalDepartment(department));
		}

		if (src.isSetFirmName()) {
			for (FirmType.FirmName firmName : src.getFirmName())
				dest.addFirmName(unmarshalFirmName(firmName));
		}

		if (src.isSetMailStop())
			dest.setMailStop(unmarshalMailStop(src.getMailStop()));

		if (src.isSetPostalCode())
			dest.setPostalCode(unmarshalPostalCode(src.getPostalCode()));

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public FirmName unmarshalFirmName(FirmType.FirmName src) {
		FirmName dest = new FirmName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public KeyLineCode unmarshalKeyLineCode(AddressDetails.PostalServiceElements.KeyLineCode src) {
		KeyLineCode dest = new KeyLineCode();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public LargeMailUser unmarshalLargeMailUser(LargeMailUserType src) {
		LargeMailUser dest = new LargeMailUser();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetBuildingName()) {
			for (BuildingNameType buildingName : src.getBuildingName())
				dest.addBuildingName(unmarshalBuildingName(buildingName));
		}

		if (src.isSetDepartment())
			dest.setDepartment(unmarshalDepartment(src.getDepartment()));

		if (src.isSetLargeMailUserIdentifier())
			dest.setLargeMailUserIdentifier(unmarshalLargeMailUserIdentifier(src.getLargeMailUserIdentifier()));

		if (src.isSetLargeMailUserName()) {
			for (LargeMailUserType.LargeMailUserName largeMailUserName : src.getLargeMailUserName())
				dest.addLargeMailUserName(unmarshalLargeMailUserName(largeMailUserName));
		}

		if (src.isSetPostalCode())
			dest.setPostalCode(unmarshalPostalCode(src.getPostalCode()));

		if (src.isSetPostBox())
			dest.setPostBox(unmarshalPostBox(src.getPostBox()));

		if (src.isSetThoroughfare())
			dest.setThoroughfare(unmarshalThoroughfare(src.getThoroughfare()));

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public LargeMailUserIdentifier unmarshalLargeMailUserIdentifier(LargeMailUserType.LargeMailUserIdentifier src) {
		LargeMailUserIdentifier dest = new LargeMailUserIdentifier();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetIndicator())
			dest.setIndicator(src.getIndicator());

		return dest;
	}

	public LargeMailUserName unmarshalLargeMailUserName(LargeMailUserType.LargeMailUserName src) {
		LargeMailUserName dest = new LargeMailUserName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public Locality unmarshalLocality(LocalityElement src) {
		Locality dest = new Locality();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetDependentLocality())
			dest.setDependentLocality(unmarshalDependentLocality(src.getDependentLocality()));

		if (src.isSetIndicator())
			dest.setIndicator(src.getIndicator());

		if (src.isSetLargeMailUser())
			dest.setLargeMailUser(unmarshalLargeMailUser(src.getLargeMailUser()));

		if (src.isSetLocalityName()) {
			for (LocalityElement.LocalityName localityName : src.getLocalityName())
				dest.addLocalityName(unmarshalLocalityName(localityName));
		}

		if (src.isSetPostalCode())
			dest.setPostalCode(unmarshalPostalCode(src.getPostalCode()));

		if (src.isSetPostalRoute())
			dest.setPostalRoute(unmarshalPostalRoute(src.getPostalRoute()));

		if (src.isSetPostBox())
			dest.setPostBox(unmarshalPostBox(src.getPostBox()));

		if (src.isSetPostOffice())
			dest.setPostOffice(unmarshalPostOffice(src.getPostOffice()));

		if (src.isSetPremise())
			dest.setPremise(unmarshalPremise(src.getPremise()));

		if (src.isSetThoroughfare())
			dest.setThoroughfare(unmarshalThoroughfare(src.getThoroughfare()));

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetUsageType())
			dest.setUsageType(src.getUsageType());

		return dest;
	}

	public LocalityName unmarshalLocalityName(LocalityElement.LocalityName src) {
		LocalityName dest = new LocalityName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public MailStop unmarshalMailStop(MailStopType src) {
		MailStop dest = new MailStop();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetMailStopName())
			dest.setMailStopName(unmarshalMailStopName(src.getMailStopName()));

		if (src.isSetMailStopNumber())
			dest.setMailStopNumber(unmarshalMailStopNumber(src.getMailStopNumber()));

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public MailStopName unmarshalMailStopName(MailStopType.MailStopName src) {
		MailStopName dest = new MailStopName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public MailStopNumber unmarshalMailStopNumber(MailStopType.MailStopNumber src) {
		MailStopNumber dest = new MailStopNumber();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetNameNumberSeparator())
			dest.setNameNumberSeparator(src.getNameNumberSeparator());

		return dest;
	}

	public PostalCode unmarshalPostalCode(PostalCodeElement src) {
		PostalCode dest = new PostalCode();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetPostalCodeNumber()) {
			for (PostalCodeElement.PostalCodeNumber postalCodeNumber : src.getPostalCodeNumber())
				dest.addPostalCodeNumber(unmarshalPostalCodeNumber(postalCodeNumber));
		}

		if (src.isSetPostalCodeNumberExtension()) {
			for (PostalCodeElement.PostalCodeNumberExtension postalCodeNumberExtension : src.getPostalCodeNumberExtension())
				dest.addPostalCodeNumberExtension(unmarshalPostalCodeNumberExtension(postalCodeNumberExtension));
		}

		if (src.isSetPostTown())
			dest.setPostTown(unmarshalPostTown(src.getPostTown()));

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PostalCodeNumber unmarshalPostalCodeNumber(PostalCodeElement.PostalCodeNumber src) {
		PostalCodeNumber dest = new PostalCodeNumber();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PostalCodeNumberExtension unmarshalPostalCodeNumberExtension(PostalCodeElement.PostalCodeNumberExtension src) {
		PostalCodeNumberExtension dest = new PostalCodeNumberExtension();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetNumberExtensionSeparator())
			dest.setNumberExtensionSeparator(src.getNumberExtensionSeparator());

		return dest;
	}

	public PostalRoute unmarshalPostalRoute(PostalRouteType src) {
		PostalRoute dest = new PostalRoute();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetPostalRouteName()) {
			for (PostalRouteType.PostalRouteName postalRouteName : src.getPostalRouteName())
				dest.addPostalRouteName(unmarshalPostalRouteName(postalRouteName));
		}

		if (src.isSetPostalRouteNumber())
			dest.setPostalRouteNumber(unmarshalPostalRouteNumber(src.getPostalRouteNumber()));

		if (src.isSetPostBox())
			dest.setPostBox(unmarshalPostBox(src.getPostBox()));

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PostalRouteName unmarshalPostalRouteName(PostalRouteType.PostalRouteName src) {
		PostalRouteName dest = new PostalRouteName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PostalRouteNumber unmarshalPostalRouteNumber(PostalRouteType.PostalRouteNumber src) {
		PostalRouteNumber dest = new PostalRouteNumber();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		return dest;
	}

	public PostalServiceElements unmarshalPostalServiceElements(AddressDetails.PostalServiceElements src) {
		PostalServiceElements dest = new PostalServiceElements();

		if (src.isSetAddressIdentifier()) {
			for (AddressDetails.PostalServiceElements.AddressIdentifier addressIdentifier : src.getAddressIdentifier())
				dest.addAddressIdentifier(unmarshalAddressIdentifier(addressIdentifier));
		}

		if (src.isSetAddressLatitude())
			dest.setAddressLatitude(unmarshalAddressLatitude(src.getAddressLatitude()));

		if (src.isSetAddressLatitudeDirection())
			dest.setAddressLatitudeDirection(unmarshalAddressLatitudeDirection(src.getAddressLatitudeDirection()));

		if (src.isSetAddressLongitude())
			dest.setAddressLongitude(unmarshalAddressLongitude(src.getAddressLongitude()));

		if (src.isSetAddressLongitudeDirection())
			dest.setAddressLongitudeDirection(unmarshalAddressLongitudeDirection(src.getAddressLongitudeDirection()));

		if (src.isSetBarcode())
			dest.setBarcode(unmarshalBarcode(src.getBarcode()));

		if (src.isSetEndorsementLineCode())
			dest.setEndorsementLineCode(unmarshalEndorsementLineCode(src.getEndorsementLineCode()));

		if (src.isSetKeyLineCode())
			dest.setKeyLineCode(unmarshalKeyLineCode(src.getKeyLineCode()));

		if (src.isSetSortingCode())
			dest.setSortingCode(unmarshalSortingCode(src.getSortingCode()));

		if (src.isSetSupplementaryPostalServiceData()) {
			for (AddressDetails.PostalServiceElements.SupplementaryPostalServiceData supplementaryPostalServiceData : src.getSupplementaryPostalServiceData())
				dest.addSupplementaryPostalServiceData(unmarshalSupplementaryPostalServiceData(supplementaryPostalServiceData));
		}

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PostBox unmarshalPostBox(PostBoxElement src) {
		PostBox dest = new PostBox();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetFirm())
			dest.setFirm(unmarshalFirm(src.getFirm()));

		if (src.isSetIndicator())
			dest.setIndicator(src.getIndicator());

		if (src.isSetPostalCode())
			dest.setPostalCode(unmarshalPostalCode(src.getPostalCode()));

		if (src.isSetPostBoxNumber())
			dest.setPostBoxNumber(unmarshalPostBoxNumber(src.getPostBoxNumber()));

		if (src.isSetPostBoxNumberExtension())
			dest.setPostBoxNumberExtension(unmarshalPostBoxNumberExtension(src.getPostBoxNumberExtension()));

		if (src.isSetPostBoxNumberPrefix())
			dest.setPostBoxNumberPrefix(unmarshalPostBoxNumberPrefix(src.getPostBoxNumberPrefix()));

		if (src.isSetPostBoxNumberSuffix())
			dest.setPostBoxNumberSuffix(unmarshalPostBoxNumberSuffix(src.getPostBoxNumberSuffix()));

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PostBoxNumber unmarshalPostBoxNumber(PostBoxElement.PostBoxNumber src) {
		PostBoxNumber dest = new PostBoxNumber();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		return dest;
	}

	public PostBoxNumberExtension unmarshalPostBoxNumberExtension(PostBoxElement.PostBoxNumberExtension src) {
		PostBoxNumberExtension dest = new PostBoxNumberExtension();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetNumberExtensionSeparator())
			dest.setNumberExtensionSeparator(src.getNumberExtensionSeparator());

		return dest;
	}

	public PostBoxNumberPrefix unmarshalPostBoxNumberPrefix(PostBoxElement.PostBoxNumberPrefix src) {
		PostBoxNumberPrefix dest = new PostBoxNumberPrefix();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetNumberPrefixSeparator())
			dest.setNumberPrefixSeparator(src.getNumberPrefixSeparator());

		return dest;
	}

	public PostBoxNumberSuffix unmarshalPostBoxNumberSuffix(PostBoxElement.PostBoxNumberSuffix src) {
		PostBoxNumberSuffix dest = new PostBoxNumberSuffix();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetNumberSuffixSeparator())
			dest.setNumberSuffixSeparator(src.getNumberSuffixSeparator());

		return dest;
	}

	public PostOffice unmarshalPostOffice(PostOfficeElement src) {
		PostOffice dest = new PostOffice();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetIndicator())
			dest.setIndicator(src.getIndicator());

		if (src.isSetPostalCode())
			dest.setPostalCode(unmarshalPostalCode(src.getPostalCode()));

		if (src.isSetPostalRoute())
			dest.setPostalRoute(unmarshalPostalRoute(src.getPostalRoute()));

		if (src.isSetPostBox())
			dest.setPostBox(unmarshalPostBox(src.getPostBox()));

		if (src.isSetPostOfficeName()) {
			for (PostOfficeElement.PostOfficeName postOfficeName : src.getPostOfficeName())
				dest.addPostOfficeName(unmarshalPostOfficeName(postOfficeName));
		}

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PostOfficeName unmarshalPostOfficeName(PostOfficeElement.PostOfficeName src) {
		PostOfficeName dest = new PostOfficeName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PostOfficeNumber unmarshalPostOfficeNumber(PostOfficeElement.PostOfficeNumber src) {
		PostOfficeNumber dest = new PostOfficeNumber();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetIndicator())
			dest.setIndicator(src.getIndicator());

		if (src.isSetIndicatorOccurrence())
			dest.setIndicatorOccurrence(src.getIndicatorOccurrence());

		return dest;
	}

	public PostTown unmarshalPostTown(PostalCodeElement.PostTown src) {
		PostTown dest = new PostTown();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetPostTownName()) {
			for (PostalCodeElement.PostTown.PostTownName postTownName : src.getPostTownName())
				dest.addPostTownName(unmarshalPostTownName(postTownName));
		}

		if (src.isSetPostTownSuffix())
			dest.setPostTownSuffix(unmarshalPostTownSuffix(src.getPostTownSuffix()));

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PostTownName unmarshalPostTownName(PostalCodeElement.PostTown.PostTownName src) {
		PostTownName dest = new PostTownName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PostTownSuffix unmarshalPostTownSuffix(PostalCodeElement.PostTown.PostTownSuffix src) {
		PostTownSuffix dest = new PostTownSuffix();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		return dest;
	}

	public Premise unmarshalPremise(PremiseElement src) {
		Premise dest = new Premise();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetBuildingName()) {
			for (BuildingNameType buildingName : src.getBuildingName())
				dest.addBuildingName(unmarshalBuildingName(buildingName));
		}

		if (src.isSetFirm())
			dest.setFirm(unmarshalFirm(src.getFirm()));

		if (src.isSetMailStop())
			dest.setMailStop(unmarshalMailStop(src.getMailStop()));

		if (src.isSetPostalCode())
			dest.setPostalCode(unmarshalPostalCode(src.getPostalCode()));

		if (src.isSetPremise())
			dest.setPremise(unmarshalPremise(src.getPremise()));

		if (src.isSetPremiseDependency())
			dest.setPremiseDependency(src.getPremiseDependency());

		if (src.isSetPremiseDependencyType())
			dest.setPremiseDependencyType(src.getPremiseDependencyType());

		if (src.isSetPremiseLocation())
			dest.setPremiseLocation(unmarshalPremiseLocation(src.getPremiseLocation()));

		if (src.isSetPremiseName()) {
			for (PremiseElement.PremiseName premiseName : src.getPremiseName())
				dest.addPremiseName(unmarshalPremiseName(premiseName));
		}

		if (src.isSetPremiseNumber()) {
			for (PremiseNumberElement premiseNumber : src.getPremiseNumber())
				dest.addPremiseNumber(unmarshalPremiseNumber(premiseNumber));
		}

		if (src.isSetPremiseNumberPrefix()) {
			for (PremiseNumberPrefixElement premiseNumberPrefix : src.getPremiseNumberPrefix())
				dest.addPremiseNumberPrefix(unmarshalPremiseNumberPrefix(premiseNumberPrefix));
		}

		if (src.isSetPremiseNumberSuffix()) {
			for (PremiseNumberSuffixElement premiseNumberSuffix : src.getPremiseNumberSuffix())
				dest.addPremiseNumberSuffix(unmarshalPremiseNumberSuffix(premiseNumberSuffix));
		}

		if (src.isSetPremiseNumberRange())
			dest.setPremiseNumberRange(unmarshalPremiseNumberRange(src.getPremiseNumberRange()));

		if (src.isSetPremiseThoroughfareConnector())
			dest.setPremiseThoroughfareConnector(src.getPremiseThoroughfareConnector());

		if (src.isSetSubPremise()) {
			for (SubPremiseType subPremise : src.getSubPremise())
				dest.addSubPremise(unmarshalSubPremise(subPremise));
		}

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PremiseLocation unmarshalPremiseLocation(PremiseElement.PremiseLocation src) {
		PremiseLocation dest = new PremiseLocation();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		return dest;
	}

	public PremiseName unmarshalPremiseName(PremiseElement.PremiseName src) {
		PremiseName dest = new PremiseName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetTypeOccurrence())
			dest.setTypeOccurrence(src.getTypeOccurrence());

		return dest;
	}

	public PremiseNumber unmarshalPremiseNumber(PremiseNumberElement src) {
		PremiseNumber dest = new PremiseNumber();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetNumberType())
			dest.setType(src.getNumberType());

		if (src.isSetNumberTypeOccurrence())
			dest.setNumberTypeOccurrence(src.getNumberTypeOccurrence());

		if (src.isSetIndicator())
			dest.setIndicator(src.getIndicator());

		if (src.isSetIndicatorOccurrence())
			dest.setIndicatorOccurrence(src.getIndicatorOccurrence());

		return dest;
	}

	public PremiseNumberPrefix unmarshalPremiseNumberPrefix(PremiseNumberPrefixElement src) {
		PremiseNumberPrefix dest = new PremiseNumberPrefix();

		if (src.isSetValue())
			dest.setValue(src.getValue());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetNumberPrefixSeparator())
			dest.setNumberPrefixSeparator(src.getNumberPrefixSeparator());

		return dest;
	}

	public PremiseNumberRange unmarshalPremiseNumberRange(PremiseElement.PremiseNumberRange src) {
		PremiseNumberRange dest = new PremiseNumberRange();

		if (src.isSetIndicator())
			dest.setIndicator(src.getIndicator());

		if (src.isSetIndicatorOccurence())
			dest.setIndicatorOccurence(src.getIndicatorOccurence());

		if (src.isSetNumberRangeOccurence())
			dest.setNumberRangeOccurence(src.getNumberRangeOccurence());

		if (src.isSetPremiseNumberRangeFrom())
			dest.setPremiseNumberRangeFrom(unmarshalPremiseNumberRangeFrom(src.getPremiseNumberRangeFrom()));

		if (src.isSetPremiseNumberRangeTo())
			dest.setPremiseNumberRangeTo(unmarshalPremiseNumberRangeTo(src.getPremiseNumberRangeTo()));

		if (src.isSetRangeType())
			dest.setRangeType(src.getRangeType());

		if (src.isSetSeparator())
			dest.setSeparator(src.getSeparator());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;		
	}

	public PremiseNumberRangeFrom unmarshalPremiseNumberRangeFrom(PremiseElement.PremiseNumberRange.PremiseNumberRangeFrom src) {
		PremiseNumberRangeFrom dest = new PremiseNumberRangeFrom();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetPremiseNumber()) {
			for (PremiseNumberElement premiseNumber : src.getPremiseNumber())
				dest.addPremiseNumber(unmarshalPremiseNumber(premiseNumber));
		}

		if (src.isSetPremiseNumberPrefix()) {
			for (PremiseNumberPrefixElement premiseNumberPrefix : src.getPremiseNumberPrefix())
				dest.addPremiseNumberPrefix(unmarshalPremiseNumberPrefix(premiseNumberPrefix));
		}

		if (src.isSetPremiseNumberSuffix()) {
			for (PremiseNumberSuffixElement premiseNumberSuffix : src.getPremiseNumberSuffix())
				dest.addPremiseNumberSuffix(unmarshalPremiseNumberSuffix(premiseNumberSuffix));
		}

		return dest;
	}

	public PremiseNumberRangeTo unmarshalPremiseNumberRangeTo(PremiseElement.PremiseNumberRange.PremiseNumberRangeTo src) {
		PremiseNumberRangeTo dest = new PremiseNumberRangeTo();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetPremiseNumber()) {
			for (PremiseNumberElement premiseNumber : src.getPremiseNumber())
				dest.addPremiseNumber(unmarshalPremiseNumber(premiseNumber));
		}

		if (src.isSetPremiseNumberPrefix()) {
			for (PremiseNumberPrefixElement premiseNumberPrefix : src.getPremiseNumberPrefix())
				dest.addPremiseNumberPrefix(unmarshalPremiseNumberPrefix(premiseNumberPrefix));
		}

		if (src.isSetPremiseNumberSuffix()) {
			for (PremiseNumberSuffixElement premiseNumberSuffix : src.getPremiseNumberSuffix())
				dest.addPremiseNumberSuffix(unmarshalPremiseNumberSuffix(premiseNumberSuffix));
		}

		return dest;
	}

	public PremiseNumberSuffix unmarshalPremiseNumberSuffix(PremiseNumberSuffixElement src) {
		PremiseNumberSuffix dest = new PremiseNumberSuffix();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetNumberSuffixSeparator())
			dest.setNumberSuffixSeparator(src.getNumberSuffixSeparator());

		return dest;
	}

	public SortingCode unmarshalSortingCode(AddressDetails.PostalServiceElements.SortingCode src) {
		SortingCode dest = new SortingCode();

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public SubAdministrativeArea unmarshalSubAdministrativeArea(AdministrativeAreaElement.SubAdministrativeArea src) {
		SubAdministrativeArea dest = new SubAdministrativeArea();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetIndicator())
			dest.setIndicator(src.getIndicator());

		if (src.isSetLocality())
			dest.setLocality(unmarshalLocality(src.getLocality()));

		if (src.isSetPostalCode())
			dest.setPostalCode(unmarshalPostalCode(src.getPostalCode()));

		if (src.isSetPostOffice())
			dest.setPostOffice(unmarshalPostOffice(src.getPostOffice()));

		if (src.isSetSubAdministrativeAreaName()) {
			for (AdministrativeAreaElement.SubAdministrativeArea.SubAdministrativeAreaName subAdministrativeAreaName : src.getSubAdministrativeAreaName())
				dest.addSubAdministrativeAreaName(unmarshalSubAdministrativeAreaName(subAdministrativeAreaName));
		}

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetUsageType())
			dest.setUsageType(src.getUsageType());

		return dest;
	}

	public SubAdministrativeAreaName unmarshalSubAdministrativeAreaName(AdministrativeAreaElement.SubAdministrativeArea.SubAdministrativeAreaName src) {
		SubAdministrativeAreaName dest = new SubAdministrativeAreaName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public SubPremise unmarshalSubPremise(SubPremiseType src) {
		SubPremise dest = new SubPremise();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetBuildingName()) {
			for (BuildingNameType buildingName : src.getBuildingName())
				dest.addBuildingName(unmarshalBuildingName(buildingName));
		}

		if (src.isSetFirm())
			dest.setFirm(unmarshalFirm(src.getFirm()));

		if (src.isSetMailStop())
			dest.setMailStop(unmarshalMailStop(src.getMailStop()));

		if (src.isSetPostalCode())
			dest.setPostalCode(unmarshalPostalCode(src.getPostalCode()));

		if (src.isSetSubPremise())
			dest.setSubPremise(unmarshalSubPremise(src.getSubPremise()));

		if (src.isSetSubPremiseLocation())
			dest.setSubPremiseLocation(unmarshalSubPremiseLocation(src.getSubPremiseLocation()));

		if (src.isSetSubPremiseName()) {
			for (SubPremiseType.SubPremiseName subPremiseName : src.getSubPremiseName())
				dest.addSubPremiseName(unmarshalSubPremiseName(subPremiseName));
		}

		if (src.isSetSubPremiseNumber()) {
			for (SubPremiseType.SubPremiseNumber subPremiseNumber : src.getSubPremiseNumber())
				dest.addSubPremiseNumber(unmarshalSubPremiseNumber(subPremiseNumber));
		}

		if (src.isSetSubPremiseNumberPrefix()) {
			for (SubPremiseType.SubPremiseNumberPrefix subPremiseNumberPrefix : src.getSubPremiseNumberPrefix())
				dest.addSubPremiseNumberPrefix(unmarshalSubPremiseNumberPrefix(subPremiseNumberPrefix));
		}

		if (src.isSetSubPremiseNumberSuffix()) {
			for (SubPremiseType.SubPremiseNumberSuffix subPremiseNumberSuffix : src.getSubPremiseNumberSuffix())
				dest.addSubPremiseNumberSuffix(unmarshalSubPremiseNumberSuffix(subPremiseNumberSuffix));
		}

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public SubPremiseLocation unmarshalSubPremiseLocation(SubPremiseType.SubPremiseLocation src) {
		SubPremiseLocation dest = new SubPremiseLocation();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		return dest;
	}

	public SubPremiseName unmarshalSubPremiseName(SubPremiseType.SubPremiseName src) {
		SubPremiseName dest = new SubPremiseName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetTypeOccurrence())
			dest.setTypeOccurrence(src.getTypeOccurrence());

		return dest;
	}

	public SubPremiseNumber unmarshalSubPremiseNumber(SubPremiseType.SubPremiseNumber src) {
		SubPremiseNumber dest = new SubPremiseNumber();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetIndicator())
			dest.setIndicator(src.getIndicator());

		if (src.isSetIndicatorOccurrence())
			dest.setIndicatorOccurrence(src.getIndicatorOccurrence());

		if (src.isSetNumberTypeOccurrence())
			dest.setNumberTypeOccurrence(src.getNumberTypeOccurrence());

		if (src.isSetPremiseNumberSeparator())
			dest.setPremiseNumberSeparator(src.getPremiseNumberSeparator());

		return dest;
	}

	public SubPremiseNumberPrefix unmarshalSubPremiseNumberPrefix(SubPremiseType.SubPremiseNumberPrefix src) {
		SubPremiseNumberPrefix dest = new SubPremiseNumberPrefix();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetNumberPrefixSeparator())
			dest.setNumberPrefixSeparator(src.getNumberPrefixSeparator());

		return dest;
	}

	public SubPremiseNumberSuffix unmarshalSubPremiseNumberSuffix(SubPremiseType.SubPremiseNumberSuffix src) {
		SubPremiseNumberSuffix dest = new SubPremiseNumberSuffix();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetNumberSuffixSeparator())
			dest.setNumberSuffixSeparator(src.getNumberSuffixSeparator());

		return dest;
	}

	public SupplementaryPostalServiceData unmarshalSupplementaryPostalServiceData(AddressDetails.PostalServiceElements.SupplementaryPostalServiceData src) {
		SupplementaryPostalServiceData dest = new SupplementaryPostalServiceData();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public Thoroughfare unmarshalThoroughfare(ThoroughfareElement src) {
		Thoroughfare dest = new Thoroughfare();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetDependentLocality())
			dest.setDependentLocality(unmarshalDependentLocality(src.getDependentLocality()));

		if (src.isSetDependentThoroughfare())
			dest.setDependentThoroughfare(unmarshalDependentThoroughfare(src.getDependentThoroughfare()));

		if (src.isSetDependentThoroughfares())
			dest.setDependentThoroughfares(src.getDependentThoroughfares());

		if (src.isSetDependentThoroughfaresConnector())
			dest.setDependentThoroughfaresConnector(src.getDependentThoroughfaresConnector());

		if (src.isSetDependentThoroughfaresIndicator())
			dest.setDependentThoroughfaresIndicator(src.getDependentThoroughfaresIndicator());

		if (src.isSetDependentThoroughfaresType())
			dest.setDependentThoroughfaresType(src.getDependentThoroughfaresType());

		if (src.isSetFirm())
			dest.setFirm(unmarshalFirm(src.getFirm()));

		if (src.isSetPostalCode())
			dest.setPostalCode(unmarshalPostalCode(src.getPostalCode()));

		if (src.isSetPremise())
			dest.setPremise(unmarshalPremise(src.getPremise()));

		if (src.isSetThoroughfareLeadingType())
			dest.setThoroughfareLeadingType(unmarshalThoroughfareLeadingType(src.getThoroughfareLeadingType()));

		if (src.isSetThoroughfareName()) {
			for (ThoroughfareNameType thoroughfareName : src.getThoroughfareName())
				dest.addThoroughfareName(unmarshalThoroughfareName(thoroughfareName));
		}

		if (src.isSetThoroughfareNumberOrThoroughfareNumberRange()) {
			for (Object content : src.getThoroughfareNumberOrThoroughfareNumberRange()) {
				XAL value = unmarshal(content);
				if (value instanceof ThoroughfareNumber)
					dest.addThoroughfareNumber((ThoroughfareNumber)value);
				else if (value instanceof ThoroughfareNumberRange)
					dest.addThoroughfareNumberRange((ThoroughfareNumberRange)value);
			}
		}

		if (src.isSetThoroughfareNumberPrefix()) {
			for (ThoroughfareNumberPrefixElement thoroughfareNumberPrefix : src.getThoroughfareNumberPrefix())
				dest.addThoroughfareNumberPrefix(unmarshalThoroughfareNumberPrefix(thoroughfareNumberPrefix));
		}

		if (src.isSetThoroughfareNumberSuffix()) {
			for (ThoroughfareNumberSuffixElement thoroughfareNumberSuffix : src.getThoroughfareNumberSuffix())
				dest.addThoroughfareNumberSuffix(unmarshalThoroughfareNumberSuffix(thoroughfareNumberSuffix));
		}

		if (src.isSetThoroughfarePostDirection())
			dest.setThoroughfarePostDirection(unmarshalThoroughfarePostDirection(src.getThoroughfarePostDirection()));

		if (src.isSetThoroughfarePreDirection())
			dest.setThoroughfarePreDirection(unmarshalThoroughfarePreDirection(src.getThoroughfarePreDirection()));

		if (src.isSetThoroughfareTrailingType())
			dest.setThoroughfareTrailingType(unmarshalThoroughfareTrailingType(src.getThoroughfareTrailingType()));

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public ThoroughfareLeadingType unmarshalThoroughfareLeadingType(ThoroughfareLeadingTypeType src) {
		ThoroughfareLeadingType dest = new ThoroughfareLeadingType();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public ThoroughfareName unmarshalThoroughfareName(ThoroughfareNameType src) {
		ThoroughfareName dest = new ThoroughfareName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public ThoroughfareNumber unmarshalThoroughfareNumber(ThoroughfareNumberElement src) {
		ThoroughfareNumber dest = new ThoroughfareNumber();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetIndicator())
			dest.setIndicator(src.getIndicator());

		if (src.isSetIndicatorOccurrence())
			dest.setIndicatorOccurrence(src.getIndicatorOccurrence());

		if (src.isSetNumberOccurrence())
			dest.setNumberOccurrence(src.getNumberOccurrence());

		if (src.isSetNumberType())
			dest.setNumberType(src.getNumberType());

		return dest;
	}

	public ThoroughfareNumberFrom unmarshalThoroughfareNumberFrom(ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberFrom src) {
		ThoroughfareNumberFrom dest = new ThoroughfareNumberFrom();

		if (src.isSetContent()) {
			for (Object content : src.getContent()) {
				if (content instanceof String)
					dest.addString((String)content);
				else {
					XAL value = unmarshal(content);
					if (value instanceof AddressLine)
						dest.addAddressLine((AddressLine)value);
					else if (value instanceof ThoroughfareNumber)
						dest.addThoroughfareNumber((ThoroughfareNumber)value);
					else if (value instanceof ThoroughfareNumberPrefix)
						dest.addThoroughfareNumberPrefix((ThoroughfareNumberPrefix)value);
					else if (value instanceof ThoroughfareNumberSuffix)
						dest.addThoroughfareNumberSuffix((ThoroughfareNumberSuffix)value);
				}
			}
		}

		if (src.isSetCode())
			dest.setCode(src.getCode());

		return dest;
	}

	public ThoroughfareNumberPrefix unmarshalThoroughfareNumberPrefix(ThoroughfareNumberPrefixElement src) {
		ThoroughfareNumberPrefix dest = new ThoroughfareNumberPrefix();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetNumberPrefixSeparator())
			dest.setNumberPrefixSeparator(src.getNumberPrefixSeparator());

		return dest;
	}

	public ThoroughfareNumberRange unmarshalThoroughfareNumberRange(ThoroughfareElement.ThoroughfareNumberRange src) {
		ThoroughfareNumberRange dest = new ThoroughfareNumberRange();

		if (src.isSetAddressLine()) {
			for (AddressLineElement addressLine : src.getAddressLine())
				dest.addAddressLine(unmarshalAddressLine(addressLine));
		}

		if (src.isSetThoroughfareNumberFrom())
			dest.setThoroughfareNumberFrom(unmarshalThoroughfareNumberFrom(src.getThoroughfareNumberFrom()));

		if (src.isSetThoroughfareNumberTo())
			dest.setThoroughfareNumberTo(unmarshalThoroughfareNumberTo(src.getThoroughfareNumberTo()));

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetIndicator())
			dest.setIndicator(src.getIndicator());

		if (src.isSetIndicatorOccurrence())
			dest.setIndicatorOccurrence(src.getIndicatorOccurrence());

		if (src.isSetNumberRangeOccurrence())
			dest.setNumberRangeOccurrence(src.getNumberRangeOccurrence());

		if (src.isSetRangeType())
			dest.setRangeType(src.getRangeType());

		if (src.isSetSeparator())
			dest.setSeparator(src.getSeparator());

		if (src.isSetType())
			dest.setType(src.getType());		

		return dest;
	}

	public ThoroughfareNumberSuffix unmarshalThoroughfareNumberSuffix(ThoroughfareNumberSuffixElement src) {
		ThoroughfareNumberSuffix dest = new ThoroughfareNumberSuffix();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetNumberSuffixSeparator())
			dest.setNumberSuffixSeparator(src.getNumberSuffixSeparator());

		return dest;
	}

	public ThoroughfareNumberTo unmarshalThoroughfareNumberTo(ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberTo src) {
		ThoroughfareNumberTo dest = new ThoroughfareNumberTo();

		if (src.isSetContent()) {
			for (Object content : src.getContent()) {
				if (content instanceof String)
					dest.addString((String)content);
				else {
					XAL value = unmarshal(content);
					if (value instanceof AddressLine)
						dest.addAddressLine((AddressLine)value);
					else if (value instanceof ThoroughfareNumber)
						dest.addThoroughfareNumber((ThoroughfareNumber)value);
					else if (value instanceof ThoroughfareNumberPrefix)
						dest.addThoroughfareNumberPrefix((ThoroughfareNumberPrefix)value);
					else if (value instanceof ThoroughfareNumberSuffix)
						dest.addThoroughfareNumberSuffix((ThoroughfareNumberSuffix)value);
				}
			}
		}

		if (src.isSetCode())
			dest.setCode(src.getCode());

		return dest;
	}

	public ThoroughfarePostDirection unmarshalThoroughfarePostDirection(ThoroughfarePostDirectionType src) {
		ThoroughfarePostDirection dest = new ThoroughfarePostDirection();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public ThoroughfarePreDirection unmarshalThoroughfarePreDirection(ThoroughfarePreDirectionType src) {
		ThoroughfarePreDirection dest = new ThoroughfarePreDirection();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public ThoroughfareTrailingType unmarshalThoroughfareTrailingType(ThoroughfareTrailingTypeType src) {
		ThoroughfareTrailingType dest = new ThoroughfareTrailingType();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

}
