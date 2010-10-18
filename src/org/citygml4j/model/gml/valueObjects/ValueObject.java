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

import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;

public interface ValueObject extends GML, Associable, Child, Copyable {
	public ScalarValue getScalarValue();
	public ScalarValueList getScalarValueList();
	public ValueExtent getValueExtent();
	public CompositeValue getCompositeValue();	
	public boolean isSetScalarValue();
	public boolean isSetScalarValueList();
	public boolean isSetValueExtent();
	public boolean isSetCompositeValue();
	
	public void setScalarValue(ScalarValue scalarValue);
	public void setScalarValueList(ScalarValueList scalarValueList);
	public void setValueExtent(ValueExtent valueExtent);
	public void setCompositeValue(CompositeValue compositeValue);
	public void unsetScalarValue();
	public void unsetScalarValueList();
	public void unsetValueExtent();
	public void unsetCompositeValue();
}
