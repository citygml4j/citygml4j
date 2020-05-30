package org.citygml4j.model.construction;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class RoofSurface extends AbstractConstructionSurface {
    private List<ADEOfRoofSurface> adeOfRoofSurface;

    public List<ADEOfRoofSurface> getADEOfRoofSurface() {
        if (adeOfRoofSurface == null)
            adeOfRoofSurface = new ChildList<>(this);

        return adeOfRoofSurface;
    }

    public void setADEOfRoofSurface(List<ADEOfRoofSurface> adeOfRoofSurface) {
        this.adeOfRoofSurface = asChild(adeOfRoofSurface);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfRoofSurface != null) {
            for (ADEOfRoofSurface container : adeOfRoofSurface)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEOfRoofSurface<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
