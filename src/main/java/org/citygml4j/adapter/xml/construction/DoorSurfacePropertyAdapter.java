package org.citygml4j.adapter.xml.construction;

import org.citygml4j.model.construction.DoorSurfaceProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class DoorSurfacePropertyAdapter extends AbstractFeaturePropertyAdapter<DoorSurfaceProperty> {

    @Override
    public DoorSurfaceProperty createObject(QName name) {
        return new DoorSurfaceProperty();
    }
}
