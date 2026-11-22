/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.metadata;

import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.builder.JsonObjectBuilder;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.model.metadata.ContactType;
import org.citygml4j.cityjson.model.metadata.PointOfContact;
import org.citygml4j.cityjson.model.metadata.Role;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.serializer.JsonObjectSerializer;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.node.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class PointOfContactAdapter implements JsonObjectBuilder<PointOfContact>, JsonObjectSerializer<PointOfContact> {

    @Override
    public PointOfContact createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new PointOfContact();
    }

    @Override
    public void buildObject(PointOfContact object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        JsonNode contactName = node.path("contactName");
        if (contactName.isString() && !contactName.asString().isEmpty()) {
            object.setContactName(contactName.asString());
        }

        JsonNode phone = node.path("phone");
        if (phone.isString()) {
            object.setPhone(phone.asString());
        }

        JsonNode address = node.path("address");
        if (address.isObject()) {
            // CityJSON 2.0 uses an address object with arbitrary members
            object.setAddress(toMap(address));
        } else if (address.isString()) {
            Map<String, Object> details = new LinkedHashMap<>();
            details.put("address", address.asString());
            object.setAddress(details);
        }

        JsonNode emailAddress = node.path("emailAddress");
        if (emailAddress.isString()) {
            object.setEmailAddress(emailAddress.asString());
        }

        JsonNode contactType = node.path("contactType");
        if (contactType.isString()) {
            object.setContactType(ContactType.fromValue(contactType.asString()));
        }

        JsonNode role = node.path("role");
        if (role.isString()) {
            object.setRole(Role.fromValue(role.asString()));
        }

        JsonNode organization = node.path("organization");
        if (organization.isString()) {
            object.setOrganization(organization.asString());
        }

        JsonNode website = node.path("website");
        if (website.isString()) {
            object.setWebsite(website.asString());
        }
    }

    @Override
    public void writeObject(PointOfContact object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        CityJSONVersion version = helper.getVersion();

        if (object.getContactName() != null) {
            node.put("contactName", object.getContactName());
        } else if (version != CityJSONVersion.v1_0) {
            node.put("contactName", "");
        }

        if (object.getPhone() != null) {
            node.put("phone", object.getPhone());
        }

        if (object.getAddress() != null && !object.getAddress().isEmpty()) {
            if (version != CityJSONVersion.v1_0 && version != CityJSONVersion.v1_1) {
                node.set("address", toJson(object.getAddress(), helper));
            } else {
                String text = toText(object.getAddress());
                if (text != null) {
                    node.put("address", text);
                }
            }
        }

        if (object.getEmailAddress() != null) {
            node.put("emailAddress", object.getEmailAddress());
        } else if (version != CityJSONVersion.v1_0) {
            node.put("emailAddress", "");
        }

        if (object.getContactType() != null) {
            node.put("contactType", object.getContactType().toValue());

            if (version == CityJSONVersion.v1_0) {
                if (object.getContactType() == ContactType.INDIVIDUAL) {
                    if (object.getRole() != null) {
                        node.put("role", object.getRole().toValue());
                    }

                    if (object.getOrganization() != null) {
                        node.put("organization", object.getOrganization());
                    }
                } else {
                    if (object.getWebsite() != null) {
                        node.put("website", object.getWebsite());
                    }
                }
            }
        }

        if (version != CityJSONVersion.v1_0) {
            if (object.getRole() != null) {
                node.put("role", object.getRole().toValue());
            }

            if (object.getOrganization() != null) {
                node.put("organization", object.getOrganization());
            }

            if (object.getWebsite() != null) {
                node.put("website", object.getWebsite());
            }
        }
    }

    private Map<String, Object> toMap(JsonNode node) {
        Map<String, Object> map = new LinkedHashMap<>();
        for (Map.Entry<String, JsonNode> entry : node.properties()) {
            map.put(entry.getKey(), toJava(entry.getValue()));
        }

        return map;
    }

    private Object toJava(JsonNode node) {
        if (node.isObject()) {
            return toMap(node);
        } else if (node.isArray()) {
            List<Object> list = new ArrayList<>(node.size());
            node.forEach(element -> list.add(toJava(element)));
            return list;
        } else if (node.isString()) {
            return node.asString();
        } else if (node.isNumber()) {
            return node.numberValue();
        } else if (node.isBoolean()) {
            return node.asBoolean();
        } else {
            return null;
        }
    }

    private JsonNode toJson(Object value, CityJSONSerializerHelper helper) {
        return switch (value) {
            case Map<?, ?> map -> {
                ObjectNode node = helper.createObject();
                map.forEach((k, v) -> node.set(String.valueOf(k), toJson(v, helper)));
                yield node;
            }
            case Collection<?> collection -> {
                ArrayNode node = helper.createArray();
                collection.forEach(v -> node.add(toJson(v, helper)));
                yield node;
            }
            case String string -> StringNode.valueOf(string);
            case Integer number -> IntNode.valueOf(number);
            case Long number -> LongNode.valueOf(number);
            case BigInteger number -> BigIntegerNode.valueOf(number);
            case BigDecimal number -> DecimalNode.valueOf(number);
            case Number number -> DoubleNode.valueOf(number.doubleValue());
            case Boolean bool -> BooleanNode.valueOf(bool);
            case null -> NullNode.getInstance();
            default -> StringNode.valueOf(value.toString());
        };
    }

    private String toText(Map<String, Object> details) {
        StringJoiner joiner = new StringJoiner(", ");
        collectText(details, joiner);
        return joiner.length() > 0 ? joiner.toString() : null;
    }

    private void collectText(Object value, StringJoiner joiner) {
        switch (value) {
            case Map<?, ?> map -> map.values().forEach(v -> collectText(v, joiner));
            case Collection<?> collection -> collection.forEach(v -> collectText(v, joiner));
            case null -> {
            }
            default -> {
                String text = value.toString();
                if (!text.isEmpty()) {
                    joiner.add(text);
                }
            }
        }
    }
}
