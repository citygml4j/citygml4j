package org.citygml4j.model.building;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractProperty;

public class RoomHeightProperty extends AbstractProperty<RoomHeight> implements CityGMLObject {

    public RoomHeightProperty() {
    }

    public RoomHeightProperty(RoomHeight object) {
        super(object);
    }

    public RoomHeightProperty(String href) {
        super(href);
    }

    @Override
    public Class<RoomHeight> getTargetType() {
        return RoomHeight.class;
    }
}
