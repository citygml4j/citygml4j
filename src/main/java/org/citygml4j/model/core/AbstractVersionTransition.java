package org.citygml4j.model.core;

import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractVersionTransition extends AbstractFeatureWithLifespan {
    private List<ADEOfAbstractVersionTransition> adeOfAbstractVersionTransition;

    public List<ADEOfAbstractVersionTransition> getADEOfAbstractVersionTransition() {
        if (adeOfAbstractVersionTransition == null)
            adeOfAbstractVersionTransition = new ChildList<>(this);

        return adeOfAbstractVersionTransition;
    }

    public void setADEOfAbstractVersionTransition(List<ADEOfAbstractVersionTransition> adeOfAbstractVersionTransition) {
        this.adeOfAbstractVersionTransition = asChild(adeOfAbstractVersionTransition);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
    }
}
