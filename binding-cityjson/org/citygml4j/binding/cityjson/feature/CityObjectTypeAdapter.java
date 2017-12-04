package org.citygml4j.binding.cityjson.feature;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class CityObjectTypeAdapter implements JsonSerializer<AbstractCityObjectType>, JsonDeserializer<AbstractCityObjectType> {
	private final CityObjectTypeFilter typeFilter;
	
	public CityObjectTypeAdapter(CityObjectTypeFilter inputFilter) {
		this.typeFilter = inputFilter;
	}
	
	public CityObjectTypeAdapter() {
		this(null);
	}
	
	@Override
	public JsonElement serialize(AbstractCityObjectType cityObject, Type typeOfSrc, JsonSerializationContext context) {
		return (typeFilter == null || typeFilter.accept(cityObject.getType().getValue())) ? context.serialize(cityObject) : null;
	}

	@Override
	public AbstractCityObjectType deserialize(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
		AbstractCityObjectType cityObject = null;
		JsonObject object = json.getAsJsonObject();
		JsonPrimitive type = object.getAsJsonPrimitive("type");

		if (type != null && type.isString()) {
			CityObjectTypeName objectType = CityObjectTypeName.fromValue(type.getAsString());
			if (object != null && (typeFilter == null || typeFilter.accept(objectType.getValue())))
				cityObject = context.deserialize(object, objectType.getTypeClass());
		}
		
		return cityObject;
	}

}
