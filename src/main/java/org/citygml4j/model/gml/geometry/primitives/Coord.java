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
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

import java.util.ArrayList;
import java.util.List;

public class Coord implements GML, Child, Copyable {
	private Double x;
	private Double y;
	private Double z;
	private ModelObject parent;
	
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
