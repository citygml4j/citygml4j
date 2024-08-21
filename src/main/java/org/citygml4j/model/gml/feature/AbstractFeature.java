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
package org.citygml4j.model.gml.feature;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.module.Module;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

public abstract class AbstractFeature extends AbstractGML {
	private BoundingShape boundedBy;
	private LocationProperty location;
	private List<ADEGenericElement> genericADEElement;
	private Module module;

	public AbstractFeature() {

	}

	public AbstractFeature(Module module) {
		this.module = module;
	}

	public void addGenericADEElement(ADEGenericElement genericADEElement) {
		getGenericADEElement().add(genericADEElement);
	}
	
	public BoundingShape getBoundedBy() {
		return boundedBy;
	}

	public LocationProperty getLocation() {
		return location;
	}
	
	public List<ADEGenericElement> getGenericADEElement() {
		if (genericADEElement == null)
			genericADEElement = new ChildList<>(this);
		
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
		if (boundingShape == null || !boundingShape.isEmpty())
			boundedBy = ModelObjects.setParent(boundingShape, this);
	}

	public void setLocation(LocationProperty location) {
		this.location = ModelObjects.setParent(location, this);
	}
	
	public void setGenericADEElement(List<ADEGenericElement> genericADEElement) {
		this.genericADEElement = new ChildList<>(this, genericADEElement);
	}

	public void unsetBoundedBy() {
		boundedBy = ModelObjects.setNull(boundedBy);
	}

	public void unsetLocation() {
		location = ModelObjects.setNull(location);
	}
	
	public void unsetGenericADEElement() {
		genericADEElement = ModelObjects.setNull(genericADEElement);
	}

	public boolean unsetGenericADEElement(ADEGenericElement genericADEElement) {
		return isSetGenericADEElement() && this.genericADEElement.remove(genericADEElement);
	}

	public boolean isSetModule() {
		return module != null;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACT_FEATURE;
	}

	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		return (options.isUseExistingEnvelopes() && boundedBy != null && !boundedBy.isEmpty()) ? boundedBy : new BoundingShape();
	}

	public SpatialRepresentation getSpatialRepresentation() {
		// return an empty spatial representation per default
		return SpatialRepresentation.emptyRepresentation();
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
