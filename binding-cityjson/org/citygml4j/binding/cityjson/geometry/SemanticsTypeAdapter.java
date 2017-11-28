package org.citygml4j.binding.cityjson.geometry;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class SemanticsTypeAdapter implements JsonSerializer<SemanticsType>, JsonDeserializer<SemanticsType> {
	private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public JsonElement serialize(SemanticsType semantics, Type typeOfSrc, JsonSerializationContext context) {
		if (semantics == null)
			return null;

		JsonObject object = new JsonObject();
		object.add("type", new JsonPrimitive(semantics.getType().getValue()));

		// serialize properties
		if (semantics.isSetProperties()) {
			JsonObject properties = context.serialize(semantics.getProperties()).getAsJsonObject();
			for (Entry<String, JsonElement> entry : properties.entrySet())
				object.add(entry.getKey(), entry.getValue());
		}

		return object;
	}

	@Override
	public SemanticsType deserialize(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		JsonObject object = json.getAsJsonObject();
		JsonPrimitive type = object.getAsJsonPrimitive("type");

		if (type != null) {		
			SemanticsTypeName semanticsType = SemanticsTypeName.fromValue(type.getAsString());
			if (semanticsType != null) {
				SemanticsType semantics = new SemanticsType(semanticsType);

				// deserialize properties
				Map<String, Object> properties = deserialize(object, context);
				if (!properties.isEmpty())
					semantics.setProperties(properties);
				
				return semantics;
			}
		}

		return null;
	}

	private Map<String, Object> deserialize(JsonObject object, JsonDeserializationContext context) {
		Map<String, Object> properties = new HashMap<>();
		
		for (Entry<String, JsonElement> entry : object.entrySet()) {
			String key = entry.getKey();					
			if (key.equals("type"))
				continue;
				
			JsonElement element = entry.getValue();
			if (element.isJsonPrimitive()) {
				JsonPrimitive primitive = element.getAsJsonPrimitive();
				if (primitive != null) {
					if (primitive.isBoolean())
						properties.put(key, primitive.getAsBoolean());
					else if (primitive.isNumber()) {
						Number value = primitive.getAsNumber();						
						if (value.intValue() == value.doubleValue())
							properties.put(key, value.intValue());	
						else
							properties.put(key, value.doubleValue());
					} else if (primitive.isString()) {
						String value = primitive.getAsString();
						try {
							Date date = formatter.parse(value);
							properties.put(key, date);
						} catch (ParseException e) {
							properties.put(key, value);
						}
					} else
						properties.put(key, context.deserialize(primitive, Object.class));
				}
			} else {
				Map<String, Object> propertySet = deserialize(element.getAsJsonObject(), context);
				if (!propertySet.isEmpty())
					properties.put(key, propertySet);
			}
		}
		
		return properties;
	}
	
}
