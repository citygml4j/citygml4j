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
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Matrix;
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
		if (this.offsetVector == null)
			this.offsetVector = new ChildList<Vector>(this);
		
		this.offsetVector.add(offsetVector);
	}

	public PointProperty getOrigin() {
		return origin;
	}

	public List<Vector> getOffsetVector() {
		if (offsetVector == null)
			offsetVector = new ChildList<Vector>(this);
		
		return offsetVector;
	}

	public boolean isSetOrigin() {
		return origin != null;
	}

	public boolean isSetOffsetVector() {
		return offsetVector != null && !offsetVector.isEmpty();
	}

	public void setOrigin(PointProperty origin) {
		if (origin != null)
			origin.setParent(this);
		
		this.origin = origin;
	}

	public void setOffsetVector(List<Vector> offsetVector) {
		this.offsetVector = new ChildList<Vector>(this, offsetVector);
	}

	public void unsetOrigin() {
		if (isSetOrigin())
			origin.unsetParent();
		
		origin = null;
	}

	public boolean unsetOffsetVector(Vector offsetVector) {
		return isSetOffsetVector() ? this.offsetVector.remove(offsetVector) : false;
	}

	public void unsetOffsetVector() {
		if (isSetOffsetVector())
			offsetVector.clear();
		
		offsetVector = null;
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
		
		Matrix[] offsetVector = new Matrix[3];
		offsetVector[0] = getDimension() >= 1 ? new Matrix(this.offsetVector.get(0).toList3d(), 3) : new Matrix(3, 1, 0);
		offsetVector[1] = getDimension() >= 2 ? new Matrix(this.offsetVector.get(1).toList3d(), 3) : new Matrix(3, 1, 0);
		offsetVector[2] = getDimension() >= 3 ? new Matrix(this.offsetVector.get(2).toList3d(), 3) : new Matrix(3, 1, 0);
		
		double[] gridLength = new double[3];
		gridLength[0] = gridLimits.getUpperCorner().getX() - gridLimits.getLowerCorner().getX();
		gridLength[1] = gridLimits.getUpperCorner().getY() - gridLimits.getLowerCorner().getY();
		gridLength[2] = gridLimits.getUpperCorner().getZ() - gridLimits.getLowerCorner().getZ();
		
		Matrix origin = new Matrix(this.origin.getPoint().toList3d(), 3);
		Matrix xmax = offsetVector[0].times(gridLength[0]);
		Matrix ymax = offsetVector[1].times(gridLength[1]);
		Matrix zmax = offsetVector[2].times(gridLength[2]); 
		
		double[][] cornerPoints = new double[8][];
		cornerPoints[0] = origin.toColumnPackedArray();
		cornerPoints[1] = xmax.plus(origin).toColumnPackedArray();
		cornerPoints[2] = ymax.plus(origin).toColumnPackedArray();
		cornerPoints[3] = zmax.plus(origin).toColumnPackedArray();
		cornerPoints[4] = xmax.plus(ymax).plus(origin).toColumnPackedArray();
		cornerPoints[5] = xmax.plus(zmax).plus(origin).toColumnPackedArray();
		cornerPoints[6] = ymax.plus(zmax).plus(origin).toColumnPackedArray();
		cornerPoints[7] = xmax.plus(ymax).plus(zmax).plus(origin).toColumnPackedArray();
		
		for (double[] cornerPoint : cornerPoints)
			bbox.update(cornerPoint[0], cornerPoint[1], cornerPoint[2]);
		
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
