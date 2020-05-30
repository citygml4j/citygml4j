package org.citygml4j.model.construction;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class InteriorWallSurface extends AbstractConstructionSurface {
    private List<ADEOfInteriorWallSurface> adeOfInteriorWallSurface;

    public List<ADEOfInteriorWallSurface> getADEOfInteriorWallSurface() {
        if (adeOfInteriorWallSurface == null)
            adeOfInteriorWallSurface = new ChildList<>(this);

        return adeOfInteriorWallSurface;
    }

    public void setADEOfInteriorWallSurface(List<ADEOfInteriorWallSurface> adeOfInteriorWallSurface) {
        this.adeOfInteriorWallSurface = asChild(adeOfInteriorWallSurface);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfInteriorWallSurface != null) {
            for (ADEOfInteriorWallSurface container : adeOfInteriorWallSurface)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEOfInteriorWallSurface<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
