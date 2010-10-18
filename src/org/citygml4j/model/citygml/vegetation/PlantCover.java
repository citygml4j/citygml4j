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
package org.citygml4j.model.citygml.vegetation;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.geometry.aggregates.MultiSolidProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.measures.Length;

public interface PlantCover extends AbstractVegetationObject {
	public String getClazz();
	public List<String> getFunction();
	public Length getAverageHeight();
	public MultiSurfaceProperty getLod1MultiSurface();
	public MultiSurfaceProperty getLod2MultiSurface();
	public MultiSurfaceProperty getLod3MultiSurface();
	public MultiSurfaceProperty getLod4MultiSurface();
	public MultiSolidProperty getLod1MultiSolid();
	public MultiSolidProperty getLod2MultiSolid();
	public MultiSolidProperty getLod3MultiSolid();
	public List<ADEComponent> getGenericApplicationPropertyOfPlantCover();
	public boolean isSetClazz();
	public boolean isSetFunction();
	public boolean isSetAverageHeight();
	public boolean isSetLod1MultiSurface();
	public boolean isSetLod2MultiSurface();
	public boolean isSetLod3MultiSurface();
	public boolean isSetLod4MultiSurface();
	public boolean isSetLod1MultiSolid();
	public boolean isSetLod2MultiSolid();
	public boolean isSetLod3MultiSolid();
	public boolean isSetGenericApplicationPropertyOfPlantCover();

	public void setClazz(String clazz);
	public void setFunction(List<String> function);
	public void addFunction(String function);
	public void setAverageHeight(Length averageHeight);
	public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface);
	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface);
	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface);
	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface);
	public void setLod1MultiSolid(MultiSolidProperty lod1MultiSolid);
	public void setLod2MultiSolid(MultiSolidProperty lod2MultiSolid);
	public void setLod3MultiSolid(MultiSolidProperty lod3MultiSolid);	
	public void addGenericApplicationPropertyOfPlantCover(ADEComponent ade);
	public void setGenericApplicationPropertyOfPlantCover(List<ADEComponent> ade);
	public void unsetClazz();
	public void unsetFunction();
	public boolean unsetFunction(String function);
	public void unsetAverageHeight();
	public void unsetLod1MultiSurface();
	public void unsetLod2MultiSurface();
	public void unsetLod3MultiSurface();
	public void unsetLod4MultiSurface();
	public void unsetLod1MultiSolid();
	public void unsetLod2MultiSolid();
	public void unsetLod3MultiSolid();
	public void unsetGenericApplicationPropertyOfPlantCover();
	public boolean unsetGenericApplicationPropertyOfPlantCover(ADEComponent ade);
}
