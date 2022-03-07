/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
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

package org.citygml4j.cityjson.adapter.geometry.builder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.citygml4j.cityjson.adapter.appearance.builder.AppearanceInfo;
import org.citygml4j.core.model.appearance.Appearance;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemplateInfo {
    private final ArrayNode templates;
    private Map<Integer, String> references;
    private AppearanceInfo appearanceInfo;

    TemplateInfo(ArrayNode templates) {
        this.templates = templates;
    }

    JsonNode getTemplate(int index) {
        return templates.path(index);
    }

    String getReference(int index) {
        return references != null ? references.get(index) : null;
    }

    void addReference(int index, String reference) {
        if (references == null) {
            references = new HashMap<>();
        }

        references.put(index, reference);
    }

    List<Appearance> getAppearances() {
        return hasAppearances() ? appearanceInfo.getAppearances() : Collections.emptyList();
    }

    boolean hasAppearances() {
        return appearanceInfo != null && appearanceInfo.hasAppearances();
    }

    AppearanceInfo getAppearanceInfo() {
        if (appearanceInfo == null) {
            appearanceInfo = new AppearanceInfo();
        }

        return appearanceInfo;
    }
}
