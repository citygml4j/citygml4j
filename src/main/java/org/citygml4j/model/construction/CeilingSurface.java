package org.citygml4j.model.construction;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class CeilingSurface extends AbstractConstructionSurface {
    private List<ADEOfCeilingSurface> adeOfCeilingSurface;

    public List<ADEOfCeilingSurface> getADEOfCeilingSurface() {
        if (adeOfCeilingSurface == null)
            adeOfCeilingSurface = new ChildList<>(this);

        return adeOfCeilingSurface;
    }

    public void setADEOfCeilingSurface(List<ADEOfCeilingSurface> adeOfCeilingSurface) {
        this.adeOfCeilingSurface = asChild(adeOfCeilingSurface);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeProperties != null) {
            for (ADEOfCeilingSurface<?> property : adeProperties)
                updateEnvelope(property, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEOfCeilingSurface<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
