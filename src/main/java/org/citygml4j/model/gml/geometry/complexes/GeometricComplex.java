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
package org.citygml4j.model.gml.geometry.complexes;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.primitives.AbstractGeometricPrimitive;
import org.citygml4j.model.gml.geometry.primitives.GeometricPrimitiveProperty;

import java.util.Arrays;
import java.util.List;

public class GeometricComplex extends AbstractGeometry {
	private List<GeometricPrimitiveProperty> element;
	
	public GeometricComplex() {
		
	}
	
	public GeometricComplex(List<? extends AbstractGeometricPrimitive> abstractGeometricPrimitives) {
        for (AbstractGeometricPrimitive abstractGeometricPrimitive : abstractGeometricPrimitives)
        	addElement(new GeometricPrimitiveProperty(abstractGeometricPrimitive));
	}
	
	public GeometricComplex(AbstractGeometricPrimitive... abstractGeometricPrimitives) {
		this(Arrays.asList(abstractGeometricPrimitives));
	}
	
	public void addElement(GeometricPrimitiveProperty element) {
		if (this.element == null)
			this.element = new ChildList<GeometricPrimitiveProperty>(this);

		this.element.add(element);
	}

	public List<GeometricPrimitiveProperty> getElement() {
		if (element == null)
			element = new ChildList<GeometricPrimitiveProperty>(this);

		return element;
	}

	public boolean isSetElement() {
		return element != null && !element.isEmpty();
	}

	public void setElement(List<GeometricPrimitiveProperty> element) {
		this.element = new ChildList<GeometricPrimitiveProperty>(this, element);
	}

	public void unsetElement() {
		if (isSetElement())
			element.clear();

		element = null;
	}

	public boolean unsetElement(GeometricPrimitiveProperty element) {
		return isSetElement() ? this.element.remove(element) : false;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetElement()) {
			for (GeometricPrimitiveProperty part : element)
				if (part.isSetGeometricPrimitive())
					bbox.update(part.getGeometricPrimitive().calcBoundingBox());
		}
		
		return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.GEOMETRIC_COMPLEX;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GeometricComplex(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GeometricComplex copy = (target == null) ? new GeometricComplex() : (GeometricComplex)target;
		super.copyTo(copy, copyBuilder);

		if (isSetElement()) {
			for (GeometricPrimitiveProperty part : element) {
				GeometricPrimitiveProperty copyPart = (GeometricPrimitiveProperty)copyBuilder.copy(part);
				copy.addElement(copyPart);

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
