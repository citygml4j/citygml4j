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
package org.citygml4j.builder.jaxb.marshal.citygml.vegetation;

import net.opengis.citygml.vegetation._2.AbstractVegetationObjectType;
import net.opengis.citygml.vegetation._2.ObjectFactory;
import net.opengis.citygml.vegetation._2.PlantCoverType;
import net.opengis.citygml.vegetation._2.SolitaryVegetationObjectType;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.vegetation.AbstractVegetationObject;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.util.mapper.TypeMapper;

import javax.xml.bind.JAXBElement;
import java.util.concurrent.locks.ReentrantLock;

public class Vegetation200Marshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final ObjectFactory veg = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;
	private TypeMapper<JAXBElement<?>> elementMapper;
	private TypeMapper<Object> typeMapper;

	public Vegetation200Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	private TypeMapper<JAXBElement<?>> getElementMapper() {
		if (elementMapper == null) {
			lock.lock();
			try {
				if (elementMapper == null) {
					elementMapper = TypeMapper.<JAXBElement<?>>create()
							.with(PlantCover.class, this::createPlantCover)
							.with(SolitaryVegetationObject.class, this::createSolitaryVegetationObject);
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
							.with(PlantCover.class, this::marshalPlantCover)
							.with(SolitaryVegetationObject.class, this::marshalSolitaryVegetationObject);
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

	public void marshalVegetationObject(AbstractVegetationObject src, AbstractVegetationObjectType dest) {
		citygml.getCore200Marshaller().marshalAbstractCityObject(src, dest);

		if (src.isSetGenericApplicationPropertyOfVegetationObject()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfVegetationObject()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfVegetationObject().add(jaxbElement);
			}
		}
	}

	public void marshalPlantCover(PlantCover src, PlantCoverType dest) {
		marshalVegetationObject(src, dest);

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

		if (src.isSetAverageHeight())
			dest.setAverageHeight(jaxb.getGMLMarshaller().marshalLength(src.getAverageHeight()));

		if (src.isSetLod1MultiSurface())
			dest.setLod1MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod1MultiSurface()));

		if (src.isSetLod2MultiSurface())
			dest.setLod2MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod2MultiSurface()));

		if (src.isSetLod3MultiSurface())
			dest.setLod3MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod3MultiSurface()));

		if (src.isSetLod4MultiSurface())
			dest.setLod4MultiSurface(jaxb.getGMLMarshaller().marshalMultiSurfaceProperty(src.getLod4MultiSurface()));

		if (src.isSetLod1MultiSolid())
			dest.setLod1MultiSolid(jaxb.getGMLMarshaller().marshalMultiSolidProperty(src.getLod1MultiSolid()));

		if (src.isSetLod2MultiSolid())
			dest.setLod2MultiSolid(jaxb.getGMLMarshaller().marshalMultiSolidProperty(src.getLod2MultiSolid()));

		if (src.isSetLod3MultiSolid())
			dest.setLod3MultiSolid(jaxb.getGMLMarshaller().marshalMultiSolidProperty(src.getLod3MultiSolid()));

		if (src.isSetLod4MultiSolid())
			dest.setLod4MultiSolid(jaxb.getGMLMarshaller().marshalMultiSolidProperty(src.getLod4MultiSolid()));

		if (src.isSetGenericApplicationPropertyOfPlantCover()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfPlantCover()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfPlantCover().add(jaxbElement);
			}
		}
	}

	public PlantCoverType marshalPlantCover(PlantCover src) {
		PlantCoverType dest = veg.createPlantCoverType();
		marshalPlantCover(src, dest);

		return dest;
	}

	public void marshalSolitaryVegetationObject(SolitaryVegetationObject src, SolitaryVegetationObjectType dest) {
		marshalVegetationObject(src, dest);

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

		if (src.isSetSpecies())
			dest.setSpecies(jaxb.getGMLMarshaller().marshalCode(src.getSpecies()));

		if (src.isSetHeight())
			dest.setHeight(jaxb.getGMLMarshaller().marshalLength(src.getHeight()));

		if (src.isSetTrunkDiameter())
			dest.setTrunkDiameter(jaxb.getGMLMarshaller().marshalLength(src.getTrunkDiameter()));

		if (src.isSetCrownDiameter())
			dest.setCrownDiameter(jaxb.getGMLMarshaller().marshalLength(src.getCrownDiameter()));

		if (src.isSetLod1Geometry())
			dest.setLod1Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod1Geometry()));

		if (src.isSetLod2Geometry())
			dest.setLod2Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod2Geometry()));

		if (src.isSetLod3Geometry())
			dest.setLod3Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod3Geometry()));

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod4Geometry()));

		if (src.isSetLod1ImplicitRepresentation())
			dest.setLod1ImplicitRepresentation(citygml.getCore200Marshaller().marshalImplicitRepresentationProperty(src.getLod1ImplicitRepresentation()));

		if (src.isSetLod2ImplicitRepresentation())
			dest.setLod2ImplicitRepresentation(citygml.getCore200Marshaller().marshalImplicitRepresentationProperty(src.getLod2ImplicitRepresentation()));

		if (src.isSetLod3ImplicitRepresentation())
			dest.setLod3ImplicitRepresentation(citygml.getCore200Marshaller().marshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation()));

		if (src.isSetLod4ImplicitRepresentation())
			dest.setLod4ImplicitRepresentation(citygml.getCore200Marshaller().marshalImplicitRepresentationProperty(src.getLod4ImplicitRepresentation()));

		if (src.isSetGenericApplicationPropertyOfSolitaryVegetationObject()) {
			for (ADEComponent adeComponent : src.getGenericApplicationPropertyOfSolitaryVegetationObject()) {
				JAXBElement<Object> jaxbElement = jaxb.getADEMarshaller().marshalJAXBElement(adeComponent);
				if (jaxbElement != null)
					dest.get_GenericApplicationPropertyOfSolitaryVegetationObject().add(jaxbElement);
			}
		}
	}

	public SolitaryVegetationObjectType marshalSolitaryVegetationObject(SolitaryVegetationObject src) {
		SolitaryVegetationObjectType dest = veg.createSolitaryVegetationObjectType();
		marshalSolitaryVegetationObject(src, dest);

		return dest;
	}

	private JAXBElement<?> createPlantCover(PlantCover src) {
		return veg.createPlantCover(marshalPlantCover(src));
	}

	private JAXBElement<?> createSolitaryVegetationObject(SolitaryVegetationObject src) {
		return veg.createSolitaryVegetationObject(marshalSolitaryVegetationObject(src));
	}

}
