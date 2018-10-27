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
package org.citygml4j.model.xal;

import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelClassEnum;
import org.citygml4j.model.gml.GMLClass;

public enum XALClass implements ModelClassEnum {
	UNDEFINED(null),

	ADDRESS(Address.class),
	ADDRESS_DETAILS(AddressDetails.class),
	ADDRESS_LATITUDE(AddressLatitude.class),
	ADDRESS_LATITUDE_DIRECTION(AddressLatitudeDirection.class),
	ADDRESS_LINE(AddressLine.class),
	ADDRESS_LINES(AddressLines.class),
	ADDRESS_LONGITUDE(AddressLongitude.class),
	ADDRESS_LONGITUDE_DIRECTION(AddressLongitudeDirection.class),
	ADDRESS_IDENTIFIER(AddressIdentifier.class),
	ADMINISTRATIVE_AREA(AdministrativeArea.class),
	ADMINISTRATIVE_AREA_NAME(AdministrativeAreaName.class),
	BARCODE(Barcode.class),
	BUILDING_NAME(BuildingName.class),
	COUNTRY(Country.class),
	COUNTRY_NAME(CountryName.class),
	COUNTRY_NAME_CODE(CountryNameCode.class),
	DEPARTMENT(Department.class),
	DEPARTMENT_NAME(DepartmentName.class),
	DEPENDENT_LOCALITY(DependentLocality.class),
	DEPENDENT_LOCALITY_NAME(DependentLocalityName.class),
	DEPENDENT_LOCALITY_NUMBER(DependentLocalityNumber.class),
	DEPENDENT_THOROUGHFARE(DependentThoroughfare.class),
	ENDORSEMENT_LINE_CODE(EndorsementLineCode.class),
	FIRM(Firm.class),
	FIRM_NAME(FirmName.class),
	LARGE_MAIL_USER(LargeMailUser.class),
	LARGE_MAIL_USER_NAME(LargeMailUserName.class),
	LARGE_MAIL_USER_IDENTIFIER(LargeMailUserIdentifier.class),
	LOCALITY(Locality.class),
	LOCALITY_NAME(LocalityName.class),
	KEY_LINE_CODE(KeyLineCode.class),
	MAIL_STOP(MailStop.class),
	MAIL_STOP_NAME(MailStopName.class),
	MAIL_STOP_NUMBER(MailStopNumber.class),
	POSTAL_CODE(PostalCode.class),
	POSTAL_CODE_NUMBER(PostalCodeNumber.class),
	POSTAL_CODE_NUMBER_EXTENSION(PostalCodeNumberExtension.class),
	POSTAL_SERVICE_ELEMENTS(PostalServiceElements.class),
	POSTAL_ROUTE(PostalRoute.class),
	POSTAL_ROUTE_NAME(PostalRouteName.class),
	POSTAL_ROUTE_NUMBER(PostalRouteNumber.class),
	POST_BOX(PostBox.class),
	POST_BOX_NUMBER(PostBoxNumber.class),
	POST_BOX_NUMBER_EXTENSION(PostBoxNumberExtension.class),
	POST_BOX_NUMBER_PREFIX(PostBoxNumberPrefix.class),
	POST_BOX_NUMBER_SUFFIX(PostBoxNumberSuffix.class),
	POST_OFFICE(PostOffice.class),
	POST_OFFICE_NAME(PostOfficeName.class),
	POST_OFFICE_NUMBER(PostOfficeNumber.class),
	POST_TOWN(PostTown.class),
	POST_TOWN_NAME(PostTownName.class),
	POST_TOWN_SUFFIX(PostTownSuffix.class),
	PREMISE(Premise.class),
	PREMISE_LOCATION(PremiseLocation.class),
	PREMISE_NAME(PremiseName.class),
	PREMISE_NUMBER(PremiseNumber.class),
	PREMISE_NUMBER_PREFIX(PremiseNumberPrefix.class),
	PREMISE_NUMBER_RANGE(PremiseNumberRange.class),
	PREMISE_NUMBER_RANGE_FROM(PremiseNumberRangeFrom.class),
	PREMISE_NUMBER_RANGE_TO(PremiseNumberRangeTo.class),
	PREMISE_NUMBER_SUFFIX(PremiseNumberSuffix.class),
	SORTING_CODE(SortingCode.class),
	SUB_ADMINISTRATIVE_AREA(SubAdministrativeArea.class),
	SUB_ADMINISTRATIVE_AREA_NAME(SubAdministrativeAreaName.class),
	SUB_PREMISE(SubPremise.class),
	SUB_PREMISE_LOCATION(SubPremiseLocation.class),
	SUB_PREMISE_NAME(SubPremiseName.class),
	SUB_PREMISE_NUMBER(SubPremiseNumber.class),
	SUB_PREMISE_NUMBER_PREFIX(SubPremiseNumberPrefix.class),
	SUB_PREMISE_NUMBER_SUFFIX(SubPremiseNumberSuffix.class),
	SUPPLEMENTARY_POSTAL_SERVICE_DATA(SupplementaryPostalServiceData.class),
	THOROUGHFARE(Thoroughfare.class),
	THOROUGHFARE_LEADING_TYPE(ThoroughfareLeadingType.class),
	THOROUGHFARE_NAME(ThoroughfareName.class),
	THOROUGHFARE_NUMBER(ThoroughfareNumber.class),
	THOROUGHFARE_NUMBER_FROM(ThoroughfareNumberFrom.class),
	THOROUGHFARE_NUMBER_FROM_CONTENT(ThoroughfareNumberFromContent.class),
	THOROUGHFARE_NUMBER_RANGE(ThoroughfareNumberRange.class),
	THOROUGHFARE_NUMBER_OR_RANGE(ThoroughfareNumberOrRange.class),
	THOROUGHFARE_NUMBER_PREFIX(ThoroughfareNumberPrefix.class),
	THOROUGHFARE_NUMBER_SUFFIX(ThoroughfareNumberSuffix.class),
	THOROUGHFARE_NUMBER_TO(ThoroughfareNumberTo.class),
	THOROUGHFARE_NUMBER_TO_CONTENT(ThoroughfareNumberToContent.class),
	THOROUGHFARE_PRE_DIRECTION(ThoroughfarePreDirection.class),
	THOROUGHFARE_POST_DIRECTION(ThoroughfarePostDirection.class),
	THOROUGHFARE_TRAILING_TYPE(ThoroughfareTrailingType.class);
	
	private final Class<? extends XAL> modelClass;

	private XALClass(Class<? extends XAL> modelClass) {
		this.modelClass = modelClass;
	}

	public Class<? extends XAL> getModelClass() {
		return modelClass;
	}
	
	public static XALClass fromModelClass(Class<? extends XAL> modelClass) {
		for (XALClass c : XALClass.values())
			if (c.modelClass == modelClass)
				return c;

		return UNDEFINED;
	}
	
	public static XALClass fromInt(int i) {
		for (XALClass c : XALClass.values()) {
			if (c.ordinal() == i)
				return c;
		}

		return UNDEFINED;
	}
	
	public boolean isInstance(ModelClassEnum type) {
		if (type == null)
			return false;
		
		Class<?> tmp = modelClass;
		Class<?> otherModelClass = null;

		if (type instanceof CityGMLClass)
			otherModelClass = ((CityGMLClass)type).getModelClass();
		else if (type instanceof GMLClass)
			otherModelClass = ((GMLClass)type).getModelClass();
		else if (type instanceof XALClass)
			otherModelClass = ((XALClass)type).getModelClass();

		if (otherModelClass != null) {
			do {
				if (tmp == otherModelClass)
					return true;
			} while ((tmp = tmp.getSuperclass()) != null);
		}
		
		return false;
	}
	
}
