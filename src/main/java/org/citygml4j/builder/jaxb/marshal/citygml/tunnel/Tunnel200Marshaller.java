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
package org.citygml4j.builder.jaxb.marshal.citygml.tunnel;

import net.opengis.citygml.tunnel._2.AbstractBoundarySurfaceType;
import net.opengis.citygml.tunnel._2.AbstractOpeningType;
import net.opengis.citygml.tunnel._2.AbstractTunnelType;
import net.opengis.citygml.tunnel._2.BoundarySurfacePropertyType;
import net.opengis.citygml.tunnel._2.CeilingSurfaceType;
import net.opengis.citygml.tunnel._2.ClosureSurfaceType;
import net.opengis.citygml.tunnel._2.DoorType;
import net.opengis.citygml.tunnel._2.FloorSurfaceType;
import net.opengis.citygml.tunnel._2.GroundSurfaceType;
import net.opengis.citygml.tunnel._2.HollowSpaceType;
import net.opengis.citygml.tunnel._2.IntTunnelInstallationPropertyType;
import net.opengis.citygml.tunnel._2.IntTunnelInstallationType;
import net.opengis.citygml.tunnel._2.InteriorFurniturePropertyType;
import net.opengis.citygml.tunnel._2.InteriorHollowSpacePropertyType;
import net.opengis.citygml.tunnel._2.InteriorWallSurfaceType;
import net.opengis.citygml.tunnel._2.ObjectFactory;
import net.opengis.citygml.tunnel._2.OpeningPropertyType;
import net.opengis.citygml.tunnel._2.OuterCeilingSurfaceType;
import net.opengis.citygml.tunnel._2.OuterFloorSurfaceType;
import net.opengis.citygml.tunnel._2.RoofSurfaceType;
import net.opengis.citygml.tunnel._2.TunnelFurnitureType;
import net.opengis.citygml.tunnel._2.TunnelInstallationPropertyType;
import net.opengis.citygml.tunnel._2.TunnelInstallationType;
import net.opengis.citygml.tunnel._2.TunnelPartPropertyType;
import net.opengis.citygml.tunnel._2.TunnelPartType;
import net.opengis.citygml.tunnel._2.TunnelType;
import net.opengis.citygml.tunnel._2.WallSurfaceType;
import net.opengis.citygml.tunnel._2.WindowType;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface;
import org.citygml4j.model.citygml.tunnel.AbstractOpening;
import org.citygml4j.model.citygml.tunnel.AbstractTunnel;
import org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.tunnel.CeilingSurface;
import org.citygml4j.model.citygml.tunnel.ClosureSurface;
import org.citygml4j.model.citygml.tunnel.Door;
import org.citygml4j.model.citygml.tunnel.FloorSurface;
import org.citygml4j.model.citygml.tunnel.GroundSurface;
import org.citygml4j.model.citygml.tunnel.HollowSpace;
import org.citygml4j.model.citygml.tunnel.IntTunnelInstallation;
import org.citygml4j.model.citygml.tunnel.IntTunnelInstallationProperty;
import org.citygml4j.model.citygml.tunnel.InteriorFurnitureProperty;
import org.citygml4j.model.citygml.tunnel.InteriorHollowSpaceProperty;
import org.citygml4j.model.citygml.tunnel.InteriorWallSurface;
import org.citygml4j.model.citygml.tunnel.OpeningProperty;
import org.citygml4j.model.citygml.tunnel.OuterCeilingSurface;
import org.citygml4j.model.citygml.tunnel.OuterFloorSurface;
import org.citygml4j.model.citygml.tunnel.RoofSurface;
import org.citygml4j.model.citygml.tunnel.Tunnel;
import org.citygml4j.model.citygml.tunnel.TunnelFurniture;
import org.citygml4j.model.citygml.tunnel.TunnelInstallation;
import org.citygml4j.model.citygml.tunnel.TunnelInstallationProperty;
import org.citygml4j.model.citygml.tunnel.TunnelPart;
import org.citygml4j.model.citygml.tunnel.TunnelPartProperty;
import org.citygml4j.model.citygml.tunnel.WallSurface;
import org.citygml4j.model.citygml.tunnel.Window;
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

public class Tunnel200Marshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final ObjectFactory tun = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;
	private TypeMapper<JAXBElement<?>> elementMapper;
	private TypeMapper<Object> typeMapper;

	public Tunnel200Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	private TypeMapper<JAXBElement<?>> getElementMapper() {
		if (elementMapper == null) {
			lock.lock();
			try {
				if (elementMapper == null) {
					elementMapper = TypeMapper.<JAXBElement<?>>create()
							.with(Tunnel.class, this::createTunnel)
							.with(TunnelFurniture.class, this::createTunnelFurniture)
							.with(TunnelInstallation.class, this::createTunnelInstallation)
							.with(TunnelPart.class, this::createTunnelPart)
							.with(CeilingSurface.class, this::createCeilingSurface)
							.with(ClosureSurface.class, this::createClosureSurface)
							.with(Door.class, this::createDoor)
							.with(FloorSurface.class, this::createFloorSurface)
							.with(GroundSurface.class, this::createGroundSurface)
							.with(IntTunnelInstallation.class, this::createIntTunnelInstallation)
							.with(InteriorWallSurface.class, this::createInteriorWallSurface)
							.with(OuterCeilingSurface.class, this::createOuterCeilingSurface)
							.with(OuterFloorSurface.class, this::createOuterFloorSurface)
							.with(RoofSurface.class, this::createRoofSurface)
							.with(HollowSpace.class, this::createHollowSpace)
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
							.with(Tunnel.class, this::marshalTunnel)
							.with(TunnelFurniture.class, this::marshalTunnelFurniture)
							.with(TunnelInstallation.class, this::marshalTunnelInstallation)
							.with(TunnelInstallationProperty.class, this::marshalTunnelInstallationProperty)
							.with(TunnelPart.class, this::marshalTunnelPart)
							.with(TunnelPartProperty.class, this::marshalTunnelPartProperty)
							.with(CeilingSurface.class, this::marshalCeilingSurface)
							.with(ClosureSurface.class, this::marshalClosureSurface)
							.with(Door.class, this::marshalDoor)
							.with(FloorSurface.class, this::marshalFloorSurface)
							.with(GroundSurface.class, this::marshalGroundSurface)
							.with(IntTunnelInstallation.class, this::marshalIntTunnelInstallation)
							.with(IntTunnelInstallationProperty.class, this::marshalIntTunnelInstallationProperty)
							.with(InteriorFurnitureProperty.class, this::marshalInteriorFurnitureProperty)
							.with(InteriorHollowSpaceProperty.class, this::marshalInteriorHollowSpaceProperty)
							.with(InteriorWallSurface.class, this::marshalInteriorWallSurface)
							.with(OpeningProperty.class, this::marshalOpeningProperty)
							.with(OuterCeilingSurface.class, this::marshalOuterCeilingSurface)
							.with(OuterFloorSurface.class, this::marshalOuterFloorSurface)
							.with(RoofSurface.class, this::marshalRoofSurface)
							.with(HollowSpace.class, this::marshalHollowSpace)
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

	public void marshalAbstractTunnel(AbstractTunnel src, AbstractTunnelType dest) {
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

		if (src.isSetOuterTunnelInstallation()) {
			for (TunnelInstallationProperty tunnelInstallationProperty : src.getOuterTunnelInstallation())
				dest.getOuterTunnelInstallation().add(marshalTunnelInstallationProperty(tunnelInstallationProperty));
		}

		if (src.isSetInteriorTunnelInstallation()) {
			for (IntTunnelInstallationProperty intTunnelInstallationProperty : src.getInteriorTunnelInstallation())
				dest.getInteriorTunnelInstallation().add(marshalIntTunnelInstallationProperty(intTunnelInstallationProperty));
		}

		if (src.isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : src.getBoundedBySurface())
				dest.getBoundedBySurface().add(marshalBoundarySurfaceProperty(boundarySurfaceProperty));
		}

		if (src.isSetConsistsOfTunnelPart()) {
			for (TunnelPartProperty tunnelPartProperty : src.getConsistsOfTunnelPart())
				dest.getConsistsOfTunnelPart().add(marshalTunnelPartProperty(tunnelPartProperty));
		}

		if (src.isSetInteriorHollowSpace()) {
			for (InteriorHollowSpaceProperty interiorHollowSpaceProperty : src.getInteriorHollowSpace())
				dest.getInteriorHollowSpace().add(marshalInteriorHollowSpaceProperty(interiorHollowSpaceProperty));
		}

		if (src.isSetGenericApplicationPropertyOfAbstractTunnel()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfAbstractTunnel()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfAbstractTunnel().add(jaxbElement);
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
		BoundarySurfacePropertyType dest = tun.createBoundarySurfacePropertyType();

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
		CeilingSurfaceType dest = tun.createCeilingSurfaceType();
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
		ClosureSurfaceType dest = tun.createClosureSurfaceType();
		marshalClosureSurface(src, dest);

		return dest;
	}

	public void marshalDoor(Door src, DoorType dest) {
		marshalAbstractOpening(src, dest);

		if (src.isSetGenericApplicationPropertyOfDoor()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfDoor()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfDoor().add(jaxbElement);
			}
		}
	}

	public DoorType marshalDoor(Door src) {
		DoorType dest = tun.createDoorType();
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
		FloorSurfaceType dest = tun.createFloorSurfaceType();
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
		GroundSurfaceType dest = tun.createGroundSurfaceType();
		marshalGroundSurface(src, dest);

		return dest;
	}

	public void marshalHollowSpace(HollowSpace src, HollowSpaceType dest) {
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

		if (src.isSetHollowSpaceInstallation()) {
			for (IntTunnelInstallationProperty intTunnelInstallationProperty : src.getHollowSpaceInstallation())
				dest.getHollowSpaceInstallation().add(marshalIntTunnelInstallationProperty(intTunnelInstallationProperty));
		}	

		if (src.isSetGenericApplicationPropertyOfHollowSpace()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfHollowSpace()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfHollowSpace().add(jaxbElement);
			}
		}
	}

	public HollowSpaceType marshalHollowSpace(HollowSpace src) {
		HollowSpaceType dest = tun.createHollowSpaceType();
		marshalHollowSpace(src, dest);

		return dest;
	}

	@SuppressWarnings("unchecked")
	public InteriorFurniturePropertyType marshalInteriorFurnitureProperty(InteriorFurnitureProperty src) {
		InteriorFurniturePropertyType dest = tun.createInteriorFurniturePropertyType();

		if (src.isSetTunnelFurniture()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getTunnelFurniture());
			if (elem != null && elem.getValue() instanceof TunnelFurnitureType)
				dest.set_CityObject((JAXBElement<? extends TunnelFurnitureType>)elem);
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
	public InteriorHollowSpacePropertyType marshalInteriorHollowSpaceProperty(InteriorHollowSpaceProperty src) {
		InteriorHollowSpacePropertyType dest = tun.createInteriorHollowSpacePropertyType();

		if (src.isSetHollowSpace()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getHollowSpace());
			if (elem != null && elem.getValue() instanceof HollowSpaceType)
				dest.set_CityObject((JAXBElement<? extends HollowSpaceType>)elem);
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
		InteriorWallSurfaceType dest = tun.createInteriorWallSurfaceType();
		marshalInteriorWallSurface(src, dest);

		return dest;
	}

	public void marshalIntTunnelInstallation(IntTunnelInstallation src, IntTunnelInstallationType dest) {
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

		if (src.isSetGenericApplicationPropertyOfIntTunnelInstallation()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfIntTunnelInstallation()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfIntTunnelInstallation().add(jaxbElement);
			}
		}
	}

	public IntTunnelInstallationType marshalIntTunnelInstallation(IntTunnelInstallation src) {
		IntTunnelInstallationType dest = tun.createIntTunnelInstallationType();
		marshalIntTunnelInstallation(src, dest);

		return dest;
	}

	@SuppressWarnings("unchecked")
	public IntTunnelInstallationPropertyType marshalIntTunnelInstallationProperty(IntTunnelInstallationProperty src) {
		IntTunnelInstallationPropertyType dest = tun.createIntTunnelInstallationPropertyType();

		if (src.isSetIntTunnelInstallation()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getIntTunnelInstallation());
			if (elem != null && elem.getValue() instanceof IntTunnelInstallationType)
				dest.set_CityObject((JAXBElement<? extends IntTunnelInstallationType>)elem);
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
	public OpeningPropertyType marshalOpeningProperty(OpeningProperty src) {
		OpeningPropertyType dest = tun.createOpeningPropertyType();

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
		OuterCeilingSurfaceType dest = tun.createOuterCeilingSurfaceType();
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
		OuterFloorSurfaceType dest = tun.createOuterFloorSurfaceType();
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
		RoofSurfaceType dest = tun.createRoofSurfaceType();
		marshalRoofSurface(src, dest);

		return dest;
	}

	public void marshalTunnel(Tunnel src, TunnelType dest) {
		marshalAbstractTunnel(src, dest);

		if (src.isSetGenericApplicationPropertyOfTunnel()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfTunnel()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfTunnel().add(jaxbElement);
			}
		}
	}

	public TunnelType marshalTunnel(Tunnel src) {
		TunnelType dest = tun.createTunnelType();
		marshalTunnel(src, dest);

		return dest;
	}

	public void marshalTunnelFurniture(TunnelFurniture src, TunnelFurnitureType dest) {
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

		if (src.isSetGenericApplicationPropertyOfTunnelFurniture()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfTunnelFurniture()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfTunnelFurniture().add(jaxbElement);
			}
		}
	}

	public TunnelFurnitureType marshalTunnelFurniture(TunnelFurniture src) {
		TunnelFurnitureType dest = tun.createTunnelFurnitureType();
		marshalTunnelFurniture(src, dest);

		return dest;
	}

	public void marshalTunnelInstallation(TunnelInstallation src, TunnelInstallationType dest) {
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

		if (src.isSetGenericApplicationPropertyOfTunnelInstallation()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfTunnelInstallation()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfTunnelInstallation().add(jaxbElement);
			}
		}

	}

	public TunnelInstallationType marshalTunnelInstallation(TunnelInstallation src) {
		TunnelInstallationType dest = tun.createTunnelInstallationType();
		marshalTunnelInstallation(src, dest);

		return dest;
	}

	@SuppressWarnings("unchecked")
	public TunnelInstallationPropertyType marshalTunnelInstallationProperty(TunnelInstallationProperty src) {
		TunnelInstallationPropertyType dest = tun.createTunnelInstallationPropertyType();

		if (src.isSetTunnelInstallation()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getTunnelInstallation());
			if (elem != null && elem.getValue() instanceof TunnelInstallationType)
				dest.set_CityObject((JAXBElement<? extends TunnelInstallationType>)elem);
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

	public void marshalTunnelPart(TunnelPart src, TunnelPartType dest) {
		marshalAbstractTunnel(src, dest);

		if (src.isSetGenericApplicationPropertyOfTunnelPart()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfTunnelPart()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfTunnelPart().add(jaxbElement);
			}
		}
	}

	public TunnelPartType marshalTunnelPart(TunnelPart src) {
		TunnelPartType dest = tun.createTunnelPartType();
		marshalTunnelPart(src, dest);

		return dest;
	}

	@SuppressWarnings("unchecked")
	public TunnelPartPropertyType marshalTunnelPartProperty(TunnelPartProperty src) {
		TunnelPartPropertyType dest = tun.createTunnelPartPropertyType();

		if (src.isSetTunnelPart()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getTunnelPart());
			if (elem != null && elem.getValue() instanceof TunnelPartType)
				dest.set_AbstractTunnel((JAXBElement<? extends TunnelPartType>)elem);
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
		WallSurfaceType dest = tun.createWallSurfaceType();
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
		WindowType dest = tun.createWindowType();
		marshalWindow(src, dest);

		return dest;
	}

	private JAXBElement<?> createTunnel(Tunnel src) {
		return tun.createTunnel(marshalTunnel(src));
	}

	private JAXBElement<?> createTunnelFurniture(TunnelFurniture src) {
		return tun.createTunnelFurniture(marshalTunnelFurniture(src));
	}

	private JAXBElement<?> createTunnelInstallation(TunnelInstallation src) {
		return tun.createTunnelInstallation(marshalTunnelInstallation(src));
	}

	private JAXBElement<?> createTunnelPart(TunnelPart src) {
		return tun.createTunnelPart(marshalTunnelPart(src));
	}

	private JAXBElement<?> createCeilingSurface(CeilingSurface src) {
		return tun.createCeilingSurface(marshalCeilingSurface(src));
	}

	private JAXBElement<?> createClosureSurface(ClosureSurface src) {
		return tun.createClosureSurface(marshalClosureSurface(src));
	}

	private JAXBElement<?> createDoor(Door src) {
		return tun.createDoor(marshalDoor(src));
	}

	private JAXBElement<?> createFloorSurface(FloorSurface src) {
		return tun.createFloorSurface(marshalFloorSurface(src));
	}

	private JAXBElement<?> createGroundSurface(GroundSurface src) {
		return tun.createGroundSurface(marshalGroundSurface(src));
	}

	private JAXBElement<?> createIntTunnelInstallation(IntTunnelInstallation src) {
		return tun.createIntTunnelInstallation(marshalIntTunnelInstallation(src));
	}

	private JAXBElement<?> createInteriorWallSurface(InteriorWallSurface src) {
		return tun.createInteriorWallSurface(marshalInteriorWallSurface(src));
	}

	private JAXBElement<?> createOuterCeilingSurface(OuterCeilingSurface src) {
		return tun.createOuterCeilingSurface(marshalOuterCeilingSurface(src));
	}

	private JAXBElement<?> createOuterFloorSurface(OuterFloorSurface src) {
		return tun.createOuterFloorSurface(marshalOuterFloorSurface(src));
	}

	private JAXBElement<?> createRoofSurface(RoofSurface src) {
		return tun.createRoofSurface(marshalRoofSurface(src));
	}

	private JAXBElement<?> createHollowSpace(HollowSpace src) {
		return tun.createHollowSpace(marshalHollowSpace(src));
	}

	private JAXBElement<?> createWallSurface(WallSurface src) {
		return tun.createWallSurface(marshalWallSurface(src));
	}

	private JAXBElement<?> createWindow(Window src) {
		return tun.createWindow(marshalWindow(src));
	}

}
