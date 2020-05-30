package org.citygml4j.model.core;

import org.citygml4j.model.common.GeometryInfo;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractUnoccupiedSpace extends AbstractPhysicalSpace {
    private List<ADEOfAbstractUnoccupiedSpace> adeOfAbstractUnoccupiedSpace;

    public List<ADEOfAbstractUnoccupiedSpace> getADEOfAbstractUnoccupiedSpace() {
        if (adeOfAbstractUnoccupiedSpace == null)
            adeOfAbstractUnoccupiedSpace = new ChildList<>(this);

        return adeOfAbstractUnoccupiedSpace;
    }

    public void setADEOfAbstractUnoccupiedSpace(List<ADEOfAbstractUnoccupiedSpace> adeOfAbstractUnoccupiedSpace) {
        this.adeOfAbstractUnoccupiedSpace = asChild(adeOfAbstractUnoccupiedSpace);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfAbstractUnoccupiedSpace != null) {
            for (ADEOfAbstractUnoccupiedSpace container : adeOfAbstractUnoccupiedSpace)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEOfAbstractUnoccupiedSpace<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }
}
