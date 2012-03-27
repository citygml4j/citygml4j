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
		return new BoundarySurfaceProperty();
	}
	
	public BoundarySurfaceProperty createBoundarySurfaceProperty(AbstractBoundarySurface boundarySurface) {
		BoundarySurfaceProperty boundarySurfaceProperty = new BoundarySurfaceProperty();
		boundarySurfaceProperty.setBoundarySurface(boundarySurface);
		return boundarySurfaceProperty;
	}
	
	public BoundarySurfaceProperty createBoundarySurfaceProperty(String xlink) {
		BoundarySurfaceProperty boundarySurfaceProperty = new BoundarySurfaceProperty();
		boundarySurfaceProperty.setHref(xlink);
		return boundarySurfaceProperty;
	}

	public Building createBuilding() {
		return new Building();
	}

	public BuildingFurniture createBuildingFurniture() {
		return new BuildingFurniture();
	}

	public BuildingInstallation createBuildingInstallation() {
		return new BuildingInstallation();
	}

	public BuildingInstallationProperty createBuildingInstallationProperty() {
		return new BuildingInstallationProperty();
	}
	
	public BuildingInstallationProperty createBuildingInstallationProperty(BuildingInstallation buildingInstallation) {
		BuildingInstallationProperty buildingInstallationProperty = new BuildingInstallationProperty();
		buildingInstallationProperty.setBuildingInstallation(buildingInstallation);
		return buildingInstallationProperty;
	}
	
	public BuildingInstallationProperty createBuildingInstallationProperty(String xlink) {
		BuildingInstallationProperty buildingInstallationProperty = new BuildingInstallationProperty();
		buildingInstallationProperty.setHref(xlink);
		return buildingInstallationProperty;
	}

	public BuildingPart createBuildingPart() {
		return new BuildingPart();
	}

	public BuildingPartProperty createBuildingPartProperty() {
		return new BuildingPartProperty();
	}
	
	public BuildingPartProperty createBuildingPartProperty(BuildingPart buildingPart) {
		BuildingPartProperty buildingPartProperty = new BuildingPartProperty();
		buildingPartProperty.setBuildingPart(buildingPart);
		return buildingPartProperty;
	}
	
	public BuildingPartProperty createBuildingPartProperty(String xlink) {
		BuildingPartProperty buildingPartProperty = new BuildingPartProperty();
		buildingPartProperty.setHref(xlink);
		return buildingPartProperty;
	}

	public CeilingSurface createCeilingSurface() {
		return new CeilingSurface();
	}
	
	public OuterCeilingSurface createOuterCeilingSurface() {
		return new OuterCeilingSurface();
	}

	public ClosureSurface createClosureSurface() {
		return new ClosureSurface();
	}

	public Door createDoor() {
		return new Door();
	}

	public FloorSurface createFloorSurface() {
		return new FloorSurface();
	}
	
	public OuterFloorSurface createOuterFloorSurface() {
		return new OuterFloorSurface();
	}

	public GroundSurface createGroundSurface() {
		return new GroundSurface();
	}

	public IntBuildingInstallation createIntBuildingInstallation() {
		return new IntBuildingInstallation();
	}

	public IntBuildingInstallationProperty createIntBuildingInstallationProperty() {
		return new IntBuildingInstallationProperty();
	}
	
	public IntBuildingInstallationProperty createIntBuildingInstallationProperty(IntBuildingInstallation intBuildingInstallation) {
		IntBuildingInstallationProperty intBuildingInstallationProperty = new IntBuildingInstallationProperty();
		intBuildingInstallationProperty.setIntBuildingInstallation(intBuildingInstallation);
		return intBuildingInstallationProperty;
	}
	
	public IntBuildingInstallationProperty createIntBuildingInstallationProperty(String xlink) {
		IntBuildingInstallationProperty intBuildingInstallationProperty = new IntBuildingInstallationProperty();
		intBuildingInstallationProperty.setHref(xlink);
		return intBuildingInstallationProperty;
	}

	public InteriorFurnitureProperty createInteriorFurnitureProperty() {
		return new InteriorFurnitureProperty();
	}
	
	public InteriorFurnitureProperty createInteriorFurnitureProperty(BuildingFurniture buildingFurniture) {
		InteriorFurnitureProperty interiorFurnitureProperty = new InteriorFurnitureProperty();
		interiorFurnitureProperty.setBuildingFurniture(buildingFurniture);
		return interiorFurnitureProperty;
	}
	
	public InteriorFurnitureProperty createInteriorFurnitureProperty(String xlink) {
		InteriorFurnitureProperty interiorFurnitureProperty = new InteriorFurnitureProperty();
		interiorFurnitureProperty.setHref(xlink);
		return interiorFurnitureProperty;
	}

	public InteriorRoomProperty createInteriorRoomProperty() {
		return new InteriorRoomProperty();
	}
	
	public InteriorRoomProperty createInteriorRoomProperty(Room room) {
		InteriorRoomProperty interiorRoomProperty = new InteriorRoomProperty();
		interiorRoomProperty.setRoom(room);
		return interiorRoomProperty;
	}
	
	public InteriorRoomProperty createInteriorRoomProperty(String xlink) {
		InteriorRoomProperty interiorRoomProperty = new InteriorRoomProperty();
		interiorRoomProperty.setHref(xlink);
		return interiorRoomProperty;
	}

	public InteriorWallSurface createInteriorWallSurface() {
		return new InteriorWallSurface();
	}

	public OpeningProperty createOpeningProperty() {
		return new OpeningProperty();
	}
	
	public OpeningProperty createOpeningProperty(AbstractOpening opening) {
		OpeningProperty openingProperty = new OpeningProperty();
		openingProperty.setOpening(opening);
		return openingProperty;
	}
	
	public OpeningProperty createOpeningProperty(String xlink) {
		OpeningProperty openingProperty = new OpeningProperty();
		openingProperty.setHref(xlink);
		return openingProperty;
	}

	public RoofSurface createRoofSurface() {
		return new RoofSurface();
	}

	public Room createRoom() {
		return new Room();
	}

	public WallSurface createWallSurface() {
		return new WallSurface();
	}

	public Window createWindow() {
		return new Window();
	}

}
