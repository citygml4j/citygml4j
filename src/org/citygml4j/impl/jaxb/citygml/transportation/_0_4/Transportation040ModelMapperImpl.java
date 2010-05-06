package org.citygml4j.impl.jaxb.citygml.transportation._0_4;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.citygml.AbstractCityGMLModelMapperImpl;
import org.citygml4j.jaxb.citygml._0_4.AuxiliaryTrafficAreaType;
import org.citygml4j.jaxb.citygml._0_4.RailwayType;
import org.citygml4j.jaxb.citygml._0_4.RoadType;
import org.citygml4j.jaxb.citygml._0_4.SquareType;
import org.citygml4j.jaxb.citygml._0_4.TrackType;
import org.citygml4j.jaxb.citygml._0_4.TrafficAreaType;
import org.citygml4j.jaxb.citygml._0_4.TransportationComplexType;
import org.citygml4j.jaxb.citygml._0_4._TransportationObjectType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.Square;
import org.citygml4j.model.citygml.transportation.Track;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TransportationComplex;
import org.citygml4j.model.citygml.transportation.TransportationObject;

public class Transportation040ModelMapperImpl extends AbstractCityGMLModelMapperImpl {

	public TrafficArea toCityGML(TrafficAreaType trafficArea, QName name) {		
		if (trafficArea.getClass().equals(TrafficAreaType.class))
			return new TrafficAreaImpl(trafficArea);
		else
			return (TrafficArea)jaxb2ade(trafficArea, name, TrafficArea.class);
	}
	
	public AuxiliaryTrafficArea toCityGML(AuxiliaryTrafficAreaType auxiliaryTrafficArea, QName name) {		
		if (auxiliaryTrafficArea.getClass().equals(AuxiliaryTrafficAreaType.class))
			return new AuxiliaryTrafficAreaImpl(auxiliaryTrafficArea);
		else
			return (AuxiliaryTrafficArea)jaxb2ade(auxiliaryTrafficArea, name, AuxiliaryTrafficArea.class);
	}
	
	public Railway toCityGML(RailwayType railway, QName name) {		
		if (railway.getClass().equals(RailwayType.class))
			return new RailwayImpl(railway);
		else
			return (Railway)jaxb2ade(railway, name, Railway.class);
	}
	
	public Road toCityGML(RoadType road, QName name) {		
		if (road.getClass().equals(RoadType.class))
			return new RoadImpl(road);
		else
			return (Road)jaxb2ade(road, name, Road.class);
	}
	
	public Square toCityGML(SquareType square, QName name) {		
		if (square.getClass().equals(SquareType.class))
			return new SquareImpl(square);
		else
			return (Square)jaxb2ade(square, name, Square.class);
	}
	
	public Track toCityGML(TrackType track, QName name) {		
		if (track.getClass().equals(TrackType.class))
			return new TrackImpl(track);
		else
			return (Track)jaxb2ade(track, name, Track.class);
	}
	
	public TransportationComplex toCityGML(TransportationComplexType transportationComplex, QName name) {		
		if (transportationComplex.getClass().equals(TransportationComplexType.class))
			return new TransportationComplexImpl(transportationComplex);
		else
			return (TransportationComplex)jaxb2ade(transportationComplex, name, TransportationComplex.class);
	}
	
	public TransportationObject toCityGML(_TransportationObjectType transportationObject, QName name) {		
		// we are just checking ADEs
		return (TransportationObject)jaxb2ade(transportationObject, name, TransportationObject.class);
	}
	
	public JAXBElement<? extends TrafficAreaType> toJAXB(TrafficArea trafficArea) {
		if (!(trafficArea instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createTrafficArea(((TrafficAreaImpl)trafficArea).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)trafficArea, TrafficAreaType.class);
	}
	
	public JAXBElement<? extends AuxiliaryTrafficAreaType> toJAXB(AuxiliaryTrafficArea auxiliaryTrafficArea) {
		if (!(auxiliaryTrafficArea instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createAuxiliaryTrafficArea(((AuxiliaryTrafficAreaImpl)auxiliaryTrafficArea).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)auxiliaryTrafficArea, AuxiliaryTrafficAreaType.class);
	}
	
	public JAXBElement<? extends RailwayType> toJAXB(Railway railway) {
		if (!(railway instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createRailway(((RailwayImpl)railway).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)railway, RailwayType.class);
	}
	
	public JAXBElement<? extends RoadType> toJAXB(Road road) {
		if (!(road instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createRoad(((RoadImpl)road).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)road, RoadType.class);
	}
	
	public JAXBElement<? extends SquareType> toJAXB(Square square) {
		if (!(square instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createSquare(((SquareImpl)square).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)square, SquareType.class);
	}
	
	public JAXBElement<? extends TrackType> toJAXB(Track track) {
		if (!(track instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createTrack(((TrackImpl)track).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)track, TrackType.class);
	}
	
	public JAXBElement<? extends TransportationComplexType> toJAXB(TransportationComplex transportationComplex) {
		if (!(transportationComplex instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createTransportationComplex(((TransportationComplexImpl)transportationComplex).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)transportationComplex, TransportationComplexType.class);
	}
	
	public JAXBElement<? extends _TransportationObjectType> toJAXB(TransportationObject transportationObject) {
		// we are just checking ADEs
		if (transportationObject instanceof ADEComponent)
			return ade2jaxb((ADEComponent)transportationObject, _TransportationObjectType.class);
		
		return null;
	}
	
	public CityGMLBase toCityGML(JAXBElement<?> jaxbElem) {
		CityGMLBase cityGMLBase = null;
		
		if (jaxbElem.getValue() != null) {
			Object value = jaxbElem.getValue();
			QName name = jaxbElem.getName();
			
			if (value instanceof TrafficAreaType)
				cityGMLBase = toCityGML((TrafficAreaType)value, name);
			else if (value instanceof AuxiliaryTrafficAreaType)
				cityGMLBase = toCityGML((AuxiliaryTrafficAreaType)value, name);
			else if (value instanceof RailwayType)
				cityGMLBase = toCityGML((RailwayType)value, name);
			else if (value instanceof RoadType)
				cityGMLBase = toCityGML((RoadType)value, name);	
			else if (value instanceof SquareType)
				cityGMLBase = toCityGML((SquareType)value, name);	
			else if (value instanceof TrackType)
				cityGMLBase = toCityGML((TrackType)value, name);	
			else if (value instanceof TransportationComplexType)
				cityGMLBase = toCityGML((TransportationComplexType)value, name);	
			else if (value instanceof _TransportationObjectType)
				cityGMLBase = toCityGML((_TransportationObjectType)value, name);
		}

		return cityGMLBase;
	}

	public JAXBElement<?> toJAXB(CityGMLBase cityGML) {
		JAXBElement<?> jaxbElem = null;
		
		if (cityGML instanceof TrafficArea)
			jaxbElem = toJAXB((TrafficArea)cityGML);
		else if (cityGML instanceof AuxiliaryTrafficArea)
			jaxbElem = toJAXB((AuxiliaryTrafficArea)cityGML);
		else if (cityGML instanceof Railway)
			jaxbElem = toJAXB((Railway)cityGML);
		else if (cityGML instanceof Road)
			jaxbElem = toJAXB((Road)cityGML);	
		else if (cityGML instanceof Square)
			jaxbElem = toJAXB((Square)cityGML);
		else if (cityGML instanceof Track)
			jaxbElem = toJAXB((Track)cityGML);
		else if (cityGML instanceof TransportationComplex)
			jaxbElem = toJAXB((TransportationComplex)cityGML);
		else if (cityGML instanceof TransportationObject)
			jaxbElem = toJAXB((TransportationObject)cityGML);
		
		return jaxbElem;
	}

}
