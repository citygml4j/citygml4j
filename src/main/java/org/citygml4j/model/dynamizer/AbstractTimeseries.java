/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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
