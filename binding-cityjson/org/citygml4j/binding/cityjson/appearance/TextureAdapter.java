package org.citygml4j.binding.cityjson.appearance;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class TextureAdapter implements JsonSerializer<Map<String, AbstractTextureObject>>, JsonDeserializer<Map<String, AbstractTextureObject>> {

	@Override
	public JsonElement serialize(Map<String, AbstractTextureObject> texture, Type typeOfSrc, JsonSerializationContext context) {
		return context.serialize(texture);
	}

	@Override
	public Map<String, AbstractTextureObject> deserialize(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		Map<String, AbstractTextureObject> texture = context.deserialize(json, typeOfSrc);
		for (Entry<String, AbstractTextureObject> entry : texture.entrySet())
			entry.getValue().theme = entry.getKey();

		return texture;
	}
	
}
