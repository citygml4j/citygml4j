/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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
 * 
 * $Id$
 */
package org.citygml4j.builder.jaxb.unmarshal.citygml.bridge;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
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
import org.citygml4j.jaxb.citygml.brid._2.OpeningPropertyType;
import org.citygml4j.jaxb.citygml.brid._2.OuterCeilingSurfaceType;
import org.citygml4j.jaxb.citygml.brid._2.OuterFloorSurfaceType;
import org.citygml4j.jaxb.citygml.brid._2.RoofSurfaceType;
import org.citygml4j.jaxb.citygml.brid._2.WallSurfaceType;
import org.citygml4j.jaxb.citygml.brid._2.WindowType;
import org.citygml4j.jaxb.citygml.core._2.AddressPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.CodeType;
import org.citygml4j.model.citygml.CityGML;
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
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.xlink.XLinkActuate;
import org.citygml4j.model.gml.xlink.XLinkShow;
import org.citygml4j.model.gml.xlink.XLinkType;
import org.citygml4j.model.module.citygml.BridgeModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

public class Bridge200Unmarshaller {
	private final BridgeModule module = BridgeModule.v2_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;

	public Bridge200Unmarshaller(CityGMLUnmarshaller citygml) {
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
		else if (src instanceof BridgeType)
			dest = unmarshalBridge((BridgeType)src);
		else if (src instanceof BridgeConstructionElementType)
			dest = unmarshalBridgeConstructionElement((BridgeConstructionElementType)src);
		else if (src instanceof BridgeConstructionElementProperty)
			dest = unmarshalBridgeConstructionElementProperty((BridgeConstructionElementPropertyType)src);
		else if (src instanceof BridgeFurnitureType)
			dest = unmarshalBridgeFurniture((BridgeFurnitureType)src);
		else if (src instanceof BridgeInstallationType)
			dest = unmarshalBridgeInstallation((BridgeInstallationType)src);
		else if (src instanceof BridgeInstallationPropertyType)
			dest = unmarshalBridgeInstallationProperty((BridgeInstallationPropertyType)src);
		else if (src instanceof BridgePartType)
			dest = unmarshalBridgePart((BridgePartType)src);
		else if (src instanceof BridgePartPropertyType)
			dest = unmarshalBridgePartProperty((BridgePartPropertyType)src);
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
		else if (src instanceof IntBridgeInstallationType)
			dest = unmarshalIntBridgeInstallation((IntBridgeInstallationType)src);
		else if (src instanceof IntBridgeInstallationPropertyType)
			dest = unmarshalIntBridgeInstallationProperty((IntBridgeInstallationPropertyType)src);
		else if (src instanceof InteriorFurniturePropertyType)
			dest = unmarshalInteriorFurnitureProperty((InteriorFurniturePropertyType)src);
		else if (src instanceof InteriorBridgeRoomPropertyType)
			dest = unmarshalInteriorBridgeRoomProperty((InteriorBridgeRoomPropertyType)src);
		else if (src instanceof InteriorWallSurfaceType)
			dest = unmarshalInteriorWallSurface((InteriorWallSurfaceType)src);	
		else if (src instanceof OuterCeilingSurfaceType)
			dest = unmarshalOuterCeilingSurface((OuterCeilingSurfaceType)src);
		else if (src instanceof OuterFloorSurfaceType)
			dest = unmarshalOuterFloorSurface((OuterFloorSurfaceType)src);
		else if (src instanceof OpeningPropertyType)
			dest = unmarshalOpeningProperty((OpeningPropertyType)src);
		else if (src instanceof RoofSurfaceType)
			dest = unmarshalRoofSurface((RoofSurfaceType)src);	
		else if (src instanceof BridgeRoomType)
			dest = unmarshalBridgeRoom((BridgeRoomType)src);
		else if (src instanceof WallSurfaceType)
			dest = unmarshalWallSurface((WallSurfaceType)src);	
		else if (src instanceof WindowType)
			dest = unmarshalWindow((WindowType)src);
		
		return dest;
	}

	public void unmarshalAbstractBridge(AbstractBridgeType src, AbstractBridge dest) throws MissingADESchemaException {
		citygml.getCore200Unmarshaller().unmarshalAbstractSite(src, dest);
		
		if (src.isSetClazz())
			dest.setClazz(jaxb.getGMLUnmarshaller().unmarshalCode(src.getClazz()));

		if (src.isSetFunction()) {
			for (CodeType function : src.getFunction())
				dest.addFunction(jaxb.getGMLUnmarshaller().unmarshalCode(function));
		}

		if (src.isSetUsage()) {
			for (CodeType usage : src.getUsage())
				dest.addUsage(jaxb.getGMLUnmarshaller().unmarshalCode(usage));
		}
		
		if (src.isSetYearOfConstruction())
			dest.setYearOfConstruction(src.getYearOfConstruction().toGregorianCalendar());
		
		if (src.isSetYearOfDemolition())
			dest.setYearOfDemolition(src.getYearOfDemolition().toGregorianCalendar());
				
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
		
		if (src.isSetOuterBridgeInstallation()) {
			for (BridgeInstallationPropertyType bridgeInstallationProperty : src.getOuterBridgeInstallation())
				dest.addOuterBridgeInstallation(unmarshalBridgeInstallationProperty(bridgeInstallationProperty));
		}
		
		if (src.isSetOuterBridgeConstruction()) {
			for (BridgeConstructionElementPropertyType bridgeConstructionElementProperty : src.getOuterBridgeConstruction())
				dest.addOuterBridgeConstructionElement(unmarshalBridgeConstructionElementProperty(bridgeConstructionElementProperty));
		}
		
		if (src.isSetInteriorBridgeInstallation()) {
			for (IntBridgeInstallationPropertyType intBridgeInstallationProperty : src.getInteriorBridgeInstallation())
				dest.addInteriorBridgeInstallation(unmarshalIntBridgeInstallationProperty(intBridgeInstallationProperty));
		}
		
		if (src.isSetBoundedBySurface()) {
			for (BoundarySurfacePropertyType boundarySurfaceProperty : src.getBoundedBySurface())
				dest.addBoundedBySurface(unmarshalBoundarySurfaceProperty(boundarySurfaceProperty));
		}
		
		if (src.isSetConsistsOfBridgePart()) {
			for (BridgePartPropertyType bridgePartProperty : src.getConsistsOfBridgePart())
				dest.addConsistsOfBridgePart(unmarshalBridgePartProperty(bridgePartProperty));
		}
		
		if (src.isSetInteriorBridgeRoom()) {
			for (InteriorBridgeRoomPropertyType interiorBridgeRoomProperty : src.getInteriorBridgeRoom())
				dest.addInteriorBridgeRoom(unmarshalInteriorBridgeRoomProperty(interiorBridgeRoomProperty));
		}
		
		if (src.isSetAddress()) {
			for (AddressPropertyType addressProperty : src.getAddress())
				dest.addAddress(citygml.getCore200Unmarshaller().unmarshalAddressProperty(addressProperty));
		}	
	}
	
	public void unmarshalAbstractBoundarySurface(AbstractBoundarySurfaceType src, AbstractBoundarySurface dest) throws MissingADESchemaException {
		citygml.getCore200Unmarshaller().unmarshalAbstractCityObject(src, dest);

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
	
	public void unmarshalAbstractOpening(AbstractOpeningType src, AbstractOpening dest) throws MissingADESchemaException {
		citygml.getCore200Unmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod3MultiSurface()));

		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod4MultiSurface()));

		if (src.isSetLod3ImplicitRepresentation())
			dest.setLod3ImplicitRepresentation(citygml.getCore200Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation()));

		if (src.isSetLod4ImplicitRepresentation())
			dest.setLod4ImplicitRepresentation(citygml.getCore200Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod4ImplicitRepresentation()));	
	}

	public BoundarySurfaceProperty unmarshalBoundarySurfaceProperty(BoundarySurfacePropertyType src) throws MissingADESchemaException {
		BoundarySurfaceProperty dest = new BoundarySurfaceProperty(module);

		if (src.isSet_BoundarySurface()) {
			ModelObject object = jaxb.unmarshal(src.get_BoundarySurface());
			if (object instanceof AbstractBoundarySurface)
				dest.setObject((AbstractBoundarySurface)object);
		}
		
		if (src.isSet_ADEComponent())
			dest.setGenericADEComponent(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));
		
		return dest;
	}

	public void unmarshalBridge(BridgeType src, Bridge dest) throws MissingADESchemaException {
		unmarshalAbstractBridge(src, dest);
	}

	public Bridge unmarshalBridge(BridgeType src) throws MissingADESchemaException {
		Bridge dest = new Bridge(module);
		unmarshalBridge(src, dest);

		return dest;
	}
	
	public void unmarshalBridgeConstructionElement(BridgeConstructionElementType src, BridgeConstructionElement dest) throws MissingADESchemaException {
		citygml.getCore200Unmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(jaxb.getGMLUnmarshaller().unmarshalCode(src.getClazz()));

		if (src.isSetFunction()) {
			for (CodeType function : src.getFunction())
				dest.addFunction(jaxb.getGMLUnmarshaller().unmarshalCode(function));
		}

		if (src.isSetUsage()) {
			for (CodeType usage : src.getUsage())
				dest.addUsage(jaxb.getGMLUnmarshaller().unmarshalCode(usage));
		}
		
		if (src.isSetLod1Geometry())
			dest.setLod1Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod1Geometry()));

		if (src.isSetLod2Geometry())
			dest.setLod2Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod2Geometry()));

		if (src.isSetLod3Geometry())
			dest.setLod3Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod3Geometry()));

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod4Geometry()));

		if (src.isSetLod1ImplicitRepresentation())
			dest.setLod1ImplicitRepresentation(citygml.getCore200Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod1ImplicitRepresentation()));

		if (src.isSetLod2ImplicitRepresentation())
			dest.setLod2ImplicitRepresentation(citygml.getCore200Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod2ImplicitRepresentation()));

		if (src.isSetLod3ImplicitRepresentation())
			dest.setLod3ImplicitRepresentation(citygml.getCore200Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation()));

		if (src.isSetLod4ImplicitRepresentation())
			dest.setLod4ImplicitRepresentation(citygml.getCore200Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod4ImplicitRepresentation()));	

		if (src.isSetLod1TerrainIntersection())
			dest.setLod1TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod1TerrainIntersection()));
		
		if (src.isSetLod2TerrainIntersection())
			dest.setLod2TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod2TerrainIntersection()));
		
		if (src.isSetLod3TerrainIntersection())
			dest.setLod3TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod3TerrainIntersection()));
		
		if (src.isSetLod4TerrainIntersection())
			dest.setLod4TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod4TerrainIntersection()));

		if (src.isSetBoundedBySurface()) {
			for (BoundarySurfacePropertyType boundarySurfaceProperty : src.getBoundedBySurface())
				dest.addBoundedBySurface(unmarshalBoundarySurfaceProperty(boundarySurfaceProperty));
		}		
	}
	
	public BridgeConstructionElement unmarshalBridgeConstructionElement(BridgeConstructionElementType src) throws MissingADESchemaException {
		BridgeConstructionElement dest = new BridgeConstructionElement(module);
		unmarshalBridgeConstructionElement(src, dest);
		
		return dest;
	}
	
	public BridgeConstructionElementProperty unmarshalBridgeConstructionElementProperty(BridgeConstructionElementPropertyType src) throws MissingADESchemaException {
		BridgeConstructionElementProperty dest = new BridgeConstructionElementProperty(module);

		if (src.isSetBridgeConstructionElement())
			dest.setBridgeConstructionElement(unmarshalBridgeConstructionElement(src.getBridgeConstructionElement()));
		
		if (src.isSet_ADEComponent())
			dest.setGenericADEComponent(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));
			
		return dest;
	}
	
	public void unmarshalBridgeFurniture(BridgeFurnitureType src, BridgeFurniture dest) throws MissingADESchemaException {
		citygml.getCore200Unmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(jaxb.getGMLUnmarshaller().unmarshalCode(src.getClazz()));

		if (src.isSetFunction()) {
			for (CodeType function : src.getFunction())
				dest.addFunction(jaxb.getGMLUnmarshaller().unmarshalCode(function));
		}

		if (src.isSetUsage()) {
			for (CodeType usage : src.getUsage())
				dest.addUsage(jaxb.getGMLUnmarshaller().unmarshalCode(usage));
		}

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod4Geometry()));

		if (src.isSetLod4ImplicitRepresentation())
			dest.setLod4ImplicitRepresentation(citygml.getCore200Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod4ImplicitRepresentation()));
	}

	public BridgeFurniture unmarshalBridgeFurniture(BridgeFurnitureType src) throws MissingADESchemaException {
		BridgeFurniture dest = new BridgeFurniture(module);
		unmarshalBridgeFurniture(src, dest);

		return dest;
	}

	public void unmarshalBridgeInstallation(BridgeInstallationType src, BridgeInstallation dest) throws MissingADESchemaException {
		citygml.getCore200Unmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(jaxb.getGMLUnmarshaller().unmarshalCode(src.getClazz()));

		if (src.isSetFunction()) {
			for (CodeType function : src.getFunction())
				dest.addFunction(jaxb.getGMLUnmarshaller().unmarshalCode(function));
		}

		if (src.isSetUsage()) {
			for (CodeType usage : src.getUsage())
				dest.addUsage(jaxb.getGMLUnmarshaller().unmarshalCode(usage));
		}

		if (src.isSetLod2Geometry())
			dest.setLod2Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod2Geometry()));

		if (src.isSetLod3Geometry())
			dest.setLod3Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod3Geometry()));

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod4Geometry()));

		if (src.isSetLod2ImplicitRepresentation())
			dest.setLod2ImplicitRepresentation(citygml.getCore200Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod2ImplicitRepresentation()));

		if (src.isSetLod3ImplicitRepresentation())
			dest.setLod3ImplicitRepresentation(citygml.getCore200Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation()));

		if (src.isSetLod4ImplicitRepresentation())
			dest.setLod4ImplicitRepresentation(citygml.getCore200Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod4ImplicitRepresentation()));	

		if (src.isSetBoundedBySurface()) {
			for (BoundarySurfacePropertyType boundarySurfaceProperty : src.getBoundedBySurface())
				dest.addBoundedBySurface(unmarshalBoundarySurfaceProperty(boundarySurfaceProperty));
		}
	}

	public BridgeInstallation unmarshalBridgeInstallation(BridgeInstallationType src) throws MissingADESchemaException {
		BridgeInstallation dest = new BridgeInstallation(module);
		unmarshalBridgeInstallation(src, dest);

		return dest;
	}

	public BridgeInstallationProperty unmarshalBridgeInstallationProperty(BridgeInstallationPropertyType src) throws MissingADESchemaException {
		BridgeInstallationProperty dest = new BridgeInstallationProperty(module);

		if (src.isSetBridgeInstallation())
			dest.setBridgeInstallation(unmarshalBridgeInstallation(src.getBridgeInstallation()));
		
		if (src.isSet_ADEComponent())
			dest.setGenericADEComponent(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));
			
		return dest;
	}

	public void unmarshalBridgePart(BridgePartType src, BridgePart dest) throws MissingADESchemaException {
		unmarshalAbstractBridge(src, dest);
	}

	public BridgePart unmarshalBridgePart(BridgePartType src) throws MissingADESchemaException {
		BridgePart dest = new BridgePart(module);
		unmarshalBridgePart(src, dest);

		return dest;
	}

	public BridgePartProperty unmarshalBridgePartProperty(BridgePartPropertyType src) throws MissingADESchemaException {
		BridgePartProperty dest = new BridgePartProperty(module);

		if (src.isSetBridgePart())
			dest.setBridgePart(unmarshalBridgePart(src.getBridgePart()));
		
		if (src.isSet_ADEComponent())
			dest.setGenericADEComponent(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));
		
		return dest;
	}
	
	public void unmarshalBridgeRoom(BridgeRoomType src, BridgeRoom dest) throws MissingADESchemaException {
		citygml.getCore200Unmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(jaxb.getGMLUnmarshaller().unmarshalCode(src.getClazz()));

		if (src.isSetFunction()) {
			for (CodeType function : src.getFunction())
				dest.addFunction(jaxb.getGMLUnmarshaller().unmarshalCode(function));
		}

		if (src.isSetUsage()) {
			for (CodeType usage : src.getUsage())
				dest.addUsage(jaxb.getGMLUnmarshaller().unmarshalCode(usage));
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
		
		if (src.isSetBridgeRoomInstallation()) {
			for (IntBridgeInstallationPropertyType intBridgeInstallationProperty : src.getBridgeRoomInstallation())
				dest.addBridgeRoomInstallation(unmarshalIntBridgeInstallationProperty(intBridgeInstallationProperty));
		}	
	}

	public BridgeRoom unmarshalBridgeRoom(BridgeRoomType src) throws MissingADESchemaException {
		BridgeRoom dest = new BridgeRoom(module);
		unmarshalBridgeRoom(src, dest);

		return dest;
	}

	public void unmarshalCeilingSurface(CeilingSurfaceType src, CeilingSurface dest) throws MissingADESchemaException {
		unmarshalAbstractBoundarySurface(src, dest);
	}

	public CeilingSurface unmarshalCeilingSurface(CeilingSurfaceType src) throws MissingADESchemaException {
		CeilingSurface dest = new CeilingSurface(module);
		unmarshalCeilingSurface(src, dest);

		return dest;
	}

	public void unmarshalClosureSurface(ClosureSurfaceType src, ClosureSurface dest) throws MissingADESchemaException {
		unmarshalAbstractBoundarySurface(src, dest);
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
				dest.addAddress(citygml.getCore200Unmarshaller().unmarshalAddressProperty(addressProperty));
		}
	}

	public Door unmarshalDoor(DoorType src) throws MissingADESchemaException {
		Door dest = new Door(module);
		unmarshalDoor(src, dest);

		return dest;
	}

	public void unmarshalFloorSurface(FloorSurfaceType src, FloorSurface dest) throws MissingADESchemaException {
		unmarshalAbstractBoundarySurface(src, dest);
	}

	public FloorSurface unmarshalFloorSurface(FloorSurfaceType src) throws MissingADESchemaException {
		FloorSurface dest = new FloorSurface(module);
		unmarshalFloorSurface(src, dest);

		return dest;
	}

	public void unmarshalGroundSurface(GroundSurfaceType src, GroundSurface dest) throws MissingADESchemaException {
		unmarshalAbstractBoundarySurface(src, dest);
	}

	public GroundSurface unmarshalGroundSurface(GroundSurfaceType src) throws MissingADESchemaException {
		GroundSurface dest = new GroundSurface(module);
		unmarshalGroundSurface(src, dest);

		return dest;
	}

	public void unmarshalIntBridgeInstallation(IntBridgeInstallationType src, IntBridgeInstallation dest) throws MissingADESchemaException {
		citygml.getCore200Unmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(jaxb.getGMLUnmarshaller().unmarshalCode(src.getClazz()));

		if (src.isSetFunction()) {
			for (CodeType function : src.getFunction())
				dest.addFunction(jaxb.getGMLUnmarshaller().unmarshalCode(function));
		}

		if (src.isSetUsage()) {
			for (CodeType usage : src.getUsage())
				dest.addUsage(jaxb.getGMLUnmarshaller().unmarshalCode(usage));
		}
		
		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod4Geometry()));
		
		if (src.isSetLod4ImplicitRepresentation())
			dest.setLod4ImplicitRepresentation(citygml.getCore200Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod4ImplicitRepresentation()));	

		if (src.isSetBoundedBySurface()) {
			for (BoundarySurfacePropertyType boundarySurfaceProperty : src.getBoundedBySurface())
				dest.addBoundedBySurface(unmarshalBoundarySurfaceProperty(boundarySurfaceProperty));
		}	
	}

	public IntBridgeInstallation unmarshalIntBridgeInstallation(IntBridgeInstallationType src) throws MissingADESchemaException {
		IntBridgeInstallation dest = new IntBridgeInstallation(module);
		unmarshalIntBridgeInstallation(src, dest);

		return dest;
	}

	public IntBridgeInstallationProperty unmarshalIntBridgeInstallationProperty(IntBridgeInstallationPropertyType src) throws MissingADESchemaException {
		IntBridgeInstallationProperty dest = new IntBridgeInstallationProperty(module);

		if (src.isSetIntBridgeInstallation())
			dest.setIntBridgeInstallation(unmarshalIntBridgeInstallation(src.getIntBridgeInstallation()));
		
		if (src.isSet_ADEComponent())
			dest.setGenericADEComponent(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));
		
		return dest;
	}

	public InteriorFurnitureProperty unmarshalInteriorFurnitureProperty(InteriorFurniturePropertyType src) throws MissingADESchemaException {
		InteriorFurnitureProperty dest = new InteriorFurnitureProperty(module);

		if (src.isSetBridgeFurniture())
			dest.setBridgeFurniture(unmarshalBridgeFurniture(src.getBridgeFurniture()));
		
		if (src.isSet_ADEComponent())
			dest.setGenericADEComponent(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));
		
		return dest;
	}

	public InteriorBridgeRoomProperty unmarshalInteriorBridgeRoomProperty(InteriorBridgeRoomPropertyType src) throws MissingADESchemaException {
		InteriorBridgeRoomProperty dest = new InteriorBridgeRoomProperty(module);

		if (src.isSetBridgeRoom())
			dest.setBridgeRoom(unmarshalBridgeRoom(src.getBridgeRoom()));
		
		if (src.isSet_ADEComponent())
			dest.setGenericADEComponent(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));
		
		return dest;
	}

	public void unmarshalInteriorWallSurface(InteriorWallSurfaceType src, InteriorWallSurface dest) throws MissingADESchemaException {
		unmarshalAbstractBoundarySurface(src, dest);
	}

	public InteriorWallSurface unmarshalInteriorWallSurface(InteriorWallSurfaceType src) throws MissingADESchemaException {
		InteriorWallSurface dest = new InteriorWallSurface(module);
		unmarshalInteriorWallSurface(src, dest);

		return dest;
	}
	
	public void unmarshalOuterCeilingSurface(OuterCeilingSurfaceType src, OuterCeilingSurface dest) throws MissingADESchemaException {
		unmarshalAbstractBoundarySurface(src, dest);
	}

	public OuterCeilingSurface unmarshalOuterCeilingSurface(OuterCeilingSurfaceType src) throws MissingADESchemaException {
		OuterCeilingSurface dest = new OuterCeilingSurface(module);
		unmarshalOuterCeilingSurface(src, dest);

		return dest;
	}
	
	public void unmarshalOuterFloorSurface(OuterFloorSurfaceType src, OuterFloorSurface dest) throws MissingADESchemaException {
		unmarshalAbstractBoundarySurface(src, dest);
	}

	public OuterFloorSurface unmarshalOuterFloorSurface(OuterFloorSurfaceType src) throws MissingADESchemaException {
		OuterFloorSurface dest = new OuterFloorSurface(module);
		unmarshalOuterFloorSurface(src, dest);

		return dest;
	}

	public OpeningProperty unmarshalOpeningProperty(OpeningPropertyType src) throws MissingADESchemaException {
		OpeningProperty dest = new OpeningProperty(module);

		if (src.isSet_Opening()) {
			ModelObject object = jaxb.unmarshal(src.get_Opening());
			if (object instanceof AbstractOpening)
				dest.setObject((AbstractOpening)object);
		}
		
		if (src.isSet_ADEComponent())
			dest.setGenericADEComponent(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));
		
		return dest;
	}

	public void unmarshalRoofSurface(RoofSurfaceType src, RoofSurface dest) throws MissingADESchemaException {
		unmarshalAbstractBoundarySurface(src, dest);
	}

	public RoofSurface unmarshalRoofSurface(RoofSurfaceType src) throws MissingADESchemaException {
		RoofSurface dest = new RoofSurface(module);
		unmarshalRoofSurface(src, dest);

		return dest;
	}

	public void unmarshalWallSurface(WallSurfaceType src, WallSurface dest) throws MissingADESchemaException {
		unmarshalAbstractBoundarySurface(src, dest);
	}

	public WallSurface unmarshalWallSurface(WallSurfaceType src) throws MissingADESchemaException {
		WallSurface dest = new WallSurface(module);
		unmarshalWallSurface(src, dest);

		return dest;
	}

	public void unmarshalWindow(WindowType src, Window dest) throws MissingADESchemaException {
		unmarshalAbstractOpening(src, dest);
	}

	public Window unmarshalWindow(WindowType src) throws MissingADESchemaException {
		Window dest = new Window(module);
		unmarshalWindow(src, dest);

		return dest;
	}
	
	public boolean assignGenericProperty(ADEComponent genericProperty, QName substitutionGroup, CityGML dest) {
		String name = substitutionGroup.getLocalPart();
		boolean success = true;
		
		if (dest instanceof AbstractBridge && name.equals("_GenericApplicationPropertyOfAbstractBridge"))
			((AbstractBridge)dest).addGenericApplicationPropertyOfAbstractBridge(genericProperty);
		else if (dest instanceof Bridge && name.equals("_GenericApplicationPropertyOfBridge"))
			((Bridge)dest).addGenericApplicationPropertyOfBridge(genericProperty);
		else if (dest instanceof BridgeConstructionElement && name.equals("_GenericApplicationPropertyOfBridgeConstructionElement"))
			((BridgeConstructionElement)dest).addGenericApplicationPropertyOfBridgeConstructionElement(genericProperty);
		else if (dest instanceof BridgePart && name.equals("_GenericApplicationPropertyOfBridgePart"))
			((BridgePart)dest).addGenericApplicationPropertyOfBridgePart(genericProperty);
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
		else if (dest instanceof OuterCeilingSurface && name.equals("_GenericApplicationPropertyOfOuterCeilingSurface"))
			((OuterCeilingSurface)dest).addGenericApplicationPropertyOfOuterCeilingSurface(genericProperty);
		else if (dest instanceof OuterFloorSurface && name.equals("_GenericApplicationPropertyOfOuterFloorSurface"))
			((OuterFloorSurface)dest).addGenericApplicationPropertyOfOuterFloorSurface(genericProperty);
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
		else if (dest instanceof BridgeFurniture && name.equals("_GenericApplicationPropertyOfBridgeFurniture"))
			((BridgeFurniture)dest).addGenericApplicationPropertyOfBridgeFurniture(genericProperty);
		else if (dest instanceof BridgeInstallation && name.equals("_GenericApplicationPropertyOfBridgeInstallation"))
			((BridgeInstallation)dest).addGenericApplicationPropertyOfBridgeInstallation(genericProperty);
		else if (dest instanceof IntBridgeInstallation && name.equals("_GenericApplicationPropertyOfIntBridgeInstallation"))
			((IntBridgeInstallation)dest).addGenericApplicationPropertyOfIntBridgeInstallation(genericProperty);
		else if (dest instanceof BridgeRoom && name.equals("_GenericApplicationPropertyOfBridgeRoom"))
			((BridgeRoom)dest).addGenericApplicationPropertyOfBridgeRoom(genericProperty);		
		else 
			success = false;
		
		return success;
	}
	
}
