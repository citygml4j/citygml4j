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

public class OrientableSurface extends AbstractSurface {
	private SurfaceProperty baseSurface;
	private Sign orientation;

	public OrientableSurface() {
		
	}
	
	public OrientableSurface(AbstractSurface base, Sign orientation) {
		setBaseSurface(new SurfaceProperty(base));
		setOrientation(orientation);
	}
	
	public OrientableSurface(String xlink, Sign orientation) {
		setBaseSurface(new SurfaceProperty(xlink));
		setOrientation(orientation);
	}
	
	public SurfaceProperty getBaseSurface() {
		return baseSurface;
	}

	public Sign getOrientation() {
		return (orientation == null) ? Sign.PLUS : orientation;
	}

	public boolean isSetBaseSurface() {
		return baseSurface != null;
	}

	public boolean isSetOrientation() {
		return orientation != null;
	}

	public void setBaseSurface(SurfaceProperty baseSurface) {
		if (baseSurface != null)
			baseSurface.setParent(this);

		this.baseSurface = baseSurface;
	}

	public void setOrientation(Sign orientation) {
		this.orientation = orientation;
	}

	public void unsetBaseSurface() {
		if (isSetBaseSurface())
			baseSurface.unsetParent();
		
		baseSurface = null;
	}

	public void unsetOrientation() {
		orientation = null;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetBaseSurface() && baseSurface.isSetSurface())
			bbox.update(baseSurface.getSurface().calcBoundingBox());
		
		return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.ORIENTABLE_SURFACE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new OrientableSurface(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		OrientableSurface copy = (target == null) ? new OrientableSurface() : (OrientableSurface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetBaseSurface()) {
			copy.setBaseSurface((SurfaceProperty)copyBuilder.copy(baseSurface));
			if (copy.getBaseSurface() == baseSurface)
				baseSurface.setParent(this);
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
