package org.citygml4j.model.citygml.building;

public interface BuildingFactory {
	public BoundarySurfaceProperty createBoundarySurfaceProperty();
	public BuildingFurniture createBuildingFurniture();
	public Building createBuilding();
	public BuildingInstallation createBuildingInstallation();
	public BuildingInstallationProperty createBuildingInstallationProperty();
	public BuildingPart createBuildingPart();
	public BuildingPartProperty createBuildingPartProperty();
	public CeilingSurface createCeilingSurface();
	public ClosureSurface createClosureSurface();
	public Door createDoor();
	public FloorSurface createFloorSurface();
	public GroundSurface createGroundSurface();
	public IntBuildingInstallation createIntBuildingInstallation();
	public IntBuildingInstallationProperty createIntBuildingInstallationProperty();
	public InteriorFurnitureProperty createInteriorFurnitureProperty();
	public InteriorRoomProperty createInteriorRoomProperty();
	public InteriorWallSurface createInteriorWallSurface();
	public OpeningProperty createOpeningProperty();
	public RoofSurface createRoofSurface();
	public Room createRoom();
	public WallSurface createWallSurface();
	public Window createWindow();
}
