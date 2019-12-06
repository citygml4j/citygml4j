package org.citygml4j.model.dynamizer;

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.model.common.Visitable;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.gml.model.temporal.TimePosition;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractTimeseries extends AbstractFeature implements CityGMLObject, Visitable {
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
}
