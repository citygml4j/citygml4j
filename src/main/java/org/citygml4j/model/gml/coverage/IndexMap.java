/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;

import java.util.ArrayList;
import java.util.List;

public class IndexMap extends GridFunction {
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
		IndexMap copy = (target == null) ? new IndexMap() : (IndexMap)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetLookUpTable())
			copy.setLookUpTable((List<Integer>)copyBuilder.copy(lookUpTable));
		
		return copy;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new IndexMap(), copyBuilder);
	}

}
