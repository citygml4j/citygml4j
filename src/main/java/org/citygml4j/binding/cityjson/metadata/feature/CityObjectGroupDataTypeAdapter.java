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
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.internal.LinkedTreeMap;
import org.citygml4j.binding.cityjson.metadata.ThematicModelType;

import java.lang.reflect.Type;
import java.util.Map;

public class CityObjectGroupDataTypeAdapter implements JsonSerializer<CityObjectGroupDataType>, JsonDeserializer<CityObjectGroupDataType> {

    @Override
    public JsonElement serialize(CityObjectGroupDataType featureMetadata, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();

        if (featureMetadata.isSetUniqueFeatureCount())
            object.add("uniqueFeatureCount", new JsonPrimitive(featureMetadata.getUniqueFeatureCount()));

        if (featureMetadata.isSetAggregateFeatureCount())
            object.add("aggregateFeatureCount", new JsonPrimitive(featureMetadata.getAggregateFeatureCount()));

        if (featureMetadata.isSetPresentLoDs())
            object.add("presentLoDs", context.serialize(featureMetadata.getPresentLoDs()));

        if (featureMetadata.isSetMemberMetadata()) {
            for (Map.Entry<ThematicModelType, AbstractFeatureDataType> entry : featureMetadata.memberMetadata.entrySet())
                object.add(entry.getKey().getValue(), context.serialize(entry.getValue()));
        }

        return object;
    }

    @Override
    public CityObjectGroupDataType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        CityObjectGroupDataType featureMetadata = new CityObjectGroupDataType();
        JsonObject object = json.getAsJsonObject();

        Map<ThematicModelType, AbstractFeatureDataType> memberMetadata = new LinkedTreeMap<>();
        for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
            switch (entry.getKey()) {
                case "uniqueFeatureCount":
                    featureMetadata.setUniqueFeatureCount(context.deserialize(entry.getValue(), Integer.class));
                    break;
                case "aggregateFeatureCount":
                    featureMetadata.setAggregateFeatureCount(context.deserialize(entry.getValue(), Integer.class));
                    break;
                case "presentLoDs":
                    featureMetadata.setPresentLoDs(context.deserialize(entry.getValue(), Map.class));
                    break;
                default:
                    ThematicModelType type = ThematicModelType.fromValue(entry.getKey());
                    if (type != null) {
                        AbstractFeatureDataType value = context.deserialize(entry.getValue(), type.getMetadataClass());
                        if (value != null)
                            memberMetadata.put(type, value);
                    }
            }
        }

        if (!memberMetadata.isEmpty())
            featureMetadata.memberMetadata = memberMetadata;

        return featureMetadata;
    }
}
