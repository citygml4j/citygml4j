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

public class GeometryObjectAdapter implements JsonSerializer<AbstractGeometryObject>, JsonDeserializer<AbstractGeometryObject> {

	@Override
	public JsonElement serialize(AbstractGeometryObject geometryObject, Type typeOfSrc, JsonSerializationContext context) {
		return context.serialize(geometryObject, geometryObject.getClass());
	}

	@Override
	public AbstractGeometryObject deserialize(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		AbstractGeometryObject geometryObject = null;
		JsonObject object = json.getAsJsonObject();
		JsonPrimitive type = object.getAsJsonPrimitive("type");

		if (type != null) {
			GeometryObjectType geometryType = GeometryObjectType.fromName(type.getAsString());
			if (object != null)
				geometryObject = context.deserialize(json, geometryType.getTypeClass());
		}

		return geometryObject;
	}

}
