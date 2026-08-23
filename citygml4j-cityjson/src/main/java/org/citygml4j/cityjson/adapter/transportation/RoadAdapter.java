/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.transportation;

import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.annotation.CityJSONElement;
import org.citygml4j.cityjson.annotation.CityJSONElements;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.builder.TypeMapper;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.transportation.*;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.node.ObjectNode;

import java.util.Iterator;

@CityJSONElements({
        @CityJSONElement(name = "Road", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "Road", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "Road", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class RoadAdapter extends AbstractTransportationSpaceAdapter<Road> implements TypeMapper {

    @Override
    public Road createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new Road();
    }

    @Override
    public void buildObject(Road object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        helper.buildStandardObjectClassifier(object, attributes);

        Iterator<JsonNode> children = node.path(Fields.CHILDREN).values().iterator();
        while (children.hasNext()) {
            String child = children.next().asString();
            ObjectNode childNode = helper.getCityObjectNode(child);
            if ("Road".equals(childNode.path(Fields.TYPE).asString())) {
                String classifier = childNode.path(Fields.ATTRIBUTES).path("class").asString();
                if ("Section".equalsIgnoreCase(classifier)) {
                    Road section = helper.getCityObject(child, Road.class);
                    object.getSections().add(new SectionProperty(shallowCopy(section, new Section())));
                } else if ("Intersection".equalsIgnoreCase(classifier)) {
                    Road intersection = helper.getCityObject(child, Road.class);
                    object.getIntersections().add(new IntersectionProperty(shallowCopy(intersection, new Intersection())));
                } else {
                    helper.buildAsTopLevelObject(child);
                }

                children.remove();
            }
        }
    }

    @Override
    public String mapType(JsonNode node, Class<?> type) {
        String classifier = node.path(Fields.ATTRIBUTES).path("class").asString();
        return "Track".equalsIgnoreCase(classifier) && type.isAssignableFrom(Track.class) ? "Track" : "Road";
    }

    @Override
    public String createType(Road object, CityJSONVersion version) throws CityJSONSerializeException {
        return "Road";
    }

    @Override
    public void writeObject(Road object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);
        ObjectNode attributes = helper.getOrPutObject(Fields.ATTRIBUTES, node);

        helper.writeStandardObjectClassifier(object, attributes);
    }
}
