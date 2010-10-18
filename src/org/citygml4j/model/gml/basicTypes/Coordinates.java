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
package org.citygml4j.model.gml.basicTypes;

import java.util.List;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;


public interface Coordinates extends GML, Child, Copyable {
	public String getValue();
	public String getDecimal();
	public String getCs();
	public String getTs();
	public boolean isSetValue();
	public boolean isSetDecimal();
	public boolean isSetCs();
	public boolean isSetTs();
	
	public List<Double> toList3d();
	public List<Double> toList3d(boolean reverseOrder);
	
	public void setValue(String value);
	public void setDecimal(String decimal);
	public void setCs(String cs);
	public void setTs(String ts);
	public void unsetValue();
	public void unsetDecimal();
	public void unsetCs();
	public void unsetTs();
}
