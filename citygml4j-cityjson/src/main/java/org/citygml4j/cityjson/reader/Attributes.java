/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
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
