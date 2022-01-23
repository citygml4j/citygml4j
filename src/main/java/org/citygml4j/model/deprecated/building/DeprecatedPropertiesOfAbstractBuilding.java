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

package org.citygml4j.model.deprecated.building;

import org.citygml4j.model.building.BuildingPartProperty;
import org.citygml4j.model.deprecated.core.DeprecatedPropertiesOfAbstractCityObject;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class DeprecatedPropertiesOfAbstractBuilding extends DeprecatedPropertiesOfAbstractCityObject {
    private List<BuildingPartProperty> consistsOfBuildingParts;
    private MultiSurfaceProperty lod0RoofEdge;
    private MultiSurfaceProperty lod1MultiSurface;
    private MultiCurveProperty lod4MultiCurve;
    private MultiSurfaceProperty lod4MultiSurface;
    private SolidProperty lod4Solid;
    private MultiCurveProperty lod4TerrainIntersectionCurve;

    public List<BuildingPartProperty> getConsistsOfBuildingParts() {
        if (consistsOfBuildingParts == null)
            consistsOfBuildingParts = new ChildList<>(this);

        return consistsOfBuildingParts;
    }

    public boolean isSetConsistsOfBuildingParts() {
        return consistsOfBuildingParts != null && !consistsOfBuildingParts.isEmpty();
    }

    public void setConsistsOfBuildingParts(List<BuildingPartProperty> consistsOfBuildingParts) {
        this.consistsOfBuildingParts = asChild(consistsOfBuildingParts);
    }

    public MultiSurfaceProperty getLod0RoofEdge() {
        return lod0RoofEdge;
    }

    public void setLod0RoofEdge(MultiSurfaceProperty lod0RoofEdge) {
        this.lod0RoofEdge = asChild(lod0RoofEdge);
    }

    public MultiSurfaceProperty getLod1MultiSurface() {
        return lod1MultiSurface;
    }

    public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
        this.lod1MultiSurface = asChild(lod1MultiSurface);
    }

    public MultiSurfaceProperty getLod4MultiSurface() {
        return lod4MultiSurface;
    }

    public MultiCurveProperty getLod4MultiCurve() {
        return lod4MultiCurve;
    }

    public void setLod4MultiCurve(MultiCurveProperty lod4MultiCurve) {
        this.lod4MultiCurve = asChild(lod4MultiCurve);
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
