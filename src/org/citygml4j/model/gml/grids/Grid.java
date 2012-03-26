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

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Point;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.AbstractGeometry;

public class Grid extends AbstractGeometry {
	private GridLimits limits;
	private List<String> axisName;
	private int dimension;

	public GridLimits getLimits() {
		return limits;
	}

	public List<String> getAxisName() {
		if (axisName == null)
			axisName = new ArrayList<String>();

		return axisName;
	}

	public Integer getDimension() {
		return dimension;
	}

	public boolean isSetLimits() {
		return limits != null;
	}

	public boolean isSetAxisName() {
		return axisName != null && !axisName.isEmpty();
	}

	public boolean isSetDimension() {
		return true;
	}

	public void setLimits(GridLimits limits) {
		if (limits != null)
			limits.setParent(this);

		this.limits = limits;
	}

	public void addAxisName(String axisName) {
		if (this.axisName == null)
			this.axisName = new ArrayList<String>();

		this.axisName.add(axisName);
	}

	public void setAxisName(List<String> axisName) {
		this.axisName = axisName;
	}

	public void setDimension(Integer dimension) {
		if (dimension > 0)
			this.dimension = dimension;
	}

	public void unsetLimits() {
		if (isSetLimits())
			limits.unsetParent();

		limits = null;
	}

	public void unsetAxisName() {
		axisName = null;
	}

	public BoundingBox calcBoundingBox() {
		if (!isSetLimits())
			return null;

		GridEnvelope gridEnvelope = limits.getGridEnvelope();
		if (!(gridEnvelope.isSetHigh() && gridEnvelope.isSetLow() &&
				gridEnvelope.getHigh().size() >= dimension &&
				gridEnvelope.getLow().size() >= dimension))
			return null;

		BoundingBox bbox = new BoundingBox();

		Point low = new Point();
		low.setX(dimension >= 1 ? gridEnvelope.getLow().get(0) : 0.0);
		low.setY(dimension >= 2 ? gridEnvelope.getLow().get(1) : 0.0);
		low.setZ(dimension >= 3 ? gridEnvelope.getLow().get(2) : 0.0);
		bbox.update(low);
		
		Point high = new Point();
		high.setX(dimension >= 1 ? gridEnvelope.getHigh().get(0) : 0.0);
		high.setY(dimension >= 2 ? gridEnvelope.getHigh().get(1) : 0.0);
		high.setZ(dimension >= 3 ? gridEnvelope.getHigh().get(2) : 0.0);
		bbox.update(high);
		
		return bbox;	
	}	

	public GMLClass getGMLClass() {
		return GMLClass.GRID;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Grid copy = (target == null) ? new Grid() : (Grid)target;
		super.copyTo(copy, copyBuilder);

		if (isSetLimits()) {
			copy.setLimits((GridLimits)copyBuilder.copy(limits));
			if (copy.getLimits() == limits)
				limits.setParent(this);
		}

		if (isSetAxisName())
			copy.setAxisName((List<String>)copyBuilder.copy(axisName));

		copy.setDimension(dimension);

		copy.unsetParent();

		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Grid(), copyBuilder);
	}

	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GeometryFunctor<T> visitor) {
		return visitor.apply(this);
	}

	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
