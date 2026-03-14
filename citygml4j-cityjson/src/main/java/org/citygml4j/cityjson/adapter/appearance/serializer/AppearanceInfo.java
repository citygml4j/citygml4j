/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.appearance.serializer;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class AppearanceInfo {
    private final ObjectNode node;
    private final String theme;
    private final int index;

    AppearanceInfo(ObjectNode node, String theme, int index) {
        this.node = node;
        this.theme = theme;
        this.index = index;
    }

    ObjectNode getNode() {
        return node;
    }

    public String getTheme() {
        return theme;
    }

    public int getIndex() {
        return index;
    }
}
