package org.citygml4j.model.dynamizer;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class TimeValuePairProperty extends AbstractInlineProperty<TimeValuePair> implements CityGMLObject {

    public TimeValuePairProperty() {
    }

    public TimeValuePairProperty(TimeValuePair object) {
        super(object);
    }

    @Override
    public Class<TimeValuePair> getTargetType() {
        return TimeValuePair.class;
    }
}
