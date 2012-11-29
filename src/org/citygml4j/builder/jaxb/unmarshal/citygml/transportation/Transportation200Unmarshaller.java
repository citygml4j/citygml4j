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
 * $Id: Transportation200Unmarshaller.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.builder.jaxb.unmarshal.citygml.transportation;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.jaxb.citygml.tran._2.AbstractTransportationObjectType;
import org.citygml4j.jaxb.citygml.tran._2.AuxiliaryTrafficAreaPropertyType;
import org.citygml4j.jaxb.citygml.tran._2.AuxiliaryTrafficAreaType;
import org.citygml4j.jaxb.citygml.tran._2.RailwayType;
import org.citygml4j.jaxb.citygml.tran._2.RoadType;
import org.citygml4j.jaxb.citygml.tran._2.SquareType;
import org.citygml4j.jaxb.citygml.tran._2.TrackType;
import org.citygml4j.jaxb.citygml.tran._2.TrafficAreaPropertyType;
import org.citygml4j.jaxb.citygml.tran._2.TrafficAreaType;
import org.citygml4j.jaxb.citygml.tran._2.TransportationComplexType;
import org.citygml4j.jaxb.gml._3_1_1.CodeType;
import org.citygml4j.jaxb.gml._3_1_1.GeometricComplexPropertyType;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.transportation.AbstractTransportationObject;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.Square;
import org.citygml4j.model.citygml.transportation.Track;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.TransportationComplex;
import org.citygml4j.model.gml.xlink.XLinkActuate;
import org.citygml4j.model.gml.xlink.XLinkShow;
import org.citygml4j.model.gml.xlink.XLinkType;
import org.citygml4j.model.module.citygml.TransportationModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

public class Transportation200Unmarshaller {
	private final TransportationModule module = TransportationModule.v2_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;

	public Transportation200Unmarshaller(CityGMLUnmarshaller citygml) {
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

		if (src instanceof AuxiliaryTrafficAreaType)
			dest = unmarshalAuxiliaryTrafficArea((AuxiliaryTrafficAreaType)src);
		else if (src instanceof AuxiliaryTrafficAreaPropertyType)
			dest = unmarshalAuxiliaryTrafficAreaProperty((AuxiliaryTrafficAreaPropertyType)src);
		else if (src instanceof RailwayType)
			dest = unmarshalRailway((RailwayType)src);
		else if (src instanceof RoadType)
			dest = unmarshalRoad((RoadType)src);
		else if (src instanceof SquareType)
			dest = unmarshalSquare((SquareType)src);
		else if (src instanceof TrackType)
			dest = unmarshalTrack((TrackType)src);		
		else if (src instanceof TrafficAreaType)
			dest = unmarshalTrafficArea((TrafficAreaType)src);
		else if (src instanceof TrafficAreaPropertyType)
			dest = unmarshalTrafficAreaProperty((TrafficAreaPropertyType)src);
		else if (src instanceof TransportationComplexType)
			dest = unmarshalTransportationComplex((TransportationComplexType)src);
		
		return dest;
	}
	
	public void unmarshalAbstractTransportationObject(AbstractTransportationObjectType src, AbstractTransportationObject dest) throws MissingADESchemaException {
		citygml.getCore200Unmarshaller().unmarshalAbstractCityObject(src, dest);
	}
	
	public void unmarshalAuxiliaryTrafficArea(AuxiliaryTrafficAreaType src, AuxiliaryTrafficArea dest) throws MissingADESchemaException {
		unmarshalAbstractTransportationObject(src, dest);
		
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
		
		if (src.isSetSurfaceMaterial())
			dest.setSurfaceMaterial(jaxb.getGMLUnmarshaller().unmarshalCode(src.getSurfaceMaterial()));
		
		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod2MultiSurface()));
		
		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod3MultiSurface()));
		
		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod4MultiSurface()));	
	}
	
	public AuxiliaryTrafficArea unmarshalAuxiliaryTrafficArea(AuxiliaryTrafficAreaType src) throws MissingADESchemaException {
		AuxiliaryTrafficArea dest =  new AuxiliaryTrafficArea(module);
		unmarshalAuxiliaryTrafficArea(src, dest);

		return dest;
	}

	public AuxiliaryTrafficAreaProperty unmarshalAuxiliaryTrafficAreaProperty(AuxiliaryTrafficAreaPropertyType src) throws MissingADESchemaException {
		AuxiliaryTrafficAreaProperty dest = new AuxiliaryTrafficAreaProperty(module);

		if (src.isSetAuxiliaryTrafficArea())
			dest.setAuxiliaryTrafficArea(unmarshalAuxiliaryTrafficArea(src.getAuxiliaryTrafficArea()));
		
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
	
	public void unmarshalRailway(RailwayType src, Railway dest) throws MissingADESchemaException {
		unmarshalTransportationComplex(src, dest);
	}
	
	public Railway unmarshalRailway(RailwayType src) throws MissingADESchemaException {
		Railway dest = new Railway(module);
		unmarshalRailway(src, dest);

		return dest;
	}
	
	public void unmarshalRoad(RoadType src, Road dest) throws MissingADESchemaException {
		unmarshalTransportationComplex(src, dest);
	}
	
	public Road unmarshalRoad(RoadType src) throws MissingADESchemaException {
		Road dest = new Road(module);
		unmarshalRoad(src, dest);

		return dest;
	}
	
	public void unmarshalSquare(SquareType src, Square dest) throws MissingADESchemaException {
		unmarshalTransportationComplex(src, dest);
	}
	
	public Square unmarshalSquare(SquareType src) throws MissingADESchemaException {
		Square dest = new Square(module);
		unmarshalSquare(src, dest);

		return dest;
	}
	
	public void unmarshalTrack(TrackType src, Track dest) throws MissingADESchemaException {
		unmarshalTransportationComplex(src, dest);
	}
	
	public Track unmarshalTrack(TrackType src) throws MissingADESchemaException {
		Track dest = new Track(module);
		unmarshalTrack(src, dest);

		return dest;
	}
	
	public void unmarshalTrafficArea(TrafficAreaType src, TrafficArea dest) throws MissingADESchemaException {
		unmarshalAbstractTransportationObject(src, dest);
		
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
		
		if (src.isSetSurfaceMaterial())
			dest.setSurfaceMaterial(jaxb.getGMLUnmarshaller().unmarshalCode(src.getSurfaceMaterial()));
		
		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod2MultiSurface()));
		
		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod3MultiSurface()));
		
		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod4MultiSurface()));	
	}
	
	public TrafficArea unmarshalTrafficArea(TrafficAreaType src) throws MissingADESchemaException {
		TrafficArea dest = new TrafficArea(module);
		unmarshalTrafficArea(src, dest);

		return dest;
	}

	public TrafficAreaProperty unmarshalTrafficAreaProperty(TrafficAreaPropertyType src) throws MissingADESchemaException {
		TrafficAreaProperty dest = new TrafficAreaProperty(module);

		if (src.isSetTrafficArea())
			dest.setTrafficArea(unmarshalTrafficArea(src.getTrafficArea()));
		
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
	
	public void unmarshalTransportationComplex(TransportationComplexType src, TransportationComplex dest) throws MissingADESchemaException {
		unmarshalAbstractTransportationObject(src, dest);
		
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
		
		if (src.isSetTrafficArea()) {
			for (TrafficAreaPropertyType trafficAreaProperty : src.getTrafficArea())
				dest.addTrafficArea(unmarshalTrafficAreaProperty(trafficAreaProperty));
		}
		
		if (src.isSetAuxiliaryTrafficArea()) {
			for (AuxiliaryTrafficAreaPropertyType auxiliaryTrafficAreaProperty : src.getAuxiliaryTrafficArea())
				dest.addAuxiliaryTrafficArea(unmarshalAuxiliaryTrafficAreaProperty(auxiliaryTrafficAreaProperty));
		}
		
		if (src.isSetLod0Network()) {
			for (GeometricComplexPropertyType geometricComplexProperty : src.getLod0Network())
				dest.addLod0Network(jaxb.getGMLUnmarshaller().unmarshalGeometricComplexProperty(geometricComplexProperty));
		}
		
		if (src.isSetLod1MultiSurface())
			dest.setLod1MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod1MultiSurface()));
		
		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod2MultiSurface()));
		
		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod3MultiSurface()));
		
		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod4MultiSurface()));
	}
	
	public TransportationComplex unmarshalTransportationComplex(TransportationComplexType src) throws MissingADESchemaException {
		TransportationComplex dest = new TransportationComplex(module);
		unmarshalTransportationComplex(src, dest);

		return dest;
	}
	
	public boolean assignGenericProperty(ADEComponent genericProperty, QName substitutionGroup, CityGML dest) {
		String name = substitutionGroup.getLocalPart();
		boolean success = true;
		
		if (dest instanceof AbstractTransportationObject && name.equals("_GenericApplicationPropertyOfTransportationObject"))
			((AbstractTransportationObject)dest).addGenericApplicationPropertyOfTransportationObject(genericProperty);
		else if (dest instanceof AuxiliaryTrafficArea && name.equals("_GenericApplicationPropertyOfAuxiliaryTrafficArea"))
			((AuxiliaryTrafficArea)dest).addGenericApplicationPropertyOfAuxiliaryTrafficArea(genericProperty);
		else if (dest instanceof TransportationComplex && name.equals("_GenericApplicationPropertyOfTransportationComplex"))
			((TransportationComplex)dest).addGenericApplicationPropertyOfTransportationComplex(genericProperty);
		else if (dest instanceof Railway && name.equals("_GenericApplicationPropertyOfRailway"))
			((Railway)dest).addGenericApplicationPropertyOfRailway(genericProperty);
		else if (dest instanceof Road && name.equals("_GenericApplicationPropertyOfRoad"))
			((Road)dest).addGenericApplicationPropertyOfRoad(genericProperty);
		else if (dest instanceof Square && name.equals("_GenericApplicationPropertyOfSquare"))
			((Square)dest).addGenericApplicationPropertyOfSquare(genericProperty);
		else if (dest instanceof Track && name.equals("_GenericApplicationPropertyOfTrack"))
			((Track)dest).addGenericApplicationPropertyOfTrack(genericProperty);
		else if (dest instanceof TrafficArea && name.equals("_GenericApplicationPropertyOfTrafficArea"))
			((TrafficArea)dest).addGenericApplicationPropertyOfTrafficArea(genericProperty);
		else 
			success = false;
		
		return success;
	}
	
}
