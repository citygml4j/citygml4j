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
package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.Coordinates;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LineStringSegment extends AbstractCurveSegment {
	private List<PosOrPointPropertyOrPointRep> controlPoints;
	private DirectPositionList posList;
	private Coordinates coordinates;
	private CurveInterpolation interpolation;

	public GMLClass getGMLClass() {
		return GMLClass.LINE_STRING_SEGMENT;
	}

	public void addPointProperty(PointProperty pointProperty) {
		getPosOrPointPropertyOrPointRep().add(new PosOrPointPropertyOrPointRep(pointProperty));
	}

	public void addPointRep(PointRep pointRep) {
		getPosOrPointPropertyOrPointRep().add(new PosOrPointPropertyOrPointRep(pointRep));
	}

	public void addPos(DirectPosition pos) {
		getPosOrPointPropertyOrPointRep().add(new PosOrPointPropertyOrPointRep(pos));
	}

	public void addControlPoint(PosOrPointPropertyOrPointRep controlPoint) {
		getPosOrPointPropertyOrPointRep().add(controlPoint);
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public CurveInterpolation getInterpolation() {
		return interpolation == null ? CurveInterpolation.LINEAR : interpolation;
	}

	public DirectPositionList getPosList() {
		return posList;
	}

	public List<PosOrPointPropertyOrPointRep> getPosOrPointPropertyOrPointRep() {
		if (controlPoints == null)
			controlPoints = new ChildList<>(this);

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
		this.coordinates = ModelObjects.setParent(coordinates, this);
	}

	public void setInterpolation(CurveInterpolation interpolation) {
		this.interpolation = CurveInterpolation.LINEAR;
	}

	public void setPosList(DirectPositionList posList) {
		this.posList = ModelObjects.setParent(posList, this);
	}

	public void setPosOrPointPropertyOrPointRep(List<PosOrPointPropertyOrPointRep> controlPoints) {
		this.controlPoints = new ChildList<>(this, controlPoints);
	}

	@Override
	public List<Double> toList3d() {
		List<Double> tmp = new ArrayList<>();

		if (isSetPosList()) 
			tmp.addAll(posList.toList3d());

		if (isSetPosOrPointPropertyOrPointRep())
			for (PosOrPointPropertyOrPointRep controlPoint : controlPoints)
				controlPoint.toList3d();

		if (isSetCoordinates())
			tmp.addAll(coordinates.toList3d());

		return tmp;
	}

	public void unsetCoordinates() {
		coordinates = ModelObjects.setNull(coordinates);
	}

	public void unsetInterpolation() {
		interpolation = null;
	}

	public void unsetPosList() {
		posList = ModelObjects.setNull(posList);
	}

	public boolean unsetPosOrPointPropertyOrPointRep(PosOrPointPropertyOrPointRep controlPoint) {
		return isSetPosOrPointPropertyOrPointRep() && controlPoints.remove(controlPoint);	}

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
		controlPoints = ModelObjects.setNull(controlPoints);
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
