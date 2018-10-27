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
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.ArrayAssociation;

import java.util.List;

public class LineStringSegmentArrayProperty extends ArrayAssociation<LineStringSegment> {
	
	public LineStringSegmentArrayProperty() {

	}

	public LineStringSegmentArrayProperty(LineStringSegment lineStringSegment) {
		super(lineStringSegment);
	}

	public LineStringSegmentArrayProperty(List<LineStringSegment> lineStringSegment) {
		super(lineStringSegment);
	}
	
	public LineStringSegmentArrayProperty(LineStringSegment... lineStringSegment) {
		super(lineStringSegment);
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.LINE_STRING_SEGMENT_ARRAY_PROPERTY;
	}

	public void addLineStringSegment(LineStringSegment lineStringSegment) {
		super.addObject(lineStringSegment);
	}

	public List<LineStringSegment> getLineStringSegment() {
		return super.getObject();
	}

	public boolean isSetLineStringSegment() {
		return super.isSetObject();
	}

	public void setLineStringSegment(List<LineStringSegment> lineStringSegment) {
		super.setObject(lineStringSegment);
	}

	public void unsetLineStringSegment() {
		super.unsetObject();
	}

	public boolean unsetLineStringSegment(LineStringSegment lineStringSegment) {
		return super.unsetObject(lineStringSegment);
	}

	public Class<LineStringSegment> getAssociableClass() {
		return LineStringSegment.class;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		LineStringSegmentArrayProperty copy = (target == null) ? new LineStringSegmentArrayProperty() : (LineStringSegmentArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new LineStringSegmentArrayProperty(), copyBuilder);
	}
	
}
