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

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.internal.LinkedTreeMap;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Map.Entry;

public class CityObjectsAdapter implements JsonSerializer<Map<String, AbstractCityObjectType>>, JsonDeserializer<Map<String, AbstractCityObjectType>> {

	@Override
	public JsonElement serialize(Map<String, AbstractCityObjectType> cityObjects, Type typeOfSrc, JsonSerializationContext context) {
		return context.serialize(cityObjects);
	}

	@Override
	public Map<String, AbstractCityObjectType> deserialize(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		Map<String, AbstractCityObjectType> cityObjects = new LinkedTreeMap<>();

		for (Entry<String, JsonElement> entry : json.getAsJsonObject().entrySet()) {
			JsonObject object = entry.getValue().getAsJsonObject();

			AbstractCityObjectType cityObject = context.deserialize(object, AbstractCityObjectType.class);
			if (cityObject != null) {
				cityObject.gmlId = entry.getKey();					
				cityObjects.put(cityObject.gmlId, cityObject);
			}
		}

		return cityObjects;
	}

}
