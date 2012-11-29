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
 * $Id: AbstractTransportationObject.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.model.citygml.transportation;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.module.citygml.TransportationModule;

public abstract class AbstractTransportationObject extends AbstractCityObject implements TransportationModuleComponent {
	private List<ADEComponent> ade;
	private TransportationModule module;
	
	public AbstractTransportationObject() {
		
	}
	
	public AbstractTransportationObject(TransportationModule module) {
		this.module = module;
	}
	
	public void addGenericApplicationPropertyOfTransportationObject(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfTransportationObject() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfTransportationObject() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfTransportationObject(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericApplicationPropertyOfTransportationObject() {
		if (isSetGenericApplicationPropertyOfTransportationObject())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfTransportationObject(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfTransportationObject() ? this.ade.remove(ade) : false;
	}

	public final TransportationModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractTransportationObject copy = (AbstractTransportationObject)target;		
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfTransportationObject()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfTransportationObject(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}
	
}
