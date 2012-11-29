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
package org.citygml4j.model.citygml.bridge;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.module.citygml.BridgeModule;

public class OuterCeilingSurface extends AbstractBoundarySurface implements BridgeModuleComponent {
	private List<ADEComponent> ade;

	public OuterCeilingSurface() {
		
	}
	
	public OuterCeilingSurface(BridgeModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfOuterCeilingSurface(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfOuterCeilingSurface() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfOuterCeilingSurface() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfOuterCeilingSurface(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericApplicationPropertyOfOuterCeilingSurface() {
		if (isSetGenericApplicationPropertyOfOuterCeilingSurface())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfOuterCeilingSurface(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfOuterCeilingSurface() ? this.ade.remove(ade) : false;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.OUTER_BRIDGE_CEILING_SURFACE;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new OuterCeilingSurface(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		OuterCeilingSurface copy = (target == null) ? new OuterCeilingSurface() : (OuterCeilingSurface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfOuterCeilingSurface()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfOuterCeilingSurface(copyPart);

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
