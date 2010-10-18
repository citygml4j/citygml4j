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

public interface Premise extends XAL, Child, Copyable {
	public List<AddressLine> getAddressLine();
	public List<PremiseName> getPremiseName();
	public PremiseLocation getPremiseLocation();
	public List<PremiseNumber> getPremiseNumber();
	public PremiseNumberRange getPremiseNumberRange();
	public List<PremiseNumberPrefix> getPremiseNumberPrefix();
	public List<PremiseNumberSuffix> getPremiseNumberSuffix();
	public List<BuildingName> getBuildingName();
	public List<SubPremise> getSubPremise();
	public Firm getFirm();
	public MailStop getMailStop();
	public PostalCode getPostalCode();
	public Premise getPremise();
	public String getType();
	public String getPremiseDependency();
	public String getPremiseDependencyType();
	public String getPremiseThoroughfareConnector();
	public boolean isSetAddressLine();
	public boolean isSetPremiseName();
	public boolean isSetPremiseLocation();
	public boolean isSetPremiseNumber();
	public boolean isSetPremiseNumberRange();
	public boolean isSetPremiseNumberPrefix();
	public boolean isSetPremiseNumberSuffix();
	public boolean isSetBuildingName();
	public boolean isSetSubPremise();
	public boolean isSetFirm();
	public boolean isSetMailStop();
	public boolean isSetPostalCode();
	public boolean isSetPremise();
	public boolean isSetType();
	public boolean isSetPremiseDependency();
	public boolean isSetPremiseDependencyType();
	public boolean isSetPremiseThoroughfareConnector();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void addPremiseName(PremiseName premiseName);
	public void setPremiseName(List<PremiseName> premiseName);
	public void setPremiseLocation(PremiseLocation premiseLocation);
	public void addPremiseNumber(PremiseNumber premiseNumber);
	public void setPremiseNumber(List<PremiseNumber> premiseNumber);
	public void setPremiseNumberRange(PremiseNumberRange premiseNumberRange);
	public void addPremiseNumberPrefix(PremiseNumberPrefix premiseNumberPrefix);
	public void setPremiseNumberPrefix(List<PremiseNumberPrefix> premiseNumberPrefix);
	public void addPremiseNumberSuffix(PremiseNumberSuffix premiseNumberSuffix);
	public void setPremiseNumberSuffix(List<PremiseNumberSuffix> premiseNumberSuffix);
	public void addBuildingName(BuildingName buildingName);
	public void setBuildingName(List<BuildingName> buildingName);
	public void addSubPremise(SubPremise subPremise);
	public void setSubPremise(List<SubPremise> subPremise);
	public void setFirm(Firm firm);
	public void setMailStop(MailStop mailStop);
	public void setPostalCode(PostalCode postalCode);
	public void setPremise(Premise premise);
	public void setType(String type);
	public void setPremiseDependency(String premiseDependency);
	public void setPremiseDependencyType(String premiseDependencyType);
	public void setPremiseThoroughfareConnector(String premiseThoroughfareConnector);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetPremiseName();
	public boolean unsetPremiseName(PremiseName premiseName);
	public void unsetPremiseLocation();
	public void unsetPremiseNumber();
	public boolean unsetPremiseNumber(PremiseNumber premiseNumber);
	public void unsetPremiseNumberRange();
	public void unsetPremiseNumberPrefix();
	public boolean unsetPremiseNumberPrefix(PremiseNumberPrefix premiseNumberPrefix);
	public void unsetPremiseNumberSuffix();
	public boolean unsetPremiseNumberSuffix(PremiseNumberSuffix premiseNumberSuffix);
	public void unsetBuildingName();
	public boolean unsetBuildingName(BuildingName buildingName);
	public void unsetSubPremise();
	public boolean unsetSubPremise(SubPremise subPremise);
	public void unsetFirm();
	public void unsetMailStop();
	public void unsetPostalCode();
	public void unsetPremise();
	public void unsetType();
	public void unsetPremiseDependency();
	public void unsetPremiseDependencyType();
	public void unsetPremiseThoroughfareConnector();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
