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

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.StandardObjectClassifier;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurveProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;

public interface WaterBody extends AbstractWaterObject, StandardObjectClassifier {
	public MultiCurveProperty getLod0MultiCurve();
	public MultiCurveProperty getLod1MultiCurve();
	public MultiSurfaceProperty getLod0MultiSurface();
	public MultiSurfaceProperty getLod1MultiSurface();
	public SolidProperty getLod1Solid();
	public SolidProperty getLod2Solid();
	public SolidProperty getLod3Solid();
	public SolidProperty getLod4Solid();
	public List<BoundedByWaterSurfaceProperty> getBoundedBySurface();
	public List<ADEComponent> getGenericApplicationPropertyOfWaterBody();
	public boolean isSetLod0MultiCurve();
	public boolean isSetLod1MultiCurve();
	public boolean isSetLod0MultiSurface();
	public boolean isSetLod1MultiSurface();
	public boolean isSetLod1Solid();
	public boolean isSetLod2Solid();
	public boolean isSetLod3Solid();
	public boolean isSetLod4Solid();
	public boolean isSetBoundedBySurface();
	public boolean isSetGenericApplicationPropertyOfWaterBody();
	
	public void setLod0MultiCurve(MultiCurveProperty lod0MultiCurve);
	public void setLod1MultiCurve(MultiCurveProperty lod1MultiCurve);
	public void setLod0MultiSurface(MultiSurfaceProperty lod0MultiSurface);
	public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface);
	public void setLod1Solid(SolidProperty lod1Solid);
	public void setLod2Solid(SolidProperty lod2Solid);
	public void setLod3Solid(SolidProperty lod3Solid);
	public void setLod4Solid(SolidProperty lod4Solid);
	public void setBoundedBySurface(List<BoundedByWaterSurfaceProperty> boundedBySurface);
	public void addBoundedBySurface(BoundedByWaterSurfaceProperty boundedBySurface);	
	public void addGenericApplicationPropertyOfWaterBody(ADEComponent ade);
	public void setGenericApplicationPropertyOfWaterBody(List<ADEComponent> ade);
	public void unsetLod0MultiCurve();
	public void unsetLod1MultiCurve();
	public void unsetLod0MultiSurface();
	public void unsetLod1MultiSurface();
	public void unsetLod1Solid();
	public void unsetLod2Solid();
	public void unsetLod3Solid();
	public void unsetLod4Solid();
	public void unsetBoundedBySurface();
	public boolean unsetBoundedBySurface(BoundedByWaterSurfaceProperty boundedBySurface);
	public void unsetGenericApplicationPropertyOfWaterBody();
	public boolean unsetGenericApplicationPropertyOfWaterBody(ADEComponent ade);
}
