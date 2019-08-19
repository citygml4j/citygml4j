package org.citygml4j.model.construction;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class ElevationProperty extends AbstractInlineProperty<Elevation> implements CityGMLObject {

    public ElevationProperty() {
    }

    public ElevationProperty(Elevation object) {
        super(object);
    }

    @Override
    public Class<Elevation> getTargetType() {
        return Elevation.class;
    }
}
