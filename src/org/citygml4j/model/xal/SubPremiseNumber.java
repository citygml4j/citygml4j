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

public interface SubPremiseNumber extends XAL, GrPostal, Child, Copyable {
	public String getContent();
	public String getIndicator();
	public String getIndicatorOccurrence();
	public String getNumberTypeOccurrence();
	public String getPremiseNumberSeparator();
	public String getType();
	public boolean isSetContent();
	public boolean isSetIndicator();
	public boolean isSetIndicatorOccurrence();
	public boolean isSetNumberTypeOccurrence();
	public boolean isSetPremiseNumberSeparator();
	public boolean isSetType();
	
	public void setContent(String content);
	public void setIndicator(String indicator);
	public void setIndicatorOccurrence(String indicatorOccurrence);
	public void setNumberTypeOccurrence(String numberTypeOccurrence);
	public void setPremiseNumberSeparator(String premiseNumberSeparator);
	public void setType(String type);
	public void unsetContent();
	public void unsetIndicator();
	public void unsetIndicatorOccurrence();
	public void unsetNumberTypeOccurrence();
	public void unsetPremiseNumberSeparator();
	public void unsetType();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
