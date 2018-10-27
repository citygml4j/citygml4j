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
package org.citygml4j.builder.jaxb.marshal.citygml.generics;

import net.opengis.citygml.generics._1.AbstractGenericAttributeType;
import net.opengis.citygml.generics._1.DateAttributeType;
import net.opengis.citygml.generics._1.DoubleAttributeType;
import net.opengis.citygml.generics._1.GenericCityObjectType;
import net.opengis.citygml.generics._1.IntAttributeType;
import net.opengis.citygml.generics._1.ObjectFactory;
import net.opengis.citygml.generics._1.StringAttributeType;
import net.opengis.citygml.generics._1.UriAttributeType;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.model.citygml.generics.AbstractGenericAttribute;
import org.citygml4j.model.citygml.generics.DateAttribute;
import org.citygml4j.model.citygml.generics.DoubleAttribute;
import org.citygml4j.model.citygml.generics.GenericAttributeSet;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.generics.IntAttribute;
import org.citygml4j.model.citygml.generics.MeasureAttribute;
import org.citygml4j.model.citygml.generics.StringAttribute;
import org.citygml4j.model.citygml.generics.UriAttribute;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.util.mapper.TypeMapper;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConstants;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Generics100Marshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final ObjectFactory gen = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;
	private TypeMapper<JAXBElement<?>> elementMapper;
	private TypeMapper<Object> typeMapper;

	public Generics100Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	private TypeMapper<JAXBElement<?>> getElementMapper() {
		if (elementMapper == null) {
			lock.lock();
			try {
				if (elementMapper == null) {
					elementMapper = TypeMapper.<JAXBElement<?>>create()
							.with(GenericCityObject.class, this::createGenericCityObject)
							.with(DateAttribute.class, this::createDateAttribute)
							.with(DoubleAttribute.class, this::createDoubleAttribute)
							.with(IntAttribute.class, this::createIntAttribute)
							.with(StringAttribute.class, this::createStringAttribute)
							.with(UriAttribute.class, this::createUriAttribute)
							.with(MeasureAttribute.class, this::createMeasureAttribute);
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
							.with(GenericCityObject.class, this::marshalGenericCityObject)
							.with(DateAttribute.class, this::marshalDateAttribute)
							.with(DoubleAttribute.class, this::marshalDoubleAttribute)
							.with(IntAttribute.class, this::marshalIntAttribute)
							.with(StringAttribute.class, this::marshalStringAttribute)
							.with(UriAttribute.class, this::marshalUriAttribute)
							.with(MeasureAttribute.class, this::marshalMeasureAttribute);
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

	public void marshalAbstractGenericAttribute(AbstractGenericAttribute src, AbstractGenericAttributeType dest) {
		if (src.isSetName())
			dest.setName(src.getName());
	}

	public void marshalGenericCityObject(GenericCityObject src, GenericCityObjectType dest) {
		citygml.getCore100Marshaller().marshalAbstractCityObject(src, dest);

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

		if (src.isSetLod0Geometry())
			dest.setLod0Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod0Geometry()));

		if (src.isSetLod1Geometry())
			dest.setLod1Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod1Geometry()));

		if (src.isSetLod2Geometry())
			dest.setLod2Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod2Geometry()));

		if (src.isSetLod3Geometry())
			dest.setLod3Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod3Geometry()));

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLMarshaller().marshalGeometryProperty(src.getLod4Geometry()));

		if (src.isSetLod0ImplicitRepresentation())
			dest.setLod0ImplicitRepresentation(citygml.getCore100Marshaller().marshalImplicitRepresentationProperty(src.getLod0ImplicitRepresentation()));

		if (src.isSetLod1ImplicitRepresentation())
			dest.setLod1ImplicitRepresentation(citygml.getCore100Marshaller().marshalImplicitRepresentationProperty(src.getLod1ImplicitRepresentation()));

		if (src.isSetLod2ImplicitRepresentation())
			dest.setLod2ImplicitRepresentation(citygml.getCore100Marshaller().marshalImplicitRepresentationProperty(src.getLod2ImplicitRepresentation()));

		if (src.isSetLod3ImplicitRepresentation())
			dest.setLod3ImplicitRepresentation(citygml.getCore100Marshaller().marshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation()));

		if (src.isSetLod4ImplicitRepresentation())
			dest.setLod4ImplicitRepresentation(citygml.getCore100Marshaller().marshalImplicitRepresentationProperty(src.getLod4ImplicitRepresentation()));

		if (src.isSetLod0TerrainIntersection())
			dest.setLod0TerrainIntersection(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod0TerrainIntersection()));

		if (src.isSetLod1TerrainIntersection())
			dest.setLod1TerrainIntersection(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod1TerrainIntersection()));

		if (src.isSetLod2TerrainIntersection())
			dest.setLod2TerrainIntersection(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod2TerrainIntersection()));

		if (src.isSetLod3TerrainIntersection())
			dest.setLod3TerrainIntersection(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod3TerrainIntersection()));

		if (src.isSetLod4TerrainIntersection())
			dest.setLod4TerrainIntersection(jaxb.getGMLMarshaller().marshalMultiCurveProperty(src.getLod4TerrainIntersection()));
	}

	public GenericCityObjectType marshalGenericCityObject(GenericCityObject src) {
		GenericCityObjectType dest = gen.createGenericCityObjectType();
		marshalGenericCityObject(src, dest);

		return dest;
	}

	public void marshalDateAttribute(DateAttribute src, DateAttributeType dest) {
		marshalAbstractGenericAttribute(src, dest);

		if (src.isSetValue()) {
			LocalDate date = src.getValue();
			dest.setValue(jaxb.getDataTypeFactory().newXMLGregorianCalendarDate(
					date.getYear(),
					date.getMonthValue(),
					date.getDayOfMonth(),
					DatatypeConstants.FIELD_UNDEFINED));
		}
	}

	public DateAttributeType marshalDateAttribute(DateAttribute src) {
		DateAttributeType dest = gen.createDateAttributeType();
		marshalDateAttribute(src, dest);

		return dest;		
	}

	public void marshalDoubleAttribute(DoubleAttribute src, DoubleAttributeType dest) {
		marshalAbstractGenericAttribute(src, dest);

		if (src.isSetValue())
			dest.setValue(src.getValue());
	}

	public DoubleAttributeType marshalDoubleAttribute(DoubleAttribute src) {
		DoubleAttributeType dest = gen.createDoubleAttributeType();
		marshalDoubleAttribute(src, dest);

		return dest;		
	}

	public void marshalIntAttribute(IntAttribute src, IntAttributeType dest) {
		marshalAbstractGenericAttribute(src, dest);

		if (src.isSetValue())
			dest.setValue(BigInteger.valueOf(src.getValue()));
	}

	public IntAttributeType marshalIntAttribute(IntAttribute src) {
		IntAttributeType dest = gen.createIntAttributeType();
		marshalIntAttribute(src, dest);

		return dest;		
	}

	public void marshalStringAttribute(StringAttribute src, StringAttributeType dest) {
		marshalAbstractGenericAttribute(src, dest);

		if (src.isSetValue())
			dest.setValue(src.getValue());
	}

	public StringAttributeType marshalStringAttribute(StringAttribute src) {
		StringAttributeType dest = gen.createStringAttributeType();
		marshalStringAttribute(src, dest);

		return dest;		
	}

	public void marshalUriAttribute(UriAttribute src, UriAttributeType dest) {
		marshalAbstractGenericAttribute(src, dest);

		if (src.isSetValue())
			dest.setValue(src.getValue());
	}

	public UriAttributeType marshalUriAttribute(UriAttribute src) {
		UriAttributeType dest = gen.createUriAttributeType();
		marshalUriAttribute(src, dest);

		return dest;		
	}

	public void marshalMeasureAttribute(MeasureAttribute src, DoubleAttributeType dest) {
		marshalAbstractGenericAttribute(src, dest);

		if (src.isSetValue())
			dest.setValue(src.getValue().getValue());
	}

	public DoubleAttributeType marshalMeasureAttribute(MeasureAttribute src) {
		DoubleAttributeType dest = gen.createDoubleAttributeType();
		marshalMeasureAttribute(src, dest);

		return dest;
	}

	public List<AbstractGenericAttributeType> marshalGenericAttributeSet(GenericAttributeSet src) {
		List<AbstractGenericAttributeType> attributes = new ArrayList<AbstractGenericAttributeType>();
		marshalGenericAttributeSet(src, attributes);

		return attributes;
	}

	private void marshalGenericAttributeSet(GenericAttributeSet src, List<AbstractGenericAttributeType> attributes) {
		for (AbstractGenericAttribute genericAttribute : src.getGenericAttribute()) {
			switch (genericAttribute.getCityGMLClass()) {
			case DATE_ATTRIBUTE:
				attributes.add(marshalDateAttribute((DateAttribute)genericAttribute));
				break;
			case DOUBLE_ATTRIBUTE:
				attributes.add(marshalDoubleAttribute((DoubleAttribute)genericAttribute));
				break;
			case INT_ATTRIBUTE:
				attributes.add(marshalIntAttribute((IntAttribute)genericAttribute));
				break;
			case STRING_ATTRIBUTE:
				attributes.add(marshalStringAttribute((StringAttribute)genericAttribute));
				break;
			case URI_ATTRIBUTE:
				attributes.add(marshalUriAttribute((UriAttribute)genericAttribute));
				break;
			case MEASURE_ATTRIBUTE:
				attributes.add(marshalMeasureAttribute((MeasureAttribute)genericAttribute));
				break;
			case GENERIC_ATTRIBUTE_SET:
				marshalGenericAttributeSet((GenericAttributeSet)genericAttribute, attributes);
				break;
			default:
				break;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<JAXBElement<? extends AbstractGenericAttributeType>> marshalGenericAttributeSetElement(GenericAttributeSet src) {
		List<JAXBElement<? extends AbstractGenericAttributeType>> elements = new ArrayList<JAXBElement<? extends AbstractGenericAttributeType>>();

		for (AbstractGenericAttribute genericAttribute : src.getGenericAttribute())
			elements.add((JAXBElement<? extends AbstractGenericAttributeType>)marshalJAXBElement(genericAttribute));

		return elements;
	}

	private JAXBElement<?> createGenericCityObject(GenericCityObject src) {
		return gen.createGenericCityObject(marshalGenericCityObject(src));
	}

	private JAXBElement<?> createDateAttribute(DateAttribute src) {
		return gen.createDateAttribute(marshalDateAttribute(src));
	}

	private JAXBElement<?> createDoubleAttribute(DoubleAttribute src) {
		return gen.createDoubleAttribute(marshalDoubleAttribute(src));
	}

	private JAXBElement<?> createIntAttribute(IntAttribute src) {
		return gen.createIntAttribute(marshalIntAttribute(src));
	}

	private JAXBElement<?> createStringAttribute(StringAttribute src) {
		return gen.createStringAttribute(marshalStringAttribute(src));
	}

	private JAXBElement<?> createUriAttribute(UriAttribute src) {
		return gen.createUriAttribute(marshalUriAttribute(src));
	}

	private JAXBElement<?> createMeasureAttribute(MeasureAttribute src) {
		return gen.createDoubleAttribute(marshalMeasureAttribute(src));
	}

}
