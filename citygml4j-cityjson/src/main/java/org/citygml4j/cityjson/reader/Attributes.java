/*
 * citygml4j-cityjson - CityJSON module for citygml4j
 * https://github.com/citygml4j/citygml4j-cityjson
 *
 * citygml4j-cityjson is part of the citygml4j project
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.cityjson.reader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Attributes {
    private final Map<String, JsonNode> attributes = new LinkedHashMap<>();

    Attributes() {
    }

    public boolean isEmpty() {
        return attributes.isEmpty();
    }

    public void add(String name, JsonNode value) {
        attributes.put(name, value);
    }

    public boolean contains(String name) {
        return attributes.containsKey(name);
    }

    public JsonNode consume(String name) {
        JsonNode value = attributes.remove(name);
        return value != null ? value : MissingNode.getInstance();
    }

    public Map.Entry<String, JsonNode> consumeNext() {
        if (!attributes.isEmpty()) {
            Iterator<Map.Entry<String, JsonNode>> iterator = attributes.entrySet().iterator();
            if (iterator.hasNext()) {
                Map.Entry<String, JsonNode> next = iterator.next();
                iterator.remove();
                return next;
            }
        }

        return null;
    }
}
