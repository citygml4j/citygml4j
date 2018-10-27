/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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

public class GridLimits implements GML, Child, Copyable {
	private GridEnvelope gridEnvelope;
	private ModelObject parent;
	
	public GMLClass getGMLClass() {
		return GMLClass.GRID_LIMITS;
	}

	public GridEnvelope getGridEnvelope() {
		return gridEnvelope;
	}

	public boolean isSetGridEnvelope() {
		return gridEnvelope != null;
	}

	public void setGridEnvelope(GridEnvelope gridEnvelope) {
		if (gridEnvelope != null)
			gridEnvelope.setParent(this);
		
		this.gridEnvelope = gridEnvelope;
	}

	public void unsetGridEnvelope() {
		if (isSetGridEnvelope())
			gridEnvelope.unsetParent();
		
		gridEnvelope = null;
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
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GridLimits copy = (target == null) ? new GridLimits() : (GridLimits)target;
		
		if (isSetGridEnvelope()) {
			copy.setGridEnvelope((GridEnvelope)copyBuilder.copy(gridEnvelope));
			if (copy.getGridEnvelope() == gridEnvelope)
				gridEnvelope.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GridLimits(), copyBuilder);
	}

}
