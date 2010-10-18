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
package org.citygml4j.model.gml.valueObjects;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;


public interface ValueExtent extends GML, Child, Copyable {
	public CategoryExtent getCategoryExtent();
	public QuantityExtent getQuantityExtent();
	public CountExtent getCountExtent();
	public boolean isSetCategoryExtent();
	public boolean isSetQuantityExtent();
	public boolean isSetCountExtent();
	
	public void setCategoryExtent(CategoryExtent categoryExtent);
	public void setQuantityExtent(QuantityExtent quantityExtent);
	public void setCountExtent(CountExtent countExtent);
	public void unsetCategoryExtent();
	public void unsetQuantityExtent();
	public void unsetCountExtent();	
}
