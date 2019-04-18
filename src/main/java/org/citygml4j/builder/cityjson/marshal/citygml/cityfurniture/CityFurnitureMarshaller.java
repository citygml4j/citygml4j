/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2019 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.builder.cityjson.marshal.citygml.cityfurniture;

import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.cityjson.feature.Attributes;
import org.citygml4j.cityjson.feature.CityFurnitureType;
import org.citygml4j.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.cityjson.geometry.GeometryInstanceType;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;

public class CityFurnitureMarshaller {
	private final CityJSONMarshaller json;
	private final CityGMLMarshaller citygml;
	
	public CityFurnitureMarshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONMarshaller();
	}
	
	public AbstractCityObjectType marshal(ModelObject src, CityJSON cityJSON) {
		if (src instanceof CityFurniture)
			return marshalCityFurniture((CityFurniture) src, cityJSON);
		
		return null;
	}
	
	public void marshalCityFurniture(CityFurniture src, CityFurnitureType dest, CityJSON cityJSON) {
		citygml.getCoreMarshaller().marshalAbstractCityObject(src, dest, cityJSON);

		Attributes attributes = dest.getAttributes();
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

		if (src.isSetGenericApplicationPropertyOfCityFurniture())
			json.getADEMarshaller().marshal(src.getGenericApplicationPropertyOfCityFurniture(), dest, cityJSON);
		
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
	
	public CityFurnitureType marshalCityFurniture(CityFurniture src, CityJSON cityJSON) {
		CityFurnitureType dest = new CityFurnitureType();
		marshalCityFurniture(src, dest, cityJSON);
		
		return dest;
	}
	
}
