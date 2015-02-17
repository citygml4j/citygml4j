/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
package org.citygml4j.model.citygml.relief;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.module.citygml.ReliefModule;

public class ReliefFeature extends AbstractCityObject implements ReliefModuleComponent {
	private int lod;
	private List<ReliefComponentProperty> reliefComponent;
	private List<ADEComponent> ade;
	private ReliefModule module;
	
	public ReliefFeature() {
		
	}
	
	public ReliefFeature(ReliefModule module) {
		this.module = module;
	}
	
	public void addGenericApplicationPropertyOfReliefFeature(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public void addReliefComponent(ReliefComponentProperty reliefComponent) {
		if (this.reliefComponent == null)
			this.reliefComponent = new ChildList<ReliefComponentProperty>(this);

		this.reliefComponent.add(reliefComponent);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfReliefFeature() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public int getLod() {
		return lod;
	}

	public List<ReliefComponentProperty> getReliefComponent() {
		if (reliefComponent == null)
			reliefComponent = new ChildList<ReliefComponentProperty>(this);

		return reliefComponent;
	}

	public boolean isSetGenericApplicationPropertyOfReliefFeature() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetLod() {
		return true;
	}

	public boolean isSetReliefComponent() {
		return reliefComponent != null && !reliefComponent.isEmpty();
	}

	public void setGenericApplicationPropertyOfReliefFeature(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setLod(int lod) {
		if (lod >= 0 && lod <= 4)
			this.lod = lod;
	}

	public void setReliefComponent(List<ReliefComponentProperty> reliefComponent) {
		this.reliefComponent = new ChildList<ReliefComponentProperty>(this, reliefComponent);
	}

	public void unsetGenericApplicationPropertyOfReliefFeature() {
		if (isSetGenericApplicationPropertyOfReliefFeature())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfReliefFeature(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfReliefFeature() ? this.ade.remove(ade) : false;
	}

	public void unsetReliefComponent() {
		if (isSetReliefComponent())
			reliefComponent.clear();

		reliefComponent = null;
	}

	public boolean unsetReliefComponent(ReliefComponentProperty reliefComponent) {
		return isSetReliefComponent() ? this.reliefComponent.remove(reliefComponent) : false;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.RELIEF_FEATURE;
	}

	public final ReliefModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = new BoundingShape();

		if (isSetReliefComponent()) {
			for (ReliefComponentProperty reliefComponentProperty : reliefComponent) {
				if (reliefComponentProperty.isSetObject()) {
					calcBoundedBy(boundedBy, reliefComponentProperty.getObject(), setBoundedBy);
				} else {
					// xlink
				}
			}
		}

		if (boundedBy.isSetEnvelope()) {
			if (setBoundedBy)
				setBoundedBy(boundedBy);

			return boundedBy;
		} else
			return null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ReliefFeature(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ReliefFeature copy = (target == null) ? new ReliefFeature() : (ReliefFeature)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetLod())
			copy.setLod(copyBuilder.copy(lod));

		if (isSetReliefComponent()) {
			for (ReliefComponentProperty part : reliefComponent) {
				ReliefComponentProperty copyPart = (ReliefComponentProperty)copyBuilder.copy(part);
				copy.addReliefComponent(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetGenericApplicationPropertyOfReliefFeature()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfReliefFeature(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}
	
	public void accept(FeatureVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(FeatureFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
