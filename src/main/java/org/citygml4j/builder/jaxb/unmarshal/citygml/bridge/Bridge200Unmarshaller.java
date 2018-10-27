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
package org.citygml4j.builder.jaxb.unmarshal.citygml.bridge;

import net.opengis.citygml._2.AddressPropertyType;
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
import net.opengis.citygml.bridge._2.OpeningPropertyType;
import net.opengis.citygml.bridge._2.OuterCeilingSurfaceType;
import net.opengis.citygml.bridge._2.OuterFloorSurfaceType;
import net.opengis.citygml.bridge._2.RoofSurfaceType;
import net.opengis.citygml.bridge._2.WallSurfaceType;
import net.opengis.citygml.bridge._2.WindowType;
import net.opengis.gml.CodeType;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
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
import org.citygml4j.util.mapper.CheckedTypeMapper;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.concurrent.locks.ReentrantLock;

public class Bridge200Unmarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final BridgeModule module = BridgeModule.v2_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;
	private CheckedTypeMapper<CityGML> typeMapper;

	public Bridge200Unmarshaller(CityGMLUnmarshaller citygml) {
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
							.with(BridgeType.class, this::unmarshalBridge)
							.with(BridgeConstructionElementType.class, this::unmarshalBridgeConstructionElement)
							.with(BridgeConstructionElementPropertyType.class, this::unmarshalBridgeConstructionElementProperty)
							.with(BridgeFurnitureType.class, this::unmarshalBridgeFurniture)
							.with(BridgeInstallationType.class, this::unmarshalBridgeInstallation)
							.with(BridgeInstallationPropertyType.class, this::unmarshalBridgeInstallationProperty)
							.with(BridgePartType.class, this::unmarshalBridgePart)
							.with(BridgePartPropertyType.class, this::unmarshalBridgePartProperty)
							.with(CeilingSurfaceType.class, this::unmarshalCeilingSurface)
							.with(ClosureSurfaceType.class, this::unmarshalClosureSurface)
							.with(DoorType.class, this::unmarshalDoor)
							.with(FloorSurfaceType.class, this::unmarshalFloorSurface)
							.with(GroundSurfaceType.class, this::unmarshalGroundSurface)
							.with(IntBridgeInstallationType.class, this::unmarshalIntBridgeInstallation)
							.with(IntBridgeInstallationPropertyType.class, this::unmarshalIntBridgeInstallationProperty)
							.with(InteriorFurniturePropertyType.class, this::unmarshalInteriorFurnitureProperty)
							.with(InteriorBridgeRoomPropertyType.class, this::unmarshalInteriorBridgeRoomProperty)
							.with(InteriorWallSurfaceType.class, this::unmarshalInteriorWallSurface)
							.with(OuterCeilingSurfaceType.class, this::unmarshalOuterCeilingSurface)
							.with(OuterFloorSurfaceType.class, this::unmarshalOuterFloorSurface)
							.with(OpeningPropertyType.class, this::unmarshalOpeningProperty)
							.with(RoofSurfaceType.class, this::unmarshalRoofSurface)
							.with(BridgeRoomType.class, this::unmarshalBridgeRoom)
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
			dest.setYearOfConstruction(src.getYearOfConstruction().toGregorianCalendar().toZonedDateTime().toLocalDate());

		if (src.isSetYearOfDemolition())
			dest.setYearOfDemolition(src.getYearOfDemolition().toGregorianCalendar().toZonedDateTime().toLocalDate());

		if (src.isSetIsMovable())
			dest.setIsMovable(src.isIsMovable());

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

		if (src.isSet_GenericApplicationPropertyOfAbstractBridge()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfAbstractBridge()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfAbstractBridge(ade);
			}
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

		if (src.isSet_GenericApplicationPropertyOfBoundarySurface()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfBoundarySurface()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfBoundarySurface(ade);
			}
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

		if (src.isSet_BoundarySurface()) {
			ModelObject object = jaxb.unmarshal(src.get_BoundarySurface());
			if (object instanceof AbstractBoundarySurface)
				dest.setObject((AbstractBoundarySurface)object);
		}

		if (src.isSet_ADEComponent())
			dest.setGenericADEElement(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

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

		if (src.isSet_GenericApplicationPropertyOfBridge()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfBridge()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfBridge(ade);
			}
		}
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

		if (src.isSet_GenericApplicationPropertyOfBridgeConstructionElement()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfBridgeConstructionElement()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfBridgeConstructionElement(ade);
			}
		}
	}

	public BridgeConstructionElement unmarshalBridgeConstructionElement(BridgeConstructionElementType src) throws MissingADESchemaException {
		BridgeConstructionElement dest = new BridgeConstructionElement(module);
		unmarshalBridgeConstructionElement(src, dest);

		return dest;
	}

	public BridgeConstructionElementProperty unmarshalBridgeConstructionElementProperty(BridgeConstructionElementPropertyType src) throws MissingADESchemaException {
		BridgeConstructionElementProperty dest = new BridgeConstructionElementProperty(module);

		if (src.isSet_CityObject()) {
			ModelObject object = jaxb.unmarshal(src.get_CityObject());
			if (object instanceof BridgeConstructionElement)
				dest.setBridgeConstructionElement((BridgeConstructionElement)object);
		}

		if (src.isSet_ADEComponent())
			dest.setGenericADEElement(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

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

		if (src.isSet_GenericApplicationPropertyOfBridgeFurniture()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfBridgeFurniture()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfBridgeFurniture(ade);
			}
		}
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

		if (src.isSet_GenericApplicationPropertyOfBridgeInstallation()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfBridgeInstallation()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfBridgeInstallation(ade);
			}
		}
	}

	public BridgeInstallation unmarshalBridgeInstallation(BridgeInstallationType src) throws MissingADESchemaException {
		BridgeInstallation dest = new BridgeInstallation(module);
		unmarshalBridgeInstallation(src, dest);

		return dest;
	}

	public BridgeInstallationProperty unmarshalBridgeInstallationProperty(BridgeInstallationPropertyType src) throws MissingADESchemaException {
		BridgeInstallationProperty dest = new BridgeInstallationProperty(module);

		if (src.isSet_CityObject()) {
			ModelObject object = jaxb.unmarshal(src.get_CityObject());
			if (object instanceof BridgeInstallation)
				dest.setBridgeInstallation((BridgeInstallation)object);
		}

		if (src.isSet_ADEComponent())
			dest.setGenericADEElement(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

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

		if (src.isSet_GenericApplicationPropertyOfBridgePart()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfBridgePart()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfBridgePart(ade);
			}
		}
	}

	public BridgePart unmarshalBridgePart(BridgePartType src) throws MissingADESchemaException {
		BridgePart dest = new BridgePart(module);
		unmarshalBridgePart(src, dest);

		return dest;
	}

	public BridgePartProperty unmarshalBridgePartProperty(BridgePartPropertyType src) throws MissingADESchemaException {
		BridgePartProperty dest = new BridgePartProperty(module);

		if (src.isSet_AbstractBridge()) {
			ModelObject object = jaxb.unmarshal(src.get_AbstractBridge());
			if (object instanceof BridgePart)
				dest.setBridgePart((BridgePart)object);
		}

		if (src.isSet_ADEComponent())
			dest.setGenericADEElement(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

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

		if (src.isSet_GenericApplicationPropertyOfBridgeRoom()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfBridgeRoom()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfBridgeRoom(ade);
			}
		}
	}

	public BridgeRoom unmarshalBridgeRoom(BridgeRoomType src) throws MissingADESchemaException {
		BridgeRoom dest = new BridgeRoom(module);
		unmarshalBridgeRoom(src, dest);

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
				dest.addAddress(citygml.getCore200Unmarshaller().unmarshalAddressProperty(addressProperty));
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

		if (src.isSet_GenericApplicationPropertyOfIntBridgeInstallation()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfIntBridgeInstallation()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfIntBridgeInstallation(ade);
			}
		}
	}

	public IntBridgeInstallation unmarshalIntBridgeInstallation(IntBridgeInstallationType src) throws MissingADESchemaException {
		IntBridgeInstallation dest = new IntBridgeInstallation(module);
		unmarshalIntBridgeInstallation(src, dest);

		return dest;
	}

	public IntBridgeInstallationProperty unmarshalIntBridgeInstallationProperty(IntBridgeInstallationPropertyType src) throws MissingADESchemaException {
		IntBridgeInstallationProperty dest = new IntBridgeInstallationProperty(module);

		if (src.isSet_CityObject()) {
			ModelObject object = jaxb.unmarshal(src.get_CityObject());
			if (object instanceof IntBridgeInstallation)
				dest.setIntBridgeInstallation((IntBridgeInstallation)object);
		}

		if (src.isSet_ADEComponent())
			dest.setGenericADEElement(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

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

		if (src.isSet_CityObject()) {
			ModelObject object = jaxb.unmarshal(src.get_CityObject());
			if (object instanceof BridgeFurniture)
				dest.setBridgeFurniture((BridgeFurniture)object);
		}

		if (src.isSet_ADEComponent())
			dest.setGenericADEElement(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

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

		if (src.isSet_CityObject()) {
			ModelObject object = jaxb.unmarshal(src.get_CityObject());
			if (object instanceof BridgeRoom)
				dest.setBridgeRoom((BridgeRoom)object);
		}

		if (src.isSet_ADEComponent())
			dest.setGenericADEElement(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

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

	public void unmarshalOuterCeilingSurface(OuterCeilingSurfaceType src, OuterCeilingSurface dest) throws MissingADESchemaException {
		unmarshalAbstractBoundarySurface(src, dest);

		if (src.isSet_GenericApplicationPropertyOfOuterCeilingSurface()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfOuterCeilingSurface()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfOuterCeilingSurface(ade);
			}
		}
	}

	public OuterCeilingSurface unmarshalOuterCeilingSurface(OuterCeilingSurfaceType src) throws MissingADESchemaException {
		OuterCeilingSurface dest = new OuterCeilingSurface(module);
		unmarshalOuterCeilingSurface(src, dest);

		return dest;
	}

	public void unmarshalOuterFloorSurface(OuterFloorSurfaceType src, OuterFloorSurface dest) throws MissingADESchemaException {
		unmarshalAbstractBoundarySurface(src, dest);

		if (src.isSet_GenericApplicationPropertyOfOuterFloorSurface()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfOuterFloorSurface()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfOuterFloorSurface(ade);
			}
		}
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
			dest.setGenericADEElement(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

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
