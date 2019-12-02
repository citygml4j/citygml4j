package org.citygml4j.xml.adapter.construction;

import org.citygml4j.model.construction.AbstractFillingSurfaceProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class AbstractFillingSurfacePropertyAdapter extends AbstractFeaturePropertyAdapter<AbstractFillingSurfaceProperty> {

    @Override
    public AbstractFillingSurfaceProperty createObject(QName name) throws ObjectBuildException {
        return new AbstractFillingSurfaceProperty();
    }
}
