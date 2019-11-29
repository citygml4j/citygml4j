package org.citygml4j.model.deprecated.bridge;

import org.citygml4j.model.core.ImplicitGeometryProperty;
import org.citygml4j.model.deprecated.core.DeprecatedPropertiesOfAbstractCityObject;
import org.xmlobjects.gml.model.geometry.GeometryProperty;

public class DeprecatedPropertiesOfBridgeInstallation extends DeprecatedPropertiesOfAbstractCityObject {
    private GeometryProperty<?> lod2Geometry;
    private GeometryProperty<?> lod3Geometry;
    private GeometryProperty<?> lod4Geometry;
    private ImplicitGeometryProperty lod4ImplicitRepresentation;

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

    public ImplicitGeometryProperty getLod4ImplicitRepresentation() {
        return lod4ImplicitRepresentation;
    }

    public void setLod4ImplicitRepresentation(ImplicitGeometryProperty lod4ImplicitRepresentation) {
        this.lod4ImplicitRepresentation = asChild(lod4ImplicitRepresentation);
    }
}
