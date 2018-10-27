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
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Point;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.AbstractGeometry;

import java.util.ArrayList;
import java.util.List;

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
