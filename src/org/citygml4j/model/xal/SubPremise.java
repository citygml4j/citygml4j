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

import java.util.List;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public interface SubPremise extends XAL, Child, Copyable {
	public List<AddressLine> getAddressLine();
	public List<SubPremiseName> getSubPremiseName();
	public SubPremiseLocation getSubPremiseLocation();
	public List<SubPremiseNumber> getSubPremiseNumber();
	public List<SubPremiseNumberPrefix> getSubPremiseNumberPrefix();
	public List<SubPremiseNumberSuffix> getSubPremiseNumberSuffix();
	public List<BuildingName> getBuildingName();
	public Firm getFirm();
	public MailStop getMailStop();
	public PostalCode getPostalCode();
	public SubPremise getSubPremise();
	public String getType();
	public boolean isSetAddressLine();
	public boolean isSetSubPremiseName();
	public boolean isSetSubPremiseLocation();
	public boolean isSetSubPremiseNumber();
	public boolean isSetSubPremiseNumberPrefix();
	public boolean isSetSubPremiseNumberSuffix();
	public boolean isSetBuildingName();
	public boolean isSetFirm();
	public boolean isSetMailStop();
	public boolean isSetPostalCode();
	public boolean isSetSubPremise();
	public boolean isSetType();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void addSubPremiseName(SubPremiseName subPremiseName);
	public void setSubPremiseName(List<SubPremiseName> subPremiseName);
	public void setSubPremiseLocation(SubPremiseLocation subPremiseLocation);
	public void addSubPremiseNumber(SubPremiseNumber subPremiseNumber);
	public void setSubPremiseNumber(List<SubPremiseNumber> subPremiseNumber);
	public void addSubPremiseNumberPrefix(SubPremiseNumberPrefix subPremiseNumberPrefix);
	public void setSubPremiseNumberPrefix(List<SubPremiseNumberPrefix> subPremiseNumberPrefix);
	public void addSubPremiseNumberSuffix(SubPremiseNumberSuffix subPremiseNumberSuffix);
	public void setSubPremiseNumberSuffix(List<SubPremiseNumberSuffix> subPremiseNumberSuffix);
	public void addBuildingName(BuildingName buildingName);
	public void setBuildingName(List<BuildingName> buildingName);
	public void setFirm(Firm firm);
	public void setMailStop(MailStop mailStop);
	public void setPostalCode(PostalCode postalCode);
	public void setSubPremise(SubPremise subPremise);
	public void setType(String type);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetSubPremiseName();
	public boolean unsetSubPremiseName(SubPremiseName subPremiseName);
	public void unsetSubPremiseLocation();
	public void unsetSubPremiseNumber();
	public boolean unsetSubPremiseNumber(SubPremiseNumber subPremiseNumber);
	public void unsetSubPremiseNumberPrefix();
	public boolean unsetSubPremiseNumberPrefix(SubPremiseNumberPrefix subPremiseNumberPrefix);
	public void unsetSubPremiseNumberSuffix();
	public boolean unsetSubPremiseNumberSuffix(SubPremiseNumberSuffix subPremiseNumberSuffix);
	public void unsetBuildingName();
	public boolean unsetBuildingName(BuildingName buildingName);
	public void unsetFirm();
	public void unsetMailStop();
	public void unsetPostalCode();
	public void unsetSubPremise();
	public void unsetType();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
