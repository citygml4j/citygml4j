/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractSpace extends AbstractCityObject {
    private SpaceType spaceType;
    private List<QualifiedVolumeProperty> volumes;
    private List<QualifiedAreaProperty> areas;
    private List<AbstractSpaceBoundaryProperty> boundaries;
    private PointProperty lod0Point;
    private MultiSurfaceProperty lod0MultiSurface;
    private MultiCurveProperty lod0MultiCurve;
    private SolidProperty lod1Solid;
    private SolidProperty lod2Solid;
    private MultiSurfaceProperty lod2MultiSurface;
    private MultiCurveProperty lod2MultiCurve;
    private SolidProperty lod3Solid;
    private MultiSurfaceProperty lod3MultiSurface;
    private MultiCurveProperty lod3MultiCurve;

    public abstract boolean isValidBoundary(Class<? extends AbstractSpaceBoundary> type);

    public SpaceType getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(SpaceType spaceType) {
        this.spaceType = spaceType;
    }

    public List<QualifiedVolumeProperty> getVolumes() {
        if (volumes == null)
            volumes = new ChildList<>(this);

        return volumes;
    }

    public boolean isSetVolumes() {
        return volumes != null && !volumes.isEmpty();
    }

    public void setVolumes(List<QualifiedVolumeProperty> volumes) {
        this.volumes = asChild(volumes);
    }

    public List<QualifiedAreaProperty> getAreas() {
        if (areas == null)
            areas = new ChildList<>(this);

        return areas;
    }

    public boolean isSetAreas() {
        return areas != null && !areas.isEmpty();
    }

    public void setAreas(List<QualifiedAreaProperty> areas) {
        this.areas = areas;
    }

    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary != null && isValidBoundary(boundary.getClass());
    }

    public boolean isValidBoundary(AbstractSpaceBoundaryProperty property) {
        return property == null || property.getObject() == null || isValidBoundary(property.getObject());
    }

    public List<AbstractSpaceBoundaryProperty> getBoundaries() {
        if (boundaries == null)
            boundaries = new ChildList<>(this);

        return boundaries;
    }

    public boolean isSetBoundaries() {
        return boundaries != null && !boundaries.isEmpty();
    }

    public void setBoundaries(List<AbstractSpaceBoundaryProperty> boundaries) {
        this.boundaries = asChild(boundaries);
        if (this.boundaries != null)
            this.boundaries.removeIf(property -> !isValidBoundary(property));
    }

    public boolean addBoundary(AbstractSpaceBoundaryProperty property) {
        if (isValidBoundary(property)) {
            getBoundaries().add(property);
            return true;
        } else {
            return false;
        }
    }

    public PointProperty getLod0Point() {
        return lod0Point;
    }

    public void setLod0Point(PointProperty lod0Point) {
        this.lod0Point = asChild(lod0Point);
    }

    public MultiSurfaceProperty getLod0MultiSurface() {
        return lod0MultiSurface;
    }

    public void setLod0MultiSurface(MultiSurfaceProperty lod0MultiSurface) {
        this.lod0MultiSurface = asChild(lod0MultiSurface);
    }

    public MultiCurveProperty getLod0MultiCurve() {
        return lod0MultiCurve;
    }

    public void setLod0MultiCurve(MultiCurveProperty lod0MultiCurve) {
        this.lod0MultiCurve = asChild(lod0MultiCurve);
    }

    public SolidProperty getLod1Solid() {
        return lod1Solid;
    }

    public void setLod1Solid(SolidProperty lod1Solid) {
        this.lod1Solid = asChild(lod1Solid);
    }

    public SolidProperty getLod2Solid() {
        return lod2Solid;
    }

    public void setLod2Solid(SolidProperty lod2Solid) {
        this.lod2Solid = asChild(lod2Solid);
    }

    public MultiSurfaceProperty getLod2MultiSurface() {
        return lod2MultiSurface;
    }

    public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
        this.lod2MultiSurface = asChild(lod2MultiSurface);
    }

    public MultiCurveProperty getLod2MultiCurve() {
        return lod2MultiCurve;
    }

    public void setLod2MultiCurve(MultiCurveProperty lod2MultiCurve) {
        this.lod2MultiCurve = asChild(lod2MultiCurve);
    }

    public SolidProperty getLod3Solid() {
        return lod3Solid;
    }

    public void setLod3Solid(SolidProperty lod3Solid) {
        this.lod3Solid = asChild(lod3Solid);
    }

    public MultiSurfaceProperty getLod3MultiSurface() {
        return lod3MultiSurface;
    }

    public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
        this.lod3MultiSurface = asChild(lod3MultiSurface);
    }

    public MultiCurveProperty getLod3MultiCurve() {
        return lod3MultiCurve;
    }

    public void setLod3MultiCurve(MultiCurveProperty lod3MultiCurve) {
        this.lod3MultiCurve = asChild(lod3MultiCurve);
    }

    public SolidProperty getSolid(int lod) {
        switch (lod) {
            case 1:
                return getLod1Solid();
            case 2:
                return getLod2Solid();
            case 3:
                return getLod3Solid();
            default:
                return null;
        }
    }

    public boolean setSolid(int lod, SolidProperty property) {
        switch (lod) {
            case 1:
                setLod1Solid(property);
                return true;
            case 2:
                setLod2Solid(property);
                return true;
            case 3:
                setLod3Solid(property);
                return true;
            default:
                return false;
        }
    }

    public MultiSurfaceProperty getMultiSurface(int lod) {
        switch (lod) {
            case 0:
                return getLod0MultiSurface();
            case 2:
                return getLod2MultiSurface();
            case 3:
                return getLod3MultiSurface();
            default:
                return null;
        }
    }

    public boolean setMultiSurface(int lod, MultiSurfaceProperty property) {
        switch (lod) {
            case 0:
                setLod0MultiSurface(property);
                return true;
            case 2:
                setLod2MultiSurface(property);
                return true;
            case 3:
                setLod3MultiSurface(property);
                return true;
            default:
                return false;
        }
    }

    public MultiCurveProperty getMultiCurve(int lod) {
        switch (lod) {
            case 0:
                return getLod0MultiCurve();
            case 2:
                return getLod2MultiCurve();
            case 3:
                return getLod3MultiCurve();
            default:
                return null;
        }
    }

    public boolean setMultiCurve(int lod, MultiCurveProperty property) {
        switch (lod) {
            case 0:
                setLod0MultiCurve(property);
                return true;
            case 2:
                setLod2MultiCurve(property);
                return true;
            case 3:
                setLod3MultiCurve(property);
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (boundaries != null) {
            for (AbstractSpaceBoundaryProperty property : boundaries) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope(options));
            }
        }

        if (lod0Point != null && lod0Point.getObject() != null)
            envelope.include(lod0Point.getObject().computeEnvelope());

        for (int lod = 0; lod < 4; lod++) {
            MultiCurveProperty curveProperty = getMultiCurve(lod);
            if (curveProperty != null && curveProperty.getObject() != null)
                envelope.include(curveProperty.getObject().computeEnvelope());
        }

        for (int lod = 0; lod < 4; lod++) {
            MultiSurfaceProperty surfaceProperty = getMultiSurface(lod);
            if (surfaceProperty != null && surfaceProperty.getObject() != null)
                envelope.include(surfaceProperty.getObject().computeEnvelope());
        }

        for (int lod = 0; lod < 4; lod++) {
            SolidProperty solidProperty = getSolid(lod);
            if (solidProperty != null && solidProperty.getObject() != null)
                envelope.include(solidProperty.getObject().computeEnvelope());
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        geometryInfo.addGeometry(0, lod0Point);

        for (int lod = 0; lod < 4; lod++)
            geometryInfo.addGeometry(lod, getMultiCurve(lod));

        for (int lod = 0; lod < 4; lod++)
            geometryInfo.addGeometry(lod, getMultiSurface(lod));

        for (int lod = 0; lod < 4; lod++)
            geometryInfo.addGeometry(lod, getSolid(lod));
    }
}
