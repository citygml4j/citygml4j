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
package org.citygml4j.builder.jaxb.marshal.citygml.building;

import net.opengis.citygml.building._2.AbstractBoundarySurfaceType;
import net.opengis.citygml.building._2.AbstractBuildingType;
import net.opengis.citygml.building._2.AbstractOpeningType;
import net.opengis.citygml.building._2.BoundarySurfacePropertyType;
import net.opengis.citygml.building._2.BuildingFurnitureType;
import net.opengis.citygml.building._2.BuildingInstallationPropertyType;
import net.opengis.citygml.building._2.BuildingInstallationType;
import net.opengis.citygml.building._2.BuildingPartPropertyType;
import net.opengis.citygml.building._2.BuildingPartType;
import net.opengis.citygml.building._2.BuildingType;
import net.opengis.citygml.building._2.CeilingSurfaceType;
import net.opengis.citygml.building._2.ClosureSurfaceType;
import net.opengis.citygml.building._2.DoorType;
import net.opengis.citygml.building._2.FloorSurfaceType;
import net.opengis.citygml.building._2.GroundSurfaceType;
import net.opengis.citygml.building._2.IntBuildingInstallationPropertyType;
import net.opengis.citygml.building._2.IntBuildingInstallationType;
import net.opengis.citygml.building._2.InteriorFurniturePropertyType;
import net.opengis.citygml.building._2.InteriorRoomPropertyType;
import net.opengis.citygml.building._2.InteriorWallSurfaceType;
import net.opengis.citygml.building._2.ObjectFactory;
import net.opengis.citygml.building._2.OpeningPropertyType;
import net.opengis.citygml.building._2.OuterCeilingSurfaceType;
import net.opengis.citygml.building._2.OuterFloorSurfaceType;
import net.opengis.citygml.building._2.RoofSurfaceType;
import net.opengis.citygml.building._2.RoomType;
import net.opengis.citygml.building._2.WallSurfaceType;
import net.opengis.citygml.building._2.WindowType;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.model.citygml.ade.ADEComponent;
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
import org.citygml4j.model.citygml.building.OuterCeilingSurface;
import org.citygml4j.model.citygml.building.OuterFloorSurface;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.building.WallSurface;
import org.citygml4j.model.citygml.building.Window;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.util.mapper.TypeMapper;
import org.w3._1999.xlink.ActuateType;
import org.w3._1999.xlink.ShowType;
import org.w3._1999.xlink.TypeType;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConstants;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.concurrent.locks.ReentrantLock;

public class Building200Marshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final ObjectFactory bldg = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;
	private TypeMapper<JAXBElement<?>> elementMapper;
	private TypeMapper<Object> typeMapper;

	public Building200Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	private TypeMapper<JAXBElement<?>> getElementMapper() {
		if (elementMapper == null) {
			lock.lock();
			try {
				if (elementMapper == null) {
					elementMapper = TypeMapper.<JAXBElement<?>>create()
							.with(Building.class, this::createBuilding)
							.with(BuildingFurniture.class, this::createBuildingFurniture)
							.with(BuildingInstallation.class, this::createBuildingInstallation)
							.with(BuildingPart.class, this::createBuildingPart)
							.with(CeilingSurface.class, this::createCeilingSurface)
							.with(ClosureSurface.class, this::createClosureSurface)
							.with(Door.class, this::createDoor)
							.with(FloorSurface.class, this::createFloorSurface)
							.with(GroundSurface.class, this::createGroundSurface)
							.with(IntBuildingInstallation.class, this::createIntBuildingInstallation)
							.with(InteriorWallSurface.class, this::createInteriorWallSurface)
							.with(OuterCeilingSurface.class, this::createOuterCeilingSurface)
							.with(OuterFloorSurface.class, this::createOuterFloorSurface)
							.with(RoofSurface.class, this::createRoofSurface)
							.with(Room.class, this::createRoom)
							.with(WallSurface.class, this::createWallSurface)
							.with(Window.class, this::createWindow);
				}
			} finally {
				lock.unlock();
			}
		}

		return elementMapper;
	}

	private TypeMapper<Object> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = TypeMapper.create()
							.with(BoundarySurfaceProperty.class, this::marshalBoundarySurfaceProperty)
							.with(Building.class, this::marshalBuilding)
							.with(BuildingFurniture.class, this::marshalBuildingFurniture)
							.with(BuildingInstallation.class, this::marshalBuildingInstallation)
							.with(BuildingInstallationProperty.class, this::marshalBuildingInstallationProperty)
							.with(BuildingPart.class, this::marshalBuildingPart)
							.with(BuildingPartProperty.class, this::marshalBuildingPartProperty)
							.with(CeilingSurface.class, this::marshalCeilingSurface)
							.with(ClosureSurface.class, this::marshalClosureSurface)
							.with(Door.class, this::marshalDoor)
							.with(FloorSurface.class, this::marshalFloorSurface)
							.with(GroundSurface.class, this::marshalGroundSurface)
							.with(IntBuildingInstallation.class, this::marshalIntBuildingInstallation)
							.with(IntBuildingInstallationProperty.class, this::marshalIntBuildingInstallationProperty)
							.with(InteriorFurnitureProperty.class, this::marshalInteriorFurnitureProperty)
							.with(InteriorRoomProperty.class, this::marshalInteriorRoomProperty)
							.with(InteriorWallSurface.class, this::marshalInteriorWallSurface)
							.with(OpeningProperty.class, this::marshalOpeningProperty)
							.with(OuterCeilingSurface.class, this::marshalOuterCeilingSurface)
							.with(OuterFloorSurface.class, this::marshalOuterFloorSurface)
							.with(RoofSurface.class, this::marshalRoofSurface)
							.with(Room.class, this::marshalRoom)
							.with(WallSurface.class, this::marshalWallSurface)
							.with(Window.class, this::marshalWindow);
				}
			} finally {
				lock.unlock();
			}
		}

		return typeMapper;
	}

	public JAXBElement<?> marshalJAXBElement(ModelObject src) {
		return getElementMapper().apply(src);
	}

	public Object marshal(ModelObject src) {
		return getTypeMapper().apply(src);
	}

	public void marshalAbstractBuilding(AbstractBuilding src, AbstractBuildingType dest) {
		citygml.getCore200Marshaller().marshalAbstractSite(src, dest);

		if (src.isSetClazz())
			dest.setClazz(jaxb.getGMLMarshaller().marshalCode(src.getClazz()));

		if (src.isSetFunction()) {
			for (Code function : src.getFunction())
				dest.getFunction().add(jaxb.getGMLMarshaller().marshalCode(function));
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage())
				dest.getUsage().add(jaxb.getGMLMarshaller().marshalCode(usage));
		}

		if (src.isSetYearOfConstruction()) {
			LocalDate date = src.getYearOfConstruction();
			dest.setYearOfConstruction(jaxb.getDataTypeFactory().newXMLGregorianCalendarDate(
					date.getYear(),
					date.getMonthValue(),
					date.getDayOfMonth(),
					DatatypeConstants.FIELD_UNDEFINED));
		}

		if (src.isSetYearOfDemolition()) {
			LocalDate date = src.getYearOfDemolition();
			dest.setYearOfDemolition(jaxb.getDataTypeFactory().newXMLGregorianCalendarDate(
					date.getYear(),
					date.getMonthValue(),
					date.getDayOfMonth(),
					DatatypeConstants.FIELD_UNDEFINED));
		}

		if (src.isSetRoofType())
			dest.setRoofType(jaxb.getGMLMarshaller().marshalCode(src.getRoofType()));

		if (src.isSetMeasuredHeight())
			dest.setMeasuredHeight(jaxb.getGMLMarshaller().marshalLength(src.getMeasuredHeight()));

		if (src.isSetStoreysAboveGround())
			dest.setStoreysAboveGround(BigInteger.valueOf(src.getStoreysAboveGround()));

		if (src.isSetStoreysBelowGround())
			dest.setStoreysBelowGround(BigInteger.valueOf(src.getStoreysBelowGround()));

		if (src.isSetStoreyHeightsAboveGround())
			dest.setStoreyHeightsAboveGround(jaxb.getGMLMarshaller().marshalMeasureOrNullList(src.getStoreyHeightsAboveGround()));

		if (src.isSetStoreyHeightsBelowGround())
			dest.setStoreyHeightsBelowGround(jaxb.getGMLMarshaller().marshalMeasureOrNullList(src.getStoreyHeightsBelowGround()));

		if (src.isSetLod1Solid())
			dest.setLod1Solid(jaxb.getGMLMarshaller().marshalSolidProperty(src.getLod1Solid()));

		if (src.isSetLod2Solid())
			dest.setLod2Solid(jaxb.getGMLMarshaller().marshalSolidProperty(src.getLod2Solid()));

		if (src.isSetLod3Solid())
			dest.setLod3Solid(jaxb.getGMLMarshaller().marshalSolidProperty(src.getLod3Solid()));

		if (src.isSetLod4Solid())
			dest.setLod4Solid(jaxb.getGMLMarshaller().marshalSolidProperty(src.getLod4Solid()));

		if (src.isSetLod1MultiSurface())
			dest.setLod1MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod1MultiSurface()));

		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod2MultiSurface()));

		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod3MultiSurface()));

		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod4MultiSurface()));

		if (src.isSetLod1TerrainIntersection())
			dest.setLod1TerrainIntersection(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod1TerrainIntersection()));

		if (src.isSetLod2TerrainIntersection())
			dest.setLod2TerrainIntersection(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod2TerrainIntersection()));

		if (src.isSetLod3TerrainIntersection())
			dest.setLod3TerrainIntersection(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod3TerrainIntersection()));

		if (src.isSetLod4TerrainIntersection())
			dest.setLod4TerrainIntersection(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod4TerrainIntersection()));

		if (src.isSetLod0FootPrint())
			dest.setLod0FootPrint(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod0FootPrint()));

		if (src.isSetLod0RoofEdge())
			dest.setLod0RoofEdge(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod0RoofEdge()));

		if (src.isSetLod2MultiCurve())
			dest.setLod2MultiCurve(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod2MultiCurve()));

		if (src.isSetLod3MultiCurve())
			dest.setLod3MultiCurve(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod3MultiCurve()));

		if (src.isSetLod4MultiCurve())
			dest.setLod4MultiCurve(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod4MultiCurve()));	

		if (src.isSetOuterBuildingInstallation()) {
			for (BuildingInstallationProperty buildingInstallationProperty : src.getOuterBuildingInstallation())
				dest.getOuterBuildingInstallation().add(marshalBuildingInstallationProperty(buildingInstallationProperty));
		}

		if (src.isSetInteriorBuildingInstallation()) {
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : src.getInteriorBuildingInstallation())
				dest.getInteriorBuildingInstallation().add(marshalIntBuildingInstallationProperty(intBuildingInstallationProperty));
		}

		if (src.isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : src.getBoundedBySurface())
				dest.getBoundedBySurface().add(marshalBoundarySurfaceProperty(boundarySurfaceProperty));
		}

		if (src.isSetConsistsOfBuildingPart()) {
			for (BuildingPartProperty buildingPartProperty : src.getConsistsOfBuildingPart())
				dest.getConsistsOfBuildingPart().add(marshalBuildingPartProperty(buildingPartProperty));
		}

		if (src.isSetInteriorRoom()) {
			for (InteriorRoomProperty interiorRoomProperty : src.getInteriorRoom())
				dest.getInteriorRoom().add(marshalInteriorRoomProperty(interiorRoomProperty));
		}

		if (src.isSetAddress()) {
			for (AddressProperty addressProperty : src.getAddress())
				dest.getAddress().add(citygml.getCore200Marshaller().marshalAddressProperty(addressProperty));
		}	

		if (src.isSetGenericApplicationPropertyOfAbstractBuilding()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfAbstractBuilding()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfAbstractBuilding().add(jaxbElement);
			}
		}
	}

	public void marshalAbstractBoundarySurface(AbstractBoundarySurface src, AbstractBoundarySurfaceType dest) {
		citygml.getCore200Marshaller().marshalAbstractCityObject(src, dest);

		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod2MultiSurface()));

		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod3MultiSurface()));

		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod4MultiSurface()));

		if (src.isSetOpening()) {
			for (OpeningProperty openingProperty : src.getOpening())
				dest.getOpening().add(marshalOpeningProperty(openingProperty));
		}

		if (src.isSetGenericApplicationPropertyOfBoundarySurface()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfBoundarySurface()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfBoundarySurface().add(jaxbElement);
			}
		}
	}

	public void marshalAbstractOpening(AbstractOpening src, AbstractOpeningType dest) {
		citygml.getCore200Marshaller().marshalAbstractCityObject(src, dest);

		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod3MultiSurface()));

		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod4MultiSurface()));

		if (src.isSetLod3ImplicitRepresentation())
			dest.setLod3ImplicitRepresentation(citygml.getCore200Marshaller().marshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation()));

		if (src.isSetLod4ImplicitRepresentation())
			dest.setLod4ImplicitRepresentation(citygml.getCore200Marshaller().marshalImplicitRepresentationProperty(src.getLod4ImplicitRepresentation()));

		if (src.isSetGenericApplicationPropertyOfOpening()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfOpening()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfOpening().add(jaxbElement);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public BoundarySurfacePropertyType marshalBoundarySurfaceProperty(BoundarySurfaceProperty src) {
		BoundarySurfacePropertyType dest = bldg.createBoundarySurfacePropertyType();

		if (src.isSetBoundarySurface()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getBoundarySurface());
			if (elem != null && elem.getValue() instanceof AbstractBoundarySurfaceType)
				dest.set_BoundarySurface((JAXBElement<? extends AbstractBoundarySurfaceType>)elem);
		}

		if (src.isSetGenericADEElement()) {
			Element element = jaxb.getADEMarshaller().marshalDOMElement(src.getGenericADEElement());
			if (element != null)
				dest.set_ADEComponent(element);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public void marshalBuilding(Building src, BuildingType dest) {
		marshalAbstractBuilding(src, dest);

		if (src.isSetGenericApplicationPropertyOfBuilding()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfBuilding()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfBuilding().add(jaxbElement);
			}
		}
	}

	public BuildingType marshalBuilding(Building src) {
		BuildingType dest = bldg.createBuildingType();
		marshalBuilding(src, dest);

		return dest;
	}

	public void marshalBuildingFurniture(BuildingFurniture src, BuildingFurnitureType dest) {
		citygml.getCore200Marshaller().marshalAbstractCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(jaxb.getGMLMarshaller().marshalCode(src.getClazz()));

		if (src.isSetFunction()) {
			for (Code function : src.getFunction())
				dest.getFunction().add(jaxb.getGMLMarshaller().marshalCode(function));
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage())
				dest.getUsage().add(jaxb.getGMLMarshaller().marshalCode(usage));
		}

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod4Geometry()));

		if (src.isSetLod4ImplicitRepresentation())
			dest.setLod4ImplicitRepresentation(citygml.getCore200Marshaller().marshalImplicitRepresentationProperty(src.getLod4ImplicitRepresentation()));

		if (src.isSetGenericApplicationPropertyOfBuildingFurniture()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfBuildingFurniture()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfBuildingFurniture().add(jaxbElement);
			}
		}
	}

	public BuildingFurnitureType marshalBuildingFurniture(BuildingFurniture src) {
		BuildingFurnitureType dest = bldg.createBuildingFurnitureType();
		marshalBuildingFurniture(src, dest);

		return dest;
	}

	public void marshalBuildingInstallation(BuildingInstallation src, BuildingInstallationType dest) {
		citygml.getCore200Marshaller().marshalAbstractCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(jaxb.getGMLMarshaller().marshalCode(src.getClazz()));

		if (src.isSetFunction()) {
			for (Code function : src.getFunction())
				dest.getFunction().add(jaxb.getGMLMarshaller().marshalCode(function));
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage())
				dest.getUsage().add(jaxb.getGMLMarshaller().marshalCode(usage));
		}

		if (src.isSetLod2Geometry())
			dest.setLod2Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod2Geometry()));

		if (src.isSetLod3Geometry())
			dest.setLod3Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod3Geometry()));

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod4Geometry()));

		if (src.isSetLod2ImplicitRepresentation())
			dest.setLod2ImplicitRepresentation(citygml.getCore200Marshaller().marshalImplicitRepresentationProperty(src.getLod2ImplicitRepresentation()));

		if (src.isSetLod3ImplicitRepresentation())
			dest.setLod3ImplicitRepresentation(citygml.getCore200Marshaller().marshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation()));

		if (src.isSetLod4ImplicitRepresentation())
			dest.setLod4ImplicitRepresentation(citygml.getCore200Marshaller().marshalImplicitRepresentationProperty(src.getLod4ImplicitRepresentation()));

		if (src.isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : src.getBoundedBySurface())
				dest.getBoundedBySurface().add(marshalBoundarySurfaceProperty(boundarySurfaceProperty));
		}

		if (src.isSetGenericApplicationPropertyOfBuildingInstallation()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfBuildingInstallation()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfBuildingInstallation().add(jaxbElement);
			}
		}

	}

	public BuildingInstallationType marshalBuildingInstallation(BuildingInstallation src) {
		BuildingInstallationType dest = bldg.createBuildingInstallationType();
		marshalBuildingInstallation(src, dest);

		return dest;
	}

	@SuppressWarnings("unchecked")
	public BuildingInstallationPropertyType marshalBuildingInstallationProperty(BuildingInstallationProperty src) {
		BuildingInstallationPropertyType dest = bldg.createBuildingInstallationPropertyType();

		if (src.isSetBuildingInstallation()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getBuildingInstallation());
			if (elem != null && elem.getValue() instanceof BuildingInstallationType)
				dest.set_CityObject((JAXBElement<? extends BuildingInstallationType>)elem);
		}

		if (src.isSetGenericADEElement()) {
			Element element = jaxb.getADEMarshaller().marshalDOMElement(src.getGenericADEElement());
			if (element != null)
				dest.set_ADEComponent(element);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public void marshalBuildingPart(BuildingPart src, BuildingPartType dest) {
		marshalAbstractBuilding(src, dest);

		if (src.isSetGenericApplicationPropertyOfBuildingPart()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfBuildingPart()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfBuildingPart().add(jaxbElement);
			}
		}
	}

	public BuildingPartType marshalBuildingPart(BuildingPart src) {
		BuildingPartType dest = bldg.createBuildingPartType();
		marshalBuildingPart(src, dest);

		return dest;
	}

	@SuppressWarnings("unchecked")
	public BuildingPartPropertyType marshalBuildingPartProperty(BuildingPartProperty src) {
		BuildingPartPropertyType dest = bldg.createBuildingPartPropertyType();

		if (src.isSetBuildingPart()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getBuildingPart());
			if (elem != null && elem.getValue() instanceof BuildingPartType)
				dest.set_AbstractBuilding((JAXBElement<? extends BuildingPartType>)elem);
		}

		if (src.isSetGenericADEElement()) {
			Element element = jaxb.getADEMarshaller().marshalDOMElement(src.getGenericADEElement());
			if (element != null)
				dest.set_ADEComponent(element);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public void marshalCeilingSurface(CeilingSurface src, CeilingSurfaceType dest) {
		marshalAbstractBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfCeilingSurface()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfCeilingSurface()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfCeilingSurface().add(jaxbElement);
			}
		}
	}

	public CeilingSurfaceType marshalCeilingSurface(CeilingSurface src) {
		CeilingSurfaceType dest = bldg.createCeilingSurfaceType();
		marshalCeilingSurface(src, dest);

		return dest;
	}

	public void marshalClosureSurface(ClosureSurface src, ClosureSurfaceType dest) {
		marshalAbstractBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfClosureSurface()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfClosureSurface()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfClosureSurface().add(jaxbElement);
			}
		}
	}

	public ClosureSurfaceType marshalClosureSurface(ClosureSurface src) {
		ClosureSurfaceType dest = bldg.createClosureSurfaceType();
		marshalClosureSurface(src, dest);

		return dest;
	}

	public void marshalDoor(Door src, DoorType dest) {
		marshalAbstractOpening(src, dest);

		if (src.isSetAddress()) {
			for (AddressProperty addressProperty : src.getAddress())
				dest.getAddress().add(citygml.getCore200Marshaller().marshalAddressProperty(addressProperty));
		}

		if (src.isSetGenericApplicationPropertyOfDoor()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfDoor()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfDoor().add(jaxbElement);
			}
		}
	}

	public DoorType marshalDoor(Door src) {
		DoorType dest = bldg.createDoorType();
		marshalDoor(src, dest);

		return dest;
	}

	public void marshalFloorSurface(FloorSurface src, FloorSurfaceType dest) {
		marshalAbstractBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfFloorSurface()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfFloorSurface()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfFloorSurface().add(jaxbElement);
			}
		}
	}

	public FloorSurfaceType marshalFloorSurface(FloorSurface src) {
		FloorSurfaceType dest = bldg.createFloorSurfaceType();
		marshalFloorSurface(src, dest);

		return dest;
	}

	public void marshalGroundSurface(GroundSurface src, GroundSurfaceType dest) {
		marshalAbstractBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfGroundSurface()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfGroundSurface()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfGroundSurface().add(jaxbElement);
			}
		}
	}

	public GroundSurfaceType marshalGroundSurface(GroundSurface src) {
		GroundSurfaceType dest = bldg.createGroundSurfaceType();
		marshalGroundSurface(src, dest);

		return dest;
	}

	public void marshalIntBuildingInstallation(IntBuildingInstallation src, IntBuildingInstallationType dest) {
		citygml.getCore200Marshaller().marshalAbstractCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(jaxb.getGMLMarshaller().marshalCode(src.getClazz()));

		if (src.isSetFunction()) {
			for (Code function : src.getFunction())
				dest.getFunction().add(jaxb.getGMLMarshaller().marshalCode(function));
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage())
				dest.getUsage().add(jaxb.getGMLMarshaller().marshalCode(usage));
		}

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod4Geometry()));

		if (src.isSetLod4ImplicitRepresentation())
			dest.setLod4ImplicitRepresentation(citygml.getCore200Marshaller().marshalImplicitRepresentationProperty(src.getLod4ImplicitRepresentation()));

		if (src.isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : src.getBoundedBySurface())
				dest.getBoundedBySurface().add(marshalBoundarySurfaceProperty(boundarySurfaceProperty));
		}

		if (src.isSetGenericApplicationPropertyOfIntBuildingInstallation()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfIntBuildingInstallation()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfIntBuildingInstallation().add(jaxbElement);
			}
		}
	}

	public IntBuildingInstallationType marshalIntBuildingInstallation(IntBuildingInstallation src) {
		IntBuildingInstallationType dest = bldg.createIntBuildingInstallationType();
		marshalIntBuildingInstallation(src, dest);

		return dest;
	}

	@SuppressWarnings("unchecked")
	public IntBuildingInstallationPropertyType marshalIntBuildingInstallationProperty(IntBuildingInstallationProperty src) {
		IntBuildingInstallationPropertyType dest = bldg.createIntBuildingInstallationPropertyType();

		if (src.isSetIntBuildingInstallation()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getIntBuildingInstallation());
			if (elem != null && elem.getValue() instanceof IntBuildingInstallationType)
				dest.set_CityObject((JAXBElement<? extends IntBuildingInstallationType>)elem);
		}

		if (src.isSetGenericADEElement()) {
			Element element = jaxb.getADEMarshaller().marshalDOMElement(src.getGenericADEElement());
			if (element != null)
				dest.set_ADEComponent(element);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	@SuppressWarnings("unchecked")
	public InteriorFurniturePropertyType marshalInteriorFurnitureProperty(InteriorFurnitureProperty src) {
		InteriorFurniturePropertyType dest = bldg.createInteriorFurniturePropertyType();

		if (src.isSetBuildingFurniture()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getBuildingFurniture());
			if (elem != null && elem.getValue() instanceof BuildingFurnitureType)
				dest.set_CityObject((JAXBElement<? extends BuildingFurnitureType>)elem);
		}

		if (src.isSetGenericADEElement()) {
			Element element = jaxb.getADEMarshaller().marshalDOMElement(src.getGenericADEElement());
			if (element != null)
				dest.set_ADEComponent(element);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	@SuppressWarnings("unchecked")
	public InteriorRoomPropertyType marshalInteriorRoomProperty(InteriorRoomProperty src) {
		InteriorRoomPropertyType dest = bldg.createInteriorRoomPropertyType();

		if (src.isSetRoom()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getRoom());
			if (elem != null && elem.getValue() instanceof RoomType)
				dest.set_CityObject((JAXBElement<? extends RoomType>)elem);
		}

		if (src.isSetGenericADEElement()) {
			Element element = jaxb.getADEMarshaller().marshalDOMElement(src.getGenericADEElement());
			if (element != null)
				dest.set_ADEComponent(element);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public void marshalInteriorWallSurface(InteriorWallSurface src, InteriorWallSurfaceType dest) {
		marshalAbstractBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfInteriorWallSurface()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfInteriorWallSurface()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfInteriorWallSurface().add(jaxbElement);
			}
		}
	}

	public InteriorWallSurfaceType marshalInteriorWallSurface(InteriorWallSurface src) {
		InteriorWallSurfaceType dest = bldg.createInteriorWallSurfaceType();
		marshalInteriorWallSurface(src, dest);

		return dest;
	}

	@SuppressWarnings("unchecked")
	public OpeningPropertyType marshalOpeningProperty(OpeningProperty src) {
		OpeningPropertyType dest = bldg.createOpeningPropertyType();

		if (src.isSetOpening()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getOpening());
			if (elem != null && elem.getValue() instanceof AbstractOpeningType)
				dest.set_Opening((JAXBElement<? extends AbstractOpeningType>)elem);
		}

		if (src.isSetGenericADEElement()) {
			Element element = jaxb.getADEMarshaller().marshalDOMElement(src.getGenericADEElement());
			if (element != null)
				dest.set_ADEComponent(element);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public void marshalOuterCeilingSurface(OuterCeilingSurface src, OuterCeilingSurfaceType dest) {
		marshalAbstractBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfOuterCeilingSurface()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfOuterCeilingSurface()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfOuterCeilingSurface().add(jaxbElement);
			}
		}
	}

	public OuterCeilingSurfaceType marshalOuterCeilingSurface(OuterCeilingSurface src) {
		OuterCeilingSurfaceType dest = bldg.createOuterCeilingSurfaceType();
		marshalOuterCeilingSurface(src, dest);

		return dest;
	}

	public void marshalOuterFloorSurface(OuterFloorSurface src, OuterFloorSurfaceType dest) {
		marshalAbstractBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfOuterFloorSurface()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfOuterFloorSurface()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfOuterFloorSurface().add(jaxbElement);
			}
		}
	}

	public OuterFloorSurfaceType marshalOuterFloorSurface(OuterFloorSurface src) {
		OuterFloorSurfaceType dest = bldg.createOuterFloorSurfaceType();
		marshalOuterFloorSurface(src, dest);

		return dest;
	}

	public void marshalRoofSurface(RoofSurface src, RoofSurfaceType dest) {
		marshalAbstractBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfRoofSurface()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfRoofSurface()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfRoofSurface().add(jaxbElement);
			}
		}
	}

	public RoofSurfaceType marshalRoofSurface(RoofSurface src) {
		RoofSurfaceType dest = bldg.createRoofSurfaceType();
		marshalRoofSurface(src, dest);

		return dest;
	}

	public void marshalRoom(Room src, RoomType dest) {
		citygml.getCore200Marshaller().marshalAbstractCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(jaxb.getGMLMarshaller().marshalCode(src.getClazz()));

		if (src.isSetFunction()) {
			for (Code function : src.getFunction())
				dest.getFunction().add(jaxb.getGMLMarshaller().marshalCode(function));
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage())
				dest.getUsage().add(jaxb.getGMLMarshaller().marshalCode(usage));
		}

		if (src.isSetLod4Solid())
			dest.setLod4Solid(jaxb.getGMLMarshaller().marshalSolidProperty(src.getLod4Solid()));

		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod4MultiSurface()));

		if (src.isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : src.getBoundedBySurface())
				dest.getBoundedBySurface().add(marshalBoundarySurfaceProperty(boundarySurfaceProperty));
		}

		if (src.isSetInteriorFurniture()) {
			for (InteriorFurnitureProperty interiorFurnitureProperty : src.getInteriorFurniture())
				dest.getInteriorFurniture().add(marshalInteriorFurnitureProperty(interiorFurnitureProperty));
		}

		if (src.isSetRoomInstallation()) {
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : src.getRoomInstallation())
				dest.getRoomInstallation().add(marshalIntBuildingInstallationProperty(intBuildingInstallationProperty));
		}	

		if (src.isSetGenericApplicationPropertyOfRoom()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfRoom()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfRoom().add(jaxbElement);
			}
		}
	}

	public RoomType marshalRoom(Room src) {
		RoomType dest = bldg.createRoomType();
		marshalRoom(src, dest);

		return dest;
	}

	public void marshalWallSurface(WallSurface src, WallSurfaceType dest) {
		marshalAbstractBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfWallSurface()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfWallSurface()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfWallSurface().add(jaxbElement);
			}
		}
	}

	public WallSurfaceType marshalWallSurface(WallSurface src) {
		WallSurfaceType dest = bldg.createWallSurfaceType();
		marshalWallSurface(src, dest);

		return dest;
	}

	public void marshalWindow(Window src, WindowType dest) {
		marshalAbstractOpening(src, dest);

		if (src.isSetGenericApplicationPropertyOfWindow()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfWindow()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfWindow().add(jaxbElement);
			}
		}
	}

	public WindowType marshalWindow(Window src) {
		WindowType dest = bldg.createWindowType();
		marshalWindow(src, dest);

		return dest;
	}

	private JAXBElement<?> createBuilding(Building src) {
		return bldg.createBuilding(marshalBuilding(src));
	}

	private JAXBElement<?> createBuildingFurniture(BuildingFurniture src) {
		return bldg.createBuildingFurniture(marshalBuildingFurniture(src));
	}

	private JAXBElement<?> createBuildingInstallation(BuildingInstallation src) {
		return bldg.createBuildingInstallation(marshalBuildingInstallation(src));
	}

	private JAXBElement<?> createBuildingPart(BuildingPart src) {
		return bldg.createBuildingPart(marshalBuildingPart(src));
	}

	private JAXBElement<?> createCeilingSurface(CeilingSurface src) {
		return bldg.createCeilingSurface(marshalCeilingSurface(src));
	}

	private JAXBElement<?> createClosureSurface(ClosureSurface src) {
		return bldg.createClosureSurface(marshalClosureSurface(src));
	}

	private JAXBElement<?> createDoor(Door src) {
		return bldg.createDoor(marshalDoor(src));
	}

	private JAXBElement<?> createFloorSurface(FloorSurface src) {
		return bldg.createFloorSurface(marshalFloorSurface(src));
	}

	private JAXBElement<?> createGroundSurface(GroundSurface src) {
		return bldg.createGroundSurface(marshalGroundSurface(src));
	}

	private JAXBElement<?> createIntBuildingInstallation(IntBuildingInstallation src) {
		return bldg.createIntBuildingInstallation(marshalIntBuildingInstallation(src));
	}

	private JAXBElement<?> createInteriorWallSurface(InteriorWallSurface src) {
		return bldg.createInteriorWallSurface(marshalInteriorWallSurface(src));
	}

	private JAXBElement<?> createOuterCeilingSurface(OuterCeilingSurface src) {
		return bldg.createOuterCeilingSurface(marshalOuterCeilingSurface(src));
	}

	private JAXBElement<?> createOuterFloorSurface(OuterFloorSurface src) {
		return bldg.createOuterFloorSurface(marshalOuterFloorSurface(src));
	}

	private JAXBElement<?> createRoofSurface(RoofSurface src) {
		return bldg.createRoofSurface(marshalRoofSurface(src));
	}

	private JAXBElement<?> createRoom(Room src) {
		return bldg.createRoom(marshalRoom(src));
	}

	private JAXBElement<?> createWallSurface(WallSurface src) {
		return bldg.createWallSurface(marshalWallSurface(src));
	}

	private JAXBElement<?> createWindow(Window src) {
		return bldg.createWindow(marshalWindow(src));
	}

}
