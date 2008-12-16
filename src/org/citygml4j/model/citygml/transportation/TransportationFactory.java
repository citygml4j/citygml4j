package org.citygml4j.model.citygml.transportation;

public interface TransportationFactory {
	public AuxiliaryTrafficArea createAuxiliaryTrafficArea();
	public AuxiliaryTrafficAreaProperty createAuxiliaryTrafficAreaProperty();
	public Railway createRailway();
	public Road createRoad();
	public Square createSquare();
	public Track createTrack();
	public TrafficArea createTrafficArea();
	public TrafficAreaProperty createTrafficAreaProperty();
	public TransportationComplex createTransportationComplex();
}
