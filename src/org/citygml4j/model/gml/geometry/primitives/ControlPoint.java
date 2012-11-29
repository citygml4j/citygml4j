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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.gml.geometry.primitives;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

public class ControlPoint implements GML, Child, Copyable {
	private DirectPositionList posList;
	private List<GeometricPositionGroup> geometricPositionGroup;
	private ModelObject parent;
	
	public void addGeometricPositionGroup(GeometricPositionGroup geometricPositionGroup) {
		if (this.geometricPositionGroup == null)
			this.geometricPositionGroup = new ChildList<GeometricPositionGroup>(this);
		
		this.geometricPositionGroup.add(geometricPositionGroup);
		unsetPosList();
	}

	public List<GeometricPositionGroup> getGeometricPositionGroup() {
		if (geometricPositionGroup == null)
			geometricPositionGroup = new ChildList<GeometricPositionGroup>(this);
		
		return geometricPositionGroup;
	}

	public DirectPositionList getPosList() {
		return posList;
	}

	public boolean isSetGeometricPositionGroup() {
		return geometricPositionGroup != null && !geometricPositionGroup.isEmpty();
	}

	public boolean isSetPosList() {
		return posList != null;
	}

	public void setGeometricPositionGroup(List<GeometricPositionGroup> geometricPositionGroup) {
		this.geometricPositionGroup = new ChildList<GeometricPositionGroup>(this, geometricPositionGroup);
		unsetPosList();
	}

	public void setPosList(DirectPositionList posList) {
		if (posList != null)
			posList.setParent(this);
		
		this.posList = posList;
		unsetGeometricPositionGroup();
	}

	public List<Double> toList3d() {
		List<Double> tmp = new ArrayList<Double>();
		
		if (isSetPosList())
			tmp.addAll(posList.toList3d());
		else if (isSetGeometricPositionGroup())
			for (GeometricPositionGroup part : geometricPositionGroup)
				tmp.addAll(part.toList3d());
		
		return tmp;
	}

	public void unsetGeometricPositionGroup() {
		if (isSetGeometricPositionGroup())
			geometricPositionGroup.clear();
		
		geometricPositionGroup = null;
	}

	public boolean unsetGeometricPositionGroup(GeometricPositionGroup geometricPositionGroup) {
		return isSetGeometricPositionGroup() ? this.geometricPositionGroup.remove(geometricPositionGroup) : false;
	}

	public void unsetPosList() {
		if (isSetPosList())
			posList.unsetParent();
		
		posList = null;
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.CONTROL_POINT;
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

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ControlPoint(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ControlPoint copy = (target == null) ? new ControlPoint() : (ControlPoint)target;
		
		if (isSetGeometricPositionGroup()) {
			for (GeometricPositionGroup part : geometricPositionGroup) {
				GeometricPositionGroup copyPart = (GeometricPositionGroup)copyBuilder.copy(part);
				copy.addGeometricPositionGroup(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetPosList()) {
			copy.setPosList((DirectPositionList)copyBuilder.copy(posList));
			if (copy.getPosList() == posList)
				posList.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
