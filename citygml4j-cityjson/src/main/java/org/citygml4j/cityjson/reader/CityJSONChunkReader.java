/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.reader;

import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.core.model.appearance.Appearance;
import org.citygml4j.core.model.core.AbstractFeature;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.core.TreeNode;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.node.ObjectNode;

import java.util.*;

public class CityJSONChunkReader extends CityJSONReader {
    private AbstractFeature next;
    private CityJSONBuilderHelper helper;
    private TopLevelIterator iterator;
    private Deque<Appearance> globalAppearances;

    CityJSONChunkReader(JsonParser reader, JsonMapper jsonMapper, CityJSONContext context) {
        super(reader, jsonMapper, context);
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

                while (next == null && globalAppearances != null && !globalAppearances.isEmpty()) {
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
            helper = null;
            iterator = null;
            if (globalAppearances != null) {
                globalAppearances.clear();
            }
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
                iterator = null;
                TreeNode node = jsonMapper.readTree(reader);
                if (node != null && node.isObject()) {
                    ObjectNode content = (ObjectNode) node;
                    helper = createHelper(content, helper);
                    iterator = TopLevelIterator.of(helper, filter);
                } else if (globalAppearances == null && helper.hasGlobalAppearances()) {
                    globalAppearances = new ArrayDeque<>(helper.getGlobalAppearances());
                }

                return iterator != null;
            } catch (CityJSONBuildException | JacksonException e) {
                throw new CityJSONReadException("Caused by:", e);
            }
        }

        return true;
    }
}