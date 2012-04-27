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
package org.citygml4j.model.gml.geometry.primitives;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.Coordinates;

public class LineStringSegment extends AbstractCurveSegment {
	private List<PosOrPointPropertyOrPointRep> controlPoints;
	private DirectPositionList posList;
	private Coordinates coordinates;
	private CurveInterpolation interpolation;

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.LINE_STRING_SEGMENT;
	}

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

	public void addPointProperty(PointProperty pointProperty) {
		if (controlPoints == null)
			controlPoints = new ChildList<PosOrPointPropertyOrPointRep>(this);

		controlPoints.add(new PosOrPointPropertyOrPointRep(pointProperty));
	}

	public void addPointRep(PointRep pointRep) {
		if (controlPoints == null)
			controlPoints = new ChildList<PosOrPointPropertyOrPointRep>(this);

		controlPoints.add(new PosOrPointPropertyOrPointRep(pointRep));
	}

	public void addPos(DirectPosition pos) {
		if (controlPoints == null)
			controlPoints = new ChildList<PosOrPointPropertyOrPointRep>(this);

		controlPoints.add(new PosOrPointPropertyOrPointRep(pos));
	}

	public void addControlPoint(PosOrPointPropertyOrPointRep controlPoint) {
		if (controlPoints == null)
			controlPoints = new ChildList<PosOrPointPropertyOrPointRep>(this);

		controlPoints.add(controlPoint);
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public CurveInterpolation getInterpolation() {
		if (interpolation == null)
			return CurveInterpolation.LINEAR;
		else 
			return interpolation;
	}

	public DirectPositionList getPosList() {
		return posList;
	}

	public List<PosOrPointPropertyOrPointRep> getPosOrPointPropertyOrPointRep() {
		if (controlPoints == null)
			controlPoints = new ChildList<PosOrPointPropertyOrPointRep>(this);

		return controlPoints;
	}

	public boolean isSetCoordinates() {
		return coordinates != null;
	}

	public boolean isSetInterpolation() {
		return interpolation != null;
	}

	public boolean isSetPosList() {
		return posList != null;
	}

	public boolean isSetPosOrPointPropertyOrPointRep() {
		return controlPoints != null && !controlPoints.isEmpty();
	}

	public void setCoordinates(Coordinates coordinates) {
		if (coordinates != null)
			coordinates.setParent(this);

		this.coordinates = coordinates;
	}

	public void setInterpolation(CurveInterpolation interpolation) {
		this.interpolation = CurveInterpolation.LINEAR;
	}

	public void setPosList(DirectPositionList posList) {
		if (posList != null)
			posList.setParent(this);

		this.posList = posList;
	}

	public void setPosOrPointPropertyOrPointRep(List<PosOrPointPropertyOrPointRep> controlPoints) {
		this.controlPoints = new ChildList<PosOrPointPropertyOrPointRep>(this, controlPoints);
	}

	public List<Double> toList3d() {
		List<Double> tmp = new ArrayList<Double>();

		if (isSetPosList()) 
			tmp.addAll(posList.toList3d());

		if (isSetPosOrPointPropertyOrPointRep())
			for (PosOrPointPropertyOrPointRep controlPoint : controlPoints)
				controlPoint.toList3d();

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

	public void unsetInterpolation() {
		interpolation = null;
	}

	public void unsetPosList() {
		if (isSetPosList())
			posList.unsetParent();

		posList = null;
	}

	public boolean unsetPosOrPointPropertyOrPointRep(PosOrPointPropertyOrPointRep controlPoint) {
		return isSetPosOrPointPropertyOrPointRep() ? controlPoints.remove(controlPoint) : false;	}

	public boolean unsetPointProperty(PointProperty pointProperty) {
		boolean success = false;

		if (isSetPosOrPointPropertyOrPointRep()) {
			Iterator<PosOrPointPropertyOrPointRep> iter = controlPoints.iterator();
			while (iter.hasNext()) {
				PosOrPointPropertyOrPointRep controlPoint = iter.next();

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

		if (isSetPosOrPointPropertyOrPointRep()) {
			Iterator<PosOrPointPropertyOrPointRep> iter = controlPoints.iterator();
			while (iter.hasNext()) {
				PosOrPointPropertyOrPointRep controlPoint = iter.next();

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

		if (isSetPosOrPointPropertyOrPointRep()) {
			Iterator<PosOrPointPropertyOrPointRep> iter = controlPoints.iterator();
			while (iter.hasNext()) {
				PosOrPointPropertyOrPointRep controlPoint = iter.next();

				if (controlPoint != null && controlPoint.getPos().equals(pos)) {
					iter.remove();
					success = true;
					break;
				}
			}
		}

		return success;
	}

	public void unsetPosOrPointPropertyOrPointRep() {
		if (isSetPosOrPointPropertyOrPointRep())
			controlPoints.clear();

		controlPoints = null;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		LineStringSegment copy = (target == null) ? new LineStringSegment() : (LineStringSegment)target;
		super.copyTo(copy, copyBuilder);

		if (isSetPosOrPointPropertyOrPointRep()) {
			for (PosOrPointPropertyOrPointRep part : controlPoints) {
				PosOrPointPropertyOrPointRep copyPart = (PosOrPointPropertyOrPointRep)copyBuilder.copy(part);
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

		if (isSetInterpolation())
			copy.setInterpolation((CurveInterpolation)copyBuilder.copy(interpolation));

		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new LineStringSegment(), copyBuilder);
	}

}
