package org.citygml4j.model.core;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class QualifiedVolumeProperty extends AbstractInlineProperty<QualifiedVolume> implements CityGMLObject {

    public QualifiedVolumeProperty() {
    }

    public QualifiedVolumeProperty(QualifiedVolume object) {
        super(object);
    }

    @Override
    public Class<QualifiedVolume> getTargetType() {
        return QualifiedVolume.class;
    }
}
