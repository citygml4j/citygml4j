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
package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.Coordinates;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LineString extends AbstractCurve {
	private List<PosOrPointPropertyOrPointRepOrCoord> controlPoints;
	private DirectPositionList posList;
	private Coordinates coordinates;

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		List<Double> points = toList3d();

		for (int i = 0; i < points.size(); i += 3)
			bbox.update(points.get(i), points.get(i + 1), points.get(i + 2));

		return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.LINE_STRING;
	}

	public void addCoord(Coord coord) {
		if (controlPoints == null)
			controlPoints = new ChildList<PosOrPointPropertyOrPointRepOrCoord>(this);

		controlPoints.add(new PosOrPointPropertyOrPointRepOrCoord(coord));
	}

	public void addPointProperty(PointProperty pointProperty) {
		if (controlPoints == null)
			controlPoints = new ChildList<PosOrPointPropertyOrPointRepOrCoord>(this);

		controlPoints.add(new PosOrPointPropertyOrPointRepOrCoord(pointProperty));
	}

	public void addPointRep(PointRep pointRep) {
		if (controlPoints == null)
			controlPoints = new ChildList<PosOrPointPropertyOrPointRepOrCoord>(this);

		controlPoints.add(new PosOrPointPropertyOrPointRepOrCoord(pointRep));
	}

	public void addPos(DirectPosition pos) {
		if (controlPoints == null)
			controlPoints = new ChildList<PosOrPointPropertyOrPointRepOrCoord>(this);

		controlPoints.add(new PosOrPointPropertyOrPointRepOrCoord(pos));
	}

	public void addControlPoint(PosOrPointPropertyOrPointRepOrCoord controlPoint) {
		if (controlPoints == null)
			controlPoints = new ChildList<PosOrPointPropertyOrPointRepOrCoord>(this);

		controlPoints.add(controlPoint);
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public DirectPositionList getPosList() {
		return posList;
	}

	public List<PosOrPointPropertyOrPointRepOrCoord> getPosOrPointPropertyOrPointRepOrCoord() {
		if (controlPoints == null)
			controlPoints = new ChildList<PosOrPointPropertyOrPointRepOrCoord>(this);

		return controlPoints;
	}

	public boolean isSetCoordinates() {
		return coordinates != null;
	}

	public boolean isSetPosList() {
		return posList != null;
	}

	public boolean isSetPosOrPointPropertyOrPointRepOrCoord() {
		return controlPoints != null && !controlPoints.isEmpty();
	}

	public void setCoordinates(Coordinates coordinates) {
		if (coordinates != null)
			coordinates.setParent(this);

		this.coordinates = coordinates;
	}

	public void setPosList(DirectPositionList posList) {
		if (posList != null)
			posList.setParent(this);

		this.posList = posList;
	}

	public void setPosOrPointPropertyOrPointRepOrCoord(List<PosOrPointPropertyOrPointRepOrCoord> controlPoints) {
		this.controlPoints = new ChildList<PosOrPointPropertyOrPointRepOrCoord>(this, controlPoints);
	}

	public List<Double> toList3d() {
		List<Double> tmp = new ArrayList<Double>();

		if (isSetPosList())
			tmp.addAll(posList.toList3d());

		if (isSetPosOrPointPropertyOrPointRepOrCoord())
			for (PosOrPointPropertyOrPointRepOrCoord controlPoint : controlPoints)
				tmp.addAll(controlPoint.toList3d());

		if (isSetCoordinates())
			tmp.addAll(coordinates.toList3d());

		return tmp;
	}

	public List<Double> toList3d(boolean reverseOrder) {
		List<Double> points = toList3d();

		if (reverseOrder) {
			List<Double> reversed = new ArrayList<Double>();

			for (int i = points.size() - 3; i >= 0; i -=3)
				reversed.addAll(points.subList(i, i + 3));

			points = reversed;
		}

		return points;
	}

	public void unsetCoordinates() {
		if (isSetCoordinates())
			coordinates.unsetParent();

		coordinates = null;
	}

	public void unsetPosList() {
		if (isSetPosList())
			posList.unsetParent();

		posList = null;
	}

	public void unsetPosOrPointPropertyOrPointRepOrCoord() {
		if (isSetPosOrPointPropertyOrPointRepOrCoord())
			controlPoints.clear();

		controlPoints = null;
	}

	public boolean unsetPosOrPointPropertyOrPointRepOrCoord(PosOrPointPropertyOrPointRepOrCoord controlPoint) {
		return isSetPosOrPointPropertyOrPointRepOrCoord() ? controlPoints.remove(controlPoint) : false;	
	}

	public boolean unsetCoord(Coord coord) {
		boolean success = false;

		if (isSetPosOrPointPropertyOrPointRepOrCoord()) {
			Iterator<PosOrPointPropertyOrPointRepOrCoord> iter = controlPoints.iterator();
			while (iter.hasNext()) {
				PosOrPointPropertyOrPointRepOrCoord controlPoint = iter.next();

				if (controlPoint != null && controlPoint.getCoord().equals(coord)) {
					iter.remove();
					success = true;
					break;
				}
			}
		}

		return success;
	}

	public boolean unsetPointProperty(PointProperty pointProperty) {
		boolean success = false;

		if (isSetPosOrPointPropertyOrPointRepOrCoord()) {
			Iterator<PosOrPointPropertyOrPointRepOrCoord> iter = controlPoints.iterator();
			while (iter.hasNext()) {
				PosOrPointPropertyOrPointRepOrCoord controlPoint = iter.next();

				if (controlPoint != null && controlPoint.getPointProperty().equals(pointProperty)) {
					iter.remove();
					success = true;
					break;
				}
			}
		}

		return success;
	}

	public boolean unsetPointRep(PointRep pointRep) {
		boolean success = false;

		if (isSetPosOrPointPropertyOrPointRepOrCoord()) {
			Iterator<PosOrPointPropertyOrPointRepOrCoord> iter = controlPoints.iterator();
			while (iter.hasNext()) {
				PosOrPointPropertyOrPointRepOrCoord controlPoint = iter.next();

				if (controlPoint != null && controlPoint.getPointRep().equals(pointRep)) {
					iter.remove();
					success = true;
					break;
				}
			}
		}

		return success;
	}

	public boolean unsetPos(DirectPosition pos) {
		boolean success = false;

		if (isSetPosOrPointPropertyOrPointRepOrCoord()) {
			Iterator<PosOrPointPropertyOrPointRepOrCoord> iter = controlPoints.iterator();
			while (iter.hasNext()) {
				PosOrPointPropertyOrPointRepOrCoord controlPoint = iter.next();

				if (controlPoint != null && controlPoint.getPos().equals(pos)) {
					iter.remove();
					success = true;
					break;
				}
			}
		}

		return success;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		LineString copy = (target == null) ? new LineString() : (LineString)target;
		super.copyTo(copy, copyBuilder);

		if (isSetPosOrPointPropertyOrPointRepOrCoord()) {
			for (PosOrPointPropertyOrPointRepOrCoord part : controlPoints) {
				PosOrPointPropertyOrPointRepOrCoord copyPart = (PosOrPointPropertyOrPointRepOrCoord)copyBuilder.copy(part);
				copy.addControlPoint(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetPosList()) {
			copy.setPosList((DirectPositionList)copyBuilder.copy(posList));
			if (copy.getPosList() == posList)
				posList.setParent(this);
		}

		if (isSetCoordinates()) {
			copy.setCoordinates((Coordinates)copyBuilder.copy(coordinates));
			if (copy.getCoordinates() == coordinates)
				coordinates.setParent(this);
		}

		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new LineString(), copyBuilder);
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
