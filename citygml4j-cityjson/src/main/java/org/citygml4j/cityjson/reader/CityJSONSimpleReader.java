/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
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

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.core.model.appearance.Appearance;
import org.citygml4j.core.model.common.TopLevelFeature;
import org.citygml4j.core.model.core.*;
import org.xmlobjects.gml.model.feature.BoundingShape;
import org.xmlobjects.gml.model.geometry.DirectPosition;
import org.xmlobjects.gml.model.geometry.Envelope;

import java.io.IOException;
import java.util.*;

public class CityJSONSimpleReader extends CityJSONReader {
    private boolean hasNext = false;
    private CityModel cityModel;

    CityJSONSimpleReader(JsonParser reader, ObjectMapper mapper, CityJSONContext context) {
        super(reader, mapper, context);
    }

    @Override
    public boolean hasNext() throws CityJSONReadException {
        if (!hasNext) {
            try {
                cityModel = new CityModel();

                TreeNode node;
                while ((node = objectMapper.readTree(reader)) != null && node.isObject()) {
                    ObjectNode content = (ObjectNode) node;
                    CityJSONBuilderHelper helper = createHelper(content);

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
            } catch (CityJSONBuildException | IOException e) {
                throw new CityJSONReadException("Caused by:", e);
            }
        }

        return hasNext;
    }

    @Override
    public AbstractFeature next() throws CityJSONReadException {
        if (hasNext()) {
            try {
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
            if (object instanceof AbstractCityObject && object instanceof TopLevelFeature) {
                cityModel.getCityObjectMembers().add(new AbstractCityObjectProperty((AbstractCityObject) object));
            } else {
                cityModel.getFeatureMembers().add(new AbstractFeatureProperty(object));
            }
        }
    }
}
