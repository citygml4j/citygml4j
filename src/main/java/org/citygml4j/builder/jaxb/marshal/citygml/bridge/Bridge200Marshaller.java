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
package org.citygml4j.builder.jaxb.marshal.citygml.bridge;

import net.opengis.citygml.bridge._2.AbstractBoundarySurfaceType;
import net.opengis.citygml.bridge._2.AbstractBridgeType;
import net.opengis.citygml.bridge._2.AbstractOpeningType;
import net.opengis.citygml.bridge._2.BoundarySurfacePropertyType;
import net.opengis.citygml.bridge._2.BridgeConstructionElementPropertyType;
import net.opengis.citygml.bridge._2.BridgeConstructionElementType;
import net.opengis.citygml.bridge._2.BridgeFurnitureType;
import net.opengis.citygml.bridge._2.BridgeInstallationPropertyType;
import net.opengis.citygml.bridge._2.BridgeInstallationType;
import net.opengis.citygml.bridge._2.BridgePartPropertyType;
import net.opengis.citygml.bridge._2.BridgePartType;
import net.opengis.citygml.bridge._2.BridgeRoomType;
import net.opengis.citygml.bridge._2.BridgeType;
import net.opengis.citygml.bridge._2.CeilingSurfaceType;
import net.opengis.citygml.bridge._2.ClosureSurfaceType;
import net.opengis.citygml.bridge._2.DoorType;
import net.opengis.citygml.bridge._2.FloorSurfaceType;
import net.opengis.citygml.bridge._2.GroundSurfaceType;
import net.opengis.citygml.bridge._2.IntBridgeInstallationPropertyType;
import net.opengis.citygml.bridge._2.IntBridgeInstallationType;
import net.opengis.citygml.bridge._2.InteriorBridgeRoomPropertyType;
import net.opengis.citygml.bridge._2.InteriorFurniturePropertyType;
import net.opengis.citygml.bridge._2.InteriorWallSurfaceType;
import net.opengis.citygml.bridge._2.ObjectFactory;
import net.opengis.citygml.bridge._2.OpeningPropertyType;
import net.opengis.citygml.bridge._2.OuterCeilingSurfaceType;
import net.opengis.citygml.bridge._2.OuterFloorSurfaceType;
import net.opengis.citygml.bridge._2.RoofSurfaceType;
import net.opengis.citygml.bridge._2.WallSurfaceType;
import net.opengis.citygml.bridge._2.WindowType;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.bridge.AbstractBoundarySurface;
import org.citygml4j.model.citygml.bridge.AbstractBridge;
import org.citygml4j.model.citygml.bridge.AbstractOpening;
import org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.bridge.Bridge;
import org.citygml4j.model.citygml.bridge.BridgeConstructionElement;
import org.citygml4j.model.citygml.bridge.BridgeConstructionElementProperty;
import org.citygml4j.model.citygml.bridge.BridgeFurniture;
import org.citygml4j.model.citygml.bridge.BridgeInstallation;
import org.citygml4j.model.citygml.bridge.BridgeInstallationProperty;
import org.citygml4j.model.citygml.bridge.BridgePart;
import org.citygml4j.model.citygml.bridge.BridgePartProperty;
import org.citygml4j.model.citygml.bridge.BridgeRoom;
import org.citygml4j.model.citygml.bridge.CeilingSurface;
import org.citygml4j.model.citygml.bridge.ClosureSurface;
import org.citygml4j.model.citygml.bridge.Door;
import org.citygml4j.model.citygml.bridge.FloorSurface;
import org.citygml4j.model.citygml.bridge.GroundSurface;
import org.citygml4j.model.citygml.bridge.IntBridgeInstallation;
import org.citygml4j.model.citygml.bridge.IntBridgeInstallationProperty;
import org.citygml4j.model.citygml.bridge.InteriorBridgeRoomProperty;
import org.citygml4j.model.citygml.bridge.InteriorFurnitureProperty;
import org.citygml4j.model.citygml.bridge.InteriorWallSurface;
import org.citygml4j.model.citygml.bridge.OpeningProperty;
import org.citygml4j.model.citygml.bridge.OuterCeilingSurface;
import org.citygml4j.model.citygml.bridge.OuterFloorSurface;
import org.citygml4j.model.citygml.bridge.RoofSurface;
import org.citygml4j.model.citygml.bridge.WallSurface;
import org.citygml4j.model.citygml.bridge.Window;
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
import java.time.LocalDate;
import java.util.concurrent.locks.ReentrantLock;

public class Bridge200Marshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final ObjectFactory brid = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;
	private TypeMapper<JAXBElement<?>> elementMapper;
	private TypeMapper<Object> typeMapper;

	public Bridge200Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	private TypeMapper<JAXBElement<?>> getElementMapper() {
		if (elementMapper == null) {
			lock.lock();
			try {
				if (elementMapper == null) {
					elementMapper = TypeMapper.<JAXBElement<?>>create()
							.with(Bridge.class, this::createBridge)
							.with(BridgeConstructionElement.class, this::createBridgeConstructionElement)
							.with(BridgeFurniture.class, this::createBridgeFurniture)
							.with(BridgeInstallation.class, this::createBridgeInstallation)
							.with(BridgePart.class, this::createBridgePart)
							.with(CeilingSurface.class, this::createCeilingSurface)
							.with(ClosureSurface.class, this::createClosureSurface)
							.with(Door.class, this::createDoor)
							.with(FloorSurface.class, this::createFloorSurface)
							.with(GroundSurface.class, this::createGroundSurface)
							.with(IntBridgeInstallation.class, this::createIntBridgeInstallation)
							.with(InteriorWallSurface.class, this::createInteriorWallSurface)
							.with(OuterCeilingSurface.class, this::createOuterCeilingSurface)
							.with(OuterFloorSurface.class, this::createOuterFloorSurface)
							.with(RoofSurface.class, this::createRoofSurface)
							.with(BridgeRoom.class, this::createBridgeRoom)
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
							.with(Bridge.class, this::marshalBridge)
							.with(BridgeConstructionElement.class, this::marshalBridgeConstructionElement)
							.with(BridgeFurniture.class, this::marshalBridgeFurniture)
							.with(BridgeInstallation.class, this::marshalBridgeInstallation)
							.with(BridgeInstallationProperty.class, this::marshalBridgeInstallationProperty)
							.with(BridgePart.class, this::marshalBridgePart)
							.with(BridgePartProperty.class, this::marshalBridgePartProperty)
							.with(CeilingSurface.class, this::marshalCeilingSurface)
							.with(ClosureSurface.class, this::marshalClosureSurface)
							.with(Door.class, this::marshalDoor)
							.with(FloorSurface.class, this::marshalFloorSurface)
							.with(GroundSurface.class, this::marshalGroundSurface)
							.with(IntBridgeInstallation.class, this::marshalIntBridgeInstallation)
							.with(IntBridgeInstallationProperty.class, this::marshalIntBridgeInstallationProperty)
							.with(InteriorFurnitureProperty.class, this::marshalInteriorFurnitureProperty)
							.with(InteriorBridgeRoomProperty.class, this::marshalInteriorBridgeRoomProperty)
							.with(InteriorWallSurface.class, this::marshalInteriorWallSurface)
							.with(OpeningProperty.class, this::marshalOpeningProperty)
							.with(OuterCeilingSurface.class, this::marshalOuterCeilingSurface)
							.with(OuterFloorSurface.class, this::marshalOuterFloorSurface)
							.with(RoofSurface.class, this::marshalRoofSurface)
							.with(BridgeRoom.class, this::marshalBridgeRoom)
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

	public void marshalAbstractBridge(AbstractBridge src, AbstractBridgeType dest) {
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

		if (src.isSetIsMovable())
			dest.setIsMovable(src.getIsMovable());

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

		if (src.isSetLod2MultiCurve())
			dest.setLod2MultiCurve(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod2MultiCurve()));

		if (src.isSetLod3MultiCurve())
			dest.setLod3MultiCurve(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod3MultiCurve()));

		if (src.isSetLod4MultiCurve())
			dest.setLod4MultiCurve(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod4MultiCurve()));	

		if (src.isSetOuterBridgeInstallation()) {
			for (BridgeInstallationProperty bridgeInstallationProperty : src.getOuterBridgeInstallation())
				dest.getOuterBridgeInstallation().add(marshalBridgeInstallationProperty(bridgeInstallationProperty));
		}

		if (src.isSetOuterBridgeConstructionElement()) {
			for (BridgeConstructionElementProperty bridgeConstructionElementProperty : src.getOuterBridgeConstructionElement())
				dest.getOuterBridgeConstruction().add(marshalBridgeConstructionElementProperty(bridgeConstructionElementProperty));
		}

		if (src.isSetInteriorBridgeInstallation()) {
			for (IntBridgeInstallationProperty intBridgeInstallationProperty : src.getInteriorBridgeInstallation())
				dest.getInteriorBridgeInstallation().add(marshalIntBridgeInstallationProperty(intBridgeInstallationProperty));
		}

		if (src.isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : src.getBoundedBySurface())
				dest.getBoundedBySurface().add(marshalBoundarySurfaceProperty(boundarySurfaceProperty));
		}

		if (src.isSetConsistsOfBridgePart()) {
			for (BridgePartProperty bridgePartProperty : src.getConsistsOfBridgePart())
				dest.getConsistsOfBridgePart().add(marshalBridgePartProperty(bridgePartProperty));
		}

		if (src.isSetInteriorBridgeRoom()) {
			for (InteriorBridgeRoomProperty interiorBridgeRoomProperty : src.getInteriorBridgeRoom())
				dest.getInteriorBridgeRoom().add(marshalInteriorBridgeRoomProperty(interiorBridgeRoomProperty));
		}

		if (src.isSetAddress()) {
			for (AddressProperty addressProperty : src.getAddress())
				dest.getAddress().add(citygml.getCore200Marshaller().marshalAddressProperty(addressProperty));
		}	

		if (src.isSetGenericApplicationPropertyOfAbstractBridge()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfAbstractBridge()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfAbstractBridge().add(jaxbElement);
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
		BoundarySurfacePropertyType dest = brid.createBoundarySurfacePropertyType();

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

	public void marshalBridge(Bridge src, BridgeType dest) {
		marshalAbstractBridge(src, dest);

		if (src.isSetGenericApplicationPropertyOfBridge()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfBridge()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfBridge().add(jaxbElement);
			}
		}
	}

	public BridgeType marshalBridge(Bridge src) {
		BridgeType dest = brid.createBridgeType();
		marshalBridge(src, dest);

		return dest;
	}

	public void marshalBridgeConstructionElement(BridgeConstructionElement src, BridgeConstructionElementType dest) {
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

		if (src.isSetLod1Geometry())
			dest.setLod1Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod1Geometry()));

		if (src.isSetLod2Geometry())
			dest.setLod2Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod2Geometry()));

		if (src.isSetLod3Geometry())
			dest.setLod3Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod3Geometry()));

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod4Geometry()));

		if (src.isSetLod1ImplicitRepresentation())
			dest.setLod1ImplicitRepresentation(citygml.getCore200Marshaller().marshalImplicitRepresentationProperty(src.getLod1ImplicitRepresentation()));

		if (src.isSetLod2ImplicitRepresentation())
			dest.setLod2ImplicitRepresentation(citygml.getCore200Marshaller().marshalImplicitRepresentationProperty(src.getLod2ImplicitRepresentation()));

		if (src.isSetLod3ImplicitRepresentation())
			dest.setLod3ImplicitRepresentation(citygml.getCore200Marshaller().marshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation()));

		if (src.isSetLod4ImplicitRepresentation())
			dest.setLod4ImplicitRepresentation(citygml.getCore200Marshaller().marshalImplicitRepresentationProperty(src.getLod4ImplicitRepresentation()));

		if (src.isSetLod1TerrainIntersection())
			dest.setLod1TerrainIntersection(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod1TerrainIntersection()));

		if (src.isSetLod2TerrainIntersection())
			dest.setLod2TerrainIntersection(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod2TerrainIntersection()));

		if (src.isSetLod3TerrainIntersection())
			dest.setLod3TerrainIntersection(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod3TerrainIntersection()));

		if (src.isSetLod4TerrainIntersection())
			dest.setLod4TerrainIntersection(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod4TerrainIntersection()));

		if (src.isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : src.getBoundedBySurface())
				dest.getBoundedBySurface().add(marshalBoundarySurfaceProperty(boundarySurfaceProperty));
		}

		if (src.isSetGenericApplicationPropertyOfBridgeConstructionElement()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfBridgeConstructionElement()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfBridgeConstructionElement().add(jaxbElement);
			}
		}
	}

	public BridgeConstructionElementType marshalBridgeConstructionElement(BridgeConstructionElement src) {
		BridgeConstructionElementType dest = new BridgeConstructionElementType();
		marshalBridgeConstructionElement(src, dest);

		return dest;
	}

	@SuppressWarnings("unchecked")
	public BridgeConstructionElementPropertyType marshalBridgeConstructionElementProperty(BridgeConstructionElementProperty src) {
		BridgeConstructionElementPropertyType dest = brid.createBridgeConstructionElementPropertyType();

		if (src.isSetBridgeConstructionElement()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getBridgeConstructionElement());
			if (elem != null && elem.getValue() instanceof BridgeConstructionElementType)
				dest.set_CityObject((JAXBElement<? extends BridgeConstructionElementType>)elem);
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

	public void marshalBridgeFurniture(BridgeFurniture src, BridgeFurnitureType dest) {
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

		if (src.isSetGenericApplicationPropertyOfBridgeFurniture()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfBridgeFurniture()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfBridgeFurniture().add(jaxbElement);
			}
		}
	}

	public BridgeFurnitureType marshalBridgeFurniture(BridgeFurniture src) {
		BridgeFurnitureType dest = brid.createBridgeFurnitureType();
		marshalBridgeFurniture(src, dest);

		return dest;
	}

	public void marshalBridgeInstallation(BridgeInstallation src, BridgeInstallationType dest) {
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

		if (src.isSetGenericApplicationPropertyOfBridgeInstallation()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfBridgeInstallation()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfBridgeInstallation().add(jaxbElement);
			}
		}
	}

	public BridgeInstallationType marshalBridgeInstallation(BridgeInstallation src) {
		BridgeInstallationType dest = brid.createBridgeInstallationType();
		marshalBridgeInstallation(src, dest);

		return dest;
	}

	@SuppressWarnings("unchecked")
	public BridgeInstallationPropertyType marshalBridgeInstallationProperty(BridgeInstallationProperty src) {
		BridgeInstallationPropertyType dest = brid.createBridgeInstallationPropertyType();

		if (src.isSetBridgeInstallation()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getBridgeInstallation());
			if (elem != null && elem.getValue() instanceof BridgeInstallationType)
				dest.set_CityObject((JAXBElement<? extends BridgeInstallationType>)elem);
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

	public void marshalBridgePart(BridgePart src, BridgePartType dest) {
		marshalAbstractBridge(src, dest);

		if (src.isSetGenericApplicationPropertyOfBridgePart()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfBridgePart()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfBridgePart().add(jaxbElement);
			}
		}
	}

	public BridgePartType marshalBridgePart(BridgePart src) {
		BridgePartType dest = brid.createBridgePartType();
		marshalBridgePart(src, dest);

		return dest;
	}

	public void marshalBridgeRoom(BridgeRoom src, BridgeRoomType dest) {
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

		if (src.isSetBridgeRoomInstallation()) {
			for (IntBridgeInstallationProperty intBridgeInstallationProperty : src.getBridgeRoomInstallation())
				dest.getBridgeRoomInstallation().add(marshalIntBridgeInstallationProperty(intBridgeInstallationProperty));
		}	

		if (src.isSetGenericApplicationPropertyOfBridgeRoom()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfBridgeRoom()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfBridgeRoom().add(jaxbElement);
			}
		}
	}

	public BridgeRoomType marshalBridgeRoom(BridgeRoom src) {
		BridgeRoomType dest = brid.createBridgeRoomType();
		marshalBridgeRoom(src, dest);

		return dest;
	}

	@SuppressWarnings("unchecked")
	public BridgePartPropertyType marshalBridgePartProperty(BridgePartProperty src) {
		BridgePartPropertyType dest = brid.createBridgePartPropertyType();

		if (src.isSetBridgePart()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getBridgePart());
			if (elem != null && elem.getValue() instanceof BridgePartType)
				dest.set_AbstractBridge((JAXBElement<? extends BridgePartType>)elem);
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
		CeilingSurfaceType dest = brid.createCeilingSurfaceType();
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
		ClosureSurfaceType dest = brid.createClosureSurfaceType();
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
		DoorType dest = brid.createDoorType();
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
		FloorSurfaceType dest = brid.createFloorSurfaceType();
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
		GroundSurfaceType dest = brid.createGroundSurfaceType();
		marshalGroundSurface(src, dest);

		return dest;
	}

	public void marshalIntBridgeInstallation(IntBridgeInstallation src, IntBridgeInstallationType dest) {
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

		if (src.isSetGenericApplicationPropertyOfIntBridgeInstallation()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfIntBridgeInstallation()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfIntBridgeInstallation().add(jaxbElement);
			}
		}
	}

	public IntBridgeInstallationType marshalIntBridgeInstallation(IntBridgeInstallation src) {
		IntBridgeInstallationType dest = brid.createIntBridgeInstallationType();
		marshalIntBridgeInstallation(src, dest);

		return dest;
	}

	@SuppressWarnings("unchecked")
	public IntBridgeInstallationPropertyType marshalIntBridgeInstallationProperty(IntBridgeInstallationProperty src) {
		IntBridgeInstallationPropertyType dest = brid.createIntBridgeInstallationPropertyType();

		if (src.isSetIntBridgeInstallation()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getIntBridgeInstallation());
			if (elem != null && elem.getValue() instanceof IntBridgeInstallationType)
				dest.set_CityObject((JAXBElement<? extends IntBridgeInstallationType>)elem);
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
	public InteriorBridgeRoomPropertyType marshalInteriorBridgeRoomProperty(InteriorBridgeRoomProperty src) {
		InteriorBridgeRoomPropertyType dest = brid.createInteriorBridgeRoomPropertyType();

		if (src.isSetBridgeRoom()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getBridgeRoom());
			if (elem != null && elem.getValue() instanceof BridgeRoomType)
				dest.set_CityObject((JAXBElement<? extends BridgeRoomType>)elem);
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
		InteriorFurniturePropertyType dest = brid.createInteriorFurniturePropertyType();

		if (src.isSetBridgeFurniture()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getBridgeFurniture());
			if (elem != null && elem.getValue() instanceof BridgeFurnitureType)
				dest.set_CityObject((JAXBElement<? extends BridgeFurnitureType>)elem);
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
		InteriorWallSurfaceType dest = brid.createInteriorWallSurfaceType();
		marshalInteriorWallSurface(src, dest);

		return dest;
	}

	@SuppressWarnings("unchecked")
	public OpeningPropertyType marshalOpeningProperty(OpeningProperty src) {
		OpeningPropertyType dest = brid.createOpeningPropertyType();

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
		OuterCeilingSurfaceType dest = brid.createOuterCeilingSurfaceType();
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
		OuterFloorSurfaceType dest = brid.createOuterFloorSurfaceType();
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
		RoofSurfaceType dest = brid.createRoofSurfaceType();
		marshalRoofSurface(src, dest);

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
		WallSurfaceType dest = brid.createWallSurfaceType();
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
		WindowType dest = brid.createWindowType();
		marshalWindow(src, dest);

		return dest;
	}

	private JAXBElement<?> createBridge(Bridge src) {
		return brid.createBridge(marshalBridge(src));
	}

	private JAXBElement<?> createBridgeConstructionElement(BridgeConstructionElement src) {
		return brid.createBridgeConstructionElement(marshalBridgeConstructionElement(src));
	}

	private JAXBElement<?> createBridgeFurniture(BridgeFurniture src) {
		return brid.createBridgeFurniture(marshalBridgeFurniture(src));
	}

	private JAXBElement<?> createBridgeInstallation(BridgeInstallation src) {
		return brid.createBridgeInstallation(marshalBridgeInstallation(src));
	}

	private JAXBElement<?> createBridgePart(BridgePart src) {
		return brid.createBridgePart(marshalBridgePart(src));
	}

	private JAXBElement<?> createCeilingSurface(CeilingSurface src) {
		return brid.createCeilingSurface(marshalCeilingSurface(src));
	}

	private JAXBElement<?> createClosureSurface(ClosureSurface src) {
		return brid.createClosureSurface(marshalClosureSurface(src));
	}

	private JAXBElement<?> createDoor(Door src) {
		return brid.createDoor(marshalDoor(src));
	}

	private JAXBElement<?> createFloorSurface(FloorSurface src) {
		return brid.createFloorSurface(marshalFloorSurface(src));
	}

	private JAXBElement<?> createGroundSurface(GroundSurface src) {
		return brid.createGroundSurface(marshalGroundSurface(src));
	}

	private JAXBElement<?> createIntBridgeInstallation(IntBridgeInstallation src) {
		return brid.createIntBridgeInstallation(marshalIntBridgeInstallation(src));
	}

	private JAXBElement<?> createInteriorWallSurface(InteriorWallSurface src) {
		return brid.createInteriorWallSurface(marshalInteriorWallSurface(src));
	}

	private JAXBElement<?> createOuterCeilingSurface(OuterCeilingSurface src) {
		return brid.createOuterCeilingSurface(marshalOuterCeilingSurface(src));
	}

	private JAXBElement<?> createOuterFloorSurface(OuterFloorSurface src) {
		return brid.createOuterFloorSurface(marshalOuterFloorSurface(src));
	}

	private JAXBElement<?> createRoofSurface(RoofSurface src) {
		return brid.createRoofSurface(marshalRoofSurface(src));
	}

	private JAXBElement<?> createBridgeRoom(BridgeRoom src) {
		return brid.createBridgeRoom(marshalBridgeRoom(src));
	}

	private JAXBElement<?> createWallSurface(WallSurface src) {
		return brid.createWallSurface(marshalWallSurface(src));
	}

	private JAXBElement<?> createWindow(Window src) {
		return brid.createWindow(marshalWindow(src));
	}

}
