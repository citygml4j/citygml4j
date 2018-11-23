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
package org.citygml4j.builder.cityjson.marshal.citygml.generics;

import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.Attributes;
import org.citygml4j.binding.cityjson.feature.GenericCityObjectType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.binding.cityjson.geometry.GeometryInstanceType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
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

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericsMarshaller {
	private final CityJSONMarshaller json;
	private final CityGMLMarshaller citygml;

	public GenericsMarshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONMarshaller();
	}
	
	public List<AbstractCityObjectType> marshal(ModelObject src) {
		if (src instanceof GenericCityObject)
			return Collections.singletonList(marshalGenericCityObject((GenericCityObject)src));
		
		return Collections.emptyList();			
	}

	public void marshalGenericCityObject(GenericCityObject src, GenericCityObjectType dest) {
		Attributes attributes = new Attributes();
		citygml.getCoreMarshaller().marshalAbstractCityObject(src, dest, attributes);
		
		if (src.isSetClazz())
			attributes.setClazz(src.getClazz().getValue());

		if (src.isSetFunction()) {
			for (Code function : src.getFunction()) {
				if (function.isSetValue()) {
					attributes.setFunction(function.getValue());
					break;
				}
			}
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage()) {
				if (usage.isSetValue()) {
					attributes.setUsage(usage.getValue());
					break;
				}
			}
		}
		
		if (attributes.hasAttributes())
			dest.setAttributes(attributes);
		
		if (src.isSetLod0Geometry()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod0Geometry());
			if (geometry != null) {
				geometry.setLod(0);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod1Geometry()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1Geometry());
			if (geometry != null) {
				geometry.setLod(1);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod2Geometry()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2Geometry());
			if (geometry != null) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod3Geometry()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3Geometry());
			if (geometry != null) {
				geometry.setLod(3);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod0ImplicitRepresentation()) {
			GeometryInstanceType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod0ImplicitRepresentation(), 0);
			if (geometry != null)
				dest.addGeometry(geometry);
		}
		
		if (src.isSetLod1ImplicitRepresentation()) {
			GeometryInstanceType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod1ImplicitRepresentation(), 1);
			if (geometry != null)
				dest.addGeometry(geometry);
		}
		
		if (src.isSetLod2ImplicitRepresentation()) {
			GeometryInstanceType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod2ImplicitRepresentation(), 2);
			if (geometry != null)
				dest.addGeometry(geometry);
		}
		
		if (src.isSetLod3ImplicitRepresentation()) {
			GeometryInstanceType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation(), 3);
			if (geometry != null)
				dest.addGeometry(geometry);
		}
	}
	
	public GenericCityObjectType marshalGenericCityObject(GenericCityObject src) {
		GenericCityObjectType dest = new GenericCityObjectType(src.getId());
		marshalGenericCityObject(src, dest);
		
		return dest;
	}
	
	public void marshalGenericAttributes(List<AbstractGenericAttribute> src, Attributes dest) {
		for (AbstractGenericAttribute attribute : src) {
			Object value = marshalGenericAttribute(attribute);
			if (value != null)
				dest.addGenericAttribute(attribute.getName(), value);
		}
	}
	
	public void marshalSemanticsAttributes(List<AbstractGenericAttribute> src, SemanticsType dest) {
		for (AbstractGenericAttribute attribute : src) {
			Object value = marshalGenericAttribute(attribute);
			if (value != null)
				dest.addProperty(attribute.getName(), value);
		}
	}
	
	private Object marshalGenericAttribute(AbstractGenericAttribute src) {
		switch (src.getCityGMLClass()) {
			case DATE_ATTRIBUTE:
				return ((DateAttribute) src).getValue().format(DateTimeFormatter.ISO_LOCAL_DATE);
			case DOUBLE_ATTRIBUTE:
				return ((DoubleAttribute) src).getValue();
			case INT_ATTRIBUTE:
				return ((IntAttribute) src).getValue();
			case STRING_ATTRIBUTE:
				return ((StringAttribute) src).getValue();
			case URI_ATTRIBUTE:
				return ((UriAttribute) src).getValue();
			case MEASURE_ATTRIBUTE:
				return ((MeasureAttribute) src).getValue();
			case GENERIC_ATTRIBUTE_SET:
				GenericAttributeSet attributeSet = (GenericAttributeSet) src;
				boolean isObject = attributeSet.getGenericAttribute().stream().anyMatch(a -> !"item".equalsIgnoreCase(a.getName()));

				if (isObject) {
					Map<String, Object> result = new HashMap<>();
					for (AbstractGenericAttribute attribute : attributeSet.getGenericAttribute()) {
						Object value = marshalGenericAttribute(attribute);
						if (value != null)
							result.put(attribute.getName(), value);
					}

					return result;
				} else {
					List<Object> result = new ArrayList<>();
					for (AbstractGenericAttribute attribute : attributeSet.getGenericAttribute()) {
						Object value = marshalGenericAttribute(attribute);
						if (value != null)
							result.add(value);
					}

					return result;
				}
			default:
				return null;
		}
	}
	
}
