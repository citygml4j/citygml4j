package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.util.Envelopes;
import org.citygml4j.visitor.Visitable;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractPointCloud extends AbstractFeature implements CityGMLObject, Visitable {
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
                Envelopes.updateEnvelope(property, envelope, options);
        }
    }
}
