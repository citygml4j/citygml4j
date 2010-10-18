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
package org.citygml4j.model.gml.coverage;

import java.util.List;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.valueObjects.ScalarValueList;
import org.citygml4j.model.gml.valueObjects.ValueArray;


public interface RangeSet extends GML, Child, Copyable {
	public List<ValueArray> getValueArray();
	public List<ScalarValueList> getScalarValueList();
	public DataBlock getDataBlock();
	public File getFile();
	public boolean isSetValueArray();
	public boolean isSetScalarValueList();
	public boolean isSetDataBlock();
	public boolean isSetFile();
	
	public void addValueArray(ValueArray valueArray);
	public void setValueArray(List<ValueArray> valueArray);
	public void addScalarValueList(ScalarValueList scalarValueList);
	public void setScalarValueList(List<ScalarValueList> scalarValueList);
	public void setDataBlock(DataBlock dataBlock);
	public void setFile(File file);
	public boolean unsetValueArray(ValueArray valueArray);
	public void unsetValueArray();
	public boolean unsetScalarValueList(ScalarValueList scalarValueList);
	public void unsetScalarValueList();
	public void unsetDataBlock();
	public void unsetFile();
}
