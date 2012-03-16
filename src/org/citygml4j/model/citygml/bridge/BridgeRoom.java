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
package org.citygml4j.model.citygml.bridge;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.StandardObjectClassifier;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;

public interface BridgeRoom extends BridgeModuleComponent, AbstractCityObject, StandardObjectClassifier {
	public List<BoundarySurfaceProperty> getBoundedBySurface();
	public List<InteriorFurnitureProperty> getInteriorFurniture();
	public List<IntBridgeInstallationProperty> getBridgeRoomInstallation();
	public SolidProperty getLod4Solid();
	public MultiSurfaceProperty getLod4MultiSurface();
	public List<ADEComponent> getGenericApplicationPropertyOfBridgeRoom();
	public boolean isSetBoundedBySurface();
	public boolean isSetInteriorFurniture();
	public boolean isSetBridgeRoomInstallation();
	public boolean isSetLod4Solid();
	public boolean isSetLod4MultiSurface();
	public boolean isSetGenericApplicationPropertyOfBridgeRoom();
	
	public void setBridgeRoomInstallation(List<IntBridgeInstallationProperty> bridgeRoomInstallation);
	public void addBridgeRoomInstallation(IntBridgeInstallationProperty bridgeRoomInstallation);
	public void setBoundedBySurface(List<BoundarySurfaceProperty> boundedBySurface);
	public void addBoundedBySurface(BoundarySurfaceProperty boundedBySurface);
	public void addInteriorFurniture(InteriorFurnitureProperty interiorFurniture);
	public void setInteriorFurniture(List<InteriorFurnitureProperty> interiorFurniture);
	public void setLod4Solid(SolidProperty lod4Solid);
	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface);	
	public void addGenericApplicationPropertyOfBridgeRoom(ADEComponent ade);
	public void setGenericApplicationPropertyOfBridgeRoom(List<ADEComponent> ade);
	public void unsetBoundedBySurface();
	public boolean unsetBoundedBySurface(BoundarySurfaceProperty boundedBySurface);
	public void unsetInteriorFurniture();
	public boolean unsetInteriorFurniture(InteriorFurnitureProperty interiorFurniture);
	public void unsetBridgeRoomInstallation();
	public boolean unsetBridgeRoomInstallation(IntBridgeInstallationProperty bridgeRoomInstallation);
	public void unsetLod4Solid();
	public void unsetLod4MultiSurface();
	public void unsetGenericApplicationPropertyOfBridgeRoom();
	public boolean unsetGenericApplicationPropertyOfBridgeRoom(ADEComponent ade);
}
