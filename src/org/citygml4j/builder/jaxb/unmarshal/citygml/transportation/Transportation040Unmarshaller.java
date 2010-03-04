package org.citygml4j.builder.jaxb.unmarshal.citygml.transportation;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.impl.citygml.transportation.AuxiliaryTrafficAreaImpl;
import org.citygml4j.impl.citygml.transportation.AuxiliaryTrafficAreaPropertyImpl;
import org.citygml4j.impl.citygml.transportation.RailwayImpl;
import org.citygml4j.impl.citygml.transportation.RoadImpl;
import org.citygml4j.impl.citygml.transportation.SquareImpl;
import org.citygml4j.impl.citygml.transportation.TrackImpl;
import org.citygml4j.impl.citygml.transportation.TrafficAreaImpl;
import org.citygml4j.impl.citygml.transportation.TrafficAreaPropertyImpl;
import org.citygml4j.impl.citygml.transportation.TransportationComplexImpl;
import org.citygml4j.jaxb.citygml._0_4.AuxiliaryTrafficAreaPropertyType;
import org.citygml4j.jaxb.citygml._0_4.AuxiliaryTrafficAreaType;
import org.citygml4j.jaxb.citygml._0_4.RailwayType;
import org.citygml4j.jaxb.citygml._0_4.RoadType;
import org.citygml4j.jaxb.citygml._0_4.SquareType;
import org.citygml4j.jaxb.citygml._0_4.TrackType;
import org.citygml4j.jaxb.citygml._0_4.TrafficAreaPropertyType;
import org.citygml4j.jaxb.citygml._0_4.TrafficAreaType;
import org.citygml4j.jaxb.citygml._0_4.TransportationComplexType;
import org.citygml4j.jaxb.citygml._0_4._TransportationObjectType;
import org.citygml4j.jaxb.gml._3_1_1.GeometricComplexPropertyType;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.Square;
import org.citygml4j.model.citygml.transportation.Track;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.TransportationComplex;
import org.citygml4j.model.citygml.transportation.TransportationObject;
import org.citygml4j.model.module.citygml.TransportationModule;

public class Transportation040Unmarshaller {
	private final TransportationModule module = TransportationModule.v0_4_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;

	public Transportation040Unmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBUnmarshaller();
	}

	public CityGML unmarshal(JAXBElement<?> src) {
		return unmarshal(src.getValue());
	}

	public CityGML unmarshal(Object src) {
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

	public void unmarshalTransportationObject(_TransportationObjectType src, TransportationObject dest) {
		citygml.getCore040Unmarshaller().unmarshalCityObject(src, dest);
	}

	public void unmarshalAuxiliaryTrafficArea(AuxiliaryTrafficAreaType src, AuxiliaryTrafficArea dest) {
		unmarshalTransportationObject(src, dest);

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetSurfaceMaterial())
			dest.setSurfaceMaterial(src.getSurfaceMaterial());

		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod2MultiSurface()));

		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod3MultiSurface()));

		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod4MultiSurface()));
	}

	public AuxiliaryTrafficArea unmarshalAuxiliaryTrafficArea(AuxiliaryTrafficAreaType src) {
		AuxiliaryTrafficArea dest =  new AuxiliaryTrafficAreaImpl(module);
		unmarshalAuxiliaryTrafficArea(src, dest);

		return dest;
	}

	public AuxiliaryTrafficAreaProperty unmarshalAuxiliaryTrafficAreaProperty(AuxiliaryTrafficAreaPropertyType src) {
		AuxiliaryTrafficAreaProperty dest = new AuxiliaryTrafficAreaPropertyImpl(module);
		jaxb.getGMLUnmarshaller().unmarshalAssociation(src, dest);

		if (src.isSet_Object()) {
			Object object = jaxb.unmarshal(src.get_Object());
			if (object instanceof AuxiliaryTrafficArea)
				dest.setObject((AuxiliaryTrafficArea)object);
		}

		return dest;
	}

	public void unmarshalRailway(RailwayType src, Railway dest) {
		unmarshalTransportationComplex(src, dest);
	}

	public Railway unmarshalRailway(RailwayType src) {
		Railway dest = new RailwayImpl(module);
		unmarshalRailway(src, dest);

		return dest;
	}

	public void unmarshalRoad(RoadType src, Road dest) {
		unmarshalTransportationComplex(src, dest);
	}

	public Road unmarshalRoad(RoadType src) {
		Road dest = new RoadImpl(module);
		unmarshalRoad(src, dest);

		return dest;
	}

	public void unmarshalSquare(SquareType src, Square dest) {
		unmarshalTransportationComplex(src, dest);
	}

	public Square unmarshalSquare(SquareType src) {
		Square dest = new SquareImpl(module);
		unmarshalSquare(src, dest);

		return dest;
	}

	public void unmarshalTrack(TrackType src, Track dest) {
		unmarshalTransportationComplex(src, dest);
	}

	public Track unmarshalTrack(TrackType src) {
		Track dest = new TrackImpl(module);
		unmarshalTrack(src, dest);

		return dest;
	}

	public void unmarshalTrafficArea(TrafficAreaType src, TrafficArea dest) {
		unmarshalTransportationObject(src, dest);

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetSurfaceMaterial())
			dest.setSurfaceMaterial(src.getSurfaceMaterial());

		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod2MultiSurface()));

		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod3MultiSurface()));

		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLUnmarshaller().unmarshalMultiSurfaceProperty(src.getLod4MultiSurface()));	
	}

	public TrafficArea unmarshalTrafficArea(TrafficAreaType src) {
		TrafficArea dest = new TrafficAreaImpl(module);
		unmarshalTrafficArea(src, dest);

		return dest;
	}

	public TrafficAreaProperty unmarshalTrafficAreaProperty(TrafficAreaPropertyType src) {
		TrafficAreaProperty dest = new TrafficAreaPropertyImpl(module);
		jaxb.getGMLUnmarshaller().unmarshalAssociation(src, dest);

		if (src.isSet_Object()) {
			Object object = jaxb.unmarshal(src.get_Object());
			if (object instanceof TrafficArea)
				dest.setObject((TrafficArea)object);
		}

		return dest;
	}

	public void unmarshalTransportationComplex(TransportationComplexType src, TransportationComplex dest) {
		unmarshalTransportationObject(src, dest);

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

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

	public TransportationComplex unmarshalTransportationComplex(TransportationComplexType src) {
		TransportationComplex dest = new TransportationComplexImpl(module);
		unmarshalTransportationComplex(src, dest);

		return dest;
	}
	
	public boolean assignGenericProperty(ADEComponent genericProperty, QName substitutionGroup, CityGML dest) {
		String name = substitutionGroup.getLocalPart();
		boolean success = true;
		
		if (dest instanceof TransportationObject && name.equals("_GenericApplicationPropertyOfTransportationObject"))
			((TransportationObject)dest).addGenericApplicationPropertyOfTransportationObject(genericProperty);
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
