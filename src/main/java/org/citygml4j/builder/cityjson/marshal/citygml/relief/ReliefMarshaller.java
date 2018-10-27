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
package org.citygml4j.builder.cityjson.marshal.citygml.relief;

import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.Attributes;
import org.citygml4j.binding.cityjson.feature.TINReliefType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.util.mapper.TypeMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReliefMarshaller {
	private final CityJSONMarshaller json;
	private final CityGMLMarshaller citygml;
	private final TypeMapper<List<AbstractCityObjectType>> typeMapper;
	
	public ReliefMarshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONMarshaller();
		
		typeMapper = TypeMapper.<List<AbstractCityObjectType>>create()
				.with(ReliefFeature.class, this::marshalReliefFeature)
				.with(TINRelief.class, this::marshalTINRelief);
	}
	
	public List<AbstractCityObjectType> marshal(ModelObject src) {
		return typeMapper.apply(src);
	}
		
	public List<AbstractCityObjectType> marshalReliefFeature(ReliefFeature src) {
		List<AbstractCityObjectType> cityObjects = new ArrayList<>();
		if (src.isSetReliefComponent()) {
			for (ReliefComponentProperty property : src.getReliefComponent()) {
				if (property.isSetReliefComponent() && property.getReliefComponent() instanceof TINRelief)
					cityObjects.addAll(marshalTINRelief((TINRelief)property.getReliefComponent()));
			}
		}
		
		return cityObjects;
	}
	
	public void marshalTINRelief(TINRelief src, TINReliefType dest) {
		Attributes attributes = new Attributes();
		citygml.getCoreMarshaller().marshalAbstractCityObject(src, dest, attributes);
		
		if (attributes.hasAttributes())
			dest.setAttributes(attributes);
		
		if (src.isSetTin()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getTin());
			if (geometry != null) {
				geometry.setLod(src.getLod());
				dest.addGeometry(geometry);
			}
		}
	}
	
	public List<AbstractCityObjectType> marshalTINRelief(TINRelief src) {
		TINReliefType dest = new TINReliefType(src.getId());
		marshalTINRelief(src, dest);
		
		return Collections.singletonList(dest);
	}
	
}
