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
package org.citygml4j.model.citygml.waterbody;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.module.citygml.WaterBodyModule;

public class WaterSurface extends AbstractWaterBoundarySurface {
	private Code waterLevel;
	private List<ADEComponent> ade;

	public WaterSurface() {

	}

	public WaterSurface(WaterBodyModule module) {
		super(module);
	}
	
	public void addGenericApplicationPropertyOfWaterSurface(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfWaterSurface() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public Code getWaterLevel() {
		return waterLevel;
	}

	public boolean isSetGenericApplicationPropertyOfWaterSurface() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetWaterLevel() {
		return waterLevel != null;
	}

	public void setGenericApplicationPropertyOfWaterSurface(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setWaterLevel(Code waterLevel) {
		this.waterLevel = waterLevel;
	}

	public void unsetGenericApplicationPropertyOfWaterSurface() {
		if (isSetGenericApplicationPropertyOfWaterSurface())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfWaterSurface(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfWaterSurface() ? this.ade.remove(ade) : false;
	}

	public void unsetWaterLevel() {
		waterLevel = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.WATER_SURFACE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new WaterSurface(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		WaterSurface copy = (target == null) ? new WaterSurface() : (WaterSurface)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetWaterLevel())
			copy.setWaterLevel((Code)copyBuilder.copy(waterLevel));
		
		if (isSetGenericApplicationPropertyOfWaterSurface()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfWaterSurface(copyPart);

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
