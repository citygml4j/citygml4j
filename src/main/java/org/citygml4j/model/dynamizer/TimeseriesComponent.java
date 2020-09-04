/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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
