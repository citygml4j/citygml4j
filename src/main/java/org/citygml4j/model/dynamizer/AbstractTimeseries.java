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
    private List<ADEOfAbstractTimeseries> adeOfAbstractTimeseries;

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

    public List<ADEOfAbstractTimeseries> getADEOfAbstractTimeseries() {
        if (adeOfAbstractTimeseries == null)
            adeOfAbstractTimeseries = new ChildList<>(this);

        return adeOfAbstractTimeseries;
    }

    public void setADEOfAbstractTimeseries(List<ADEOfAbstractTimeseries> adeOfAbstractTimeseries) {
        this.adeOfAbstractTimeseries = asChild(adeOfAbstractTimeseries);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
    }
}
