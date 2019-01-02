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

package org.citygml4j.binding.cityjson.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyHelper {

    public List<String> getDeclaredProperties(Class<?> clazz) {
        List<String> attributeNames = new ArrayList<>();
        do {
            for (Field field : clazz.getDeclaredFields()) {
                if (Modifier.isTransient(field.getModifiers()))
                    continue;

                SerializedName name = field.getAnnotation(SerializedName.class);
                attributeNames.add(name != null ? name.value() : field.getName());
            }
        } while ((clazz = clazz.getSuperclass()) != null);

        return attributeNames;
    }

    public Object deserialize(JsonElement element) {
        if (element.isJsonPrimitive()) {
            JsonPrimitive primitive = element.getAsJsonPrimitive();
            if (primitive.isBoolean())
                return primitive.getAsBoolean();
            else if (primitive.isNumber()) {
                Number value = primitive.getAsNumber();
                if (value.toString().equals(String.valueOf(value.intValue())))
                    return value.intValue();
                else
                    return value.doubleValue();
            } else {
                String value = primitive.getAsString();
                try {
                    return LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE);
                } catch (DateTimeParseException e) {
                    return value;
                }
            }
        } else if (element.isJsonObject()) {
            JsonObject object = element.getAsJsonObject();
            Map<String, Object> attributeSet = new HashMap<>();

            for (Map.Entry<String, JsonElement> nested : object.entrySet()) {
                Object value = deserialize(nested.getValue());
                if (value != null)
                    attributeSet.put(nested.getKey(), value);
            }

            if (!attributeSet.isEmpty())
                return attributeSet;
        } else if (element.isJsonArray()) {
            JsonArray array = element.getAsJsonArray();
            List<Object> items = new ArrayList<>();

            for (int i = 0; i < array.size(); i++) {
                Object value = deserialize(array.get(i));
                if (value != null)
                    items.add(value);
            }

            if (!items.isEmpty())
                return items;
        }

        return null;
    }

}
