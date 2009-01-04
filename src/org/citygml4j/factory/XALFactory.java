package org.citygml4j.factory;

import org.citygml4j.impl.jaxb.xal._2.AddressDetailsImpl;
import org.citygml4j.impl.jaxb.xal._2.AddressIdentifierImpl;
import org.citygml4j.impl.jaxb.xal._2.AddressImpl;
import org.citygml4j.impl.jaxb.xal._2.AddressLatitudeDirectionImpl;
import org.citygml4j.impl.jaxb.xal._2.AddressLatitudeImpl;
import org.citygml4j.impl.jaxb.xal._2.AddressLineImpl;
import org.citygml4j.impl.jaxb.xal._2.AddressLinesImpl;
import org.citygml4j.impl.jaxb.xal._2.AddressLongitudeDirectionImpl;
import org.citygml4j.impl.jaxb.xal._2.AddressLongitudeImpl;
import org.citygml4j.impl.jaxb.xal._2.AdministrativeAreaImpl;
import org.citygml4j.impl.jaxb.xal._2.AdministrativeAreaNameImpl;
import org.citygml4j.impl.jaxb.xal._2.BarcodeImpl;
import org.citygml4j.impl.jaxb.xal._2.BuildingNameImpl;
import org.citygml4j.impl.jaxb.xal._2.CountryImpl;
import org.citygml4j.impl.jaxb.xal._2.CountryNameCodeImpl;
import org.citygml4j.impl.jaxb.xal._2.CountryNameImpl;
import org.citygml4j.impl.jaxb.xal._2.DepartmentImpl;
import org.citygml4j.impl.jaxb.xal._2.DepartmentNameImpl;
import org.citygml4j.impl.jaxb.xal._2.DependentLocalityImpl;
import org.citygml4j.impl.jaxb.xal._2.DependentLocalityNameImpl;
import org.citygml4j.impl.jaxb.xal._2.DependentLocalityNumberImpl;
import org.citygml4j.impl.jaxb.xal._2.DependentThoroughfareImpl;
import org.citygml4j.impl.jaxb.xal._2.EndorsementLineCodeImpl;
import org.citygml4j.impl.jaxb.xal._2.FirmImpl;
import org.citygml4j.impl.jaxb.xal._2.FirmNameImpl;
import org.citygml4j.impl.jaxb.xal._2.KeyLineCodeImpl;
import org.citygml4j.impl.jaxb.xal._2.LargeMailUserIdentifierImpl;
import org.citygml4j.impl.jaxb.xal._2.LargeMailUserImpl;
import org.citygml4j.impl.jaxb.xal._2.LocalityImpl;
import org.citygml4j.impl.jaxb.xal._2.LocalityNameImpl;
import org.citygml4j.impl.jaxb.xal._2.MailStopImpl;
import org.citygml4j.impl.jaxb.xal._2.MailStopNameImpl;
import org.citygml4j.impl.jaxb.xal._2.MailStopNumberImpl;
import org.citygml4j.impl.jaxb.xal._2.PostBoxImpl;
import org.citygml4j.impl.jaxb.xal._2.PostBoxNumberExtensionImpl;
import org.citygml4j.impl.jaxb.xal._2.PostBoxNumberImpl;
import org.citygml4j.impl.jaxb.xal._2.PostBoxNumberPrefixImpl;
import org.citygml4j.impl.jaxb.xal._2.PostBoxNumberSuffixImpl;
import org.citygml4j.impl.jaxb.xal._2.PostOfficeImpl;
import org.citygml4j.impl.jaxb.xal._2.PostOfficeNameImpl;
import org.citygml4j.impl.jaxb.xal._2.PostOfficeNumberImpl;
import org.citygml4j.impl.jaxb.xal._2.PostTownImpl;
import org.citygml4j.impl.jaxb.xal._2.PostTownNameImpl;
import org.citygml4j.impl.jaxb.xal._2.PostTownSuffixImpl;
import org.citygml4j.impl.jaxb.xal._2.PostalCodeImpl;
import org.citygml4j.impl.jaxb.xal._2.PostalCodeNumberExtensionImpl;
import org.citygml4j.impl.jaxb.xal._2.PostalCodeNumberImpl;
import org.citygml4j.impl.jaxb.xal._2.PostalRouteImpl;
import org.citygml4j.impl.jaxb.xal._2.PostalRouteNameImpl;
import org.citygml4j.impl.jaxb.xal._2.PostalRouteNumberImpl;
import org.citygml4j.impl.jaxb.xal._2.PostalServiceElementsImpl;
import org.citygml4j.impl.jaxb.xal._2.PremiseImpl;
import org.citygml4j.impl.jaxb.xal._2.PremiseLocationImpl;
import org.citygml4j.impl.jaxb.xal._2.PremiseNameImpl;
import org.citygml4j.impl.jaxb.xal._2.PremiseNumberImpl;
import org.citygml4j.impl.jaxb.xal._2.PremiseNumberPrefixImpl;
import org.citygml4j.impl.jaxb.xal._2.PremiseNumberRangeFromImpl;
import org.citygml4j.impl.jaxb.xal._2.PremiseNumberRangeImpl;
import org.citygml4j.impl.jaxb.xal._2.PremiseNumberRangeToImpl;
import org.citygml4j.impl.jaxb.xal._2.PremiseNumberSuffixImpl;
import org.citygml4j.impl.jaxb.xal._2.SortingCodeImpl;
import org.citygml4j.impl.jaxb.xal._2.SubAdministrativeAreaImpl;
import org.citygml4j.impl.jaxb.xal._2.SubAdministrativeAreaNameImpl;
import org.citygml4j.impl.jaxb.xal._2.SubPremiseImpl;
import org.citygml4j.impl.jaxb.xal._2.SubPremiseLocationImpl;
import org.citygml4j.impl.jaxb.xal._2.SubPremiseNameImpl;
import org.citygml4j.impl.jaxb.xal._2.SubPremiseNumberImpl;
import org.citygml4j.impl.jaxb.xal._2.SubPremiseNumberPrefixImpl;
import org.citygml4j.impl.jaxb.xal._2.SubPremiseNumberSuffixImpl;
import org.citygml4j.impl.jaxb.xal._2.SupplementaryPostalServiceDataImpl;
import org.citygml4j.impl.jaxb.xal._2.ThoroughfareImpl;
import org.citygml4j.impl.jaxb.xal._2.ThoroughfareLeadingTypeImpl;
import org.citygml4j.impl.jaxb.xal._2.ThoroughfareNameImpl;
import org.citygml4j.impl.jaxb.xal._2.ThoroughfareNumberFromImpl;
import org.citygml4j.impl.jaxb.xal._2.ThoroughfareNumberImpl;
import org.citygml4j.impl.jaxb.xal._2.ThoroughfareNumberPrefixImpl;
import org.citygml4j.impl.jaxb.xal._2.ThoroughfareNumberRangeImpl;
import org.citygml4j.impl.jaxb.xal._2.ThoroughfareNumberSuffixImpl;
import org.citygml4j.impl.jaxb.xal._2.ThoroughfareNumberToImpl;
import org.citygml4j.impl.jaxb.xal._2.ThoroughfarePostDirectionImpl;
import org.citygml4j.impl.jaxb.xal._2.ThoroughfarePreDirectionImpl;
import org.citygml4j.impl.jaxb.xal._2.ThoroughfareTrailingTypeImpl;
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
	
	public ThoroughfareNumber createThoroughfareNumber() {
		return new ThoroughfareNumberImpl();
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

