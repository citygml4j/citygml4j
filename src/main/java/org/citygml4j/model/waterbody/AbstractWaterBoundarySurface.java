package org.citygml4j.model.waterbody;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.core.AbstractThematicSurface;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractWaterBoundarySurface extends AbstractThematicSurface {
    private List<ADEOfAbstractWaterBoundarySurface> adeOfAbstractWaterBoundarySurface;

    public List<ADEOfAbstractWaterBoundarySurface> getADEOfAbstractWaterBoundarySurface() {
        if (adeOfAbstractWaterBoundarySurface == null)
            adeOfAbstractWaterBoundarySurface = new ChildList<>(this);

        return adeOfAbstractWaterBoundarySurface;
    }

    public void setADEOfAbstractWaterBoundarySurface(List<ADEOfAbstractWaterBoundarySurface> adeOfAbstractWaterBoundarySurface) {
        this.adeOfAbstractWaterBoundarySurface = asChild(adeOfAbstractWaterBoundarySurface);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeProperties != null) {
            for (ADEOfAbstractWaterBoundarySurface<?> property : adeProperties)
                updateEnvelope(property, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEOfAbstractWaterBoundarySurface<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }
}
