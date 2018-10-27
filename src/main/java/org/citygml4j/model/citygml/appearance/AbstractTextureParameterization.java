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
package org.citygml4j.model.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.module.citygml.AppearanceModule;

import java.util.List;

public abstract class AbstractTextureParameterization extends AbstractGML implements AppearanceModuleComponent {
	private List<ADEGenericElement> genericADEElement;
	private List<ADEComponent> ade;
	private AppearanceModule module;
	
	public AbstractTextureParameterization() {
		
	}
	
	public AbstractTextureParameterization(AppearanceModule module) {
		this.module = module;
	}
	
	public void addGenericADEElement(ADEGenericElement genericADEElement) {
		if (this.genericADEElement == null)
			this.genericADEElement = new ChildList<ADEGenericElement>(this);
		
		this.genericADEElement.add(genericADEElement);
	}
	
	public void addGenericApplicationPropertyOfTextureParameterization(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEGenericElement> getGenericADEElement() {
		if (genericADEElement == null)
			genericADEElement = new ChildList<ADEGenericElement>(this);
		
		return genericADEElement;
	}
	
	public List<ADEComponent> getGenericApplicationPropertyOfTextureParameterization() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericADEComponent() {
		return genericADEElement != null && !genericADEElement.isEmpty();
	}
	
	public boolean isSetGenericApplicationPropertyOfTextureParameterization() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericADEElement(List<ADEGenericElement> genericADEElement) {
		this.genericADEElement = new ChildList<ADEGenericElement>(this, genericADEElement);
	}
	
	public void setGenericApplicationPropertyOfTextureParameterization(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericADEElement() {
		if (isSetGenericADEComponent())
			genericADEElement.clear();
		
		genericADEElement = null;
	}

	public boolean unsetGenericADEElement(ADEComponent genericADEElement) {
		return isSetGenericADEComponent() ? this.genericADEElement.remove(genericADEElement) : false;
	}
	
	public void unsetGenericApplicationPropertyOfTextureParameterization() {
		if (isSetGenericApplicationPropertyOfTextureParameterization())
				ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfTextureParameterization(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfTextureParameterization() ? this.ade.remove(ade) : false;
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
		
		if (isSetGenericADEComponent()) {
			for (ADEGenericElement part : genericADEElement) {
				ADEGenericElement copyPart = (ADEGenericElement)copyBuilder.copy(part);
				copy.addGenericADEElement(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
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
