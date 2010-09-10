package org.citygml4j.builder.jaxb.unmarshal.citygml.building;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
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
import org.citygml4j.impl.citygml.building.RoofSurfaceImpl;
import org.citygml4j.impl.citygml.building.RoomImpl;
import org.citygml4j.impl.citygml.building.WallSurfaceImpl;
import org.citygml4j.impl.citygml.building.WindowImpl;
import org.citygml4j.jaxb.citygml.bldg._1.AbstractBoundarySurfaceType;
import org.citygml4j.jaxb.citygml.bldg._1.AbstractBuildingType;
import org.citygml4j.jaxb.citygml.bldg._1.AbstractOpeningType;
import org.citygml4j.jaxb.citygml.bldg._1.BoundarySurfacePropertyType;
import org.citygml4j.jaxb.citygml.bldg._1.BuildingFurnitureType;
import org.citygml4j.jaxb.citygml.bldg._1.BuildingInstallationPropertyType;
import org.citygml4j.jaxb.citygml.bldg._1.BuildingInstallationType;
import org.citygml4j.jaxb.citygml.bldg._1.BuildingPartPropertyType;
import org.citygml4j.jaxb.citygml.bldg._1.BuildingPartType;
import org.citygml4j.jaxb.citygml.bldg._1.BuildingType;
import org.citygml4j.jaxb.citygml.bldg._1.CeilingSurfaceType;
import org.citygml4j.jaxb.citygml.bldg._1.ClosureSurfaceType;
import org.citygml4j.jaxb.citygml.bldg._1.DoorType;
import org.citygml4j.jaxb.citygml.bldg._1.FloorSurfaceType;
import org.citygml4j.jaxb.citygml.bldg._1.GroundSurfaceType;
import org.citygml4j.jaxb.citygml.bldg._1.IntBuildingInstallationPropertyType;
import org.citygml4j.jaxb.citygml.bldg._1.IntBuildingInstallationType;
import org.citygml4j.jaxb.citygml.bldg._1.InteriorFurniturePropertyType;
import org.citygml4j.jaxb.citygml.bldg._1.InteriorRoomPropertyType;
import org.citygml4j.jaxb.citygml.bldg._1.InteriorWallSurfaceType;
import org.citygml4j.jaxb.citygml.bldg._1.OpeningPropertyType;
import org.citygml4j.jaxb.citygml.bldg._1.RoofSurfaceType;
import org.citygml4j.jaxb.citygml.bldg._1.RoomType;
import org.citygml4j.jaxb.citygml.bldg._1.WallSurfaceType;
import org.citygml4j.jaxb.citygml.bldg._1.WindowType;
import org.citygml4j.jaxb.citygml.core._1.AddressPropertyType;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.AbstractBuilding;
import org.citygml4j.model.citygml.building.AbstractBoundarySurface;
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
import org.citygml4j.model.citygml.building.AbstractOpening;
import org.citygml4j.model.citygml.building.OpeningProperty;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.building.WallSurface;
import org.citygml4j.model.citygml.building.Window;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

public class Building100Unmarshaller {
	private final BuildingModule module = BuildingModule.v1_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;

	public Building100Unmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBUnmarshaller();
	}

	public CityGML unmarshal(JAXBElement<?> src) throws MissingADESchemaException {
		return unmarshal(src.getValue());
	}

	public CityGML unmarshal(Object src) throws MissingADESchemaException {
		if (src instanceof JAXBElement<?>)
			return unmarshal((JAXBElement<?>)src);
		
		CityGML dest = null;
		
		if (src instanceof BoundarySurfacePropertyType)
			dest = unmarshalBoundarySurfaceProperty((BoundarySurfacePropertyType)src);
		else if (src instanceof BuildingType)
			dest = unmarshalBuilding((BuildingType)src);		
		else if (src instanceof BuildingFurnitureType)
			dest = unmarshalBuildingFurniture((BuildingFurnitureType)src);
		else if (src instanceof BuildingInstallationType)
			dest = unmarshalBuildingInstallation((BuildingInstallationType)src);
		else if (src instanceof BuildingInstallationPropertyType)
			dest = unmarshalBuildingInstallationProperty((BuildingInstallationPropertyType)src);
		else if (src instanceof BuildingPartType)
			dest = unmarshalBuildingPart((BuildingPartType)src);
		else if (src instanceof BuildingPartPropertyType)
			dest = unmarshalBuildingPartProperty((BuildingPartPropertyType)src);
		else if (src instanceof CeilingSurfaceType)
			dest = unmarshalCeilingSurface((CeilingSurfaceType)src);
		else if (src instanceof ClosureSurfaceType)
			dest = unmarshalClosureSurface((ClosureSurfaceType)src);		
		else if (src instanceof DoorType)
			dest = unmarshalDoor((DoorType)src);
		else if (src instanceof FloorSurfaceType)
			dest = unmarshalFloorSurface((FloorSurfaceType)src);
		else if (src instanceof GroundSurfaceType)
			dest = unmarshalGroundSurface((GroundSurfaceType)src);
		else if (src instanceof IntBuildingInstallationType)
			dest = unmarshalIntBuildingInstallation((IntBuildingInstallationType)src);
		else if (src instanceof IntBuildingInstallationPropertyType)
			dest = unmarshalIntBuildingInstallationProperty((IntBuildingInstallationPropertyType)src);
		else if (src instanceof InteriorFurniturePropertyType)
			dest = unmarshalInteriorFurnitureProperty((InteriorFurniturePropertyType)src);
		else if (src instanceof InteriorRoomPropertyType)
			dest = unmarshalInteriorRoomProperty((InteriorRoomPropertyType)src);
		else if (src instanceof InteriorWallSurfaceType)
			dest = unmarshalInteriorWallSurface((InteriorWallSurfaceType)src);		
		else if (src instanceof OpeningPropertyType)
			dest = unmarshalOpeningProperty((OpeningPropertyType)src);
		else if (src instanceof RoofSurfaceType)
			dest = unmarshalRoofSurface((RoofSurfaceType)src);	
		else if (src instanceof RoomType)
			dest = unmarshalRoom((RoomType)src);
		else if (src instanceof WallSurfaceType)
			dest = unmarshalWallSurface((WallSurfaceType)src);	
		else if (src instanceof WindowType)
			dest = unmarshalWindow((WindowType)src);
		
		return dest;
	}

	public void unmarshalAbstractBuilding(AbstractBuildingType src, AbstractBuilding dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalSite(src, dest);
		
		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());
		
		if (src.isSetYearOfConstruction())
			dest.setYearOfConstruction(src.getYearOfConstruction().toGregorianCalendar());
		
		if (src.isSetYearOfDemolition())
			dest.setYearOfDemolition(src.getYearOfDemolition().toGregorianCalendar());
		
		if (src.isSetRoofType())
			dest.setRoofType(src.getRoofType());
		
		if (src.isSetMeasuredHeight())
			dest.setMeasuredHeight(jaxb.getGMLUnmarshaller().unmarshalLength(src.getMeasuredHeight()));
		
		if (src.isSetStoreysAboveGround())
			dest.setStoreysAboveGround(src.getStoreysAboveGround().intValue());
		
		if (src.isSetStoreysBelowGround())
			dest.setStoreysBelowGround(src.getStoreysBelowGround().intValue());
		
		if (src.isSetStoreyHeightsAboveGround())
			dest.setStoreyHeightsAboveGround(jaxb.getGMLUnmarshaller().unmarshalMeasureOrNullList(src.getStoreyHeightsAboveGround()));
		
		if (src.isSetStoreyHeightsBelowGround())
			dest.setStoreyHeightsBelowGround(jaxb.getGMLUnmarshaller().unmarshalMeasureOrNullList(src.getStoreyHeightsBelowGround()));
		
		if (src.isSetLod1Solid())
			dest.setLod1Solid(jaxb.getGMLUnmarshaller().unmarshalSolidProperty(src.getLod1Solid()));
		
		if (src.isSetLod2Solid())
			dest.setLod2Solid(jaxb.getGMLUnmarshaller().unmarshalSolidProperty(src.getLod2Solid()));
		
		if (src.isSetLod3Solid())
			dest.setLod3Solid(jaxb.getGMLUnmarshaller().unmarshalSolidProperty(src.getLod3Solid()));
		
		if (src.isSetLod4Solid())
			dest.setLod4Solid(jaxb.getGMLUnmarshaller().unmarshalSolidProperty(src.getLod4Solid()));
		
		if (src.isSetLod1MultiSurface())
			dest.setLod1MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod1MultiSurface()));
		
		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod2MultiSurface()));
		
		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod3MultiSurface()));
		
		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod4MultiSurface()));
		
		if (src.isSetLod1TerrainIntersection())
			dest.setLod1TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod1TerrainIntersection()));
		
		if (src.isSetLod2TerrainIntersection())
			dest.setLod2TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod2TerrainIntersection()));
		
		if (src.isSetLod3TerrainIntersection())
			dest.setLod3TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod3TerrainIntersection()));
		
		if (src.isSetLod4TerrainIntersection())
			dest.setLod4TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod4TerrainIntersection()));
		
		if (src.isSetLod2MultiCurve())
			dest.setLod2MultiCurve(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod2MultiCurve()));
		
		if (src.isSetLod3MultiCurve())
			dest.setLod3MultiCurve(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod3MultiCurve()));
		
		if (src.isSetLod4MultiCurve())
			dest.setLod4MultiCurve(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod4MultiCurve()));	
		
		if (src.isSetOuterBuildingInstallation()) {
			for (BuildingInstallationPropertyType buildingInstallationProperty : src.getOuterBuildingInstallation())
				dest.addOuterBuildingInstallation(unmarshalBuildingInstallationProperty(buildingInstallationProperty));
		}
		
		if (src.isSetInteriorBuildingInstallation()) {
			for (IntBuildingInstallationPropertyType intBuildingInstallationProperty : src.getInteriorBuildingInstallation())
				dest.addInteriorBuildingInstallation(unmarshalIntBuildingInstallationProperty(intBuildingInstallationProperty));
		}
		
		if (src.isSetBoundedBySurface()) {
			for (BoundarySurfacePropertyType boundarySurfaceProperty : src.getBoundedBySurface())
				dest.addBoundedBySurface(unmarshalBoundarySurfaceProperty(boundarySurfaceProperty));
		}
		
		if (src.isSetConsistsOfBuildingPart()) {
			for (BuildingPartPropertyType buildingPartProperty : src.getConsistsOfBuildingPart())
				dest.addConsistsOfBuildingPart(unmarshalBuildingPartProperty(buildingPartProperty));
		}
		
		if (src.isSetInteriorRoom()) {
			for (InteriorRoomPropertyType interiorRoomProperty : src.getInteriorRoom())
				dest.addInteriorRoom(unmarshalInteriorRoomProperty(interiorRoomProperty));
		}
		
		if (src.isSetAddress()) {
			for (AddressPropertyType addressProperty : src.getAddress())
				dest.addAddress(citygml.getCore100Unmarshaller().unmarshalAddressProperty(addressProperty));
		}	
	}
	
	public void unmarshalBoundarySurface(AbstractBoundarySurfaceType src, AbstractBoundarySurface dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalCityObject(src, dest);

		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod2MultiSurface()));

		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod3MultiSurface()));

		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod4MultiSurface()));

		if (src.isSetOpening()) {
			for (OpeningPropertyType openingProperty : src.getOpening())
				dest.addOpening(unmarshalOpeningProperty(openingProperty));
		}
	}
	
	public void unmarshalOpening(AbstractOpeningType src, AbstractOpening dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalCityObject(src, dest);

		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod3MultiSurface()));

		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod4MultiSurface()));
	}

	public BoundarySurfaceProperty unmarshalBoundarySurfaceProperty(BoundarySurfacePropertyType src) throws MissingADESchemaException {
		BoundarySurfaceProperty dest = new BoundarySurfacePropertyImpl(module);
		jaxb.getGMLUnmarshaller().unmarshalFeatureProperty(src, dest);

		if (src.isSet_Object()) {
			Object object = jaxb.unmarshal(src.get_Object());
			if (object instanceof AbstractBoundarySurface)
				dest.setObject((AbstractBoundarySurface)object);
		}
		
		return dest;
	}

	public void unmarshalBuilding(BuildingType src, Building dest) throws MissingADESchemaException {
		unmarshalAbstractBuilding(src, dest);
	}

	public Building unmarshalBuilding(BuildingType src) throws MissingADESchemaException {
		Building dest = new BuildingImpl(module);
		unmarshalBuilding(src, dest);

		return dest;
	}
	
	public void unmarshalBuildingFurniture(BuildingFurnitureType src, BuildingFurniture dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod4Geometry()));

		if (src.isSetLod4ImplicitRepresentation())
			dest.setLod4ImplicitRepresentation(citygml.getCore100Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod4ImplicitRepresentation()));
	}

	public BuildingFurniture unmarshalBuildingFurniture(BuildingFurnitureType src) throws MissingADESchemaException {
		BuildingFurniture dest = new BuildingFurnitureImpl(module);
		unmarshalBuildingFurniture(src, dest);

		return dest;
	}

	public void unmarshalBuildingInstallation(BuildingInstallationType src, BuildingInstallation dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetLod2Geometry())
			dest.setLod2Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod2Geometry()));

		if (src.isSetLod3Geometry())
			dest.setLod3Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod3Geometry()));

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod4Geometry()));
	}

	public BuildingInstallation unmarshalBuildingInstallation(BuildingInstallationType src) throws MissingADESchemaException {
		BuildingInstallation dest = new BuildingInstallationImpl(module);
		unmarshalBuildingInstallation(src, dest);

		return dest;
	}

	public BuildingInstallationProperty unmarshalBuildingInstallationProperty(BuildingInstallationPropertyType src) throws MissingADESchemaException {
		BuildingInstallationProperty dest = new BuildingInstallationPropertyImpl(module);
		jaxb.getGMLUnmarshaller().unmarshalFeatureProperty(src, dest);

		if (src.isSet_Object()) {
			Object object = jaxb.unmarshal(src.get_Object());
			if (object instanceof BuildingInstallation)
				dest.setObject((BuildingInstallation)object);
		}
		
		return dest;
	}

	public void unmarshalBuildingPart(BuildingPartType src, BuildingPart dest) throws MissingADESchemaException {
		unmarshalAbstractBuilding(src, dest);
	}

	public BuildingPart unmarshalBuildingPart(BuildingPartType src) throws MissingADESchemaException {
		BuildingPart dest = new BuildingPartImpl(module);
		unmarshalBuildingPart(src, dest);

		return dest;
	}

	public BuildingPartProperty unmarshalBuildingPartProperty(BuildingPartPropertyType src) throws MissingADESchemaException {
		BuildingPartProperty dest = new BuildingPartPropertyImpl(module);
		jaxb.getGMLUnmarshaller().unmarshalFeatureProperty(src, dest);

		if (src.isSet_Object()) {
			Object object = jaxb.unmarshal(src.get_Object());
			if (object instanceof BuildingPart)
				dest.setObject((BuildingPart)object);
		}
		
		return dest;
	}

	public void unmarshalCeilingSurface(CeilingSurfaceType src, CeilingSurface dest) throws MissingADESchemaException {
		unmarshalBoundarySurface(src, dest);
	}

	public CeilingSurface unmarshalCeilingSurface(CeilingSurfaceType src) throws MissingADESchemaException {
		CeilingSurface dest = new CeilingSurfaceImpl(module);
		unmarshalCeilingSurface(src, dest);

		return dest;
	}

	public void unmarshalClosureSurface(ClosureSurfaceType src, ClosureSurface dest) throws MissingADESchemaException {
		unmarshalBoundarySurface(src, dest);
	}

	public ClosureSurface unmarshalClosureSurface(ClosureSurfaceType src) throws MissingADESchemaException {
		ClosureSurface dest = new ClosureSurfaceImpl(module);
		unmarshalClosureSurface(src, dest);

		return dest;
	}

	public void unmarshalDoor(DoorType src, Door dest) throws MissingADESchemaException {
		unmarshalOpening(src, dest);

		if (src.isSetAddress()) {
			for (AddressPropertyType addressProperty : src.getAddress())
				dest.addAddress(citygml.getCore100Unmarshaller().unmarshalAddressProperty(addressProperty));
		}
	}

	public Door unmarshalDoor(DoorType src) throws MissingADESchemaException {
		Door dest = new DoorImpl(module);
		unmarshalDoor(src, dest);

		return dest;
	}

	public void unmarshalFloorSurface(FloorSurfaceType src, FloorSurface dest) throws MissingADESchemaException {
		unmarshalBoundarySurface(src, dest);
	}

	public FloorSurface unmarshalFloorSurface(FloorSurfaceType src) throws MissingADESchemaException {
		FloorSurface dest = new FloorSurfaceImpl(module);
		unmarshalFloorSurface(src, dest);

		return dest;
	}

	public void unmarshalGroundSurface(GroundSurfaceType src, GroundSurface dest) throws MissingADESchemaException {
		unmarshalBoundarySurface(src, dest);
	}

	public GroundSurface unmarshalGroundSurface(GroundSurfaceType src) throws MissingADESchemaException {
		GroundSurface dest = new GroundSurfaceImpl(module);
		unmarshalGroundSurface(src, dest);

		return dest;
	}

	public void unmarshalIntBuildingInstallation(IntBuildingInstallationType src, IntBuildingInstallation dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod4Geometry()));
	}

	public IntBuildingInstallation unmarshalIntBuildingInstallation(IntBuildingInstallationType src) throws MissingADESchemaException {
		IntBuildingInstallation dest = new IntBuildingInstallationImpl(module);
		unmarshalIntBuildingInstallation(src, dest);

		return dest;
	}

	public IntBuildingInstallationProperty unmarshalIntBuildingInstallationProperty(IntBuildingInstallationPropertyType src) throws MissingADESchemaException {
		IntBuildingInstallationProperty dest = new IntBuildingInstallationPropertyImpl(module);
		jaxb.getGMLUnmarshaller().unmarshalFeatureProperty(src, dest);

		if (src.isSet_Object()) {
			Object object = jaxb.unmarshal(src.get_Object());
			if (object instanceof IntBuildingInstallation)
				dest.setObject((IntBuildingInstallation)object);
		}
		
		return dest;
	}

	public InteriorFurnitureProperty unmarshalInteriorFurnitureProperty(InteriorFurniturePropertyType src) throws MissingADESchemaException {
		InteriorFurnitureProperty dest = new InteriorFurniturePropertyImpl(module);
		jaxb.getGMLUnmarshaller().unmarshalFeatureProperty(src, dest);

		if (src.isSet_Object()) {
			Object object = jaxb.unmarshal(src.get_Object());
			if (object instanceof BuildingFurniture)
				dest.setObject((BuildingFurniture)object);
		}
		
		return dest;
	}

	public InteriorRoomProperty unmarshalInteriorRoomProperty(InteriorRoomPropertyType src) throws MissingADESchemaException {
		InteriorRoomProperty dest = new InteriorRoomPropertyImpl(module);
		jaxb.getGMLUnmarshaller().unmarshalFeatureProperty(src, dest);

		if (src.isSet_Object()) {
			Object object = jaxb.unmarshal(src.get_Object());
			if (object instanceof Room)
				dest.setObject((Room)object);
		}
		
		return dest;
	}

	public void unmarshalInteriorWallSurface(InteriorWallSurfaceType src, InteriorWallSurface dest) throws MissingADESchemaException {
		unmarshalBoundarySurface(src, dest);
	}

	public InteriorWallSurface unmarshalInteriorWallSurface(InteriorWallSurfaceType src) throws MissingADESchemaException {
		InteriorWallSurface dest = new InteriorWallSurfaceImpl(module);
		unmarshalInteriorWallSurface(src, dest);

		return dest;
	}

	public OpeningProperty unmarshalOpeningProperty(OpeningPropertyType src) throws MissingADESchemaException {
		OpeningProperty dest = new OpeningPropertyImpl(module);
		jaxb.getGMLUnmarshaller().unmarshalFeatureProperty(src, dest);

		if (src.isSet_Object()) {
			Object object = jaxb.unmarshal(src.get_Object());
			if (object instanceof AbstractOpening)
				dest.setObject((AbstractOpening)object);
		}
		
		return dest;
	}

	public void unmarshalRoofSurface(RoofSurfaceType src, RoofSurface dest) throws MissingADESchemaException {
		unmarshalBoundarySurface(src, dest);
	}

	public RoofSurface unmarshalRoofSurface(RoofSurfaceType src) throws MissingADESchemaException {
		RoofSurface dest = new RoofSurfaceImpl(module);
		unmarshalRoofSurface(src, dest);

		return dest;
	}

	public void unmarshalRoom(RoomType src, Room dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz());

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());
		
		if (src.isSetBoundedBySurface()) {
			for (BoundarySurfacePropertyType boundarySurfaceProperty : src.getBoundedBySurface())
				dest.addBoundedBySurface(unmarshalBoundarySurfaceProperty(boundarySurfaceProperty));
		}
		
		if (src.isSetInteriorFurniture()) {
			for (InteriorFurniturePropertyType interiorFurnitureProperty : src.getInteriorFurniture())
				dest.addInteriorFurniture(unmarshalInteriorFurnitureProperty(interiorFurnitureProperty));
		}
		
		if (src.isSetRoomInstallation()) {
			for (IntBuildingInstallationPropertyType intBuildingInstallationProperty : src.getRoomInstallation())
				dest.addRoomInstallation(unmarshalIntBuildingInstallationProperty(intBuildingInstallationProperty));
		}	
	}

	public Room unmarshalRoom(RoomType src) throws MissingADESchemaException {
		Room dest = new RoomImpl(module);
		unmarshalRoom(src, dest);

		return dest;
	}

	public void unmarshalWallSurface(WallSurfaceType src, WallSurface dest) throws MissingADESchemaException {
		unmarshalBoundarySurface(src, dest);
	}

	public WallSurface unmarshalWallSurface(WallSurfaceType src) throws MissingADESchemaException {
		WallSurface dest = new WallSurfaceImpl(module);
		unmarshalWallSurface(src, dest);

		return dest;
	}

	public void unmarshalWindow(WindowType src, Window dest) throws MissingADESchemaException {
		unmarshalOpening(src, dest);
	}

	public Window unmarshalWindow(WindowType src) throws MissingADESchemaException {
		Window dest = new WindowImpl(module);
		unmarshalWindow(src, dest);

		return dest;
	}
	
	public boolean assignGenericProperty(ADEComponent genericProperty, QName substitutionGroup, CityGML dest) {
		String name = substitutionGroup.getLocalPart();
		boolean success = true;
		
		if (dest instanceof AbstractBuilding && name.equals("_GenericApplicationPropertyOfAbstractBuilding"))
			((AbstractBuilding)dest).addGenericApplicationPropertyOfAbstractBuilding(genericProperty);
		else if (dest instanceof Building && name.equals("_GenericApplicationPropertyOfBuilding"))
			((Building)dest).addGenericApplicationPropertyOfBuilding(genericProperty);
		else if (dest instanceof BuildingPart && name.equals("_GenericApplicationPropertyOfBuildingPart"))
			((BuildingPart)dest).addGenericApplicationPropertyOfBuildingPart(genericProperty);
		else if (dest instanceof AbstractBoundarySurface && name.equals("_GenericApplicationPropertyOfBoundarySurface"))
			((AbstractBoundarySurface)dest).addGenericApplicationPropertyOfBoundarySurface(genericProperty);
		else if (dest instanceof CeilingSurface && name.equals("_GenericApplicationPropertyOfCeilingSurface"))
			((CeilingSurface)dest).addGenericApplicationPropertyOfCeilingSurface(genericProperty);
		else if (dest instanceof ClosureSurface && name.equals("_GenericApplicationPropertyOfClosureSurface"))
			((ClosureSurface)dest).addGenericApplicationPropertyOfClosureSurface(genericProperty);
		else if (dest instanceof FloorSurface && name.equals("_GenericApplicationPropertyOfFloorSurface"))
			((FloorSurface)dest).addGenericApplicationPropertyOfFloorSurface(genericProperty);
		else if (dest instanceof GroundSurface && name.equals("_GenericApplicationPropertyOfGroundSurface"))
			((GroundSurface)dest).addGenericApplicationPropertyOfGroundSurface(genericProperty);
		else if (dest instanceof InteriorWallSurface && name.equals("_GenericApplicationPropertyOfInteriorWallSurface"))
			((InteriorWallSurface)dest).addGenericApplicationPropertyOfInteriorWallSurface(genericProperty);
		else if (dest instanceof RoofSurface && name.equals("_GenericApplicationPropertyOfRoofSurface"))
			((RoofSurface)dest).addGenericApplicationPropertyOfRoofSurface(genericProperty);
		else if (dest instanceof WallSurface && name.equals("_GenericApplicationPropertyOfWallSurface"))
			((WallSurface)dest).addGenericApplicationPropertyOfWallSurface(genericProperty);
		else if (dest instanceof AbstractOpening && name.equals("_GenericApplicationPropertyOfOpening"))
			((AbstractOpening)dest).addGenericApplicationPropertyOfOpening(genericProperty);
		else if (dest instanceof Window && name.equals("_GenericApplicationPropertyOfWindow"))
			((Window)dest).addGenericApplicationPropertyOfWindow(genericProperty);
		else if (dest instanceof Door && name.equals("_GenericApplicationPropertyOfDoor"))
			((Door)dest).addGenericApplicationPropertyOfDoor(genericProperty);
		else if (dest instanceof BuildingFurniture && name.equals("_GenericApplicationPropertyOfBuildingFurniture"))
			((BuildingFurniture)dest).addGenericApplicationPropertyOfBuildingFurniture(genericProperty);
		else if (dest instanceof BuildingInstallation && name.equals("_GenericApplicationPropertyOfBuildingInstallation"))
			((BuildingInstallation)dest).addGenericApplicationPropertyOfBuildingInstallation(genericProperty);
		else if (dest instanceof IntBuildingInstallation && name.equals("_GenericApplicationPropertyOfIntBuildingInstallation"))
			((IntBuildingInstallation)dest).addGenericApplicationPropertyOfIntBuildingInstallation(genericProperty);
		else if (dest instanceof Room && name.equals("_GenericApplicationPropertyOfRoom"))
			((Room)dest).addGenericApplicationPropertyOfRoom(genericProperty);		
		else 
			success = false;
		
		return success;
	}
	
}
