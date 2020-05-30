package org.citygml4j.model.waterbody;

import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class WaterSurface extends AbstractWaterBoundarySurface {
    private Code waterLevel;
    private List<ADEOfWaterSurface> adeOfWaterSurface;

    public Code getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(Code waterLevel) {
        this.waterLevel = asChild(waterLevel);
    }

    public List<ADEOfWaterSurface> getADEOfWaterSurface() {
        if (adeOfWaterSurface == null)
            adeOfWaterSurface = new ChildList<>(this);

        return adeOfWaterSurface;
    }

    public void setADEOfWaterSurface(List<ADEOfWaterSurface> adeOfWaterSurface) {
        this.adeOfWaterSurface = asChild(adeOfWaterSurface);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfWaterSurface != null) {
            for (ADEOfWaterSurface container : adeOfWaterSurface)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeOfWaterSurface != null) {
            for (ADEOfWaterSurface container : adeOfWaterSurface)
                updateGeometryInfo(container, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
