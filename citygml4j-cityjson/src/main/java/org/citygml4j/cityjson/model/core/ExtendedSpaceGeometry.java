/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.model.core;

import org.citygml4j.core.model.common.GeometryInfo;
import org.citygml4j.core.model.common.LevelOfDetail;
import org.citygml4j.core.model.core.ADEOfAbstractSpace;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;

public class ExtendedSpaceGeometry extends ADEOfAbstractSpace {
    @LevelOfDetail(1)
    MultiSurfaceProperty lod1MultiSurface;

    public MultiSurfaceProperty getLod1MultiSurface() {
        return lod1MultiSurface;
    }

    public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
        this.lod1MultiSurface = asChild(lod1MultiSurface);
    }

    @Override
    public void updateGeometryInfo(GeometryInfo geometryInfo) {
        if (lod1MultiSurface != null) {
            geometryInfo.addGeometry(1, lod1MultiSurface);
        }
    }
}
