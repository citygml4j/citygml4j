/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
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
 */
package org.citygml4j.model.citygml.waterbody;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;

public interface AbstractWaterBoundarySurface extends WaterBodyModuleComponent, AbstractCityObject {
	public SurfaceProperty getLod2Surface();
	public SurfaceProperty getLod3Surface();
	public SurfaceProperty getLod4Surface();
	public List<ADEComponent> getGenericApplicationPropertyOfWaterBoundarySurface();
	public boolean isSetLod2Surface();
	public boolean isSetLod3Surface();
	public boolean isSetLod4Surface();
	public boolean isSetGenericApplicationPropertyOfWaterBoundarySurface();
	
	public void setLod2Surface(SurfaceProperty lod2Surface);
	public void setLod3Surface(SurfaceProperty lod3Surface);
	public void setLod4Surface(SurfaceProperty lod4Surface);	
	public void addGenericApplicationPropertyOfWaterBoundarySurface(ADEComponent ade);
	public void setGenericApplicationPropertyOfWaterBoundarySurface(List<ADEComponent> ade);
	public void unsetLod2Surface();
	public void unsetLod3Surface();
	public void unsetLod4Surface();
	public void unsetGenericApplicationPropertyOfWaterBoundarySurface();
	public boolean unsetGenericApplicationPropertyOfWaterBoundarySurface(ADEComponent ade);
}
