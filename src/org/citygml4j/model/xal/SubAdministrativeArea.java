/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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

import java.util.List;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public interface SubAdministrativeArea extends XAL, Child, Copyable {
	public List<AddressLine> getAddressLine();
	public List<SubAdministrativeAreaName> getSubAdministrativeAreaName();
	public Locality getLocality();
	public PostOffice getPostOffice();
	public PostalCode getPostalCode();
	public String getType();
	public String getUsageType();
	public String getIndicator();
	public boolean isSetAddressLine();
	public boolean isSetSubAdministrativeAreaName();
	public boolean isSetLocality();
	public boolean isSetPostOffice();
	public boolean isSetPostalCode();
	public boolean isSetType();
	public boolean isSetUsageType();
	public boolean isSetIndicator();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void addSubAdministrativeAreaName(SubAdministrativeAreaName subAdministrativeAreaName);
	public void setSubAdministrativeAreaName(List<SubAdministrativeAreaName> subAdministrativeAreaName);
	public void setLocality(Locality locality);
	public void setPostOffice(PostOffice postOffice);
	public void setPostalCode(PostalCode postalCode);
	public void setType(String type);
	public void setUsageType(String usageType);
	public void setIndicator(String indicator);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetSubAdministrativeAreaName();
	public boolean unsetSubAdministrativeAreaName(SubAdministrativeAreaName subAdministrativeAreaName);
	public void unsetLocality();
	public void unsetPostOffice();
	public void unsetPostalCode();
	public void unsetType();
	public void unsetUsageType();
	public void unsetIndicator();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
