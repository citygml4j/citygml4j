package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractProperty;

public class ImplicitGeometryProperty extends AbstractProperty<ImplicitGeometry> implements CityGMLObject {

    public ImplicitGeometryProperty() {
    }

    public ImplicitGeometryProperty(ImplicitGeometry object) {
        super(object);
    }

    @Override
    public Class<ImplicitGeometry> getTargetType() {
        return ImplicitGeometry.class;
    }
}
