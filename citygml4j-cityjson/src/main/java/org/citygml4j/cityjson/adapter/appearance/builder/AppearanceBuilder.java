/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.appearance.builder;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.appearance.ParameterizedTextureAdapter;
import org.citygml4j.cityjson.adapter.appearance.X3DMaterialAdapter;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.core.model.appearance.*;

public class AppearanceBuilder {
    private final CityJSONBuilderHelper helper;
    private final ArrayNode materials;
    private final ArrayNode textures;
    private final TextureVerticesBuilder textureVerticesBuilder;

    public AppearanceBuilder(ObjectNode appearance, CityJSONBuilderHelper helper) {
        this.helper = helper;
        materials = helper.getOrPutArray(Fields.MATERIALS, appearance);
        textures = helper.getOrPutArray(Fields.TEXTURES, appearance);
        textureVerticesBuilder = new TextureVerticesBuilder(helper.getOrPutArray(Fields.VERTICES_TEXTURE, appearance));
    }

    public TextureVerticesBuilder getTextureVerticesBuilder() {
        return textureVerticesBuilder;
    }

    public X3DMaterial getOrCreateMaterial(int index, String theme, AppearanceInfo appearanceInfo) {
        X3DMaterial material = appearanceInfo.getMaterial(index);
        if (material == null) {
            try {
                material = helper.getObjectUsingBuilder(materials.get(index), X3DMaterialAdapter.class);
                addToAppearance(material, theme, appearanceInfo);
                appearanceInfo.addMaterial(index, material);
            } catch (Exception e) {
                //
            }
        }

        return material;
    }

    public ParameterizedTexture getOrCreateTexture(int index, String theme, AppearanceInfo appearanceInfo) {
        ParameterizedTexture texture = appearanceInfo.getTexture(index);
        if (texture == null) {
            try {
                texture = helper.getObjectUsingBuilder(textures.get(index), ParameterizedTextureAdapter.class);
                addToAppearance(texture, theme, appearanceInfo);
                appearanceInfo.addTexture(index, texture);
            } catch (Exception e) {
                //
            }
        }

        return texture;
    }

    private void addToAppearance(AbstractSurfaceData surfaceData, String theme, AppearanceInfo appearanceInfo) {
        Appearance appearance = appearanceInfo.getAppearance(theme);
        if (appearance == null) {
            appearance = new Appearance();
            appearance.setTheme(!theme.isEmpty() ? theme : null);
            appearanceInfo.addAppearance(theme, appearance);
        }

        appearance.getSurfaceData().add(new AbstractSurfaceDataProperty(surfaceData));
    }
}
