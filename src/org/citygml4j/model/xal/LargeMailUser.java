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

public interface LargeMailUser extends XAL, Child, Copyable {
	public List<AddressLine> getAddressLine();
	public List<LargeMailUserName> getLargeMailUserName();
	public LargeMailUserIdentifier getLargeMailUserIdentifier();
	public List<BuildingName> getBuildingName();
	public Department getDepartment();
	public PostBox getPostBox();
	public Thoroughfare getThoroughfare(); 
	public PostalCode getPostalCode();
	public String getType();
	public boolean isSetAddressLine();
	public boolean isSetLargeMailUserName();
	public boolean isSetLargeMailUserIdentifier();
	public boolean isSetBuildingName();
	public boolean isSetDepartment();
	public boolean isSetPostBox();
	public boolean isSetThoroughfare(); 
	public boolean isSetPostalCode();
	public boolean isSetType();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void addLargeMailUserName(LargeMailUserName largeMailUserName);
	public void setLargeMailUserName(List<LargeMailUserName> largeMailUserName);
	public void setLargeMailUserIdentifier(LargeMailUserIdentifier largeMailUserIdentifier);
	public void addBuildingName(BuildingName buildingName);
	public void setBuildingName(List<BuildingName> buildingName);
	public void setDepartment(Department department);
	public void setPostBox(PostBox postBox);
	public void setThoroughfare(Thoroughfare thoroughfare);
	public void setPostalCode(PostalCode postalCode);
	public void setType(String type);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetLargeMailUserName();
	public boolean unsetLargeMailUserName(LargeMailUserName largeMailUserName);
	public void unsetLargeMailUserIdentifier();
	public void unsetBuildingName();
	public boolean unsetBuildingName(BuildingName buildingName);
	public void unsetDepartment();
	public void unsetPostBox();
	public void unsetThoroughfare(); 
	public void unsetPostalCode();
	public void unsetType();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
