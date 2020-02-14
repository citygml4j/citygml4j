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
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;

import java.util.ArrayList;
import java.util.List;

public class Ring extends AbstractRing {
	private List<CurveProperty> curveMember;

	public void addCurveMember(CurveProperty curveMember) {
		getCurveMember().add(curveMember);
	}

	public List<CurveProperty> getCurveMember() {
		if (curveMember == null)
			curveMember = new ChildList<>(this);

		return curveMember;
	}

	public boolean isSetCurveMember() {
		return curveMember != null && !curveMember.isEmpty();
	}

	public void setCurveMember(List<CurveProperty> curveMember) {
		this.curveMember = new ChildList<>(this, curveMember);
	}

	public void unsetCurveMember() {
		curveMember = ModelObjects.setNull(curveMember);
	}

	public boolean unsetCurveMember(CurveProperty curveMember) {
		return isSetCurveMember() && this.curveMember.remove(curveMember);
	}

	public GMLClass getGMLClass() {
		return GMLClass.RING;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Ring(), copyBuilder);
	}

	@Override
	public List<Double> toList3d() {
		if (isSetCurveMember()) {
			List<Double> coordinates = new ArrayList<>();
			for (CurveProperty property : curveMember) {
				if (property != null && property.isSetCurve()) {
					List<Double> candidates = property.getCurve().toList3d();
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
		Ring copy = (target == null) ? new Ring() : (Ring)target;
		super.copyTo(copy, copyBuilder);

		if (isSetCurveMember()) {
			for (CurveProperty part : curveMember) {
				CurveProperty copyPart = (CurveProperty)copyBuilder.copy(part);
				copy.addCurveMember(copyPart);

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
