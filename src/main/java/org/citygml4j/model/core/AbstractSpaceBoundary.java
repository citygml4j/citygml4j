package org.citygml4j.model.core;

import org.citygml4j.model.common.GeometryInfo;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractSpaceBoundary extends AbstractCityObject {
    private List<ADEOfAbstractSpaceBoundary> adeOfAbstractSpaceBoundary;

    public List<ADEOfAbstractSpaceBoundary> getADEOfAbstractSpaceBoundary() {
        if (adeOfAbstractSpaceBoundary == null)
            adeOfAbstractSpaceBoundary = new ChildList<>(this);

        return adeOfAbstractSpaceBoundary;
    }

    public void setADEOfAbstractSpaceBoundary(List<ADEOfAbstractSpaceBoundary> adeOfAbstractSpaceBoundary) {
        this.adeOfAbstractSpaceBoundary = asChild(adeOfAbstractSpaceBoundary);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfAbstractSpaceBoundary != null) {
            for (ADEOfAbstractSpaceBoundary container : adeOfAbstractSpaceBoundary)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfAbstractSpaceBoundary != null) {
            for (ADEOfAbstractSpaceBoundary container : adeOfAbstractSpaceBoundary)
                updateGeometryInfo(container, geometryInfo);
        }
    }
}
