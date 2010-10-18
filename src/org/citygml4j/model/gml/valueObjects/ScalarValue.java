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
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.basicTypes.Measure;


public interface ScalarValue extends GML, Child, Copyable {
	public Boolean getBoolean();
	public Code getCategory();
	public Measure getQuantity();
	public Integer getCount();
	public boolean isSetBoolean();
	public boolean isSetCategory();
	public boolean isSetQuantity();
	public boolean isSetCount();
	
	public void setBoolean(Boolean _boolean);
	public void setCategory(Code category);
	public void setQuantity(Measure quantity);
	public void setCount(Integer count);
	public void unsetBoolean();
	public void unsetCategory();
	public void unsetQuantity();
	public void unsetCount();
}
