/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.xal;

import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public interface AddressDetails extends XAL, GrPostal, Associable, Child, Copyable {
	public PostalServiceElements getPostalServiceElements();
	public Address getAddress();
	public AddressLines getAddressLines();	
	public Country getCountry();
	public AdministrativeArea getAdministrativeArea();
	public Locality getLocality();
	public Thoroughfare getThoroughfare();
	public String getAddressType();
	public String getCurrentStatus();
	public String getValidFromDate();
	public String getValidToDate();
	public String getUsage();
	public String getAddressDetailsKey();
	public boolean isSetPostalServiceElements();
	public boolean isSetAddress();
	public boolean isSetAddressLines();	
	public boolean isSetCountry();
	public boolean isSetAdministrativeArea();
	public boolean isSetLocality();
	public boolean isSetThoroughfare();
	public boolean isSetAddressType();
	public boolean isSetCurrentStatus();
	public boolean isSetValidFromDate();
	public boolean isSetValidToDate();
	public boolean isSetUsage();
	public boolean isSetAddressDetailsKey();	
	
	public void setPostalServiceElements(PostalServiceElements postalServiceElements);
	public void setAddress(Address address);
	public void setAddressLines(AddressLines addressLines);
	public void setCountry(Country country);
	public void setAdministrativeArea(AdministrativeArea administrativeArea);
	public void setLocality(Locality locality);
	public void setThoroughfare(Thoroughfare thoroughfare);
	public void setAddressType(String addressType);
	public void setCurrentStatus(String currentStatus);
	public void setValidFromDate(String validFromDate);
	public void setValidToDate(String validToDate);
	public void setUsage(String usage);
	public void setAddressDetailsKey(String addressDetailsKey);
	public void unsetPostalServiceElements();
	public void unsetAddress();
	public void unsetAddressLines();	
	public void unsetCountry();
	public void unsetAdministrativeArea();
	public void unsetLocality();
	public void unsetThoroughfare();
	public void unsetAddressType();
	public void unsetCurrentStatus();
	public void unsetValidFromDate();
	public void unsetValidToDate();
	public void unsetUsage();
	public void unsetAddressDetailsKey();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
