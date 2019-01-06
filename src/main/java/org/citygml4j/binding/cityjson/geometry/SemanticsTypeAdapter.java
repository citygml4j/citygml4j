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
package org.citygml4j.binding.cityjson.geometry;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.citygml4j.binding.cityjson.CityJSONRegistry;
import org.citygml4j.binding.cityjson.util.PropertyHelper;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SemanticsTypeAdapter implements JsonSerializer<SemanticsType>, JsonDeserializer<SemanticsType> {
	private final CityJSONRegistry registry = CityJSONRegistry.getInstance();
	private final Map<String, List<String>> predefinedAttributes = new HashMap<>();
	private final PropertyHelper propertyHelper = new PropertyHelper();

	@Override
	public JsonElement serialize(SemanticsType semantics, Type typeOfSrc, JsonSerializationContext context) {
		if (semantics == null)
			return null;

		if (semantics.type == null)
			semantics.type = registry.getSemanticSurfaceType(semantics);

		Class<?> semanticsTypeClass = registry.getSemanticSurfaceClass(semantics.type);
		JsonElement element = context.serialize(semantics, semanticsTypeClass);
		if (element != null && element.isJsonObject()) {
			JsonObject object = element.getAsJsonObject();

			// serialize properties
			if (semantics.isSetAttributes()) {
				JsonObject properties = context.serialize(semantics.getAttributes()).getAsJsonObject();
				for (Entry<String, JsonElement> entry : properties.entrySet())
					object.add(entry.getKey(), entry.getValue());
			}
		}

		return element;
	}

	@Override
	public SemanticsType deserialize(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		JsonObject object = json.getAsJsonObject();
		JsonPrimitive type = object.getAsJsonPrimitive("type");

		if (type != null && type.isString()) {
			Class<?> semanticsTypeClass = registry.getSemanticSurfaceClass(type.getAsString());
			if (semanticsTypeClass != null) {
				SemanticsType semantics = context.deserialize(object, semanticsTypeClass);

				// deserialize properties
				List<String> predefined = predefinedAttributes.computeIfAbsent(semantics.getClass().getTypeName(),
						v -> propertyHelper.getDeclaredProperties(semantics.getClass()));

				for (Entry<String, JsonElement> entry : object.entrySet()) {
					String key = entry.getKey();
					if (predefined.contains(key))
						continue;

					Object value = propertyHelper.deserialize(entry.getValue());
					if (value != null)
						semantics.addAttribute(key, value);
				}

				return semantics;
			}
		}

		return null;
	}
}
