/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.Attributes;
import org.citygml4j.binding.cityjson.feature.GenericCityObjectType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.binding.cityjson.geometry.GeometryTypeName;
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
		
		Map<Integer, GeometryTypeName> geometryTypes = new HashMap<>();
		if (src.isSetLod0Geometry()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod0Geometry());
			if (geometry != null) {
				geometry.setLod(0);
				dest.addGeometry(geometry);
				geometryTypes.put(0, geometry.getType());
			}
		}
		
		if (src.isSetLod1Geometry()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1Geometry());
			if (geometry != null) {
				geometry.setLod(1);
				dest.addGeometry(geometry);
				geometryTypes.put(1, geometry.getType());
			}
		}
		
		if (src.isSetLod2Geometry()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2Geometry());
			if (geometry != null) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
				geometryTypes.put(2, geometry.getType());
			}
		}
		
		if (src.isSetLod3Geometry()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3Geometry());
			if (geometry != null) {
				geometry.setLod(3);
				dest.addGeometry(geometry);
				geometryTypes.put(3, geometry.getType());
			}
		}
		
		if (src.isSetLod0ImplicitRepresentation()) {
			AbstractGeometryObjectType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod0ImplicitRepresentation());
			if (geometry != null && geometryTypes.get(0) != geometry.getType()) {
				geometry.setLod(0);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod1ImplicitRepresentation()) {
			AbstractGeometryObjectType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod1ImplicitRepresentation());
			if (geometry != null && geometryTypes.get(1) != geometry.getType()) {
				geometry.setLod(1);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod2ImplicitRepresentation()) {
			AbstractGeometryObjectType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod2ImplicitRepresentation());
			if (geometry != null && geometryTypes.get(2) != geometry.getType()) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod3ImplicitRepresentation()) {
			AbstractGeometryObjectType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation());
			if (geometry != null && geometryTypes.get(3) != geometry.getType()) {
				geometry.setLod(3);
				dest.addGeometry(geometry);
			}
		}
	}
	
	public GenericCityObjectType marshalGenericCityObject(GenericCityObject src) {
		GenericCityObjectType dest = new GenericCityObjectType(src.getId());
		marshalGenericCityObject(src, dest);
		
		return dest;
	}
	
	public void marshalGenericAttributes(List<AbstractGenericAttribute> src, Attributes dest) {
		Map<String, Object> attributes = marshalGenericAttributes(src);
		if (!attributes.isEmpty()) {
			for (Entry<String, Object> entry : attributes.entrySet())
				dest.addGenericAttribute(entry.getKey(), entry.getValue());
		}
	}
	
	public void marshalSemanticsAttributes(List<AbstractGenericAttribute> src, SemanticsType dest) {
		Map<String, Object> attributes = marshalGenericAttributes(src);
		if (!attributes.isEmpty()) {
			for (Entry<String, Object> entry : attributes.entrySet())
				dest.addProperty(entry.getKey(), entry.getValue());
		}
	}
	
	private Map<String, Object> marshalGenericAttributes(List<AbstractGenericAttribute> src) {
		Map<String, Object> attributes = new LinkedHashMap<>();
		
		for (AbstractGenericAttribute attribute : src) {
			String name = attribute.getName();
			Object value = null;
			
			switch (attribute.getCityGMLClass()) {
			case DATE_ATTRIBUTE:
				value = ((DateAttribute)attribute).getValue().getTime();
				break;
			case DOUBLE_ATTRIBUTE:
				value = ((DoubleAttribute)attribute).getValue();
				break;
			case INT_ATTRIBUTE:
				value = ((IntAttribute)attribute).getValue();
				break;
			case STRING_ATTRIBUTE:
				value = ((StringAttribute)attribute).getValue();
				break;
			case URI_ATTRIBUTE:
				value = ((UriAttribute)attribute).getValue();
				break;
			case MEASURE_ATTRIBUTE:
				value = ((MeasureAttribute)attribute).getValue();
				break;
			case GENERIC_ATTRIBUTE_SET:
				value = marshalGenericAttributes(((GenericAttributeSet)attribute).getGenericAttribute());
				break;
			default:
				break;
			}
			
			if (name != null && value != null)
				attributes.put(name, value);
		}
		
		return attributes;
	}
	
}
