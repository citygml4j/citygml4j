package org.citygml4j.adapter.xml.construction;

import org.citygml4j.model.construction.WindowSurfaceProperty;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class WindowSurfacePropertyAdapter extends AbstractFeaturePropertyAdapter<WindowSurfaceProperty> {

    @Override
    public WindowSurfaceProperty createObject(QName name) {
        return new WindowSurfaceProperty();
    }
}
