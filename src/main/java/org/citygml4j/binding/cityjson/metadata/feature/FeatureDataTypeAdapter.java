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

package org.citygml4j.binding.cityjson.metadata.feature;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.internal.LinkedTreeMap;
import org.citygml4j.binding.cityjson.metadata.ThematicModelType;

import java.lang.reflect.Type;
import java.util.Map;

public class FeatureDataTypeAdapter implements JsonSerializer<Map<ThematicModelType, AbstractFeatureDataType>>, JsonDeserializer<Map<ThematicModelType, AbstractFeatureDataType>> {

    @Override
    public JsonElement serialize(Map<ThematicModelType, AbstractFeatureDataType> featureMetadata, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(featureMetadata);
    }

    @Override
    public Map<ThematicModelType, AbstractFeatureDataType> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Map<ThematicModelType, AbstractFeatureDataType> featureMetadata = new LinkedTreeMap<>();

        for (Map.Entry<String, JsonElement> entry : json.getAsJsonObject().entrySet()) {
            ThematicModelType type = ThematicModelType.fromValue(entry.getKey());
            if (type != null) {
                AbstractFeatureDataType value = context.deserialize(entry.getValue(), type.getMetadataClass());
                if (value != null)
                    featureMetadata.put(type, value);
            }

        }

        return !featureMetadata.isEmpty() ? featureMetadata : null;
    }
}
