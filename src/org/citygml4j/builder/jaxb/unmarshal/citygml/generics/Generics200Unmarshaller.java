/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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
 * 
 * $Id: Generics200Unmarshaller.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.builder.jaxb.unmarshal.citygml.generics;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.jaxb.citygml.gen._2.AbstractGenericAttributeType;
import org.citygml4j.jaxb.citygml.gen._2.DateAttributeType;
import org.citygml4j.jaxb.citygml.gen._2.DoubleAttributeType;
import org.citygml4j.jaxb.citygml.gen._2.GenericAttributeSetType;
import org.citygml4j.jaxb.citygml.gen._2.GenericCityObjectType;
import org.citygml4j.jaxb.citygml.gen._2.IntAttributeType;
import org.citygml4j.jaxb.citygml.gen._2.MeasureAttributeType;
import org.citygml4j.jaxb.citygml.gen._2.StringAttributeType;
import org.citygml4j.jaxb.citygml.gen._2.UriAttributeType;
import org.citygml4j.jaxb.gml._3_1_1.CodeType;
import org.citygml4j.model.citygml.CityGML;
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
import org.citygml4j.model.module.citygml.GenericsModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

public class Generics200Unmarshaller {
	private final GenericsModule module = GenericsModule.v2_0_0;
	private final JAXBUnmarshaller jaxb;
	private final CityGMLUnmarshaller citygml;

	public Generics200Unmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		jaxb = citygml.getJAXBUnmarshaller();
	}

	public CityGML unmarshal(JAXBElement<?> src) throws MissingADESchemaException {
		return unmarshal(src.getValue());
	}

	public CityGML unmarshal(Object src) throws MissingADESchemaException {
		if (src instanceof JAXBElement<?>)
			return unmarshal((JAXBElement<?>)src);

		CityGML dest = null;

		if (src instanceof GenericCityObjectType)
			dest = unmarshalGenericCityObject((GenericCityObjectType)src);
		else if (src instanceof DateAttributeType)
			dest = unmarshalDateAttribute((DateAttributeType)src);
		else if (src instanceof DoubleAttributeType)
			dest = unmarshalDoubleAttribute((DoubleAttributeType)src);
		else if (src instanceof GenericAttributeSetType)
			dest = unmarshalGenericAttributeSet((GenericAttributeSetType)src);
		else if (src instanceof IntAttributeType)
			dest = unmarshalIntAttribute((IntAttributeType)src);
		else if (src instanceof MeasureAttributeType)
			dest = unmarshalMeasureAttribute((MeasureAttributeType)src);
		else if (src instanceof StringAttributeType)
			dest = unmarshalStringAttribute((StringAttributeType)src);
		else if (src instanceof UriAttributeType)
			dest = unmarshalUriAttribute((UriAttributeType)src);

		return dest;
	}

	public void unmarshalAbstractGenericAttribute(AbstractGenericAttributeType src, AbstractGenericAttribute dest) {
		if (src.isSetName())
			dest.setName(src.getName());
	}

	public void unmarshalGenericCityObject(GenericCityObjectType src, GenericCityObject dest) throws MissingADESchemaException {
		citygml.getCore200Unmarshaller().unmarshalAbstractCityObject(src, dest);

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

		if (src.isSetLod0Geometry())
			dest.setLod0Geometry(jaxb.getGMLUnmarshaller().unmarshalGeometryProperty(src.getLod0Geometry()));

		if (src.isSetLod1Geometry())
			dest.setLod1Geometry(jaxb.getGMLUnmarshaller()
					.unmarshalGeometryProperty(src.getLod1Geometry()));

		if (src.isSetLod2Geometry())
			dest.setLod2Geometry(jaxb.getGMLUnmarshaller()
					.unmarshalGeometryProperty(src.getLod2Geometry()));

		if (src.isSetLod3Geometry())
			dest.setLod3Geometry(jaxb.getGMLUnmarshaller()
					.unmarshalGeometryProperty(src.getLod3Geometry()));

		if (src.isSetLod4Geometry())
			dest.setLod4Geometry(jaxb.getGMLUnmarshaller()
					.unmarshalGeometryProperty(src.getLod4Geometry()));

		if (src.isSetLod0ImplicitRepresentation())
			dest.setLod0ImplicitRepresentation(citygml.getCore200Unmarshaller()
					.unmarshalImplicitRepresentationProperty(
							src.getLod0ImplicitRepresentation()));

		if (src.isSetLod1ImplicitRepresentation())
			dest.setLod1ImplicitRepresentation(citygml.getCore200Unmarshaller()
					.unmarshalImplicitRepresentationProperty(
							src.getLod1ImplicitRepresentation()));

		if (src.isSetLod2ImplicitRepresentation())
			dest.setLod2ImplicitRepresentation(citygml.getCore200Unmarshaller()
					.unmarshalImplicitRepresentationProperty(
							src.getLod2ImplicitRepresentation()));

		if (src.isSetLod3ImplicitRepresentation())
			dest.setLod3ImplicitRepresentation(citygml.getCore200Unmarshaller()
					.unmarshalImplicitRepresentationProperty(
							src.getLod3ImplicitRepresentation()));

		if (src.isSetLod4ImplicitRepresentation())
			dest.setLod4ImplicitRepresentation(citygml.getCore200Unmarshaller()
					.unmarshalImplicitRepresentationProperty(
							src.getLod4ImplicitRepresentation()));

		if (src.isSetLod0TerrainIntersection())
			dest.setLod0TerrainIntersection(jaxb.getGMLUnmarshaller()
					.unmarshalMultiCurveProperty(
							src.getLod0TerrainIntersection()));

		if (src.isSetLod1TerrainIntersection())
			dest.setLod1TerrainIntersection(jaxb.getGMLUnmarshaller()
					.unmarshalMultiCurveProperty(
							src.getLod1TerrainIntersection()));

		if (src.isSetLod2TerrainIntersection())
			dest.setLod2TerrainIntersection(jaxb.getGMLUnmarshaller()
					.unmarshalMultiCurveProperty(
							src.getLod2TerrainIntersection()));

		if (src.isSetLod3TerrainIntersection())
			dest.setLod3TerrainIntersection(jaxb.getGMLUnmarshaller()
					.unmarshalMultiCurveProperty(
							src.getLod3TerrainIntersection()));

		if (src.isSetLod4TerrainIntersection())
			dest.setLod4TerrainIntersection(jaxb.getGMLUnmarshaller()
					.unmarshalMultiCurveProperty(
							src.getLod4TerrainIntersection()));
	}

	public GenericCityObject unmarshalGenericCityObject(GenericCityObjectType src) throws MissingADESchemaException {
		GenericCityObject dest = new GenericCityObject(module);
		unmarshalGenericCityObject(src, dest);

		return dest;
	}

	public void unmarshalDateAttribute(DateAttributeType src, DateAttribute dest) {
		unmarshalAbstractGenericAttribute(src, dest);

		if (src.isSetValue())
			dest.setValue(src.getValue().toGregorianCalendar());
	}

	public DateAttribute unmarshalDateAttribute(DateAttributeType src) {
		DateAttribute dest = new DateAttribute(module);
		unmarshalDateAttribute(src, dest);

		return dest;		
	}

	public void unmarshalGenericAttributeSet(GenericAttributeSetType src, GenericAttributeSet dest) throws MissingADESchemaException {
		unmarshalAbstractGenericAttribute(src, dest);

		if (src.isSet_GenericAttribute()) {
			for (JAXBElement<? extends AbstractGenericAttributeType> elem : src.get_GenericAttribute()) {				
				ModelObject object = jaxb.unmarshal(elem);
				if (object instanceof AbstractGenericAttribute)
					dest.addGenericAttribute((AbstractGenericAttribute)object);
			}
		}
	}

	public GenericAttributeSet unmarshalGenericAttributeSet(GenericAttributeSetType src) throws MissingADESchemaException {
		GenericAttributeSet dest = new GenericAttributeSet(module);
		unmarshalGenericAttributeSet(src, dest);

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

	public void unmarshalMeasureAttribute(MeasureAttributeType src, MeasureAttribute dest) {
		unmarshalAbstractGenericAttribute(src, dest);

		if (src.isSetValue())
			dest.setValue(jaxb.getGMLUnmarshaller().unmarshalMeasure(src.getValue()));
	}

	public MeasureAttribute unmarshalMeasureAttribute(MeasureAttributeType src) {
		MeasureAttribute dest = new MeasureAttribute(module);
		unmarshalMeasureAttribute(src, dest);

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
