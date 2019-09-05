package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class QualifiedAreaProperty extends AbstractInlineProperty<QualifiedArea> implements CityGMLObject {

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
