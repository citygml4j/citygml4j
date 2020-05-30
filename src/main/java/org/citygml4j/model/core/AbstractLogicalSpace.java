package org.citygml4j.model.core;

import org.citygml4j.model.common.GeometryInfo;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractLogicalSpace extends AbstractSpace {
    private List<ADEOfAbstractLogicalSpace> adeOfAbstractLogicalSpace;

    public List<ADEOfAbstractLogicalSpace> getADEOfAbstractLogicalSpace() {
        if (adeOfAbstractLogicalSpace == null)
            adeOfAbstractLogicalSpace = new ChildList<>(this);

        return adeOfAbstractLogicalSpace;
    }

    public void setADEOfAbstractLogicalSpace(List<ADEOfAbstractLogicalSpace> adeOfAbstractLogicalSpace) {
        this.adeOfAbstractLogicalSpace = asChild(adeOfAbstractLogicalSpace);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (adeOfAbstractLogicalSpace != null) {
            for (ADEOfAbstractLogicalSpace container : adeOfAbstractLogicalSpace)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEOfAbstractLogicalSpace<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }
}
