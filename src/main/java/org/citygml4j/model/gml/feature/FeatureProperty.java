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
package org.citygml4j.model.gml.feature;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.AssociationByRepOrRef;

public class FeatureProperty<T extends AbstractFeature> extends AssociationByRepOrRef<T> {
	private ADEGenericElement genericADEElement;
	
	public FeatureProperty() {
		
	}
	
	public FeatureProperty(T feature) {
		super(feature);
	}
	
	public FeatureProperty(String href) {
		super(href);
	}
	
	public T getFeature() {
		return super.getObject();
	}

	public boolean isSetFeature() {
		return super.isSetObject();
	}

	public void setFeature(T feature) {
		super.setObject(feature);
	}

	public void unsetFeature() {
		super.unsetObject();
	}

	public ADEGenericElement getGenericADEElement() {
		return genericADEElement;
	}

	public boolean isSetGenericADEElement() {
		return genericADEElement != null;
	}
	
	public void setGenericADEElement(ADEGenericElement genericADEElement) {
		if (genericADEElement != null)
			genericADEElement.setParent(this);
		
		this.genericADEElement = genericADEElement;
	}
	
	public void unsetGenericADEElement() {
		if (isSetGenericADEElement())
			genericADEElement.unsetParent();
		
		genericADEElement = null;
	}

	public GMLClass getGMLClass() {
		return GMLClass.FEATURE_PROPERTY;
	}

	@SuppressWarnings("unchecked")
	public Class<T> getAssociableClass() {
		return (Class<T>)AbstractFeature.class;
	}

	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		FeatureProperty<T> copy = (target == null) ? new FeatureProperty<T>() : (FeatureProperty<T>)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericADEElement()) {
			copy.setGenericADEElement((ADEGenericElement)copyBuilder.copy(genericADEElement));
			if (copy.getGenericADEElement() == genericADEElement)
				genericADEElement.setParent(this);
		}
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new FeatureProperty<T>(), copyBuilder);
	}

}
