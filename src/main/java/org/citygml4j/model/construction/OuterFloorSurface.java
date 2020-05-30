package org.citygml4j.model.construction;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class OuterFloorSurface extends AbstractConstructionSurface {
    private List<ADEOfOuterFloorSurface> adeOfOuterFloorSurface;

    public List<ADEOfOuterFloorSurface> getADEOfOuterFloorSurface() {
        if (adeOfOuterFloorSurface == null)
            adeOfOuterFloorSurface = new ChildList<>(this);

        return adeOfOuterFloorSurface;
    }

    public void setADEOfOuterFloorSurface(List<ADEOfOuterFloorSurface> adeOfOuterFloorSurface) {
        this.adeOfOuterFloorSurface = asChild(adeOfOuterFloorSurface);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfOuterFloorSurface != null) {
            for (ADEOfOuterFloorSurface container : adeOfOuterFloorSurface)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEOfOuterFloorSurface<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
