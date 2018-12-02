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
import org.citygml4j.binding.cityjson.CityJSONRegistry;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityObjectTypeAdapter implements JsonSerializer<AbstractCityObjectType>, JsonDeserializer<AbstractCityObjectType> {
	private final CityJSONRegistry registry = CityJSONRegistry.getInstance();
	private CityObjectTypeFilter typeFilter;
	
	public CityObjectTypeAdapter withTypeFilter(CityObjectTypeFilter inputFilter) {
		this.typeFilter = inputFilter;
		return this;
	}
	
	@Override
	public JsonElement serialize(AbstractCityObjectType cityObject, Type typeOfSrc, JsonSerializationContext context) {
		if (typeFilter != null && !typeFilter.accept(cityObject.getType()))
			return null;

		if (cityObject.type == null)
			cityObject.type = CityJSONRegistry.getInstance().getCityObjectType(cityObject);

		if (cityObject.attributes != null && !cityObject.attributes.hasAttributes())
			cityObject.attributes = null;

		JsonElement result = context.serialize(cityObject);

		if (result != null && cityObject.attributes != null) {
			JsonObject object = result.getAsJsonObject().getAsJsonObject("attributes");

			// serialize extension attributes
			if (cityObject.attributes.isSetExtensionAttributes()) {
				JsonObject attributes = context.serialize(cityObject.attributes.getExtensionAttributes()).getAsJsonObject();
				for (Map.Entry<String, JsonElement> entry : attributes.entrySet())
					object.add(entry.getKey(), entry.getValue());
			}

			// serialize generic attributes
			if (cityObject.attributes.isSetGenericAttributes()) {
				JsonObject attributes = context.serialize(cityObject.attributes.getGenericAttributes()).getAsJsonObject();
				for (Map.Entry<String, JsonElement> entry : attributes.entrySet())
					object.add(entry.getKey(), entry.getValue());
			}
		}

		return result;
	}

	@Override
	public AbstractCityObjectType deserialize(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		AbstractCityObjectType cityObject = null;
		JsonObject object = json.getAsJsonObject();
		JsonPrimitive type = object.getAsJsonPrimitive("type");

		if (type != null && type.isString()) {
			Class<?> typeClass = registry.getCityObjectClass(type.getAsString());
			if (typeClass != null && (typeFilter == null || typeFilter.accept(type.getAsString()))) {
				cityObject = context.deserialize(object, typeClass);
				cityObject.type = type.getAsString();

				if (cityObject.attributes != null) {
					JsonObject attributes = object.get("attributes").getAsJsonObject();

					Class<?> attributesClass = cityObject.getAttributesClass();
					if (attributesClass != Attributes.class)
						cityObject.attributes = context.deserialize(attributes, attributesClass);

					// deserialize generic attributes
					Map<String, Object> genericAttributes = new HashMap<>();
					List<String> predefined = cityObject.attributes.getAttributeNames();

					for (Map.Entry<String, JsonElement> entry : attributes.entrySet()) {
						// skip attributes defined by the city object type
						String key = entry.getKey();
						if (predefined.contains(key))
							continue;

						// check whether we found a registered extension attribute
						if (entry.getKey().startsWith("+")) {
							Type extensionAttributeType = registry.getExtensionAttributeClass(entry.getKey(), cityObject);
							if (extensionAttributeType != null) {
								Object value = context.deserialize(entry.getValue(), extensionAttributeType);
								if (value != null) {
									cityObject.attributes.addExtensionAttribute(entry.getKey(), value);
									continue;
								}
							}
						}

						// otherwise, map the attribute to a generic attribute
						Object value = deserialize(entry.getValue(), context);
						if (value != null)
							genericAttributes.put(key, value);
					}

					if (!genericAttributes.isEmpty())
						cityObject.attributes.setGenericAttributes(genericAttributes);
				}

			}
		}
		
		return cityObject;
	}

	private Object deserialize(JsonElement element, JsonDeserializationContext context) {
		if (element.isJsonPrimitive()) {
			JsonPrimitive primitive = element.getAsJsonPrimitive();
			if (primitive.isBoolean())
				return primitive.getAsBoolean();
			else if (primitive.isNumber()) {
				Number value = primitive.getAsNumber();
				if (value.toString().equals(String.valueOf(value.intValue())))
					return value.intValue();
				else
					return value.doubleValue();
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
