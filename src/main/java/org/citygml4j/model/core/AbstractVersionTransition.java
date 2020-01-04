package org.citygml4j.model.core;

import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractVersionTransition extends AbstractFeatureWithLifespan {
    private List<ADEPropertyOfAbstractVersionTransition<?>> adeProperties;

    public List<ADEPropertyOfAbstractVersionTransition<?>> getADEPropertiesOfAbstractVersionTransition() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractVersionTransition(List<ADEPropertyOfAbstractVersionTransition<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
    }
}
