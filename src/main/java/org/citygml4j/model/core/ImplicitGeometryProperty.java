package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class ImplicitGeometryProperty extends AbstractInlineProperty<ImplicitGeometry> implements CityGMLObject {

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
