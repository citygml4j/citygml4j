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
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;

public class Curve extends AbstractCurve {
	private CurveSegmentArrayProperty segments;
	
	public CurveSegmentArrayProperty getSegments() {
		return segments;
	}

	public boolean isSetSegments() {
		return segments != null;
	}

	public void setSegments(CurveSegmentArrayProperty segments) {
		if (segments != null)
			segments.setParent(this);
		
		this.segments = segments;
	}

	public void unsetSegments() {
		if (isSetSegments())
			segments.unsetParent();
		
		segments = null;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetSegments()) {
			CurveSegmentArrayProperty arrayProperty = getSegments();
			
			if (arrayProperty.isSetCurveSegment())
				for (AbstractCurveSegment curveSegment : arrayProperty.getCurveSegment())
					bbox.update(curveSegment.calcBoundingBox());
		}
		
		return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.CURVE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Curve(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Curve copy = (target == null) ? new Curve() : (Curve)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetSegments()) {
			copy.setSegments((CurveSegmentArrayProperty)copyBuilder.copy(segments));
			if (copy.getSegments() == segments)
				segments.setParent(this);
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
