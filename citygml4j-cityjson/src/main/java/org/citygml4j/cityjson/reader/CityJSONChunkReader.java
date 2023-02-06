/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.core.model.appearance.Appearance;
import org.citygml4j.core.model.core.AbstractFeature;

import java.io.IOException;
import java.util.*;

public class CityJSONChunkReader extends CityJSONReader {
    private final Deque<Appearance> globalAppearances = new ArrayDeque<>();

    private AbstractFeature next;
    private CityJSONBuilderHelper helper;
    private TopLevelIterator iterator;

    CityJSONChunkReader(JsonParser reader, ObjectMapper mapper, CityJSONContext context) {
        super(reader, mapper, context);
    }

    @Override
    public boolean hasNext() throws CityJSONReadException {
        if (next == null) {
            try {
                while (next == null && !topLevelObjects.isEmpty()) {
                    String nested = topLevelObjects.pop();
                    JsonNode node = helper.getCityObjects().path(nested);
                    if (node.isObject()) {
                        next = processCityObject(node, nested);
                        helper.getCityObjects().remove(nested);
                    }
                }

                while (next == null && updateTopLevelIterator()) {
                    if (iterator.hasNext()) {
                        Map.Entry<String, JsonNode> entry = iterator.next();
                        next = processCityObject(entry.getValue(), entry.getKey());
                    }
                }

                while (next == null && !globalAppearances.isEmpty()) {
                    next = globalAppearances.pop();
                }
            } catch (CityJSONBuildException e) {
                throw new CityJSONReadException("Caused by:", e);
            }
        }

        return next != null;
    }

    @Override
    public AbstractFeature next() throws CityJSONReadException {
        if (hasNext()) {
            try {
                if (resolver != null) {
                    resolver.resolveReferences(next);
                }

                return next;
            } finally {
                next = null;
            }
        }

        throw new NoSuchElementException();
    }

    @Override
    public void close() throws CityJSONReadException {
        try {
            super.close();
        } finally {
            globalAppearances.clear();
            helper = null;
            iterator = null;
        }
    }

    private AbstractFeature processCityObject(JsonNode topLevelObject, String identifier) throws CityJSONReadException, CityJSONBuildException {
        AbstractFeature object = helper.getObject(topLevelObject, AbstractFeature.class);
        helper.removeChildren(topLevelObject, identifier, !topLevelObjects.isEmpty() ?
                new HashSet<>(topLevelObjects) :
                Collections.emptySet());

        if (object != null) {
            object.setId(identifier);
        }

        return object;
    }

    private boolean updateTopLevelIterator() throws CityJSONReadException {
        if (iterator == null || !iterator.hasNext()) {
            try {
                if (helper != null && helper.hasGlobalAppearances()) {
                    globalAppearances.addAll(helper.getGlobalAppearances());
                }

                helper = null;
                iterator = null;

                if (globalAppearances.isEmpty()) {
                    TreeNode node = objectMapper.readTree(reader);
                    if (node != null && node.isObject()) {
                        ObjectNode content = (ObjectNode) node;
                        helper = createHelper(content);
                        iterator = TopLevelIterator.of(helper, filter);
                    }
                }

                return iterator != null;
            } catch (CityJSONBuildException | IOException e) {
                throw new CityJSONReadException("Caused by:", e);
            }
        }

        return true;
    }
}