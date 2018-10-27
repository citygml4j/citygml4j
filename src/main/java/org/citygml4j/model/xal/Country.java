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

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

import java.util.List;

public class Country implements XAL, Child, Copyable {
	private List<AddressLine> addressLine;
	private List<CountryNameCode> countryNameCode;
	private List<CountryName> countryName;
	private AdministrativeArea administrativeArea;
	private Locality locality;
	private Thoroughfare thoroughfare;
	private ModelObject parent;

	public void addAddressLine(AddressLine addressLine) {
		if (this.addressLine == null)
			this.addressLine = new ChildList<AddressLine>(this);

		this.addressLine.add(addressLine);
	}

	public void addCountryName(CountryName countryName) {
		if (this.countryName == null)
			this.countryName = new ChildList<CountryName>(this);

		this.countryName.add(countryName);
	}

	public void addCountryNameCode(CountryNameCode countryNameCode) {
		if (this.countryNameCode == null)
			this.countryNameCode = new ChildList<CountryNameCode>(this);

		this.countryNameCode.add(countryNameCode);
	}

	public List<AddressLine> getAddressLine() {
		if (addressLine == null)
			addressLine = new ChildList<AddressLine>(this);

		return addressLine;
	}

	public AdministrativeArea getAdministrativeArea() {
		return administrativeArea;
	}

	public List<CountryName> getCountryName() {
		if (countryName == null)
			countryName = new ChildList<CountryName>(this);

		return countryName;
	}

	public List<CountryNameCode> getCountryNameCode() {
		if (countryNameCode == null)
			countryNameCode = new ChildList<CountryNameCode>(this);

		return countryNameCode;
	}

	public Locality getLocality() {
		return locality;
	}

	public Thoroughfare getThoroughfare() {
		return thoroughfare;
	}

	public boolean isSetAddressLine() {
		return addressLine != null && !addressLine.isEmpty();
	}

	public boolean isSetAdministrativeArea() {
		return administrativeArea != null;
	}

	public boolean isSetCountryName() {
		return countryName != null && !countryName.isEmpty();
	}

	public boolean isSetCountryNameCode() {
		return countryNameCode != null && !countryNameCode.isEmpty();
	}

	public boolean isSetLocality() {
		return locality != null;
	}

	public boolean isSetThoroughfare() {
		return thoroughfare != null;
	}

	public void setAddressLine(List<AddressLine> addressLine) {
		this.addressLine = new ChildList<AddressLine>(this, addressLine);
	}

	public void setAdministrativeArea(AdministrativeArea administrativeArea) {
		if (administrativeArea != null)
			administrativeArea.setParent(this);

		this.administrativeArea = administrativeArea;
	}

	public void setCountryName(List<CountryName> countryName) {
		this.countryName = new ChildList<CountryName>(this, countryName);
	}

	public void setCountryNameCode(List<CountryNameCode> countryNameCode) {
		this.countryNameCode = new ChildList<CountryNameCode>(this, countryNameCode);
	}

	public void setLocality(Locality locality) {
		if (locality != null)
			locality.setParent(this);

		this.locality = locality;
	}

	public void setThoroughfare(Thoroughfare thoroughfare) {
		if (thoroughfare != null)
			thoroughfare.setParent(this);

		this.thoroughfare = thoroughfare;
	}

	public void unsetAddressLine() {
		if (isSetAddressLine())
			addressLine.clear();

		addressLine = null;
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		return isSetAddressLine() ? this.addressLine.remove(addressLine) : false;
	}

	public void unsetAdministrativeArea() {
		if (isSetAdministrativeArea())
			administrativeArea.unsetParent();

		administrativeArea = null;
	}

	public void unsetCountryName() {
		if (isSetCountryName())
			countryName.clear();

		countryName = null;
	}

	public boolean unsetCountryName(CountryName countryName) {
		return isSetCountryName() ? this.countryName.remove(countryName) : false;
	}

	public void unsetCountryNameCode() {
		if (isSetCountryNameCode())
			countryNameCode.clear();
		
		countryNameCode = null;
	}

	public boolean unsetCountryNameCode(CountryNameCode countryNameCode) {
		return isSetCountryNameCode() ? this.countryNameCode.remove(countryNameCode) : false;
	}

	public void unsetLocality() {
		if (isSetLocality())
			locality.unsetParent();

		locality = null;
	}

	public void unsetThoroughfare() {
		if (isSetThoroughfare())
			thoroughfare.unsetParent();

		thoroughfare = null;
	}

	public XALClass getXALClass() {
		return XALClass.COUNTRY;
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
		return copyTo(new Country(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Country copy = (target == null) ? new Country() : (Country)target;

		if (isSetAddressLine()) {
			for (AddressLine part : addressLine) {
				AddressLine copyPart = (AddressLine)copyBuilder.copy(part);
				copy.addAddressLine(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetCountryName()) {
			for (CountryName part : countryName) {
				CountryName copyPart = (CountryName)copyBuilder.copy(part);
				copy.addCountryName(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetCountryNameCode()) {
			for (CountryNameCode part : countryNameCode) {
				CountryNameCode copyPart = (CountryNameCode)copyBuilder.copy(part);
				copy.addCountryNameCode(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
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
	
	public void accept(XALVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(XALFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
