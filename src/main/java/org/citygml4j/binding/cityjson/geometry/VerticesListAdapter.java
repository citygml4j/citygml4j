package org.citygml4j.binding.cityjson.geometry;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class VerticesListAdapter implements JsonSerializer<VerticesList>, JsonDeserializer<VerticesList> {
	private boolean asInteger;
	
	public VerticesListAdapter serializeAsInteger(boolean asInteger) {
		this.asInteger = asInteger;
		return this;
	}
	
	@Override
	public JsonElement serialize(VerticesList verticesList, Type typeOfSrc, JsonSerializationContext context) {
		if (!asInteger)
			return context.serialize(verticesList.getVertices());
		else {
			JsonArray vertices = new JsonArray();
			for (List<Double> vertex : verticesList.getVertices()) {
				JsonArray values = new JsonArray();
				for (double value : vertex)
					values.add((int)value);
				
				vertices.add(values);
			}
			
			return vertices;
		}
	}

	@Override
	public VerticesList deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		return new VerticesList(context.deserialize(json, new TypeToken<List<List<Double>>>(){}.getType()));
	}
	
}
