/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.dynamizer;

import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class GenericTimeseries extends AbstractAtomicTimeseries {
    private TimeseriesValue valueType;
    private List<TimeValuePairProperty> timeValuePairs;

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

    public boolean isSetTimeValuePairs() {
        return timeValuePairs != null && !timeValuePairs.isEmpty();
    }

    public void setTimeValuePairs(List<TimeValuePairProperty> timeValuePairs) {
        this.timeValuePairs = asChild(timeValuePairs);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
