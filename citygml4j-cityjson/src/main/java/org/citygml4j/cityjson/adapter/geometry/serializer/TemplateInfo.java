/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.geometry.serializer;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class TemplateInfo {
    private final int index;
    private ObjectNode node;

    TemplateInfo(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    ObjectNode getNode() {
        return node;
    }

    TemplateInfo setNode(ObjectNode node) {
        this.node = node;
        return this;
    }
}
