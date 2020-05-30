package org.citygml4j.model.waterbody;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class WaterGroundSurface extends AbstractWaterBoundarySurface {
    private List<ADEOfWaterGroundSurface> adeOfWaterGroundSurface;

    public List<ADEOfWaterGroundSurface> getADEOfWaterGroundSurface() {
        if (adeOfWaterGroundSurface == null)
            adeOfWaterGroundSurface = new ChildList<>(this);

        return adeOfWaterGroundSurface;
    }

    public void setADEOfWaterGroundSurface(List<ADEOfWaterGroundSurface> adeOfWaterGroundSurface) {
        this.adeOfWaterGroundSurface = asChild(adeOfWaterGroundSurface);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfWaterGroundSurface != null) {
            for (ADEOfWaterGroundSurface container : adeOfWaterGroundSurface)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfWaterGroundSurface != null) {
            for (ADEOfWaterGroundSurface container : adeOfWaterGroundSurface)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
