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
package org.citygml4j.model.gml.grids;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

import java.util.ArrayList;
import java.util.List;

public class GridEnvelope implements GML, Child, Copyable {
	private List<Integer> low;
	private List<Integer> high;
	private ModelObject parent;
	
	public GMLClass getGMLClass() {
		return GMLClass.GRID_ENVELOPE;
	}

	public List<Integer> getLow() {
		if (low == null)
			low = new ArrayList<Integer>();
		
		return low;
	}

	public List<Integer> getHigh() {
		if (high == null)
			high = new ArrayList<Integer>();
		
		return high;
	}

	public boolean isSetLow() {
		return low != null && !low.isEmpty();
	}

	public boolean isSetHigh() {
		return high != null && !high.isEmpty();
	}

	public void addLow(Integer low) {
		if (this.low == null)
			this.low = new ArrayList<Integer>();
		
		this.low.add(low);
	}

	public void addHigh(Integer high) {
		if (this.high == null)
			this.high = new ArrayList<Integer>();
		
		this.high.add(high);
	}

	public void setLow(List<Integer> low) {
		this.low = low;
	}

	public void setHigh(List<Integer> high) {
		this.high = high;
	}

	public void unsetLow() {
		low = null;
	}

	public void unsetHigh() {
		high = null;
	}
	
	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}
	
	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GridEnvelope copy = (target == null) ? new GridEnvelope() : (GridEnvelope)target;
		
		if (isSetLow())
			copy.setLow((List<Integer>)copyBuilder.copy(low));
		
		if (isSetHigh())
			copy.setHigh((List<Integer>)copyBuilder.copy(high));
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GridEnvelope(), copyBuilder);
	}

}
