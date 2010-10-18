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

public interface ThoroughfareNumberRange extends XAL, GrPostal, Child, Copyable {
	public List<AddressLine> getAddressLine();
	public ThoroughfareNumberFrom getThoroughfareNumberFrom();
	public ThoroughfareNumberTo getThoroughfareNumberTo();
	public String getRangeType();
	public String getIndicator();
	public String getSeparator();
	public String getIndicatorOccurrence();
	public String getNumberRangeOccurrence();
	public String getType();
	public boolean isSetAddressLine();
	public boolean isSetThoroughfareNumberFrom();
	public boolean isSetThoroughfareNumberTo();
	public boolean isSetRangeType();
	public boolean isSetIndicator();
	public boolean isSetSeparator();
	public boolean isSetIndicatorOccurrence();
	public boolean isSetNumberRangeOccurrence();
	public boolean isSetType();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void setThoroughfareNumberFrom(ThoroughfareNumberFrom thoroughfareNumberFrom);
	public void setThoroughfareNumberTo(ThoroughfareNumberTo thoroughfareNumberTo);
	public void setRangeType(String rangeType);
	public void setIndicator(String indicator);
	public void setSeparator(String separator);
	public void setIndicatorOccurrence(String indicatorOccurrence);
	public void setNumberRangeOccurrence(String numberRangeOccurrence);
	public void setType(String type);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetThoroughfareNumberFrom();
	public void unsetThoroughfareNumberTo();
	public void unsetRangeType();
	public void unsetIndicator();
	public void unsetSeparator();
	public void unsetIndicatorOccurrence();
	public void unsetNumberRangeOccurrence();
	public void unsetType();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
