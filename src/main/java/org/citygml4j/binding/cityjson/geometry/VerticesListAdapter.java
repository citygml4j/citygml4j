/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
