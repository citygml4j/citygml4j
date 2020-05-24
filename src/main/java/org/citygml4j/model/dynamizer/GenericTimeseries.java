package org.citygml4j.model.dynamizer;

import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class GenericTimeseries extends AbstractAtomicTimeseries {
    private TimeseriesValue valueType;
    private List<TimeValuePairProperty> timeValuePairs;
    private List<ADEOfGenericTimeseries> adeOfGenericTimeseries;

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

    public List<ADEOfGenericTimeseries> getADEOfGenericTimeseries() {
        if (adeOfGenericTimeseries == null)
            adeOfGenericTimeseries = new ChildList<>(this);

        return adeOfGenericTimeseries;
    }

    public void setADEOfGenericTimeseries(List<ADEOfGenericTimeseries> adeOfGenericTimeseries) {
        this.adeOfGenericTimeseries = asChild(adeOfGenericTimeseries);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
