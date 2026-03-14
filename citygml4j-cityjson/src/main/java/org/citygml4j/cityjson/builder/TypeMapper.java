/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.builder;

import com.fasterxml.jackson.databind.JsonNode;

@FunctionalInterface
public interface TypeMapper {
    String mapType(JsonNode node, Class<?> type);
}
