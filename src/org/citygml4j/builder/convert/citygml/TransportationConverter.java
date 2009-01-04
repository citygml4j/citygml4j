package org.citygml4j.builder.convert.citygml;

import org.citygml4j.factory.CityGMLFactory;
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
import org.citygml4j.model.gml.GeometricComplexProperty;
import org.citygml4j.model.gml.MultiSurfaceProperty;

public class TransportationConverter {
	private CityGMLConvertBuilder builder;
	private CityGMLFactory citygml;

	protected TransportationConverter(CityGMLConvertBuilder builder) {
		this.builder = builder;
		citygml = new CityGMLFactory();
	}

	protected AuxiliaryTrafficArea convertAuxiliaryTrafficArea(AuxiliaryTrafficArea src) {
		AuxiliaryTrafficArea dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof AuxiliaryTrafficArea)
				dest = (AuxiliaryTrafficArea)tmp;
		} else {
			dest = citygml.createAuxiliaryTrafficArea(builder.convertContext.tranModule);
			if (dest != null)
				convertAuxiliaryTrafficArea(src, dest);
		}

		return dest;
	}

	protected AuxiliaryTrafficAreaProperty convertAuxiliaryTrafficAreaProperty(AuxiliaryTrafficAreaProperty src) {
		AuxiliaryTrafficAreaProperty dest = citygml.createAuxiliaryTrafficAreaProperty(builder.convertContext.tranModule);
		if (dest != null) {
			builder.gml.convertAssociation(src, dest);

			if (src.isSetObject()) {
				AuxiliaryTrafficArea tmp = convertAuxiliaryTrafficArea(src.getObject());
				if (tmp != null)
					dest.setObject(tmp);
			}
		}

		return dest;
	}

	protected Railway convertRailway(Railway src) {
		Railway dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof Railway)
				dest = (Railway)tmp;
		} else {
			dest = citygml.createRailway(builder.convertContext.tranModule);
			if (dest != null)
				convertRailway(src, dest);
		}

		return dest;
	}

	protected Road convertRoad(Road src) {
		Road dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof Road)
				dest = (Road)tmp;
		} else {
			dest = citygml.createRoad(builder.convertContext.tranModule);
			if (dest != null)
				convertRoad(src, dest);
		}

		return dest;
	}

	protected Square convertSquare(Square src) {
		Square dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof Square)
				dest = (Square)tmp;
		} else {
			dest = citygml.createSquare(builder.convertContext.tranModule);
			if (dest != null)
				convertSquare(src, dest);
		}

		return dest;
	}

	protected Track convertTrack(Track src) {
		Track dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof Track)
				dest = (Track)tmp;
		} else {
			dest = citygml.createTrack(builder.convertContext.tranModule);
			if (dest != null)
				convertTrack(src, dest);
		}

		return dest;
	}

	protected TrafficArea convertTrafficArea(TrafficArea src) {
		TrafficArea dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof TrafficArea)
				dest = (TrafficArea)tmp;
		} else {
			dest = citygml.createTrafficArea(builder.convertContext.tranModule);
			if (dest != null)
				convertTrafficArea(src, dest);
		}

		return dest;
	}

	protected TrafficAreaProperty convertTrafficAreaProperty(TrafficAreaProperty src) {
		TrafficAreaProperty dest = citygml.createTrafficAreaProperty(builder.convertContext.tranModule);
		if (dest != null) {
			builder.gml.convertAssociation(src, dest);

			if (src.isSetObject()) {
				TrafficArea tmp = convertTrafficArea(src.getObject());
				if (tmp != null)
					dest.setObject(tmp);
			}
		}

		return dest;
	}

	protected TransportationComplex convertTransportationComplex(TransportationComplex src) {
		TransportationComplex dest = null;

		if (src instanceof ADEComponent) {
			ADEComponent tmp = builder.convertADEComponent((ADEComponent)src);
			if (tmp != null && tmp instanceof TransportationComplex)
				dest = (TransportationComplex)tmp;
		} else {
			dest = citygml.createTransportationComplex(builder.convertContext.tranModule);
			if (dest != null)
				convertTransportationComplex(src, dest);
		}

		return dest;
	}

	protected void convertAuxiliaryTrafficArea(AuxiliaryTrafficArea src, AuxiliaryTrafficArea dest) {
		convertTransportationObject(src, dest);

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetSurfaceMaterial())
			dest.setSurfaceMaterial(src.getSurfaceMaterial());

		if (src.isSetLod2MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod2MultiSurface());
			if (tmp != null)
				dest.setLod2MultiSurface(tmp);
		}

		if (src.isSetLod3MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod3MultiSurface());
			if (tmp != null)
				dest.setLod3MultiSurface(tmp);
		}

		if (src.isSetLod4MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod4MultiSurface());
			if (tmp != null)
				dest.setLod4MultiSurface(tmp);
		}

		if (src.isSetGenericApplicationPropertyOfAuxiliaryTrafficArea()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfAuxiliaryTrafficArea()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfAuxiliaryTrafficArea(tmp);
			}
		}
	}

	protected void convertRailway(Railway src, Railway dest) {
		convertTransportationComplex(src, dest);

		if (src.isSetGenericApplicationPropertyOfRailway()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfRailway()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfRailway(tmp);
			}
		}
	}

	protected void convertRoad(Road src, Road dest) {
		convertTransportationComplex(src, dest);

		if (src.isSetGenericApplicationPropertyOfRoad()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfRoad()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfRoad(tmp);
			}
		}
	}

	protected void convertSquare(Square src, Square dest) {
		convertTransportationComplex(src, dest);

		if (src.isSetGenericApplicationPropertyOfSquare()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfSquare()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfSquare(tmp);
			}
		}
	}

	protected void convertTrack(Track src, Track dest) {
		convertTransportationComplex(src, dest);

		if (src.isSetGenericApplicationPropertyOfTrack()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfTrack()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfTrack(tmp);
			}
		}
	}

	protected void convertTrafficArea(TrafficArea src, TrafficArea dest) {
		convertTransportationObject(src, dest);

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetSurfaceMaterial())
			dest.setSurfaceMaterial(src.getSurfaceMaterial());

		if (src.isSetLod2MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod2MultiSurface());
			if (tmp != null)
				dest.setLod2MultiSurface(tmp);
		}

		if (src.isSetLod3MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod3MultiSurface());
			if (tmp != null)
				dest.setLod3MultiSurface(tmp);
		}

		if (src.isSetLod4MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod4MultiSurface());
			if (tmp != null)
				dest.setLod4MultiSurface(tmp);
		}

		if (src.isSetGenericApplicationPropertyOfTrafficArea()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfTrafficArea()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfTrafficArea(tmp);
			}
		}
	}

	protected void convertTransportationComplex(TransportationComplex src, TransportationComplex dest) {
		convertTransportationObject(src, dest);

		if (src.isSetFunction())
			dest.setFunction(src.getFunction());

		if (src.isSetUsage())
			dest.setUsage(src.getUsage());

		if (src.isSetAuxiliaryTrafficArea()) {
			for (AuxiliaryTrafficAreaProperty aux : src.getAuxiliaryTrafficArea()) {
				AuxiliaryTrafficAreaProperty tmp = convertAuxiliaryTrafficAreaProperty(aux);
				if (tmp != null)
					dest.addAuxiliaryTrafficArea(tmp);
			}
		}

		if (src.isSetTrafficArea()) {
			for (TrafficAreaProperty traffic : src.getTrafficArea()) {
				TrafficAreaProperty tmp = convertTrafficAreaProperty(traffic);
				if (tmp != null)
					dest.addTrafficArea(tmp);
			}
		}

		if (src.isSetLod0Network()) {
			for (GeometricComplexProperty geometricComplex : src.getLod0Network()) {
				GeometricComplexProperty tmp = builder.gml.convertGeometricComplexProperty(geometricComplex);
				if (tmp != null)
					dest.addLod0Network(tmp);
			}
		}

		if (src.isSetLod1MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod1MultiSurface());
			if (tmp != null)
				dest.setLod1MultiSurface(tmp);
		}

		if (src.isSetLod2MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod2MultiSurface());
			if (tmp != null)
				dest.setLod2MultiSurface(tmp);
		}

		if (src.isSetLod3MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod3MultiSurface());
			if (tmp != null)
				dest.setLod3MultiSurface(tmp);
		}

		if (src.isSetLod4MultiSurface()) {
			MultiSurfaceProperty tmp = builder.gml.convertMultiSurfaceProperty(src.getLod4MultiSurface());
			if (tmp != null)
				dest.setLod4MultiSurface(tmp);
		}

		if (src.isSetGenericApplicationPropertyOfTransportationComplex()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfTransportationComplex()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfTransportationComplex(tmp);
			}
		}
	}

	protected void convertTransportationObject(TransportationObject src, TransportationObject dest) {
		builder.core.convertCityObject(src, dest);
		
		if (src.isSetGenericApplicationPropertyOfTransportationObject()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfTransportationObject()) {
				ADEComponent tmp = builder.ade.convertADEComponent(ade);
				if (tmp != null)
					dest.addGenericApplicationPropertyOfTransportationObject(tmp);
			}
		}
	}
}
