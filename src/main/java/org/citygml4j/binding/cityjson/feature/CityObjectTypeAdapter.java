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
package org.citygml4j.binding.cityjson.feature;

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
import java.util.Set;

public class CityObjectTypeAdapter implements JsonSerializer<AbstractCityObjectType>, JsonDeserializer<AbstractCityObjectType> {
	public static final String UNKNOWN_EXTENSION = "org.citygml4j.unknownExtension";

	private final CityJSONRegistry registry = CityJSONRegistry.getInstance();
	private final Map<String, List<String>> predefinedProperties = new HashMap<>();
	private final PropertyHelper propertyHelper = new PropertyHelper();

	private CityObjectTypeFilter typeFilter;
	private boolean processUnknownExtensions;

	public CityObjectTypeAdapter withTypeFilter(CityObjectTypeFilter inputFilter) {
		this.typeFilter = inputFilter;
		return this;
	}

	public CityObjectTypeAdapter processUnknownExtensions(boolean processUnknownExtensions) {
		this.processUnknownExtensions = processUnknownExtensions;
		return this;
	}
	
	@Override
	public JsonElement serialize(AbstractCityObjectType cityObject, Type typeOfSrc, JsonSerializationContext context) {
		if (typeFilter != null && !typeFilter.accept(cityObject.getType()))
			return null;

		if (cityObject.type == null)
			cityObject.type = CityJSONRegistry.getInstance().getCityObjectType(cityObject);

		JsonElement element = context.serialize(cityObject);
		if (element != null && element.isJsonObject()) {
			JsonObject result = element.getAsJsonObject();

			// serialize extension properties
			if (cityObject.isSetExtensionProperties()) {
				JsonObject properties = context.serialize(cityObject.getExtensionProperties()).getAsJsonObject();
				for (Map.Entry<String, JsonElement> entry : properties.entrySet())
					result.add(entry.getKey(), entry.getValue());
			}

			if (cityObject.attributes != null) {
				JsonObject object = result.getAsJsonObject().getAsJsonObject("attributes");

				// serialize extension attributes
				if (cityObject.attributes.isSetExtensionAttributes()) {
					JsonObject attributes = context.serialize(cityObject.attributes.getExtensionAttributes()).getAsJsonObject();
					for (Map.Entry<String, JsonElement> entry : attributes.entrySet())
						object.add(entry.getKey(), entry.getValue());
				}

				// remove empty attributes
				if (object.entrySet().isEmpty())
					result.getAsJsonObject().remove("attributes");
			}
		}

		return element;
	}

	@Override
	public AbstractCityObjectType deserialize(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		JsonObject object = json.getAsJsonObject();
		JsonPrimitive type = object.getAsJsonPrimitive("type");

		if (type != null && type.isString()) {
			Class<?> typeClass = registry.getCityObjectClass(type.getAsString());

			// map unknown extensions to generic city objects
			boolean unknownExtension = false;
			if (typeClass == null && processUnknownExtensions) {
				typeClass = GenericCityObjectType.class;
				unknownExtension = true;
			}

			if (typeClass != null && (typeFilter == null || typeFilter.accept(type.getAsString()))) {
				AbstractCityObjectType cityObject = context.deserialize(object, typeClass);
				cityObject.type = type.getAsString();

				// deserialize extension properties
				Map<String, Object> extensionProperties = deserialize(object.entrySet(), typeClass, cityObject, context);
				if (!extensionProperties.isEmpty())
					cityObject.setExtensionProperties(extensionProperties);

				if (cityObject.attributes != null) {
					JsonObject attributes = object.get("attributes").getAsJsonObject();

					Class<?> attributesClass = cityObject.getAttributesClass();
					if (attributesClass != Attributes.class)
						cityObject.attributes = context.deserialize(attributes, attributesClass);

					// deserialize extension attributes
					Map<String, Object> extensionAttributes = deserialize(attributes.entrySet(), attributesClass, cityObject, context);
					if (!extensionAttributes.isEmpty())
						cityObject.attributes.setExtensionAttributes(extensionAttributes);
				}

				if (unknownExtension)
					cityObject.setLocalProperty(UNKNOWN_EXTENSION, true);

				return cityObject;
			}
		}
		
		return null;
	}

	private Map<String, Object> deserialize(Set<Map.Entry<String, JsonElement>> entrySet, Class<?> typeClass, AbstractCityObjectType cityObject, JsonDeserializationContext context) {
		Map<String, Object> properties = new HashMap<>();
		List<String> predefined = predefinedProperties.computeIfAbsent(
				typeClass.getTypeName(),
				v -> propertyHelper.getDeclaredProperties(typeClass));

		for (Map.Entry<String, JsonElement> entry : entrySet) {
			// skip properties defined by the type class
			String key = entry.getKey();
			if (predefined.contains(key))
				continue;

			// check whether we found a registered extension property
			Type extensionAttributeType = registry.getExtensionPropertyClass(entry.getKey(), cityObject);
			Object value = extensionAttributeType != null ?
					context.deserialize(entry.getValue(), extensionAttributeType) :
					propertyHelper.deserialize(entry.getValue());

			if (value != null)
				properties.put(key, value);
		}

		return properties;
	}
}
