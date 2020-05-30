package org.citygml4j.model.construction;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class WallSurface extends AbstractConstructionSurface {
    private List<ADEOfWallSurface> adeOfWallSurface;

    public List<ADEOfWallSurface> getADEOfWallSurface() {
        if (adeOfWallSurface == null)
            adeOfWallSurface = new ChildList<>(this);

        return adeOfWallSurface;
    }

    public void setADEOfWallSurface(List<ADEOfWallSurface> adeOfWallSurface) {
        this.adeOfWallSurface = asChild(adeOfWallSurface);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfWallSurface != null) {
            for (ADEOfWallSurface container : adeOfWallSurface)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfWallSurface != null) {
            for (ADEOfWallSurface container : adeOfWallSurface)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
