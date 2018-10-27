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
package org.citygml4j.builder.cityjson.unmarshal.citygml.generics;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.Attributes;
import org.citygml4j.binding.cityjson.feature.GenericCityObjectType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.binding.cityjson.geometry.GeometryInstanceType;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.generics.AbstractGenericAttribute;
import org.citygml4j.model.citygml.generics.DateAttribute;
import org.citygml4j.model.citygml.generics.DoubleAttribute;
import org.citygml4j.model.citygml.generics.GenericAttributeSet;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.generics.IntAttribute;
import org.citygml4j.model.citygml.generics.StringAttribute;
import org.citygml4j.model.citygml.generics.UriAttribute;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GenericsUnmarshaller {
	private final CityJSONUnmarshaller json;
	private final CityGMLUnmarshaller citygml;
	
	public GenericsUnmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONUnmarshaller();
	}
	
	public AbstractCityObject unmarshal(AbstractCityObjectType src, CityJSON cityJSON) {
		if (src instanceof GenericCityObjectType)
			return unmarshalGenericCityObject((GenericCityObjectType)src);
		
		return null;
	}
	
	public void unmarshalGenericCityObject(GenericCityObjectType src, GenericCityObject dest) {
		citygml.getCoreUnmarshaller().unmarshalAbstractCityObject(src, dest);
		
		if (src.isSetAttributes()) {
			Attributes attributes = src.getAttributes();
			if (attributes.isSetClazz())
				dest.setClazz(new Code(attributes.getClazz()));

			if (attributes.isSetFunction())
				dest.addFunction(new Code(attributes.getFunction()));

			if (attributes.isSetUsage())
				dest.addUsage(new Code(attributes.getUsage()));
		}
		
		for (AbstractGeometryType geometryType : src.getGeometry()) {
			if (geometryType instanceof AbstractGeometryObjectType) {
				AbstractGeometryObjectType geometryObject = (AbstractGeometryObjectType) geometryType;
				AbstractGeometry geometry = json.getGMLUnmarshaller().unmarshal(geometryObject, dest);

				if (geometry != null) {
					int lod = geometryObject.getLod().intValue();
					switch (lod) {
						case 0:
							dest.setLod0Geometry(new GeometryProperty<>(geometry));
							break;
						case 1:
							dest.setLod1Geometry(new GeometryProperty<>(geometry));
							break;
						case 2:
							dest.setLod2Geometry(new GeometryProperty<>(geometry));
							break;
						case 3:
							dest.setLod3Geometry(new GeometryProperty<>(geometry));
							break;
					}
				}
			} else if (geometryType instanceof GeometryInstanceType) {
				GeometryInstanceType geometryInstance = (GeometryInstanceType) geometryType;
				ImplicitGeometry geometry = citygml.getCoreUnmarshaller().unmarshalGeometryInstance(geometryInstance);

				if (geometry != null) {
					switch ((int) geometry.getLocalProperty(CityJSONUnmarshaller.GEOMETRY_INSTANCE_LOD)) {
						case 0:
							dest.setLod1ImplicitRepresentation(new ImplicitRepresentationProperty(geometry));
							break;
						case 1:
							dest.setLod1ImplicitRepresentation(new ImplicitRepresentationProperty(geometry));
							break;
						case 2:
							dest.setLod2ImplicitRepresentation(new ImplicitRepresentationProperty(geometry));
							break;
						case 3:
							dest.setLod3ImplicitRepresentation(new ImplicitRepresentationProperty(geometry));
							break;
					}
				}
			}
		}
	}
	
	public GenericCityObject unmarshalGenericCityObject(GenericCityObjectType src) {
		GenericCityObject dest = new GenericCityObject();
		unmarshalGenericCityObject(src, dest);
		
		return dest;
	}
	
	public void unmarshalGenericAttributes(Attributes src, AbstractCityObject dest) {
		List<AbstractGenericAttribute> genericAttributes = unmarshalGenericAttributes(src.getGenericAttributes());
		if (!genericAttributes.isEmpty())
			dest.setGenericAttribute(genericAttributes);
	}
	
	public void unmarshalSemanticsAttributes(Map<String, Object> src, AbstractCityObject dest) {
		List<AbstractGenericAttribute> genericAttributes = unmarshalGenericAttributes(src);
		if (!genericAttributes.isEmpty())
			dest.setGenericAttribute(genericAttributes);
	}
	
	private List<AbstractGenericAttribute> unmarshalGenericAttributes(Map<? extends Object, ? extends Object> src) {
		List<AbstractGenericAttribute> attributes = new ArrayList<>();
		
		for (Entry<? extends Object, ? extends Object> entry : src.entrySet()) {
			String name = entry.getKey().toString();
			Object value = entry.getValue();			
			AbstractGenericAttribute attribute = null;
			
			if (value instanceof Integer)
				attribute = new IntAttribute((Integer)value);
			else if (value instanceof Double)
				attribute = new DoubleAttribute((Double)value);
			else if (value instanceof Date)
				attribute = new DateAttribute((Date)value);
			else if (value instanceof String) {
				try {
					URI uri = new URI((String)value);
					if (uri.getScheme() != null && uri.getPath() != null) 
						attribute = new UriAttribute((String)value);
				} catch (URISyntaxException e) {
					// nothing to do
				}
				
				if (attribute == null)
					attribute = new StringAttribute((String)value);
			} else if (value instanceof Map<?, ?>) {
				List<AbstractGenericAttribute> attributeSet = unmarshalGenericAttributes((Map<?, ?>)value);
				if (!attributeSet.isEmpty())
					attribute = new GenericAttributeSet(attributeSet);
			} else
				attribute = new StringAttribute(value.toString());

			if (attribute != null) {
				attribute.setName(name);
				attributes.add(attribute);
			}
		}
		
		return attributes;
	}
	
}
