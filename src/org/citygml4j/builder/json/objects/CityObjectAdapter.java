package org.citygml4j.builder.json.objects;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class CityObjectAdapter implements JsonSerializer<AbstractCityObject>, JsonDeserializer<AbstractCityObject> {

	@Override
	public JsonElement serialize(AbstractCityObject cityObject, Type typeOfSrc, JsonSerializationContext context) {
		return context.serialize(cityObject, cityObject.getClass());
	}

	@Override
	public AbstractCityObject deserialize(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		AbstractCityObject cityObject = null;
		JsonObject object = json.getAsJsonObject();
		JsonPrimitive type = object.getAsJsonPrimitive("type");

		if (type != null) {
			CityObjectType objectType = CityObjectType.fromName(type.getAsString());
			if (object != null)
				cityObject = context.deserialize(json, objectType.getTypeClass());
		}

		return cityObject;
	}
	
}
