package org.citygml4j.builder.json.objects.feature;

import java.lang.reflect.Type;
import java.util.List;
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
		List<String> attributeNames = attributes.getAttributeNames();
		
		JsonObject object = json.getAsJsonObject();
		for (Entry<String, JsonElement> entry : object.entrySet()) {
			String key = entry.getKey();
			if (attributeNames.contains(key))
				continue;
			
			JsonElement value = entry.getValue();
			if (value.isJsonPrimitive()) {
				JsonPrimitive primitive = entry.getValue().getAsJsonPrimitive();
				if (primitive != null) {
					if (primitive.isBoolean())
						attributes.addGenericAttribute(key, primitive.getAsBoolean());
					else if (primitive.isNumber())
						attributes.addGenericAttribute(key, primitive.getAsNumber());
					else if (primitive.isString())
						attributes.addGenericAttribute(key, primitive.getAsString());
					else
						attributes.addGenericAttribute(key, context.deserialize(primitive, Object.class));
				}
			} else
				attributes.addGenericAttribute(key, context.deserialize(value, Object.class));
		}

		return attributes;
	}

}
