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
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.ArrayAssociation;

import java.util.List;

public class FeatureArrayProperty extends ArrayAssociation<AbstractFeature> {
	private List<ADEGenericElement> genericADEElement;
	
	public FeatureArrayProperty() {
		
	}
	
	public FeatureArrayProperty(AbstractFeature abstractFeature) {
		super(abstractFeature);
	}
	
	public FeatureArrayProperty(List<AbstractFeature> abstractFeature) {
		super(abstractFeature);
	}
	
	public FeatureArrayProperty(AbstractFeature... abstractFeature) {
		super(abstractFeature);
	}
	
	public void addFeature(AbstractFeature feature) {
		super.addObject(feature);
	}
	
	public void addGenericADEElement(ADEGenericElement genericADEElement) {
		if (this.genericADEElement == null)
			this.genericADEElement = new ChildList<ADEGenericElement>(this);
		
		this.genericADEElement.add(genericADEElement);
	}

	public List<? extends AbstractFeature> getFeature() {
		return super.getObject();
	}
	
	public List<ADEGenericElement> getGenericADEElement() {
		if (genericADEElement == null)
			genericADEElement = new ChildList<ADEGenericElement>(this);
		
		return genericADEElement;
	}

	public boolean isSetFeature() {
		return super.isSetObject();
	}
	
	public boolean isSetGenericADEElement() {
		return genericADEElement != null && !genericADEElement.isEmpty();
	}

	@SuppressWarnings("unchecked")
	public void setFeature(List<? extends AbstractFeature> feature) {
		super.setObject((List<AbstractFeature>)feature);
	}
	
	public void setGenericADEComponent(List<ADEGenericElement> genericADEComponent) {
		this.genericADEElement = new ChildList<ADEGenericElement>(this, genericADEComponent);
	}

	public void unsetFeature() {
		super.unsetObject();
	}
	
	public void unsetGenericADEElement() {
		if (isSetGenericADEElement())
			genericADEElement.clear();
		
		genericADEElement = null;
	}

	public boolean unsetFeature(AbstractFeature feature) {
		return super.unsetObject(feature);
	}
	
	public boolean unsetGenericADEElement(ADEComponent genericADEElement) {
		return isSetGenericADEElement() ? this.genericADEElement.remove(genericADEElement) : false;
	}

	public GMLClass getGMLClass() {
		return GMLClass.FEATURE_ARRAY_PROPERTY;
	}

	public Class<AbstractFeature> getAssociableClass() {
		return AbstractFeature.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new FeatureArrayProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		FeatureArrayProperty copy = (target == null) ? new FeatureArrayProperty() : (FeatureArrayProperty)target;
		super.copyTo(copy, copyBuilder);
		
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

}
