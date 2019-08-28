package org.citygml4j.adapter.xml.construction;

import org.citygml4j.model.construction.AbstractConstructionSurfaceProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractConstructionSurfacePropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractConstructionSurfaceProperty> {

    @Override
    public AbstractConstructionSurfaceProperty createObject(QName name) {
        return new AbstractConstructionSurfaceProperty();
    }
}
