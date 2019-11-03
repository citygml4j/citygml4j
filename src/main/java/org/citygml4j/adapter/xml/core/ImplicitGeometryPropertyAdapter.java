package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.ImplicitGeometryProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;

import javax.xml.namespace.QName;

public class ImplicitGeometryPropertyAdapter extends AbstractPropertyAdapter<ImplicitGeometryProperty> {

    @Override
    public ImplicitGeometryProperty createObject(QName name) throws ObjectBuildException {
        return new ImplicitGeometryProperty();
    }
}
