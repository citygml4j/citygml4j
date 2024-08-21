/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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

public class OrientableCurve extends AbstractCurve {
	private CurveProperty baseCurve;
	private Sign orientation;

	public OrientableCurve() {
		
	}
	
	public OrientableCurve(AbstractCurve base, Sign orientation) {
		setBaseCurve(new CurveProperty(base));
		setOrientation(orientation);
	}
	
	public OrientableCurve(String xlink, Sign orientation) {
		setBaseCurve(new CurveProperty(xlink));
		setOrientation(orientation);
	}
	
	public CurveProperty getBaseCurve() {
		return baseCurve;
	}

	public Sign getOrientation() {
		return orientation == null ? Sign.PLUS : orientation;
	}

	public boolean isSetBaseCurve() {
		return baseCurve != null;
	}

	public boolean isSetOrientation() {
		return orientation != null;
	}

	public void setBaseCurve(CurveProperty baseCurve) {
		this.baseCurve = ModelObjects.setParent(baseCurve, this);
	}

	public void setOrientation(Sign orientation) {
		this.orientation = orientation;
	}

	public void unsetBaseCurve() {
		baseCurve = ModelObjects.setNull(baseCurve);
	}

	public void unsetOrientation() {
		orientation = null;
	}

	public GMLClass getGMLClass() {
		return GMLClass.ORIENTABLE_CURVE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new OrientableCurve(), copyBuilder);
	}

	@Override
	public List<Double> toList3d() {
		return isSetBaseCurve() && baseCurve.isSetCurve() ?
				baseCurve.getCurve().toList3d(getOrientation() == Sign.MINUS) :
				new ArrayList<>();
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		OrientableCurve copy = (target == null) ? new OrientableCurve() : (OrientableCurve)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetBaseCurve()) {
			copy.setBaseCurve((CurveProperty)copyBuilder.copy(baseCurve));
			if (copy.getBaseCurve() == baseCurve)
				baseCurve.setParent(this);
		}
		
		if (isSetOrientation())
			copy.setOrientation((Sign)copyBuilder.copy(orientation));
		
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
