/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2019 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.binding.cityjson.feature;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.util.PropertyHelper;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class CityJSONAdapter implements JsonSerializer<CityJSON>, JsonDeserializer<CityJSON> {
    private final PropertyHelper propertyHelper = new PropertyHelper();
    private List<String> predefinedProperties;

    @Override
    public JsonElement serialize(CityJSON cityJSON, Type typeOfSrc, JsonSerializationContext context) {
        JsonElement element = context.serialize(cityJSON, InternalCityJSONType.class);
        if (element != null && element.isJsonObject()) {
            JsonObject object = element.getAsJsonObject();

            // serialize extension properties
            if (cityJSON.isSetExtensionProperties()) {
                JsonObject properties = context.serialize(cityJSON.getExtensionProperties()).getAsJsonObject();
                for (Map.Entry<String, JsonElement> entry : properties.entrySet())
                    object.add(entry.getKey(), entry.getValue());
            }
        }

        return element;
    }

    @Override
    public CityJSON deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        CityJSON cityJSON = context.deserialize(json, InternalCityJSONType.class);

        if (predefinedProperties == null)
            predefinedProperties = propertyHelper.getDeclaredProperties(CityJSON.class);

        // deserialize extension properties
        for (Map.Entry<String, JsonElement> entry : json.getAsJsonObject().entrySet()) {
            String key = entry.getKey();
            if (predefinedProperties.contains(key))
                continue;

            Object value = propertyHelper.deserialize(entry.getValue());
            if (value != null)
                cityJSON.addExtensionProperty(key, value);
        }

        return cityJSON;
    }
}
