/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ChunkingOptions {
    private final boolean chunkByFeatures;
    private final Set<QName> properties = new HashSet<>();
    private final Set<QName> excludes = new HashSet<>();

    private boolean skipCityModel = true;
    private boolean keepInlineAppearance = true;

    private ChunkingOptions(boolean chunkByFeatures) {
        this.chunkByFeatures = chunkByFeatures;
    }

    public static ChunkingOptions chunkByFeatures() {
        return new ChunkingOptions(true);
    }

    public static ChunkingOptions chunkByFeatureProperties() {
        return new ChunkingOptions(false);
    }

    public static ChunkingOptions chunkByFeatureProperties(Collection<QName> properties) {
        ChunkingOptions chunkingOptions = chunkByFeatureProperties();
        properties.forEach(chunkingOptions::chunkAtFeatureProperty);
        return chunkingOptions;
    }

    public static ChunkingOptions chunkByFeatureProperties(QName... properties) {
        return chunkByFeatureProperties(Arrays.asList(properties));
    }

    public static ChunkingOptions chunkByCityModelMembers() {
        return chunkByFeatureProperties().chunkAtCityModelMembers();
    }

    public boolean isChunkByFeatures() {
        return chunkByFeatures;
    }

    public boolean isSkipCityModel() {
        return skipCityModel;
    }

    public ChunkingOptions skipCityModel(boolean skipCityModel) {
        this.skipCityModel = skipCityModel;
        return this;
    }

    public boolean isKeepInlineAppearance() {
        return keepInlineAppearance;
    }

    public ChunkingOptions keepInlineAppearance(boolean keepInlineAppearance) {
        this.keepInlineAppearance = keepInlineAppearance;
        return this;
    }

    public boolean isChunkAtFeatureProperty(QName property) {
        return properties.contains(property);
    }

    public boolean isChunkAtFeatureProperty(String namespaceURI, String localPart) {
        return isChunkAtFeatureProperty(new QName(namespaceURI, localPart));
    }

    public ChunkingOptions chunkAtFeatureProperty(QName property) {
        properties.add(property);
        return this;
    }

    public ChunkingOptions chunkAtFeatureProperty(String namespaceURI, String localPart) {
        return chunkAtFeatureProperty(new QName(namespaceURI, localPart));
    }

    public ChunkingOptions chunkAtCityModelMembers() {
        // default CityGML 3.0 properties
        chunkAtFeatureProperty(CoreModule.v3_0.getNamespaceURI(), "cityObjectMember");
        chunkAtFeatureProperty(CoreModule.v3_0.getNamespaceURI(), "appearanceMember");
        chunkAtFeatureProperty(CoreModule.v3_0.getNamespaceURI(), "featureMember");
        chunkAtFeatureProperty(CoreModule.v3_0.getNamespaceURI(), "versionMember");
        chunkAtFeatureProperty(CoreModule.v3_0.getNamespaceURI(), "versionTransitionMember");

        // default CityGML 2.0 properties
        chunkAtFeatureProperty(CoreModule.v2_0.getNamespaceURI(), "cityObjectMember");
        chunkAtFeatureProperty(AppearanceModule.v2_0.getNamespaceURI(), "appearanceMember");

        // default CityGML 1.0 properties
        chunkAtFeatureProperty(CoreModule.v1_0.getNamespaceURI(), "cityObjectMember");
        chunkAtFeatureProperty(AppearanceModule.v1_0.getNamespaceURI(), "appearanceMember");

        // default GML properties
        chunkAtFeatureProperty(GMLCoreModule.v3_1.getNamespaceURI(), "featureMember");
        chunkAtFeatureProperty(GMLCoreModule.v3_1.getNamespaceURI(), "featureMembers");

        return this;
    }

    public boolean isExcludeFeatureFromChunking(QName feature) {
        return excludes.contains(feature);
    }

    public boolean isExcludeFeatureFromChunking(String namespaceURI, String localPart) {
        return isExcludeFeatureFromChunking(new QName(namespaceURI, localPart));
    }

    public ChunkingOptions excludeFeatureFromChunking(QName feature) {
        excludes.add(feature);
        return this;
    }

    public ChunkingOptions excludeFeatureFromChunking(String namespaceURI, String localPart) {
        return excludeFeatureFromChunking(new QName(namespaceURI, localPart));
    }
}
