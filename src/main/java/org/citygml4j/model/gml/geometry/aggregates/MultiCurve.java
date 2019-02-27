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
package org.citygml4j.model.gml.geometry.aggregates;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractCurve;
import org.citygml4j.model.gml.geometry.primitives.CurveArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.CurveProperty;

import java.util.Arrays;
import java.util.List;

public class MultiCurve extends AbstractGeometricAggregate {
	private List<CurveProperty> curveMember;
	private CurveArrayProperty curveMembers;
	
	public MultiCurve() {
		
	}
	
	public MultiCurve(List<? extends AbstractCurve> abstractCurves) {
		for (AbstractCurve abstractCurve : abstractCurves)
			addCurveMember(new CurveProperty(abstractCurve));
	}
	
	public MultiCurve(AbstractCurve... abstractCurves) {
		this(Arrays.asList(abstractCurves));
	}

	public void addCurveMember(CurveProperty curveMember) {
		getCurveMember().add(curveMember);
	}

	public List<CurveProperty> getCurveMember() {
		if (curveMember == null)
			curveMember = new ChildList<>(this);

		return curveMember;
	}

	public CurveArrayProperty getCurveMembers() {
		return curveMembers;
	}

	public boolean isSetCurveMember() {
		return curveMember != null && !curveMember.isEmpty();
	}

	public boolean isSetCurveMembers() {
		return curveMembers != null;
	}

	public void setCurveMember(List<CurveProperty> curveMember) {
		this.curveMember = new ChildList<>(this, curveMember);
	}

	public void setCurveMembers(CurveArrayProperty curveMembers) {
		this.curveMembers = ModelObjects.setParent(curveMembers, this);
	}

	public void unsetCurveMember() {
		curveMember = ModelObjects.setNull(curveMember);
	}

	public boolean unsetCurveMember(CurveProperty curveMember) {
		return isSetCurveMember() && this.curveMember.remove(curveMember);
	}

	public void unsetCurveMembers() {
		curveMembers = ModelObjects.setNull(curveMembers);
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetCurveMember()) {
			for (CurveProperty curveProperty : getCurveMember()) 
				if (curveProperty.isSetCurve())
					bbox.update(curveProperty.getCurve().calcBoundingBox());
		}

		if (isSetCurveMembers()) {
			CurveArrayProperty curveArrayProperty = getCurveMembers();

			if (curveArrayProperty.isSetCurve())
				for (AbstractCurve abstractCurve : curveArrayProperty.getCurve())
					bbox.update(abstractCurve.calcBoundingBox());
		}
		
		return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_CURVE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiCurve(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiCurve copy = (target == null) ? new MultiCurve() : (MultiCurve)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetCurveMember()) {
			for (CurveProperty part : curveMember) {
				CurveProperty copyPart = (CurveProperty)copyBuilder.copy(part);
				copy.addCurveMember(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetCurveMembers()) {
			copy.setCurveMembers((CurveArrayProperty)copyBuilder.copy(curveMembers));
			if (copy.getCurveMembers() == curveMembers)
				curveMembers.setParent(this);
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
