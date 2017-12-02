package org.citygml4j.binding.cityjson.feature;

import java.lang.reflect.Type;

import org.citygml4j.builder.cityjson.json.io.reader.CityJSONInputFilter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class CityObjectTypeAdapter implements JsonSerializer<AbstractCityObjectType>, JsonDeserializer<AbstractCityObjectType> {
	private final CityJSONInputFilter inputFilter;
	
	public CityObjectTypeAdapter(CityJSONInputFilter inputFilter) {
		this.inputFilter = inputFilter;
	}
	
	public CityObjectTypeAdapter() {
		this(null);
	}
	
	@Override
	public JsonElement serialize(AbstractCityObjectType cityObject, Type typeOfSrc, JsonSerializationContext context) {
		return context.serialize(cityObject);
	}

	@Override
	public AbstractCityObjectType deserialize(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		AbstractCityObjectType cityObject = null;
		JsonObject object = json.getAsJsonObject();
		JsonPrimitive type = object.getAsJsonPrimitive("type");

		if (type != null && type.isString()) {
			CityObjectTypeName objectType = CityObjectTypeName.fromValue(type.getAsString());
			if (object != null && (inputFilter == null || inputFilter.accept(objectType.getValue())))
				cityObject = context.deserialize(object, objectType.getTypeClass());
		}
		
		return cityObject;
	}

}
