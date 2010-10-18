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

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public interface PremiseNumberRange extends XAL, Child, Copyable {
	public PremiseNumberRangeFrom getPremiseNumberRangeFrom();
	public PremiseNumberRangeTo getPremiseNumberRangeTo();
	public String getRangeType();
	public String getIndicator();
	public String getSeparator();
	public String getType();
	public String getIndicatorOccurence();
	public String getNumberRangeOccurence();
	public boolean isSetPremiseNumberRangeFrom();
	public boolean isSetPremiseNumberRangeTo();
	public boolean isSetRangeType();
	public boolean isSetIndicator();
	public boolean isSetSeparator();
	public boolean isSetType();
	public boolean isSetIndicatorOccurence();
	public boolean isSetNumberRangeOccurence();
	
	public void setPremiseNumberRangeFrom(PremiseNumberRangeFrom premiseNumberRangeFrom);
	public void setPremiseNumberRangeTo(PremiseNumberRangeTo premiseNumberRangeTo);
	public void setRangeType(String rangeType);
	public void setIndicator(String indicator);
	public void setSeparator(String separator);
	public void setType(String type);
	public void setIndicatorOccurence(String indicatorOccurence);
	public void setNumberRangeOccurence(String numberRangeOccurence);
	public void unsetPremiseNumberRangeFrom();
	public void unsetPremiseNumberRangeTo();
	public void unsetRangeType();
	public void unsetIndicator();
	public void unsetSeparator();
	public void unsetType();
	public void unsetIndicatorOccurence();
	public void unsetNumberRangeOccurence();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
