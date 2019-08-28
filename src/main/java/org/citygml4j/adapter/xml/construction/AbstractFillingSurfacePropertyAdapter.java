package org.citygml4j.adapter.xml.construction;

import org.citygml4j.model.construction.AbstractFillingSurfaceProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractFillingSurfacePropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractFillingSurfaceProperty> {

    @Override
    public AbstractFillingSurfaceProperty createObject(QName name) {
        return new AbstractFillingSurfaceProperty();
    }
}
