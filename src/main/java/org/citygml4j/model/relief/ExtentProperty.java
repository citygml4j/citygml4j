package org.citygml4j.model.relief;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.primitives.Polygon;

public class ExtentProperty extends GeometryProperty<Polygon> implements CityGMLObject {

    public ExtentProperty() {
    }

    public ExtentProperty(Polygon object) {
        super(object);
    }

    public ExtentProperty(String href) {
        super(href);
    }

    @Override
    public Class<Polygon> getTargetType() {
        return Polygon.class;
    }
}
