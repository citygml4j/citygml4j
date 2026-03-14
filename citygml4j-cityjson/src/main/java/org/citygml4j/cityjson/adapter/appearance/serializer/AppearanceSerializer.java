/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.appearance.serializer;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.appearance.ParameterizedTextureAdapter;
import org.citygml4j.cityjson.adapter.appearance.X3DMaterialAdapter;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.core.model.appearance.AbstractSurfaceData;
import org.citygml4j.core.model.appearance.Appearance;
import org.citygml4j.core.model.appearance.ParameterizedTexture;
import org.citygml4j.core.model.appearance.X3DMaterial;

import java.util.*;

public class AppearanceSerializer {
    public static final String FALLBACK_THEME = "unnamed";
    public static final int DEFAULT_TEXTURE_VERTEX_PRECISION = 7;

    private final CityJSONSerializerHelper helper;
    private final Map<Integer, AppearanceInfo> materials = new HashMap<>();
    private final Map<Integer, AppearanceInfo> textures = new HashMap<>();
    private final TextureVerticesBuilder textureVerticesBuilder = new TextureVerticesBuilder(DEFAULT_TEXTURE_VERTEX_PRECISION);

    private String fallbackTheme = FALLBACK_THEME;

    public AppearanceSerializer(CityJSONSerializerHelper helper) {
        this.helper = helper;
    }

    public String getFallbackTheme() {
        return fallbackTheme;
    }

    public void setFallbackTheme(String fallbackTheme) {
        this.fallbackTheme = fallbackTheme != null ? fallbackTheme : FALLBACK_THEME;
    }

    public TextureVerticesBuilder getTextureVerticesBuilder() {
        return textureVerticesBuilder;
    }

    public AppearanceInfo getOrCreateMaterial(X3DMaterial material) {
        return materials.computeIfAbsent(computeKey(material), v -> {
            try {
                ObjectNode node = helper.getObjectUsingSerializer(material, X3DMaterialAdapter.class);
                return new AppearanceInfo(node, getTheme(material), materials.size());
            } catch (Exception e) {
                return null;
            }
        });
    }

    public boolean hasMaterials() {
        return !materials.isEmpty();
    }

    public Iterator<ObjectNode> getMaterials() {
        return materials.values().stream()
                .sorted(Comparator.comparingInt(AppearanceInfo::getIndex))
                .map(AppearanceInfo::getNode)
                .iterator();
    }

    public AppearanceInfo getOrCreateTexture(ParameterizedTexture texture) {
        return textures.computeIfAbsent(computeKey(texture), v -> {
            try {
                ObjectNode node = helper.getObjectUsingSerializer(texture, ParameterizedTextureAdapter.class);
                return new AppearanceInfo(node, getTheme(texture), textures.size());
            } catch (Exception e) {
                return null;
            }
        });
    }

    public boolean hasTextures() {
        return !textures.isEmpty();
    }

    public Iterator<ObjectNode> getTextures() {
        return textures.values().stream()
                .sorted(Comparator.comparingInt(AppearanceInfo::getIndex))
                .map(AppearanceInfo::getNode)
                .iterator();
    }

    private String getTheme(AbstractSurfaceData surfaceData) {
        String theme = null;
        Appearance appearance = surfaceData.getParent(Appearance.class);
        if (appearance != null) {
            theme = appearance.getTheme();
        }

        return theme != null ? theme : fallbackTheme;
    }

    public void reset() {
        materials.clear();
        textures.clear();
        textureVerticesBuilder.reset();
    }

    private int computeKey(X3DMaterial material) {
        return Objects.hash(getTheme(material),
                material.getAmbientIntensity(),
                material.getDiffuseColor().toList(),
                material.getEmissiveColor().toList(),
                material.getSpecularColor().toList(),
                material.getShininess(),
                material.getTransparency(),
                material.getIsSmooth());
    }

    private int computeKey(ParameterizedTexture texture) {
        return Objects.hash(getTheme(texture),
                texture.getImageURI(),
                texture.getMimeType() != null ? texture.getMimeType().getValue() : null,
                texture.getTextureType(),
                texture.getWrapMode(),
                texture.getBorderColor() != null ? texture.getBorderColor().toList() : null);
    }
}
