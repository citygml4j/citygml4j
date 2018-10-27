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
package org.citygml4j.builder.jaxb.unmarshal.citygml.transportation;

import net.opengis.citygml.transportation._2.AbstractTransportationObjectType;
import net.opengis.citygml.transportation._2.AuxiliaryTrafficAreaPropertyType;
import net.opengis.citygml.transportation._2.AuxiliaryTrafficAreaType;
import net.opengis.citygml.transportation._2.RailwayType;
import net.opengis.citygml.transportation._2.RoadType;
import net.opengis.citygml.transportation._2.SquareType;
import net.opengis.citygml.transportation._2.TrackType;
import net.opengis.citygml.transportation._2.TrafficAreaPropertyType;
import net.opengis.citygml.transportation._2.TrafficAreaType;
import net.opengis.citygml.transportation._2.TransportationComplexType;
import net.opengis.gml.CodeType;
import net.opengis.gml.GeometricComplexPropertyType;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
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
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.xlink.XLinkActuate;
import org.citygml4j.model.gml.xlink.XLinkShow;
import org.citygml4j.model.gml.xlink.XLinkType;
import org.citygml4j.model.module.citygml.TransportationModule;
import org.citygml4j.util.mapper.CheckedTypeMapper;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.concurrent.locks.ReentrantLock;

public class Transportation200Unmarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final TransportationModule module = TransportationModule.v2_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;
	private CheckedTypeMapper<CityGML> typeMapper;

	public Transportation200Unmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBUnmarshaller();
	}

	private CheckedTypeMapper<CityGML> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = CheckedTypeMapper.<CityGML>create()
							.with(AuxiliaryTrafficAreaType.class, this::unmarshalAuxiliaryTrafficArea)
							.with(AuxiliaryTrafficAreaPropertyType.class, this::unmarshalAuxiliaryTrafficAreaProperty)
							.with(RailwayType.class, this::unmarshalRailway)
							.with(RoadType.class, this::unmarshalRoad)
							.with(SquareType.class, this::unmarshalSquare)
							.with(TrackType.class, this::unmarshalTrack)
							.with(TrafficAreaType.class, this::unmarshalTrafficArea)
							.with(TrafficAreaPropertyType.class, this::unmarshalTrafficAreaProperty)
							.with(TransportationComplexType.class, this::unmarshalTransportationComplex)
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

	public void unmarshalAbstractTransportationObject(AbstractTransportationObjectType src, AbstractTransportationObject dest) throws MissingADESchemaException {
		citygml.getCore200Unmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSet_GenericApplicationPropertyOfTransportationObject()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfTransportationObject()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfTransportationObject(ade);
			}
		}
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

		if (src.isSet_GenericApplicationPropertyOfAuxiliaryTrafficArea()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfAuxiliaryTrafficArea()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfAuxiliaryTrafficArea(ade);
			}
		}
	}

	public AuxiliaryTrafficArea unmarshalAuxiliaryTrafficArea(AuxiliaryTrafficAreaType src) throws MissingADESchemaException {
		AuxiliaryTrafficArea dest =  new AuxiliaryTrafficArea(module);
		unmarshalAuxiliaryTrafficArea(src, dest);

		return dest;
	}

	public AuxiliaryTrafficAreaProperty unmarshalAuxiliaryTrafficAreaProperty(AuxiliaryTrafficAreaPropertyType src) throws MissingADESchemaException {
		AuxiliaryTrafficAreaProperty dest = new AuxiliaryTrafficAreaProperty(module);

		if (src.isSet_CityObject()) {
			ModelObject object = jaxb.unmarshal(src.get_CityObject());
			if (object instanceof AuxiliaryTrafficArea)
				dest.setAuxiliaryTrafficArea((AuxiliaryTrafficArea)object);
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

	public void unmarshalRailway(RailwayType src, Railway dest) throws MissingADESchemaException {
		unmarshalTransportationComplex(src, dest);

		if (src.isSet_GenericApplicationPropertyOfRailway()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfRailway()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfRailway(ade);
			}
		}
	}

	public Railway unmarshalRailway(RailwayType src) throws MissingADESchemaException {
		Railway dest = new Railway(module);
		unmarshalRailway(src, dest);

		return dest;
	}

	public void unmarshalRoad(RoadType src, Road dest) throws MissingADESchemaException {
		unmarshalTransportationComplex(src, dest);

		if (src.isSet_GenericApplicationPropertyOfRoad()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfRoad()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfRoad(ade);
			}
		}
	}

	public Road unmarshalRoad(RoadType src) throws MissingADESchemaException {
		Road dest = new Road(module);
		unmarshalRoad(src, dest);

		return dest;
	}

	public void unmarshalSquare(SquareType src, Square dest) throws MissingADESchemaException {
		unmarshalTransportationComplex(src, dest);

		if (src.isSet_GenericApplicationPropertyOfSquare()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfSquare()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfSquare(ade);
			}
		}
	}

	public Square unmarshalSquare(SquareType src) throws MissingADESchemaException {
		Square dest = new Square(module);
		unmarshalSquare(src, dest);

		return dest;
	}

	public void unmarshalTrack(TrackType src, Track dest) throws MissingADESchemaException {
		unmarshalTransportationComplex(src, dest);

		if (src.isSet_GenericApplicationPropertyOfTrack()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfTrack()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfTrack(ade);
			}
		}
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

		if (src.isSet_GenericApplicationPropertyOfTrafficArea()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfTrafficArea()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfTrafficArea(ade);
			}
		}
	}

	public TrafficArea unmarshalTrafficArea(TrafficAreaType src) throws MissingADESchemaException {
		TrafficArea dest = new TrafficArea(module);
		unmarshalTrafficArea(src, dest);

		return dest;
	}

	public TrafficAreaProperty unmarshalTrafficAreaProperty(TrafficAreaPropertyType src) throws MissingADESchemaException {
		TrafficAreaProperty dest = new TrafficAreaProperty(module);

		if (src.isSet_CityObject()) {
			ModelObject object = jaxb.unmarshal(src.get_CityObject());
			if (object instanceof TrafficArea)
				dest.setTrafficArea((TrafficArea)object);
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

		if (src.isSet_GenericApplicationPropertyOfTransportationComplex()) {
			for (JAXBElement<Object> elem : src.get_GenericApplicationPropertyOfTransportationComplex()) {
				ADEModelObject ade = jaxb.getADEUnmarshaller().unmarshal(elem);
				if (ade != null)
					dest.addGenericApplicationPropertyOfTransportationComplex(ade);
			}
		}
	}

	public TransportationComplex unmarshalTransportationComplex(TransportationComplexType src) throws MissingADESchemaException {
		TransportationComplex dest = new TransportationComplex(module);
		unmarshalTransportationComplex(src, dest);

		return dest;
	}

	public boolean assignGenericProperty(ADEGenericElement genericProperty, QName substitutionGroup, CityGML dest) {
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
