package org.citygml4j.model.relief;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.primitives.TriangulatedSurface;

public class TinProperty extends GeometryProperty<TriangulatedSurface> implements CityGMLObject {

    public TinProperty() {
    }

    public TinProperty(TriangulatedSurface object) {
        super(object);
    }

    public TinProperty(String href) {
        super(href);
    }

    @Override
    public Class<TriangulatedSurface> getTargetType() {
        return TriangulatedSurface.class;
    }
}
