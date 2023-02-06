/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.core.model.core.AbstractDynamizer;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.temporal.TimePosition;

public class Dynamizer extends AbstractDynamizer {
    private String attributeRef;
    private TimePosition startTime;
    private TimePosition endTime;
    private AbstractTimeseriesProperty dynamicData;
    private SensorConnectionProperty sensorConnection;

    public Dynamizer() {
    }

    public Dynamizer(String attributeRef) {
        this.attributeRef = attributeRef;
    }

    public String getAttributeRef() {
        return attributeRef;
    }

    public void setAttributeRef(String attributeRef) {
        this.attributeRef = attributeRef;
    }

    public TimePosition getStartTime() {
        return startTime;
    }

    public void setStartTime(TimePosition startTime) {
        this.startTime = asChild(startTime);
    }

    public TimePosition getEndTime() {
        return endTime;
    }

    public void setEndTime(TimePosition endTime) {
        this.endTime = asChild(endTime);
    }

    public AbstractTimeseriesProperty getDynamicData() {
        return dynamicData;
    }

    public void setDynamicData(AbstractTimeseriesProperty dynamicData) {
        this.dynamicData = asChild(dynamicData);
    }

    public SensorConnectionProperty getSensorConnection() {
        return sensorConnection;
    }

    public void setSensorConnection(SensorConnectionProperty sensorConnection) {
        this.sensorConnection = asChild(sensorConnection);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
