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
package org.citygml4j.model.gml.valueObjects;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.basicTypes.BooleanOrNullList;
import org.citygml4j.model.gml.basicTypes.CodeOrNullList;
import org.citygml4j.model.gml.basicTypes.IntegerOrNullList;
import org.citygml4j.model.gml.basicTypes.MeasureOrNullList;


public interface ScalarValueList extends GML, Child, Copyable {
	public BooleanOrNullList getBooleanList();
	public CodeOrNullList getCategoryList();
	public MeasureOrNullList getQuantityList();
	public IntegerOrNullList getCountList();
	public boolean isSetBooleanList();
	public boolean isSetCategoryList();
	public boolean isSetQuantityList();
	public boolean isSetCountList();
	
	public void setBooleanList(BooleanOrNullList booleanList);
	public void setCategoryList(CodeOrNullList categoryList);
	public void setQuantityList(MeasureOrNullList quantityList);
	public void setCountList(IntegerOrNullList countList);
	public void unsetBooleanList();
	public void unsetCategoryList();
	public void unsetQuantityList();
	public void unsetCountList();
}
