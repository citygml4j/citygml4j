package org.citygml4j.model.construction;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.core.AbstractThematicSurface;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractConstructionSurface extends AbstractThematicSurface {
    private List<AbstractFillingSurfaceProperty> fillingSurfaces;
    private List<ADEOfAbstractConstructionSurface> adeOfAbstractConstructionSurface;

    public List<AbstractFillingSurfaceProperty> getFillingSurfaces() {
        if (fillingSurfaces == null)
            fillingSurfaces = new ChildList<>(this);

        return fillingSurfaces;
    }

    public void setFillingSurfaces(List<AbstractFillingSurfaceProperty> fillingSurfaces) {
        this.fillingSurfaces = asChild(fillingSurfaces);
    }

    public List<ADEOfAbstractConstructionSurface> getADEOfAbstractConstructionSurface() {
        if (adeOfAbstractConstructionSurface == null)
            adeOfAbstractConstructionSurface = new ChildList<>(this);

        return adeOfAbstractConstructionSurface;
    }

    public void setADEOfAbstractConstructionSurface(List<ADEOfAbstractConstructionSurface> adeOfAbstractConstructionSurface) {
        this.adeOfAbstractConstructionSurface = asChild(adeOfAbstractConstructionSurface);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeProperties != null) {
            for (ADEOfAbstractConstructionSurface<?> property : adeProperties)
                updateEnvelope(property, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEOfAbstractConstructionSurface<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }
}
