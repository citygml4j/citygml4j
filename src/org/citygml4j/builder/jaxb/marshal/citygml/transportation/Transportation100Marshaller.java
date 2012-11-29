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
package org.citygml4j.builder.jaxb.marshal.citygml.transportation;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.jaxb.citygml.tran._1.AbstractTransportationObjectType;
import org.citygml4j.jaxb.citygml.tran._1.AuxiliaryTrafficAreaPropertyType;
import org.citygml4j.jaxb.citygml.tran._1.AuxiliaryTrafficAreaType;
import org.citygml4j.jaxb.citygml.tran._1.ObjectFactory;
import org.citygml4j.jaxb.citygml.tran._1.RailwayType;
import org.citygml4j.jaxb.citygml.tran._1.RoadType;
import org.citygml4j.jaxb.citygml.tran._1.SquareType;
import org.citygml4j.jaxb.citygml.tran._1.TrackType;
import org.citygml4j.jaxb.citygml.tran._1.TrafficAreaPropertyType;
import org.citygml4j.jaxb.citygml.tran._1.TrafficAreaType;
import org.citygml4j.jaxb.citygml.tran._1.TransportationComplexType;
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
import org.citygml4j.model.citygml.transportation.TransportationModuleComponent;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.complexes.GeometricComplexProperty;

public class Transportation100Marshaller {
	private final ObjectFactory tran = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;
	
	public Transportation100Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = null;
		
		if (src instanceof TransportationModuleComponent)
			src = marshal((TransportationModuleComponent)src);
	
		if (src instanceof AuxiliaryTrafficAreaType)
			dest = tran.createAuxiliaryTrafficArea((AuxiliaryTrafficAreaType)src);
		else if (src instanceof RailwayType)
			dest = tran.createRailway((RailwayType)src);
		else if (src instanceof RoadType)
			dest = tran.createRoad((RoadType)src);
		else if (src instanceof SquareType)
			dest = tran.createSquare((SquareType)src);
		else if (src instanceof TrackType)
			dest = tran.createTrack((TrackType)src);		
		else if (src instanceof TrafficAreaType)
			dest = tran.createTrafficArea((TrafficAreaType)src);
		else if (src instanceof TransportationComplexType)
			dest = tran.createTransportationComplex((TransportationComplexType)src);
		
		return dest;
	}
	
	public Object marshal(ModelObject src) {
		Object dest = null;
		
		if (src instanceof AuxiliaryTrafficArea)
			dest = marshalAuxiliaryTrafficArea((AuxiliaryTrafficArea)src);
		else if (src instanceof AuxiliaryTrafficAreaProperty)
			dest = marshalAuxiliaryTrafficAreaProperty((AuxiliaryTrafficAreaProperty)src);
		else if (src instanceof Railway)
			dest = marshalRailway((Railway)src);
		else if (src instanceof Road)
			dest = marshalRoad((Road)src);
		else if (src instanceof Square)
			dest = marshalSquare((Square)src);
		else if (src instanceof Track)
			dest = marshalTrack((Track)src);
		else if (src instanceof TrafficArea)
			dest = marshalTrafficArea((TrafficArea)src);
		else if (src instanceof TrafficAreaProperty)
			dest = marshalTrafficAreaProperty((TrafficAreaProperty)src);
		else if (src instanceof TransportationComplex)
			dest = marshalTransportationComplex((TransportationComplex)src);
		
		return dest;
	}
	
	public void marshalAbstractTransportationObject(AbstractTransportationObject src, AbstractTransportationObjectType dest) {
		citygml.getCore100Marshaller().marshalAbstractCityObject(src, dest);
		
		if (src.isSetGenericApplicationPropertyOfTransportationObject()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfTransportationObject())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfTransportationObject().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public void marshalAuxiliaryTrafficArea(AuxiliaryTrafficArea src, AuxiliaryTrafficAreaType dest) {
		marshalAbstractTransportationObject(src, dest);
		
		if (src.isSetFunction()) {
			for (Code function : src.getFunction())
				dest.getFunction().add(function.getValue());
		}
		
		if (src.isSetSurfaceMaterial())
			dest.setSurfaceMaterial(src.getSurfaceMaterial().getValue());
		
		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod2MultiSurface()));
		
		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod3MultiSurface()));
		
		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod4MultiSurface()));
		
		if (src.isSetGenericApplicationPropertyOfAuxiliaryTrafficArea()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfAuxiliaryTrafficArea())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfAuxiliaryTrafficArea().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public AuxiliaryTrafficAreaType marshalAuxiliaryTrafficArea(AuxiliaryTrafficArea src) {
		AuxiliaryTrafficAreaType dest =  tran.createAuxiliaryTrafficAreaType();
		marshalAuxiliaryTrafficArea(src, dest);

		return dest;
	}
	
	public AuxiliaryTrafficAreaPropertyType marshalAuxiliaryTrafficAreaProperty(AuxiliaryTrafficAreaProperty src) {
		AuxiliaryTrafficAreaPropertyType dest = tran.createAuxiliaryTrafficAreaPropertyType();
		jaxb.getGMLMarshaller().marshalFeatureProperty(src, dest);

		if (src.isSetAuxiliaryTrafficArea()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getAuxiliaryTrafficArea());
			if (elem != null && elem.getValue() instanceof AuxiliaryTrafficAreaType)
				dest.set_Object((JAXBElement<?>)elem);
		}

		return dest;
	}
	
	public void marshalRailway(Railway src, RailwayType dest) {
		marshalTransportationComplex(src, dest);
		
		if (src.isSetGenericApplicationPropertyOfRailway()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfRailway())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfRailway().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public RailwayType marshalRailway(Railway src) {
		RailwayType dest = tran.createRailwayType();
		marshalRailway(src, dest);

		return dest;
	}
	
	public void marshalRoad(Road src, RoadType dest) {
		marshalTransportationComplex(src, dest);
		
		if (src.isSetGenericApplicationPropertyOfRoad()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfRoad())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfRoad().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public RoadType marshalRoad(Road src) {
		RoadType dest = tran.createRoadType();
		marshalRoad(src, dest);

		return dest;
	}
	
	public void marshalSquare(Square src, SquareType dest) {
		marshalTransportationComplex(src, dest);
		
		if (src.isSetGenericApplicationPropertyOfSquare()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfSquare())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfSquare().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public SquareType marshalSquare(Square src) {
		SquareType dest = tran.createSquareType();
		marshalSquare(src, dest);

		return dest;
	}
	
	public void marshalTrack(Track src, TrackType dest) {
		marshalTransportationComplex(src, dest);
		
		if (src.isSetGenericApplicationPropertyOfTrack()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfTrack())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfTrack().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public TrackType marshalTrack(Track src) {
		TrackType dest = tran.createTrackType();
		marshalTrack(src, dest);

		return dest;
	}	
	
	public void marshalTrafficArea(TrafficArea src, TrafficAreaType dest) {
		marshalAbstractTransportationObject(src, dest);
		
		if (src.isSetFunction()) {
			for (Code function : src.getFunction())
				dest.getFunction().add(function.getValue());
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage())
				dest.getUsage().add(usage.getValue());
		}
		
		if (src.isSetSurfaceMaterial())
			dest.setSurfaceMaterial(src.getSurfaceMaterial().getValue());
		
		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod2MultiSurface()));
		
		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod3MultiSurface()));
		
		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod4MultiSurface()));
		
		if (src.isSetGenericApplicationPropertyOfTrafficArea()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfTrafficArea())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfTrafficArea().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public TrafficAreaType marshalTrafficArea(TrafficArea src) {
		TrafficAreaType dest = tran.createTrafficAreaType();
		marshalTrafficArea(src, dest);

		return dest;
	}

	public TrafficAreaPropertyType marshalTrafficAreaProperty(TrafficAreaProperty src) {
		TrafficAreaPropertyType dest = tran.createTrafficAreaPropertyType();
		jaxb.getGMLMarshaller().marshalFeatureProperty(src, dest);

		if (src.isSetTrafficArea()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getTrafficArea());
			if (elem != null && elem.getValue() instanceof TrafficAreaType)
				dest.set_Object((JAXBElement<?>)elem);
		}

		return dest;
	}
	
	public void marshalTransportationComplex(TransportationComplex src, TransportationComplexType dest) {
		marshalAbstractTransportationObject(src, dest);
		
		if (src.isSetFunction()) {
			for (Code function : src.getFunction())
				dest.getFunction().add(function.getValue());
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage())
				dest.getUsage().add(usage.getValue());
		}
		
		if (src.isSetTrafficArea()) {
			for (TrafficAreaProperty trafficAreaProperty : src.getTrafficArea())
				dest.getTrafficArea().add(marshalTrafficAreaProperty(trafficAreaProperty));
		}
		
		if (src.isSetAuxiliaryTrafficArea()) {
			for (AuxiliaryTrafficAreaProperty auxiliaryTrafficAreaProperty : src.getAuxiliaryTrafficArea())
				dest.getAuxiliaryTrafficArea().add(marshalAuxiliaryTrafficAreaProperty(auxiliaryTrafficAreaProperty));
		}
		
		if (src.isSetLod0Network()) {
			for (GeometricComplexProperty geometricComplexProperty : src.getLod0Network())
				dest.getLod0Network().add(jaxb.getGMLMarshaller().marshalGeometricComplexProperty(geometricComplexProperty));
		}
		
		if (src.isSetLod1MultiSurface())
			dest.setLod1MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod1MultiSurface()));
		
		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod2MultiSurface()));
		
		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod3MultiSurface()));
		
		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod4MultiSurface()));
		
		if (src.isSetGenericApplicationPropertyOfTransportationComplex()) {
			for (ADEComponent adeComponent :src.getGenericApplicationPropertyOfTransportationComplex())
				if (adeComponent.isSetContent())
					dest.get_GenericApplicationPropertyOfTransportationComplex().add(citygml.ade2jaxbElement(adeComponent));
		}
	}
	
	public TransportationComplexType marshalTransportationComplex(TransportationComplex src) {
		TransportationComplexType dest = tran.createTransportationComplexType();
		marshalTransportationComplex(src, dest);

		return dest;
	}
	
}
