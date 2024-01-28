/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
