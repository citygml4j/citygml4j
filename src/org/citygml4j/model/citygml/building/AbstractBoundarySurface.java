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
package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;

public interface AbstractBoundarySurface extends BuildingModuleComponent, AbstractCityObject {
	public MultiSurfaceProperty getLod2MultiSurface();
	public MultiSurfaceProperty getLod3MultiSurface();
	public MultiSurfaceProperty getLod4MultiSurface();
	public List<OpeningProperty> getOpening();
	public List<ADEComponent> getGenericApplicationPropertyOfBoundarySurface();
	public boolean isSetLod2MultiSurface();
	public boolean isSetLod3MultiSurface();
	public boolean isSetLod4MultiSurface();
	public boolean isSetOpening();
	public boolean isSetGenericApplicationPropertyOfBoundarySurface();
	
	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface);
	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface);
	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface);
	public void setOpening(List<OpeningProperty> opening);
	public void addOpening(OpeningProperty opening);	
	public void addGenericApplicationPropertyOfBoundarySurface(ADEComponent ade);
	public void setGenericApplicationPropertyOfBoundarySurface(List<ADEComponent> ade);
	public void unsetLod2MultiSurface();
	public void unsetLod3MultiSurface();
	public void unsetLod4MultiSurface();
	public void unsetOpening();
	public boolean unsetOpening(OpeningProperty opening);
	public void unsetGenericApplicationPropertyOfBoundarySurface();
	public boolean unsetGenericApplicationPropertyOfBoundarySurface(ADEComponent ade);
}
