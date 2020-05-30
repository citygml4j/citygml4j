package org.citygml4j.model.core;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class ClosureSurface extends AbstractThematicSurface {
    private List<ADEOfClosureSurface> adeOfClosureSurface;

    public List<ADEOfClosureSurface> getADEOfClosureSurface() {
        if (adeOfClosureSurface == null)
            adeOfClosureSurface = new ChildList<>(this);

        return adeOfClosureSurface;
    }

    public void setADEOfClosureSurface(List<ADEOfClosureSurface> adeOfClosureSurface) {
        this.adeOfClosureSurface = asChild(adeOfClosureSurface);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfClosureSurface != null) {
            for (ADEOfClosureSurface container : adeOfClosureSurface)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfClosureSurface != null) {
            for (ADEOfClosureSurface container : adeOfClosureSurface)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
