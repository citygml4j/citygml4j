package org.citygml4j.model.core;

import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractDynamizer extends AbstractFeatureWithLifespan {
    private List<ADEOfAbstractDynamizer> adeOfAbstractDynamizer;

    public List<ADEOfAbstractDynamizer> getADEOfAbstractDynamizer() {
        if (adeOfAbstractDynamizer == null)
            adeOfAbstractDynamizer = new ChildList<>(this);

        return adeOfAbstractDynamizer;
    }

    public void setADEOfAbstractDynamizer(List<ADEOfAbstractDynamizer> adeOfAbstractDynamizer) {
        this.adeOfAbstractDynamizer = asChild(adeOfAbstractDynamizer);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
    }
}
