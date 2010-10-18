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
package org.citygml4j.builder.jaxb.marshal.citygml.generics;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.jaxb.citygml.gen._1.AbstractGenericAttributeType;
import org.citygml4j.jaxb.citygml.gen._1.DateAttributeType;
import org.citygml4j.jaxb.citygml.gen._1.DoubleAttributeType;
import org.citygml4j.jaxb.citygml.gen._1.GenericCityObjectType;
import org.citygml4j.jaxb.citygml.gen._1.IntAttributeType;
import org.citygml4j.jaxb.citygml.gen._1.ObjectFactory;
import org.citygml4j.jaxb.citygml.gen._1.StringAttributeType;
import org.citygml4j.jaxb.citygml.gen._1.UriAttributeType;
import org.citygml4j.model.citygml.generics.AbstractGenericAttribute;
import org.citygml4j.model.citygml.generics.DateAttribute;
import org.citygml4j.model.citygml.generics.DoubleAttribute;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.generics.GenericsModuleComponent;
import org.citygml4j.model.citygml.generics.IntAttribute;
import org.citygml4j.model.citygml.generics.StringAttribute;
import org.citygml4j.model.citygml.generics.UriAttribute;
import org.citygml4j.model.common.base.ModelObject;

public class Generics100Marshaller {
	private final ObjectFactory gen = new ObjectFactory();
	private final JAXBMarshaller jaxb;
	private final CityGMLMarshaller citygml;
	
	public Generics100Marshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBMarshaller();
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = null;

		if (src instanceof GenericsModuleComponent)
			src = marshal((GenericsModuleComponent)src);
		
		if (src instanceof GenericCityObjectType)
			dest = gen.createGenericCityObject((GenericCityObjectType)src);
		else if (src instanceof DateAttributeType)
			dest = gen.createDateAttribute((DateAttributeType)src);
		else if (src instanceof DoubleAttributeType)
			dest = gen.createDoubleAttribute((DoubleAttributeType)src);
		else if (src instanceof IntAttributeType)
			dest = gen.createIntAttribute((IntAttributeType)src);
		else if (src instanceof StringAttributeType)
			dest = gen.createStringAttribute((StringAttributeType)src);
		else if (src instanceof UriAttributeType)
			dest = gen.createUriAttribute((UriAttributeType)src);
		
		return dest;
	}
	
	public Object marshal(ModelObject src) {
		Object dest = null;
		
		if (src instanceof GenericCityObject)
			dest = marshalGenericCityObject((GenericCityObject)src);
		else if (src instanceof DateAttribute)
			dest = marshalDateAttribute((DateAttribute)src);
		else if (src instanceof DoubleAttribute)
			dest = marshalDoubleAttribute((DoubleAttribute)src);
		else if (src instanceof IntAttribute)
			dest = marshalIntAttribute((IntAttribute)src);
		else if (src instanceof StringAttribute)
			dest = marshalStringAttribute((StringAttribute)src);
		else if (src instanceof UriAttribute)
			dest = marshalUriAttribute((UriAttribute)src);
		
		return dest;
	}
	
	public void marshalGenericAttribute(AbstractGenericAttribute src, AbstractGenericAttributeType dest) {
		if (src.isSetName())
			dest.setName(src.getName());
	}
	
	public void marshalGenericCityObject(GenericCityObject src, GenericCityObjectType dest) {
		citygml.getCore100Marshaller().marshalCityObject(src, dest);
		
		if (src.isSetClazz())
			dest.setClazz(src.getClazz());
		
		if (src.isSetFunction())
			dest.setFunction(src.getFunction());
		
		if (src.isSetUsage())
			dest.setUsage(src.getUsage());
		
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
		marshalGenericAttribute(src, dest);
		
		if (src.isSetValue()) {
			try {
				GregorianCalendar date = src.getValue();
				DatatypeFactory factory = DatatypeFactory.newInstance();
				dest.setValue(factory.newXMLGregorianCalendarDate(
						date.get(Calendar.YEAR),
						date.get(Calendar.MONTH) + 1,
						date.get(Calendar.DAY_OF_MONTH),
						DatatypeConstants.FIELD_UNDEFINED));
			} catch (DatatypeConfigurationException e) {
				// 
			}
		}
	}
	
	public DateAttributeType marshalDateAttribute(DateAttribute src) {
		DateAttributeType dest = gen.createDateAttributeType();
		marshalDateAttribute(src, dest);

		return dest;		
	}
	
	public void marshalDoubleAttribute(DoubleAttribute src, DoubleAttributeType dest) {
		marshalGenericAttribute(src, dest);
		
		if (src.isSetValue())
			dest.setValue(src.getValue());
	}
	
	public DoubleAttributeType marshalDoubleAttribute(DoubleAttribute src) {
		DoubleAttributeType dest = gen.createDoubleAttributeType();
		marshalDoubleAttribute(src, dest);

		return dest;		
	}
	
	public void marshalIntAttribute(IntAttribute src, IntAttributeType dest) {
		marshalGenericAttribute(src, dest);
		
		if (src.isSetValue())
			dest.setValue(BigInteger.valueOf(src.getValue()));
	}
	
	public IntAttributeType marshalIntAttribute(IntAttribute src) {
		IntAttributeType dest = gen.createIntAttributeType();
		marshalIntAttribute(src, dest);

		return dest;		
	}
	
	public void marshalStringAttribute(StringAttribute src, StringAttributeType dest) {
		marshalGenericAttribute(src, dest);
		
		if (src.isSetValue())
			dest.setValue(src.getValue());
	}
	
	public StringAttributeType marshalStringAttribute(StringAttribute src) {
		StringAttributeType dest = gen.createStringAttributeType();
		marshalStringAttribute(src, dest);

		return dest;		
	}
	
	public void marshalUriAttribute(UriAttribute src, UriAttributeType dest) {
		marshalGenericAttribute(src, dest);
		
		if (src.isSetValue())
			dest.setValue(src.getValue());
	}
	
	public UriAttributeType marshalUriAttribute(UriAttribute src) {
		UriAttributeType dest = gen.createUriAttributeType();
		marshalUriAttribute(src, dest);

		return dest;		
	}
	
}
