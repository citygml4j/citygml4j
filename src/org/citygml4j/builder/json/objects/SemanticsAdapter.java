package org.citygml4j.builder.json.objects;

import java.lang.reflect.Type;
import java.util.Map.Entry;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class SemanticsAdapter implements JsonSerializer<Semantics>, JsonDeserializer<Semantics> {

	@Override
	public JsonElement serialize(Semantics semantics, Type typeOfSrc, JsonSerializationContext context) {
		if (semantics == Semantics.EMPTY)
			return new JsonObject();

		JsonObject object = new JsonObject();
		object.add("type", new JsonPrimitive(semantics.getType().getName()));

		// serialize properties
		if (semantics.isSetProperties()) {
			JsonObject properties = context.serialize(semantics.getProperties()).getAsJsonObject();
			for (Entry<String, JsonElement> entry : properties.entrySet())
				object.add(entry.getKey(), entry.getValue());
		}

		return object;
	}

	@Override
	public Semantics deserialize(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		JsonObject object = json.getAsJsonObject();
		JsonPrimitive type = object.getAsJsonPrimitive("type");

		if (type != null) {		
			SemanticsType semanticsType = SemanticsType.fromName(type.getAsString());
			if (semanticsType != null) {
				Semantics semantics = new Semantics(semanticsType);

				// deserialize properties
				for (Entry<String, JsonElement> entry : object.entrySet()) {
					String key = entry.getKey();					
					if (key.equals("type"))
						continue;
						
					JsonElement value = entry.getValue();
					if (value.isJsonPrimitive()) {
						JsonPrimitive primitive = entry.getValue().getAsJsonPrimitive();
						if (primitive != null) {
							if (primitive.isBoolean())
								semantics.addProperty(key, primitive.getAsBoolean());
							else if (primitive.isNumber())
								semantics.addProperty(key, primitive.getAsNumber());
							else if (primitive.isString())
								semantics.addProperty(key, primitive.getAsString());
							else
								semantics.addProperty(key, context.deserialize(primitive, Object.class));
						}
					} else
						semantics.addProperty(key, context.deserialize(value, Object.class));	
				}

				return semantics;
			}
		}

		return Semantics.EMPTY;
	}

}
