package org.citygml4j.model.core;

import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractPointCloud extends AbstractFeature {
    private List<ADEPropertyOfAbstractPointCloud<?>> adeProperties;

    public List<ADEPropertyOfAbstractPointCloud<?>> getADEPropertiesOfAbstractPointCloud() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractPointCloud(List<ADEPropertyOfAbstractPointCloud<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        if (adeProperties != null) {
            for (ADEPropertyOfAbstractPointCloud<?> property : adeProperties)
                updateEnvelope(property, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (adeProperties != null) {
            for (ADEPropertyOfAbstractPointCloud<?> property : adeProperties)
                updateGeometryInfo(property, geometryInfo);
        }
    }
}
