package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.QualifiedVolumeProperty;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class QualifiedVolumePropertyAdapter extends AbstractInlinePropertyAdapter<QualifiedVolumeProperty> {

    @Override
    public QualifiedVolumeProperty createObject(QName name) {
        return new QualifiedVolumeProperty();
    }
}
