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

package org.citygml4j.model.deprecated.tunnel;

import org.citygml4j.model.deprecated.core.DeprecatedPropertiesOfAbstractCityObject;
import org.citygml4j.model.tunnel.TunnelPartProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class DeprecatedPropertiesOfAbstractTunnel extends DeprecatedPropertiesOfAbstractCityObject {
    private List<TunnelPartProperty> consistsOfTunnelParts;
    private MultiSurfaceProperty lod1MultiSurface;
    private MultiCurveProperty lod4MultiCurve;
    private MultiSurfaceProperty lod4MultiSurface;
    private SolidProperty lod4Solid;
    private MultiCurveProperty lod4TerrainIntersectionCurve;

    public List<TunnelPartProperty> getConsistsOfTunnelParts() {
        if (consistsOfTunnelParts == null)
            consistsOfTunnelParts = new ChildList<>(this);

        return consistsOfTunnelParts;
    }

    public boolean isSetConsistsOfTunnelParts() {
        return consistsOfTunnelParts != null && !consistsOfTunnelParts.isEmpty();
    }

    public void setConsistsOfTunnelParts(List<TunnelPartProperty> consistsOfTunnelParts) {
        this.consistsOfTunnelParts = asChild(consistsOfTunnelParts);
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
