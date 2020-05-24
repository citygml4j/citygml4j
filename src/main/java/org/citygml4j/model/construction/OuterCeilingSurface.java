package org.citygml4j.model.construction;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class OuterCeilingSurface extends AbstractConstructionSurface {
    private List<ADEOfOuterCeilingSurface> adeOfOuterCeilingSurface;

    public List<ADEOfOuterCeilingSurface> getADEOfOuterCeilingSurface() {
        if (adeOfOuterCeilingSurface == null)
            adeOfOuterCeilingSurface = new ChildList<>(this);

        return adeOfOuterCeilingSurface;
    }

    public void setADEOfOuterCeilingSurface(List<ADEOfOuterCeilingSurface> adeOfOuterCeilingSurface) {
        this.adeOfOuterCeilingSurface = asChild(adeOfOuterCeilingSurface);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeProperties != null) {
            for (ADEOfOuterCeilingSurface<?> property : adeProperties)
                updateEnvelope(property, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEOfOuterCeilingSurface<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
