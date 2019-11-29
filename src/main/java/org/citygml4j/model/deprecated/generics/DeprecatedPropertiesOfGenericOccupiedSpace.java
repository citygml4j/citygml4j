package org.citygml4j.model.deprecated.generics;

import org.citygml4j.model.core.ImplicitGeometryProperty;
import org.citygml4j.model.deprecated.core.DeprecatedPropertiesOfAbstractCityObject;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;

public class DeprecatedPropertiesOfGenericOccupiedSpace extends DeprecatedPropertiesOfAbstractCityObject {
    private GeometryProperty<?> lod0Geometry;
    private GeometryProperty<?> lod1Geometry;
    private GeometryProperty<?> lod2Geometry;
    private GeometryProperty<?> lod3Geometry;
    private GeometryProperty<?> lod4Geometry;
    private MultiCurveProperty lod0TerrainIntersectionCurve;
    private MultiCurveProperty lod4TerrainIntersectionCurve;
    private ImplicitGeometryProperty lod0ImplicitRepresentation;
    private ImplicitGeometryProperty lod4ImplicitRepresentation;

    public GeometryProperty<?> getLod0Geometry() {
        return lod0Geometry;
    }

    public void setLod0Geometry(GeometryProperty<?> lod0Geometry) {
        this.lod0Geometry = asChild(lod0Geometry);
    }

    public GeometryProperty<?> getLod1Geometry() {
        return lod1Geometry;
    }

    public void setLod1Geometry(GeometryProperty<?> lod1Geometry) {
        this.lod1Geometry = asChild(lod1Geometry);
    }

    public GeometryProperty<?> getLod2Geometry() {
        return lod2Geometry;
    }

    public void setLod2Geometry(GeometryProperty<?> lod2Geometry) {
        this.lod2Geometry = asChild(lod2Geometry);
    }

    public GeometryProperty<?> getLod3Geometry() {
        return lod3Geometry;
    }

    public void setLod3Geometry(GeometryProperty<?> lod3Geometry) {
        this.lod3Geometry = asChild(lod3Geometry);
    }

    public GeometryProperty<?> getLod4Geometry() {
        return lod4Geometry;
    }

    public void setLod4Geometry(GeometryProperty<?> lod4Geometry) {
        this.lod4Geometry = asChild(lod4Geometry);
    }

    public MultiCurveProperty getLod0TerrainIntersectionCurve() {
        return lod0TerrainIntersectionCurve;
    }

    public void setLod0TerrainIntersectionCurve(MultiCurveProperty lod0TerrainIntersectionCurve) {
        this.lod0TerrainIntersectionCurve = asChild(lod0TerrainIntersectionCurve);
    }

    public MultiCurveProperty getLod4TerrainIntersectionCurve() {
        return lod4TerrainIntersectionCurve;
    }

    public void setLod4TerrainIntersectionCurve(MultiCurveProperty lod4TerrainIntersectionCurve) {
        this.lod4TerrainIntersectionCurve = asChild(lod4TerrainIntersectionCurve);
    }

    public ImplicitGeometryProperty getLod0ImplicitRepresentation() {
        return lod0ImplicitRepresentation;
    }

    public void setLod0ImplicitRepresentation(ImplicitGeometryProperty lod0ImplicitRepresentation) {
        this.lod0ImplicitRepresentation = asChild(lod0ImplicitRepresentation);
    }

    public ImplicitGeometryProperty getLod4ImplicitRepresentation() {
        return lod4ImplicitRepresentation;
    }

    public void setLod4ImplicitRepresentation(ImplicitGeometryProperty lod4ImplicitRepresentation) {
        this.lod4ImplicitRepresentation = asChild(lod4ImplicitRepresentation);
    }
}
