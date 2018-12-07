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

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.TINReliefType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.ade.ExtensionAttribute;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.util.mapper.BiFunctionTypeMapper;

public class ReliefMarshaller {
	private final CityJSONMarshaller json;
	private final CityGMLMarshaller citygml;
	private final BiFunctionTypeMapper<CityJSON, AbstractCityObjectType> typeMapper;
	
	public ReliefMarshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONMarshaller();
		
		typeMapper = BiFunctionTypeMapper.<CityJSON, AbstractCityObjectType>create()
				.with(ReliefFeature.class, this::marshalReliefFeature)
				.with(TINRelief.class, this::marshalTINRelief);
	}
	
	public AbstractCityObjectType marshal(ModelObject src, CityJSON cityJSON) {
		return typeMapper.apply(src, cityJSON);
	}
		
	public AbstractCityObjectType marshalReliefFeature(ReliefFeature src, CityJSON cityJSON) {
		if (src.isSetReliefComponent()) {
			for (ReliefComponentProperty property : src.getReliefComponent()) {
				if (property.isSetReliefComponent() && property.getReliefComponent() instanceof TINRelief)
					cityJSON.addCityObject(marshalTINRelief((TINRelief) property.getReliefComponent(), cityJSON));
			}
		}
		
		return null;
	}
	
	public void marshalTINRelief(TINRelief src, TINReliefType dest, CityJSON cityJSON) {
		citygml.getCoreMarshaller().marshalAbstractCityObject(src, dest, cityJSON);

		if (src.isSetGenericApplicationPropertyOfTinRelief()) {
			for (ADEComponent ade : src.getGenericApplicationPropertyOfTinRelief()) {
				if (ade instanceof ADEModelObject) {
					ExtensionAttribute attribute = json.getADEMarshaller().unmarshalExtensionAttribute((ADEModelObject) ade);
					if (attribute != null)
						dest.getAttributes().addExtensionAttribute(attribute.getName(), attribute.getValue());
				}
			}
		}
		
		if (src.isSetTin()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getTin());
			if (geometry != null) {
				geometry.setLod(src.getLod());
				dest.addGeometry(geometry);
			}
		}
	}
	
	public TINReliefType marshalTINRelief(TINRelief src, CityJSON cityJSON) {
		TINReliefType dest = new TINReliefType();
		marshalTINRelief(src, dest, cityJSON);
		
		return dest;
	}
	
}
