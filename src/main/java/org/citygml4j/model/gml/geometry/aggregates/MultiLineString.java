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
package org.citygml4j.model.gml.geometry.aggregates;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.LineString;
import org.citygml4j.model.gml.geometry.primitives.LineStringProperty;

import java.util.Arrays;
import java.util.List;

public class MultiLineString extends AbstractGeometricAggregate {
	private List<LineStringProperty> lineStringMember;		
	
	public MultiLineString() {
		
	}
	
	public MultiLineString(List<LineString> lineStrings) {
		for (LineString lineString : lineStrings)
			addLineStringMember(new LineStringProperty(lineString));
	}
	
	public MultiLineString(LineString... lineStrings) {
		this(Arrays.asList(lineStrings));
	}
	
	public void addLineStringMember(LineStringProperty lineStringMember) {
		if (this.lineStringMember == null)
			this.lineStringMember = new ChildList<LineStringProperty>(this);
		
		this.lineStringMember.add(lineStringMember);
	}

	public List<LineStringProperty> getLineStringMember() {
		if (lineStringMember == null)
			lineStringMember = new ChildList<LineStringProperty>(this);
		
		return lineStringMember;
	}

	public boolean isSetLineStringMember() {
		return lineStringMember != null && !lineStringMember.isEmpty();
	}

	public void setLineStringMember(List<LineStringProperty> lineStringMember) {
		this.lineStringMember = new ChildList<LineStringProperty>(this, lineStringMember);
	}

	public void unsetLineStringMember() {
		if (isSetLineStringMember())
			lineStringMember.clear();
		
		lineStringMember = null;
	}

	public boolean unsetLineStringMember(LineStringProperty lineStringMember) {
		return isSetLineStringMember() ? this.lineStringMember.remove(lineStringMember) : false;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetLineStringMember()) {
			for (LineStringProperty lineStringProperty : getLineStringMember())
				if (lineStringProperty.isSetLineString())
					bbox.update(lineStringProperty.getLineString().calcBoundingBox());
		}
		
		return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_LINE_STRING;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiLineString(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiLineString copy = (target == null) ? new MultiLineString() : (MultiLineString)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetLineStringMember()) {
			for (LineStringProperty part : lineStringMember) {
				LineStringProperty copyPart = (LineStringProperty)copyBuilder.copy(part);
				copy.addLineStringMember(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
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
