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
package org.citygml4j.model.citygml.tunnel;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.module.citygml.TunnelModule;

public class WallSurface extends AbstractBoundarySurface implements TunnelModuleComponent {
	private List<ADEComponent> ade;

	public WallSurface() {
		
	}
	
	public WallSurface(TunnelModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfWallSurface(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfWallSurface() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfWallSurface() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfWallSurface(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);	}

	public void unsetGenericApplicationPropertyOfWallSurface() {
		if (isSetGenericApplicationPropertyOfWallSurface())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfWallSurface(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfWallSurface() ? this.ade.remove(ade) : false;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TUNNEL_WALL_SURFACE;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new WallSurface(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		WallSurface copy = (target == null) ? new WallSurface() : (WallSurface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfWallSurface()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfWallSurface(copyPart);

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
