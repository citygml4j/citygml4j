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
package org.citygml4j.binding.cityjson.feature;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class CityObjectTypeAdapter implements JsonSerializer<AbstractCityObjectType>, JsonDeserializer<AbstractCityObjectType> {
	private final CityObjectTypeFilter typeFilter;
	
	public CityObjectTypeAdapter(CityObjectTypeFilter inputFilter) {
		this.typeFilter = inputFilter;
	}
	
	public CityObjectTypeAdapter() {
		this(null);
	}
	
	@Override
	public JsonElement serialize(AbstractCityObjectType cityObject, Type typeOfSrc, JsonSerializationContext context) {
		return (typeFilter == null || typeFilter.accept(cityObject.getType().getValue())) ? context.serialize(cityObject) : null;
	}

	@Override
	public AbstractCityObjectType deserialize(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		AbstractCityObjectType cityObject = null;
		JsonObject object = json.getAsJsonObject();
		JsonPrimitive type = object.getAsJsonPrimitive("type");

		if (type != null && type.isString()) {
			CityObjectTypeName objectType = CityObjectTypeName.fromValue(type.getAsString());
			if (object != null && (typeFilter == null || typeFilter.accept(objectType.getValue())))
				cityObject = context.deserialize(object, objectType.getTypeClass());
		}
		
		return cityObject;
	}

}
