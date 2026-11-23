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
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.node.ObjectNode;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

public class PointOfContactAdapter implements JsonObjectBuilder<PointOfContact>, JsonObjectSerializer<PointOfContact> {
    private static final TypeReference<Map<String, Object>> ADDRESS_TYPE = new TypeReference<>() {
    };

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
            try {
                object.setAddress(helper.getContext().getJsonMapper().convertValue(address, ADDRESS_TYPE));
            } catch (JacksonException e) {
                throw new CityJSONBuildException("Failed to read point of contact address.", e);
            }
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
            if (version != CityJSONVersion.v1_0) {
                try {
                    node.set("address", helper.getContext().getJsonMapper().valueToTree(object.getAddress()));
                } catch (JacksonException e) {
                    throw new CityJSONSerializeException("Failed to write point of contact address.", e);
                }
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
