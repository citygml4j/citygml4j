package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractProperty;

public class OccupancyProperty extends AbstractProperty<Occupancy> implements CityGMLObject {

    public OccupancyProperty() {
    }

    public OccupancyProperty(Occupancy object) {
        super(object);
    }

    @Override
    public Class<Occupancy> getTargetType() {
        return Occupancy.class;
    }
}
