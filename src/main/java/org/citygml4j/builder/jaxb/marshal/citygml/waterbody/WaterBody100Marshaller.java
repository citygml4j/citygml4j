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
package org.citygml4j.builder.jaxb.marshal.citygml.waterbody;

import net.opengis.citygml.waterbody._1.AbstractWaterBoundarySurfaceType;
import net.opengis.citygml.waterbody._1.AbstractWaterObjectType;
import net.opengis.citygml.waterbody._1.BoundedByWaterSurfacePropertyType;
import net.opengis.citygml.waterbody._1.ObjectFactory;
import net.opengis.citygml.waterbody._1.WaterBodyType;
import net.opengis.citygml.waterbody._1.WaterClosureSurfaceType;
import net.opengis.citygml.waterbody._1.WaterGroundSurfaceType;
import net.opengis.citygml.waterbody._1.WaterSurfaceType;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.waterbody.AbstractWaterBoundarySurface;
import org.citygml4j.model.citygml.waterbody.AbstractWaterObject;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.util.mapper.TypeMapper;

import javax.xml.bind.JAXBElement;
import java.util.concurrent.locks.ReentrantLock;

public class WaterBody100Marshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final ObjectFactory wtr = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;
	private TypeMapper<JAXBElement<?>> elementMapper;
	private TypeMapper<Object> typeMapper;

	public WaterBody100Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	private TypeMapper<JAXBElement<?>> getElementMapper() {
		if (elementMapper == null) {
			lock.lock();
			try {
				if (elementMapper == null) {
					elementMapper = TypeMapper.<JAXBElement<?>>create()
							.with(WaterBody.class, this::createWaterBody)
							.with(WaterClosureSurface.class, this::createWaterClosureSurface)
							.with(WaterGroundSurface.class, this::createWaterGroundSurface)
							.with(WaterSurface.class, this::createWaterSurface);
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
							.with(BoundedByWaterSurfaceProperty.class, this::marshalBoundedByWaterSurfaceProperty)
							.with(WaterBody.class, this::marshalWaterBody)
							.with(WaterClosureSurface.class, this::marshalWaterClosureSurface)
							.with(WaterGroundSurface.class, this::marshalWaterGroundSurface)
							.with(WaterSurface.class, this::marshalWaterSurface);
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

	public void marshalAbstractWaterObject(AbstractWaterObject src, AbstractWaterObjectType dest) {
		citygml.getCore100Marshaller().marshalAbstractCityObject(src, dest);

		if (src.isSetGenericApplicationPropertyOfWaterObject()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfWaterObject()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfWaterObject().add(jaxbElement);
			}
		}
	}

	public void marshalAbstractWaterBoundarySurface(AbstractWaterBoundarySurface src, AbstractWaterBoundarySurfaceType dest) {
		citygml.getCore100Marshaller().marshalAbstractCityObject(src, dest);

		if (src.isSetLod2Surface())
			dest.setLod2Surface(jaxb.getGMLMarshaller().marshalSurfaceProperty(src.getLod2Surface()));

		if (src.isSetLod3Surface())
			dest.setLod3Surface(jaxb.getGMLMarshaller().marshalSurfaceProperty(src.getLod3Surface()));

		if (src.isSetLod4Surface())
			dest.setLod4Surface(jaxb.getGMLMarshaller().marshalSurfaceProperty(src.getLod4Surface()));

		if (src.isSetGenericApplicationPropertyOfWaterBoundarySurface()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfWaterBoundarySurface()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfWaterBoundarySurface().add(jaxbElement);
			}
		}
	}

	public BoundedByWaterSurfacePropertyType marshalBoundedByWaterSurfaceProperty(BoundedByWaterSurfaceProperty src) {
		BoundedByWaterSurfacePropertyType dest = wtr.createBoundedByWaterSurfacePropertyType();
		jaxb.getGMLMarshaller().marshalFeatureProperty(src, dest);

		if (src.isSetWaterBoundarySurface()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getWaterBoundarySurface());
			if (elem != null && elem.getValue() instanceof AbstractWaterBoundarySurfaceType)
				dest.set_Object((JAXBElement<?>)elem);
		}

		return dest;
	}

	public void marshalWaterBody(WaterBody src, WaterBodyType dest) {
		marshalAbstractWaterObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(src.getClazz().getValue());

		if (src.isSetFunction()) {
			for (Code function : src.getFunction())
				dest.getFunction().add(function.getValue());
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage())
				dest.getUsage().add(usage.getValue());
		}

		if (src.isSetLod0MultiSurface())
			dest.setLod0MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod0MultiSurface()));

		if (src.isSetLod1MultiSurface())
			dest.setLod1MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod1MultiSurface()));

		if (src.isSetLod0MultiCurve())
			dest.setLod0MultiCurve(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod0MultiCurve()));

		if (src.isSetLod1MultiCurve())
			dest.setLod1MultiCurve(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod1MultiCurve()));

		if (src.isSetLod1Solid())
			dest.setLod1Solid(jaxb.getGMLMarshaller().marshalSolidProperty(src.getLod1Solid()));

		if (src.isSetLod2Solid())
			dest.setLod2Solid(jaxb.getGMLMarshaller().marshalSolidProperty(src.getLod2Solid()));

		if (src.isSetLod3Solid())
			dest.setLod3Solid(jaxb.getGMLMarshaller().marshalSolidProperty(src.getLod3Solid()));

		if (src.isSetLod4Solid())
			dest.setLod4Solid(jaxb.getGMLMarshaller().marshalSolidProperty(src.getLod4Solid()));

		if (src.isSetBoundedBySurface()) {
			for (BoundedByWaterSurfaceProperty boundedByWaterSurfaceProperty : src.getBoundedBySurface())
				dest.getBoundedBySurface().add(marshalBoundedByWaterSurfaceProperty(boundedByWaterSurfaceProperty));
		}

		if (src.isSetGenericApplicationPropertyOfWaterBody()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfWaterBody()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfWaterBody().add(jaxbElement);
			}
		}
	}

	public WaterBodyType marshalWaterBody(WaterBody src) {
		WaterBodyType dest = wtr.createWaterBodyType();
		marshalWaterBody(src, dest);

		return dest;
	}

	public void marshalWaterClosureSurface(WaterClosureSurface src, WaterClosureSurfaceType dest) {
		marshalAbstractWaterBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfWaterClosureSurface()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfWaterClosureSurface()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfWaterClosureSurface().add(jaxbElement);
			}
		}
	}

	public WaterClosureSurfaceType marshalWaterClosureSurface(WaterClosureSurface src) {
		WaterClosureSurfaceType dest = wtr.createWaterClosureSurfaceType();
		marshalWaterClosureSurface(src, dest);

		return dest;
	}

	public void marshalWaterGroundSurface(WaterGroundSurface src, WaterGroundSurfaceType dest) {
		marshalAbstractWaterBoundarySurface(src, dest);

		if (src.isSetGenericApplicationPropertyOfWaterGroundSurface()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfWaterGroundSurface()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfWaterGroundSurface().add(jaxbElement);
			}
		}
	}

	public WaterGroundSurfaceType marshalWaterGroundSurface(WaterGroundSurface src) {
		WaterGroundSurfaceType dest = wtr.createWaterGroundSurfaceType();
		marshalWaterGroundSurface(src, dest);

		return dest;
	}

	public void marshalWaterSurface(WaterSurface src, WaterSurfaceType dest) {
		marshalAbstractWaterBoundarySurface(src, dest);

		if (src.isSetWaterLevel())
			dest.setWaterLevel(src.getWaterLevel().getValue());

		if (src.isSetGenericApplicationPropertyOfWaterSurface()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfWaterSurface()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfWaterSurface().add(jaxbElement);
			}
		}
	}

	public WaterSurfaceType marshalWaterSurface(WaterSurface src) {
		WaterSurfaceType dest = wtr.createWaterSurfaceType();
		marshalWaterSurface(src, dest);

		return dest;
	}

	private JAXBElement<?> createWaterBody(WaterBody src) {
		return wtr.createWaterBody(marshalWaterBody(src));
	}

	private JAXBElement<?> createWaterClosureSurface(WaterClosureSurface src) {
		return wtr.createWaterClosureSurface(marshalWaterClosureSurface(src));
	}

	private JAXBElement<?> createWaterGroundSurface(WaterGroundSurface src) {
		return wtr.createWaterGroundSurface(marshalWaterGroundSurface(src));
	}

	private JAXBElement<?> createWaterSurface(WaterSurface src) {
		return wtr.createWaterSurface(marshalWaterSurface(src));
	}

}
