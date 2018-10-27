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
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;

import java.util.List;

public class Polygon extends AbstractSurface {
	private AbstractRingProperty exterior;
	private List<AbstractRingProperty> interior;

	public void addInterior(AbstractRingProperty abstractRingProperty) {
		if (interior == null)
			interior = new ChildList<AbstractRingProperty>(this);

		interior.add(abstractRingProperty);
	}

	public AbstractRingProperty getExterior() {
		return exterior;
	}

	public List<AbstractRingProperty> getInterior() {
		if (interior == null)
			interior = new ChildList<AbstractRingProperty>(this);

		return interior;
	}

	public boolean isSetExterior() {
		return exterior != null;
	}

	public boolean isSetInterior() {
		return interior != null && !interior.isEmpty();
	}

	public void setExterior(AbstractRingProperty abstractRingProperty) {
		if (abstractRingProperty != null)
			abstractRingProperty.setParent(this);

		exterior = abstractRingProperty;
	}

	public void setInterior(List<AbstractRingProperty> abstractRingProperty) {
		interior = new ChildList<AbstractRingProperty>(this, abstractRingProperty);
	}

	public void unsetExterior() {
		if (isSetExterior())
			exterior.unsetParent();

		exterior = null;
	}

	public void unsetInterior() {
		if (isSetInterior())
			interior.clear();

		interior = null;
	}

	public boolean unsetInterior(AbstractRingProperty abstractRingProperty) {
		return isSetInterior() ? interior.remove(abstractRingProperty) : false;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetExterior() && exterior.isSetRing())
			bbox.update(exterior.getRing().calcBoundingBox());
		
		return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.POLYGON;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Polygon(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Polygon copy = (target == null) ? new Polygon() : (Polygon)target;
		super.copyTo(copy, copyBuilder);

		if (isSetExterior()) {
			copy.setExterior((AbstractRingProperty)copyBuilder.copy(exterior));
			if (copy.getExterior() == exterior)
				exterior.setParent(this);
		}

		if (isSetInterior()) {
			for (AbstractRingProperty part : interior) {
				AbstractRingProperty copyPart = (AbstractRingProperty)copyBuilder.copy(part);
				copy.addInterior(copyPart);

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
