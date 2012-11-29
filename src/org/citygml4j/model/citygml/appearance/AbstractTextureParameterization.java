/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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
 * 
 * $Id$
 */
package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.module.citygml.AppearanceModule;

public abstract class AbstractTextureParameterization extends AbstractGML implements AppearanceModuleComponent {
	private List<ADEComponent> genericADEComponent;
	private List<ADEComponent> ade;
	private AppearanceModule module;
	
	public AbstractTextureParameterization() {
		
	}
	
	public AbstractTextureParameterization(AppearanceModule module) {
		this.module = module;
	}
	
	public void addGenericADEComponent(ADEComponent genericADEComponent) {
		if (this.genericADEComponent == null)
			this.genericADEComponent = new ChildList<ADEComponent>(this);
		
		this.genericADEComponent.add(genericADEComponent);
	}
	
	public void addGenericApplicationPropertyOfTextureParameterization(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericADEComponent() {
		if (genericADEComponent == null)
			genericADEComponent = new ChildList<ADEComponent>(this);
		
		return genericADEComponent;
	}
	
	public List<ADEComponent> getGenericApplicationPropertyOfTextureParameterization() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericADEComponent() {
		return genericADEComponent != null && !genericADEComponent.isEmpty();
	}
	
	public boolean isSetGenericApplicationPropertyOfTextureParameterization() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericADEComponent(List<ADEComponent> genericADEComponent) {
		this.genericADEComponent = new ChildList<ADEComponent>(this, genericADEComponent);
	}
	
	public void setGenericApplicationPropertyOfTextureParameterization(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericADEComponent() {
		if (isSetGenericADEComponent())
			genericADEComponent.clear();
		
		genericADEComponent = null;
	}

	public boolean unsetGenericADEComponent(ADEComponent genericADEComponent) {
		return isSetGenericADEComponent() ? this.genericADEComponent.remove(genericADEComponent) : false;
	}
	
	public void unsetGenericApplicationPropertyOfTextureParameterization() {
		if (isSetGenericApplicationPropertyOfTextureParameterization())
				ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfTextureParameterization(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfTextureParameterization() ? this.ade.remove(ade) : false;
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}
	
	public final AppearanceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractTextureParameterization copy = (AbstractTextureParameterization)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfTextureParameterization()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfTextureParameterization(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}
}
