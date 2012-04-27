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
package org.citygml4j.builder.jaxb.marshal.citygml.bridge;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.jaxb.citygml.brid._2.AbstractBoundarySurfaceType;
import org.citygml4j.jaxb.citygml.brid._2.AbstractBridgeType;
import org.citygml4j.jaxb.citygml.brid._2.AbstractOpeningType;
import org.citygml4j.jaxb.citygml.brid._2.BoundarySurfacePropertyType;
import org.citygml4j.jaxb.citygml.brid._2.BridgeConstructionElementPropertyType;
import org.citygml4j.jaxb.citygml.brid._2.BridgeConstructionElementType;
import org.citygml4j.jaxb.citygml.brid._2.BridgeFurnitureType;
import org.citygml4j.jaxb.citygml.brid._2.BridgeInstallationPropertyType;
import org.citygml4j.jaxb.citygml.brid._2.BridgeInstallationType;
import org.citygml4j.jaxb.citygml.brid._2.BridgePartPropertyType;
import org.citygml4j.jaxb.citygml.brid._2.BridgePartType;
import org.citygml4j.jaxb.citygml.brid._2.BridgeRoomType;
import org.citygml4j.jaxb.citygml.brid._2.BridgeType;
import org.citygml4j.jaxb.citygml.brid._2.CeilingSurfaceType;
import org.citygml4j.jaxb.citygml.brid._2.ClosureSurfaceType;
import org.citygml4j.jaxb.citygml.brid._2.DoorType;
import org.citygml4j.jaxb.citygml.brid._2.FloorSurfaceType;
import org.citygml4j.jaxb.citygml.brid._2.GroundSurfaceType;
import org.citygml4j.jaxb.citygml.brid._2.IntBridgeInstallationPropertyType;
import org.citygml4j.jaxb.citygml.brid._2.IntBridgeInstallationType;
import org.citygml4j.jaxb.citygml.brid._2.InteriorBridgeRoomPropertyType;
import org.citygml4j.jaxb.citygml.brid._2.InteriorFurniturePropertyType;
import org.citygml4j.jaxb.citygml.brid._2.InteriorWallSurfaceType;
import org.citygml4j.jaxb.citygml.brid._2.ObjectFactory;
import org.citygml4j.jaxb.citygml.brid._2.OpeningPropertyType;
import org.citygml4j.jaxb.citygml.brid._2.OuterCeilingSurfaceType;
import org.citygml4j.jaxb.citygml.brid._2.OuterFloorSurfaceType;
import org.citygml4j.jaxb.citygml.brid._2.RoofSurfaceType;
import org.citygml4j.jaxb.citygml.brid._2.WallSurfaceType;
import org.citygml4j.jaxb.citygml.brid._2.WindowType;
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
import org.citygml4j.model.citygml.bridge.BridgeModuleComponent;
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

public class Bridge200Marshaller {
	private final ObjectFactory brid = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;

	public Bridge200Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = null;

		if (src instanceof BridgeModuleComponent)
			src = marshal((BridgeModuleComponent)src);

		if (src instanceof BridgeType)
			dest = brid.createBridge((BridgeType)src);
		else if (src instanceof BridgeConstructionElementType)
			dest = brid.createBridgeConstructionElement((BridgeConstructionElementType)src);
		else if (src instanceof BridgeFurnitureType)
			dest = brid.createBridgeFurniture((BridgeFurnitureType)src);
		else if (src instanceof BridgeInstallationType)
			dest = brid.createBridgeInstallation((BridgeInstallationType)src);
		else if (src instanceof BridgePartType)
			dest = brid.createBridgePart((BridgePartType)src);
		else if (src instanceof CeilingSurfaceType)
			dest = brid.createCeilingSurface((CeilingSurfaceType)src);
		else if (src instanceof ClosureSurfaceType)
			dest = brid.createClosureSurface((ClosureSurfaceType)src);
		else if (src instanceof DoorType)
			dest = brid.createDoor((DoorType)src);
		else if (src instanceof FloorSurfaceType)
			dest = brid.createFloorSurface((FloorSurfaceType)src);
		else if (src instanceof GroundSurfaceType)
			dest = brid.createGroundSurface((GroundSurfaceType)src);
		else if (src instanceof IntBridgeInstallationType)
			dest = brid.createIntBridgeInstallation((IntBridgeInstallationType)src);
		else if (src instanceof InteriorWallSurfaceType)
			dest = brid.createInteriorWallSurface((InteriorWallSurfaceType)src);
		else if (src instanceof OuterCeilingSurfaceType)
			dest = brid.createOuterCeilingSurface((OuterCeilingSurfaceType)src);
		else if (src instanceof OuterFloorSurfaceType)
			dest = brid.createOuterFloorSurface((OuterFloorSurfaceType)src);
		else if (src instanceof RoofSurfaceType)
			dest = brid.createRoofSurface((RoofSurfaceType)src);
		else if (src instanceof BridgeRoomType)
			dest = brid.createBridgeRoom((BridgeRoomType)src);
		else if (src instanceof WallSurfaceType)
			dest = brid.createWallSurface((WallSurfaceType)src);
		else if (src instanceof WindowType)
			dest = brid.createWindow((WindowType)src);

		return dest;
	}

	public Object marshal(ModelObject src) {
		Object dest = null;

		if (src instanceof BoundarySurfaceProperty)
			dest = marshalBoundarySurfaceProperty((BoundarySurfaceProperty)src);
		else if (src instanceof Bridge)
			dest = marshalBridge((Bridge)src);
		else if (src instanceof BridgeConstructionElement)
			dest = marshalBridgeConstructionElement((BridgeConstructionElement)src);
		else if (src instanceof BridgeFurniture)
			dest = marshalBridgeFurniture((BridgeFurniture)src);
		else if (src instanceof BridgeInstallation)
			dest = marshalBridgeInstallation((BridgeInstallation)src);
		else if (src instanceof BridgeInstallationProperty)
			dest = marshalBridgeInstallationProperty((BridgeInstallationProperty)src);
		else if (src instanceof BridgePart)
			dest = marshalBridgePart((BridgePart)src);
		else if (src instanceof BridgePartProperty)
			dest = marshalBridgePartProperty((BridgePartProperty)src);
		else if (src instanceof CeilingSurface)
			dest = marshalCeilingSurface((CeilingSurface)src);
		else if (src instanceof ClosureSurface)
			dest = marshalClosureSurface((ClosureSurface)src);
		else if (src instanceof Door)
			dest = marshalDoor((Door)src);
		else if (src instanceof FloorSurface)
			dest = marshalFloorSurface((FloorSurface)src);
		else if (src instanceof GroundSurface)
			dest = marshalGroundSurface((GroundSurface)src);
		else if (src instanceof IntBridgeInstallation)
			dest = marshalIntBridgeInstallation((IntBridgeInstallation)src);
		else if (src instanceof IntBridgeInstallationProperty)
			dest = marshalIntBridgeInstallationProperty((IntBridgeInstallationProperty)src);
		else if (src instanceof InteriorFurnitureProperty)
			dest = marshalInteriorFurnitureProperty((InteriorFurnitureProperty)src);
		else if (src instanceof InteriorBridgeRoomProperty)
			dest = marshalInteriorBridgeRoomProperty((InteriorBridgeRoomProperty)src);
		else if (src instanceof InteriorWallSurface)
			dest = marshalInteriorWallSurface((InteriorWallSurface)src);
		else if (src instanceof OpeningProperty)
			dest = marshalOpeningProperty((OpeningProperty)src);
		else if (src instanceof OuterCeilingSurface)
			dest = marshalOuterCeilingSurface((OuterCeilingSurface)src);
		else if (src instanceof OuterFloorSurface)
			dest = marshalOuterFloorSurface((OuterFloorSurface)src);
		else if (src instanceof RoofSurface)
			dest = marshalRoofSurface((RoofSurface)src);
		else if (src instanceof BridgeRoom)
			dest = marshalBridgeRoom((BridgeRoom)src);
		else if (src instanceof WallSurface)
			dest = marshalWallSurface((WallSurface)src);
		else if (src instanceof Window)
			dest = marshalWindow((Window)src);

		return dest;
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
			try {
				GregorianCalendar date = src.getYearOfConstruction();
				DatatypeFactory factory = DatatypeFactory.newInstance();
				dest.setYearOfConstruction(factory.newXMLGregorianCalendarDate(
						date.get(Calendar.YEAR),
						date.get(Calendar.MONTH) + 1,
						date.get(Calendar.DAY_OF_MONTH),
						DatatypeConstants.FIELD_UNDEFINED));
			} catch (DatatypeConfigurationException e) {
				// 
			}
		}

		if (src.isSetYearOfDemolition()) {
			try {
				GregorianCalendar date = src.getYearOfDemolition();
				DatatypeFactory factory = DatatypeFactory.newInstance();
				dest.setYearOfDemolition(factory.newXMLGregorianCalendarDate(
						date.get(Calendar.YEAR),
						date.get(Calendar.MONTH) + 1,
						date.get(Calendar.DAY_OF_MONTH),
						DatatypeConstants.FIELD_UNDEFINED));
			} catch (DatatypeConfigurationException e) {
				// 
			}
		}

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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfAbstractBridge())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfAbstractBridge().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfBoundarySurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfBoundarySurface().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfOpening())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfOpening().add(citygml.ade2jaxbElement(adeComponent));
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
		
		if (src.isSetGenericADEComponent() && src.getGenericADEComponent().isSetContent())
			dest.set_ADEComponent(src.getGenericADEComponent().getContent());

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public void marshalBridge(Bridge src, BridgeType dest) {
		marshalAbstractBridge(src, dest);

		if (src.isSetGenericApplicationPropertyOfBridge()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfBridge())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfBridge().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfBridgeConstructionElement())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfBridgeConstructionElement().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public BridgeConstructionElementType marshalBridgeConstructionElement(BridgeConstructionElement src) {
		BridgeConstructionElementType dest = new BridgeConstructionElementType();
		marshalBridgeConstructionElement(src, dest);
		
		return dest;
	}
	
	public BridgeConstructionElementPropertyType marshalBridgeConstructionElementProperty(BridgeConstructionElementProperty src) {
		BridgeConstructionElementPropertyType dest = brid.createBridgeConstructionElementPropertyType();

		if (src.isSetBridgeConstructionElement())
			dest.setBridgeConstructionElement(marshalBridgeConstructionElement(src.getBridgeConstructionElement()));
		
		if (src.isSetGenericADEComponent() && src.getGenericADEComponent().isSetContent())
			dest.set_ADEComponent(src.getGenericADEComponent().getContent());

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfBridgeFurniture())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfBridgeFurniture().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfBridgeInstallation())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfBridgeInstallation().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public BridgeInstallationType marshalBridgeInstallation(BridgeInstallation src) {
		BridgeInstallationType dest = brid.createBridgeInstallationType();
		marshalBridgeInstallation(src, dest);

		return dest;
	}

	public BridgeInstallationPropertyType marshalBridgeInstallationProperty(BridgeInstallationProperty src) {
		BridgeInstallationPropertyType dest = brid.createBridgeInstallationPropertyType();

		if (src.isSetBridgeInstallation())
			dest.setBridgeInstallation(marshalBridgeInstallation(src.getBridgeInstallation()));
		
		if (src.isSetGenericADEComponent() && src.getGenericADEComponent().isSetContent())
			dest.set_ADEComponent(src.getGenericADEComponent().getContent());

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public void marshalBridgePart(BridgePart src, BridgePartType dest) {
		marshalAbstractBridge(src, dest);

		if (src.isSetGenericApplicationPropertyOfBridgePart()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfBridgePart())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfBridgePart().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfBridgeRoom())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfBridgeRoom().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public BridgeRoomType marshalBridgeRoom(BridgeRoom src) {
		BridgeRoomType dest = brid.createBridgeRoomType();
		marshalBridgeRoom(src, dest);

		return dest;
	}

	public BridgePartPropertyType marshalBridgePartProperty(BridgePartProperty src) {
		BridgePartPropertyType dest = brid.createBridgePartPropertyType();

		if (src.isSetBridgePart())
			dest.setBridgePart(marshalBridgePart(src.getBridgePart()));
		
		if (src.isSetGenericADEComponent() && src.getGenericADEComponent().isSetContent())
			dest.set_ADEComponent(src.getGenericADEComponent().getContent());

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public void marshalCeilingSurface(CeilingSurface src, CeilingSurfaceType dest) {
		marshalAbstractBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfCeilingSurface()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfCeilingSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfCeilingSurface().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfClosureSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfClosureSurface().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfDoor())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfDoor().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfFloorSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfFloorSurface().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfGroundSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfGroundSurface().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfIntBridgeInstallation())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfIntBridgeInstallation().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public IntBridgeInstallationType marshalIntBridgeInstallation(IntBridgeInstallation src) {
		IntBridgeInstallationType dest = brid.createIntBridgeInstallationType();
		marshalIntBridgeInstallation(src, dest);

		return dest;
	}

	public IntBridgeInstallationPropertyType marshalIntBridgeInstallationProperty(IntBridgeInstallationProperty src) {
		IntBridgeInstallationPropertyType dest = brid.createIntBridgeInstallationPropertyType();

		if (src.isSetIntBridgeInstallation())
			dest.setIntBridgeInstallation(marshalIntBridgeInstallation(src.getIntBridgeInstallation()));
		
		if (src.isSetGenericADEComponent() && src.getGenericADEComponent().isSetContent())
			dest.set_ADEComponent(src.getGenericADEComponent().getContent());

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}
	
	public InteriorBridgeRoomPropertyType marshalInteriorBridgeRoomProperty(InteriorBridgeRoomProperty src) {
		InteriorBridgeRoomPropertyType dest = brid.createInteriorBridgeRoomPropertyType();

		if (src.isSetBridgeRoom())
			dest.setBridgeRoom(marshalBridgeRoom(src.getBridgeRoom()));
		
		if (src.isSetGenericADEComponent() && src.getGenericADEComponent().isSetContent())
			dest.set_ADEComponent(src.getGenericADEComponent().getContent());

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public InteriorFurniturePropertyType marshalInteriorFurnitureProperty(InteriorFurnitureProperty src) {
		InteriorFurniturePropertyType dest = brid.createInteriorFurniturePropertyType();

		if (src.isSetBridgeFurniture())
			dest.setBridgeFurniture(marshalBridgeFurniture(src.getBridgeFurniture()));
		
		if (src.isSetGenericADEComponent() && src.getGenericADEComponent().isSetContent())
			dest.set_ADEComponent(src.getGenericADEComponent().getContent());

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public void marshalInteriorWallSurface(InteriorWallSurface src, InteriorWallSurfaceType dest) {
		marshalAbstractBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfInteriorWallSurface()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfInteriorWallSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfInteriorWallSurface().add(citygml.ade2jaxbElement(adeComponent));
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
		
		if (src.isSetGenericADEComponent() && src.getGenericADEComponent().isSetContent())
			dest.set_ADEComponent(src.getGenericADEComponent().getContent());

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}
	
	public void marshalOuterCeilingSurface(OuterCeilingSurface src, OuterCeilingSurfaceType dest) {
		marshalAbstractBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfOuterCeilingSurface()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfOuterCeilingSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfOuterCeilingSurface().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfOuterFloorSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfOuterFloorSurface().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfRoofSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfRoofSurface().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfWallSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfWallSurface().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfWindow())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfWindow().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public WindowType marshalWindow(Window src) {
		WindowType dest = brid.createWindowType();
		marshalWindow(src, dest);

		return dest;
	}

}
