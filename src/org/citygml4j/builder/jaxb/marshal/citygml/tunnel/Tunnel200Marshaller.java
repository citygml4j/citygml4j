/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2016 Claus Nagel <claus.nagel@gmail.com>
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

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;

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
import org.citygml4j.model.citygml.tunnel.TunnelModuleComponent;
import org.citygml4j.model.citygml.tunnel.TunnelPart;
import org.citygml4j.model.citygml.tunnel.TunnelPartProperty;
import org.citygml4j.model.citygml.tunnel.WallSurface;
import org.citygml4j.model.citygml.tunnel.Window;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.w3._1999.xlink.ActuateType;
import org.w3._1999.xlink.ShowType;
import org.w3._1999.xlink.TypeType;

public class Tunnel200Marshaller {
	private final ObjectFactory tun = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;

	public Tunnel200Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = null;

		if (src instanceof TunnelModuleComponent)
			src = marshal((TunnelModuleComponent)src);

		if (src instanceof TunnelType)
			dest = tun.createTunnel((TunnelType)src);		
		else if (src instanceof TunnelFurnitureType)
			dest = tun.createTunnelFurniture((TunnelFurnitureType)src);
		else if (src instanceof TunnelInstallationType)
			dest = tun.createTunnelInstallation((TunnelInstallationType)src);
		else if (src instanceof TunnelPartType)
			dest = tun.createTunnelPart((TunnelPartType)src);
		else if (src instanceof CeilingSurfaceType)
			dest = tun.createCeilingSurface((CeilingSurfaceType)src);
		else if (src instanceof ClosureSurfaceType)
			dest = tun.createClosureSurface((ClosureSurfaceType)src);
		else if (src instanceof DoorType)
			dest = tun.createDoor((DoorType)src);
		else if (src instanceof FloorSurfaceType)
			dest = tun.createFloorSurface((FloorSurfaceType)src);
		else if (src instanceof GroundSurfaceType)
			dest = tun.createGroundSurface((GroundSurfaceType)src);
		else if (src instanceof IntTunnelInstallationType)
			dest = tun.createIntTunnelInstallation((IntTunnelInstallationType)src);
		else if (src instanceof InteriorWallSurfaceType)
			dest = tun.createInteriorWallSurface((InteriorWallSurfaceType)src);
		else if (src instanceof OuterCeilingSurfaceType)
			dest = tun.createOuterCeilingSurface((OuterCeilingSurfaceType)src);
		else if (src instanceof OuterFloorSurfaceType)
			dest = tun.createOuterFloorSurface((OuterFloorSurfaceType)src);
		else if (src instanceof RoofSurfaceType)
			dest = tun.createRoofSurface((RoofSurfaceType)src);
		else if (src instanceof HollowSpaceType)
			dest = tun.createHollowSpace((HollowSpaceType)src);
		else if (src instanceof WallSurfaceType)
			dest = tun.createWallSurface((WallSurfaceType)src);
		else if (src instanceof WindowType)
			dest = tun.createWindow((WindowType)src);

		return dest;
	}

	public Object marshal(ModelObject src) {
		Object dest = null;

		if (src instanceof BoundarySurfaceProperty)
			dest = marshalBoundarySurfaceProperty((BoundarySurfaceProperty)src);
		else if (src instanceof Tunnel)
			dest = marshalTunnel((Tunnel)src);
		else if (src instanceof TunnelFurniture)
			dest = marshalTunnelFurniture((TunnelFurniture)src);
		else if (src instanceof TunnelInstallation)
			dest = marshalTunnelInstallation((TunnelInstallation)src);
		else if (src instanceof TunnelInstallationProperty)
			dest = marshalTunnelInstallationProperty((TunnelInstallationProperty)src);
		else if (src instanceof TunnelPart)
			dest = marshalTunnelPart((TunnelPart)src);
		else if (src instanceof TunnelPartProperty)
			dest = marshalTunnelPartProperty((TunnelPartProperty)src);
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
		else if (src instanceof IntTunnelInstallation)
			dest = marshalIntTunnelInstallation((IntTunnelInstallation)src);
		else if (src instanceof IntTunnelInstallationProperty)
			dest = marshalIntTunnelInstallationProperty((IntTunnelInstallationProperty)src);
		else if (src instanceof InteriorFurnitureProperty)
			dest = marshalInteriorFurnitureProperty((InteriorFurnitureProperty)src);
		else if (src instanceof InteriorHollowSpaceProperty)
			dest = marshalInteriorHollowSpaceProperty((InteriorHollowSpaceProperty)src);
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
		else if (src instanceof HollowSpace)
			dest = marshalHollowSpace((HollowSpace)src);
		else if (src instanceof WallSurface)
			dest = marshalWallSurface((WallSurface)src);
		else if (src instanceof Window)
			dest = marshalWindow((Window)src);

		return dest;
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfAbstractTunnel())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfAbstractTunnel().add(citygml.ade2jaxbElement(adeComponent));
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
		BoundarySurfacePropertyType dest = tun.createBoundarySurfacePropertyType();

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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfCeilingSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfCeilingSurface().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfClosureSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfClosureSurface().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfDoor())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfDoor().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfFloorSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfFloorSurface().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfGroundSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfGroundSurface().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfHollowSpace())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfHollowSpace().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public HollowSpaceType marshalHollowSpace(HollowSpace src) {
		HollowSpaceType dest = tun.createHollowSpaceType();
		marshalHollowSpace(src, dest);

		return dest;
	}

	public InteriorFurniturePropertyType marshalInteriorFurnitureProperty(InteriorFurnitureProperty src) {
		InteriorFurniturePropertyType dest = tun.createInteriorFurniturePropertyType();

		if (src.isSetTunnelFurniture())
			dest.setTunnelFurniture(marshalTunnelFurniture(src.getTunnelFurniture()));
		
		if (src.isSetGenericADEComponent() && src.getGenericADEComponent().isSetContent())
			dest.set_ADEComponent(src.getGenericADEComponent().getContent());

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

	public InteriorHollowSpacePropertyType marshalInteriorHollowSpaceProperty(InteriorHollowSpaceProperty src) {
		InteriorHollowSpacePropertyType dest = tun.createInteriorHollowSpacePropertyType();

		if (src.isSetHollowSpace())
			dest.setHollowSpace(marshalHollowSpace(src.getHollowSpace()));
		
		if (src.isSetGenericADEComponent() && src.getGenericADEComponent().isSetContent())
			dest.set_ADEComponent(src.getGenericADEComponent().getContent());

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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfInteriorWallSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfInteriorWallSurface().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfIntTunnelInstallation())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfIntTunnelInstallation().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public IntTunnelInstallationType marshalIntTunnelInstallation(IntTunnelInstallation src) {
		IntTunnelInstallationType dest = tun.createIntTunnelInstallationType();
		marshalIntTunnelInstallation(src, dest);

		return dest;
	}

	public IntTunnelInstallationPropertyType marshalIntTunnelInstallationProperty(IntTunnelInstallationProperty src) {
		IntTunnelInstallationPropertyType dest = tun.createIntTunnelInstallationPropertyType();

		if (src.isSetIntTunnelInstallation())
			dest.setIntTunnelInstallation(marshalIntTunnelInstallation(src.getIntTunnelInstallation()));
		
		if (src.isSetGenericADEComponent() && src.getGenericADEComponent().isSetContent())
			dest.set_ADEComponent(src.getGenericADEComponent().getContent());

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
		
		if (src.isSetGenericADEComponent() && src.getGenericADEComponent().isSetContent())
			dest.set_ADEComponent(src.getGenericADEComponent().getContent());

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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfOuterCeilingSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfOuterCeilingSurface().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfOuterFloorSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfOuterFloorSurface().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfRoofSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfRoofSurface().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfTunnel())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfTunnel().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfTunnelFurniture())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfTunnelFurniture().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfTunnelInstallation())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfTunnelInstallation().add(citygml.ade2jaxbElement(adeComponent));
		}

	}

	public TunnelInstallationType marshalTunnelInstallation(TunnelInstallation src) {
		TunnelInstallationType dest = tun.createTunnelInstallationType();
		marshalTunnelInstallation(src, dest);

		return dest;
	}

	public TunnelInstallationPropertyType marshalTunnelInstallationProperty(TunnelInstallationProperty src) {
		TunnelInstallationPropertyType dest = tun.createTunnelInstallationPropertyType();

		if (src.isSetTunnelInstallation())
			dest.setTunnelInstallation(marshalTunnelInstallation(src.getTunnelInstallation()));
		
		if (src.isSetGenericADEComponent() && src.getGenericADEComponent().isSetContent())
			dest.set_ADEComponent(src.getGenericADEComponent().getContent());

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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfTunnelPart())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfTunnelPart().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public TunnelPartType marshalTunnelPart(TunnelPart src) {
		TunnelPartType dest = tun.createTunnelPartType();
		marshalTunnelPart(src, dest);

		return dest;
	}

	public TunnelPartPropertyType marshalTunnelPartProperty(TunnelPartProperty src) {
		TunnelPartPropertyType dest = tun.createTunnelPartPropertyType();

		if (src.isSetTunnelPart())
			dest.setTunnelPart(marshalTunnelPart(src.getTunnelPart()));
		
		if (src.isSetGenericADEComponent() && src.getGenericADEComponent().isSetContent())
			dest.set_ADEComponent(src.getGenericADEComponent().getContent());

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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfWallSurface())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfWallSurface().add(citygml.ade2jaxbElement(adeComponent));
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
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfWindow())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfWindow().add(citygml.ade2jaxbElement(adeComponent));
		}
	}

	public WindowType marshalWindow(Window src) {
		WindowType dest = tun.createWindowType();
		marshalWindow(src, dest);

		return dest;
	}

}
