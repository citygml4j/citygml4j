package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.ImplicitGeometryProperty;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class ImplicitGeometryPropertyAdapter extends AbstractInlinePropertyAdapter<ImplicitGeometryProperty> {

    @Override
    public ImplicitGeometryProperty createObject(QName name) {
        return new ImplicitGeometryProperty();
    }
}
