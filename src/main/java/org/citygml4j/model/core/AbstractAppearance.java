package org.citygml4j.model.core;

import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractAppearance extends AbstractFeatureWithLifespan {
    private List<ADEOfAbstractAppearance> adeOfAbstractAppearance;

    public List<ADEOfAbstractAppearance> getADEOfAbstractAppearance() {
        if (adeOfAbstractAppearance == null)
            adeOfAbstractAppearance = new ChildList<>(this);

        return adeOfAbstractAppearance;
    }

    public void setADEOfAbstractAppearance(List<ADEOfAbstractAppearance> adeOfAbstractAppearance) {
        this.adeOfAbstractAppearance = asChild(adeOfAbstractAppearance);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
    }
}
