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
package org.citygml4j.model.gml.grids;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

public class GridLimits implements GML, Child, Copyable {
	private GridEnvelope gridEnvelope;
	private ModelObject parent;
	
	public ModelType getModelType() {
		return ModelType.GML;
	}
	
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
