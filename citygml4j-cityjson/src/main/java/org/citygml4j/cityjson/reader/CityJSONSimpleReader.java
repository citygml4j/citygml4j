/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.reader;

import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.core.model.appearance.Appearance;
import org.citygml4j.core.model.common.TopLevelFeature;
import org.citygml4j.core.model.core.*;
import org.xmlobjects.gml.model.feature.BoundingShape;
import org.xmlobjects.gml.model.geometry.DirectPosition;
import org.xmlobjects.gml.model.geometry.Envelope;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.core.TreeNode;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.node.ObjectNode;

import java.util.*;

public class CityJSONSimpleReader extends CityJSONReader {
    private boolean hasNext = false;
    private CityModel cityModel;
    private CityJSONBuilderHelper helper;

    CityJSONSimpleReader(JsonParser reader, JsonMapper jsonMapper, CityJSONContext context) {
        super(reader, jsonMapper, context);
    }

    @Override
    public boolean hasNext() throws CityJSONReadException {
        if (!hasNext) {
            try {
                cityModel = new CityModel();

                TreeNode node;
                while ((node = jsonMapper.readTree(reader)) != null && node.isObject()) {
                    ObjectNode content = (ObjectNode) node;
                    helper = createHelper(content, helper);

                    TopLevelIterator iterator = TopLevelIterator.of(helper, filter);
                    while (iterator.hasNext()) {
                        Map.Entry<String, JsonNode> entry = iterator.next();
                        processCityObject(entry.getValue(), entry.getKey(), helper);
                    }

                    if ((cityModel.isSetCityObjectMembers()
                            || cityModel.isSetFeatureMembers())
                            && helper.hasGlobalAppearances()) {
                        for (Appearance appearance : helper.getGlobalAppearances()) {
                            cityModel.getAppearanceMembers().add(new AbstractAppearanceProperty(appearance));
                        }
                    }

                    hasNext = true;
                }

                if (hasNext) {
                    if (metadata != null && metadata.isSetGeographicalExtent()) {
                        List<Double> geographicalExtent = metadata.getGeographicalExtent();
                        if (geographicalExtent.size() > 5) {
                            Envelope envelope = new Envelope(
                                    new DirectPosition(geographicalExtent.subList(0, 3)),
                                    new DirectPosition(geographicalExtent.subList(3, 6)));
                            envelope.setSrsDimension(3);

                            if (metadata.getReferenceSystem() != null) {
                                envelope.setSrsName(metadata.getReferenceSystem().toURL());
                            }

                            cityModel.setBoundedBy(new BoundingShape(envelope));
                        }
                    }

                    if (extraRootProperties != null) {
                        for (ADEOfCityModel property : extraRootProperties.values()) {
                            cityModel.addADEProperty(property);
                        }
                    }
                }
            } catch (CityJSONBuildException | JacksonException e) {
                throw new CityJSONReadException("Caused by:", e);
            }
        }

        return hasNext;
    }

    @Override
    public AbstractFeature next() throws CityJSONReadException {
        if (hasNext()) {
            try {
                if (resolver != null) {
                    resolver.resolveReferences(cityModel);
                }

                return cityModel;
            } finally {
                hasNext = false;
                cityModel = null;
            }
        }

        throw new NoSuchElementException();
    }

    private void processCityObject(JsonNode topLevelObject, String identifier, CityJSONBuilderHelper helper) throws CityJSONReadException, CityJSONBuildException {
        AbstractFeature object = helper.getObject(topLevelObject, AbstractFeature.class);
        helper.removeChildren(topLevelObject, identifier, !topLevelObjects.isEmpty() ?
                new HashSet<>(topLevelObjects) :
                Collections.emptySet());

        while (!topLevelObjects.isEmpty()) {
            String nested = topLevelObjects.pop();
            JsonNode node = helper.getCityObjects().path(nested);
            if (node.isObject()) {
                processCityObject(node, nested, helper);
                helper.getCityObjects().remove(nested);
            }
        }

        if (object != null) {
            object.setId(identifier);
            if (object instanceof AbstractCityObject cityObject && object instanceof TopLevelFeature) {
                cityModel.getCityObjectMembers().add(new AbstractCityObjectProperty(cityObject));
            } else {
                cityModel.getFeatureMembers().add(new AbstractFeatureProperty(object));
            }
        }
    }
}
