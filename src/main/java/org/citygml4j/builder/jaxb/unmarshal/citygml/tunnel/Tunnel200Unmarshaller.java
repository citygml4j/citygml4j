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
package org.citygml4j.builder.jaxb.unmarshal.citygml.tunnel;

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
import net.opengis.gml.CodeType;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
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
import org.citygml4j.model.gml.xlink.XLinkActuate;
import org.citygml4j.model.gml.xlink.XLinkShow;
import org.citygml4j.model.gml.xlink.XLinkType;
import org.citygml4j.model.module.citygml.TunnelModule;
import org.citygml4j.util.mapper.CheckedTypeMapper;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.concurrent.locks.ReentrantLock;

public class Tunnel200Unmarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final TunnelModule module = TunnelModule.v2_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;
	private CheckedTypeMapper<CityGML> typeMapper;

	public Tunnel200Unmarshaller(CityGMLUnmarshaller citygml) {
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
							.with(CeilingSurfaceType.class, this::unmarshalCeilingSurface)
							.with(ClosureSurfaceType.class, this::unmarshalClosureSurface)
							.with(DoorType.class, this::unmarshalDoor)
							.with(FloorSurfaceType.class, this::unmarshalFloorSurface)
							.with(GroundSurfaceType.class, this::unmarshalGroundSurface)
							.with(HollowSpaceType.class, this::unmarshalHollowSpace)
							.with(IntTunnelInstallationType.class, this::unmarshalIntTunnelInstallation)
							.with(IntTunnelInstallationPropertyType.class, this::unmarshalIntTunnelInstallationProperty)
							.with(InteriorFurniturePropertyType.class, this::unmarshalInteriorFurnitureProperty)
							.with(InteriorHollowSpacePropertyType.class, this::unmarshalInteriorHollowSpaceProperty)
							.with(InteriorWallSurfaceType.class, this::unmarshalInteriorWallSurface)
							.with(OpeningPropertyType.class, this::unmarshalOpeningProperty)
							.with(OuterCeilingSurfaceType.class, this::unmarshalOuterCeilingSurface)
							.with(OuterFloorSurfaceType.class, this::unmarshalOuterFloorSurface)
							.with(RoofSurfaceType.class, this::unmarshalRoofSurface)
							.with(TunnelType.class, this::unmarshalTunnel)
							.with(TunnelFurnitureType.class, this::unmarshalTunnelFurniture)
							.with(TunnelInstallationType.class, this::unmarshalTunnelInstallation)
							.with(TunnelInstallationPropertyType.class, this::unmarshalTunnelInstallationProperty)
							.with(TunnelPartType.class, this::unmarshalTunnelPart)
							.with(TunnelPartPropertyType.class, this::unmarshalTunnelPartProperty)
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

	public void unmarshalAbstractTunnel(AbstractTunnelType src, AbstractTunnel dest) throws MissingADESchemaException {
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

		if (src.isSetOuterTunnelInstallation()) {
			for (TunnelInstallationPropertyType tunnelInstallationProperty : src.getOuterTunnelInstallation())
				dest.addOuterTunnelInstallation(unmarshalTunnelInstallationProperty(tunnelInstallationProperty));
		}

		if (src.isSetInteriorTunnelInstallation()) {
			for (IntTunnelInstallationPropertyType intTunnelInstallationProperty : src.getInteriorTunnelInstallation())
				dest.addInteriorTunnelInstallation(unmarshalIntTunnelInstallationProperty(intTunnelInstallationProperty));
		}

		if (src.isSetBoundedBySurface()) {
			for (BoundarySurfacePropertyType boundarySurfaceProperty : src.getBoundedBySurface())
				dest.addBoundedBySurface(unmarshalBoundarySurfaceProperty(boundarySurfaceProperty));
		}

		if (src.isSetConsistsOfTunnelPart()) {
			for (TunnelPartPropertyType tunnelPartProperty : src.getConsistsOfTunnelPart())
				dest.addConsistsOfTunnelPart(unmarshalTunnelPartProperty(tunnelPartProperty));
		}

		if (src.isSetInteriorHollowSpace()) {
			for (InteriorHollowSpacePropertyType interiorHollowSpaceProperty : src.getInteriorHollowSpace())
				dest.addInteriorHollowSpace(unmarshalInteriorHollowSpaceProperty(interiorHollowSpaceProperty));
		}

		if (src.isSet_GenericApplicationPropertyOfAbstractTunnel()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfAbstractTunnel()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfAbstractTunnel(ade);
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

	public void unmarshalHollowSpace(HollowSpaceType src, HollowSpace dest) throws MissingADESchemaException {
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

		if (src.isSetHollowSpaceInstallation()) {
			for (IntTunnelInstallationPropertyType intTunnelInstallationProperty : src.getHollowSpaceInstallation())
				dest.addHollowSpaceInstallation(unmarshalIntTunnelInstallationProperty(intTunnelInstallationProperty));
		}

		if (src.isSet_GenericApplicationPropertyOfHollowSpace()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfHollowSpace()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfHollowSpace(ade);
			}
		}
	}

	public HollowSpace unmarshalHollowSpace(HollowSpaceType src) throws MissingADESchemaException {
		HollowSpace dest = new HollowSpace(module);
		unmarshalHollowSpace(src, dest);

		return dest;
	}

	public void unmarshalIntTunnelInstallation(IntTunnelInstallationType src, IntTunnelInstallation dest) throws MissingADESchemaException {
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

		if (src.isSet_GenericApplicationPropertyOfIntTunnelInstallation()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfIntTunnelInstallation()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfIntTunnelInstallation(ade);
			}
		}
	}

	public IntTunnelInstallation unmarshalIntTunnelInstallation(IntTunnelInstallationType src) throws MissingADESchemaException {
		IntTunnelInstallation dest = new IntTunnelInstallation(module);
		unmarshalIntTunnelInstallation(src, dest);

		return dest;
	}

	public IntTunnelInstallationProperty unmarshalIntTunnelInstallationProperty(IntTunnelInstallationPropertyType src) throws MissingADESchemaException {
		IntTunnelInstallationProperty dest = new IntTunnelInstallationProperty(module);

		if (src.isSet_CityObject()) {
			ModelObject object = jaxb.unmarshal(src.get_CityObject());
			if (object instanceof IntTunnelInstallation)
				dest.setIntTunnelInstallation((IntTunnelInstallation)object);
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
			if (object instanceof TunnelFurniture)
				dest.setTunnelFurniture((TunnelFurniture)object);
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

	public InteriorHollowSpaceProperty unmarshalInteriorHollowSpaceProperty(InteriorHollowSpacePropertyType src) throws MissingADESchemaException {
		InteriorHollowSpaceProperty dest = new InteriorHollowSpaceProperty(module);

		if (src.isSet_CityObject()) {
			ModelObject object = jaxb.unmarshal(src.get_CityObject());
			if (object instanceof HollowSpace)
				dest.setHollowSpace((HollowSpace)object);
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

	public void unmarshalTunnel(TunnelType src, Tunnel dest) throws MissingADESchemaException {
		unmarshalAbstractTunnel(src, dest);

		if (src.isSet_GenericApplicationPropertyOfTunnel()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfTunnel()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfTunnel(ade);
			}
		}
	}

	public Tunnel unmarshalTunnel(TunnelType src) throws MissingADESchemaException {
		Tunnel dest = new Tunnel(module);
		unmarshalTunnel(src, dest);

		return dest;
	}

	public void unmarshalTunnelFurniture(TunnelFurnitureType src, TunnelFurniture dest) throws MissingADESchemaException {
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

		if (src.isSet_GenericApplicationPropertyOfTunnelFurniture()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfTunnelFurniture()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfTunnelFurniture(ade);
			}
		}
	}

	public TunnelFurniture unmarshalTunnelFurniture(TunnelFurnitureType src) throws MissingADESchemaException {
		TunnelFurniture dest = new TunnelFurniture(module);
		unmarshalTunnelFurniture(src, dest);

		return dest;
	}

	public void unmarshalTunnelInstallation(TunnelInstallationType src, TunnelInstallation dest) throws MissingADESchemaException {
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

		if (src.isSet_GenericApplicationPropertyOfTunnelInstallation()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfTunnelInstallation()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfTunnelInstallation(ade);
			}
		}
	}

	public TunnelInstallation unmarshalTunnelInstallation(TunnelInstallationType src) throws MissingADESchemaException {
		TunnelInstallation dest = new TunnelInstallation(module);
		unmarshalTunnelInstallation(src, dest);

		return dest;
	}

	public TunnelInstallationProperty unmarshalTunnelInstallationProperty(TunnelInstallationPropertyType src) throws MissingADESchemaException {
		TunnelInstallationProperty dest = new TunnelInstallationProperty(module);

		if (src.isSet_CityObject()) {
			ModelObject object = jaxb.unmarshal(src.get_CityObject());
			if (object instanceof TunnelInstallation)
				dest.setTunnelInstallation((TunnelInstallation)object);
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

	public void unmarshalTunnelPart(TunnelPartType src, TunnelPart dest) throws MissingADESchemaException {
		unmarshalAbstractTunnel(src, dest);

		if (src.isSet_GenericApplicationPropertyOfTunnelPart()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfTunnelPart()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfTunnelPart(ade);
			}
		}
	}

	public TunnelPart unmarshalTunnelPart(TunnelPartType src) throws MissingADESchemaException {
		TunnelPart dest = new TunnelPart(module);
		unmarshalTunnelPart(src, dest);

		return dest;
	}

	public TunnelPartProperty unmarshalTunnelPartProperty(TunnelPartPropertyType src) throws MissingADESchemaException {
		TunnelPartProperty dest = new TunnelPartProperty(module);

		if (src.isSet_AbstractTunnel()) {
			ModelObject object = jaxb.unmarshal(src.get_AbstractTunnel());
			if (object instanceof TunnelPart)
				dest.setTunnelPart((TunnelPart)object);
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

		if (dest instanceof AbstractTunnel && name.equals("_GenericApplicationPropertyOfAbstractTunnel"))
			((AbstractTunnel)dest).addGenericApplicationPropertyOfAbstractTunnel(genericProperty);
		else if (dest instanceof Tunnel && name.equals("_GenericApplicationPropertyOfTunnel"))
			((Tunnel)dest).addGenericApplicationPropertyOfTunnel(genericProperty);
		else if (dest instanceof TunnelPart && name.equals("_GenericApplicationPropertyOfTunnelPart"))
			((TunnelPart)dest).addGenericApplicationPropertyOfTunnelPart(genericProperty);
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
		else if (dest instanceof TunnelFurniture && name.equals("_GenericApplicationPropertyOfTunnelFurniture"))
			((TunnelFurniture)dest).addGenericApplicationPropertyOfTunnelFurniture(genericProperty);
		else if (dest instanceof TunnelInstallation && name.equals("_GenericApplicationPropertyOfTunnelInstallation"))
			((TunnelInstallation)dest).addGenericApplicationPropertyOfTunnelInstallation(genericProperty);
		else if (dest instanceof IntTunnelInstallation && name.equals("_GenericApplicationPropertyOfIntTunnelInstallation"))
			((IntTunnelInstallation)dest).addGenericApplicationPropertyOfIntTunnelInstallation(genericProperty);
		else if (dest instanceof HollowSpace && name.equals("_GenericApplicationPropertyOfHollowSpace"))
			((HollowSpace)dest).addGenericApplicationPropertyOfHollowSpace(genericProperty);		
		else 
			success = false;

		return success;
	}

}
