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
package org.citygml4j.builder.jaxb.marshal.citygml.transportation;

import net.opengis.citygml.transportation._2.AbstractTransportationObjectType;
import net.opengis.citygml.transportation._2.AuxiliaryTrafficAreaPropertyType;
import net.opengis.citygml.transportation._2.AuxiliaryTrafficAreaType;
import net.opengis.citygml.transportation._2.ObjectFactory;
import net.opengis.citygml.transportation._2.RailwayType;
import net.opengis.citygml.transportation._2.RoadType;
import net.opengis.citygml.transportation._2.SquareType;
import net.opengis.citygml.transportation._2.TrackType;
import net.opengis.citygml.transportation._2.TrafficAreaPropertyType;
import net.opengis.citygml.transportation._2.TrafficAreaType;
import net.opengis.citygml.transportation._2.TransportationComplexType;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
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
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.complexes.GeometricComplexProperty;
import org.citygml4j.util.mapper.TypeMapper;
import org.w3._1999.xlink.ActuateType;
import org.w3._1999.xlink.ShowType;
import org.w3._1999.xlink.TypeType;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBElement;
import java.util.concurrent.locks.ReentrantLock;

public class Transportation200Marshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final ObjectFactory tran = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;
	private TypeMapper<JAXBElement<?>> elementMapper;
	private TypeMapper<Object> typeMapper;

	public Transportation200Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	private TypeMapper<JAXBElement<?>> getElementMapper() {
		if (elementMapper == null) {
			lock.lock();
			try {
				if (elementMapper == null) {
					elementMapper = TypeMapper.<JAXBElement<?>>create()
							.with(AuxiliaryTrafficArea.class, this::createAuxiliaryTrafficArea)
							.with(Railway.class, this::createRailway)
							.with(Road.class, this::createRoad)
							.with(Square.class, this::createSquare)
							.with(Track.class, this::createTrack)
							.with(TrafficArea.class, this::createTrafficArea)
							.with(TransportationComplex.class, this::createTransportationComplex);
				}
			} finally {
				lock.unlock();
			}
		}

		return elementMapper;
	}

	private TypeMapper<Object> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = TypeMapper.create()
							.with(AuxiliaryTrafficArea.class, this::marshalAuxiliaryTrafficArea)
							.with(AuxiliaryTrafficAreaProperty.class, this::marshalAuxiliaryTrafficAreaProperty)
							.with(Railway.class, this::marshalRailway)
							.with(Road.class, this::marshalRoad)
							.with(Square.class, this::marshalSquare)
							.with(Track.class, this::marshalTrack)
							.with(TrafficArea.class, this::marshalTrafficArea)
							.with(TrafficAreaProperty.class, this::marshalTrafficAreaProperty)
							.with(TransportationComplex.class, this::marshalTransportationComplex);
				}
			} finally {
				lock.unlock();
			}
		}

		return typeMapper;
	}

	public JAXBElement<?> marshalJAXBElement(ModelObject src) {
		return getElementMapper().apply(src);
	}

	public Object marshal(ModelObject src) {
		return getTypeMapper().apply(src);
	}

	public void marshalAbstractTransportationObject(AbstractTransportationObject src, AbstractTransportationObjectType dest) {
		citygml.getCore200Marshaller().marshalAbstractCityObject(src, dest);

		if (src.isSetGenericApplicationPropertyOfTransportationObject()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfTransportationObject()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfTransportationObject().add(jaxbElement);
			}
		}
	}

	public void marshalAuxiliaryTrafficArea(AuxiliaryTrafficArea src, AuxiliaryTrafficAreaType dest) {
		marshalAbstractTransportationObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(jaxb.getGMLMarshaller().marshalCode(src.getClazz()));

		if (src.isSetFunction()) {
			for (Code function : src.getFunction())
				dest.getFunction().add(jaxb.getGMLMarshaller().marshalCode(function));
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage())
				dest.getUsage().add(jaxb.getGMLMarshaller().marshalCode(usage));
		}

		if (src.isSetSurfaceMaterial())
			dest.setSurfaceMaterial(jaxb.getGMLMarshaller().marshalCode(src.getSurfaceMaterial()));

		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod2MultiSurface()));

		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod3MultiSurface()));

		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod4MultiSurface()));

		if (src.isSetGenericApplicationPropertyOfAuxiliaryTrafficArea()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfAuxiliaryTrafficArea()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfAuxiliaryTrafficArea().add(jaxbElement);
			}
		}
	}

	public AuxiliaryTrafficAreaType marshalAuxiliaryTrafficArea(AuxiliaryTrafficArea src) {
		AuxiliaryTrafficAreaType dest =  tran.createAuxiliaryTrafficAreaType();
		marshalAuxiliaryTrafficArea(src, dest);

		return dest;
	}

	@SuppressWarnings("unchecked")
	public AuxiliaryTrafficAreaPropertyType marshalAuxiliaryTrafficAreaProperty(AuxiliaryTrafficAreaProperty src) {
		AuxiliaryTrafficAreaPropertyType dest = tran.createAuxiliaryTrafficAreaPropertyType();

		if (src.isSetAuxiliaryTrafficArea()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getAuxiliaryTrafficArea());
			if (elem != null && elem.getValue() instanceof AuxiliaryTrafficAreaType)
				dest.set_CityObject((JAXBElement<? extends AuxiliaryTrafficAreaType>)elem);
		}

		if (src.isSetGenericADEElement()) {
			Element element = jaxb.getADEMarshaller().marshalDOMElement(src.getGenericADEElement());
			if (element != null)
				dest.set_ADEComponent(element);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public void marshalRailway(Railway src, RailwayType dest) {
		marshalTransportationComplex(src, dest);

		if (src.isSetGenericApplicationPropertyOfRailway()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfRailway()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfRailway().add(jaxbElement);
			}
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
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfRoad()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfRoad().add(jaxbElement);
			}
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
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfSquare()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfSquare().add(jaxbElement);
			}
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
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfTrack()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfTrack().add(jaxbElement);
			}
		}
	}

	public TrackType marshalTrack(Track src) {
		TrackType dest = tran.createTrackType();
		marshalTrack(src, dest);

		return dest;
	}	

	public void marshalTrafficArea(TrafficArea src, TrafficAreaType dest) {
		marshalAbstractTransportationObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(jaxb.getGMLMarshaller().marshalCode(src.getClazz()));

		if (src.isSetFunction()) {
			for (Code function : src.getFunction())
				dest.getFunction().add(jaxb.getGMLMarshaller().marshalCode(function));
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage())
				dest.getUsage().add(jaxb.getGMLMarshaller().marshalCode(usage));
		}

		if (src.isSetSurfaceMaterial())
			dest.setSurfaceMaterial(jaxb.getGMLMarshaller().marshalCode(src.getSurfaceMaterial()));

		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod2MultiSurface()));

		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod3MultiSurface()));

		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod4MultiSurface()));

		if (src.isSetGenericApplicationPropertyOfTrafficArea()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfTrafficArea()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfTrafficArea().add(jaxbElement);
			}
		}
	}

	public TrafficAreaType marshalTrafficArea(TrafficArea src) {
		TrafficAreaType dest = tran.createTrafficAreaType();
		marshalTrafficArea(src, dest);

		return dest;
	}

	@SuppressWarnings("unchecked")
	public TrafficAreaPropertyType marshalTrafficAreaProperty(TrafficAreaProperty src) {
		TrafficAreaPropertyType dest = tran.createTrafficAreaPropertyType();

		if (src.isSetTrafficArea()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getTrafficArea());
			if (elem != null && elem.getValue() instanceof TrafficAreaType)
				dest.set_CityObject((JAXBElement<? extends TrafficAreaType>)elem);
		}

		if (src.isSetGenericADEElement()) {
			Element element = jaxb.getADEMarshaller().marshalDOMElement(src.getGenericADEElement());
			if (element != null)
				dest.set_ADEComponent(element);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public void marshalTransportationComplex(TransportationComplex src, TransportationComplexType dest) {
		marshalAbstractTransportationObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(jaxb.getGMLMarshaller().marshalCode(src.getClazz()));

		if (src.isSetFunction()) {
			for (Code function : src.getFunction())
				dest.getFunction().add(jaxb.getGMLMarshaller().marshalCode(function));
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage())
				dest.getUsage().add(jaxb.getGMLMarshaller().marshalCode(usage));
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
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfTransportationComplex()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfTransportationComplex().add(jaxbElement);
			}
		}
	}

	public TransportationComplexType marshalTransportationComplex(TransportationComplex src) {
		TransportationComplexType dest = tran.createTransportationComplexType();
		marshalTransportationComplex(src, dest);

		return dest;
	}

	private JAXBElement<?> createAuxiliaryTrafficArea(AuxiliaryTrafficArea src) {
		return tran.createAuxiliaryTrafficArea(marshalAuxiliaryTrafficArea(src));
	}

	private JAXBElement<?> createRailway(Railway src) {
		return tran.createRailway(marshalRailway(src));
	}

	private JAXBElement<?> createRoad(Road src) {
		return tran.createRoad(marshalRoad(src));
	}

	private JAXBElement<?> createSquare(Square src) {
		return tran.createSquare(marshalSquare(src));
	}

	private JAXBElement<?> createTrack(Track src) {
		return tran.createTrack(marshalTrack(src));
	}

	private JAXBElement<?> createTrafficArea(TrafficArea src) {
		return tran.createTrafficArea(marshalTrafficArea(src));
	}

	private JAXBElement<?> createTransportationComplex(TransportationComplex src) {
		return tran.createTransportationComplex(marshalTransportationComplex(src));
	}

}
