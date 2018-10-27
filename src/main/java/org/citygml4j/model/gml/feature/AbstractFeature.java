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
package org.citygml4j.model.gml.feature;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public abstract class AbstractFeature extends AbstractGML {
	private BoundingShape boundedBy;
	private LocationProperty location;
	private List<ADEGenericElement> genericADEElement;

	public void addGenericADEElement(ADEGenericElement genericADEElement) {
		if (this.genericADEElement == null)
			this.genericADEElement = new ChildList<ADEGenericElement>(this);
		
		this.genericADEElement.add(genericADEElement);
	}
	
	public BoundingShape getBoundedBy() {
		return boundedBy;
	}

	public LocationProperty getLocation() {
		return location;
	}
	
	public List<ADEGenericElement> getGenericADEElement() {
		if (genericADEElement == null)
			genericADEElement = new ChildList<ADEGenericElement>(this);
		
		return genericADEElement;
	}

	public boolean isSetBoundedBy() {
		return boundedBy != null;
	}

	public boolean isSetLocation() {
		return location != null;
	}
	
	public boolean isSetGenericADEElement() {
		return genericADEElement != null && !genericADEElement.isEmpty();
	}
	
	public void setBoundedBy(BoundingShape boundingShape) {
		if (boundingShape != null) {
			if (boundingShape.isEmpty())
				return;
			
			boundingShape.setParent(this);
		}

		boundedBy = boundingShape;
	}

	public void setLocation(LocationProperty location) {
		if (location != null)
			location.setParent(this);

		this.location = location;
	}
	
	public void setGenericADEElement(List<ADEGenericElement> genericADEElement) {
		this.genericADEElement = new ChildList<ADEGenericElement>(this, genericADEElement);
	}

	public void unsetBoundedBy() {
		if (boundedBy != null)
			boundedBy.unsetParent();

		boundedBy = null;
	}

	public void unsetLocation() {
		if (location != null)
			location.unsetParent();

		location = null;
	}
	
	public void unsetGenericADEElement() {
		if (isSetGenericADEElement())
			genericADEElement.clear();
		
		genericADEElement = null;
	}

	public boolean unsetGenericADEElement(ADEGenericElement genericADEElement) {
		return isSetGenericADEElement() ? this.genericADEElement.remove(genericADEElement) : false;
	}

	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACT_FEATURE;
	}

	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		return (options.isUseExistingEnvelopes() && boundedBy != null && !boundedBy.isEmpty()) ? boundedBy : new BoundingShape();
	}
	
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractFeature copy = (AbstractFeature)target;
		super.copyTo(copy, copyBuilder);

		if (isSetBoundedBy()) {
			copy.setBoundedBy((BoundingShape)copyBuilder.copy(boundedBy));
			if (copy.getBoundedBy() == boundedBy)
				boundedBy.setParent(this);
		}

		if (isSetLocation()) {
			copy.setLocation((LocationProperty)copyBuilder.copy(location));
			if (copy.getLocation() == location)
				location.setParent(this);
		}
		
		if (isSetGenericADEElement()) {
			for (ADEGenericElement part : genericADEElement) {
				ADEGenericElement copyPart = (ADEGenericElement)copyBuilder.copy(part);
				copy.addGenericADEElement(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}
	
	public abstract void accept(FeatureVisitor visitor);
	public abstract <T> T accept(FeatureFunctor<T> visitor);

}
