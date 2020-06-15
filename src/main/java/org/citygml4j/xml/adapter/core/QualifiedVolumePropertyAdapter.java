package org.citygml4j.xml.adapter.core;

import org.citygml4j.model.core.QualifiedVolumeProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class QualifiedVolumePropertyAdapter extends AbstractInlinePropertyAdapter<QualifiedVolumeProperty> {

    @Override
    public QualifiedVolumeProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new QualifiedVolumeProperty();
    }
}
