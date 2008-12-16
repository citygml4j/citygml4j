package org.citygml4j.impl.jaxb.citygml.building._0_4;

import org.citygml4j.impl.jaxb.citygml.AbstractBuildingFactoryImpl;
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
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.building.WallSurface;
import org.citygml4j.model.citygml.building.Window;

public class Building040FactoryImpl extends AbstractBuildingFactoryImpl {

	@Override
	public BoundarySurfaceProperty createBoundarySurfaceProperty() {
		return new BoundarySurfacePropertyImpl();
	}

	@Override
	public Building createBuilding() {
		return new BuildingImpl();
	}

	@Override
	public BuildingFurniture createBuildingFurniture() {
		return new BuildingFurnitureImpl();
	}

	@Override
	public BuildingInstallation createBuildingInstallation() {
		return new BuildingInstallationImpl();
	}

	@Override
	public BuildingInstallationProperty createBuildingInstallationProperty() {
		return new BuildingInstallationPropertyImpl();
	}

	@Override
	public BuildingPart createBuildingPart() {
		return new BuildingPartImpl();
	}

	@Override
	public BuildingPartProperty createBuildingPartProperty() {
		return new BuildingPartPropertyImpl();
	}

	@Override
	public CeilingSurface createCeilingSurface() {
		return new CeilingSurfaceImpl();
	}

	@Override
	public ClosureSurface createClosureSurface() {
		return new ClosureSurfaceImpl();
	}

	@Override
	public Door createDoor() {
		return new DoorImpl();
	}

	@Override
	public FloorSurface createFloorSurface() {
		return new FloorSurfaceImpl();
	}

	@Override
	public GroundSurface createGroundSurface() {
		return new GroundSurfaceImpl();
	}

	@Override
	public IntBuildingInstallation createIntBuildingInstallation() {
		return new IntBuildingInstallationImpl();
	}

	@Override
	public IntBuildingInstallationProperty createIntBuildingInstallationProperty() {
		return new IntBuildingInstallationPropertyImpl();
	}

	@Override
	public InteriorFurnitureProperty createInteriorFurnitureProperty() {
		return new InteriorFurniturePropertyImpl();
	}

	@Override
	public InteriorRoomProperty createInteriorRoomProperty() {
		return new InteriorRoomPropertyImpl();
	}

	@Override
	public InteriorWallSurface createInteriorWallSurface() {
		return new InteriorWallSurfaceImpl();
	}

	@Override
	public OpeningProperty createOpeningProperty() {
		return new OpeningPropertyImpl();
	}

	@Override
	public RoofSurface createRoofSurface() {
		return new RoofSurfaceImpl();
	}

	@Override
	public Room createRoom() {
		return new RoomImpl();
	}

	@Override
	public WallSurface createWallSurface() {
		return new WallSurfaceImpl();
	}

	@Override
	public Window createWindow() {
		return new WindowImpl();
	}

}
