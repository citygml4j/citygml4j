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

package org.citygml4j.xml.reader;

import org.citygml4j.xml.module.citygml.AppearanceModule;
import org.citygml4j.xml.module.citygml.CoreModule;
import org.citygml4j.xml.module.gml.GMLCoreModule;

import javax.xml.namespace.QName;
import java.util.*;

public class ChunkOptions {
    private final Map<String, Set<String>> properties = new HashMap<>();
    private final Map<String, Set<String>> excludes = new HashMap<>();
    private boolean skipCityModel = true;
    private boolean keepInlineAppearance = true;

    private ChunkOptions() {
    }

    public static ChunkOptions defaults() {
        return new ChunkOptions()
                .addCityModelMemberProperties()
                .addGroupMemberProperties();
    }

    public static ChunkOptions chunkByFeatures() {
        return new ChunkOptions();
    }

    public static ChunkOptions chunkByProperties(Collection<QName> properties) {
        ChunkOptions chunkOptions = new ChunkOptions();
        if (properties != null) {
            properties.forEach(chunkOptions::withProperty);
        }

        return chunkOptions;
    }

    public static ChunkOptions chunkByProperties(QName... properties) {
        return chunkByProperties(properties != null ? List.of(properties) : null);
    }

    boolean shouldChunk(QName property) {
        return properties.isEmpty() || containsProperty(property.getNamespaceURI(), property.getLocalPart());
    }

    public boolean containsProperty(String namespaceURI, String localPart) {
        return properties.getOrDefault(namespaceURI, Collections.emptySet()).contains(localPart);
    }

    public boolean containsProperty(QName property) {
        return containsProperty(property.getNamespaceURI(), property.getLocalPart());
    }

    public ChunkOptions withProperty(String namespaceURI, String localPart) {
        properties.computeIfAbsent(namespaceURI, v -> new HashSet<>()).add(localPart);
        return this;
    }

    public ChunkOptions withProperty(QName property) {
        return withProperty(property.getNamespaceURI(), property.getLocalPart());
    }

    public ChunkOptions withProperties(Collection<QName> properties) {
        if (properties != null) {
            properties.forEach(this::withProperty);
        }

        return this;
    }

    public boolean isExcludeFeature(String namespaceURI, String localPart) {
        return excludes.getOrDefault(namespaceURI, Collections.emptySet()).contains(localPart);
    }

    public boolean isExcludeFeature(QName feature) {
        return isExcludeFeature(feature.getNamespaceURI(), feature.getLocalPart());
    }

    public ChunkOptions excludeFeature(String namespaceURI, String localPart) {
        excludes.computeIfAbsent(namespaceURI, v -> new HashSet<>()).add(localPart);
        return this;
    }

    public ChunkOptions excludeFeature(QName feature) {
        return excludeFeature(feature.getNamespaceURI(), feature.getLocalPart());
    }

    public ChunkOptions excludeFeatures(Collection<QName> features) {
        if (features != null) {
            features.forEach(this::excludeFeature);
        }

        return this;
    }

    public boolean isSkipCityModel() {
        return skipCityModel;
    }

    public ChunkOptions skipCityModel(boolean skipCityModel) {
        this.skipCityModel = skipCityModel;
        return this;
    }

    public boolean isKeepInlineAppearance() {
        return keepInlineAppearance;
    }

    public ChunkOptions keepInlineAppearance(boolean keepInlineAppearance) {
        this.keepInlineAppearance = keepInlineAppearance;
        return this;
    }

    public ChunkOptions addCityModelMemberProperties() {
        return withProperty(CoreModule.v3_0.getNamespaceURI(), "cityObjectMember")
                .withProperty(CoreModule.v3_0.getNamespaceURI(), "appearanceMember")
                .withProperty(CoreModule.v3_0.getNamespaceURI(), "featureMember")
                .withProperty(CoreModule.v3_0.getNamespaceURI(), "versionMember")
                .withProperty(CoreModule.v3_0.getNamespaceURI(), "versionTransitionMember")
                .withProperty(CoreModule.v2_0.getNamespaceURI(), "cityObjectMember")
                .withProperty(AppearanceModule.v2_0.getNamespaceURI(), "appearanceMember")
                .withProperty(CoreModule.v1_0.getNamespaceURI(), "cityObjectMember")
                .withProperty(AppearanceModule.v1_0.getNamespaceURI(), "appearanceMember")
                .withProperty(GMLCoreModule.v3_1.getNamespaceURI(), "featureMember")
                .withProperty(GMLCoreModule.v3_1.getNamespaceURI(), "featureMembers");
    }

    public ChunkOptions addGroupMemberProperties() {
        return withProperty(CoreModule.v2_0.getNamespaceURI(), "groupMember")
                .withProperty(AppearanceModule.v2_0.getNamespaceURI(), "parent")
                .withProperty(CoreModule.v1_0.getNamespaceURI(), "groupMember")
                .withProperty(AppearanceModule.v1_0.getNamespaceURI(), "parent");
    }
}
