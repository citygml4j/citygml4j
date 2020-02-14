/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.CoordinateListProvider;

import java.util.ArrayList;
import java.util.List;

public class PosOrPointPropertyOrPointRepOrCoord implements GML, Child, Copyable, CoordinateListProvider {
	private DirectPosition pos;
	private PointProperty pointProperty;
	private PointRep pointRep;
	private Coord coord;
	private ModelObject parent;
	
	public PosOrPointPropertyOrPointRepOrCoord() {
		
	}
	
	public PosOrPointPropertyOrPointRepOrCoord(DirectPosition pos) {
		setPos(pos);
	}
	
	public PosOrPointPropertyOrPointRepOrCoord(PointProperty pointProperty) {
		setPointProperty(pointProperty);
	}
	
	public PosOrPointPropertyOrPointRepOrCoord(PointRep pointRep) {
		setPointRep(pointRep);
	}
	
	public PosOrPointPropertyOrPointRepOrCoord(Coord coord) {
		setCoord(coord);
	}
	
	public PointProperty getPointProperty() {
		return pointProperty;
	}

	public PointRep getPointRep() {
		return pointRep;
	}

	public DirectPosition getPos() {
		return pos;
	}

	public Coord getCoord() {
		return coord;
	}

	public boolean isSetPointProperty() {
		return pointProperty != null;
	}

	public boolean isSetPointRep() {
		return pointRep != null;
	}

	public boolean isSetPos() {
		return pos != null;
	}

	public boolean isSetCoord() {
		return coord != null;
	}

	public void setPos(DirectPosition pos) {
		this.pos = ModelObjects.setParent(pos, this);
		unsetPointProperty();
		unsetPointRep();
		unsetCoord();
	}

	public void setPointProperty(PointProperty pointProperty) {
		this.pointProperty = ModelObjects.setParent(pointProperty, this);
		unsetPointRep();
		unsetPos();
		unsetCoord();
	}

	public void setPointRep(PointRep pointRep) {
		this.pointRep = ModelObjects.setParent(pointRep, this);
		unsetPointProperty();
		unsetPos();
		unsetCoord();
	}

	public void setCoord(Coord coord) {
		this.coord = ModelObjects.setParent(coord, this);
		unsetPointProperty();
		unsetPointRep();
		unsetPos();
	}

	@Override
	public List<Double> toList3d() {
		List<Double> tmp = new ArrayList<>();

		if (isSetPos())
			tmp.addAll(pos.toList3d());
		else if (isSetPointProperty() && pointProperty.isSetPoint())
			tmp.addAll(pointProperty.getPoint().toList3d());
		else if (isSetPointRep() && pointRep.isSetPoint())
			tmp.addAll(pointRep.getPoint().toList3d());
		else if (isSetCoord())
			tmp.addAll(coord.toList3d());

		return tmp;
	}

	public void unsetPointProperty() {
		pointProperty = ModelObjects.setNull(pointProperty);
	}

	public void unsetPointRep() {
		pointRep = ModelObjects.setNull(pointRep);
	}

	public void unsetPos() {
		pos = ModelObjects.setNull(pos);
	}
	
	public void unsetCoord() {
		coord = ModelObjects.setNull(coord);
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
	
	public GMLClass getGMLClass() {
		return GMLClass.POS_OR_POINT_PROPERTY_OR_POINT_REP_OR_COORD;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PosOrPointPropertyOrPointRepOrCoord(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PosOrPointPropertyOrPointRepOrCoord copy = (target == null) ? new PosOrPointPropertyOrPointRepOrCoord() : (PosOrPointPropertyOrPointRepOrCoord)target;
		
		if (isSetPointProperty()) {
			copy.setPointProperty((PointProperty)copyBuilder.copy(pointProperty));
			if (copy.getPointProperty() == pointProperty)
				pointProperty.setParent(this);
		}
		
		if (isSetPointRep()) {
			copy.setPointRep((PointRep)copyBuilder.copy(pointRep));
			if (copy.getPointRep() == pointRep)
				pointRep.setParent(this);
		}
		
		if (isSetPos()) {
			copy.setPos((DirectPosition)copyBuilder.copy(pos));
			if (copy.getPos() == pos)
				pos.setParent(this);
		}
		
		if (isSetCoord()) {
			copy.setCoord((Coord)copyBuilder.copy(coord));
			if (copy.getCoord() == coord)
				coord.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
