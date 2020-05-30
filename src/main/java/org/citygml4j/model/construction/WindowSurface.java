package org.citygml4j.model.construction;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class WindowSurface extends AbstractFillingSurface {
    private List<ADEOfWindowSurface> adeOfWindowSurface;

    public List<ADEOfWindowSurface> getADEOfWindowSurface() {
        if (adeOfWindowSurface == null)
            adeOfWindowSurface = new ChildList<>(this);

        return adeOfWindowSurface;
    }

    public void setADEOfWindowSurface(List<ADEOfWindowSurface> adeOfWindowSurface) {
        this.adeOfWindowSurface = asChild(adeOfWindowSurface);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfWindowSurface != null) {
            for (ADEOfWindowSurface container : adeOfWindowSurface)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfWindowSurface != null) {
            for (ADEOfWindowSurface container : adeOfWindowSurface)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
