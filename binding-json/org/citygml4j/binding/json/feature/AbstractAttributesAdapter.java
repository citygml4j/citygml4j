package org.citygml4j.binding.json.feature;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

public abstract class AbstractAttributesAdapter<T extends Attributes> implements JsonSerializer<T>, JsonDeserializer<T> {
	private final Class<T> type;
	private final SimpleDateFormat formatter;
	
	protected AbstractAttributesAdapter(Class<T> type) {
		this.type = type;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
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
		Map<String, Object> genericAttributes = deserialize(json.getAsJsonObject(), attributes.getAttributeNames(), context);
		if (!genericAttributes.isEmpty())
			attributes.setGenericAttributes(genericAttributes);
		
		return attributes;
	}
	
	private Map<String, Object> deserialize(JsonObject object, List<String> attributeNames, JsonDeserializationContext context) {
		Map<String, Object> genericAttributes = new HashMap<>();
		
		for (Entry<String, JsonElement> entry : object.entrySet()) {
			String key = entry.getKey();
			if (attributeNames.contains(key))
				continue;
			
			JsonElement element = entry.getValue();
			if (element.isJsonPrimitive()) {
				JsonPrimitive primitive = element.getAsJsonPrimitive();
				if (primitive != null) {
					if (primitive.isBoolean())
						genericAttributes.put(key, primitive.getAsBoolean());
					else if (primitive.isNumber()) {
						Number value = primitive.getAsNumber();						
						if (value.intValue() == value.doubleValue())
							genericAttributes.put(key, value.intValue());	
						else
							genericAttributes.put(key, value.doubleValue());
					} else if (primitive.isString()) {
						String value = primitive.getAsString();
						try {
							Date date = formatter.parse(value);
							genericAttributes.put(key, date);
						} catch (ParseException e) {
							genericAttributes.put(key, value);
						}
					} else
						genericAttributes.put(key, context.deserialize(primitive, Object.class));
				}
			} else {
				Map<String, Object> attributeSet = deserialize(element.getAsJsonObject(), attributeNames, context);
				if (!attributeSet.isEmpty())
					genericAttributes.put(key, attributeSet);
			}
		}
		
		return genericAttributes;
	}

}
