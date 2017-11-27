package org.citygml4j.binding.json.appearance;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class MaterialAdapter implements JsonSerializer<Map<String, AbstractMaterialObject>>, JsonDeserializer<Map<String, AbstractMaterialObject>> {

	@Override
	public JsonElement serialize(Map<String, AbstractMaterialObject> material, Type typeOfSrc, JsonSerializationContext context) {
		return context.serialize(material);
	}

	@Override
	public Map<String, AbstractMaterialObject> deserialize(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		Map<String, AbstractMaterialObject> material = context.deserialize(json, typeOfSrc);
		for (Entry<String, AbstractMaterialObject> entry : material.entrySet())
			entry.getValue().theme = entry.getKey();

		return material;
	}
	
}
