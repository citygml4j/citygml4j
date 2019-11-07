package org.citygml4j.model.dynamizer;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.temporal.TimeDuration;

public class TimeseriesComponent extends GMLObject implements CityGMLObject {
    private Integer repetitions;
    private TimeDuration additionalGap;
    private AbstractTimeseriesProperty timeseries;

    public TimeseriesComponent() {
    }

    public TimeseriesComponent(Integer repetitions, AbstractTimeseriesProperty timeseries) {
        this.repetitions = repetitions;
        setTimeseries(timeseries);
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }

    public TimeDuration getAdditionalGap() {
        return additionalGap;
    }

    public void setAdditionalGap(TimeDuration additionalGap) {
        this.additionalGap = asChild(additionalGap);
    }

    public AbstractTimeseriesProperty getTimeseries() {
        return timeseries;
    }

    public void setTimeseries(AbstractTimeseriesProperty timeseries) {
        this.timeseries = asChild(timeseries);
    }
}
