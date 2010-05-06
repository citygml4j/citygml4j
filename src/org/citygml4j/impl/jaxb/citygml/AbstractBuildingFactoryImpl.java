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
	
	public abstract BoundarySurfaceProperty createBoundarySurfaceProperty();

	public abstract Building createBuilding();

	public abstract BuildingFurniture createBuildingFurniture();

	public abstract BuildingInstallation createBuildingInstallation();

	public abstract BuildingInstallationProperty createBuildingInstallationProperty();

	public abstract BuildingPart createBuildingPart();

	public abstract BuildingPartProperty createBuildingPartProperty();

	public abstract CeilingSurface createCeilingSurface();

	public abstract ClosureSurface createClosureSurface();

	public abstract Door createDoor();

	public abstract FloorSurface createFloorSurface();

	public abstract GroundSurface createGroundSurface();

	public abstract IntBuildingInstallation createIntBuildingInstallation();

	public abstract IntBuildingInstallationProperty createIntBuildingInstallationProperty();

	public abstract InteriorFurnitureProperty createInteriorFurnitureProperty();

	public abstract InteriorRoomProperty createInteriorRoomProperty();

	public abstract InteriorWallSurface createInteriorWallSurface();

	public abstract OpeningProperty createOpeningProperty();

	public abstract RoofSurface createRoofSurface();

	public abstract Room createRoom();

	public abstract WallSurface createWallSurface();

	public abstract Window createWindow();

}
