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

public interface Thoroughfare extends XAL, Child, Copyable {
	public List<AddressLine> getAddressLine();
	public List<ThoroughfareNumberOrRange> getThoroughfareNumberOrThoroughfareNumberRange();
	public List<ThoroughfareNumberPrefix> getThoroughfareNumberPrefix();
	public List<ThoroughfareNumberSuffix> getThoroughfareNumberSuffix();
	public ThoroughfarePreDirection getThoroughfarePreDirection();
	public ThoroughfareLeadingType getThoroughfareLeadingType();
	public List<ThoroughfareName> getThoroughfareName();
	public ThoroughfareTrailingType getThoroughfareTrailingType();
	public ThoroughfarePostDirection getThoroughfarePostDirection();
	public DependentThoroughfare getDependentThoroughfare();
	public DependentLocality getDependentLocality();
	public Premise getPremise();
	public Firm getFirm();
	public PostalCode getPostalCode();
	public String getType();
	public String getDependentThoroughfares();
	public String getDependentThoroughfaresIndicator();
	public String getDependentThoroughfaresConnector();
	public String getDependentThoroughfaresType();
	public boolean isSetAddressLine();
	public boolean isSetThoroughfareNumberOrThoroughfareNumberRange();
	public boolean isSetThoroughfareNumberPrefix();
	public boolean isSetThoroughfareNumberSuffix();
	public boolean isSetThoroughfarePreDirection();
	public boolean isSetThoroughfareLeadingType();
	public boolean isSetThoroughfareName();
	public boolean isSetThoroughfareTrailingType();
	public boolean isSetThoroughfarePostDirection();
	public boolean isSetDependentThoroughfare();
	public boolean isSetDependentLocality();
	public boolean isSetPremise();
	public boolean isSetFirm();
	public boolean isSetPostalCode();
	public boolean isSetType();
	public boolean isSetDependentThoroughfares();
	public boolean isSetDependentThoroughfaresIndicator();
	public boolean isSetDependentThoroughfaresConnector();
	public boolean isSetDependentThoroughfaresType();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void addThoroughfareNumber(ThoroughfareNumber thoroughfareNumber);
	public void addThoroughfareNumberRange(ThoroughfareNumberRange thoroughfareNumberRange);
	public void addThoroughfareNumberOrThoroughfareNumberRange(ThoroughfareNumberOrRange numberOrRange);
	public void setThoroughfareNumberOrThoroughfareNumberRange(List<ThoroughfareNumberOrRange> numberOrRange);
	public void addThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix);
	public void setThoroughfareNumberPrefix(List<ThoroughfareNumberPrefix> thoroughfareNumberPrefix);
	public void addThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix);
	public void setThoroughfareNumberSuffix(List<ThoroughfareNumberSuffix> thoroughfareNumberSuffix);
	public void setThoroughfarePreDirection(ThoroughfarePreDirection thoroughfarePreDirection);
	public void setThoroughfareLeadingType(ThoroughfareLeadingType thoroughfareLeadingType);
	public void addThoroughfareName(ThoroughfareName thoroughfareName);
	public void setThoroughfareName(List<ThoroughfareName> thoroughfareName);
	public void setThoroughfareTrailingType(ThoroughfareTrailingType thoroughfareTrailingType);
	public void setThoroughfarePostDirection(ThoroughfarePostDirection thoroughfarePostDirection);
	public void setDependentThoroughfare(DependentThoroughfare dependentThoroughfare);
	public void setDependentLocality(DependentLocality dependentLocality);
	public void setPremise(Premise premise);
	public void setFirm(Firm firm);
	public void setPostalCode(PostalCode postalCode);
	public void setType(String type);
	public void setDependentThoroughfares(String dependentThoroughfares);
	public void setDependentThoroughfaresIndicator(String dependentThoroughfaresIndicator);
	public void setDependentThoroughfaresConnector(String dependentThoroughfaresConnector);
	public void setDependentThoroughfaresType(String dependentThoroughfaresType);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetThoroughfareNumberOrThoroughfareNumberRange();
	public boolean unsetThoroughfareNumberOrThoroughfareNumberRange(ThoroughfareNumberOrRange thoroughfareNumberOrRange);
	public boolean unsetThoroughfareNumber(ThoroughfareNumber thoroughfareNumber);
	public boolean unsetThoroughfareNumberRange(ThoroughfareNumberRange thoroughfareNumberRange);
	public void unsetThoroughfareNumberPrefix();
	public boolean unsetThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix);
	public void unsetThoroughfareNumberSuffix();
	public boolean unsetThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix);
	public void unsetThoroughfarePreDirection();
	public void unsetThoroughfareLeadingType();
	public void unsetThoroughfareName();
	public boolean unsetThoroughfareName(ThoroughfareName thoroughfareName);
	public void unsetThoroughfareTrailingType();
	public void unsetThoroughfarePostDirection();
	public void unsetDependentThoroughfare();
	public void unsetDependentLocality();
	public void unsetPremise();
	public void unsetFirm();
	public void unsetPostalCode();
	public void unsetType();
	public void unsetDependentThoroughfares();
	public void unsetDependentThoroughfaresIndicator();
	public void unsetDependentThoroughfaresConnector();
	public void unsetDependentThoroughfaresType();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
