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

public interface PostalRoute extends XAL, Child, Copyable {
	public List<AddressLine> getAddressLine();
	public List<PostalRouteName> getPostalRouteName();
	public PostalRouteNumber getPostalRouteNumber();
	public PostBox getPostBox();
	public String getType();
	public boolean isSetAddressLine();
	public boolean isSetPostalRouteName();
	public boolean isSetPostalRouteNumber();
	public boolean isSetPostBox();
	public boolean isSetType();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void addPostalRouteName(PostalRouteName postalRouteName);
	public void setPostalRouteName(List<PostalRouteName> postalRouteName);
	public void setPostalRouteNumber(PostalRouteNumber postalRouteNumber);
	public void setPostBox(PostBox postBox);
	public void setType(String type);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetPostalRouteName();
	public boolean unsetPostalRouteName(PostalRouteName postalRouteName);
	public void unsetPostalRouteNumber();
	public void unsetPostBox();
	public void unsetType();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
