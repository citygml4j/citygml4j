/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.builder.jaxb.marshal.xal;

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
import oasis.names.tc.ciq.xsdschema.xal._2.ObjectFactory;
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
import org.citygml4j.model.common.base.ModelObject;
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
import org.citygml4j.util.mapper.TypeMapper;

import javax.xml.bind.JAXBElement;
import java.util.concurrent.locks.ReentrantLock;

public class XALMarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final ObjectFactory xal= new ObjectFactory();
	private TypeMapper<Object> typeMapper;

	private TypeMapper<Object> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = TypeMapper.create()
							.with(Address.class, this::marshalAddress)
							.with(org.citygml4j.model.xal.AddressDetails.class, this::marshalAddressDetails)
							.with(AddressIdentifier.class, this::marshalAddressIdentifier)
							.with(AddressLatitude.class, this::marshalAddressLatitude)
							.with(AddressLatitudeDirection.class, this::marshalAddressLatitudeDirection)
							.with(AddressLine.class, this::marshalAddressLine)
							.with(AddressLines.class, this::marshalAddressLines)
							.with(AddressLongitude.class, this::marshalAddressLongitude)
							.with(AddressLongitudeDirection.class, this::marshalAddressLongitudeDirection)
							.with(AdministrativeArea.class, this::marshalAdministrativeArea)
							.with(AdministrativeAreaName.class, this::marshalAdministrativeAreaName)
							.with(Barcode.class, this::marshalBarcode)
							.with(BuildingName.class, this::marshalBuildingName)
							.with(Country.class, this::marshalCountry)
							.with(CountryName.class, this::marshalCountryName)
							.with(CountryNameCode.class, this::marshalCountryNameCode)
							.with(Department.class, this::marshalDepartment)
							.with(DepartmentName.class, this::marshalDepartmentName)
							.with(DependentLocality.class, this::marshalDependentLocality)
							.with(DependentLocalityName.class, this::marshalDependentLocalityName)
							.with(DependentLocalityNumber.class, this::marshalDependentLocalityNumber)
							.with(DependentThoroughfare.class, this::marshalDependentThoroughfare)
							.with(EndorsementLineCode.class, this::marshalEndorsementLineCode)
							.with(Firm.class, this::marshalFirm)
							.with(FirmName.class, this::marshalFirmName)
							.with(KeyLineCode.class, this::marshalKeyLineCode)
							.with(LargeMailUser.class, this::marshalLargeMailUser)
							.with(LargeMailUserIdentifier.class, this::marshalLargeMailUserIdentifier)
							.with(LargeMailUserName.class, this::marshalLargeMailUserName)
							.with(Locality.class, this::marshalLocality)
							.with(LocalityName.class, this::marshalLocalityName)
							.with(MailStop.class, this::marshalMailStop)
							.with(MailStopName.class, this::marshalMailStopName)
							.with(MailStopNumber.class, this::marshalMailStopNumber)
							.with(PostalCode.class, this::marshalPostalCode)
							.with(PostalCodeNumber.class, this::marshalPostalCodeNumber)
							.with(PostalCodeNumberExtension.class, this::marshalPostalCodeNumberExtension)
							.with(PostalRoute.class, this::marshalPostalRoute)
							.with(PostalRouteName.class, this::marshalPostalRouteName)
							.with(PostalRouteNumber.class, this::marshalPostalRouteNumber)
							.with(PostalServiceElements.class, this::marshalPostalServiceElements)
							.with(PostBox.class, this::marshalPostBox)
							.with(PostBoxNumber.class, this::marshalPostBoxNumber)
							.with(PostBoxNumberExtension.class, this::marshalPostBoxNumberExtension)
							.with(PostBoxNumberPrefix.class, this::marshalPostBoxNumberPrefix)
							.with(PostBoxNumberSuffix.class, this::marshalPostBoxNumberSuffix)
							.with(PostOffice.class, this::marshalPostOffice)
							.with(PostOfficeName.class, this::marshalPostOfficeName)
							.with(PostOfficeNumber.class, this::marshalPostOfficeNumber)
							.with(PostTown.class, this::marshalPostTown)
							.with(PostTownName.class, this::marshalPostTownName)
							.with(PostTownSuffix.class, this::marshalPostTownSuffix)
							.with(Premise.class, this::marshalPremise)
							.with(PremiseLocation.class, this::marshalPremiseLocation)
							.with(PremiseName.class, this::marshalPremiseName)
							.with(PremiseNumber.class, this::marshalPremiseNumber)
							.with(PremiseNumberPrefix.class, this::marshalPremiseNumberPrefix)
							.with(PremiseNumberRange.class, this::marshalPremiseNumberRange)
							.with(PremiseNumberRangeFrom.class, this::marshalPremiseNumberRangeFrom)
							.with(PremiseNumberRangeTo.class, this::marshalPremiseNumberRangeTo)
							.with(PremiseNumberSuffix.class, this::marshalPremiseNumberSuffix)
							.with(SortingCode.class, this::marshalSortingCode)
							.with(SubAdministrativeArea.class, this::marshalSubAdministrativeArea)
							.with(SubAdministrativeAreaName.class, this::marshalSubAdministrativeAreaName)
							.with(SubPremise.class, this::marshalSubPremise)
							.with(SubPremiseLocation.class, this::marshalSubPremiseLocation)
							.with(SubPremiseName.class, this::marshalSubPremiseName)
							.with(SubPremiseNumber.class, this::marshalSubPremiseNumber)
							.with(SubPremiseNumberPrefix.class, this::marshalSubPremiseNumberPrefix)
							.with(SubPremiseNumberSuffix.class, this::marshalSubPremiseNumberSuffix)
							.with(SupplementaryPostalServiceData.class, this::marshalSupplementaryPostalServiceData)
							.with(Thoroughfare.class, this::marshalThoroughfare)
							.with(ThoroughfareLeadingType.class, this::marshalThoroughfareLeadingType)
							.with(ThoroughfareName.class, this::marshalThoroughfareName)
							.with(ThoroughfareNumber.class, this::marshalThoroughfareNumber)
							.with(ThoroughfareNumberFrom.class, this::marshalThoroughfareNumberFrom)
							.with(ThoroughfareNumberPrefix.class, this::marshalThoroughfareNumberPrefix)
							.with(ThoroughfareNumberRange.class, this::marshalThoroughfareNumberRange)
							.with(ThoroughfareNumberSuffix.class, this::marshalThoroughfareNumberSuffix)
							.with(ThoroughfareNumberTo.class, this::marshalThoroughfareNumberTo)
							.with(ThoroughfarePostDirection.class, this::marshalThoroughfarePostDirection)
							.with(ThoroughfarePreDirection.class, this::marshalThoroughfarePreDirection)
							.with(ThoroughfareTrailingType.class, this::marshalThoroughfareTrailingType);
				}
			} finally {
				lock.unlock();
			}
		}

		return typeMapper;
	}

	public JAXBElement<?> marshalJAXBElement(ModelObject src) {
		Object dest = marshal(src);
		if (dest instanceof AddressDetails)
			return xal.createAddressDetails((AddressDetails)dest);

		return null;
	}

	public Object marshal(ModelObject src) {
		return getTypeMapper().apply(src);
	}	

	public AddressDetails.Address marshalAddress(Address src) {
		AddressDetails.Address dest = xal.createAddressDetailsAddress();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		return dest;
	}

	public AddressDetails marshalAddressDetails(org.citygml4j.model.xal.AddressDetails src) {
		AddressDetails dest = xal.createAddressDetails();

		if (src.isSetAddress())
			dest.setAddress(marshalAddress(src.getAddress()));

		if (src.isSetAddressDetailsKey())
			dest.setAddressDetailsKey(src.getAddressDetailsKey());

		if (src.isSetAddressLines())
			dest.setAddressLines(marshalAddressLines(src.getAddressLines()));

		if (src.isSetAddressType())
			dest.setAddressType(src.getAddressType());

		if (src.isSetAdministrativeArea())
			dest.setAdministrativeArea(marshalAdministrativeArea(src.getAdministrativeArea()));

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetCountry())
			dest.setCountry(marshalCountry(src.getCountry()));

		if (src.isSetCurrentStatus())
			dest.setCurrentStatus(src.getCurrentStatus());

		if (src.isSetLocality())
			dest.setLocality(marshalLocality(src.getLocality()));

		if (src.isSetPostalServiceElements())
			dest.setPostalServiceElements(marshalPostalServiceElements(src.getPostalServiceElements()));

		if (src.isSetThoroughfare())
			dest.setThoroughfare(marshalThoroughfare(src.getThoroughfare()));

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetValidFromDate())
			dest.setValidFromDate(src.getValidFromDate());

		if (src.isSetValidToDate())
			dest.setValidToDate(src.getValidToDate());		

		return dest;
	}

	public AddressDetails.PostalServiceElements.AddressIdentifier marshalAddressIdentifier(AddressIdentifier src) {
		AddressDetails.PostalServiceElements.AddressIdentifier dest = xal.createAddressDetailsPostalServiceElementsAddressIdentifier();

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

	public AddressDetails.PostalServiceElements.AddressLatitude marshalAddressLatitude(AddressLatitude src) {
		AddressDetails.PostalServiceElements.AddressLatitude dest = xal.createAddressDetailsPostalServiceElementsAddressLatitude();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public AddressDetails.PostalServiceElements.AddressLatitudeDirection marshalAddressLatitudeDirection(AddressLatitudeDirection src) {
		AddressDetails.PostalServiceElements.AddressLatitudeDirection dest = xal.createAddressDetailsPostalServiceElementsAddressLatitudeDirection();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public AddressLineElement marshalAddressLine(AddressLine src) {
		AddressLineElement dest = xal.createAddressLineElement();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public AddressLinesType marshalAddressLines(AddressLines src) {
		AddressLinesType dest = xal.createAddressLinesType();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		return dest;
	}

	public AddressDetails.PostalServiceElements.AddressLongitude marshalAddressLongitude(AddressLongitude src) {
		AddressDetails.PostalServiceElements.AddressLongitude dest = xal.createAddressDetailsPostalServiceElementsAddressLongitude();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public AddressDetails.PostalServiceElements.AddressLongitudeDirection marshalAddressLongitudeDirection(AddressLongitudeDirection src) {
		AddressDetails.PostalServiceElements.AddressLongitudeDirection dest = xal.createAddressDetailsPostalServiceElementsAddressLongitudeDirection();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public AdministrativeAreaElement marshalAdministrativeArea(AdministrativeArea src) {
		AdministrativeAreaElement dest = xal.createAdministrativeAreaElement();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetAdministrativeAreaName()) {
			for (AdministrativeAreaName administrativeAreaName : src.getAdministrativeAreaName())
				dest.getAdministrativeAreaName().add(marshalAdministrativeAreaName(administrativeAreaName));
		}

		if (src.isSetIndicator())
			dest.setIndicator(src.getIndicator());

		if (src.isSetLocality())
			dest.setLocality(marshalLocality(src.getLocality()));

		if (src.isSetPostalCode())
			dest.setPostalCode(marshalPostalCode(src.getPostalCode()));

		if (src.isSetPostOffice())
			dest.setPostOffice(marshalPostOffice(src.getPostOffice()));

		if (src.isSetSubAdministrativeArea())
			dest.setSubAdministrativeArea(marshalSubAdministrativeArea(src.getSubAdministrativeArea()));

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetUsageType())
			dest.setUsageType(src.getUsageType());

		return dest;
	}

	public AdministrativeAreaElement.AdministrativeAreaName marshalAdministrativeAreaName(AdministrativeAreaName src) {
		AdministrativeAreaElement.AdministrativeAreaName dest = xal.createAdministrativeAreaElementAdministrativeAreaName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public AddressDetails.PostalServiceElements.Barcode marshalBarcode(Barcode src) {
		AddressDetails.PostalServiceElements.Barcode dest = xal.createAddressDetailsPostalServiceElementsBarcode();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public BuildingNameType marshalBuildingName(BuildingName src) {
		BuildingNameType dest = xal.createBuildingNameType();

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

	public AddressDetails.Country marshalCountry(Country src) {
		AddressDetails.Country dest = xal.createAddressDetailsCountry();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetAdministrativeArea())
			dest.setAdministrativeArea(marshalAdministrativeArea(src.getAdministrativeArea()));

		if (src.isSetCountryName()) {
			for (CountryName countryName : src.getCountryName())
				dest.getCountryName().add(marshalCountryName(countryName));
		}

		if (src.isSetCountryNameCode()) {
			for (CountryNameCode countryNameCode : src.getCountryNameCode())
				dest.getCountryNameCode().add(marshalCountryNameCode(countryNameCode));
		}

		if (src.isSetLocality())
			dest.setLocality(marshalLocality(src.getLocality()));

		if (src.isSetThoroughfare())
			dest.setThoroughfare(marshalThoroughfare(src.getThoroughfare()));		

		return dest;
	}

	public CountryNameElement marshalCountryName(CountryName src) {
		CountryNameElement dest = xal.createCountryNameElement();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public AddressDetails.Country.CountryNameCode marshalCountryNameCode(CountryNameCode src) {
		AddressDetails.Country.CountryNameCode dest = xal.createAddressDetailsCountryCountryNameCode();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetScheme())
			dest.setScheme(src.getScheme());

		return dest;
	}

	public DepartmentElement marshalDepartment(Department src) {
		DepartmentElement dest = xal.createDepartmentElement();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetDepartmentName()) {
			for (DepartmentName departmentName : src.getDepartmentName())
				dest.getDepartmentName().add(marshalDepartmentName(departmentName));
		}

		if (src.isSetMailStop())
			dest.setMailStop(marshalMailStop(src.getMailStop()));

		if (src.isSetPostalCode())
			dest.setPostalCode(marshalPostalCode(src.getPostalCode()));

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public DepartmentElement.DepartmentName marshalDepartmentName(DepartmentName src) {
		DepartmentElement.DepartmentName dest = xal.createDepartmentElementDepartmentName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public DependentLocalityType marshalDependentLocality(DependentLocality src) {
		DependentLocalityType dest = xal.createDependentLocalityType();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetConnector())
			dest.setConnector(src.getConnector());

		if (src.isSetDependentLocality())
			dest.setDependentLocality(marshalDependentLocality(src.getDependentLocality()));

		if (src.isSetDependentLocalityName()) {
			for (DependentLocalityName dependentLocalityName : src.getDependentLocalityName())
				dest.getDependentLocalityName().add(marshalDependentLocalityName(dependentLocalityName));
		}

		if (src.isSetDependentLocalityNumber())
			dest.setDependentLocalityNumber(marshalDependentLocalityNumber(src.getDependentLocalityNumber()));

		if (src.isSetIndicator())
			dest.setIndicator(src.getIndicator());

		if (src.isSetLargeMailUser())
			dest.setLargeMailUser(marshalLargeMailUser(src.getLargeMailUser()));

		if (src.isSetPostalCode())
			dest.setPostalCode(marshalPostalCode(src.getPostalCode()));

		if (src.isSetPostalRoute())
			dest.setPostalRoute(marshalPostalRoute(src.getPostalRoute()));

		if (src.isSetPostBox())
			dest.setPostBox(marshalPostBox(src.getPostBox()));

		if (src.isSetPostOffice())
			dest.setPostOffice(marshalPostOffice(src.getPostOffice()));

		if (src.isSetPremise())
			dest.setPremise(marshalPremise(src.getPremise()));

		if (src.isSetThoroughfare())
			dest.setThoroughfare(marshalThoroughfare(src.getThoroughfare()));

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetUsageType())
			dest.setUsageType(src.getUsageType());

		return dest;
	}

	public DependentLocalityType.DependentLocalityName marshalDependentLocalityName(DependentLocalityName src) {
		DependentLocalityType.DependentLocalityName dest = xal.createDependentLocalityTypeDependentLocalityName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public DependentLocalityType.DependentLocalityNumber marshalDependentLocalityNumber(DependentLocalityNumber src) {
		DependentLocalityType.DependentLocalityNumber dest = xal.createDependentLocalityTypeDependentLocalityNumber();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetNameNumberOccurrence())
			dest.setNameNumberOccurrence(src.getNameNumberOccurrence());

		return dest;
	}

	public ThoroughfareElement.DependentThoroughfare marshalDependentThoroughfare(DependentThoroughfare src) {
		ThoroughfareElement.DependentThoroughfare dest = xal.createThoroughfareElementDependentThoroughfare();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetThoroughfareLeadingType())
			dest.setThoroughfareLeadingType(marshalThoroughfareLeadingType(src.getThoroughfareLeadingType()));

		if (src.isSetThoroughfareName()) {
			for (ThoroughfareName thoroughfareName : src.getThoroughfareName())
				dest.getThoroughfareName().add(marshalThoroughfareName(thoroughfareName));
		}

		if (src.isSetThoroughfarePostDirection())
			dest.setThoroughfarePostDirection(marshalThoroughfarePostDirection(src.getThoroughfarePostDirection()));

		if (src.isSetThoroughfarePreDirection())
			dest.setThoroughfarePreDirection(marshalThoroughfarePreDirection(src.getThoroughfarePreDirection()));

		if (src.isSetThoroughfareTrailingType())
			dest.setThoroughfareTrailingType(marshalThoroughfareTrailingType(src.getThoroughfareTrailingType()));

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public AddressDetails.PostalServiceElements.EndorsementLineCode marshalEndorsementLineCode(EndorsementLineCode src) {
		AddressDetails.PostalServiceElements.EndorsementLineCode dest = xal.createAddressDetailsPostalServiceElementsEndorsementLineCode();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public FirmType marshalFirm(Firm src) {
		FirmType dest = xal.createFirmType();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetDepartment()) {
			for (Department department : src.getDepartment())
				dest.getDepartment().add(marshalDepartment(department));
		}

		if (src.isSetFirmName()) {
			for (FirmName firmName : src.getFirmName())
				dest.getFirmName().add(marshalFirmName(firmName));
		}

		if (src.isSetMailStop())
			dest.setMailStop(marshalMailStop(src.getMailStop()));

		if (src.isSetPostalCode())
			dest.setPostalCode(marshalPostalCode(src.getPostalCode()));

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public FirmType.FirmName marshalFirmName(FirmName src) {
		FirmType.FirmName dest = xal.createFirmTypeFirmName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public AddressDetails.PostalServiceElements.KeyLineCode marshalKeyLineCode(KeyLineCode src) {
		AddressDetails.PostalServiceElements.KeyLineCode dest = xal.createAddressDetailsPostalServiceElementsKeyLineCode();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public LargeMailUserType marshalLargeMailUser(LargeMailUser src) {
		LargeMailUserType dest = xal.createLargeMailUserType();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetBuildingName()) {
			for (BuildingName buildingName : src.getBuildingName())
				dest.getBuildingName().add(marshalBuildingName(buildingName));
		}

		if (src.isSetDepartment())
			dest.setDepartment(marshalDepartment(src.getDepartment()));

		if (src.isSetLargeMailUserIdentifier())
			dest.setLargeMailUserIdentifier(marshalLargeMailUserIdentifier(src.getLargeMailUserIdentifier()));

		if (src.isSetLargeMailUserName()) {
			for (LargeMailUserName largeMailUserName : src.getLargeMailUserName())
				dest.getLargeMailUserName().add(marshalLargeMailUserName(largeMailUserName));
		}

		if (src.isSetPostalCode())
			dest.setPostalCode(marshalPostalCode(src.getPostalCode()));

		if (src.isSetPostBox())
			dest.setPostBox(marshalPostBox(src.getPostBox()));

		if (src.isSetThoroughfare())
			dest.setThoroughfare(marshalThoroughfare(src.getThoroughfare()));

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public LargeMailUserType.LargeMailUserIdentifier marshalLargeMailUserIdentifier(LargeMailUserIdentifier src) {
		LargeMailUserType.LargeMailUserIdentifier dest = xal.createLargeMailUserTypeLargeMailUserIdentifier();

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

	public LargeMailUserType.LargeMailUserName marshalLargeMailUserName(LargeMailUserName src) {
		LargeMailUserType.LargeMailUserName dest = xal.createLargeMailUserTypeLargeMailUserName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public LocalityElement marshalLocality(Locality src) {
		LocalityElement dest = xal.createLocalityElement();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetDependentLocality())
			dest.setDependentLocality(marshalDependentLocality(src.getDependentLocality()));

		if (src.isSetIndicator())
			dest.setIndicator(src.getIndicator());

		if (src.isSetLargeMailUser())
			dest.setLargeMailUser(marshalLargeMailUser(src.getLargeMailUser()));

		if (src.isSetLocalityName()) {
			for (LocalityName localityName : src.getLocalityName())
				dest.getLocalityName().add(marshalLocalityName(localityName));
		}

		if (src.isSetPostalCode())
			dest.setPostalCode(marshalPostalCode(src.getPostalCode()));

		if (src.isSetPostalRoute())
			dest.setPostalRoute(marshalPostalRoute(src.getPostalRoute()));

		if (src.isSetPostBox())
			dest.setPostBox(marshalPostBox(src.getPostBox()));

		if (src.isSetPostOffice())
			dest.setPostOffice(marshalPostOffice(src.getPostOffice()));

		if (src.isSetPremise())
			dest.setPremise(marshalPremise(src.getPremise()));

		if (src.isSetThoroughfare())
			dest.setThoroughfare(marshalThoroughfare(src.getThoroughfare()));

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetUsageType())
			dest.setUsageType(src.getUsageType());

		return dest;
	}

	public LocalityElement.LocalityName marshalLocalityName(LocalityName src) {
		LocalityElement.LocalityName dest = xal.createLocalityElementLocalityName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public MailStopType marshalMailStop(MailStop src) {
		MailStopType dest = xal.createMailStopType();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetMailStopName())
			dest.setMailStopName(marshalMailStopName(src.getMailStopName()));

		if (src.isSetMailStopNumber())
			dest.setMailStopNumber(marshalMailStopNumber(src.getMailStopNumber()));

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public MailStopType.MailStopName marshalMailStopName(MailStopName src) {
		MailStopType.MailStopName dest = xal.createMailStopTypeMailStopName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public MailStopType.MailStopNumber marshalMailStopNumber(MailStopNumber src) {
		MailStopType.MailStopNumber dest = xal.createMailStopTypeMailStopNumber();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetNameNumberSeparator())
			dest.setNameNumberSeparator(src.getNameNumberSeparator());

		return dest;
	}

	public PostalCodeElement marshalPostalCode(PostalCode src) {
		PostalCodeElement dest = xal.createPostalCodeElement();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetPostalCodeNumber()) {
			for (PostalCodeNumber postalCodeNumber : src.getPostalCodeNumber())
				dest.getPostalCodeNumber().add(marshalPostalCodeNumber(postalCodeNumber));
		}

		if (src.isSetPostalCodeNumberExtension()) {
			for (PostalCodeNumberExtension postalCodeNumberExtension : src.getPostalCodeNumberExtension())
				dest.getPostalCodeNumberExtension().add(marshalPostalCodeNumberExtension(postalCodeNumberExtension));
		}

		if (src.isSetPostTown())
			dest.setPostTown(marshalPostTown(src.getPostTown()));

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PostalCodeElement.PostalCodeNumber marshalPostalCodeNumber(PostalCodeNumber src) {
		PostalCodeElement.PostalCodeNumber dest = xal.createPostalCodeElementPostalCodeNumber();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PostalCodeElement.PostalCodeNumberExtension marshalPostalCodeNumberExtension(PostalCodeNumberExtension src) {
		PostalCodeElement.PostalCodeNumberExtension dest = xal.createPostalCodeElementPostalCodeNumberExtension();

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

	public PostalRouteType marshalPostalRoute(PostalRoute src) {
		PostalRouteType dest = xal.createPostalRouteType();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetPostalRouteName()) {
			for (PostalRouteName postalRouteName : src.getPostalRouteName())
				dest.getPostalRouteName().add(marshalPostalRouteName(postalRouteName));
		}

		if (src.isSetPostalRouteNumber())
			dest.setPostalRouteNumber(marshalPostalRouteNumber(src.getPostalRouteNumber()));

		if (src.isSetPostBox())
			dest.setPostBox(marshalPostBox(src.getPostBox()));

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PostalRouteType.PostalRouteName marshalPostalRouteName(PostalRouteName src) {
		PostalRouteType.PostalRouteName dest = xal.createPostalRouteTypePostalRouteName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PostalRouteType.PostalRouteNumber marshalPostalRouteNumber(PostalRouteNumber src) {
		PostalRouteType.PostalRouteNumber dest = xal.createPostalRouteTypePostalRouteNumber();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		return dest;
	}

	public AddressDetails.PostalServiceElements marshalPostalServiceElements(PostalServiceElements src) {
		AddressDetails.PostalServiceElements dest = xal.createAddressDetailsPostalServiceElements();

		if (src.isSetAddressIdentifier()) {
			for (AddressIdentifier addressIdentifier : src.getAddressIdentifier())
				dest.getAddressIdentifier().add(marshalAddressIdentifier(addressIdentifier));
		}

		if (src.isSetAddressLatitude())
			dest.setAddressLatitude(marshalAddressLatitude(src.getAddressLatitude()));

		if (src.isSetAddressLatitudeDirection())
			dest.setAddressLatitudeDirection(marshalAddressLatitudeDirection(src.getAddressLatitudeDirection()));

		if (src.isSetAddressLongitude())
			dest.setAddressLongitude(marshalAddressLongitude(src.getAddressLongitude()));

		if (src.isSetAddressLongitudeDirection())
			dest.setAddressLongitudeDirection(marshalAddressLongitudeDirection(src.getAddressLongitudeDirection()));

		if (src.isSetBarcode())
			dest.setBarcode(marshalBarcode(src.getBarcode()));

		if (src.isSetEndorsementLineCode())
			dest.setEndorsementLineCode(marshalEndorsementLineCode(src.getEndorsementLineCode()));

		if (src.isSetKeyLineCode())
			dest.setKeyLineCode(marshalKeyLineCode(src.getKeyLineCode()));

		if (src.isSetSortingCode())
			dest.setSortingCode(marshalSortingCode(src.getSortingCode()));

		if (src.isSetSupplementaryPostalServiceData()) {
			for (SupplementaryPostalServiceData supplementaryPostalServiceData : src.getSupplementaryPostalServiceData())
				dest.getSupplementaryPostalServiceData().add(marshalSupplementaryPostalServiceData(supplementaryPostalServiceData));
		}

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PostBoxElement marshalPostBox(PostBox src) {
		PostBoxElement dest = xal.createPostBoxElement();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetFirm())
			dest.setFirm(marshalFirm(src.getFirm()));

		if (src.isSetIndicator())
			dest.setIndicator(src.getIndicator());

		if (src.isSetPostalCode())
			dest.setPostalCode(marshalPostalCode(src.getPostalCode()));

		if (src.isSetPostBoxNumber())
			dest.setPostBoxNumber(marshalPostBoxNumber(src.getPostBoxNumber()));

		if (src.isSetPostBoxNumberExtension())
			dest.setPostBoxNumberExtension(marshalPostBoxNumberExtension(src.getPostBoxNumberExtension()));

		if (src.isSetPostBoxNumberPrefix())
			dest.setPostBoxNumberPrefix(marshalPostBoxNumberPrefix(src.getPostBoxNumberPrefix()));

		if (src.isSetPostBoxNumberSuffix())
			dest.setPostBoxNumberSuffix(marshalPostBoxNumberSuffix(src.getPostBoxNumberSuffix()));

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PostBoxElement.PostBoxNumber marshalPostBoxNumber(PostBoxNumber src) {
		PostBoxElement.PostBoxNumber dest = xal.createPostBoxElementPostBoxNumber();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		return dest;
	}

	public PostBoxElement.PostBoxNumberExtension marshalPostBoxNumberExtension(PostBoxNumberExtension src) {
		PostBoxElement.PostBoxNumberExtension dest = xal.createPostBoxElementPostBoxNumberExtension();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetNumberExtensionSeparator())
			dest.setNumberExtensionSeparator(src.getNumberExtensionSeparator());

		return dest;
	}

	public PostBoxElement.PostBoxNumberPrefix marshalPostBoxNumberPrefix(PostBoxNumberPrefix src) {
		PostBoxElement.PostBoxNumberPrefix dest = xal.createPostBoxElementPostBoxNumberPrefix();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetNumberPrefixSeparator())
			dest.setNumberPrefixSeparator(src.getNumberPrefixSeparator());

		return dest;
	}

	public PostBoxElement.PostBoxNumberSuffix marshalPostBoxNumberSuffix(PostBoxNumberSuffix src) {
		PostBoxElement.PostBoxNumberSuffix dest = xal.createPostBoxElementPostBoxNumberSuffix();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetNumberSuffixSeparator())
			dest.setNumberSuffixSeparator(src.getNumberSuffixSeparator());

		return dest;
	}

	public PostOfficeElement marshalPostOffice(PostOffice src) {
		PostOfficeElement dest = xal.createPostOfficeElement();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetIndicator())
			dest.setIndicator(src.getIndicator());

		if (src.isSetPostalCode())
			dest.setPostalCode(marshalPostalCode(src.getPostalCode()));

		if (src.isSetPostalRoute())
			dest.setPostalRoute(marshalPostalRoute(src.getPostalRoute()));

		if (src.isSetPostBox())
			dest.setPostBox(marshalPostBox(src.getPostBox()));

		if (src.isSetPostOfficeName()) {
			for (PostOfficeName postOfficeName : src.getPostOfficeName())
				dest.getPostOfficeName().add(marshalPostOfficeName(postOfficeName));
		}

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PostOfficeElement.PostOfficeName marshalPostOfficeName(PostOfficeName src) {
		PostOfficeElement.PostOfficeName dest = xal.createPostOfficeElementPostOfficeName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PostOfficeElement.PostOfficeNumber marshalPostOfficeNumber(PostOfficeNumber src) {
		PostOfficeElement.PostOfficeNumber dest = xal.createPostOfficeElementPostOfficeNumber();

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

	public PostalCodeElement.PostTown marshalPostTown(PostTown src) {
		PostalCodeElement.PostTown dest = xal.createPostalCodeElementPostTown();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetPostTownName()) {
			for (PostTownName postTownName : src.getPostTownName())
				dest.getPostTownName().add(marshalPostTownName(postTownName));
		}

		if (src.isSetPostTownSuffix())
			dest.setPostTownSuffix(marshalPostTownSuffix(src.getPostTownSuffix()));

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PostalCodeElement.PostTown.PostTownName marshalPostTownName(PostTownName src) {
		PostalCodeElement.PostTown.PostTownName dest = xal.createPostalCodeElementPostTownPostTownName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PostalCodeElement.PostTown.PostTownSuffix marshalPostTownSuffix(PostTownSuffix src) {
		PostalCodeElement.PostTown.PostTownSuffix dest = xal.createPostalCodeElementPostTownPostTownSuffix();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		return dest;
	}

	public PremiseElement marshalPremise(Premise src) {
		PremiseElement dest = xal.createPremiseElement();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetBuildingName()) {
			for (BuildingName buildingName : src.getBuildingName())
				dest.getBuildingName().add(marshalBuildingName(buildingName));
		}

		if (src.isSetFirm())
			dest.setFirm(marshalFirm(src.getFirm()));

		if (src.isSetMailStop())
			dest.setMailStop(marshalMailStop(src.getMailStop()));

		if (src.isSetPostalCode())
			dest.setPostalCode(marshalPostalCode(src.getPostalCode()));

		if (src.isSetPremise())
			dest.setPremise(marshalPremise(src.getPremise()));

		if (src.isSetPremiseDependency())
			dest.setPremiseDependency(src.getPremiseDependency());

		if (src.isSetPremiseDependencyType())
			dest.setPremiseDependencyType(src.getPremiseDependencyType());

		if (src.isSetPremiseLocation())
			dest.setPremiseLocation(marshalPremiseLocation(src.getPremiseLocation()));

		if (src.isSetPremiseName()) {
			for (PremiseName premiseName : src.getPremiseName())
				dest.getPremiseName().add(marshalPremiseName(premiseName));
		}

		if (src.isSetPremiseNumber()) {
			for (PremiseNumber premiseNumber : src.getPremiseNumber())
				dest.getPremiseNumber().add(marshalPremiseNumber(premiseNumber));
		}

		if (src.isSetPremiseNumberPrefix()) {
			for (PremiseNumberPrefix premiseNumberPrefix : src.getPremiseNumberPrefix())
				dest.getPremiseNumberPrefix().add(marshalPremiseNumberPrefix(premiseNumberPrefix));
		}

		if (src.isSetPremiseNumberSuffix()) {
			for (PremiseNumberSuffix premiseNumberSuffix : src.getPremiseNumberSuffix())
				dest.getPremiseNumberSuffix().add(marshalPremiseNumberSuffix(premiseNumberSuffix));
		}

		if (src.isSetPremiseNumberRange())
			dest.setPremiseNumberRange(marshalPremiseNumberRange(src.getPremiseNumberRange()));

		if (src.isSetPremiseThoroughfareConnector())
			dest.setPremiseThoroughfareConnector(src.getPremiseThoroughfareConnector());

		if (src.isSetSubPremise()) {
			for (SubPremise subPremise : src.getSubPremise())
				dest.getSubPremise().add(marshalSubPremise(subPremise));
		}

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public PremiseElement.PremiseLocation marshalPremiseLocation(PremiseLocation src) {
		PremiseElement.PremiseLocation dest = xal.createPremiseElementPremiseLocation();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		return dest;
	}

	public PremiseElement.PremiseName marshalPremiseName(PremiseName src) {
		PremiseElement.PremiseName dest = xal.createPremiseElementPremiseName();

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

	public PremiseNumberElement marshalPremiseNumber(PremiseNumber src) {
		PremiseNumberElement dest = xal.createPremiseNumberElement();

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

	public PremiseNumberPrefixElement marshalPremiseNumberPrefix(PremiseNumberPrefix src) {
		PremiseNumberPrefixElement dest = xal.createPremiseNumberPrefixElement();

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

	public PremiseElement.PremiseNumberRange marshalPremiseNumberRange(PremiseNumberRange src) {
		PremiseElement.PremiseNumberRange dest = xal.createPremiseElementPremiseNumberRange();

		if (src.isSetIndicator())
			dest.setIndicator(src.getIndicator());

		if (src.isSetIndicatorOccurence())
			dest.setIndicatorOccurence(src.getIndicatorOccurence());

		if (src.isSetNumberRangeOccurence())
			dest.setNumberRangeOccurence(src.getNumberRangeOccurence());

		if (src.isSetPremiseNumberRangeFrom())
			dest.setPremiseNumberRangeFrom(marshalPremiseNumberRangeFrom(src.getPremiseNumberRangeFrom()));

		if (src.isSetPremiseNumberRangeTo())
			dest.setPremiseNumberRangeTo(marshalPremiseNumberRangeTo(src.getPremiseNumberRangeTo()));

		if (src.isSetRangeType())
			dest.setRangeType(src.getRangeType());

		if (src.isSetSeparator())
			dest.setSeparator(src.getSeparator());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;		
	}

	public PremiseElement.PremiseNumberRange.PremiseNumberRangeFrom marshalPremiseNumberRangeFrom(PremiseNumberRangeFrom src) {
		PremiseElement.PremiseNumberRange.PremiseNumberRangeFrom dest = xal.createPremiseElementPremiseNumberRangePremiseNumberRangeFrom();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetPremiseNumber()) {
			for (PremiseNumber premiseNumber : src.getPremiseNumber())
				dest.getPremiseNumber().add(marshalPremiseNumber(premiseNumber));
		}

		if (src.isSetPremiseNumberPrefix()) {
			for (PremiseNumberPrefix premiseNumberPrefix : src.getPremiseNumberPrefix())
				dest.getPremiseNumberPrefix().add(marshalPremiseNumberPrefix(premiseNumberPrefix));
		}

		if (src.isSetPremiseNumberSuffix()) {
			for (PremiseNumberSuffix premiseNumberSuffix : src.getPremiseNumberSuffix())
				dest.getPremiseNumberSuffix().add(marshalPremiseNumberSuffix(premiseNumberSuffix));
		}

		return dest;
	}

	public PremiseElement.PremiseNumberRange.PremiseNumberRangeTo marshalPremiseNumberRangeTo(PremiseNumberRangeTo src) {
		PremiseElement.PremiseNumberRange.PremiseNumberRangeTo dest = xal.createPremiseElementPremiseNumberRangePremiseNumberRangeTo();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetPremiseNumber()) {
			for (PremiseNumber premiseNumber : src.getPremiseNumber())
				dest.getPremiseNumber().add(marshalPremiseNumber(premiseNumber));
		}

		if (src.isSetPremiseNumberPrefix()) {
			for (PremiseNumberPrefix premiseNumberPrefix : src.getPremiseNumberPrefix())
				dest.getPremiseNumberPrefix().add(marshalPremiseNumberPrefix(premiseNumberPrefix));
		}

		if (src.isSetPremiseNumberSuffix()) {
			for (PremiseNumberSuffix premiseNumberSuffix : src.getPremiseNumberSuffix())
				dest.getPremiseNumberSuffix().add(marshalPremiseNumberSuffix(premiseNumberSuffix));
		}

		return dest;
	}

	public PremiseNumberSuffixElement marshalPremiseNumberSuffix(PremiseNumberSuffix src) {
		PremiseNumberSuffixElement dest = xal.createPremiseNumberSuffixElement();

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

	public AddressDetails.PostalServiceElements.SortingCode marshalSortingCode(SortingCode src) {
		AddressDetails.PostalServiceElements.SortingCode dest = xal.createAddressDetailsPostalServiceElementsSortingCode();

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public AdministrativeAreaElement.SubAdministrativeArea marshalSubAdministrativeArea(SubAdministrativeArea src) {
		AdministrativeAreaElement.SubAdministrativeArea dest = xal.createAdministrativeAreaElementSubAdministrativeArea();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetIndicator())
			dest.setIndicator(src.getIndicator());

		if (src.isSetLocality())
			dest.setLocality(marshalLocality(src.getLocality()));

		if (src.isSetPostalCode())
			dest.setPostalCode(marshalPostalCode(src.getPostalCode()));

		if (src.isSetPostOffice())
			dest.setPostOffice(marshalPostOffice(src.getPostOffice()));

		if (src.isSetSubAdministrativeAreaName()) {
			for (SubAdministrativeAreaName subAdministrativeAreaName : src.getSubAdministrativeAreaName())
				dest.getSubAdministrativeAreaName().add(marshalSubAdministrativeAreaName(subAdministrativeAreaName));
		}

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetUsageType())
			dest.setUsageType(src.getUsageType());

		return dest;
	}

	public AdministrativeAreaElement.SubAdministrativeArea.SubAdministrativeAreaName marshalSubAdministrativeAreaName(SubAdministrativeAreaName src) {
		AdministrativeAreaElement.SubAdministrativeArea.SubAdministrativeAreaName dest = xal.createAdministrativeAreaElementSubAdministrativeAreaSubAdministrativeAreaName();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public SubPremiseType marshalSubPremise(SubPremise src) {
		SubPremiseType dest = xal.createSubPremiseType();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetBuildingName()) {
			for (BuildingName buildingName : src.getBuildingName())
				dest.getBuildingName().add(marshalBuildingName(buildingName));
		}

		if (src.isSetFirm())
			dest.setFirm(marshalFirm(src.getFirm()));

		if (src.isSetMailStop())
			dest.setMailStop(marshalMailStop(src.getMailStop()));

		if (src.isSetPostalCode())
			dest.setPostalCode(marshalPostalCode(src.getPostalCode()));

		if (src.isSetSubPremise())
			dest.setSubPremise(marshalSubPremise(src.getSubPremise()));

		if (src.isSetSubPremiseLocation())
			dest.setSubPremiseLocation(marshalSubPremiseLocation(src.getSubPremiseLocation()));

		if (src.isSetSubPremiseName()) {
			for (SubPremiseName subPremiseName : src.getSubPremiseName())
				dest.getSubPremiseName().add(marshalSubPremiseName(subPremiseName));
		}

		if (src.isSetSubPremiseNumber()) {
			for (SubPremiseNumber subPremiseNumber : src.getSubPremiseNumber())
				dest.getSubPremiseNumber().add(marshalSubPremiseNumber(subPremiseNumber));
		}

		if (src.isSetSubPremiseNumberPrefix()) {
			for (SubPremiseNumberPrefix subPremiseNumberPrefix : src.getSubPremiseNumberPrefix())
				dest.getSubPremiseNumberPrefix().add(marshalSubPremiseNumberPrefix(subPremiseNumberPrefix));
		}

		if (src.isSetSubPremiseNumberSuffix()) {
			for (SubPremiseNumberSuffix subPremiseNumberSuffix : src.getSubPremiseNumberSuffix())
				dest.getSubPremiseNumberSuffix().add(marshalSubPremiseNumberSuffix(subPremiseNumberSuffix));
		}

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}	

	public SubPremiseType.SubPremiseLocation marshalSubPremiseLocation(SubPremiseLocation src) {
		SubPremiseType.SubPremiseLocation dest = xal.createSubPremiseTypeSubPremiseLocation();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		return dest;
	}

	public SubPremiseType.SubPremiseName marshalSubPremiseName(SubPremiseName src) {
		SubPremiseType.SubPremiseName dest = xal.createSubPremiseTypeSubPremiseName();

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

	public SubPremiseType.SubPremiseNumber marshalSubPremiseNumber(SubPremiseNumber src) {
		SubPremiseType.SubPremiseNumber dest = xal.createSubPremiseTypeSubPremiseNumber();

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

	public SubPremiseType.SubPremiseNumberPrefix marshalSubPremiseNumberPrefix(SubPremiseNumberPrefix src) {
		SubPremiseType.SubPremiseNumberPrefix dest = xal.createSubPremiseTypeSubPremiseNumberPrefix();

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

	public SubPremiseType.SubPremiseNumberSuffix marshalSubPremiseNumberSuffix(SubPremiseNumberSuffix src) {
		SubPremiseType.SubPremiseNumberSuffix dest = xal.createSubPremiseTypeSubPremiseNumberSuffix();

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

	public AddressDetails.PostalServiceElements.SupplementaryPostalServiceData marshalSupplementaryPostalServiceData(SupplementaryPostalServiceData src) {
		AddressDetails.PostalServiceElements.SupplementaryPostalServiceData dest = xal.createAddressDetailsPostalServiceElementsSupplementaryPostalServiceData();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public ThoroughfareElement marshalThoroughfare(Thoroughfare src) {
		ThoroughfareElement dest = xal.createThoroughfareElement();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetDependentLocality())
			dest.setDependentLocality(marshalDependentLocality(src.getDependentLocality()));

		if (src.isSetDependentThoroughfare())
			dest.setDependentThoroughfare(marshalDependentThoroughfare(src.getDependentThoroughfare()));

		if (src.isSetDependentThoroughfares())
			dest.setDependentThoroughfares(src.getDependentThoroughfares());

		if (src.isSetDependentThoroughfaresConnector())
			dest.setDependentThoroughfaresConnector(src.getDependentThoroughfaresConnector());

		if (src.isSetDependentThoroughfaresIndicator())
			dest.setDependentThoroughfaresIndicator(src.getDependentThoroughfaresIndicator());

		if (src.isSetDependentThoroughfaresType())
			dest.setDependentThoroughfaresType(src.getDependentThoroughfaresType());

		if (src.isSetFirm())
			dest.setFirm(marshalFirm(src.getFirm()));

		if (src.isSetPostalCode())
			dest.setPostalCode(marshalPostalCode(src.getPostalCode()));

		if (src.isSetPremise())
			dest.setPremise(marshalPremise(src.getPremise()));

		if (src.isSetThoroughfareLeadingType())
			dest.setThoroughfareLeadingType(marshalThoroughfareLeadingType(src.getThoroughfareLeadingType()));

		if (src.isSetThoroughfareName()) {
			for (ThoroughfareName thoroughfareName : src.getThoroughfareName())
				dest.getThoroughfareName().add(marshalThoroughfareName(thoroughfareName));
		}

		if (src.isSetThoroughfareNumberOrThoroughfareNumberRange()) {
			for (ThoroughfareNumberOrRange content : src.getThoroughfareNumberOrThoroughfareNumberRange()) {
				if (content.isSetThoroughfareNumber())
					dest.getThoroughfareNumberOrThoroughfareNumberRange().add(marshalThoroughfareNumber(content.getThoroughfareNumber()));
				else if (content.isSetThoroughfareNumberRange())
					dest.getThoroughfareNumberOrThoroughfareNumberRange().add(marshalThoroughfareNumberRange(content.getThoroughfareNumberRange()));
			}
		}

		if (src.isSetThoroughfareNumberPrefix()) {
			for (ThoroughfareNumberPrefix thoroughfareNumberPrefix : src.getThoroughfareNumberPrefix())
				dest.getThoroughfareNumberPrefix().add(marshalThoroughfareNumberPrefix(thoroughfareNumberPrefix));
		}

		if (src.isSetThoroughfareNumberSuffix()) {
			for (ThoroughfareNumberSuffix thoroughfareNumberSuffix : src.getThoroughfareNumberSuffix())
				dest.getThoroughfareNumberSuffix().add(marshalThoroughfareNumberSuffix(thoroughfareNumberSuffix));
		}

		if (src.isSetThoroughfarePostDirection())
			dest.setThoroughfarePostDirection(marshalThoroughfarePostDirection(src.getThoroughfarePostDirection()));

		if (src.isSetThoroughfarePreDirection())
			dest.setThoroughfarePreDirection(marshalThoroughfarePreDirection(src.getThoroughfarePreDirection()));

		if (src.isSetThoroughfareTrailingType())
			dest.setThoroughfareTrailingType(marshalThoroughfareTrailingType(src.getThoroughfareTrailingType()));

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public ThoroughfareLeadingTypeType marshalThoroughfareLeadingType(ThoroughfareLeadingType src) {
		ThoroughfareLeadingTypeType dest = xal.createThoroughfareLeadingTypeType();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public ThoroughfareNameType marshalThoroughfareName(ThoroughfareName src) {
		ThoroughfareNameType dest = xal.createThoroughfareNameType();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public ThoroughfareNumberElement marshalThoroughfareNumber(ThoroughfareNumber src) {
		ThoroughfareNumberElement dest = xal.createThoroughfareNumberElement();

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

	public ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberFrom marshalThoroughfareNumberFrom(ThoroughfareNumberFrom src) {
		ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberFrom dest = xal.createThoroughfareElementThoroughfareNumberRangeThoroughfareNumberFrom();

		if (src.isSetContent()) {
			for (ThoroughfareNumberFromContent content : src.getContent()) {
				if (content.isSetAddressLine())
					dest.getContent().add(marshalAddressLine(content.getAddressLine()));
				else if (content.isSetThoroughfareNumber())
					dest.getContent().add(marshalThoroughfareNumber(content.getThoroughfareNumber()));
				else if (content.isSetThoroughfareNumberPrefix())
					dest.getContent().add(marshalThoroughfareNumberPrefix(content.getThoroughfareNumberPrefix()));
				else if (content.isSetThoroughfareNumberSuffix())
					dest.getContent().add(marshalThoroughfareNumberSuffix(content.getThoroughfareNumberSuffix()));
				else if (content.isSetString())
					dest.getContent().add(content.getString());
			}
		}

		if (src.isSetCode())
			dest.setCode(src.getCode());

		return dest;
	}

	public ThoroughfareNumberPrefixElement marshalThoroughfareNumberPrefix(ThoroughfareNumberPrefix src) {
		ThoroughfareNumberPrefixElement dest = xal.createThoroughfareNumberPrefixElement();

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

	public ThoroughfareElement.ThoroughfareNumberRange marshalThoroughfareNumberRange(ThoroughfareNumberRange src) {
		ThoroughfareElement.ThoroughfareNumberRange dest = xal.createThoroughfareElementThoroughfareNumberRange();

		if (src.isSetAddressLine()) {
			for (AddressLine addressLine : src.getAddressLine())
				dest.getAddressLine().add(marshalAddressLine(addressLine));
		}

		if (src.isSetThoroughfareNumberFrom())
			dest.setThoroughfareNumberFrom(marshalThoroughfareNumberFrom(src.getThoroughfareNumberFrom()));

		if (src.isSetThoroughfareNumberTo())
			dest.setThoroughfareNumberTo(marshalThoroughfareNumberTo(src.getThoroughfareNumberTo()));

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

	public ThoroughfareNumberSuffixElement marshalThoroughfareNumberSuffix(ThoroughfareNumberSuffix src) {
		ThoroughfareNumberSuffixElement dest = xal.createThoroughfareNumberSuffixElement();

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

	public ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberTo marshalThoroughfareNumberTo(ThoroughfareNumberTo src) {
		ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberTo dest = xal.createThoroughfareElementThoroughfareNumberRangeThoroughfareNumberTo();

		if (src.isSetContent()) {
			for (ThoroughfareNumberToContent content : src.getContent()) {
				if (content.isSetAddressLine())
					dest.getContent().add(marshalAddressLine(content.getAddressLine()));
				else if (content.isSetThoroughfareNumber())
					dest.getContent().add(marshalThoroughfareNumber(content.getThoroughfareNumber()));
				else if (content.isSetThoroughfareNumberPrefix())
					dest.getContent().add(marshalThoroughfareNumberPrefix(content.getThoroughfareNumberPrefix()));
				else if (content.isSetThoroughfareNumberSuffix())
					dest.getContent().add(marshalThoroughfareNumberSuffix(content.getThoroughfareNumberSuffix()));
				else if (content.isSetString())
					dest.getContent().add(content.getString());
			}
		}

		if (src.isSetCode())
			dest.setCode(src.getCode());

		return dest;
	}

	public ThoroughfarePostDirectionType marshalThoroughfarePostDirection(ThoroughfarePostDirection src) {
		ThoroughfarePostDirectionType dest = xal.createThoroughfarePostDirectionType();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public ThoroughfarePreDirectionType marshalThoroughfarePreDirection(ThoroughfarePreDirection src) {
		ThoroughfarePreDirectionType dest = xal.createThoroughfarePreDirectionType();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

	public ThoroughfareTrailingTypeType marshalThoroughfareTrailingType(ThoroughfareTrailingType src) {
		ThoroughfareTrailingTypeType dest = xal.createThoroughfareTrailingTypeType();

		if (src.isSetContent())
			dest.setContent(src.getContent());

		if (src.isSetCode())
			dest.setCode(src.getCode());

		if (src.isSetType())
			dest.setType(src.getType());

		return dest;
	}

}
