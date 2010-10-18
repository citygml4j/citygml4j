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

public interface PremiseNumberRangeTo extends XAL, Child, Copyable {
	public List<AddressLine> getAddressLine();
	public List<PremiseNumberPrefix> getPremiseNumberPrefix();
	public List<PremiseNumber> getPremiseNumber();
	public List<PremiseNumberSuffix> getPremiseNumberSuffix();
	public boolean isSetAddressLine();
	public boolean isSetPremiseNumberPrefix();
	public boolean isSetPremiseNumber();
	public boolean isSetPremiseNumberSuffix();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void addPremiseNumberPrefix(PremiseNumberPrefix premiseNumberPrefix);
	public void setPremiseNumberPrefix(List<PremiseNumberPrefix> premiseNumberPrefix);
	public void addPremiseNumber(PremiseNumber premiseNumber);
	public void setPremiseNumber(List<PremiseNumber> premiseNumber);
	public void addPremiseNumberSuffix(PremiseNumberSuffix premiseNumberSuffix);
	public void setPremiseNumberSuffix(List<PremiseNumberSuffix> premiseNumberSuffix);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetPremiseNumberPrefix();
	public boolean unsetPremiseNumberPrefix(PremiseNumberPrefix premiseNumberPrefix);
	public void unsetPremiseNumber();
	public boolean unsetPremiseNumber(PremiseNumber premiseNumber);
	public void unsetPremiseNumberSuffix();
	public boolean unsetPremiseNumberSuffix(PremiseNumberSuffix premiseNumberSuffix);
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
