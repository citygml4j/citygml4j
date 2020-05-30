package org.citygml4j.model.construction;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class GroundSurface extends AbstractConstructionSurface {
    private List<ADEOfGroundSurface> adeOfGroundSurface;

    public List<ADEOfGroundSurface> getADEOfGroundSurface() {
        if (adeOfGroundSurface == null)
            adeOfGroundSurface = new ChildList<>(this);

        return adeOfGroundSurface;
    }

    public void setADEOfGroundSurface(List<ADEOfGroundSurface> adeOfGroundSurface) {
        this.adeOfGroundSurface = asChild(adeOfGroundSurface);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfGroundSurface != null) {
            for (ADEOfGroundSurface container : adeOfGroundSurface)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEOfGroundSurface<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
