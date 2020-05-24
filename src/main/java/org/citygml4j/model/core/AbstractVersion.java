package org.citygml4j.model.core;

import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractVersion extends AbstractFeatureWithLifespan {
    private List<ADEOfAbstractVersion> adeOfAbstractVersion;

    public List<ADEOfAbstractVersion> getADEOfAbstractVersion() {
        if (adeOfAbstractVersion == null)
            adeOfAbstractVersion = new ChildList<>(this);

        return adeOfAbstractVersion;
    }

    public void setADEOfAbstractVersion(List<ADEOfAbstractVersion> adeOfAbstractVersion) {
        this.adeOfAbstractVersion = asChild(adeOfAbstractVersion);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
    }
}
