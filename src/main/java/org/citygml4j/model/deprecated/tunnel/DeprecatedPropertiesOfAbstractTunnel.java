package org.citygml4j.model.deprecated.tunnel;

import org.citygml4j.model.deprecated.core.DeprecatedPropertiesOfAbstractCityObject;
import org.citygml4j.model.tunnel.TunnelInstallationProperty;
import org.citygml4j.model.tunnel.TunnelPartProperty;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class DeprecatedPropertiesOfAbstractTunnel extends DeprecatedPropertiesOfAbstractCityObject {
    private List<TunnelInstallationProperty> outerTunnelInstallations;
    private List<TunnelInstallationProperty> interiorTunnelInstallations;
    private List<Reference> interiorHollowSpaces;
    private List<TunnelPartProperty> consistsOfTunnelParts;
    private MultiSurfaceProperty lod1MultiSurface;
    private MultiCurveProperty lod4MultiCurve;
    private MultiSurfaceProperty lod4MultiSurface;
    private SolidProperty lod4Solid;
    private MultiCurveProperty lod4TerrainIntersectionCurve;

    public List<TunnelInstallationProperty> getOuterTunnelInstallations() {
        if (outerTunnelInstallations == null)
            outerTunnelInstallations = new ChildList<>(this);

        return outerTunnelInstallations;
    }

    public void setOuterTunnelInstallations(List<TunnelInstallationProperty> outerTunnelInstallations) {
        this.outerTunnelInstallations = asChild(outerTunnelInstallations);
    }

    public List<TunnelInstallationProperty> getInteriorTunnelInstallations() {
        if (interiorTunnelInstallations == null)
            interiorTunnelInstallations = new ChildList<>(this);

        return interiorTunnelInstallations;
    }

    public void setInteriorTunnelInstallations(List<TunnelInstallationProperty> interiorTunnelInstallations) {
        this.interiorTunnelInstallations = asChild(interiorTunnelInstallations);
    }

    public List<Reference> getInteriorHollowSpaces() {
        if (interiorHollowSpaces == null)
            interiorHollowSpaces = new ChildList<>(this);

        return interiorHollowSpaces;
    }

    public void setInteriorHollowSpaces(List<Reference> interiorHollowSpaces) {
        this.interiorHollowSpaces = asChild(interiorHollowSpaces);
    }

    public List<TunnelPartProperty> getConsistsOfTunnelParts() {
        if (consistsOfTunnelParts == null)
            consistsOfTunnelParts = new ChildList<>(this);

        return consistsOfTunnelParts;
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
