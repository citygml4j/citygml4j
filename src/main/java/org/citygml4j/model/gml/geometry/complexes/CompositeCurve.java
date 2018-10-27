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
package org.citygml4j.model.gml.geometry.complexes;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractCurve;
import org.citygml4j.model.gml.geometry.primitives.CurveProperty;

import java.util.Arrays;
import java.util.List;

public class CompositeCurve extends AbstractCurve {
	private List<CurveProperty> curveMember;
	
	public CompositeCurve() {
		
	}
	
	public CompositeCurve(List<? extends AbstractCurve> abstractCurves) {
		for (AbstractCurve abstractCurve : abstractCurves)
			addCurveMember(new CurveProperty(abstractCurve));
	}
	
	public CompositeCurve(AbstractCurve... abstractCurves) {
		this(Arrays.asList(abstractCurves));
	}
	
	public void addCurveMember(CurveProperty curveMember) {
		if (this.curveMember == null)
			this.curveMember = new ChildList<CurveProperty>(this);
		
		this.curveMember.add(curveMember);
	}

	public List<CurveProperty> getCurveMember() {
		if (curveMember == null)
			curveMember = new ChildList<CurveProperty>(this);
		
		return curveMember;
	}

	public boolean isSetCurveMember() {
		return curveMember != null && !curveMember.isEmpty();
	}

	public void setCurveMember(List<CurveProperty> curveMember) {
		this.curveMember = new ChildList<CurveProperty>(this, curveMember);
	}

	public void unsetCurveMember() {
		if (isSetCurveMember())
			curveMember.clear();
		
		curveMember = null;
	}

	public boolean unsetCurveMember(CurveProperty curveMember) {
		return isSetCurveMember() ? this.curveMember.remove(curveMember) : false;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetCurveMember()) {
			for (CurveProperty curvePropery : getCurveMember())
				if (curvePropery.isSetCurve())
					bbox.update(curvePropery.getCurve().calcBoundingBox());
		}
		
		return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.COMPOSITE_CURVE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CompositeCurve(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CompositeCurve copy = (target == null) ? new CompositeCurve() : (CompositeCurve)target;
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
