package org.citygml4j.builder.convert.citygml;

import org.citygml4j.factory.CityGMLFactory;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.AbstractBuilding;
import org.citygml4j.model.citygml.building.BoundarySurface;
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
import org.citygml4j.model.citygml.building.Opening;
import org.citygml4j.model.citygml.building.OpeningProperty;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.building.WallSurface;
import org.citygml4j.model.citygml.building.Window;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.gml.GeometryProperty;
import org.citygml4j.model.gml.MultiSurfaceProperty;
import org.citygml4j.model.gml.SolidProperty;

public class BuildingConverter {
	private CityGMLConvertBuilder builder;
	private CityGMLFactory citygml;

	protected BuildingConverter(CityGMLConvertBuilder builder) {
		this.builder = builder;
		citygml = new CityGMLFactory();
	}

	protected BoundarySurfaceProperty convertBoundarySurfaceProperty(BoundarySurfaceProperty src) {
		BoundarySurfaceProperty dest = citygml.createBoundarySurfaceProperty(builder.convertContext.bldgModule);
		if (dest != null) {
			builder.gml.convertAssociation(src, dest);

			if (src.isSetObject()) {
				CityObject tmp = builder.core.convertCityObject(src.getObject());
				if (tmp != null && tmp instanceof BoundarySurface)
					dest.setObject((BoundarySurface)tmp);
			}
		}

		return dest;
	}

	protected Building convertBuilding(Building src) {
		Building dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof Building)
				dest = (Building)tmp;
		} else {
			dest = citygml.createBuilding(builder.convertContext.bldgModule);
			if (dest != null)
				convertBuilding(src, dest);
		}

		return dest;
	}

	protected BuildingFurniture convertBuildingFurniture(BuildingFurniture src) {
		BuildingFurniture dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof BuildingFurniture)
				dest = (BuildingFurniture)tmp;
		} else {
			dest = citygml.createBuildingFurniture(builder.convertContext.bldgModule);
			if (dest != null)
				convertBuildingFurniture(src, dest);
		}

		return dest;
	}

	protected BuildingInstallation convertBuildingInstallation(BuildingInstallation src) {
		BuildingInstallation dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof BuildingInstallation)
				dest = (BuildingInstallation)tmp;
		} else {
			dest = citygml.createBuildingInstallation(builder.convertContext.bldgModule);
			if (dest != null)
				convertBuildingInstallation(src, dest);
		}

		return dest;
	}

	protected BuildingInstallationProperty convertBuildingInstallationProperty(BuildingInstallationProperty src) {
		BuildingInstallationProperty dest = citygml.createBuildingInstallationProperty(builder.convertContext.bldgModule);
		if (dest != null) {
			builder.gml.convertAssociation(src, dest);

			if (src.isSetObject()) {
				BuildingInstallation tmp = convertBuildingInstallation(src.getObject());
				if (tmp != null)
					dest.setObject(tmp);
			}
		}

		return dest;
	}

	protected BuildingPart convertBuildingPart(BuildingPart src) {
		BuildingPart dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof BuildingPart)
				dest = (BuildingPart)tmp;
		} else {
			dest = citygml.createBuildingPart(builder.convertContext.bldgModule);
			if (dest != null)
				convertBuildingPart(src, dest);
		}

		return dest;
	}

	protected BuildingPartProperty convertBuildingPartProperty(BuildingPartProperty src) {
		BuildingPartProperty dest = citygml.createBuildingPartProperty(builder.convertContext.bldgModule);
		if (dest != null) {
			builder.gml.convertAssociation(src, dest);

			if (src.isSetObject()) {
				BuildingPart tmp = convertBuildingPart(src.getObject());
				if (tmp != null)
					dest.setObject(tmp);
			}
		}

		return dest;
	}

	protected CeilingSurface convertCeilingSurface(CeilingSurface src) {
		CeilingSurface dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof CeilingSurface)
				dest = (CeilingSurface)tmp;
		} else {
			dest = citygml.createCeilingSurface(builder.convertContext.bldgModule);
			if (dest != null)
				convertCeilingSurface(src, dest);
		}

		return dest;
	}

	protected ClosureSurface convertClosureSurface(ClosureSurface src) {
		ClosureSurface dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof ClosureSurface)
				dest = (ClosureSurface)tmp;
		} else {
			dest = citygml.createClosureSurface(builder.convertContext.bldgModule);
			if (dest != null)
				convertClosureSurface(src, dest);
		}

		return dest;
	}

	protected Door convertDoor(Door src) {
		Door dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof Door)
				dest = (Door)tmp;
		} else {
			dest = citygml.createDoor(builder.convertContext.bldgModule);
			if (dest != null)
				convertDoor(src, dest);
		}

		return dest;
	}

	protected FloorSurface convertFloorSurface(FloorSurface src) {
		FloorSurface dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof FloorSurface)
				dest = (FloorSurface)tmp;
		} else {
			dest = citygml.createFloorSurface(builder.convertContext.bldgModule);
			if (dest != null)
				convertFloorSurface(src, dest);
		}

		return dest;
	}

	protected GroundSurface convertGroundSurface(GroundSurface src) {
		GroundSurface dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof GroundSurface)
				dest = (GroundSurface)tmp;
		} else {
			dest = citygml.createGroundSurface(builder.convertContext.bldgModule);
			if (dest != null)
				convertGroundSurface(src, dest);
		}

		return dest;
	}

	protected IntBuildingInstallation convertIntBuildingInstallation(IntBuildingInstallation src) {
		IntBuildingInstallation dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof IntBuildingInstallation)
				dest = (IntBuildingInstallation)tmp;
		} else {
			dest = citygml.createIntBuildingInstallation(builder.convertContext.bldgModule);
			if (dest != null)
				convertIntBuildingInstallation(src, dest);
		}

		return dest;
	}

	protected IntBuildingInstallationProperty convertIntBuildingInstallationProperty(IntBuildingInstallationProperty src) {
		IntBuildingInstallationProperty dest = citygml.createIntBuildingInstallationProperty(builder.convertContext.bldgModule);
		if (dest != null) {
			builder.gml.convertAssociation(src, dest);

			if (src.isSetObject()) {
				IntBuildingInstallation tmp = convertIntBuildingInstallation(src.getObject());
				if (tmp != null)
					dest.setObject(tmp);
			}
		}

		return dest;
	}

	protected InteriorFurnitureProperty convertInteriorFurnitureProperty(InteriorFurnitureProperty src) {
		InteriorFurnitureProperty dest = citygml.createInteriorFurnitureProperty(builder.convertContext.bldgModule);
		if (dest != null) {
			builder.gml.convertAssociation(src, dest);

			if (src.isSetObject()) {
				BuildingFurniture tmp = convertBuildingFurniture(src.getObject());
				if (tmp != null)
					dest.setObject(tmp);
			}
		}

		return dest;
	}

	protected InteriorRoomProperty convertInteriorRoomProperty(InteriorRoomProperty src) {
		InteriorRoomProperty dest = citygml.createInteriorRoomProperty(builder.convertContext.bldgModule);
		if (dest != null) {
			builder.gml.convertAssociation(src, dest);

			if (src.isSetObject()) {
				Room tmp = convertRoom(src.getObject());
				if (tmp != null)
					dest.setObject(tmp);
			}
		}

		return dest;
	}

	protected InteriorWallSurface convertInteriorWallSurface(InteriorWallSurface src) {
		InteriorWallSurface dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof InteriorWallSurface)
				dest = (InteriorWallSurface)tmp;
		} else {
			dest = citygml.createInteriorWallSurface(builder.convertContext.bldgModule);
			if (dest != null)
				convertInteriorWallSurface(src, dest);
		}

		return dest;
	}

	protected OpeningProperty convertOpeningProperty(OpeningProperty src) {
		OpeningProperty dest = citygml.createOpeningProperty(builder.convertContext.bldgModule);
		if (dest != null) {
			builder.gml.convertAssociation(src, dest);

			if (src.isSetObject()) {
				CityObject tmp = builder.core.convertCityObject(src.getObject());
				if (tmp != null && tmp instanceof Opening)
					dest.setObject((Opening)tmp);
			}
		}

		return dest;
	}

	protected RoofSurface convertRoofSurface(RoofSurface src) {
		RoofSurface dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof RoofSurface)
				dest = (RoofSurface)tmp;
		} else {
			dest = citygml.createRoofSurface(builder.convertContext.bldgModule);
			if (dest != null)
				convertRoofSurface(src, dest);
		}

		return dest;
	}

	protected Room convertRoom(Room src) {
		Room dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof Room)
				dest = (Room)tmp;
		} else {
			dest = citygml.createRoom(builder.convertContext.bldgModule);
			if (dest != null)
				convertRoom(src, dest);
		}

		return dest;
	}

	protected WallSurface convertWallSurface(WallSurface src) {
		WallSurface dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof WallSurface)
				dest = (WallSurface)tmp;
		} else {
			dest = citygml.createWallSurface(builder.convertContext.bldgModule);
			if (dest != null)
				convertWallSurface(src, dest);
		}

		return dest;
	}

	protected Window convertWindow(Window src) {
		Window dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof Window)
				dest = (Window)tmp;
		} else {
			dest = citygml.createWindow(builder.convertContext.bldgModule);
			if (dest != null)
				convertWindow(src, dest);
		}

		return dest;
	}

	protected void convertAbstractBuilding(AbstractBuilding src, AbstractBuilding dest) {
		builder.core.convertSite(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetYearOfConstruction())
			dest.setYearOfConstruction(src.getYearOfConstruction());

		if (src.isSetYearOfDemolition())
			dest.setYearOfDemolition(src.getYearOfDemolition());

		if (src.isSetRoofType())
			dest.setRoofType(src.getRoofType());

		if (src.isSetMeasuredHeight())
			dest.setMeasuredHeight(src.getMeasuredHeight());

		if (src.isSetStoreysAboveGround())
			dest.setStoreysAboveGround(src.getStoreysAboveGround());

		if (src.isSetStoreysBelowGround())
			dest.setStoreysBelowGround(src.getStoreysBelowGround());

		if (src.isSetStoreyHeightsAboveGround())
			dest.setStoreyHeightsAboveGround(src.getStoreyHeightsAboveGround());

		if (src.isSetStoreyHeightsBelowGround())
			dest.setStoreyHeightsBelowGround(src.getStoreyHeightsBelowGround());

		if (src.isSetLod1Solid()) {
			SolidProperty tmp = builder.gml.convertSolidProperty(src.getLod1Solid());
			if (tmp != null)
				dest.setLod1Solid(tmp);
		}

		if (src.isSetLod2Solid()) {
			SolidProperty tmp = builder.gml.convertSolidProperty(src.getLod2Solid());
			if (tmp != null)
				dest.setLod2Solid(tmp);
		}

		if (src.isSetLod3Solid()) {
			SolidProperty tmp = builder.gml.convertSolidProperty(src.getLod3Solid());
			if (tmp != null)
				dest.setLod3Solid(tmp);
		}

		if (src.isSetLod4Solid()) {
			SolidProperty tmp = builder.gml.convertSolidProperty(src.getLod4Solid());
			if (tmp != null)
				dest.setLod4Solid(tmp);
		}

		if (src.isSetLod1TerrainIntersection())
			dest.setLod1TerrainIntersection(src.getLod1TerrainIntersection());

		if (src.isSetLod2TerrainIntersection())
			dest.setLod2TerrainIntersection(src.getLod2TerrainIntersection());

		if (src.isSetLod3TerrainIntersection())
			dest.setLod3TerrainIntersection(src.getLod3TerrainIntersection());

		if (src.isSetLod4TerrainIntersection())
			dest.setLod4TerrainIntersection(src.getLod4TerrainIntersection());

		if (src.isSetLod2MultiCurve())
			dest.setLod2MultiCurve(src.getLod2MultiCurve());

		if (src.isSetLod3MultiCurve())
			dest.setLod3MultiCurve(src.getLod3MultiCurve());

		if (src.isSetLod4MultiCurve())
			dest.setLod4MultiCurve(src.getLod4MultiCurve());

		if (src.isSetLod1MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod1MultiSurface());
			if (tmp != null)
				dest.setLod1MultiSurface(tmp);
		}

		if (src.isSetLod2MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod2MultiSurface());
			if (tmp != null)
				dest.setLod2MultiSurface(tmp);
		}

		if (src.isSetLod3MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod3MultiSurface());
			if (tmp != null)
				dest.setLod3MultiSurface(tmp);
		}

		if (src.isSetLod4MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod4MultiSurface());
			if (tmp != null)
				dest.setLod4MultiSurface(tmp);
		}

		if (src.isSetOuterBuildingInstallation()) {
			for (BuildingInstallationProperty outer : src.getOuterBuildingInstallation()) {
				BuildingInstallationProperty tmp = convertBuildingInstallationProperty(outer);
				if (tmp != null)
					dest.addOuterBuildingInstallation(tmp);
			}
		}

		if (src.isSetInteriorBuildingInstallation()) {
			for (IntBuildingInstallationProperty interior : src.getInteriorBuildingInstallation()) {
				IntBuildingInstallationProperty tmp = convertIntBuildingInstallationProperty(interior);
				if (tmp != null)
					dest.addInteriorBuildingInstallation(tmp);
			}
		}

		if (src.isSetBoundedBySurfaces()) {
			for (BoundarySurfaceProperty boundedBy : src.getBoundedBySurfaces()) {
				BoundarySurfaceProperty tmp = convertBoundarySurfaceProperty(boundedBy);
				if (tmp != null)
					dest.addBoundedBySurface(tmp);
			}
		}

		if (src.isSetConsistsOfBuildingPart()) {
			for (BuildingPartProperty part : src.getConsistsOfBuildingPart()) {
				BuildingPartProperty tmp = convertBuildingPartProperty(part);
				if (tmp != null)
					dest.addConsistsOfBuildingPart(tmp);
			}
		}

		if (src.isSetInteriorRoom()) {
			for (InteriorRoomProperty room : src.getInteriorRoom()) {
				InteriorRoomProperty tmp = convertInteriorRoomProperty(room);
				if (tmp != null)
					dest.addInteriorRoom(tmp);
			}
		}

		if (src.isSetAddress()) {
			for (AddressProperty addressProperty : src.getAddress()) {
				AddressProperty tmp = builder.core.convertAddressProperty(addressProperty);
				if (tmp != null)
					dest.addAddress(tmp);
			}
		}

		if (src.isSetGenericApplicationPropertyOfAbstractBuilding()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfAbstractBuilding()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfAbstractBuilding(tmp);
			}
		}
	}

	protected void convertBoundarySurface(BoundarySurface src, BoundarySurface dest) {
		builder.core.convertCityObject(src, dest);

		if (src.isSetLod2MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod2MultiSurface());
			if (tmp != null)
				dest.setLod2MultiSurface(tmp);
		}

		if (src.isSetLod3MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod3MultiSurface());
			if (tmp != null)
				dest.setLod3MultiSurface(tmp);
		}

		if (src.isSetLod4MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod4MultiSurface());
			if (tmp != null)
				dest.setLod4MultiSurface(tmp);
		}

		if (src.isSetOpening()) {
			for (OpeningProperty opening : src.getOpening()) {
				OpeningProperty tmp = convertOpeningProperty(opening);
				if (tmp != null)
					dest.addOpening(tmp);
			}
		}

		if (src.isSetGenericApplicationPropertyOfBoundarySurface()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfBoundarySurface()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfBoundarySurface(tmp);
			}
		}
	}

	protected void convertBuilding(Building src, Building dest) {
		convertAbstractBuilding(src, dest);

		if (src.isSetGenericApplicationPropertyOfBuilding()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfBuilding()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfBuilding(tmp);
			}
		}
	}

	protected void convertBuildingFurniture(BuildingFurniture src, BuildingFurniture dest) {
		builder.core.convertCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetLod4Geometry()) {
			GeometryProperty tmp = builder.gml.convertGeometryProperty(src.getLod4Geometry());
			if (tmp != null)
				dest.setLod4Geometry(tmp);
		}

		if (src.isSetLoD4ImplicitRepresentation()) {
			ImplicitRepresentationProperty tmp = builder.core.convertImplicitRepresentationProperty(src.getLoD4ImplicitRepresentation());
			if (tmp != null)
				dest.setLoD4ImplicitRepresentation(tmp);
		}

		if (src.isSetGenericApplicationPropertyOfBuildingFurniture()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfBuildingFurniture()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfBuildingFurniture(tmp);
			}
		}
	}

	protected void convertBuildingInstallation(BuildingInstallation src, BuildingInstallation dest) {
		builder.core.convertCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetLod2Geometry()) {
			GeometryProperty tmp = builder.gml.convertGeometryProperty(src.getLod2Geometry());
			if (tmp != null)
				dest.setLod2Geometry(tmp);
		}

		if (src.isSetLod3Geometry()) {
			GeometryProperty tmp = builder.gml.convertGeometryProperty(src.getLod3Geometry());
			if (tmp != null)
				dest.setLod3Geometry(tmp);
		}

		if (src.isSetLod4Geometry()) {
			GeometryProperty tmp = builder.gml.convertGeometryProperty(src.getLod4Geometry());
			if (tmp != null)
				dest.setLod4Geometry(tmp);
		}

		if (src.isSetGenericApplicationPropertyOfBuildingInstallation()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfBuildingInstallation()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfBuildingInstallation(tmp);
			}
		}
	}

	protected void convertBuildingPart(BuildingPart src, BuildingPart dest) {
		convertAbstractBuilding(src, dest);

		if (src.isSetGenericApplicationPropertyOfBuildingPart()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfBuildingPart()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfBuildingPart(tmp);
			}
		}
	}

	protected void convertCeilingSurface(CeilingSurface src, CeilingSurface dest) {
		convertBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfCeilingSurface()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfCeilingSurface()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfCeilingSurface(tmp);
			}
		}
	}

	protected void convertClosureSurface(ClosureSurface src, ClosureSurface dest) {
		convertBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfClosureSurface()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfClosureSurface()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfClosureSurface(tmp);
			}
		}
	}

	protected void convertDoor(Door src, Door dest) {
		convertOpening(src, dest);

		if (src.isSetAddress()) {
			for (AddressProperty address : src.getAddress()) {
				AddressProperty tmp = builder.core.convertAddressProperty(address);
				if (tmp != null)
					dest.addAddress(tmp);
			}
		}

		if (src.isSetGenericApplicationPropertyOfDoor()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfDoor()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfDoor(tmp);
			}
		}
	}

	protected void convertFloorSurface(FloorSurface src, FloorSurface dest) {
		convertBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfFloorSurface()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfFloorSurface()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfFloorSurface(tmp);
			}
		}
	}

	protected void convertGroundSurface(GroundSurface src, GroundSurface dest) {
		convertBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfGroundSurface()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfGroundSurface()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfGroundSurface(tmp);
			}
		}
	}

	protected void convertIntBuildingInstallation(IntBuildingInstallation src, IntBuildingInstallation dest) {
		builder.core.convertCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetLod4Geometry()) {
			GeometryProperty tmp = builder.gml.convertGeometryProperty(src.getLod4Geometry());
			if (tmp != null)
				dest.setLod4Geometry(tmp);
		}

		if (src.isSetGenericApplicationPropertyOfIntBuildingInstallation()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfIntBuildingInstallation()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfIntBuildingInstallation(tmp);
			}
		}
	}

	protected void convertInteriorWallSurface(InteriorWallSurface src, InteriorWallSurface dest) {
		convertBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfInteriorWallSurface()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfInteriorWallSurface()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfInteriorWallSurface(tmp);
			}
		}
	}

	protected void convertOpening(Opening src, Opening dest) {
		builder.core.convertCityObject(src, dest);

		if (src.isSetLod3MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod3MultiSurface());
			if (tmp != null)
				dest.setLod3MultiSurface(tmp);
		}

		if (src.isSetLod4MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod4MultiSurface());
			if (tmp != null)
				dest.setLod4MultiSurface(tmp);
		}

		if (src.isSetGenericApplicationPropertyOfOpening()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfOpening()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfOpening(tmp);
			}
		}
	}

	protected void convertRoom(Room src, Room dest) {
		builder.core.convertCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetBoundedBySurfaces()) {
			for (BoundarySurfaceProperty boundedBy : src.getBoundedBySurfaces()) {
				BoundarySurfaceProperty tmp = convertBoundarySurfaceProperty(boundedBy);
				if (tmp != null)
					dest.addBoundedBySurface(tmp);
			}
		}

		if (src.isSetInteriorFurniture()) {
			for (InteriorFurnitureProperty furniture : src.getInteriorFurniture()) {
				InteriorFurnitureProperty tmp = convertInteriorFurnitureProperty(furniture);
				if (tmp != null)
					dest.addInteriorFurniture(tmp);
			}
		}

		if (src.isSetRoomInstallation()) {
			for (IntBuildingInstallationProperty roomInstallation : src.getRoomInstallation()) {
				IntBuildingInstallationProperty tmp = convertIntBuildingInstallationProperty(roomInstallation);
				if (tmp != null)
					dest.addRoomInstallation(tmp);
			}
		}

		if (src.isSetLod4Solid()) {
			SolidProperty tmp = builder.gml.convertSolidProperty(src.getLod4Solid());
			if (tmp != null)
				dest.setLod4Solid(tmp);
		}

		if (src.isSetLod4MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod4MultiSurface());
			if (tmp != null)
				dest.setLod4MultiSurface(tmp);
		}

		if (src.isSetGenericApplicationPropertyOfRoom()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfRoom()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfRoom(tmp);
			}
		}
	}

	protected void convertRoofSurface(RoofSurface src, RoofSurface dest) {
		convertBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfRoofSurface()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfRoofSurface()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfRoofSurface(tmp);
			}
		}
	}

	protected void convertWallSurface(WallSurface src, WallSurface dest) {
		convertBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfWallSurface()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfWallSurface()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfWallSurface(tmp);
			}
		}
	}

	protected void convertWindow(Window src, Window dest) {
		convertOpening(src, dest);

		if (src.isSetGenericApplicationPropertyOfWindow()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfWindow()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfWindow(tmp);
			}
		}
	}
}
