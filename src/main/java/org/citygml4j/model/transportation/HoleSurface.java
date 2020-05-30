package org.citygml4j.model.transportation;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.core.AbstractThematicSurface;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class HoleSurface extends AbstractThematicSurface {
    private List<ADEOfHoleSurface> adeOfHoleSurface;

    public List<ADEOfHoleSurface> getADEOfHoleSurface() {
        if (adeOfHoleSurface == null)
            adeOfHoleSurface = new ChildList<>(this);

        return adeOfHoleSurface;
    }

    public void setADEOfHoleSurface(List<ADEOfHoleSurface> adeOfHoleSurface) {
        this.adeOfHoleSurface = asChild(adeOfHoleSurface);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfHoleSurface != null) {
            for (ADEOfHoleSurface container : adeOfHoleSurface)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEOfHoleSurface<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
