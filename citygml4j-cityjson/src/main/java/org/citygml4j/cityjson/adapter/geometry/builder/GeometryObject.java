/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.cityjson.adapter.appearance.builder.AppearanceInfo;
import org.citygml4j.core.model.appearance.Appearance;
import org.citygml4j.core.model.core.AbstractSpaceBoundary;
import org.citygml4j.core.model.core.ImplicitGeometry;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;

import java.util.Collections;
import java.util.List;

public class GeometryObject {
    private AbstractGeometry geometry;
    private ImplicitGeometry implicitGeometry;
    private List<AbstractSpaceBoundary> boundaries;
    private AppearanceInfo appearanceInfo;

    private GeometryObject() {
    }

    static GeometryObject newInstance() {
        return new GeometryObject();
    }

    public AbstractGeometry getGeometry() {
        return geometry;
    }

    public <T extends AbstractGeometry> T getGeometry(Class<T> type) {
        return type.isInstance(geometry) ? type.cast(geometry) : null;
    }

    public boolean isSetGeometry() {
        return geometry != null;
    }

    void setGeometry(AbstractGeometry geometry) {
        this.geometry = geometry;
        implicitGeometry = null;
    }

    public ImplicitGeometry getImplicitGeometry() {
        return implicitGeometry;
    }

    public boolean isSetImplicitGeometry() {
        return implicitGeometry != null;
    }

    void setImplicitGeometry(ImplicitGeometry implicitGeometry) {
        this.implicitGeometry = implicitGeometry;
        geometry = null;
    }

    public List<AbstractSpaceBoundary> getBoundaries() {
        return hasBoundaries() ? boundaries : Collections.emptyList();
    }

    public boolean hasBoundaries() {
        return boundaries != null && !boundaries.isEmpty();
    }

    void setBoundaries(List<AbstractSpaceBoundary> boundaries) {
        this.boundaries = boundaries;
    }

    public List<Appearance> getAppearances() {
        return hasAppearances() ? appearanceInfo.getAppearances() : Collections.emptyList();
    }

    public boolean hasAppearances() {
        return appearanceInfo != null && appearanceInfo.hasAppearances();
    }

    AppearanceInfo getAppearanceInfo() {
        if (appearanceInfo == null) {
            appearanceInfo = new AppearanceInfo();
        }

        return appearanceInfo;
    }

    void setAppearanceInfo(AppearanceInfo appearanceInfo) {
        this.appearanceInfo = appearanceInfo;
    }

    void reset(boolean keepAppearances) {
        geometry = null;
        implicitGeometry = null;
        boundaries = null;
        if (!keepAppearances) {
            appearanceInfo = null;
        }
    }
}
