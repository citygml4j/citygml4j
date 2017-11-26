package org.citygml4j.builder.json.objects.feature;

import java.lang.reflect.Type;
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
import com.google.gson.internal.LinkedTreeMap;

public class CityObjectsAdapter implements JsonSerializer<Map<String, AbstractCityObjectType>>, JsonDeserializer<Map<String, AbstractCityObjectType>> {

	@Override
	public JsonElement serialize(Map<String, AbstractCityObjectType> cityObjects, Type typeOfSrc, JsonSerializationContext context) {
		return context.serialize(cityObjects);
	}

	@Override
	public Map<String, AbstractCityObjectType> deserialize(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		Map<String, AbstractCityObjectType> cityObjects = new LinkedTreeMap<>();

		for (Entry<String, JsonElement> entry : json.getAsJsonObject().entrySet()) {
			JsonObject object = entry.getValue().getAsJsonObject();
			JsonPrimitive type = object.getAsJsonPrimitive("type");

			if (type != null) {
				CityObjectTypeName objectType = CityObjectTypeName.fromValue(type.getAsString());
				if (object != null) {
					AbstractCityObjectType cityObject = context.deserialize(object, objectType.getTypeClass());
					cityObject.gmlId = entry.getKey();					
					cityObjects.put(cityObject.gmlId, cityObject);
				}
			}
		}
		
		return cityObjects;
	}

}
