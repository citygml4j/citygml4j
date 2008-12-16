package org.citygml4j.impl.jaxb.citygml.transportation._0_4;

import org.citygml4j.impl.jaxb.citygml.AbstractTransportationFactoryImpl;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.Square;
import org.citygml4j.model.citygml.transportation.Track;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.TransportationComplex;

public class Transportation040FactoryImpl extends AbstractTransportationFactoryImpl {

	@Override
	public AuxiliaryTrafficArea createAuxiliaryTrafficArea() {
		return new AuxiliaryTrafficAreaImpl();
	}

	@Override
	public AuxiliaryTrafficAreaProperty createAuxiliaryTrafficAreaProperty() {
		return new AuxiliaryTrafficAreaPropertyImpl();
	}

	@Override
	public Railway createRailway() {
		return new RailwayImpl();
	}

	@Override
	public Road createRoad() {
		return new RoadImpl();
	}

	@Override
	public Square createSquare() {
		return new SquareImpl();
	}

	@Override
	public Track createTrack() {
		return new TrackImpl();
	}

	@Override
	public TrafficArea createTrafficArea() {
		return new TrafficAreaImpl();
	}

	@Override
	public TrafficAreaProperty createTrafficAreaProperty() {
		return new TrafficAreaPropertyImpl();
	}

	@Override
	public TransportationComplex createTransportationComplex() {
		return new TransportationComplexImpl();
	}

}
