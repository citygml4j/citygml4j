/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.geometry.serializer;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class TemplateInfo {
    static final TemplateInfo NULL_TEMPLATE = new TemplateInfo(null, -1);
    private final ObjectNode node;
    private final int index;

    TemplateInfo(ObjectNode node, int index) {
        this.node = node;
        this.index = index;
    }

    ObjectNode getNode() {
        return node;
    }

    public int getIndex() {
        return index;
    }
}
