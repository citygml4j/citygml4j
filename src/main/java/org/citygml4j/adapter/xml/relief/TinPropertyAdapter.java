package org.citygml4j.adapter.xml.relief;

import org.citygml4j.model.relief.TinProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.AbstractGeometryPropertyAdapter;

import javax.xml.namespace.QName;

public class TinPropertyAdapter extends AbstractGeometryPropertyAdapter<TinProperty> {

    @Override
    public TinProperty createObject(QName name) throws ObjectBuildException {
        return new TinProperty();
    }
}
