/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.builder.jaxb.unmarshal.citygml.building;

import net.opengis.citygml._1.AddressPropertyType;
import net.opengis.citygml.building._1.AbstractBoundarySurfaceType;
import net.opengis.citygml.building._1.AbstractBuildingType;
import net.opengis.citygml.building._1.AbstractOpeningType;
import net.opengis.citygml.building._1.BoundarySurfacePropertyType;
import net.opengis.citygml.building._1.BuildingFurnitureType;
import net.opengis.citygml.building._1.BuildingInstallationPropertyType;
import net.opengis.citygml.building._1.BuildingInstallationType;
import net.opengis.citygml.building._1.BuildingPartPropertyType;
import net.opengis.citygml.building._1.BuildingPartType;
import net.opengis.citygml.building._1.BuildingType;
import net.opengis.citygml.building._1.CeilingSurfaceType;
import net.opengis.citygml.building._1.ClosureSurfaceType;
import net.opengis.citygml.building._1.DoorType;
import net.opengis.citygml.building._1.FloorSurfaceType;
import net.opengis.citygml.building._1.GroundSurfaceType;
import net.opengis.citygml.building._1.IntBuildingInstallationPropertyType;
import net.opengis.citygml.building._1.IntBuildingInstallationType;
import net.opengis.citygml.building._1.InteriorFurniturePropertyType;
import net.opengis.citygml.building._1.InteriorRoomPropertyType;
import net.opengis.citygml.building._1.InteriorWallSurfaceType;
import net.opengis.citygml.building._1.OpeningPropertyType;
import net.opengis.citygml.building._1.RoofSurfaceType;
import net.opengis.citygml.building._1.RoomType;
import net.opengis.citygml.building._1.WallSurfaceType;
import net.opengis.citygml.building._1.WindowType;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.citygml.building.AbstractBoundarySurface;
import org.citygml4j.model.citygml.building.AbstractBuilding;
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
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.building.WallSurface;
import org.citygml4j.model.citygml.building.Window;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.citygml4j.util.mapper.CheckedTypeMapper;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.concurrent.locks.ReentrantLock;

public class Building100Unmarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final BuildingModule module = BuildingModule.v1_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;
	private CheckedTypeMapper<CityGML> typeMapper;

	public Building100Unmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBUnmarshaller();
	}

	private CheckedTypeMapper<CityGML> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = CheckedTypeMapper.<CityGML>create()
							.with(BoundarySurfacePropertyType.class, this::unmarshalBoundarySurfaceProperty)
							.with(BuildingType.class, this::unmarshalBuilding)
							.with(BuildingFurnitureType.class, this::unmarshalBuildingFurniture)
							.with(BuildingInstallationType.class, this::unmarshalBuildingInstallation)
							.with(BuildingInstallationPropertyType.class, this::unmarshalBuildingInstallationProperty)
							.with(BuildingPartType.class, this::unmarshalBuildingPart)
							.with(BuildingPartPropertyType.class, this::unmarshalBuildingPartProperty)
							.with(CeilingSurfaceType.class, this::unmarshalCeilingSurface)
							.with(ClosureSurfaceType.class, this::unmarshalClosureSurface)
							.with(DoorType.class, this::unmarshalDoor)
							.with(FloorSurfaceType.class, this::unmarshalFloorSurface)
							.with(GroundSurfaceType.class, this::unmarshalGroundSurface)
							.with(IntBuildingInstallationType.class, this::unmarshalIntBuildingInstallation)
							.with(IntBuildingInstallationPropertyType.class, this::unmarshalIntBuildingInstallationProperty)
							.with(InteriorFurniturePropertyType.class, this::unmarshalInteriorFurnitureProperty)
							.with(InteriorRoomPropertyType.class, this::unmarshalInteriorRoomProperty)
							.with(InteriorWallSurfaceType.class, this::unmarshalInteriorWallSurface)
							.with(OpeningPropertyType.class, this::unmarshalOpeningProperty)
							.with(RoofSurfaceType.class, this::unmarshalRoofSurface)
							.with(RoomType.class, this::unmarshalRoom)
							.with(WallSurfaceType.class, this::unmarshalWallSurface)
							.with(WindowType.class, this::unmarshalWindow)
							.with(JAXBElement.class, this::unmarshal);
				}
			} finally {
				lock.unlock();
			}
		}

		return typeMapper;
	}

	public CityGML unmarshal(JAXBElement<?> src) throws MissingADESchemaException {
		return unmarshal(src.getValue());
	}

	public CityGML unmarshal(Object src) throws MissingADESchemaException {
		return getTypeMapper().apply(src);
	}

	public void unmarshalAbstractBuilding(AbstractBuildingType src, AbstractBuilding dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalAbstractSite(src, dest);

		if (src.isSetClazz())
			dest.setClazz(new Code(src.getClazz()));

		if (src.isSetFunction()) {
			for (String function : src.getFunction())
				dest.addFunction(new Code(function));
		}

		if (src.isSetUsage()) {
			for (String usage : src.getUsage())
				dest.addUsage(new Code(usage));
		}

		if (src.isSetYearOfConstruction())
			dest.setYearOfConstruction(src.getYearOfConstruction().toGregorianCalendar().toZonedDateTime().toLocalDate());

		if (src.isSetYearOfDemolition())
			dest.setYearOfDemolition(src.getYearOfDemolition().toGregorianCalendar().toZonedDateTime().toLocalDate());

		if (src.isSetRoofType())
			dest.setRoofType(new Code(src.getRoofType()));

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

		if (src.isSet_GenericApplicationPropertyOfAbstractBuilding()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfAbstractBuilding()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfAbstractBuilding(ade);
			}
		}
	}

	public void unmarshalAbstractBoundarySurface(AbstractBoundarySurfaceType src, AbstractBoundarySurface dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalAbstractCityObject(src, dest);

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

		if (src.isSet_GenericApplicationPropertyOfBoundarySurface()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfBoundarySurface()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfBoundarySurface(ade);
			}
		}
	}

	public void unmarshalAbstractOpening(AbstractOpeningType src, AbstractOpening dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod3MultiSurface()));

		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod4MultiSurface()));

		if (src.isSet_GenericApplicationPropertyOfOpening()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfOpening()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfOpening(ade);
			}
		}
	}

	public BoundarySurfaceProperty unmarshalBoundarySurfaceProperty(BoundarySurfacePropertyType src) throws MissingADESchemaException {
		BoundarySurfaceProperty dest = new BoundarySurfaceProperty(module);
		jaxb.getGMLUnmarshaller().unmarshalFeatureProperty(src, dest);

		if (src.isSet_Object()) {
			ModelObject object = jaxb.unmarshal(src.get_Object());
			if (object instanceof AbstractBoundarySurface)
				dest.setObject((AbstractBoundarySurface)object);
		}

		return dest;
	}

	public void unmarshalBuilding(BuildingType src, Building dest) throws MissingADESchemaException {
		unmarshalAbstractBuilding(src, dest);

		if (src.isSet_GenericApplicationPropertyOfBuilding()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfBuilding()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfBuilding(ade);
			}
		}
	}

	public Building unmarshalBuilding(BuildingType src) throws MissingADESchemaException {
		Building dest = new Building(module);
		unmarshalBuilding(src, dest);

		return dest;
	}

	public void unmarshalBuildingFurniture(BuildingFurnitureType src, BuildingFurniture dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(new Code(src.getClazz()));

		if (src.isSetFunction()) {
			for (String function : src.getFunction())
				dest.addFunction(new Code(function));
		}

		if (src.isSetUsage()) {
			for (String usage : src.getUsage())
				dest.addUsage(new Code(usage));
		}

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod4Geometry()));

		if (src.isSetLod4ImplicitRepresentation())
			dest.setLod4ImplicitRepresentation(citygml.getCore100Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod4ImplicitRepresentation()));

		if (src.isSet_GenericApplicationPropertyOfBuildingFurniture()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfBuildingFurniture()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfBuildingFurniture(ade);
			}
		}
	}

	public BuildingFurniture unmarshalBuildingFurniture(BuildingFurnitureType src) throws MissingADESchemaException {
		BuildingFurniture dest = new BuildingFurniture(module);
		unmarshalBuildingFurniture(src, dest);

		return dest;
	}

	public void unmarshalBuildingInstallation(BuildingInstallationType src, BuildingInstallation dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(new Code(src.getClazz()));

		if (src.isSetFunction()) {
			for (String function : src.getFunction())
				dest.addFunction(new Code(function));
		}

		if (src.isSetUsage()) {
			for (String usage : src.getUsage())
				dest.addUsage(new Code(usage));
		}

		if (src.isSetLod2Geometry())
			dest.setLod2Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod2Geometry()));

		if (src.isSetLod3Geometry())
			dest.setLod3Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod3Geometry()));

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod4Geometry()));

		if (src.isSet_GenericApplicationPropertyOfBuildingInstallation()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfBuildingInstallation()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfBuildingInstallation(ade);
			}
		}
	}

	public BuildingInstallation unmarshalBuildingInstallation(BuildingInstallationType src) throws MissingADESchemaException {
		BuildingInstallation dest = new BuildingInstallation(module);
		unmarshalBuildingInstallation(src, dest);

		return dest;
	}

	public BuildingInstallationProperty unmarshalBuildingInstallationProperty(BuildingInstallationPropertyType src) throws MissingADESchemaException {
		BuildingInstallationProperty dest = new BuildingInstallationProperty(module);
		jaxb.getGMLUnmarshaller().unmarshalFeatureProperty(src, dest);

		if (src.isSet_Object()) {
			ModelObject object = jaxb.unmarshal(src.get_Object());
			if (object instanceof BuildingInstallation)
				dest.setObject((BuildingInstallation)object);
		}

		return dest;
	}

	public void unmarshalBuildingPart(BuildingPartType src, BuildingPart dest) throws MissingADESchemaException {
		unmarshalAbstractBuilding(src, dest);

		if (src.isSet_GenericApplicationPropertyOfBuildingPart()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfBuildingPart()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfBuildingPart(ade);
			}
		}
	}

	public BuildingPart unmarshalBuildingPart(BuildingPartType src) throws MissingADESchemaException {
		BuildingPart dest = new BuildingPart(module);
		unmarshalBuildingPart(src, dest);

		return dest;
	}

	public BuildingPartProperty unmarshalBuildingPartProperty(BuildingPartPropertyType src) throws MissingADESchemaException {
		BuildingPartProperty dest = new BuildingPartProperty(module);
		jaxb.getGMLUnmarshaller().unmarshalFeatureProperty(src, dest);

		if (src.isSet_Object()) {
			ModelObject object = jaxb.unmarshal(src.get_Object());
			if (object instanceof BuildingPart)
				dest.setObject((BuildingPart)object);
		}

		return dest;
	}

	public void unmarshalCeilingSurface(CeilingSurfaceType src, CeilingSurface dest) throws MissingADESchemaException {
		unmarshalAbstractBoundarySurface(src, dest);

		if (src.isSet_GenericApplicationPropertyOfCeilingSurface()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfCeilingSurface()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfCeilingSurface(ade);
			}
		}
	}

	public CeilingSurface unmarshalCeilingSurface(CeilingSurfaceType src) throws MissingADESchemaException {
		CeilingSurface dest = new CeilingSurface(module);
		unmarshalCeilingSurface(src, dest);

		return dest;
	}

	public void unmarshalClosureSurface(ClosureSurfaceType src, ClosureSurface dest) throws MissingADESchemaException {
		unmarshalAbstractBoundarySurface(src, dest);

		if (src.isSet_GenericApplicationPropertyOfClosureSurface()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfClosureSurface()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfClosureSurface(ade);
			}
		}
	}

	public ClosureSurface unmarshalClosureSurface(ClosureSurfaceType src) throws MissingADESchemaException {
		ClosureSurface dest = new ClosureSurface(module);
		unmarshalClosureSurface(src, dest);

		return dest;
	}

	public void unmarshalDoor(DoorType src, Door dest) throws MissingADESchemaException {
		unmarshalAbstractOpening(src, dest);

		if (src.isSetAddress()) {
			for (AddressPropertyType addressProperty : src.getAddress())
				dest.addAddress(citygml.getCore100Unmarshaller().unmarshalAddressProperty(addressProperty));
		}

		if (src.isSet_GenericApplicationPropertyOfDoor()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfDoor()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfDoor(ade);
			}
		}
	}

	public Door unmarshalDoor(DoorType src) throws MissingADESchemaException {
		Door dest = new Door(module);
		unmarshalDoor(src, dest);

		return dest;
	}

	public void unmarshalFloorSurface(FloorSurfaceType src, FloorSurface dest) throws MissingADESchemaException {
		unmarshalAbstractBoundarySurface(src, dest);

		if (src.isSet_GenericApplicationPropertyOfFloorSurface()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfFloorSurface()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfFloorSurface(ade);
			}
		}
	}

	public FloorSurface unmarshalFloorSurface(FloorSurfaceType src) throws MissingADESchemaException {
		FloorSurface dest = new FloorSurface(module);
		unmarshalFloorSurface(src, dest);

		return dest;
	}

	public void unmarshalGroundSurface(GroundSurfaceType src, GroundSurface dest) throws MissingADESchemaException {
		unmarshalAbstractBoundarySurface(src, dest);

		if (src.isSet_GenericApplicationPropertyOfGroundSurface()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfGroundSurface()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfGroundSurface(ade);
			}
		}
	}

	public GroundSurface unmarshalGroundSurface(GroundSurfaceType src) throws MissingADESchemaException {
		GroundSurface dest = new GroundSurface(module);
		unmarshalGroundSurface(src, dest);

		return dest;
	}

	public void unmarshalIntBuildingInstallation(IntBuildingInstallationType src, IntBuildingInstallation dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(new Code(src.getClazz()));

		if (src.isSetFunction()) {
			for (String function : src.getFunction())
				dest.addFunction(new Code(function));
		}

		if (src.isSetUsage()) {
			for (String usage : src.getUsage())
				dest.addUsage(new Code(usage));
		}

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod4Geometry()));

		if (src.isSet_GenericApplicationPropertyOfIntBuildingInstallation()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfIntBuildingInstallation()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfIntBuildingInstallation(ade);
			}
		}
	}

	public IntBuildingInstallation unmarshalIntBuildingInstallation(IntBuildingInstallationType src) throws MissingADESchemaException {
		IntBuildingInstallation dest = new IntBuildingInstallation(module);
		unmarshalIntBuildingInstallation(src, dest);

		return dest;
	}

	public IntBuildingInstallationProperty unmarshalIntBuildingInstallationProperty(IntBuildingInstallationPropertyType src) throws MissingADESchemaException {
		IntBuildingInstallationProperty dest = new IntBuildingInstallationProperty(module);
		jaxb.getGMLUnmarshaller().unmarshalFeatureProperty(src, dest);

		if (src.isSet_Object()) {
			ModelObject object = jaxb.unmarshal(src.get_Object());
			if (object instanceof IntBuildingInstallation)
				dest.setObject((IntBuildingInstallation)object);
		}

		return dest;
	}

	public InteriorFurnitureProperty unmarshalInteriorFurnitureProperty(InteriorFurniturePropertyType src) throws MissingADESchemaException {
		InteriorFurnitureProperty dest = new InteriorFurnitureProperty(module);
		jaxb.getGMLUnmarshaller().unmarshalFeatureProperty(src, dest);

		if (src.isSet_Object()) {
			ModelObject object = jaxb.unmarshal(src.get_Object());
			if (object instanceof BuildingFurniture)
				dest.setObject((BuildingFurniture)object);
		}

		return dest;
	}

	public InteriorRoomProperty unmarshalInteriorRoomProperty(InteriorRoomPropertyType src) throws MissingADESchemaException {
		InteriorRoomProperty dest = new InteriorRoomProperty(module);
		jaxb.getGMLUnmarshaller().unmarshalFeatureProperty(src, dest);

		if (src.isSet_Object()) {
			ModelObject object = jaxb.unmarshal(src.get_Object());
			if (object instanceof Room)
				dest.setObject((Room)object);
		}

		return dest;
	}

	public void unmarshalInteriorWallSurface(InteriorWallSurfaceType src, InteriorWallSurface dest) throws MissingADESchemaException {
		unmarshalAbstractBoundarySurface(src, dest);

		if (src.isSet_GenericApplicationPropertyOfInteriorWallSurface()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfInteriorWallSurface()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfInteriorWallSurface(ade);
			}
		}
	}

	public InteriorWallSurface unmarshalInteriorWallSurface(InteriorWallSurfaceType src) throws MissingADESchemaException {
		InteriorWallSurface dest = new InteriorWallSurface(module);
		unmarshalInteriorWallSurface(src, dest);

		return dest;
	}

	public OpeningProperty unmarshalOpeningProperty(OpeningPropertyType src) throws MissingADESchemaException {
		OpeningProperty dest = new OpeningProperty(module);
		jaxb.getGMLUnmarshaller().unmarshalFeatureProperty(src, dest);

		if (src.isSet_Object()) {
			ModelObject object = jaxb.unmarshal(src.get_Object());
			if (object instanceof AbstractOpening)
				dest.setObject((AbstractOpening)object);
		}

		return dest;
	}

	public void unmarshalRoofSurface(RoofSurfaceType src, RoofSurface dest) throws MissingADESchemaException {
		unmarshalAbstractBoundarySurface(src, dest);

		if (src.isSet_GenericApplicationPropertyOfRoofSurface()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfRoofSurface()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfRoofSurface(ade);
			}
		}
	}

	public RoofSurface unmarshalRoofSurface(RoofSurfaceType src) throws MissingADESchemaException {
		RoofSurface dest = new RoofSurface(module);
		unmarshalRoofSurface(src, dest);

		return dest;
	}

	public void unmarshalRoom(RoomType src, Room dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(new Code(src.getClazz()));

		if (src.isSetFunction()) {
			for (String function : src.getFunction())
				dest.addFunction(new Code(function));
		}

		if (src.isSetUsage()) {
			for (String usage : src.getUsage())
				dest.addUsage(new Code(usage));
		}

		if (src.isSetLod4Solid())
			dest.setLod4Solid(jaxb.getGMLUnmarshaller().unmarshalSolidProperty(src.getLod4Solid()));

		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod4MultiSurface()));

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

		if (src.isSet_GenericApplicationPropertyOfRoom()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfRoom()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfRoom(ade);
			}
		}
	}

	public Room unmarshalRoom(RoomType src) throws MissingADESchemaException {
		Room dest = new Room(module);
		unmarshalRoom(src, dest);

		return dest;
	}

	public void unmarshalWallSurface(WallSurfaceType src, WallSurface dest) throws MissingADESchemaException {
		unmarshalAbstractBoundarySurface(src, dest);

		if (src.isSet_GenericApplicationPropertyOfWallSurface()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfWallSurface()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfWallSurface(ade);
			}
		}
	}

	public WallSurface unmarshalWallSurface(WallSurfaceType src) throws MissingADESchemaException {
		WallSurface dest = new WallSurface(module);
		unmarshalWallSurface(src, dest);

		return dest;
	}

	public void unmarshalWindow(WindowType src, Window dest) throws MissingADESchemaException {
		unmarshalAbstractOpening(src, dest);

		if (src.isSet_GenericApplicationPropertyOfWindow()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfWindow()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfWindow(ade);
			}
		}
	}

	public Window unmarshalWindow(WindowType src) throws MissingADESchemaException {
		Window dest = new Window(module);
		unmarshalWindow(src, dest);

		return dest;
	}

	public boolean assignGenericProperty(ADEGenericElement genericProperty, QName substitutionGroup, CityGML dest) {
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
