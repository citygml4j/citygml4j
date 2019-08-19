package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractProperty;

public class QualifiedAreaProperty extends AbstractProperty<QualifiedArea> implements CityGMLObject {

    public QualifiedAreaProperty() {
    }

    public QualifiedAreaProperty(QualifiedArea object) {
        super(object);
    }

    @Override
    public Class<QualifiedArea> getTargetType() {
        return QualifiedArea.class;
    }
}
