package org.citygml4j.model.dynamizer;

import org.xmlobjects.model.ChildList;

import java.util.List;

public class GenericTimeseries extends AbstractAtomicTimeseries {
    private TimeseriesValue valueType;
    private List<TimeValuePairProperty> timeValuePairs;
    private List<ADEPropertyOfGenericTimeseries<?>> adeProperties;

    public GenericTimeseries() {
    }

    public GenericTimeseries(TimeseriesValue valueType, List<TimeValuePairProperty> timeValuePairs) {
        this.valueType = valueType;
        setTimeValuePairs(timeValuePairs);
    }

    public TimeseriesValue getValueType() {
        return valueType;
    }

    public void setValueType(TimeseriesValue valueType) {
        this.valueType = valueType;
    }

    public List<TimeValuePairProperty> getTimeValuePairs() {
        if (timeValuePairs == null)
            timeValuePairs = new ChildList<>(this);

        return timeValuePairs;
    }

    public void setTimeValuePairs(List<TimeValuePairProperty> timeValuePairs) {
        this.timeValuePairs = asChild(timeValuePairs);
    }

    public List<ADEPropertyOfGenericTimeseries<?>> getADEPropertiesOfGenericTimeseries() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfGenericTimeseries(List<ADEPropertyOfGenericTimeseries<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
