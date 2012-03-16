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
package org.citygml4j.factory;

import org.citygml4j.impl.citygml.building.BoundarySurfacePropertyImpl;
import org.citygml4j.impl.citygml.building.BuildingFurnitureImpl;
import org.citygml4j.impl.citygml.building.BuildingImpl;
import org.citygml4j.impl.citygml.building.BuildingInstallationImpl;
import org.citygml4j.impl.citygml.building.BuildingInstallationPropertyImpl;
import org.citygml4j.impl.citygml.building.BuildingPartImpl;
import org.citygml4j.impl.citygml.building.BuildingPartPropertyImpl;
import org.citygml4j.impl.citygml.building.CeilingSurfaceImpl;
import org.citygml4j.impl.citygml.building.ClosureSurfaceImpl;
import org.citygml4j.impl.citygml.building.DoorImpl;
import org.citygml4j.impl.citygml.building.FloorSurfaceImpl;
import org.citygml4j.impl.citygml.building.GroundSurfaceImpl;
import org.citygml4j.impl.citygml.building.IntBuildingInstallationImpl;
import org.citygml4j.impl.citygml.building.IntBuildingInstallationPropertyImpl;
import org.citygml4j.impl.citygml.building.InteriorFurniturePropertyImpl;
import org.citygml4j.impl.citygml.building.InteriorRoomPropertyImpl;
import org.citygml4j.impl.citygml.building.InteriorWallSurfaceImpl;
import org.citygml4j.impl.citygml.building.OpeningPropertyImpl;
import org.citygml4j.impl.citygml.building.OuterCeilingSurfaceImpl;
import org.citygml4j.impl.citygml.building.OuterFloorSurfaceImpl;
import org.citygml4j.impl.citygml.building.RoofSurfaceImpl;
import org.citygml4j.impl.citygml.building.RoomImpl;
import org.citygml4j.impl.citygml.building.WallSurfaceImpl;
import org.citygml4j.impl.citygml.building.WindowImpl;
import org.citygml4j.model.citygml.building.AbstractBoundarySurface;
import org.citygml4j.model.citygml.building.AbstractOpening;
import org.citygml4j.model.citygml.building.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.building.BuildingFurniture;
import org.citygml4j.model.citygml.building.BuildingInstallation;
import org.citygml4j.model.citygml.building.BuildingInstallationProperty;
import org.citygml4j.model.citygml.building.BuildingPart;
import org.citygml4j.model.citygml.building.BuildingPartProperty;
import org.citygml4j.model.citygml.building.CeilingSurface;
import org.citygml4j.model.citygml.building.ClosureSurface;
import org.citygml4j.model.citygml.building.Door;
import org.citygml4j.model.citygml.building.FloorSurface;
import org.citygml4j.model.citygml.building.GroundSurface;
import org.citygml4j.model.citygml.building.IntBuildingInstallation;
import org.citygml4j.model.citygml.building.IntBuildingInstallationProperty;
import org.citygml4j.model.citygml.building.InteriorFurnitureProperty;
import org.citygml4j.model.citygml.building.InteriorRoomProperty;
import org.citygml4j.model.citygml.building.InteriorWallSurface;
import org.citygml4j.model.citygml.building.OpeningProperty;
import org.citygml4j.model.citygml.building.OuterCeilingSurface;
import org.citygml4j.model.citygml.building.OuterFloorSurface;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.building.WallSurface;
import org.citygml4j.model.citygml.building.Window;

public class BuildingFactory {

	public BuildingFactory() {
		
	}
	
	public BoundarySurfaceProperty createBoundarySurfaceProperty() {
		return new BoundarySurfacePropertyImpl();
	}
	
	public BoundarySurfaceProperty createBoundarySurfaceProperty(AbstractBoundarySurface boundarySurface) {
		BoundarySurfaceProperty boundarySurfaceProperty = new BoundarySurfacePropertyImpl();
		boundarySurfaceProperty.setBoundarySurface(boundarySurface);
		return boundarySurfaceProperty;
	}
	
	public BoundarySurfaceProperty createBoundarySurfaceProperty(String xlink) {
		BoundarySurfaceProperty boundarySurfaceProperty = new BoundarySurfacePropertyImpl();
		boundarySurfaceProperty.setHref(xlink);
		return boundarySurfaceProperty;
	}

	public Building createBuilding() {
		return new BuildingImpl();
	}

	public BuildingFurniture createBuildingFurniture() {
		return new BuildingFurnitureImpl();
	}

	public BuildingInstallation createBuildingInstallation() {
		return new BuildingInstallationImpl();
	}

	public BuildingInstallationProperty createBuildingInstallationProperty() {
		return new BuildingInstallationPropertyImpl();
	}
	
	public BuildingInstallationProperty createBuildingInstallationProperty(BuildingInstallation buildingInstallation) {
		BuildingInstallationProperty buildingInstallationProperty = new BuildingInstallationPropertyImpl();
		buildingInstallationProperty.setBuildingInstallation(buildingInstallation);
		return buildingInstallationProperty;
	}
	
	public BuildingInstallationProperty createBuildingInstallationProperty(String xlink) {
		BuildingInstallationProperty buildingInstallationProperty = new BuildingInstallationPropertyImpl();
		buildingInstallationProperty.setHref(xlink);
		return buildingInstallationProperty;
	}

	public BuildingPart createBuildingPart() {
		return new BuildingPartImpl();
	}

	public BuildingPartProperty createBuildingPartProperty() {
		return new BuildingPartPropertyImpl();
	}
	
	public BuildingPartProperty createBuildingPartProperty(BuildingPart buildingPart) {
		BuildingPartProperty buildingPartProperty = new BuildingPartPropertyImpl();
		buildingPartProperty.setBuildingPart(buildingPart);
		return buildingPartProperty;
	}
	
	public BuildingPartProperty createBuildingPartProperty(String xlink) {
		BuildingPartProperty buildingPartProperty = new BuildingPartPropertyImpl();
		buildingPartProperty.setHref(xlink);
		return buildingPartProperty;
	}

	public CeilingSurface createCeilingSurface() {
		return new CeilingSurfaceImpl();
	}
	
	public OuterCeilingSurface createOuterCeilingSurface() {
		return new OuterCeilingSurfaceImpl();
	}

	public ClosureSurface createClosureSurface() {
		return new ClosureSurfaceImpl();
	}

	public Door createDoor() {
		return new DoorImpl();
	}

	public FloorSurface createFloorSurface() {
		return new FloorSurfaceImpl();
	}
	
	public OuterFloorSurface createOuterFloorSurface() {
		return new OuterFloorSurfaceImpl();
	}

	public GroundSurface createGroundSurface() {
		return new GroundSurfaceImpl();
	}

	public IntBuildingInstallation createIntBuildingInstallation() {
		return new IntBuildingInstallationImpl();
	}

	public IntBuildingInstallationProperty createIntBuildingInstallationProperty() {
		return new IntBuildingInstallationPropertyImpl();
	}
	
	public IntBuildingInstallationProperty createIntBuildingInstallationProperty(IntBuildingInstallation intBuildingInstallation) {
		IntBuildingInstallationProperty intBuildingInstallationProperty = new IntBuildingInstallationPropertyImpl();
		intBuildingInstallationProperty.setIntBuildingInstallation(intBuildingInstallation);
		return intBuildingInstallationProperty;
	}
	
	public IntBuildingInstallationProperty createIntBuildingInstallationProperty(String xlink) {
		IntBuildingInstallationProperty intBuildingInstallationProperty = new IntBuildingInstallationPropertyImpl();
		intBuildingInstallationProperty.setHref(xlink);
		return intBuildingInstallationProperty;
	}

	public InteriorFurnitureProperty createInteriorFurnitureProperty() {
		return new InteriorFurniturePropertyImpl();
	}
	
	public InteriorFurnitureProperty createInteriorFurnitureProperty(BuildingFurniture buildingFurniture) {
		InteriorFurnitureProperty interiorFurnitureProperty = new InteriorFurniturePropertyImpl();
		interiorFurnitureProperty.setBuildingFurniture(buildingFurniture);
		return interiorFurnitureProperty;
	}
	
	public InteriorFurnitureProperty createInteriorFurnitureProperty(String xlink) {
		InteriorFurnitureProperty interiorFurnitureProperty = new InteriorFurniturePropertyImpl();
		interiorFurnitureProperty.setHref(xlink);
		return interiorFurnitureProperty;
	}

	public InteriorRoomProperty createInteriorRoomProperty() {
		return new InteriorRoomPropertyImpl();
	}
	
	public InteriorRoomProperty createInteriorRoomProperty(Room room) {
		InteriorRoomProperty interiorRoomProperty = new InteriorRoomPropertyImpl();
		interiorRoomProperty.setRoom(room);
		return interiorRoomProperty;
	}
	
	public InteriorRoomProperty createInteriorRoomProperty(String xlink) {
		InteriorRoomProperty interiorRoomProperty = new InteriorRoomPropertyImpl();
		interiorRoomProperty.setHref(xlink);
		return interiorRoomProperty;
	}

	public InteriorWallSurface createInteriorWallSurface() {
		return new InteriorWallSurfaceImpl();
	}

	public OpeningProperty createOpeningProperty() {
		return new OpeningPropertyImpl();
	}
	
	public OpeningProperty createOpeningProperty(AbstractOpening opening) {
		OpeningProperty openingProperty = new OpeningPropertyImpl();
		openingProperty.setOpening(opening);
		return openingProperty;
	}
	
	public OpeningProperty createOpeningProperty(String xlink) {
		OpeningProperty openingProperty = new OpeningPropertyImpl();
		openingProperty.setHref(xlink);
		return openingProperty;
	}

	public RoofSurface createRoofSurface() {
		return new RoofSurfaceImpl();
	}

	public Room createRoom() {
		return new RoomImpl();
	}

	public WallSurface createWallSurface() {
		return new WallSurfaceImpl();
	}

	public Window createWindow() {
		return new WindowImpl();
	}

}
