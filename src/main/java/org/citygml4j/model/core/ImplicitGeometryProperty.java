package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class ImplicitGeometryProperty extends FeatureProperty<ImplicitGeometry> implements CityGMLObject {

    public ImplicitGeometryProperty() {
    }

    public ImplicitGeometryProperty(ImplicitGeometry object) {
        super(object);
    }

    public ImplicitGeometryProperty(String href) {
        super(href);
    }

    @Override
    public Class<ImplicitGeometry> getTargetType() {
        return ImplicitGeometry.class;
    }
}
