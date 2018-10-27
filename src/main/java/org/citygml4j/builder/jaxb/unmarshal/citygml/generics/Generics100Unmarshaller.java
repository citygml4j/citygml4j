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
package org.citygml4j.builder.jaxb.unmarshal.citygml.generics;

import net.opengis.citygml.generics._1.AbstractGenericAttributeType;
import net.opengis.citygml.generics._1.DateAttributeType;
import net.opengis.citygml.generics._1.DoubleAttributeType;
import net.opengis.citygml.generics._1.GenericCityObjectType;
import net.opengis.citygml.generics._1.IntAttributeType;
import net.opengis.citygml.generics._1.StringAttributeType;
import net.opengis.citygml.generics._1.UriAttributeType;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.generics.AbstractGenericAttribute;
import org.citygml4j.model.citygml.generics.DateAttribute;
import org.citygml4j.model.citygml.generics.DoubleAttribute;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.generics.IntAttribute;
import org.citygml4j.model.citygml.generics.StringAttribute;
import org.citygml4j.model.citygml.generics.UriAttribute;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.module.citygml.GenericsModule;
import org.citygml4j.util.mapper.CheckedTypeMapper;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

import javax.xml.bind.JAXBElement;
import java.util.concurrent.locks.ReentrantLock;

public class Generics100Unmarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final GenericsModule module = GenericsModule.v1_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;
	private CheckedTypeMapper<CityGML> typeMapper;

	public Generics100Unmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBUnmarshaller();
	}

	private CheckedTypeMapper<CityGML> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = CheckedTypeMapper.<CityGML>create()
							.with(GenericCityObjectType.class, this::unmarshalGenericCityObject)
							.with(DateAttributeType.class, this::unmarshalDateAttribute)
							.with(DoubleAttributeType.class, this::unmarshalDoubleAttribute)
							.with(IntAttributeType.class, this::unmarshalIntAttribute)
							.with(StringAttributeType.class, this::unmarshalStringAttribute)
							.with(UriAttributeType.class, this::unmarshalUriAttribute)
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

	public void unmarshalAbstractGenericAttribute(AbstractGenericAttributeType src, AbstractGenericAttribute dest) {
		if (src.isSetName())
			dest.setName(src.getName());
	}

	public void unmarshalGenericCityObject(GenericCityObjectType src, GenericCityObject dest) throws MissingADESchemaException {
		citygml.getCore100Unmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetClazz())
			dest.setClazz(new Code(src.getClazz()));

		if (src.isSetFunction()) {
			for (String function : src.getFunction())
				dest.addFunction(new Code(function));
		}

		if (src.isSetUsage()) {
			for (String usage : src.getUsage())
				dest.addUsage(new Code(usage));
		}

		if (src.isSetLod0Geometry())
			dest.setLod0Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod0Geometry()));

		if (src.isSetLod1Geometry())
			dest.setLod1Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod1Geometry()));

		if (src.isSetLod2Geometry())
			dest.setLod2Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod2Geometry()));

		if (src.isSetLod3Geometry())
			dest.setLod3Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod3Geometry()));

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod4Geometry()));

		if (src.isSetLod0ImplicitRepresentation())
			dest.setLod0ImplicitRepresentation(citygml.getCore100Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod0ImplicitRepresentation()));

		if (src.isSetLod1ImplicitRepresentation())
			dest.setLod1ImplicitRepresentation(citygml.getCore100Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod1ImplicitRepresentation()));

		if (src.isSetLod2ImplicitRepresentation())
			dest.setLod2ImplicitRepresentation(citygml.getCore100Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod2ImplicitRepresentation()));

		if (src.isSetLod3ImplicitRepresentation())
			dest.setLod3ImplicitRepresentation(citygml.getCore100Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation()));

		if (src.isSetLod4ImplicitRepresentation())
			dest.setLod4ImplicitRepresentation(citygml.getCore100Unmarshaller().unmarshalImplicitRepresentationProperty(src.getLod4ImplicitRepresentation()));

		if (src.isSetLod0TerrainIntersection())
			dest.setLod0TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod0TerrainIntersection()));

		if (src.isSetLod1TerrainIntersection())
			dest.setLod1TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod1TerrainIntersection()));

		if (src.isSetLod2TerrainIntersection())
			dest.setLod2TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod2TerrainIntersection()));

		if (src.isSetLod3TerrainIntersection())
			dest.setLod3TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod3TerrainIntersection()));

		if (src.isSetLod4TerrainIntersection())
			dest.setLod4TerrainIntersection(jaxb.getGMLUnmarshaller().unmarshalMultiCurveProperty(src.getLod4TerrainIntersection()));
	}

	public GenericCityObject unmarshalGenericCityObject(GenericCityObjectType src) throws MissingADESchemaException {
		GenericCityObject dest = new GenericCityObject(module);
		unmarshalGenericCityObject(src, dest);

		return dest;
	}

	public void unmarshalDateAttribute(DateAttributeType src, DateAttribute dest) {
		unmarshalAbstractGenericAttribute(src, dest);

		if (src.isSetValue())
			dest.setValue(src.getValue().toGregorianCalendar().toZonedDateTime().toLocalDate());
	}

	public DateAttribute unmarshalDateAttribute(DateAttributeType src) {
		DateAttribute dest = new DateAttribute(module);
		unmarshalDateAttribute(src, dest);

		return dest;		
	}

	public void unmarshalDoubleAttribute(DoubleAttributeType src, DoubleAttribute dest) {
		unmarshalAbstractGenericAttribute(src, dest);

		if (src.isSetValue())
			dest.setValue(src.getValue());
	}

	public DoubleAttribute unmarshalDoubleAttribute(DoubleAttributeType src) {
		DoubleAttribute dest = new DoubleAttribute(module);
		unmarshalDoubleAttribute(src, dest);

		return dest;		
	}

	public void unmarshalIntAttribute(IntAttributeType src, IntAttribute dest) {
		unmarshalAbstractGenericAttribute(src, dest);

		if (src.isSetValue())
			dest.setValue(src.getValue().intValue());
	}

	public IntAttribute unmarshalIntAttribute(IntAttributeType src) {
		IntAttribute dest = new IntAttribute(module);
		unmarshalIntAttribute(src, dest);

		return dest;		
	}

	public void unmarshalStringAttribute(StringAttributeType src, StringAttribute dest) {
		unmarshalAbstractGenericAttribute(src, dest);

		if (src.isSetValue())
			dest.setValue(src.getValue());
	}

	public StringAttribute unmarshalStringAttribute(StringAttributeType src) {
		StringAttribute dest = new StringAttribute(module);
		unmarshalStringAttribute(src, dest);

		return dest;		
	}

	public void unmarshalUriAttribute(UriAttributeType src, UriAttribute dest) {
		unmarshalAbstractGenericAttribute(src, dest);

		if (src.isSetValue())
			dest.setValue(src.getValue());
	}

	public UriAttribute unmarshalUriAttribute(UriAttributeType src) {
		UriAttribute dest = new UriAttribute(module);
		unmarshalUriAttribute(src, dest);

		return dest;		
	}

}
