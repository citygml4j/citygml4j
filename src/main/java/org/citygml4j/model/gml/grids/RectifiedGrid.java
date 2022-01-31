/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.geometry.Matrix;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.PointProperty;
import org.citygml4j.model.gml.geometry.primitives.Vector;

import java.util.List;

public class RectifiedGrid extends Grid {
	private PointProperty origin;
	private List<Vector> offsetVector;
	
	public void addOffsetVector(Vector offsetVector) {
		getOffsetVector().add(offsetVector);
	}

	public PointProperty getOrigin() {
		return origin;
	}

	public List<Vector> getOffsetVector() {
		if (offsetVector == null)
			offsetVector = new ChildList<>(this);
		
		return offsetVector;
	}

	public boolean isSetOrigin() {
		return origin != null;
	}

	public boolean isSetOffsetVector() {
		return offsetVector != null && !offsetVector.isEmpty();
	}

	public void setOrigin(PointProperty origin) {
		this.origin = ModelObjects.setParent(origin, this);
	}

	public void setOffsetVector(List<Vector> offsetVector) {
		this.offsetVector = new ChildList<>(this, offsetVector);
	}

	public void unsetOrigin() {
		origin = ModelObjects.setNull(origin);
	}

	public boolean unsetOffsetVector(Vector offsetVector) {
		return isSetOffsetVector() && this.offsetVector.remove(offsetVector);
	}

	public void unsetOffsetVector() {
		offsetVector = ModelObjects.setNull(offsetVector);
	}
	
	@Override
	public BoundingBox calcBoundingBox() {
		if (!(isSetOrigin() && origin.isSetPoint() &&
				isSetOffsetVector() && offsetVector.size() >= getDimension()))
			return null;
		
		BoundingBox gridLimits = super.calcBoundingBox();
		if (gridLimits == null)
			return null;

		BoundingBox bbox = new BoundingBox();
		
		Matrix[] offsetVectors = new Matrix[3];
		offsetVectors[0] = getDimension() >= 1 ? new Matrix(this.offsetVector.get(0).toList3d(), 3) : new Matrix(3, 1, 0);
		offsetVectors[1] = getDimension() >= 2 ? new Matrix(this.offsetVector.get(1).toList3d(), 3) : new Matrix(3, 1, 0);
		offsetVectors[2] = getDimension() >= 3 ? new Matrix(this.offsetVector.get(2).toList3d(), 3) : new Matrix(3, 1, 0);

		Matrix origin = new Matrix(this.origin.getPoint().toList3d(), 3);
		List<Double> limits = gridLimits.toList();

		for (int x = 0; x < 2; x++) {
			for (int y = 0; y < 2; y++) {
				for (int z = 0; z < 2; z++) {
					double[] cornerPoint = origin
							.plus(offsetVectors[0].times(limits.get(x * 3)))
							.plus(offsetVectors[1].times(limits.get(1 + y * 3)))
							.plus(offsetVectors[2].times(limits.get(2 + z * 3))).getColumnPackedCopy();

					bbox.update(cornerPoint[0], cornerPoint[1], cornerPoint[2]);
				}
			}
		}
		
		return bbox;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.RECTIFIED_GRID;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		RectifiedGrid copy = (target == null) ? new RectifiedGrid() : (RectifiedGrid)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetOffsetVector()) {
			for (Vector part : offsetVector) {
				Vector copyPart = (Vector)copyBuilder.copy(part);
				copy.addOffsetVector(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetOrigin()) {
			copy.setOrigin((PointProperty)copyBuilder.copy(origin));
			if (copy.getOrigin() == origin)
				origin.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new RectifiedGrid(), copyBuilder);
	}
	
	@Override
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public <T> T accept(GeometryFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	@Override
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
