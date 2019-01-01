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
import com.google.gson.reflect.TypeToken;
import org.citygml4j.binding.cityjson.CityJSONRegistry;
import org.citygml4j.binding.cityjson.util.PropertyHelper;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SemanticsTypeAdapter implements JsonSerializer<SemanticsType>, JsonDeserializer<SemanticsType> {
	private final Map<String, List<String>> predefinedAttributes = new HashMap<>();
	private final PropertyHelper propertyHelper = new PropertyHelper();

	@Override
	public JsonElement serialize(SemanticsType semantics, Type typeOfSrc, JsonSerializationContext context) {
		if (semantics == null)
			return null;

		if (semantics.type == null)
			semantics.type = CityJSONRegistry.getInstance().getSemanticSurfaceType(semantics);

		JsonObject object = null;
		if (semantics.type.startsWith("+")) {
			Class<?> semanticsTypeClass = CityJSONRegistry.getInstance().getSemanticSurfaceClass(semantics.type);
			if (semanticsTypeClass != null && semanticsTypeClass != SemanticsType.class) {
				JsonElement element = context.serialize(semantics, semanticsTypeClass);
				if (element != null && element.isJsonObject())
					object = element.getAsJsonObject();
			}
		}

		if (object == null)
			object = new JsonObject();

		object.add("type", new JsonPrimitive(semantics.type));

		if (semantics.isSetParent())
			object.add("parent", new JsonPrimitive(semantics.getParent()));

		if (semantics.isSetChildren())
			object.add("children", context.serialize(semantics.getChildren()));

		// serialize properties
		if (semantics.isSetAttributes()) {
			JsonObject properties = context.serialize(semantics.getAttributes()).getAsJsonObject();
			for (Entry<String, JsonElement> entry : properties.entrySet())
				object.add(entry.getKey(), entry.getValue());
		}

		return object;
	}

	@Override
	public SemanticsType deserialize(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		SemanticsType semantics = null;
		JsonObject object = json.getAsJsonObject();
		JsonPrimitive type = object.getAsJsonPrimitive("type");

		if (type != null && type.isString()) {
			if (type.getAsString().startsWith("+")) {
				Class<?> semanticsTypeClass = CityJSONRegistry.getInstance().getSemanticSurfaceClass(type.getAsString());
				if (semanticsTypeClass != null) {
					semantics = context.deserialize(object, semanticsTypeClass);
					semantics.type = type.getAsString();
				}
			} else
				semantics = new SemanticsType(type.getAsString());

			if (semantics != null) {
				Number parent = context.deserialize(object.get("parent"), Integer.class);
				if (parent != null)
					semantics.setParent(parent.intValue());

				List<Integer> children = context.deserialize(object.get("children"), new TypeToken<List<Integer>>(){}.getType());
				if (children != null)
					semantics.setChildren(children);

				// deserialize properties
				Map<String, Object> properties = new HashMap<>();
				List<String> predefined = predefinedAttributes.get(semantics.getClass().getTypeName());
				if (predefined == null) {
					predefined = propertyHelper.getDeclaredProperties(semantics.getClass());
					predefinedAttributes.put(semantics.getClass().getTypeName(), predefined);
				}

				for (Entry<String, JsonElement> entry : object.entrySet()) {
					String key = entry.getKey();
					if (predefined.contains(key))
						continue;

					Object value = propertyHelper.deserialize(entry.getValue(), context);
					if (value != null)
						properties.put(key, value);
				}

				if (!properties.isEmpty())
					semantics.setAttributes(properties);
			}
		}

		return semantics;
	}
}
