/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.common.GeometryInfo;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;
import org.xmlobjects.gml.util.EnvelopeOptions;

public abstract class AbstractPhysicalSpace extends AbstractSpace {
    private MultiCurveProperty lod1TerrainIntersectionCurve;
    private MultiCurveProperty lod2TerrainIntersectionCurve;
    private MultiCurveProperty lod3TerrainIntersectionCurve;
    private AbstractPointCloudProperty pointCloud;

    public MultiCurveProperty getLod1TerrainIntersectionCurve() {
        return lod1TerrainIntersectionCurve;
    }

    public void setLod1TerrainIntersectionCurve(MultiCurveProperty lod1TerrainIntersectionCurve) {
        this.lod1TerrainIntersectionCurve = asChild(lod1TerrainIntersectionCurve);
    }

    public MultiCurveProperty getLod2TerrainIntersectionCurve() {
        return lod2TerrainIntersectionCurve;
    }

    public void setLod2TerrainIntersectionCurve(MultiCurveProperty lod2TerrainIntersectionCurve) {
        this.lod2TerrainIntersectionCurve = asChild(lod2TerrainIntersectionCurve);
    }

    public MultiCurveProperty getLod3TerrainIntersectionCurve() {
        return lod3TerrainIntersectionCurve;
    }

    public void setLod3TerrainIntersectionCurve(MultiCurveProperty lod3TerrainIntersectionCurve) {
        this.lod3TerrainIntersectionCurve = asChild(lod3TerrainIntersectionCurve);
    }

    public AbstractPointCloudProperty getPointCloud() {
        return pointCloud;
    }

    public void setPointCloud(AbstractPointCloudProperty pointCloud) {
        this.pointCloud = asChild(pointCloud);
    }

    public MultiCurveProperty getTerrainIntersectionCurve(int lod) {
        return switch (lod) {
            case 1 -> getLod1TerrainIntersectionCurve();
            case 2 -> getLod2TerrainIntersectionCurve();
            case 3 -> getLod3TerrainIntersectionCurve();
            default -> null;
        };
    }

    public boolean setTerrainIntersectionCurve(int lod, MultiCurveProperty property) {
        return switch (lod) {
            case 1 -> {
                setLod1TerrainIntersectionCurve(property);
                yield true;
            }
            case 2 -> {
                setLod2TerrainIntersectionCurve(property);
                yield true;
            }
            case 3 -> {
                setLod3TerrainIntersectionCurve(property);
                yield true;
            }
            default -> false;
        };
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (pointCloud != null && pointCloud.getObject() != null)
            envelope.include(pointCloud.getObject().computeEnvelope(options));
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        for (int lod = 1; lod < 4; lod++) {
            geometryInfo.addGeometry(lod, getTerrainIntersectionCurve(lod));
        }
    }
}
