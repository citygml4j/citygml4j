/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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
 * 
 * $Id$
 */
package org.citygml4j.model.gml.geometry.primitives;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

public class Coord implements GML, Child, Copyable {
	private Double x;
	private Double y;
	private Double z;
	private ModelObject parent;
	
	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.COORD;
	}

	public Double getX() {
		return x;
	}

	public Double getY() {
		return y;
	}

	public Double getZ() {
		return z;
	}

	public boolean isSetX() {
		return x != null;
	}

	public boolean isSetY() {
		return y != null;
	}

	public boolean isSetZ() {
		return z != null;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public void setZ(Double z) {
		this.z = z;
	}

	public List<Double> toList3d() {
		List<Double> tmp = new ArrayList<Double>();
		
		if (isSetX() && isSetY()) {
			tmp.add(x);
			tmp.add(y);			
			tmp.add(isSetZ() ? z : 0.0);
		}
		
		return tmp;
	}

	public void unsetX() {
		x = null;
	}

	public void unsetY() {
		y = null;
	}

	public void unsetZ() {
		z = null;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Coord copy = (target == null) ? new Coord() : (Coord)target;
		
		if (isSetX())
			copy.setX((Double)copyBuilder.copy(x));
		
		if (isSetY())
			copy.setY((Double)copyBuilder.copy(y));
		
		if (isSetZ())
			copy.setZ((Double)copyBuilder.copy(z));
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Coord(), copyBuilder);
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

}
