package org.citygml4j.model.dynamizer;

import org.citygml4j.model.core.AbstractFeature;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.temporal.TimePosition;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractTimeseries extends AbstractFeature {
    private TimePosition firstTimestamp;
    private TimePosition lastTimestamp;
    private List<ADEPropertyOfAbstractTimeseries<?>> adeProperties;

    public TimePosition getFirstTimestamp() {
        return firstTimestamp;
    }

    public void setFirstTimestamp(TimePosition firstTimestamp) {
        this.firstTimestamp = asChild(firstTimestamp);
    }

    public TimePosition getLastTimestamp() {
        return lastTimestamp;
    }

    public void setLastTimestamp(TimePosition lastTimestamp) {
        this.lastTimestamp = asChild(lastTimestamp);
    }

    public List<ADEPropertyOfAbstractTimeseries<?>> getADEPropertiesOfAbstractTimeseries() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractTimeseries(List<ADEPropertyOfAbstractTimeseries<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
    }
}
