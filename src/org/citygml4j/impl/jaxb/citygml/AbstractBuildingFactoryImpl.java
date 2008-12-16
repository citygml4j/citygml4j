package org.citygml4j.impl.jaxb.citygml;

import org.citygml4j.impl.jaxb.citygml.building._0_4.Building040FactoryImpl;
import org.citygml4j.impl.jaxb.citygml.building._1.Building100FactoryImpl;
import org.citygml4j.model.citygml.building.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.building.BuildingFactory;
import org.citygml4j.model.citygml.building.BuildingFurniture;
import org.citygml4j.model.citygml.building.BuildingInstallation;
import org.citygml4j.model.citygml.building.BuildingInstallationProperty;
import org.citygml4j.model.citygml.building.BuildingModule;
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

public abstract class AbstractBuildingFactoryImpl implements BuildingFactory {
	private static Building040FactoryImpl factory040 = new Building040FactoryImpl();
	private static Building100FactoryImpl factory100 = new Building100FactoryImpl();
	
	public static BuildingFactory getInstance(BuildingModule module) {
		switch (module) {
		case v0_4_0:
			return factory040;
		default:
			return factory100;
		}
	}
	
	@Override
	public abstract BoundarySurfaceProperty createBoundarySurfaceProperty();

	@Override
	public abstract Building createBuilding();

	@Override
	public abstract BuildingFurniture createBuildingFurniture();

	@Override
	public abstract BuildingInstallation createBuildingInstallation();

	@Override
	public abstract BuildingInstallationProperty createBuildingInstallationProperty();

	@Override
	public abstract BuildingPart createBuildingPart();

	@Override
	public abstract BuildingPartProperty createBuildingPartProperty();

	@Override
	public abstract CeilingSurface createCeilingSurface();

	@Override
	public abstract ClosureSurface createClosureSurface();

	@Override
	public abstract Door createDoor();

	@Override
	public abstract FloorSurface createFloorSurface();

	@Override
	public abstract GroundSurface createGroundSurface();

	@Override
	public abstract IntBuildingInstallation createIntBuildingInstallation();

	@Override
	public abstract IntBuildingInstallationProperty createIntBuildingInstallationProperty();

	@Override
	public abstract InteriorFurnitureProperty createInteriorFurnitureProperty();

	@Override
	public abstract InteriorRoomProperty createInteriorRoomProperty();

	@Override
	public abstract InteriorWallSurface createInteriorWallSurface();

	@Override
	public abstract OpeningProperty createOpeningProperty();

	@Override
	public abstract RoofSurface createRoofSurface();

	@Override
	public abstract Room createRoom();

	@Override
	public abstract WallSurface createWallSurface();

	@Override
	public abstract Window createWindow();

}
