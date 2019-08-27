package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.ImplicitGeometryProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class ImplicitGeometryPropertyAdapter extends AbstractFeaturePropertyAdapter<ImplicitGeometryProperty> {

    @Override
    public ImplicitGeometryProperty createObject(QName name) {
        return new ImplicitGeometryProperty();
    }
}
