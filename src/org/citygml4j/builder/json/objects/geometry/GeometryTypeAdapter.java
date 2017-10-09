package org.citygml4j.builder.json.objects.geometry;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GeometryTypeAdapter implements JsonSerializer<AbstractGeometryType>, JsonDeserializer<AbstractGeometryType> {

	@Override
	public JsonElement serialize(AbstractGeometryType geometryObject, Type typeOfSrc, JsonSerializationContext context) {
		return context.serialize(geometryObject, geometryObject.getClass());
	}

	@Override
	public AbstractGeometryType deserialize(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		AbstractGeometryType geometryObject = null;
		JsonObject object = json.getAsJsonObject();
		JsonPrimitive type = object.getAsJsonPrimitive("type");

		if (type != null) {
			GeometryTypeName geometryType = GeometryTypeName.fromValue(type.getAsString());
			if (object != null)
				geometryObject = context.deserialize(json, geometryType.getTypeClass());
		}

		return geometryObject;
	}

}
