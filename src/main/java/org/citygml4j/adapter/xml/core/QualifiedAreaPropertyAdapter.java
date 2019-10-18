package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.QualifiedAreaProperty;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class QualifiedAreaPropertyAdapter extends AbstractInlinePropertyAdapter<QualifiedAreaProperty> {

    @Override
    public QualifiedAreaProperty createObject(QName name) {
        return new QualifiedAreaProperty();
    }
}