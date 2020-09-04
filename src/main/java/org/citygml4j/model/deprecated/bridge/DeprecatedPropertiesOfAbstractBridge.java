/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.model.deprecated.bridge;

import org.citygml4j.model.bridge.BridgePartProperty;
import org.citygml4j.model.deprecated.core.DeprecatedPropertiesOfAbstractCityObject;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class DeprecatedPropertiesOfAbstractBridge extends DeprecatedPropertiesOfAbstractCityObject {
    private List<Reference> outerBridgeConstructions;
    private List<Reference> outerBridgeInstallations;
    private List<Reference> interiorBridgeInstallations;
    private List<Reference> interiorBridgeRooms;
    private List<BridgePartProperty> consistsOfBridgeParts;
    private MultiSurfaceProperty lod1MultiSurface;
    private MultiCurveProperty lod4MultiCurve;
    private MultiSurfaceProperty lod4MultiSurface;
    private SolidProperty lod4Solid;
    private MultiCurveProperty lod4TerrainIntersectionCurve;

    public List<Reference> getOuterBridgeConstructions() {
        if (outerBridgeConstructions == null)
            outerBridgeConstructions = new ChildList<>(this);

        return outerBridgeConstructions;
    }

    public void setOuterBridgeConstructions(List<Reference> outerBridgeConstructions) {
        this.outerBridgeConstructions = asChild(outerBridgeConstructions);
    }

    public List<Reference> getOuterBridgeInstallations() {
        if (outerBridgeInstallations == null)
            outerBridgeInstallations = new ChildList<>(this);

        return outerBridgeInstallations;
    }

    public void setOuterBridgeInstallations(List<Reference> outerBridgeInstallations) {
        this.outerBridgeInstallations = asChild(outerBridgeInstallations);
    }

    public List<Reference> getInteriorBridgeInstallations() {
        if (interiorBridgeInstallations == null)
            interiorBridgeInstallations = new ChildList<>(this);

        return interiorBridgeInstallations;
    }

    public void setInteriorBridgeInstallations(List<Reference> interiorBridgeInstallations) {
        this.interiorBridgeInstallations = asChild(interiorBridgeInstallations);
    }

    public List<Reference> getInteriorBridgeRooms() {
        if (interiorBridgeRooms == null)
            interiorBridgeRooms = new ChildList<>(this);

        return interiorBridgeRooms;
    }

    public void setInteriorBridgeRooms(List<Reference> interiorBridgeRooms) {
        this.interiorBridgeRooms = asChild(interiorBridgeRooms);
    }

    public List<BridgePartProperty> getConsistsOfBridgeParts() {
        if (consistsOfBridgeParts == null)
            consistsOfBridgeParts = new ChildList<>(this);

        return consistsOfBridgeParts;
    }

    public void setConsistsOfBridgeParts(List<BridgePartProperty> consistsOfBridgeParts) {
        this.consistsOfBridgeParts = asChild(consistsOfBridgeParts);
    }

    public MultiSurfaceProperty getLod1MultiSurface() {
        return lod1MultiSurface;
    }

    public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
        this.lod1MultiSurface = asChild(lod1MultiSurface);
    }

    public MultiCurveProperty getLod4MultiCurve() {
        return lod4MultiCurve;
    }

    public void setLod4MultiCurve(MultiCurveProperty lod4MultiCurve) {
        this.lod4MultiCurve = asChild(lod4MultiCurve);
    }

    public MultiSurfaceProperty getLod4MultiSurface() {
        return lod4MultiSurface;
    }

    public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
        this.lod4MultiSurface = asChild(lod4MultiSurface);
    }

    public SolidProperty getLod4Solid() {
        return lod4Solid;
    }

    public void setLod4Solid(SolidProperty lod4Solid) {
        this.lod4Solid = asChild(lod4Solid);
    }

    public MultiCurveProperty getLod4TerrainIntersectionCurve() {
        return lod4TerrainIntersectionCurve;
    }

    public void setLod4TerrainIntersectionCurve(MultiCurveProperty lod4TerrainIntersectionCurve) {
        this.lod4TerrainIntersectionCurve = asChild(lod4TerrainIntersectionCurve);
    }
}
