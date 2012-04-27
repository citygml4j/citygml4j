/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.gml.feature;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.ArrayAssociation;

public class FeatureArrayProperty extends ArrayAssociation<AbstractFeature> {
	private List<ADEComponent> genericADEComponent;
	
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
	
	public void addGenericADEComponent(ADEComponent genericADEComponent) {
		if (this.genericADEComponent == null)
			this.genericADEComponent = new ChildList<ADEComponent>(this);
		
		this.genericADEComponent.add(genericADEComponent);
	}

	public List<? extends AbstractFeature> getFeature() {
		return super.getObject();
	}
	
	public List<ADEComponent> getGenericADEComponent() {
		if (genericADEComponent == null)
			genericADEComponent = new ChildList<ADEComponent>(this);
		
		return genericADEComponent;
	}

	public boolean isSetFeature() {
		return super.isSetObject();
	}
	
	public boolean isSetGenericADEComponent() {
		return genericADEComponent != null && !genericADEComponent.isEmpty();
	}

	@SuppressWarnings("unchecked")
	public void setFeature(List<? extends AbstractFeature> feature) {
		super.setObject((List<AbstractFeature>)feature);
	}
	
	public void setGenericADEComponent(List<ADEComponent> genericADEComponent) {
		this.genericADEComponent = new ChildList<ADEComponent>(this, genericADEComponent);
	}

	public void unsetFeature() {
		super.unsetObject();
	}
	
	public void unsetGenericADEComponent() {
		if (isSetGenericADEComponent())
			genericADEComponent.clear();
		
		genericADEComponent = null;
	}

	public boolean unsetFeature(AbstractFeature feature) {
		return super.unsetObject(feature);
	}
	
	public boolean unsetGenericADEComponent(ADEComponent genericADEComponent) {
		return isSetGenericADEComponent() ? this.genericADEComponent.remove(genericADEComponent) : false;
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
		
		if (isSetGenericADEComponent()) {
			for (ADEComponent part : genericADEComponent) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericADEComponent(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}

}
