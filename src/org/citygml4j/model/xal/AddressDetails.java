/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public class AddressDetails implements XAL, GrPostal, Associable, Child, Copyable {
	private PostalServiceElements postalServiceElements;
	private Address address;
	private AddressLines addressLines;
	private Country country;
	private AdministrativeArea administrativeArea;
	private Locality locality;
	private Thoroughfare thoroughfare;
	private String addressType;
	private String currentStatus;
	private String validFromDate;
	private String validToDate;
	private String usage;
	private String addressDetailsKey;
	private String code;
	private ModelObject parent;

	public Address getAddress() {
		return address;
	}

	public String getAddressDetailsKey() {
		return addressDetailsKey;
	}

	public AddressLines getAddressLines() {
		return addressLines;
	}

	public String getAddressType() {
		return addressType;
	}

	public AdministrativeArea getAdministrativeArea() {
		return administrativeArea;
	}

	public Country getCountry() {
		return country;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public Locality getLocality() {
		return locality;
	}

	public PostalServiceElements getPostalServiceElements() {
		return postalServiceElements;
	}

	public Thoroughfare getThoroughfare() {
		return thoroughfare;
	}

	public String getUsage() {
		return usage;
	}

	public String getValidFromDate() {
		return validFromDate;
	}

	public String getValidToDate() {
		return validToDate;
	}

	public boolean isSetAddress() {
		return address != null;
	}

	public boolean isSetAddressDetailsKey() {
		return addressDetailsKey != null;
	}

	public boolean isSetAddressLines() {
		return addressLines != null;
	}

	public boolean isSetAddressType() {
		return addressType != null;
	}

	public boolean isSetAdministrativeArea() {
		return administrativeArea != null;
	}

	public boolean isSetCountry() {
		return country != null;
	}

	public boolean isSetCurrentStatus() {
		return currentStatus != null;
	}

	public boolean isSetLocality() {
		return locality != null;
	}

	public boolean isSetPostalServiceElements() {
		return postalServiceElements != null;
	}

	public boolean isSetThoroughfare() {
		return thoroughfare != null;
	}

	public boolean isSetUsage() {
		return usage != null;
	}

	public boolean isSetValidFromDate() {
		return validFromDate != null;
	}

	public boolean isSetValidToDate() {
		return validToDate != null;
	}

	public void setAddress(Address address) {
		if (address != null)
			address.setParent(this);

		this.address = address;
	}

	public void setAddressDetailsKey(String addressDetailsKey) {
		this.addressDetailsKey = addressDetailsKey;
	}

	public void setAddressLines(AddressLines addressLines) {
		if (addressLines != null)
			addressLines.setParent(this);

		this.addressLines = addressLines;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public void setAdministrativeArea(AdministrativeArea administrativeArea) {
		if (administrativeArea != null)
			administrativeArea.setParent(this);

		this.administrativeArea = administrativeArea;
	}

	public void setCountry(Country country) {
		if (country != null)
			country.setParent(this);

		this.country = country;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public void setLocality(Locality locality) {
		if (locality != null)
			locality.setParent(this);

		this.locality = locality;
	}

	public void setPostalServiceElements(PostalServiceElements postalServiceElements) {
		if (postalServiceElements != null)
			postalServiceElements.setParent(this);

		this.postalServiceElements = postalServiceElements;
	}

	public void setThoroughfare(Thoroughfare thoroughfare) {
		if (thoroughfare != null)
			thoroughfare.setParent(this);

		this.thoroughfare = thoroughfare;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public void setValidFromDate(String validFromDate) {
		this.validFromDate = validFromDate;
	}

	public void setValidToDate(String validToDate) {
		this.validToDate = validToDate;
	}

	public void unsetAddress() {
		if (isSetAddress())
			address.unsetParent();

		address = null;
	}

	public void unsetAddressDetailsKey() {
		addressDetailsKey = null;
	}

	public void unsetAddressLines() {
		if (isSetAddressLines())
			addressLines.unsetParent();

		addressLines = null;
	}

	public void unsetAddressType() {
		addressType = null;
	}

	public void unsetAdministrativeArea() {
		if (isSetAdministrativeArea())
			administrativeArea.unsetParent();

		administrativeArea = null;
	}

	public void unsetCountry() {
		if (isSetCountry())
			country.unsetParent();

		country = null;
	}

	public void unsetCurrentStatus() {
		currentStatus = null;
	}

	public void unsetLocality() {
		if (isSetLocality())
			locality.unsetParent();

		locality = null;
	}

	public void unsetPostalServiceElements() {
		if (isSetPostalServiceElements())
			postalServiceElements.unsetParent();

		postalServiceElements = null;
	}

	public void unsetThoroughfare() {
		if (isSetThoroughfare())
			thoroughfare.unsetParent();

		thoroughfare = null;
	}

	public void unsetUsage() {
		usage = null;
	}

	public void unsetValidFromDate() {
		validFromDate = null;
	}

	public void unsetValidToDate() {
		validToDate = null;
	}

	public ModelType getModelType() {
		return ModelType.XAL;
	}

	public XALClass getXALClass() {
		return XALClass.ADDRESS_DETAILS;
	}

	public String getCode() {
		return code;
	}

	public boolean isSetCode() {
		return code != null;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void unsetCode() {
		code = null;
	}

	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new AddressDetails(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		AddressDetails copy = (target == null) ? new AddressDetails() : (AddressDetails)target;

		if (isSetAddressType())
			copy.setAddressType(copyBuilder.copy(addressType));

		if (isSetCurrentStatus())
			copy.setCurrentStatus(copyBuilder.copy(currentStatus));

		if (isSetValidFromDate())
			copy.setValidFromDate(copyBuilder.copy(validFromDate));

		if (isSetValidToDate())
			copy.setValidToDate(copyBuilder.copy(validToDate));

		if (isSetUsage())
			copy.setUsage(copyBuilder.copy(usage));

		if (isSetAddressDetailsKey())
			copy.setAddressDetailsKey(copyBuilder.copy(addressDetailsKey));

		if (isSetCode())
			copy.setCode(copyBuilder.copy(code));

		if (isSetPostalServiceElements()) {
			copy.setPostalServiceElements((PostalServiceElements)copyBuilder.copy(postalServiceElements));
			if (copy.getPostalServiceElements() == postalServiceElements)
				postalServiceElements.setParent(this);
		}

		if (isSetAddress()) {
			copy.setAddress((Address)copyBuilder.copy(address));
			if (copy.getAddress() == address)
				address.setParent(this);
		}

		if (isSetAddressLines()) {
			copy.setAddressLines((AddressLines)copyBuilder.copy(addressLines));
			if (copy.getAddressLines() == addressLines)
				addressLines.setParent(this);
		}

		if (isSetCountry()) {
			copy.setCountry((Country)copyBuilder.copy(country));
			if (copy.getCountry() == country)
				country.setParent(this);
		}

		if (isSetAdministrativeArea()) {
			copy.setAdministrativeArea((AdministrativeArea)copyBuilder.copy(administrativeArea));
			if (copy.getAdministrativeArea() == administrativeArea)
				administrativeArea.setParent(this);
		}

		if (isSetLocality()) {
			copy.setLocality((Locality)copyBuilder.copy(locality));
			if (copy.getLocality() == locality)
				locality.setParent(this);
		}

		if (isSetThoroughfare()) {
			copy.setThoroughfare((Thoroughfare)copyBuilder.copy(thoroughfare));
			if (copy.getThoroughfare() == thoroughfare)
				thoroughfare.setParent(this);
		}

		copy.unsetParent();

		return copy;
	}

	public void visit(XALVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T visit(XALFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
