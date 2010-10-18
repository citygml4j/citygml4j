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
package org.citygml4j.impl.gml.coverage;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.coverage.IndexMap;

public class IndexMapImpl extends GridFunctionImpl implements IndexMap {
	private List<Integer> lookUpTable;
	
	public List<Integer> getLookUpTable() {
		if (lookUpTable == null)
			lookUpTable = new ArrayList<Integer>();
		
		return lookUpTable;
	}

	public boolean isSetLookUpTable() {
		return lookUpTable != null && !lookUpTable.isEmpty();
	}

	public void addLookUpIndex(Integer lookUpIndex) {
		if (lookUpTable == null)
			lookUpTable = new ArrayList<Integer>();
		
		lookUpTable.add(lookUpIndex);
	}

	public void setLookUpTable(List<Integer> lookUpTable) {
		this.lookUpTable = lookUpTable;
	}

	public void unsetLookUpTable() {
		lookUpTable = null;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.INDEX_MAP;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		IndexMap copy = (target == null) ? new IndexMapImpl() : (IndexMap)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetLookUpTable())
			copy.setLookUpTable((List<Integer>)copyBuilder.copy(lookUpTable));
		
		return copy;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new IndexMapImpl(), copyBuilder);
	}

}
