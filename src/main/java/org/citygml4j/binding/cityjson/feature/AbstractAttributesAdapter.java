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
package org.citygml4j.binding.cityjson.feature;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class AbstractAttributesAdapter<T extends Attributes> implements JsonSerializer<T>, JsonDeserializer<T> {
	private final Class<T> type;

	protected AbstractAttributesAdapter(Class<T> type) {
		this.type = type;
	}
	
	@Override
	public JsonElement serialize(T cityGMLAttributes, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject object = context.serialize(cityGMLAttributes).getAsJsonObject();
		
		// serialize generic attributes
		if (cityGMLAttributes.isSetGenericAttributes()) {
			JsonObject properties = context.serialize(cityGMLAttributes.getGenericAttributes()).getAsJsonObject();
			for (Entry<String, JsonElement> entry : properties.entrySet())
				object.add(entry.getKey(), entry.getValue());
		}
		
		return object;
	}
	
	@Override
	public T deserialize(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		T attributes = context.deserialize(json, type);

		// deserialize generic attributes
		Map<String, Object> genericAttributes = new HashMap<>();
		List<String> predefined = attributes.getAttributeNames();

		for (Entry<String, JsonElement> entry : json.getAsJsonObject().entrySet()) {
			String key = entry.getKey();
			if (predefined.contains(key))
				continue;

			Object value = deserialize(entry.getValue(), context);
			if (value != null)
				genericAttributes.put(key, value);
		}

		if (!genericAttributes.isEmpty())
			attributes.setGenericAttributes(genericAttributes);
		
		return attributes;
	}

	private Object deserialize(JsonElement element, JsonDeserializationContext context) {
		if (element.isJsonPrimitive()) {
			JsonPrimitive primitive = element.getAsJsonPrimitive();
			if (primitive.isBoolean())
				return primitive.getAsBoolean();
			else if (primitive.isNumber()) {
				Number value = primitive.getAsNumber();
				return (value.toString().equals(String.valueOf(value.intValue()))) ? value.intValue() : value.doubleValue();
			} else if (primitive.isString()) {
				String value = primitive.getAsString();
				try {
					return LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE);
				} catch (DateTimeParseException e) {
					return value;
				}
			} else
				return context.deserialize(primitive, Object.class);
		} else if (element.isJsonObject()) {
			JsonObject object = element.getAsJsonObject();
			Map<String, Object> attributeSet = new HashMap<>();

			for (Map.Entry<String, JsonElement> nested : object.entrySet()) {
				Object value = deserialize(nested.getValue(), context);
				if (value != null)
					attributeSet.put(nested.getKey(), value);
			}

			if (!attributeSet.isEmpty())
				return attributeSet;
		} else if (element.isJsonArray()) {
			JsonArray array = element.getAsJsonArray();
			List<Object> items = new ArrayList<>();

			for (int i = 0; i < array.size(); i++) {
				Object value = deserialize(array.get(i), context);
				if (value != null)
					items.add(value);
			}

			if (!items.isEmpty())
				return items;
		}

		return null;
	}

}
