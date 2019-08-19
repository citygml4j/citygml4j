package org.citygml4j.model.construction;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class HeightProperty extends AbstractInlineProperty<Height> implements CityGMLObject {

    public HeightProperty() {
    }

    public HeightProperty(Height object) {
        super(object);
    }

    @Override
    public Class<Height> getTargetType() {
        return Height.class;
    }
}
