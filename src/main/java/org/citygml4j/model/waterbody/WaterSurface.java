package org.citygml4j.model.waterbody;

import org.citygml4j.model.core.GeometryInfo;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class WaterSurface extends AbstractWaterBoundarySurface {
    private Code waterLevel;
    private List<ADEPropertyOfWaterSurface<?>> adeProperties;

    public Code getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(Code waterLevel) {
        this.waterLevel = asChild(waterLevel);
    }

    public List<ADEPropertyOfWaterSurface<?>> getADEPropertiesOfWaterSurface() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfWaterSurface(List<ADEPropertyOfWaterSurface<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeProperties != null) {
            for (ADEPropertyOfWaterSurface<?> property : adeProperties)
                updateEnvelope(property, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEPropertyOfWaterSurface<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
