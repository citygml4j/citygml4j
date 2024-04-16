/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.cityjson.adapter.transportation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.annotation.CityJSONElement;
import org.citygml4j.cityjson.annotation.CityJSONElements;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.transportation.*;
import org.xmlobjects.gml.model.basictypes.Code;

import java.util.Iterator;

@CityJSONElements({
        @CityJSONElement(name = "Track", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "Track", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "Track", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class TrackAdapter extends AbstractTransportationSpaceAdapter<Track> {

    @Override
    public Track createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new Track();
    }

    @Override
    public void buildObject(Track object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        attributes.consume("class");
        helper.buildStandardObjectClassifier(object, attributes);

        Iterator<JsonNode> children = node.path(Fields.CHILDREN).elements();
        while (children.hasNext()) {
            String child = children.next().asText();
            ObjectNode childNode = helper.getCityObjectNode(child);

            String type = childNode.path(Fields.TYPE).asText();
            if ("Road".equals(type) || "Track".equals(type)) {
                String classifier = childNode.path(Fields.ATTRIBUTES).path("class").asText();
                if ("Section".equalsIgnoreCase(classifier)) {
                    Track section = helper.getCityObject(child, Track.class);
                    object.getSections().add(new SectionProperty(shallowCopy(section, new Section())));
                } else if ("Intersection".equalsIgnoreCase(classifier)) {
                    Track intersection = helper.getCityObject(child, Track.class);
                    object.getIntersections().add(new IntersectionProperty(shallowCopy(intersection, new Intersection())));
                } else {
                    helper.buildAsTopLevelObject(child);
                }

                children.remove();
            }
        }
    }

    @Override
    public String createType(Track object, CityJSONVersion version) throws CityJSONSerializeException {
        return "Road";
    }

    @Override
    public void writeObject(Track object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);
        ObjectNode attributes = helper.getOrPutObject(Fields.ATTRIBUTES, node);

        object.setClassifier(new Code("Track"));
        helper.writeStandardObjectClassifier(object, attributes);
    }
}
