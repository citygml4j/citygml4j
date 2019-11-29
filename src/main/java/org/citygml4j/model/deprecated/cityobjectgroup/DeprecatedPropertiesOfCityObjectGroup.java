package org.citygml4j.model.deprecated.cityobjectgroup;

import org.citygml4j.model.deprecated.core.DeprecatedPropertiesOfAbstractCityObject;
import org.xmlobjects.gml.model.geometry.GeometryProperty;

public class DeprecatedPropertiesOfCityObjectGroup extends DeprecatedPropertiesOfAbstractCityObject {
    private GeometryProperty<?> geometry;

    public GeometryProperty<?> getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryProperty<?> geometry) {
        this.geometry = asChild(geometry);
    }
}
