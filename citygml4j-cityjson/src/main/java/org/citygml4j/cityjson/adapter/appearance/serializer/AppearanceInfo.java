/*
 * citygml4j-cityjson - CityJSON module for citygml4j
 * https://github.com/citygml4j/citygml4j-cityjson
 *
 * citygml4j-cityjson is part of the citygml4j project
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