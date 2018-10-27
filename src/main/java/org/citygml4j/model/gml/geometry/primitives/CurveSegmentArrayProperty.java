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
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.ArrayAssociation;

import java.util.List;

public class CurveSegmentArrayProperty extends ArrayAssociation<AbstractCurveSegment> {

	public CurveSegmentArrayProperty() {
		
	}
	
	public CurveSegmentArrayProperty(AbstractCurveSegment abstractCurveSegment) {
		super(abstractCurveSegment);
	}
	
	public CurveSegmentArrayProperty(List<AbstractCurveSegment> abstractCurveSegment) {
		super(abstractCurveSegment);
	}
	
	public CurveSegmentArrayProperty(AbstractCurveSegment... abstractCurveSegment) {
		super(abstractCurveSegment);
	}
	
	public void addCurveSegment(AbstractCurveSegment curveSegment) {
		super.addObject(curveSegment);
	}

	public List<? extends AbstractCurveSegment> getCurveSegment() {
		return super.getObject();
	}

	public boolean isSetCurveSegment() {
		return super.isSetObject();
	}

	@SuppressWarnings("unchecked")
	public void setCurveSegment(List<? extends AbstractCurveSegment> curveSegment) {
		super.setObject((List<AbstractCurveSegment>)curveSegment);
	}

	public void unsetCurveSegment() {
		super.unsetObject();
	}

	public boolean unsetCurveSegment(AbstractCurveSegment curveSegment) {
		return super.unsetObject(curveSegment);
	}

	public GMLClass getGMLClass() {
		return GMLClass.CURVE_SEGMENT_ARRAY_PROPERTY;
	}

	public Class<AbstractCurveSegment> getAssociableClass() {
		return AbstractCurveSegment.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CurveSegmentArrayProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CurveSegmentArrayProperty copy = (target == null) ? new CurveSegmentArrayProperty() : (CurveSegmentArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
