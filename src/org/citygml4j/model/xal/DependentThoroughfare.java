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

public interface DependentThoroughfare extends XAL, Child, Copyable {
	public List<AddressLine> getAddressLine();
	public ThoroughfarePreDirection getThoroughfarePreDirection();
	public ThoroughfareLeadingType getThoroughfareLeadingType();
	public List<ThoroughfareName> getThoroughfareName();
	public ThoroughfareTrailingType getThoroughfareTrailingType();
	public ThoroughfarePostDirection getThoroughfarePostDirection();
	public String getType();
	public boolean isSetAddressLine();
	public boolean isSetThoroughfarePreDirection();
	public boolean isSetThoroughfareLeadingType();
	public boolean isSetThoroughfareName();
	public boolean isSetThoroughfareTrailingType();
	public boolean isSetThoroughfarePostDirection();
	public boolean isSetType();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void setThoroughfarePreDirection(ThoroughfarePreDirection thoroughfarePreDirection);
	public void setThoroughfareLeadingType(ThoroughfareLeadingType thoroughfareLeadingType);
	public void addThoroughfareName(ThoroughfareName thoroughfareName);
	public void setThoroughfareName(List<ThoroughfareName> thoroughfareName);
	public void setThoroughfareTrailingType(ThoroughfareTrailingType thoroughfareTrailingType);
	public void setThoroughfarePostDirection(ThoroughfarePostDirection thoroughfarePostDirection);
	public void setType(String type);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetThoroughfarePreDirection();
	public void unsetThoroughfareLeadingType();
	public void unsetThoroughfareName();
	public boolean unsetThoroughfareName(ThoroughfareName thoroughfareName);
	public void unsetThoroughfareTrailingType();
	public void unsetThoroughfarePostDirection();
	public void unsetType();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
