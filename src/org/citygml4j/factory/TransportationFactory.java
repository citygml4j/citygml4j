/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
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
 */
package org.citygml4j.factory;

import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.Square;
import org.citygml4j.model.citygml.transportation.Track;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.TransportationComplex;

public class TransportationFactory {

	public TransportationFactory() {
		
	}

	public AuxiliaryTrafficArea createAuxiliaryTrafficArea() {
		return new AuxiliaryTrafficArea();
	}

	public AuxiliaryTrafficAreaProperty createAuxiliaryTrafficAreaProperty() {
		return new AuxiliaryTrafficAreaProperty();
	}
	
	public AuxiliaryTrafficAreaProperty createAuxiliaryTrafficAreaProperty(AuxiliaryTrafficArea auxiliaryTrafficArea) {
		AuxiliaryTrafficAreaProperty auxiliaryTrafficAreaProperty = new AuxiliaryTrafficAreaProperty();
		auxiliaryTrafficAreaProperty.setAuxiliaryTrafficArea(auxiliaryTrafficArea);
		return auxiliaryTrafficAreaProperty;
	}
	
	public AuxiliaryTrafficAreaProperty createAuxiliaryTrafficAreaProperty(String xlink) {
		AuxiliaryTrafficAreaProperty auxiliaryTrafficAreaProperty = new AuxiliaryTrafficAreaProperty();
		auxiliaryTrafficAreaProperty.setHref(xlink);
		return auxiliaryTrafficAreaProperty;
	}

	public Railway createRailway() {
		return new Railway();
	}

	public Road createRoad() {
		return new Road();
	}

	public Square createSquare() {
		return new Square();
	}

	public Track createTrack() {
		return new Track();
	}

	public TrafficArea createTrafficArea() {
		return new TrafficArea();
	}

	public TrafficAreaProperty createTrafficAreaProperty() {
		return new TrafficAreaProperty();
	}
	
	public TrafficAreaProperty createTrafficAreaProperty(TrafficArea trafficArea) {
		TrafficAreaProperty trafficAreaProperty = new TrafficAreaProperty();
		trafficAreaProperty.setTrafficArea(trafficArea);
		return trafficAreaProperty;
	}
	
	public TrafficAreaProperty createTrafficAreaProperty(String xlink) {
		TrafficAreaProperty trafficAreaProperty = new TrafficAreaProperty();
		trafficAreaProperty.setHref(xlink);
		return trafficAreaProperty;
	}

	public TransportationComplex createTransportationComplex() {
		return new TransportationComplex();
	}
	
}
