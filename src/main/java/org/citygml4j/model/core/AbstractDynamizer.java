package org.citygml4j.model.core;

import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractDynamizer extends AbstractFeatureWithLifespan {
    private List<ADEPropertyOfAbstractDynamizer<?>> adeProperties;

    public List<ADEPropertyOfAbstractDynamizer<?>> getADEPropertiesOfAbstractDynamizer() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractDynamizer(List<ADEPropertyOfAbstractDynamizer<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    public void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
    }
}
