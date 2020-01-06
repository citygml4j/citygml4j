/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2019 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;

import java.util.ArrayList;
import java.util.List;

public class Curve extends AbstractCurve {
	private CurveSegmentArrayProperty segments;
	
	public CurveSegmentArrayProperty getSegments() {
		return segments;
	}

	public boolean isSetSegments() {
		return segments != null;
	}

	public void setSegments(CurveSegmentArrayProperty segments) {
		this.segments = ModelObjects.setParent(segments, this);
	}

	public void unsetSegments() {
		segments = ModelObjects.setNull(segments);
	}

	public GMLClass getGMLClass() {
		return GMLClass.CURVE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Curve(), copyBuilder);
	}

	@Override
	public List<Double> toList3d() {
		if (segments != null) {
			List<Double> coordinates = new ArrayList<>();
			for (AbstractCurveSegment segment : segments.getCurveSegment()) {
				if (segment != null) {
					List<Double> candidates = segment.toList3d();
					if (!candidates.isEmpty()) {
						int size = coordinates.size();
						if (size == 0)
							coordinates.addAll(candidates);
						else {
							if (candidates.get(0).doubleValue() == coordinates.get(size - 3).doubleValue()
									&& candidates.get(1).doubleValue() == coordinates.get(size - 2).doubleValue()
									&& candidates.get(2).doubleValue() == coordinates.get(size - 1).doubleValue())
								coordinates.addAll(candidates.subList(3, candidates.size()));
							else
								coordinates.addAll(candidates);
						}
					}
				}
			}

			return coordinates;
		} else
			return new ArrayList<>();
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
