package org.citygml4j.model.dynamizer;

import org.citygml4j.model.core.AbstractDynamizer;
import org.xmlobjects.gml.model.temporal.TimePosition;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Dynamizer extends AbstractDynamizer {
    private String attributeRef;
    private TimePosition startTime;
    private TimePosition endTime;
    private AbstractTimeseriesProperty dynamicData;
    private SensorConnectionProperty sensorConnection;
    private List<ADEPropertyOfDynamizer<?>> adeProperties;

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

    public List<ADEPropertyOfDynamizer<?>> getADEPropertiesOfDynamizer() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfDynamizer(List<ADEPropertyOfDynamizer<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
