/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.appearance.builder;

import org.citygml4j.core.model.appearance.Appearance;
import org.citygml4j.core.model.appearance.ParameterizedTexture;
import org.citygml4j.core.model.appearance.X3DMaterial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppearanceInfo {
    private final Map<String, Appearance> appearances = new HashMap<>();
    private Map<Integer, X3DMaterial> materials;
    private Map<Integer, ParameterizedTexture> textures;

    public List<Appearance> getAppearances() {
        return new ArrayList<>(appearances.values());
    }

    public boolean hasAppearances() {
        return !appearances.isEmpty();
    }

    Appearance getAppearance(String theme) {
        return appearances.get(theme);
    }

    void addAppearance(String theme, Appearance appearance) {
        appearances.put(theme, appearance);
    }

    X3DMaterial getMaterial(int index) {
        return materials != null ? materials.get(index) : null;
    }

    void addMaterial(int index, X3DMaterial material) {
        if (materials == null) {
            materials = new HashMap<>();
        }

        materials.put(index, material);
    }

    ParameterizedTexture getTexture(int index) {
        return textures != null ? textures.get(index) : null;
    }

    void addTexture(int index, ParameterizedTexture texture) {
        if (textures == null) {
            textures = new HashMap<>();
        }

        textures.put(index, texture);
    }
}
