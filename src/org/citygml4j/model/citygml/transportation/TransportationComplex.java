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
package org.citygml4j.model.citygml.transportation;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.complexes.GeometricComplexProperty;

public interface TransportationComplex extends AbstractTransportationObject {
	public List<String> getFunction();
	public List<String> getUsage();
	public List<TrafficAreaProperty> getTrafficArea();
	public List<AuxiliaryTrafficAreaProperty> getAuxiliaryTrafficArea();
	public List<GeometricComplexProperty> getLod0Network();
	public MultiSurfaceProperty getLod1MultiSurface();
	public MultiSurfaceProperty getLod2MultiSurface();
	public MultiSurfaceProperty getLod3MultiSurface();
	public MultiSurfaceProperty getLod4MultiSurface();
	public List<ADEComponent> getGenericApplicationPropertyOfTransportationComplex();
	public boolean isSetFunction();
	public boolean isSetUsage();
	public boolean isSetTrafficArea();
	public boolean isSetAuxiliaryTrafficArea();
	public boolean isSetLod0Network();
	public boolean isSetLod1MultiSurface();
	public boolean isSetLod2MultiSurface();
	public boolean isSetLod3MultiSurface();
	public boolean isSetLod4MultiSurface();
	public boolean isSetGenericApplicationPropertyOfTransportationComplex();
	
	public void setFunction(List<String> function);
	public void addFunction(String function);
	public void setUsage(List<String> usage);
	public void addUsage(String usage);
	public void setTrafficArea(List<TrafficAreaProperty> trafficArea);
	public void addTrafficArea(TrafficAreaProperty trafficArea);
	public void setAuxiliaryTrafficArea(List<AuxiliaryTrafficAreaProperty> auxiliaryTrafficArea);
	public void addAuxiliaryTrafficArea(AuxiliaryTrafficAreaProperty auxiliaryTrafficArea);
	public void setLod0Network(List<GeometricComplexProperty> lod0Network);
	public void addLod0Network(GeometricComplexProperty lod0Network);
	public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface);
	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface);
	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface);
	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface);	
	public void addGenericApplicationPropertyOfTransportationComplex(ADEComponent ade);
	public void setGenericApplicationPropertyOfTransportationComplex(List<ADEComponent> ade);
	public void unsetFunction();
	public boolean unsetFunction(String function);
	public void unsetUsage();
	public boolean unsetUsage(String usage);
	public void unsetTrafficArea();
	public boolean unsetTrafficArea(TrafficAreaProperty trafficArea);
	public void unsetAuxiliaryTrafficArea();
	public boolean unsetAuxiliaryTrafficArea(AuxiliaryTrafficAreaProperty auxiliaryTrafficArea);
	public void unsetLod0Network();
	public boolean unsetLod0Network(GeometricComplexProperty lod0Network);
	public void unsetLod1MultiSurface();
	public void unsetLod2MultiSurface();
	public void unsetLod3MultiSurface();
	public void unsetLod4MultiSurface();
	public void unsetGenericApplicationPropertyOfTransportationComplex();
	public boolean unsetGenericApplicationPropertyOfTransportationComplex(ADEComponent ade);
}
