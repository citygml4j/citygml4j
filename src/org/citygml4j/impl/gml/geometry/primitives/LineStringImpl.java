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
package org.citygml4j.impl.gml.geometry.primitives;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.Coordinates;
import org.citygml4j.model.gml.geometry.primitives.Coord;
import org.citygml4j.model.gml.geometry.primitives.DirectPosition;
import org.citygml4j.model.gml.geometry.primitives.DirectPositionList;
import org.citygml4j.model.gml.geometry.primitives.LineString;
import org.citygml4j.model.gml.geometry.primitives.PointProperty;
import org.citygml4j.model.gml.geometry.primitives.PointRep;
import org.citygml4j.model.gml.geometry.primitives.PosOrPointPropertyOrPointRepOrCoord;

public class LineStringImpl extends AbstractCurveImpl implements LineString {
	private List<PosOrPointPropertyOrPointRepOrCoord> controlPoints;
	private DirectPositionList posList;
	private Coordinates coordinates;

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		List<Double> points = toList3d();

		for (int i = 0; i < points.size(); i += 3)
			bbox.update(points.get(i), points.get(i + 1), points.get(i + 2));

		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.LINE_STRING;
	}

	public void addCoord(Coord coord) {
		if (controlPoints == null)
			controlPoints = new ChildList<PosOrPointPropertyOrPointRepOrCoord>(this);

		controlPoints.add(new PosOrPointPropertyOrPointRepOrCoordImpl(coord));
	}

	public void addPointProperty(PointProperty pointProperty) {
		if (controlPoints == null)
			controlPoints = new ChildList<PosOrPointPropertyOrPointRepOrCoord>(this);

		controlPoints.add(new PosOrPointPropertyOrPointRepOrCoordImpl(pointProperty));
	}

	public void addPointRep(PointRep pointRep) {
		if (controlPoints == null)
			controlPoints = new ChildList<PosOrPointPropertyOrPointRepOrCoord>(this);

		controlPoints.add(new PosOrPointPropertyOrPointRepOrCoordImpl(pointRep));
	}

	public void addPos(DirectPosition pos) {
		if (controlPoints == null)
			controlPoints = new ChildList<PosOrPointPropertyOrPointRepOrCoord>(this);

		controlPoints.add(new PosOrPointPropertyOrPointRepOrCoordImpl(pos));
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
		LineString copy = (target == null) ? new LineStringImpl() : (LineString)target;
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
		return copyTo(new LineStringImpl(), copyBuilder);
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
