package org.citygml4j.model.dynamizer;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class TimeseriesComponentProperty extends AbstractInlineProperty<SensorConnection> implements CityGMLObject {

    public TimeseriesComponentProperty() {
    }

    public TimeseriesComponentProperty(SensorConnection object) {
        super(object);
    }

    @Override
    public Class<SensorConnection> getTargetType() {
        return SensorConnection.class;
    }
}
