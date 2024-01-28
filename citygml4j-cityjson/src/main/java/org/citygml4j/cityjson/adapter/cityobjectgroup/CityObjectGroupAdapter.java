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

package org.citygml4j.cityjson.adapter.cityobjectgroup;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.core.AbstractLogicalSpaceAdapter;
import org.citygml4j.cityjson.annotation.CityJSONElement;
import org.citygml4j.cityjson.annotation.CityJSONElements;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.cityobjectgroup.CityObjectGroup;
import org.citygml4j.core.model.cityobjectgroup.Role;
import org.citygml4j.core.model.cityobjectgroup.RoleProperty;
import org.citygml4j.core.model.core.AbstractCityObject;
import org.citygml4j.core.model.core.AbstractCityObjectReference;
import org.citygml4j.core.model.deprecated.cityobjectgroup.DeprecatedPropertiesOfCityObjectGroup;
import org.citygml4j.core.model.deprecated.cityobjectgroup.GroupMember;

import java.util.EnumSet;
import java.util.Iterator;

@CityJSONElements({
        @CityJSONElement(name = "CityObjectGroup", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "CityObjectGroup", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "CityObjectGroup", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class CityObjectGroupAdapter extends AbstractLogicalSpaceAdapter<CityObjectGroup> {
    private final EnumSet<GeometryType> allowedTypes = EnumSet.complementOf(EnumSet.of(GeometryType.TEMPLATE_GEOMETRY));

    @Override
    public CityObjectGroup createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new CityObjectGroup();
    }

    @Override
    public void buildObject(CityObjectGroup object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        helper.buildStandardObjectClassifier(object, attributes);

        Iterator<JsonNode> children = node.path(Fields.CHILDREN).elements();
        JsonNode roles = attributes.consume(Fields.CHILDREN_ROLES);
        int index = 0;

        while (children.hasNext()) {
            addGroupMember(object, children.next().asText(), roles.get(index), helper);
            children.remove();
            index++;
        }

        for (JsonNode member : attributes.consume(Fields.MEMBERS)) {
            addGroupMember(object, member.asText(), null, helper);
        }
    }

    @Override
    public String createType(CityObjectGroup object, CityJSONVersion version) throws CityJSONSerializeException {
        return "CityObjectGroup";
    }

    @Override
    public void writeObject(CityObjectGroup object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);
        ObjectNode attributes = helper.getOrPutObject(Fields.ATTRIBUTES, node);

        helper.writeStandardObjectClassifier(object, attributes);

        if (object.isSetGroupMembers()) {
            for (RoleProperty property : object.getGroupMembers()) {
                if (property.getObject() != null
                        && property.getObject().getGroupMember() != null
                        && property.getObject().getGroupMember().getHref() != null) {
                    AbstractCityObjectReference reference = property.getObject().getGroupMember();
                    addChild(getIdFromReference(reference.getHref()), property.getObject().getRole(), node, helper);
                }
            }
        }

        if (object.hasDeprecatedProperties()) {
            DeprecatedPropertiesOfCityObjectGroup properties = object.getDeprecatedProperties();

            if (properties.isSetGroupMembers()) {
                for (GroupMember member : properties.getGroupMembers()) {
                    if (member.getObject() != null) {
                        AbstractCityObject child = member.getObject();
                        helper.writeCityObject(child);
                        addChild(child.getId(), member.getRole(), node, helper);
                    }
                }
            }

            if (properties.getGroupParent() != null) {
                helper.writeCityObject(properties.getGroupParent().getObject());
            }

            if (properties.getGeometry() != null) {
                helper.addGeometry(properties.getGeometry(), 0, node);
            }
        }

        if (helper.getVersion() == CityJSONVersion.v1_0) {
            ArrayNode geometry = helper.getOrPutArray(Fields.GEOMETRY, node);
            if (geometry.size() > 1) {
                JsonNode element = geometry.get(0);
                geometry.removeAll().add(element);
            }
        } else if (containsOnlyNull((ArrayNode) node.get(Fields.CHILDREN_ROLES))) {
            node.remove(Fields.CHILDREN_ROLES);
        }
    }

    @Override
    public EnumSet<GeometryType> getAllowedGeometryTypes(CityJSONVersion version) {
        return allowedTypes;
    }

    private void addGroupMember(CityObjectGroup object, String member, JsonNode memberRole, CityJSONBuilderHelper helper) {
        if (!member.isEmpty()) {
            helper.buildAsTopLevelObject(member);

            Role role = new Role(new AbstractCityObjectReference("#" + member));
            if (memberRole != null && memberRole.isTextual()) {
                role.setRole(memberRole.asText());
            }

            object.getGroupMembers().add(new RoleProperty(role));
        }
    }

    private void addChild(String id, String role, ObjectNode node, CityJSONSerializerHelper helper) {
        helper.getOrPutArray(helper.getVersion() == CityJSONVersion.v1_0 ?
                Fields.MEMBERS :
                Fields.CHILDREN, node).add(id);

        if (helper.getVersion() != CityJSONVersion.v1_0) {
            helper.getOrPutArray(Fields.CHILDREN_ROLES, node).add(role);
        }
    }

    private boolean containsOnlyNull(ArrayNode roles) {
        if (roles == null) {
            return false;
        }

        for (int i = 0; i < roles.size(); i++) {
            if (!roles.get(i).isNull()) {
                return false;
            }
        }

        return true;
    }

    public String getIdFromReference(String reference) {
        int index = reference.lastIndexOf("#");
        return index != -1 ? reference.substring(index + 1) : reference;
    }
}
