package org.citygml4j.model.building;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class RoomHeightProperty extends AbstractInlineProperty<RoomHeight> implements CityGMLObject {

    public RoomHeightProperty() {
    }

    public RoomHeightProperty(RoomHeight object) {
        super(object);
    }

    @Override
    public Class<RoomHeight> getTargetType() {
        return RoomHeight.class;
    }
}
