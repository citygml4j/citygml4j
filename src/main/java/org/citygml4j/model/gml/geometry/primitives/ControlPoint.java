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
package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

import java.util.ArrayList;
import java.util.List;

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
