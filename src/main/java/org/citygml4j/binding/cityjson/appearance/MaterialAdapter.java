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
package org.citygml4j.binding.cityjson.appearance;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Map.Entry;

public class MaterialAdapter implements JsonSerializer<Map<String, AbstractMaterialObject>>, JsonDeserializer<Map<String, AbstractMaterialObject>> {

	@Override
	public JsonElement serialize(Map<String, AbstractMaterialObject> material, Type typeOfSrc, JsonSerializationContext context) {
		return context.serialize(material);
	}

	@Override
	public Map<String, AbstractMaterialObject> deserialize(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		Map<String, AbstractMaterialObject> material = context.deserialize(json, typeOfSrc);
		for (Entry<String, AbstractMaterialObject> entry : material.entrySet())
			entry.getValue().theme = entry.getKey();

		return material;
	}
	
}
